package heima.candy;

public class Candy4 {
    public static void foo(String... args) {
        String[] array = args; // 直接赋值
        System.out.println(array);
    }

}

/*

0 aload_0
1 astore_1
2 getstatic #2 <java/lang/System.out>
5 aload_1
6 invokevirtual #3 <java/io/PrintStream.println>
9 return

 */


/*
0 iconst_2
1 anewarray #4 <java/lang/String>
4 dup
5 iconst_0
6 ldc #5 <hello>
8 aastore
9 dup
10 iconst_1
11 ldc #6 <world>
13 aastore
14 invokestatic #7 <heima/candy/Candy4.foo>
17 return

 */


