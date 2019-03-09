package ru.geekbrains.Course1__Lesson.Lesson3;

import java.util.Random;
import java.util.Scanner;

public class GuessingWord{
    public static void main(String[] args) {
        System.out.println("Lesson3. Job 2 (Игра - угадай слово)");
        boolean finishedGame;
        Scanner sc = new Scanner(System.in);
        do {
            guessingOneWord(sc);
            System.out.println("Вы хотите повторить игру? Если да - введите 1. Для завершения - любое другое число");
            finishedGame = (Integer.parseInt(sc.nextLine()) != 1);
        } while (!finishedGame);
        sc.close();
    }

    private static void guessingOneWord(Scanner sc) {
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        Integer selectedIndex = random.nextInt(words.length);
        System.out.println("Загадано слово: " + words[selectedIndex]);
        System.out.println("Введите свой ответ:");
        String answer;
        boolean equal;
        do {
            answer = (sc.nextLine()).toLowerCase();
            equal = answer.equals(words[selectedIndex]);
            if (!equal) {
                System.out.println("В загаданном слове присутствуют следующие открытые буквы:");
                System.out.println(GetHint(words[selectedIndex], answer));
                System.out.println("Пробуйте угадать снова...");
            }
        } while (!equal);
        System.out.println("Вы угадали!!! \n");
    }

    private static String GetHint(String selectedWord, String answer) {
        StringBuilder res = new StringBuilder();
        int MaxLength = 15;
        for (int i = 0; i < MaxLength; i++) {
           if (i < selectedWord.length() && i < answer.length() && selectedWord.charAt(i) == answer.charAt(i)) {
               res.append(answer.charAt(i));
            } else {
                res.append('#');
            }
        }
        return res.toString();
    }

}
