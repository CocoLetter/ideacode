package heima;

public class Demo3_12_5 {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);
    }
    public static int test() {
        int i= 10;
        try {
            return 10;
        } finally {
            i = 20;
        }
    }
}
/*
 0 bipush 10
 2 istore_0
 3 bipush 10
 5 istore_1
 6 bipush 20
 8 istore_0
 9 iload_1
10 ireturn
11 astore_2
12 bipush 20
14 istore_0
15 aload_2
16 athrow
 */