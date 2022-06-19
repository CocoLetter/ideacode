package heima.candy;

public class Candy10 {
    public static void  test(int x){
        Runnable thread = new Runnable() {
            @Override
            public void run() {
                System.out.println(x);
            }
        } ;
        Thread thread1 = new Thread(thread);
        thread1.run();

    }

    public static void main(String[] args) {
        test(4);
    }

}

