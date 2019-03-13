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
    }


}
