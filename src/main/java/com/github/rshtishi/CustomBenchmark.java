package com.github.rshtishi;

public class CustomBenchmark {

    public static void main(String[] args) {

        testSqrt();
        testJavaSqrt();
        testConstant();

    }

    public static void benchamark(int times, Runnable runnable) {
        long start = System.nanoTime();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        for (int i = 0; i < times; i++) {
            runnable.run();
        }
        double end = (System.nanoTime() - start) / 1_000_000d;
        System.out.printf("%s ran %f ops/ms/n", methodName, times / end);
    }

    private static double sqrt(double num) {
        return Math.exp(0.5 * Math.log(num));
    }

    private static double javaSqrt(double num) {
        return Math.sqrt(num);
    }

    private static double constant() {
        return 10d;
    }

    private static void testSqrt() {
        benchamark(1_000_000, () -> sqrt(10));
        System.out.println();
    }

    private static void testJavaSqrt() {
        benchamark(1_000_000, () -> javaSqrt(10));
        System.out.println();
    }

    private static void testConstant() {
        benchamark(1_000_000, () -> constant());
        System.out.println();
    }
}
