package ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity;

import ru.geekbrains.Course1__Lesson.Lesson7.BattleGame.entity.units.*;

public class Player {
    public static final int DEFAULT_HEROES_COUNT = 4;
    private boolean active;
    private String name;

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }
    private Hero[] heroes = new Hero[DEFAULT_HEROES_COUNT];


    public Player(String name, boolean active, Hero[] heroes) {
        this.name = name;
        this.active = active;
        this.heroes = heroes;
    }

    public Player(String name, boolean active) {
        this.name = name;
        this.active = active;
        this.heroes = null;
    }

    public Hero[] getHeroes() {
        return heroes;
    }

    public void setHeroes(Hero[] heroesArray) {
        this.heroes = heroesArray;
    }

    public boolean isWinAfterAttack(Player enemyPlayer) {
        Hero ourHero = this.getHero();
        Hero enemyHero = enemyPlayer.getHero();

        ourHero.setDamage(enemyHero);

        String stat =
                this.getName() + " " +
                        ourHero.getClass().getSimpleName() + " -> " +
                        enemyHero.getClass().getSimpleName();
        if (enemyHero.isAlive()) {
            System.out.println(stat + "(здоровье: " + enemyHero.getHealth() + ")");
        } else {
            System.out.println(stat + "(убит)");
        }

        if (enemyHero.isAlive()) {
            Healer enemyHealer = enemyPlayer.getHealer();
            if (enemyHealer != null) {
                enemyHealer.healingHero(enemyPlayer.getHero());
                System.out.println(" - Доктор вылечил " + enemyHero.getClass().getSimpleName() + " до " + enemyHero.getHealth());
            }
        }

        return enemyPlayer.isDamaged();
    }

    public Hero getHero(){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].isAlive()) {
                return heroes[i];
            }
        }
        return null;
    }

    public boolean isDamaged() {
        for (Hero h: heroes) {
            if(h == null) {
                break;
            } else {
                if (h.isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Healer getHealer() {
        for (int i = heroes.length - 1; i > 0; i--) {
            if (heroes[i] instanceof Healer) {
                return (Healer) heroes[i];
            }
        }
        return null;
    }

}
