package ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.units;

public class Assassin extends Hero{
    public static String GetHeroName(){
        return "Assassin";
    }

    public Assassin() {
        super.Hero(80, 110, 0);
    }
}
