import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Person  implements PersonBeharvior{
    public static void main(String[] args) {
        Person person = new Person();
        LanguageBeharvior lang =(LanguageBeharvior) person;
        lang.language();
    }

    public void language() {
        System.out.println("language");

    }

    public void speak() {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.peek();
        System.out.println("speak");

        ArrayList<Object> objects = new ArrayList<>();
        Object remove = objects.remove(0);

    }
}




 interface LanguageBeharvior {
     public void language();
 }


  interface SpeakBeharvior {
     public void speak();
 }
 interface PersonBeharvior  extends LanguageBeharvior,SpeakBeharvior{
 }

