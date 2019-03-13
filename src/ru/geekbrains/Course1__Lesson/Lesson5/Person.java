package ru.geekbrains.Course1__Lesson.Lesson5;

public class Person {
    private String fio;
    private String staffPost;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public Person(String fio, String staffPost, String email, String telephone, int salary, int age) {
        this.fio = fio;
        this.staffPost = staffPost;
        this.email = email;
        this.telephone = telephone;
        setSalary(salary);
        setAge(age);
    }

    private void setAge(int age) {
        if (age > 17 && age < 100) {
            this.age = age;
        } else {
            this.age = 18;
        }
    }

    private void setSalary(int salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            this.salary = 0;
        }

    }

    public int getAge() {
        return age;
    }

    public void outPersonalInfo() {
        System.out.println(
                "Сотрудник: " + fio + " " +
                "должность: " + staffPost  + " " +
                "e-mail: " + email  + " " +
                "тел.: " + telephone  + " " +
                "з/п: " + salary  + " " +
                "возраст: " + age);
    }
}
