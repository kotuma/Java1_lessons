package ru.geekbrains.Course1__Lesson.Lesson3;

import java.util.Scanner;

public class cCalc {
    static int linesLength; // длина массива без пустух строк
    static int eBgn;
    static int eEnd;
    public static void main(String[] args) {
        System.out.println("Lesson3. Job 3 (Консольный калькулятор)");
        System.out.println("Введите выражение для расчёта, например, '8 + 150 / ( 4 + 2 ) - 3' (без вложенных скобок)");

        Scanner in = new Scanner(System.in);
        String[] lines = in.nextLine().split(" ");
        linesLength = lines.length;


        if(!isCorrectExpression(lines)){
            System.out.println("Выражение некорректно");
            return;
        }

        float res = Calculate(lines);

        String str = String.format("Результат: %f", res);
        System.out.println(str);

        //res = Integer.parseInt(line[0]);
    }

    private static float Calculate (String[] lines ) {
       int posLBR;
       int posRBR;
       int count = 2;
       float res;
        do {
            posLBR = getLBRPos(lines, 0); // Поиск скобок
            if (posLBR > -1) {
                posRBR = getRBRPos(lines, posLBR + 1);
                if (posRBR > posLBR) { // Расчет выражения в скобках
                    res = CalcSequenceOperations(lines, posLBR + 1, posRBR - 1);

                    lines[posLBR] = Float.toString( res );
                    // Элементы массива смещаются на count позиций влево и вместо рассчитанной приоитетной операции добавляются пустые строки в конец массива
                    MoveElementsToLeft(lines, posLBR + count + 1, count);
                    FillZeroLines(lines, linesLength, count);
                    linesLength -= count;
                    //eEnd -= count;
                }
            }
        } while (posLBR > -1);

        return CalcSequenceOperations(lines, 0, linesLength);
    }

    private static float CalcSimpleOperation (float a, float b, String operation ) {
    // например, "2 + 3" или "5 / 3"
        float res = 0;
        if (!isCorrectOperation(operation)) return res;
        switch (operation) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                if (b != 0) {
                    res = a / b;
                } else System.out.println("Ошибка. Деление на ноль!");
                break;
        }
        return res;
    }

    private static float CalcSequenceOperations (String[] lines, int eBgn, int eEnd) {
        // например, "2 + 3 / 2 - 1" - последовательность операций без скобок
        float res;
        int count = 2;
        // Поиск приоритетных операций и их расчет
        int priorityOperPos;
        do {
            priorityOperPos = GetPriorityOperationPos(lines, eBgn, eEnd);
            if (priorityOperPos > 0) { // позиция приоритетной операции
                lines[priorityOperPos - 1] = Float.toString(
                        CalcSimpleOperation(
                                GetFloat(lines[priorityOperPos - 1]),
                                GetFloat(lines[priorityOperPos + 1]),
                                lines[priorityOperPos]));
                // Элементы массива смещаются на 2 позиции влево и вместо рассчитанной приоитетной операции добавляются пустые строки в конец массива
                MoveElementsToLeft(lines, priorityOperPos + count, count);
                FillZeroLines(lines, eEnd, count);
                linesLength -= count;
                eEnd -= count;
            }

        } while (priorityOperPos > 0);

        // Расчет значения выражения не содержащего приоритетных операций (например, 2 + 3 - 4,5 + 0)
        while (eEnd > eBgn + 1) {
            if (isCorrectOperation(lines[eBgn + 1])) {
                res = CalcSimpleOperation(GetFloat(lines[eBgn]), GetFloat(lines[eBgn + 2]), lines[eBgn + 1]);
                lines[eBgn] = Float.toString( res );
                // Элементы массива смещаются на 2 позиции влево и вместо рассчитанной приоитетной операции добавляются пустые строки в конец массива
                MoveElementsToLeft(lines, eBgn + 3, count);
                FillZeroLines(lines, eEnd, count);
                linesLength -= count;
                eEnd -= count;
            }
        }
        return GetFloat(lines[eBgn]); // в последовательности операций были только приоритетные

    }

    private static boolean isCorrectExpression(String[] lines) {
        boolean res = true;
        if (lines.length < 3) res = false;
        // Реализовать дополнительные виды проверки выражения (наличие пар скобок, последовательность и числа)

        return res;
    }

    private static boolean isCorrectOperation(String str){
        boolean res = false;
        if (str == null) return false;
        switch (str) {
            case "+":
            case "-":
            case "*":
            case "/":
                res = true;
        }
        if (!res) System.out.println(String.format("Ошибка. Не корректная операция <%s>!", str));
        return res;
    }

    private static boolean isCorrectFloat(String str){
        if (str == null && str.length() < 1) return false;

        try {
            Float.parseFloat(str);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static float GetFloat(String str) {
        if (isCorrectFloat(str)) {
            return Float.parseFloat(str);
        } else {
            System.out.println(String.format("Ошибка. Не корректное значение <%s>!", str));
            return 0;
        }
    }
    private static boolean isPriorityOperation(String str){
        boolean res = false;
        if (str.length() == 1) {
            switch (str) {
                case "*":
                case "/":
                    res = true;
            }
        }
        return res;
    }

    private static int GetPriorityOperationPos(String[] lines, int eBgn, int eEnd) {
        int res = 0;
        for (int i = eBgn + 1; i < eEnd; i += 2) {
            if (isCorrectOperation(lines[i]) && isPriorityOperation(lines[i])) {
                res = i;
                break;
            }

        }
        return res;
    }
    private static void MoveElementsToLeft(String[] lines, int bgnPos, int cnt){
        for (int i = bgnPos; i < lines.length; i++) {
            if (i - cnt >= 0) {
                lines[i - cnt] = lines[i];

            }
        }
    }

    private static void FillZeroLines(String[] lines, int bgnPos, int count){
        for (int i = bgnPos; i < count; i++) {
            if (i >= 0 && i < lines.length) lines[i] = "";
        }
    }

    private static int getLBRPos(String[] lines, int bgnPost) { // Поиск левой скобки
        int res = -1;
        for (int i = bgnPost; i < linesLength; i++) {
            if (lines[i].equals("(")) {
                res = i;
                break;
            }
        }
        return res;
    }

    private static int getRBRPos(String[] lines, int bgnPost) { // Поиск правой скобки
        int res = -1;
        for (int i = bgnPost; i < linesLength; i++) {
            if (lines[i].equals(")")) {
                res = i;
                break;
            }
        }
        return res;
    }
}
