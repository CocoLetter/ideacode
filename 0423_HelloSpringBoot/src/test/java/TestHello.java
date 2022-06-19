import java.io.UnsupportedEncodingException;

public class TestHello {


    public static void main(String[] args) throws UnsupportedEncodingException {
        String yan = "严";
        byte[] bs=yan.getBytes("UTF-8");
        for(byte i : bs){
            System.out.println(i);
        }

    }
}
