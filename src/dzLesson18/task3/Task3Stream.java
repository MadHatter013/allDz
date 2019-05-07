package dzLesson18.task3;

import java.io.*;

public class Task3Stream {
    public static void main(String[] args) {
        try (OutputStream output = new FileOutputStream("E:\\rewrite\\B.txt");
             InputStream input = new FileInputStream("E:\\\\rewrite\\\\A.txt")) {
            int size = input.available();
            for (int i = 0; i < size; i++) {
                System.out.println((char) input.read() + " ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
