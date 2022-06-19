package heima;

public class Demo3_12_1 {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);
    }
    public static int test() {
        try {
            int i = 1/0;
            return 10;
        } finally {
//            return 20;
        }
    }
}
//这样写发生异常时由于异常处理表的存在会以return 20的方式处理异常，掩盖了异常，不会报错
//finally中不写return：发生异常会报错

/*
 0 iconst_1
 1 iconst_0
 2 idiv
 3 istore_0
 4 bipush 10
 6 istore_1
 7 bipush 20
 9 ireturn
10 astore_2
11 bipush 20
13 ireturn

 */
