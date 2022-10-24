package com.github.rshtishi;

public class Fibonacci {

    static int calculate(int n) {
        // Base Case
        if (n <= 1)
            return n;

        // Recursive call
        return calculate(n - 1) + calculate(n - 2);
    }
}
