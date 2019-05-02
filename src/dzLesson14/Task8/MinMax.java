package dzLesson14.Task8;

import java.util.Arrays;

public class MinMax<T extends Number> {
    private T[] array;

    public MinMax(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public double maxElement(){
        double max = array[0].doubleValue();
        for (T t: array) {
            if(t.doubleValue() > max){
                max = t.doubleValue();
            }
        }
        return max;
    }
    public double minElement(){
        double min = array[0].doubleValue();
        for (T t: array) {
            if(t.doubleValue() < min){
                min = t.doubleValue();
            }
        }
        return min;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinMax<?> minMax = (MinMax<?>) o;
        return Arrays.equals(array, minMax.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "MinMax{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
