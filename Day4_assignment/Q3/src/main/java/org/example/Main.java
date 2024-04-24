package org.example;


import java.util.Arrays;

public class Main {
    public static <T> void exchangeElements(T[] array, int index1, int index2) {
        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        // Example usage with an Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        exchangeElements(intArray, 1, 3);
        System.out.println(Arrays.toString(intArray)); // Output: [1, 4, 3, 2, 5]

        // Example usage with a String array
        String[] stringArray = {"Apple", "Banana", "Orange", "Mango"};
        exchangeElements(stringArray, 0, 2);
        System.out.println(Arrays.toString(stringArray)); // Output: [Orange, Banana, Apple, Mango]
    }
}
