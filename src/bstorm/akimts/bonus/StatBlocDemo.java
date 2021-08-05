package bstorm.akimts.bonus;

public class StatBlocDemo {

    static class Test {
        static int i = 0;

        static {
            i = 10;
            System.out.println("passage par le bloc");
        }
    }

    public static void main(String[] args) {
        modifI();
        System.out.println(Test.i);
    }

    public static void modifI(){
        Test.i = 25;
        System.out.println("passage par modifI");
    }

}
