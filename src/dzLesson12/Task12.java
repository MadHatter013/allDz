package dzLesson12;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task12 {
    private static int latWord(String[] str) { // число уникальных символов
        int count = 0;
        for (String string : str) { // обход строки
            System.out.print(string);
            Pattern pattern = Pattern.compile("[a-zA-Z]+");
            Matcher matcher = pattern.matcher(string);
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
        int count = latWord(a);
        System.out.println("Количество слов содержащие только символы латинского алфавита: " + count);
    }
}
