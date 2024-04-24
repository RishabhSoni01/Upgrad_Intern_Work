package org.example.Question3;
import java.util.Arrays;

public class ArrayUtils {

    public static <T> void exchangeElements(T[] array, int index1, int index2) {
        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            throw new IllegalArgumentException("Invalid indices");
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        exchangeElements(intArray, 0, 4);
        System.out.println(Arrays.toString(intArray));

        String[] stringArray = {"apple", "banana", "orange", "grape"};
        exchangeElements(stringArray, 1, 3);
        System.out.println(Arrays.toString(stringArray));
    }
}