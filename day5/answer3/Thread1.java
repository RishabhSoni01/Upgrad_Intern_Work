package org.example.answer3;

public class Thread1 extends Thread {

    private int number;

    public Thread1(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int result = 1;
        while (number > 1) {
            result = result * number;
            number--; // decrementing the number in each iteration
        }
        System.out.println("Factorial: " + result);
    }
}
