package ru.geekbrains.Course1__Lesson.Lesson6;

public class Sentence {


    public static void main(String[] args) {
        String s = "Предложение  один     Теперь предложение    два   Предложение   три";
        String s1 = s.replaceAll(" +", " ");
        StringBuilder s2 = new StringBuilder("");

        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) == ' ' && s1.charAt(i+1) >= 'А' && s1.charAt(i+1) <= 'Я') {
                s2.append('.');
                s2.append(s1.charAt(i));
            } else {
                s2.append(s1.charAt(i));
                if (i == s1.length() - 1 && s1.charAt(i) != '.') {
                    s2.append('.');
                }
            }
        }
        System.out.println(s2.toString());
    }
}
