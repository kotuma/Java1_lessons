package ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.units;

public class HeroesHelper {
    private static int [] heroesTypes = {0, 1, 2};

    public static int getMinHeroesID() {
        return heroesTypes[0];
    }

    public static int getMaxHeroesID() {
        return heroesTypes[heroesTypes.length - 1];
    }

    public static String getHeroTypeByID(int heroID) {
        String res = "";
        if(heroID >= heroesTypes[0] && heroID <= heroesTypes[heroesTypes.length - 1]) {
            switch (heroID) {
                case 0: {
                    res = Warrior.GetHeroName();
                    break;
                }
                case 1: {
                    res = Assassin.GetHeroName();
                    break;
                }
                case 2: {
                    res = Healer.GetHeroName();
                    break;
                }
            }
        }
        return res;
    }
}
