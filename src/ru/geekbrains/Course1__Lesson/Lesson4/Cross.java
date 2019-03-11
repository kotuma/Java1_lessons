package ru.geekbrains.Course1__Lesson.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Cross {
    private static int SIZE_X = 5;
    private static int SIZE_Y = SIZE_X;
    private static char [][] field = new char[SIZE_Y][SIZE_X];
    private static int [] stateMap = new int[SIZE_Y + SIZE_X + 2];
    private static int [] stateIDs = new int[SIZE_Y + SIZE_X + 2];
    private static int WIN_COUNT = 4;
    private static char PLAYER_DOT = 'X';
    private static char AI_DOT = 'O';
    private static char EMPTY_DOT = '.';
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Lesson4. CrossGame\n");
        initField();
        printField();
        while (true) {
            playerStep();
            printField();
            if (checkFinishGame(PLAYER_DOT)) {
                break;
            }

            aiStep();
            printField();
            if (checkFinishGame(AI_DOT)) {
                break;
            }
        }
    }

    private static boolean checkFinishGame(char dot) {
        if (isDraw()) { // Проверка на ничью
            System.out.println("- Ничья !");
            return true;
        }

        if (isWin(dot)) { // Проверка на выигрыш
            if (dot == AI_DOT) {
                System.out.println("- Победил компьютер !");
            } else {
                System.out.println("- Вы выиграли !!!");
            }
            return true;
        } else {
            return false;
        }
    }

    private static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j <SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    //Отрисовка поля игры
    private static void printField() {
        String str;

        System.out.print("    ");
        // нумерация колонок
        for (int j = 0; j < SIZE_X; j++) {
            System.out.printf(" %s", j + 1);
        }

        System.out.println();
        printHorizLine();
        for (int i = 0; i < SIZE_Y; i++) {
            str = String.format("%s   |", i+1); // Нумерация строк
            System.out.print(str);
            for (int j = 0; j <SIZE_X; j++) {
                System.out.print(field[i][j]);
                System.out.print('|');
            }
            System.out.println();
        }
        printHorizLine();
    }

    // Отрисовка горизонтальной линии
    private static void printHorizLine() {
        System.out.print("    ");
        for (int j = 0; j <= SIZE_X * 2 ; j++) {
            System.out.print('-');
        }
        System.out.println();
    }

    // Ход игрока
    private static void setSymbol(int x, int y, char symbol) {
        field[y][x] = symbol;
    }

    // Проверка на заполненность ячейки
    private static boolean isValidCell(int x, int y) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return (field[y][x] == EMPTY_DOT);
    }

    // Ход игрока
    private static void playerStep() {
        int x;
        int y;
        do {
            System.out.println("Сделайте Ваш ход. Введите номер стролбца и строки (через пробел):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isValidCell(x, y));
        setSymbol(x, y, PLAYER_DOT);
    }

    // Ход AI
    private static void aiStep() {
        int x;
        int y;
        do {
            x = random.nextInt(SIZE_X);
            y = random.nextInt(SIZE_Y);
        } while (!isValidCell(x, y));
        setSymbol(x, y, AI_DOT);
    }

    // Проверка на ничью (все клетки заполнены)
    private static boolean isDraw() {
        boolean res = true; //
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j <SIZE_X; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    res = false; // не ничья
                    break;
                }
            }
        }
        return res;
    }

    // Проверка на выигрыш
    private static boolean isWin(char dot) {
        fillStateMapFor(dot);
        for (int i = 0; i < stateMap.length; i++) {
            if (stateMap[i] >= WIN_COUNT) {
               return true;
            }
        }
        return false;
    }

    // Заполнение карты-статуса
    private static void fillStateMapFor(char dot) {
        int id = -1;
        int cnt = 0;
        // Расчет массива значений для строк
        for (int i = 0; i < SIZE_Y; i++) {
            id++;
            cnt = 0;
            for (int j = 0; j <SIZE_X; j++) {
                if (field[i][j] == dot) {
                    cnt++;
                } else if (field[i][j] != EMPTY_DOT) {
                    cnt = 0; // показатель для данной линии аннулируется при наличии вражеского dot
                    break;
                }

            }
            stateMap[id] = cnt;
            stateIDs[id] = id;
        }

        // Расчет массива значений для колонок
        for (int j = 0; j <SIZE_X; j++) {
            id++;
            cnt = 0;
            for (int i = 0; i < SIZE_Y; i++) {
                if (field[i][j] == dot) {
                    cnt++;
                } else if (field[i][j] != EMPTY_DOT) {
                cnt = 0; // показатель для данной линии аннулируется при наличии вражеского dot
                break;
            }
            }
            stateMap[id] = cnt;
            stateIDs[id] = id;
        }

        // Расчет массива значений для левой диагонали
        id++;
        cnt = 0;
        stateMap[id] = cnt;
        stateIDs[id] = id;
        // ToDo - сделать подсчет

        // Расчет массива значений для правой диагонали
        id++;
        cnt = 0;
        stateMap[id] = cnt;
        stateIDs[id] = id;
        // ToDo - сделать подсчет
    }



}
