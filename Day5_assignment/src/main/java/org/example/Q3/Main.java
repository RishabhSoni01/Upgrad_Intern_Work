package org.example.Q3;

import java.util.ArrayList;
import java.util.List;

class FactorialTask implements Runnable {
    private final int number;
    private long factorial;

    public FactorialTask(int number) {
        this.number = number;
    }

    public long getFactorial() {
        return factorial;
    }


    public void run() {
        factorial = calculateFactorial(number);
    }

    private long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

class FactorsTask implements Runnable {
    private final int number;
    private final List<Integer> factors = new ArrayList<>();

    public FactorsTask(int number) {
        this.number = number;
    }

    public List<Integer> getFactors() {
        return factors;
    }


    public void run() {
        calculateFactors(number);
    }

    private void calculateFactors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int number = 10;

        FactorialTask factorialTask = new FactorialTask(number);
        FactorsTask factorsTask = new FactorsTask(number);

        Thread factorialThread = new Thread(factorialTask);
        Thread factorsThread = new Thread(factorsTask);

        factorialThread.start();
        factorsThread.start();

        try {
            factorialThread.join();
            factorsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long factorial = factorialTask.getFactorial();
        List<Integer> factors = factorsTask.getFactors();

        System.out.println("Factorial of " + number + ": " + factorial);
        System.out.println("Factors of " + number + ": " + factors);

        System.out.println("Main thread finished.");
    }
}
