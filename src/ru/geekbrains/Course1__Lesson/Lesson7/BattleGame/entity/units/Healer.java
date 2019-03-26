package ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.units;


public class Healer extends Hero {
    private static final int DELTA_HEALING = 5;
    private static final int MAX_HEALING = 130;

    public Healer() {
        super.Hero(20, 90, 20);
    }

    public boolean healingHero(Hero ourHero) {
        if (ourHero.isAlive() && this.getHealing() > 0 && ourHero.neededHealing(ourHero)) {
            ourHero.setHealth(
                    ourHero.getHealth() + this.getHealing());
            this.increaseHealing(); // + навык лечения
            return true;
        }
        return false; // лечение не требуется (уже умер или 100% здоров)
    }

    private void increaseHealing() {
        if (this.healing < MAX_HEALING) {
            this.healing += DELTA_HEALING; // + навык лечения
        }
    }
}
