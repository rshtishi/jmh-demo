# jmh-demo

JMH is short for Java Microbenchmark Harness. It is a toolkit developed by the same people who implement the JVM that helps you implement Java microbenchmarks correctly. 


Why do I need to learn a difficult framework when I can do the benchmark as I always have done by calculating timestamps? :confused: E.g:

```
public class CustomBenchmark {

    public static void main(String[] args) {

        testSqrt();
        testJavaSqrt();

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
    
    private static void testSqrt() {
        benchamark(1_000_000, () -> sqrt(10));
        System.out.println();
    }

    private static void testJavaSqrt() {
        benchamark(1_000_000, () -> javaSqrt(10));
        System.out.println();
    }
}    
    
```
