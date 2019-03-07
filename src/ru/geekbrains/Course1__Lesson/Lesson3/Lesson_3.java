package ru.geekbrains.Course1__Lesson.Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson_3 {
    public static void main(String[] args) {
        System.out.println("Lesson3. Job 1 ");
        guessingNumberGame();


    }

    private static void guessingNumberGame(){
        boolean startGame = true;
        Scanner sc = new Scanner(System.in);
        while (startGame) {
            guessingNumber();
            System.out.println("Вы хотите повторить? Если да - введите 1. Для завершения - любое другое число");
            startGame = (sc.nextInt() == 1);
        }
    }

    private static void guessingNumber() {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int value = rand.nextInt(10);
        System.out.println("\nУгадайте число в диапазоне от 0 до 9. У Вас три попытки.");
        System.out.println("   - Введите число");
        for (int i = 0; i < 3; i++) {
            int n = sc.nextInt();
            if (n == value) {
                System.out.println("   - Ура! Вы угадали!");
                return;
            } else {
                if (n < value) {
                    System.out.println("   - Загаданное число больше");
                } else System.out.println("   - Загаданное число меньше");
            }

        }
    }
}
