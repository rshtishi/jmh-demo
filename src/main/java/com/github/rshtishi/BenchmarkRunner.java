package com.github.rshtishi;

import com.github.rshtishi.benchmark.CanSumBenchmark;
import com.github.rshtishi.benchmark.FibonacciBenchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;

public class BenchmarkRunner {

    public static void main(String[] args) throws IOException, RunnerException {
        //org.openjdk.jmh.Main.main(args);
        Options options = new OptionsBuilder().include(CanSumBenchmark.class.getSimpleName())
                .build();
        new Runner(options).run();
    }

}
