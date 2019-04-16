package dzLesson12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task13 {
    private static void findPalindrome(String[] str) {
        StringBuilder stringBuilder;
        for (String string : str) {
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(string);
            if (matcher.matches()) {
                stringBuilder = new StringBuilder(string);
                if (string.equals(stringBuilder.reverse().toString())) {
                    System.out.println(stringBuilder);
                }
            }
        }
    }

    public static void main(String[] args) {
        String str = "Если есть хвосты по дз, начните с 1 не сданного задания. 123 324 111 4554";
        String[] a = str.split(" ");

        System.out.println("Все слова палиндромы(состоящие только из цифр): ");
        findPalindrome(a);
    }
}
