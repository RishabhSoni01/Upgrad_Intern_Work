package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

class FactorialThread extends Thread {
    private int number;
    private long result;

    public FactorialThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        result = calculateFactorial(number);
    }

    private long calculateFactorial(int number) {
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public long getResult() {
        return result;
    }
}

class FactorsThread extends Thread {
    private int number;
    private String result;

    public FactorsThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        result = calculateFactors(number);
    }

    private String calculateFactors(int number) {
        StringBuilder factors = new StringBuilder();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.append(i).append(" ");
            }
        }
        return factors.toString();
    }

    public String getResult() {
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int number = scanner.nextInt();

        FactorialThread factorialThread = new FactorialThread(number);
        FactorsThread factorsThread = new FactorsThread(number);

        factorialThread.start();
        factorsThread.start();

        factorialThread.join();
        factorsThread.join();

        System.out.println("Factorial: " + factorialThread.getResult());
        System.out.println("Factors: " + factorsThread.getResult());
    }
}