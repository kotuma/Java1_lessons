package ru.geekbrains.Course1__Lesson.Lesson7.entity.units;

public class Hero {
    int losses = 0;
    int health = 100;
    int maxHealth = health;
    int healing = 0;
    boolean Alive;
    private static final int DELTA_LOSSES = 10;

    protected int getMaxHealth() {
        return maxHealth;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (this.health > maxHealth) {
            this.health = maxHealth;
        }
    }

    public boolean neededHealing(Hero hero) {
        return hero.isAlive() && hero.getHealth() < hero.getMaxHealth();
    }

    public int getHealing() {
        return healing;
    }

    private void setHealing(int healing) {
        this.healing = healing;
    }

    public boolean isAlive() {
        return Alive;
    }

    public void setAlive(boolean alive) {
        Alive = alive;
    }

    public void Hero(int losses, int health, int healing) {
        this.losses = losses;
        this.health = health;
        this.maxHealth = health;
        this.healing = healing;

        this.Alive = true; // живой
    }

    public void setDamage(Hero enemy) { // Наносить урон врагу
        enemy.getDamage(this.losses); // враг принимает урон
        if (!enemy.isAlive()) {
            this.losses += DELTA_LOSSES; // убил врага + навык в бою
        }
    }

    public void getDamage(int damage) { // Получать урон от противника
        health -= damage;
        if (health <= 0) {
            health = 0;
            setAlive(false); // статус - убит
        }

    }

    @Override
    public String toString() {
        String stat;
        if (this.isAlive()) {
            stat = String.format(": %s/%s", this.losses, this.health);
            if (this.healing > 0) {
                stat += String.format("/%s", this.healing);
            }
            stat += "";
        } else
            stat = "-убит";
        return this.getClass().getSimpleName() + stat;
    }
}
