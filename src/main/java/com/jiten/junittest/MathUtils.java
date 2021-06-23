package com.jiten.junittest;

import java.util.Objects;

public class MathUtils {
    public int add(int value1, int value2) {
        return value1 + value2;
    }
    public double computeCircleArea(double radius){
        return Math.PI * radius * radius;
    }

    public int divide(int value1, int value2) {
        return value1 / value2;
    }

    public int multiply(int value1, int value2) {
        return value1 * value2;
    }
}