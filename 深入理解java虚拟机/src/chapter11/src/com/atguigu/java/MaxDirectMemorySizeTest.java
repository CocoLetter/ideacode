/*
package chapter11.src.com.atguigu.java;





import java.lang.reflect.Field;

*/
/**
 * -Xmx20m -XX:MaxDirectMemorySize=10m
 * @author shkstart  shkstart@126.com
 * @create 2020  0:36
 *//*



*/
/**
 * -Xmx20m -XX:MaxDirectMemorySize=10m
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
 * 	at java.nio.Bits.reserveMemory(Bits.java:694)
 * 	at java.nio.DirectByteBuffer.<init>(DirectByteBuffer.java:123)
 * 	at java.nio.ByteBuffer.allocateDirect(ByteBuffer.java:311)
 * 	at chapter11.src.com.atguigu.java.BufferTest.main(BufferTest.java:20)
 *//*

public class MaxDirectMemorySizeTest {
    private static final long _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        int count = 0;
        while(true){
            unsafe.allocateMemory(_1MB);
            System.out.println(++count);//19061//19049
        }

    }
}
*/
