package com.github.rshtishi.benchmark;

import com.github.rshtishi.algorythms.Fibonacci;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class FibonacciBenchmark {

    @State(Scope.Benchmark)
    public static class FibonacciState {
        @Param({"15"})
        public int value;
    }

    @Benchmark
    public void testCalculateFibonacci(FibonacciState state, Blackhole blackhole) {
        int result = Fibonacci.calculate(state.value);
        blackhole.consume(result);
    }

    @Benchmark
    public void testRecursiveCalculateFibonacci(FibonacciState state, Blackhole blackhole) {
        int result = Fibonacci.recursiveCalculate(state.value);
        blackhole.consume(result);
    }

    @Benchmark
    public void testMemoizationCalculateFibonacci(FibonacciState state, Blackhole blackhole) {
        int result = Fibonacci.memoizationCalculate(state.value, new HashMap<>());
        blackhole.consume(result);
    }

    @Benchmark
    public void testTabulationCalculateFibonacci(FibonacciState state, Blackhole blackHole) {
        int result = Fibonacci.tabulationCalculate(state.value);
        blackHole.consume(result);
    }

}
