package ru.geekbrains.Course1__Lesson.Lesson1;

public class Lesson_1 {

    public static void main(String[] args) {
        boolean bool = false;
        char ch = 'f';
        byte value_byte = 127;
        short value_short = 500;
        int value_int = 100000000;
        long value_long = 5555555555555L;
        float value_float = 0.001f;
        double value_double = 777777.1111101;

        System.out.println("Результат расчёта выражения: " +
                String.format ("%.3f", calcEquation(3, 2, 1, 3.14)));

        System.out.println("Результат сравнения лежит в интервале от 10 до 20: " +
                checkSum(19, 7));

        outIsPositiveValue(-1);
        outIsPositiveValue(0);

        System.out.println("Передано отрицательное число: " +
                isNegativeValue(-1));
        System.out.println("Передано отрицательное число: " +
                isNegativeValue(5));

        helloOutWith("Вася");

        isLeapYearOut(2000);
        isLeapYearOut(2019);
        isLeapYearOut(2020);
        isLeapYearOut(2100);
        isLeapYearOut(2200);
        isLeapYearOut(2300);
        isLeapYearOut(2400);
        isLeapYearOut(2401);
    }

    private static double calcEquation(int a, int b, int c, double d) {
        if (d != 0) {
            return a * (b + (c / d));
        } else {
            return a * b;
        }
    }

    private static boolean checkSum(int a, int b) { return ((a + b) >= 10 && (a + b) <= 20); }

    private static void outIsPositiveValue(int a) {
        System.out.println("Передано положительное число: " +
                (a >=0 ));
    }

    private static boolean isNegativeValue(int a) { return a < 0; }

    private static void helloOutWith(String name) {
        System.out.println("Привет, " + name + "!");
    }

    private static void isLeapYearOut(int year) {
        boolean isLeapYear = false;
        if (year % 4 == 0) { //Каждый 4-й год является високосным
            isLeapYear = true;
            if (year % 100 == 0) {
                isLeapYear = false; // кроме каждого 100-го
                if (year % 400 == 0) isLeapYear = true; // при этом, каждый 400-й – високосный
            }
        }

        System.out.println("Год: " + year + " - " + (isLeapYear ? "високосный": "не високосный"));
    }
}