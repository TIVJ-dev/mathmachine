package io.github.tivj.mathmachine;

public class Circle {
    public double circumferenceFromRadius(double radius) {
        return circumferenceFromDiameter(radius * 2);
    }
    public double circumferenceFromDiameter(double diameter) {
        return Math.PI * diameter;
    }
    public double radiusFromCircumference(double circumference) {
        return diameterFromCircumference(circumference) * 2;
    }
    public double diameterFromCircumference(double circumference) {
        return circumference / Math.PI;
    }

    public static class StepByStep {
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
            System.out.println("π / "+circumference+" * 2");
            System.out.println("= "+circumference+" * 2");
            System.out.println("= "+circumference * 2);
        }
        public void diameterFromCircumference(double circumference) {
            System.out.println(circumference+" / π");
            System.out.println("= "+circumference / Math.PI);
        }
    }
}