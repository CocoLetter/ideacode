package cn.itcast.domain;

public class Person {
    private String name;
    private int age;

    public String a;
    protected String b;
    String c;
    private String d;

    static{
        System.out.println("Person.static");
    }



    public Person() {
        System.out.println("Person()");
    }

    public Person(String name, int age) {
        System.out.println("Person(String name, int age)");

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }


    public void eat(){
        System.out.println(name+"eat...");
    }

    public void eat(String food){
        System.out.println(name+"eat..."+food);
    }
}
