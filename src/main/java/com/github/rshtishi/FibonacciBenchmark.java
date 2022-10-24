package com.github.rshtishi;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class FibonacciBenchmark {

    @Benchmark
    public void testImperativeSum() {
        Fibonacci.calculate(10);
    }

}
