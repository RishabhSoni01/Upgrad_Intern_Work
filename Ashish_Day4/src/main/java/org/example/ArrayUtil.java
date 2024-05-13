package org.example;

import java.util.Random;

public class ArrayUtil {

    public static <T> void shuffle(T[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        // Example usage
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"apple", "banana", "cherry", "date"};

        // Shuffle elements in integer array
        shuffle(intArray);
        System.out.println("After shuffling elements in integer array:");
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Shuffle elements in string array
        shuffle(strArray);
        System.out.println("After shuffling elements in string array:");
        for (String str : strArray) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}