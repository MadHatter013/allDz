package dzLesson13;

import dzLesson16.task2.HeavyBox;

public class Task5 {
    public static void main(String[] args) {
        getMetaInfo(HeavyBox.class);
    }

    private static void getMetaInfo(Class metaClass){
        System.out.println("Super Class: " + metaClass.getSuperclass());
        System.out.println("In the package: " + metaClass.getPackageName());
        System.out.println("Class Modifier: " + metaClass.getModifiers());
        System.out.println();

        System.out.println("Is Array? - " + metaClass.isArray());
        System.out.println("Is Interface? - " + metaClass.isInterface());
        System.out.println("Is primitive type? - " + metaClass.isPrimitive());
        System.out.println();

        System.out.println("Declared classes: " + metaClass.getDeclaredClasses());
        System.out.println("Dclared constructor: " + metaClass.getDeclaredConstructors());
        System.out.println("Declared methods: " + metaClass.getDeclaredMethods());
        System.out.println("Declared fields: " + metaClass.getDeclaredFields());
        System.out.println();

        System.out.println("Open classes: " + metaClass.getClasses());
        System.out.println("Constructors: " + metaClass.getConstructors());
        System.out.println("Methods: " + metaClass.getMethods());
        System.out.println("Field: " + metaClass.getFields());
    }
}
