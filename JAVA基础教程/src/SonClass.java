class SonClass extends FatherClass{


    public int age=4562;

    private String name="he";


    public SonClass(){
      super(22);//line 1
        super.hello();
        super.hehe();
        System.out.println("子类 无参 构造函数");
    }
    public SonClass(int a){
        super(33,"Hello");//line 2
        System.out.println("子类一个参数构造函数sub = "+a);
    }
    public void fun(int a){//子类中定义一个实例函数
        //super(33,"Hello");//构造函数调用必须声明在构造函数中,这行代码不注释的话会报错
        System.out.println("子类一个参数构造函数sub = "+a);
    }
}