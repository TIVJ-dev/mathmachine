package io.github.tivj.mathmachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void init() {
        allClasses.add(Main.class);
        allClasses.add(Circle.class);
        initDone = true;
    }
    private static boolean initDone = false;
    public static void main(String[] args) {
        if (!initDone) init();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression = null;
        try {
            expression = reader.readLine();
        } catch (IOException e) {main(args); return;}
        if (expression.equals("list functions")) {
            listFunctions();
            main(args);
            return;
        }
        expression = expression.replace(" ", "").replace(",",".");
        if (expression.equals("stop") ||expression.equals("quit")) System.exit(0);
        else if (expression.startsWith("pi*")) System.out.println(
                Math.PI * Double.parseDouble(
                        expression.substring("pi*".length())
                )
        );
        else if (expression.contains("#") && expression.contains(";")) invoke(
                expression.substring(0,expression.indexOf("#")),
                expression.substring(expression.indexOf("#")+1,expression.indexOf(";")),
                Double.parseDouble(expression.substring(expression.indexOf(";")+1))
        );

        main(args);
    }

    public static void invoke(String classname, String methodName, double arg) {
        try {
            Class<?> c;
            try {
                c = Class.forName("io.github.tivj.mathmachine."+classname);
            } catch (ClassNotFoundException e) {
                try {
                    c = Class.forName(classname);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Could not find function.");
                    return;
                }
            }
            Object instance = c.newInstance();
            Method m = c.getDeclaredMethod(methodName, double.class);
            m.setAccessible(true);
            Object result = m.invoke(instance, arg);
            if (result != null) System.out.println(result);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("Error invoking fuction.");
        }
    }

    public static HashSet<Class<?>> allClasses = new HashSet<>();
    public static void listFunctions() {
        List<String> methods = new ArrayList<>();
        for (Class<?> c : allClasses) {
            for (Method method : c.getMethods()) {
                StringBuilder stringBuilder = new StringBuilder(c.getCanonicalName().replace("io.github.tivj.mathmachine.","")+"#"+method.getName()+";");

                Class<?>[] args = method.getParameterTypes();
                int index = 0;
                for (Class<?> clazz : args) {
                    stringBuilder.append(clazz.getCanonicalName());
                    index++;
                    if (args.length != index) stringBuilder.append(", ");
                }

                methods.add(stringBuilder.toString());
            }
        }

        //print
        for (String method : methods) {
            System.out.println(method);
        }
    }
}
