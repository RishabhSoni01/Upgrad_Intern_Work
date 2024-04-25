package org.example.answer3;

public class Main {

    public static void main(String[] args) {
        int input = 10;

        Thread1 factorial = new Thread1(input);
        factorial.start();

        Thread2 factor = new Thread2(input);
        factor.start();

        try {
            factorial.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            factor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("I am the main thread");
    }
}

