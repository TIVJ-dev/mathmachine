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
}
