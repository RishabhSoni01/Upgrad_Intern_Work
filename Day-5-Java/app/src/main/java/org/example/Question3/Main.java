package org.example.Question3;
import org.example.Question3.*;

public class Main {
    public static void main(String[] args) {
        int number = 25;
        FactorialCalculator factorialCalculator = new FactorialCalculator(number);
        FactorsCalculator factorsCalculator = new FactorsCalculator(number);

        Thread factorialThread = new Thread(factorialCalculator);
        Thread factorsThread = new Thread(factorsCalculator);

        factorialThread.start();
        factorsThread.start();
        try {
            factorialThread.join();
            factorsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished last.");
    }
}
class FactorialCalculator implements Runnable {
    private final int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
class FactorsCalculator implements Runnable {
    private final int number;

    public FactorsCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.print("Factors of " + number + " are: ");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

