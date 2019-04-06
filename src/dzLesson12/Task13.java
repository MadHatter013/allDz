package dzLesson12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task13 {
    private static void FindPalindrome(String[] str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(str[i]);
            if (matcher.matches()) {
                stringBuilder = new StringBuilder(str[i]);
                if (stringBuilder.toString().equals(stringBuilder.reverse().toString())) {
                    System.out.println(stringBuilder);
                }
            }
        }
    }

    public static void main(String[] args) {
        String str = "Если есть хвосты по дз, начните с 1 не сданного задания. 123 324 111 4554";
        String[] a = str.split(" ");

        System.out.println("Все слова палиндромы(состоящие только из цифр): ");
        FindPalindrome(a);
    }
}
