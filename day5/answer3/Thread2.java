package org.example.answer3;

import java.util.ArrayList;

public class Thread2 extends Thread {

    private int number;

    public Thread2(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int x = 2;
        ArrayList<Integer> list = new ArrayList<>();

        // Adding elements to the ArrayList
        while (number > 1) {
            while (number % x == 0) {
                list.add(x);
                number = number / x;
            }
            x++;
        }
        System.out.println("Factor: " + list);
    }
}
