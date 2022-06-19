public class Base {
    private void test() {
        System.out.println("hello");
    }
}

class Son extends Base{
    public void test() {
    }
    public static void main(String[] args) {
        Son son = new Son();
        Base father = son;
//        father.test();
    }
}
