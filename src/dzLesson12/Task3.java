package dzLesson12;

public class Task3 {
    public static void main(String[] args) {
        StringBuilder string = new StringBuilder("Object-oriented programming is a programming language model organized around objects " +
                "rather than \"actions\" and data rather than logic. Object-oriented programming blabla. Object-oriented programming bla.");


        int a = string.indexOf("Object-oriented programming");

        replaceOOP(string);
        System.out.println(string);
    }

    public static StringBuilder replaceOOP(StringBuilder str) {
        boolean b = true;
        for (int i = 0; i < str.length(); i++) {
            i = str.indexOf("Object-oriented programming", i);
            if (i == -1) {
                System.out.println("Замена окончена");
                break;
            }
            b = !b;
            if (b == true) {
                str.delete(i, i + 27);
                str = str.insert(i, "OOP");
            }
        }
        return str;
    }
}
