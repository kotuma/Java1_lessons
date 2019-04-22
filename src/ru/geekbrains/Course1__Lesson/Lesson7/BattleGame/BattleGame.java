package ru.geekbrains.Course1__Lesson.Lesson7.BattleGame;

import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.Player;
import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.units.HeroesGenerator;

import java.util.Arrays;
import java.util.Scanner;

public class BattleGame {
    static int activePlayerID = 0;

    public static void main(String[] args) {
        boolean finishGame = false;

        Scanner in = new Scanner(System.in);

        Player[] players = {
            new Player("Green", true, HeroesGenerator.generateRandomHeroes(Player.DEFAULT_HEROES_COUNT)),
            new Player("Red", false, HeroesGenerator.generateRandomHeroes(Player.DEFAULT_HEROES_COUNT))
        };

        int idActive;
        int idPassive;
        while (!finishGame) {
            idActive = BattleGame.activePlayerID;
            idPassive  = ChangeActivePlayerID(idActive);
            System.out.println("Атаковал игрок: " + players[idActive].getName() + ": " + Arrays.toString(players[idActive].getHeroes()));
            System.out.println("Игрок " + players[idPassive].getName() + ": " + Arrays.toString(players[idPassive].getHeroes()));
            if (players[idActive].isWinAfterAttack(players[idPassive])) {
                System.out.println("Победил игрок: " + players[idActive].getName());
                finishGame = true;
                break;
            }
            System.out.println("Введите что либо для продолжения боя...");
            in.nextLine();
        }
    }

    public int getActivePlayerID() {
        return activePlayerID;
    }

    public static int ChangeActivePlayerID(int activePlayerID) {
        switch (activePlayerID) {
            case 0: {
                BattleGame.activePlayerID = 1;
                break;
            }
            case 1: {
                BattleGame.activePlayerID = 0;
                break;
            }

        }
        return BattleGame.activePlayerID;
    }
}
