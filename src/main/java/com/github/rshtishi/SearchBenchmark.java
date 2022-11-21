package com.github.rshtishi;

import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class SearchBenchmark {

    @State(Scope.Benchmark)
    public static class SearchState {
        @Param({"1", "10", "100"})
        public int parameter;
        public List<Integer> list;

        @Setup(Level.Trial)
        public void setup() {
            list = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        }

        @TearDown
        public void tearDown(){
            list = null;
        }
    }

    @Benchmark
    public void streamSearchBenchamrk(SearchState searchState){
        searchState.list.stream().anyMatch( i -> i==searchState.parameter);
    }
}
