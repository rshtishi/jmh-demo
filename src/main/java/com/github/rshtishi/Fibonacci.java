package com.github.rshtishi;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    static int calculate(int n) {
        int fib1 = 1;
        int fib2 = 1;
        int fibonacci = fib1;
        for (int i = 2; i < n; i++) {
            fibonacci = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibonacci;
        }
        return fibonacci;
    }

    static int recursiveCalculate(int n) {
        // Base Case
        if (n <= 1)
            return n;

        // Recursive call
        return recursiveCalculate(n - 1) + recursiveCalculate(n - 2);
    }

    static int memoizationCalculate(int n, Map<Integer,Integer> map){
        if(map==null){
            map = new HashMap<>();
        } else {
            if(map.containsKey(n)){
                return map.get(n);
            }
        }
        // Base Case
        if (n <= 1)
            return n;
        int fibbonaci = memoizationCalculate(n-1,map)+memoizationCalculate(n-2,map);
        map.put(n,fibbonaci);
        return fibbonaci;
    }
}
