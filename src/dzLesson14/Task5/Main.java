package dzLesson14.Task5;


class Potato implements Cookable {
    @Override
    public void cook(String str) {
        System.out.println(str);
    }
}
public class Main {



    public static void main(String[] args) {
        Food food = new Food();

        Potato potato = new Potato(){
            public void cook(String str){
                System.out.println(str);
            }
        };
        food.prepare(potato,"String");
    }
}
