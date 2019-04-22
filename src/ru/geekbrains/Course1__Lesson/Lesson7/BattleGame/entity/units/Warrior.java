package ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.units;

public class Warrior extends Hero{
    public static String GetHeroName(){
        return "Warrior";
    }
    public Warrior() {
        super.Hero(50, 150, 0);
    }

}
