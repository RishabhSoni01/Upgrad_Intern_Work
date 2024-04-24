package org.example.answer3;
import java.util.Arrays;

public class ArraySwap {

        public static <T> void swap(T[] array, int index1, int index2) {
            T temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }


        public static void main(String[] args) {
            Integer[] intArray = {1, 2, 3, 4, 5};
            swap(intArray, 1, 3);
            System.out.println(Arrays.toString(intArray));

            String[] stringArray = {"apple", "banana", "mango"};
            swap(stringArray, 0, 2);
            System.out.println(Arrays.toString(stringArray));
        }
}
