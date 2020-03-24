package io.github.tivj.mathmachine;

public class Circle {
    public void circumferenceFromRadius(double radius) {
        System.out.println("π * ("+radius+" * 2)");
        double diameter = radius * 2;
        System.out.println("= π * "+diameter);
        System.out.println("= "+ Math.PI * diameter);
    }
    public void circumferenceFromDiameter(double diameter) {
        System.out.println("π * "+diameter);
        System.out.println("= "+ Math.PI * diameter);
    }
    public void radiusFromCircumference(double circumference) {
        double calc = circumference;
        System.out.println(calc+" / π"+" / 2");
        calc = calc/ Math.PI;
        System.out.println("= "+calc+" / 2");
        calc = calc / 2;
        System.out.println("= "+calc);
    }
    public void diameterFromCircumference(double circumference) {
        System.out.println(circumference+" / π");
        System.out.println("= "+circumference / Math.PI);
    }
    public void areaFromRadius(double radius) {
        double calc = radius;
        System.out.println("π * "+calc+"²");
        calc = (Math.PI * calc);
        System.out.println("= "+ calc +"²");
        calc = calc*calc;
        System.out.println("= "+calc);
    }
    public void areaFromDiameter(double diameter) {
        double calc = diameter;
        System.out.println("π * ("+calc+" / 2)²");
        calc = calc / 2;
        System.out.println("= π * "+calc+"²");
        calc = calc*calc;
        System.out.println("= "+ calc +"²");
        calc = (Math.PI * calc);
        System.out.println("= "+calc);
    }
}