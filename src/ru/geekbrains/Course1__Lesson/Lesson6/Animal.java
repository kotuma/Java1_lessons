package ru.geekbrains.Course1__Lesson.Lesson6;

abstract class Animal {
    public String getName() {
        return name;
    }

    private final String name;


    public Animal (String name) {
        this.name = name;
    }

}

interface IRunnable {
    boolean run(int distance);
}

interface ISwimmable {
    boolean swim(int distance);
}

interface IJumpable {
    boolean jump(float height);
}



