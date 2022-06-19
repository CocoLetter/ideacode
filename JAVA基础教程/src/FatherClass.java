class FatherClass{
    String name = "hei";
    public FatherClass(){
        System.out.println("父类 无参 构造函数");
    }
    public FatherClass(int i){
        System.out.println("父类 一个参数构造函数super = "+i);
    }
    public FatherClass(int i,String j){
        System.out.println("父类 一个参数构造函数superi = "+i+",superj = "+j);
    }

    public void hello(){
        System.out.println("hello");
    }

    public static void hehe(){
        System.out.println("hehe");
    }

}