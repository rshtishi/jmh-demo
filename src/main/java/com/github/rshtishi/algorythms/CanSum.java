package com.github.rshtishi.algorythms;

public class CanSum {

    public static boolean calculate(int targetSum, int[] numbers) {
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for(int num : numbers){
            int remainder = targetSum -num;
            if(calculate(remainder,numbers)==true){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 3, 2, 5};
        int targetSum = 7;

        System.out.println(calculate(targetSum,numbers));
    }
}
