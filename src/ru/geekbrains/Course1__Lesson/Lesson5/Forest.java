package ru.geekbrains.Course1__Lesson.Lesson5;

import java.util.Arrays;

public class Forest {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 20;
    private int[] iForest;


    public Forest() {
        iForest = new int[20];
    }

    private void clearState() {
        for (int i = 0; i < iForest.length; i++) {
            iForest[i] = 0;
        }
    }

    public void loadFromString(String str){
        String[] strings = str.split(" ");
        clearState();
        for (String elem: strings) {
            int i = Integer.parseInt(elem);
            if (i >= MIN_VALUE && i <= MAX_VALUE) {
                iForest[i-1]++;
            }

        }
    }

    @Override
    public String toString() {
        return "Результат подсчета деревьев в лесу: " + Arrays.toString(iForest);
    }
}
