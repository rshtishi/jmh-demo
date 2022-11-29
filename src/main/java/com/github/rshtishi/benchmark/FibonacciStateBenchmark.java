package com.github.rshtishi.benchmark;

import com.github.rshtishi.algorythms.Fibonacci;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class FibonacciStateBenchmark {

    @State(Scope.Benchmark)
    public static class FibonacciState {
        @Param({"5", "6"})
        public int value;
    }

    @Benchmark
    public void testCalculateFibonaccix(FibonacciState state, Blackhole blackhole) {
        blackhole.consume(Fibonacci.calculate(state.value));
    }

}
