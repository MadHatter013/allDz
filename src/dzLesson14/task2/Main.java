package dzLesson14.task2;

public class Main {
    public static void main(String[] args){
        User user = new User();
        user.new Query().printToLog();
        User.Query user1 = new User().new Query();
        user1.printToLog();
        user.createQuery();
    }
}
