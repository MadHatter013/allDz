package dzLesson18.task3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        char[] array = new char[50];
        File inputFile = new File("E:\\rewrite\\A.txt");
        File outputFile = new File("E:\\rewrite\\B.txt");
        try (FileWriter fileWriter = new FileWriter(outputFile);
             FileReader fileReader = new FileReader(inputFile)) {

            int size = fileReader.read(array);
            fileWriter.write(array);
            for (int i = 0; i < size; i++) {
                System.out.print(array[i]);
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
