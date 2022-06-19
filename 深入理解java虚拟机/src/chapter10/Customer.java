package chapter10;

public class Customer {

    public String name;
    private Account acc;

    protected int age = 20;
    static final int money = 12;

    {
        name = "匿名用户";
    }


    public Customer() {
        age=12;
        acc = new Account();
    }



}

class Account {

}
