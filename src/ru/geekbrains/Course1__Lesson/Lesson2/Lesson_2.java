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
        System.out.println("Lesson2. Job 5 ");
        System.out.println("Lesson2. Job 6 ");
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
}
