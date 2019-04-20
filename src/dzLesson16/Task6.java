package dzLesson16;

import dzLesson16.task2.HeavyBox;

import java.util.ArrayDeque;
import java.util.Queue;

public class Task6 {
    public static void main(String[] args) {
        Queue<HeavyBox> heavyBoxQueue = new ArrayDeque<>();
        heavyBoxQueue.offer(new HeavyBox(4, 4, 4, 4));
        heavyBoxQueue.offer(new HeavyBox(5, 5, 5, 5));
        heavyBoxQueue.offer(new HeavyBox(6, 6, 6, 6));
        heavyBoxQueue.offer(new HeavyBox(7, 7, 7, 7));

        for (int i = 0; i < heavyBoxQueue.size(); ) {
            System.out.println(i);
            System.out.println(heavyBoxQueue.poll());
        }
    }
}
