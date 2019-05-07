package dzLesson18.task3;

import java.io.*;

public class Task3Part2 {
    public static void main(String[] args) {
        char[] array = new char[50];
        File inputFile = new File("E:\\rewrite\\A.txt");
        File outputFile = new File("E:\\rewrite\\B.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
             BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

            int size = br.read(array);
            bw.write(array);
            for (int i = 0; i < size; i++) {
                System.out.print(array[i]);
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
