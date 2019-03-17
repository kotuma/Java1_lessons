package ru.geekbrains.Course1__Lesson.Lesson6;

import java.util.Random;

public class Dog extends Animal implements IRunnable, IJumpable, ISwimmable {
    private int maxRun = 500;
    private float maxJump = 0.5f;
    private int maxSwim = 10;
    private final int RUN_OFFSET = 300;
    private final int SWIM_OFFSET = 5;
    private final float JUMP_OFFSET = 0.4f;
    private static Random rnd = new Random();

    public Dog(String name) {
        super("Dog " + name);
        maxRun  -= rnd.nextInt(RUN_OFFSET);
        maxSwim -= rnd.nextInt(SWIM_OFFSET);
        float x = rnd.nextInt(Math.round(JUMP_OFFSET * 1000));
        maxJump = maxJump - x / 1000;
    }

    public boolean run(int distance) {
        return distance <= maxRun;
    }

    public boolean jump(float height) {
        return height <= maxJump;
    }

    public boolean swim(int distance) {
        return distance <= maxSwim;
    }

}