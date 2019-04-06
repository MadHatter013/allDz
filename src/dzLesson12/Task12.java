package dzLesson12;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task12 {
    private static int LatWord(String[] str) { // число уникальных символов
        int count = 0;
        for (int i = 0; i < str.length; i++) { // обход строки
            System.out.print(str[i]);
            Pattern pattern = Pattern.compile("[a-zA-Z]+");
            Matcher matcher = pattern.matcher(str[i]);
            System.out.print(" " + matcher.matches() + " \n");
            if (matcher.matches()) {
                count++;
            }
        }

        return count; // возвращаем длину получившейся строки
    }

    public static void main(String[] args) {
        String str = "One two three раз два три one1 two2 123 ";
        String[] a = str.split(" ");
        int count = LatWord(a);
        System.out.println("Количество слов содержащие только символы латинского алфавита: " + count);
    }
}
