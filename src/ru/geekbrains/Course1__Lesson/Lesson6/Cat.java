package ru.geekbrains.Course1__Lesson.Lesson6;

import java.util.Random;

public class Cat extends Animal implements IRunnable, IJumpable {
    private int maxRun = 200;
    private float maxJump = 2;
    private final int RUN_OFFSET = 100;
    private final float JUMP_OFFSET = 0.7f;
    private static Random rnd = new Random();

    public Cat(String name) {
        super("Cat " + name);

        maxRun -= rnd.nextInt(RUN_OFFSET);
        float x = rnd.nextInt(Math.round(JUMP_OFFSET * 1000));
        maxJump = maxJump - x / 1000;
    }

    public boolean run(int distance) {
        return distance <= maxRun;
    }

    public boolean jump(float height) {
        return height <= maxJump;
    }
}
