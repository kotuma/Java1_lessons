package ru.geekbrains.Course1__Lesson.Lesson5;

public class Main {
   public static void main(String[] args) {
       System.out.println("Lesson5. Данные о сотрудниках за 40.\n");
       Person[] personArray = new Person[5];
       personArray[0] = new Person("Иванов Иван Иванович", "Директор", "director@bestcompany.com", "+79271112233", 300000, 55);
       personArray[1] = new Person("Иванова Анна Ивановна", "Главный бухгалтер", "FinanceDepartament@bestcompany.com", "+79271112232", 250000, 53);
       personArray[2] = new Person("Иванов Станислав Иванович", "Главный инженер", "HeadIngeneer@bestcompany.com", "+79271112231", 152000, 18);
       personArray[3] = new Person("Петров Николай Сидорович", "вед. инженер", "petrov@bestcompany.com", "+79061113327", 50000, 41);
       personArray[4] = new Person("Боширов Фёдор Иннокеньтьевич", "инженер", "boshirov@bestcompany.com", "+79061113328", 45000, 37);

       for (Person cPerson: personArray) {
           if (cPerson.getAge() > 40) cPerson.outPersonalInfo();
       }

       System.out.println();
       System.out.println("Lesson5. Задача о деревьях.");
       String forestStr = "5 1 5 2 2 4 1 4 5 1 5 3 2 4 4 4 5 1 3 4 2 2 1 2 4 4 4 5 4 3 5 4 4 5 5 1 4 1 5 3 1 4 5 3 3 4 2 2 4 4 5 5 1 1 1 4 5 5 4 4 2 4 3 1 3 3 1 1 3 1 3 4 4 3 2 2 1 3 4 4 2 3 4 2 4 4 1 4 4 4 2 1 2 4 1 5 2 2 5 4 2 2 3 1 5 5 3 5 3 1 4 5 4 2 1 3 1 2 1 4 1 3 4 2 2 5 2 3 1 1 2 3 3 4 4 2 4 1 2 2 2 5 1 5 1 2 2 1 3 3 4 3 5 3 5 1 2 1 3 3 2 4 1 4 3 5 1 2 1 2 3 2 1 3 2 2 4 3 2 1 5 1 4 5 4 4 5 5 4 2 3 5 1 3 4 3 2 4 5 2 5 2 4 1 4 5 2 3 3 4 4 3 5 2 2 3 5 1 2 4 3 4 4 3 2 2 1 4 5 5 1 5 2 4 5 5 4 2 2 1 5 1 3 4 2 4 2 2 4 3 5 2 2 4 4 4 5 5 2 5 5 2 5 1 1 5 5 4 1 2 4 1 2 2 5 4 5 1 5 4 4 5 5 5 3 3 4 3 3 5 3 2 2 2 2 2 1 2 5 2 3 4 3 5 5 2 4 5 3 4 3 1 3 2 1 1 5 4 4 2 3 1 3 4 2 4 1 3 5 1 5 3 5 2 3 4 4 1 3 1 5 5 1 2 2 1 3 1 5 1 2 2 1 5 1 3 3 2 1 3 2 5 1 1 2 3 5 5 4 3 1 3 3 1 5 4 2 3 4";

       Forest forest = new Forest();
       forest.loadFromString(forestStr);
       System.out.println(forest);

    }


}
