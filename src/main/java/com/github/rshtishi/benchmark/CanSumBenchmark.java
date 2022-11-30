package com.github.rshtishi.benchmark;

import com.github.rshtishi.algorythms.CanSum;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2, warmups = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 2)
@Measurement(iterations = 3)
public class CanSumBenchmark {

    @State(Scope.Benchmark)
    public static class CanSumState {
        @Param({"7","120"})
        int targetSum;
        int[] numbers;

        @Setup(Level.Trial)
        public void setup(){
            numbers = new Random().ints(10,1,10).toArray();
        }

        @TearDown(Level.Trial)
        public void tearDown(){
            numbers = null;
        }
    }

    @Benchmark
    public void testCalculateCanSum(Blackhole blackhole, CanSumState state){
        blackhole.consume(CanSum.calculate(state.targetSum, state.numbers));
    }
}
