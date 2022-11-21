package com.github.rshtishi;

public class CustomBenchmark {

    public static void main(String[] args) {

        testSqrt(num);
        testJavaSqrt(num);
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

    static double num = 10;

    private static double testSqrt(double num) {
        double[] placeholder = new double[1];
        benchamark(1_000_000, () -> placeholder[0] = sqrt(num));
        System.out.println();
        return placeholder[0];
    }

    private static double testJavaSqrt(double num) {
        double[] placeholder = new double[1];
        benchamark(1_000_000, () -> placeholder[0] = javaSqrt(num));
        System.out.println();
        return placeholder[0];
    }

    private static void testConstant() {
        benchamark(1_000_000, () -> constant());
        System.out.println();
    }
}
