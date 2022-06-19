package list;

import java.util.ArrayList;

public class ArrayList0623 {
    public static void test(ArrayList input){
        input.set(2, 0);
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(3);
        strings.add("1");
        strings.add("2");
        strings.add("3");
        System.out.println(strings.size());
        test(strings);
        System.out.println(strings);

        String s =null;
        System.out.println(
                s==null
        );

    }



}

