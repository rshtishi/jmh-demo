package com.github.rshtishi;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class FibonacciBenchmark {

    @Benchmark
    public void testCalculateFibonacci(){
        Fibonacci.calculate(10);
    }

    @Benchmark
    public void testRecursiveCalculateFibonacci() {
        Fibonacci.recursiveCalculate(10);
    }

}
