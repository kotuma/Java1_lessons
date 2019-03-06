package ru.geekbrains.Course1__Lesson.Lesson2;

import java.util.Arrays;

public class Lesson_2 {
    public static void main(String[] args) {
        System.out.println("Lesson2. Job 1 ");
        fillArrayAndInvert();

        System.out.println("Lesson2. Job 2 ");
        createArrayAndFillPlus3();

        System.out.println("Lesson2. Job 3 ");
        modifyArrayValuesLessThenSix();

        System.out.println("Lesson2. Job 4 ");
        fill_2D_ArrayByDiags();

        System.out.println("Lesson2. Job 5 ");
        fillArrayAndGetMinMax();

        System.out.println("Lesson2. Job 6 ");
        int[] arr1 = { 2, 2, 2, 1, 2, 2, 10, 1 }; // Balanced array
        int[] arr2 = { 1, 1, 1, 2, 1 }; // Balanced array
        int[] arr3 = { 8, 9, 4 }; // Disbalanced array
        System.out.println(checkBalance(arr1));
        System.out.println(checkBalance(arr2));
        System.out.println(checkBalance(arr3));

        System.out.println("Lesson2. Job 7 ");
    }
    private static void fillArrayAndInvert() {
        int[] iArr = { 0, 1, 0, 0, 1, 0, 1, 1 };
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = (iArr[i] == 0 ? 1: 0);
        }
        System.out.println(Arrays.toString(iArr));
    }
    private static void createArrayAndFillPlus3() {
        int[] iArr = new int[8];
        for (int i = 1; i < iArr.length; i++) {
            iArr[i] = iArr[i - 1] + 3;
        }
        System.out.println(Arrays.toString(iArr));
    }
    private static void modifyArrayValuesLessThenSix() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] < 6? arr[i] * 2: arr[i]);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void fill_2D_ArrayByDiags() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ( (i == j)  || (j == arr[i].length - 1 - i) ) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static void fillArrayAndGetMinMax() {
        int[] arr = { 7, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 4 };
        int min = arr[0]; int max = arr[0];
        for (int val: arr) {
            if (val < min) min = val;
            if (val > max) max = val;
        }
        System.out.println("Min/max values: " + min + " / " + max);
    }

    private static boolean checkBalance(int[] iArr) {
        return false
    }
}
