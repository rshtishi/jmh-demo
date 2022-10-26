package com.github.rshtishi;

import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
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

    @Benchmark
    public void testMemoizationCalculateFibonacci(){
        Fibonacci.memoizationCalculate(10, new HashMap<>());
    }

}
