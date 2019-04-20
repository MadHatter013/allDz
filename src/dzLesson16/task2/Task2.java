package dzLesson16.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<HeavyBox> heavyBoxList = new ArrayList<>();
        heavyBoxList.add(new HeavyBox(4, 4, 4, 4));
        heavyBoxList.add(new HeavyBox(4, 4, 4, 4));
        heavyBoxList.add(new HeavyBox(4, 4, 4, 4));
        heavyBoxList.add(new HeavyBox(4, 4, 4, 4));

        Object[] objectArray = heavyBoxList.toArray();
        System.out.println(Arrays.toString(objectArray) + "\n");

        HeavyBox[] heavyObject1 = new HeavyBox[heavyBoxList.size()];
        heavyBoxList.toArray(heavyObject1);
        System.out.println(Arrays.toString(heavyObject1) + "\n");

        HeavyBox[] heavyObject2 = heavyBoxList.toArray(new HeavyBox[0]);
        System.out.println(Arrays.toString(heavyObject2) + "\n");


    }
}
