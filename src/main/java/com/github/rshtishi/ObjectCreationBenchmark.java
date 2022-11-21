package com.github.rshtishi;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 2,warmups = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class ObjectCreationBenchmark {

    @Benchmark
    public void testDoNothing() {
    }

    @Benchmark
    public void testObjectCreation(){
        new Object();
    }

    @Benchmark
    public Object testObjectCreationThatReturnsObject(){
        return new Object();
    }

    @Benchmark
    public void testObjectCreationWithBlackHole(Blackhole blackHole){
        blackHole.consume(new Object());
    }


}
