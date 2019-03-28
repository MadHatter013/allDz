package dzLesson12;

public class Task4 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("String");
        StringBuilder stringBuilder1 = new StringBuilder("Code");
        StringBuilder stringBuilder2 = new StringBuilder("Practice");
        StringBuilder stringBuilder3 = new StringBuilder("Pra");
        stringBuilder = twoMiddleCharacters(stringBuilder);
        stringBuilder1 = twoMiddleCharacters(stringBuilder1);
        stringBuilder2 = twoMiddleCharacters(stringBuilder2);
//        stringBuilder3 = twoMiddleCharacters(stringBuilder3);

    }

    public static StringBuilder twoMiddleCharacters(StringBuilder stringBuilder) {
        int length = stringBuilder.length();
        if (length % 2 != 0) {
            System.out.println("Длина строки - нечетное значение!");
            System.exit(3);
        }
        stringBuilder = stringBuilder.delete(0, (length / 2) - 1);
        stringBuilder = stringBuilder.delete(2, length);
        System.out.println(stringBuilder);
        return stringBuilder;
    }
}
