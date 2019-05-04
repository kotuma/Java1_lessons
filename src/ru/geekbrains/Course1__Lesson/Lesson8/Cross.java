package ru.geekbrains.Course1__Lesson.Lesson8;

import java.util.Random;
import java.util.Scanner;

// Класс реализующий логику игры крестики-нолики
public class Cross {
    // параметры игрового поля
    private int sizeY = 5; //размер поля по вертикали
    private int sizeX = 5; //размер поля по горизонтали
    private int sizeWin = 4; //кол-во заполненных подряд полей для победы
    private int gameMode = 0; //режим игры ()
    private char[][] fieldg;
    private String state = "";
    // игровые элементы
    public static final char player_DOT = 'X';
    public static final char Ai_DOT = 'O';
    public static final char EMPTY_DOT = '.';
    private char currentPlayerDot;

    // обявление классов ввода и случайного числа для игры
    static Scanner scr = new Scanner(System.in);
    static Random rnd = new Random();

    public Cross(int sizeX, int sizeY, int winSeriesSize, int gameMode){
        setSizeX(sizeX);
        setSizeY(sizeY);
        setSizeWin(winSeriesSize);
        setGameMode(gameMode);
        setCurrentPlayerDot(Cross.player_DOT);

        emtpyField();
    }

    public char getCurrentPlayerDot() {
        return currentPlayerDot;
    }

    public void setCurrentPlayerDot(char currentPlayerDot) {
        this.currentPlayerDot = currentPlayerDot;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeWin(int sizeWin) {
        this.sizeWin = sizeWin;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    //поле в начале игры
    private void emtpyField () {
        fieldg =  new char [sizeY][sizeX];

        for (int i = 0; i< sizeY; i++) {
            for (int j = 0; j< sizeX; j++) {
                fieldg [i][j] = EMPTY_DOT;
            }
        }
    }

    public String getState() {
        return this.state;
    }

    public char getFieldValue(int x, int y){
        if (x >= 0 && y >= 0 && x < sizeX && y < sizeY) {
            return fieldg [y][x];
        }
        else {
            return EMPTY_DOT;
        }
    }

    // запись хода игрока на поле
    private void dotField (int y, int x, char dot) {
        fieldg [y][x] = dot;
    }
/*
    //Ход человева
    private void playerMove () {
        int x, y;
        do {
            System.out.println("Введите координаты вашего хода в диапозоне от 1 до " + sizeY);
            System.out.print ("Координат по строке ");
            y = scr.nextInt()-1;
            System.out.print ("Координат по столбцу ");
            x = scr.nextInt()-1;

        } while (!checkMove(y,x));
        dotField(y, x, player_DOT);
    }
*/
    public void setState(String state) {
        this.state = state;
    }

    // Возвращает наличие статуса выигрыша или ничьи в игре
    private boolean isFinishGameState(char playerChar) {
        if (checkWin(playerChar)) {
            if (gameMode == Map.MODE_H_V_A) {
                if (playerChar == player_DOT) {
                    setState("Congratulations! You are winner !!!");
                } else {
                    setState("Winner - AI !");
                }
                return true;
            } else {
                setState("Player [" + playerChar + "] win !");
                return true;
            }
        }

        if (fullField()) {
            setState("Tie. Field is full...");
            return true;
        }
        return false;
    }

    //Ход человева
    public boolean setPlayerMove(int x, int y) {
        if (getState().length() > 0) {
            return true;
        }

        if (checkMove(y, x)) {
            dotField(y, x, getCurrentPlayerDot());
            isFinishGameState(getCurrentPlayerDot());
            if (isFinishGameState(getCurrentPlayerDot()) || gameMode == Map.MODE_H_V_H) {
                changeCurrentPlayerIfNeeded();
                return true;
            }
        }
        else {
            return false;
        }


        if (gameMode == Map.MODE_H_V_A && state.length() == 0) {
            AiMove();
            isFinishGameState(Ai_DOT);
            return true;
        }
        else {
            return false;
        }
    }

    // Ход компьютера
    private void AiMove() {
        int x, y;
        //блокировка ходов человека
        for (int v = 0; v< sizeY; v++) {
            for (int h = 0; h < sizeX; h++) {
                //анализ наличие поля для проверки
                if (h+ sizeWin <= sizeX) {                           //по горизонтали
                    if (checkLineHorisont(v, h, player_DOT) == sizeWin - 1) {
                        if (MoveAiLineHorisont(v, h, Ai_DOT)) return;
                    }

                    if (v - sizeWin > -2) {                            //вверх по диагонали
                        if (checkDiaUp(v, h, player_DOT) == sizeWin - 1) {
                            if (MoveAiDiaUp(v, h, Ai_DOT)) return;
                        }
                    }
                    if (v + sizeWin <= sizeY) {                       //вниз по диагонали
                        if (checkDiaDown(v, h, player_DOT) == sizeWin - 1) {
                            if (MoveAiDiaDown(v, h, Ai_DOT)) return;
                        }
                    }
                }
                if (v+ sizeWin <= sizeY) {                       //по вертикали
                    if (checkLineVertical(v,h,player_DOT) == sizeWin -1) {
                        if(MoveAiLineVertical(v,h,Ai_DOT)) return;
                    }
                }
            }
        }
        //игра на победу
        for (int v = 0; v< sizeY; v++) {
            for (int h = 0; h < sizeX; h++) {
                //анализ наличие поля для проверки
                if (h+ sizeWin <= sizeX) {                           //по горизонтали
                    if (checkLineHorisont(v,h,Ai_DOT) == sizeWin -1) {
                        if (MoveAiLineHorisont(v,h,Ai_DOT)) return;
                    }

                    if (v- sizeWin >-2) {                            //вверх по диагонали
                        if (checkDiaUp(v, h, Ai_DOT) == sizeWin -1) {
                            if (MoveAiDiaUp(v,h,Ai_DOT)) return;
                        }
                    }
                    if (v+ sizeWin <= sizeY) {                       //вниз по диагонали
                        if (checkDiaDown(v, h, Ai_DOT) == sizeWin -1) {
                            if (MoveAiDiaDown(v,h,Ai_DOT)) return;
                        }
                    }

                }
                if (v+ sizeWin <= sizeY) {                       //по вертикали
                    if (checkLineVertical(v,h,Ai_DOT) == sizeWin -1) {
                        if(MoveAiLineVertical(v,h,Ai_DOT)) return;
                    }
                }
            }
        }

        //случайный ход
        do {
            y = rnd.nextInt(sizeY);
            x = rnd.nextInt(sizeX);
        } while (!checkMove(y,x));
        dotField(y, x, Ai_DOT);
    }

    //ход компьютера по горизонтали
    private boolean MoveAiLineHorisont(int v, int h, char dot) {
        for (int j = h; j < sizeWin; j++) {
            if ((fieldg[v][j] == EMPTY_DOT)) {
                fieldg[v][j] = dot;
                return true;
            }
        }
        return false;
    }
    //ход компьютера по вертикали
    private boolean MoveAiLineVertical(int v, int h, char dot) {
        for (int i = v; i< sizeWin; i++) {
            if ((fieldg[i][h] == EMPTY_DOT)) {
                fieldg[i][h] = dot;
                return true;
            }
        }
        return false;
    }
    //проверка заполнения всей линии по диагонали вверх

    private boolean MoveAiDiaUp(int v, int h, char dot) {
        for (int i = 0, j = 0; j < sizeWin; i--, j++) {
            if ((fieldg[v+i][h+j] == EMPTY_DOT)) {
                fieldg[v+i][h+j] = dot;
                return true;
            }
        }
        return false;
    }

    //проверка заполнения всей линии по диагонали вниз
    private boolean MoveAiDiaDown(int v, int h, char dot) {

        for (int i = 0; i < sizeWin; i++) {
            if ((fieldg[i+v][i+h] == EMPTY_DOT)) {
                fieldg[i+v][i+h] = dot;
                return true;
            }
        }
        return false;
    }

    //проверка заполнения выбранного для хода игроком
    private boolean checkMove(int y, int x) {
        if (x < 0 || x >= sizeX || y < 0 || y >= sizeY) return false;
        else if (!(fieldg[y][x] == EMPTY_DOT)) return false;

        return true;
    }

    //проверка на ничью (все  ячейки поля заполнены ходами)
    private boolean fullField() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (fieldg[i][j] == EMPTY_DOT) return false;
            }
        }
        System.out.println("Игра закончилась в ничью");
        return true;
    }

    //проверка победы
    private boolean checkWin(char dot) {
        for (int v = 0; v < sizeY; v++) {
            for (int h = 0; h < sizeX; h++) {
                //анализ наличие поля для проверки
                if (h + sizeWin <= sizeX) {                           //по горизонтали
                    if (checkLineHorisont(v, h, dot) >= sizeWin) return true;

                    if (v - sizeWin > -2) {                            //вверх по диагонали
                        if (checkDiaUp(v, h, dot) >= sizeWin) return true;
                    }
                    if (v + sizeWin <= sizeY) {                       //вниз по диагонали
                        if (checkDiaDown(v, h, dot) >= sizeWin) return true;
                    }
                }
                if (v + sizeWin <= sizeY) {                       //по вертикали
                    if (checkLineVertical(v, h, dot) >= sizeWin) return true;
                }
            }
        }
        return false;
    }

    //проверка заполнения всей линии по диагонали вверх
    private int checkDiaUp(int v, int h, char dot) {
        int count=0;
        for (int i = 0, j = 0; j < sizeWin; i--, j++) {
            if ((fieldg[v+i][h+j] == dot)) count++;
        }
        return count;
    }

    //проверка заполнения всей линии по диагонали вниз
    private int checkDiaDown(int v, int h, char dot) {
        int count=0;
        for (int i = 0; i < sizeWin; i++) {
            if ((fieldg[i+v][i+h] == dot)) count++;
        }
        return count;
    }

    private int checkLineHorisont(int v, int h, char dot) {
        int count=0;
        for (int j = h; j < sizeWin + h; j++) {
            if ((fieldg[v][j] == dot)) count++;
        }
        return count;
    }

    //проверка заполнения всей линии по вертикали
    private int checkLineVertical(int v, int h, char dot) {
        int count=0;
        for (int i = v; i< sizeWin + v; i++) {
            if ((fieldg[i][h] == dot)) count++;
        }
        return count;
    }

    private void changeCurrentPlayerIfNeeded(){
        if(gameMode == Map.MODE_H_V_H) {
            if(getCurrentPlayerDot() == player_DOT) {
                setCurrentPlayerDot(Ai_DOT);
            }
            else {
                setCurrentPlayerDot(player_DOT);
            }
        }
    }

}
