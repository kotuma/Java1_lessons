package ru.geekbrains.Course1__Lesson.Lesson6;

class MarathonMain {
    public static void main(String[] args) {
        Marathon marathon = new Marathon();

        Animal[] animals = {
                    new Cat("Boris"),
                    new Cat("Vasilii"),
                    new Cat("Murzic"),
                    new Dog("Sharik"),
                    new Dog("Juchka"),
                    new Dog("Bobik")
            };

        System.out.println("Lesson6. Marathon.\n");
        marathon.start(animals);
        marathon.run(160);
        marathon.run(450);
        marathon.swim(7);
        marathon.swim(9);
        marathon.jump(0.3f);
        marathon.jump(1.7f);
    }
}
