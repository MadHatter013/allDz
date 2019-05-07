package dzLesson18.task2;

import java.io.*;

public class FileInputOutputStreamDemo {
    public static void main(String[] args) {
        try (OutputStream output = new FileOutputStream("a.txt");
             InputStream input = new FileInputStream("a.txt")) {
            char[] symbols = {'a', 'b', 'c'};
            for (char s : symbols) {
                // Запись каждого символа в текстовый файл
                output.write(s);
            }

            int size = input.available();

            for (int i = 0; i < size; i++) {
                // Чтение текстового файла посимвольно
                System.out.print((char) input.read() + " ");
            }

        } catch (IOException e) {
            System.out.print("Exception");
        }
    }
}
