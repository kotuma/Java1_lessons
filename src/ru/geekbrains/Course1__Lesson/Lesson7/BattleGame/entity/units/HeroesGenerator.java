package ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.units;

import java.util.Random;

public class HeroesGenerator {

    public static final int UNITS_CLASSES_COUNT = 3;

    public static Hero[] generateRandomHeroes(int count) {
        Hero[] heroes = new Hero[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int unitNum = random.nextInt(UNITS_CLASSES_COUNT);
            switch (unitNum){
                case 0: {
                    heroes[i] = new Warrior();
                    break;
                }
                case 1: {
                    heroes[i] = new Assassin();
                    break;
                }
                case 2: {
                    heroes[i] = new Healer();
                    break;
                }
            }
        }
        return heroes;
    }
}
