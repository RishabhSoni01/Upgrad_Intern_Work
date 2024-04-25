package org.example.Question_3;

class FactorialThread extends Thread {
    private int number;
    private long factorial;

    public FactorialThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        factorial = calculateFactorial(number);
        System.out.println("Factorial of " + number + ": " + factorial);
    }

    private long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}

class FactorsThread extends Thread {
    private int number;

    public FactorsThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.print("Factors of " + number + ": ");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        int number = 10;

        FactorialThread factorialThread = new FactorialThread(number);
        FactorsThread factorsThread = new FactorsThread(number);

        factorialThread.start();
        factorsThread.start();

        try {
            factorialThread.join();
            factorsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}