package ru.geekbrains.Course1__Lesson.Lesson6;

// 1. Создать классы Собака и Кот с наследованием от класса Животное.
// 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу
// передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
// 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.;
// плавание: кот не умеет плавать, собака 10 м.).
// 4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
// (Например, dog1.run(150); -> результат: run: true)
// 5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.


class Marathon {
   private Animal[] mAnimals;

    public void start(Animal[] animals) {
        mAnimals = animals;
        System.out.println("Marathon started with:");
        for (Animal animal: mAnimals) {
            System.out.println("   - " + animal.getName());
        }
    }

    public void run(int distance) {
        System.out.println("Marathon run distance " + distance + "m finished:");
        for (Animal animal: mAnimals) {
            if (animal instanceof IRunnable && ((IRunnable) animal).run(distance)) {
                System.out.println("   - " + animal.getName());
            }
        }
    }

    public void jump(float height) {
        System.out.println("Marathon jump height " + height + "m finished:");
        for (Animal animal: mAnimals) {
            if (animal instanceof IJumpable && ((IJumpable) animal).jump(height)) {
                System.out.println("   - " + animal.getName());
            }
        }
    }

    public void swim(int distance) {
        System.out.println("Marathon swim distance " + distance + "m finished");
        for (Animal animal: mAnimals) {
            if (animal instanceof ISwimmable && ((ISwimmable) animal).swim(distance)) {
                System.out.println("   - " + animal.getName());
            }
        }
    }

}
