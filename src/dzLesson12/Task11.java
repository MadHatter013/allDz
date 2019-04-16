package dzLesson12;


public class Task11 {
    private static int diffWords(String st) {
        StringBuilder u = new StringBuilder();
        String c;
        for (int i = 0; i < st.length(); i++) {
            c = String.valueOf(st.charAt(i));
            if (u.indexOf(c) == -1)
                u.append(c);
        }

        return u.length();
    }

    public static void main(String[] args) {
        String str = "fffff ab f 1234 jkjk";
        String[] a = str.split(" ");
        String goal = a[0];
        System.out.print("Строка: \n" + goal + " ");
        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + " ");
            if (diffWords(a[i]) < diffWords(goal))
                goal = a[i];
        }
        System.out.println("");
        System.out.println("Искомое слово: " + goal + ", число разных символов: " + diffWords(goal));
    }
}
