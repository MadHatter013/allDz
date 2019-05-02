package dzLesson14.Task8;

public class Main {
    public static void main(String[] args) {
        MinMax<Double> array = new MinMax<Double>(new Double[4]);

        Double[] arrayD = new Double[4];
        arrayD[0] = 4.0;
        arrayD[1] = 8.05;
        arrayD[2] = 1.4;
        arrayD[3] = 9.3;
        array.setArray(arrayD);

        System.out.println(array.maxElement());
        System.out.println(array.minElement());
    }
}
