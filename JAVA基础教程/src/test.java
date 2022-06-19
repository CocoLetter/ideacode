import java.io.*;
import java.util.*;

;

class Father {

    int count = 100;

    public void display() {
        System.out.println(count);
    }
    protected void run(){
        System.out.println("run");
    }
}


class Son extends Father implements Cloneable {

    int i;
    Object o;
    int count = 200;

    public void display() {
        System.out.println(count);
    }



    public void sing(){
        System.out.println("sing");
        System.out.println(i);
        System.out.println(o);
    }


    public void test2(){
        FileInputStream fis = null;
        try {
            File file = new File("hello1.txt");
            fis = new FileInputStream(file);

            int data = fis.read();
            while(data != -1){
                System.out.print((char)data);
                data = fis.read();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

public class test {
    public static void main(String[] args) throws CloneNotSupportedException {
    /*   Son S = new Son();
        System.out.println(S.count);//200
        S.run();
//        System.out.println(son);

        S.display();//200
        System.out.println(S);//Son@2f4d3709

        Father f = S;
        System.out.println(f);//Son@2f4d3709
        System.out.println(S==f);//true
        System.out.println(f.count);//100

        f.display();//200

        Son s1=(Son) f;
        System.out.println(s1);

        char[] ch=new char[]{'A','B','C'};//ABC
        System.out.println(ch);
        int[] in=new int[]{1,2,2};
        System.out.println(in);//[I@4e50df2e
        double[] dou=new double[]{1.1,1.2,1.4};
        System.out.println(dou);//[D@1d81eb93

        Integer integer = 12;
        String string = integer+1+"";
        System.out.println(string);

        String dou1 = "1.23";

        Double v = Double.parseDouble(dou1);

        System.out.println("");
        Integer a=128;
        Integer b=128;
        System.out.println(a==b);
        Integer a1=1;
        Integer b1=1;
        System.out.println(a1==b1);
        int max=78;


        Son son = new Son();
        son.sing();

        Object  i = new Integer(12);
        Object  j = new Integer(12);
        int n= (Integer) i;
        System.out.println(n);
        Integer k=13;
        Integer m=13;
        System.out.println(k==m);
        System.out.println(i==j);
        int bloc=(int) i;
        System.out.println(bloc);

        String string1 = new String("abcdefg");

        String m1 = new String("abc");
        String m3 = new String("abc");
        String m2="abc";
        String m4="abc";
        System.out.println(m1.getBytes()+""+m3.getBytes());
        System.out.println(m2.getBytes()+""+m4.getBytes());
        System.out.println(m1==m2);
        System.out.println(m1.getBytes());
        System.out.println();
        System.out.println(m1.intern());


            String javaVersion = System.getProperty("java.version");
            System.out.println("java的version:" + javaVersion);

            String javaHome = System.getProperty("java.home");
            System.out.println("java的home:" + javaHome);

            String osName = System.getProperty("os.name");
            System.out.println("os的name:" + osName);

            String osVersion = System.getProperty("os.version");
            System.out.println("os的version:" + osVersion);

            String userName = System.getProperty("user.name");
            System.out.println("user的name:" + userName);

            String userHome = System.getProperty("user.home");
            System.out.println("user的home:" + userHome);

            String userDir = System.getProperty("user.dir");
            System.out.println("user的dir:" + userDir);


        List<Integer> integers = Arrays.asList(123, 12);
        Collection coll = new ArrayList();
        coll.add("hello");
        coll.add("hello");

        Iterator iter= coll.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        ArrayList<String> strings = new ArrayList<>();
        strings.add("abc");

        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("Liusheng");

        Integer inte=12123;
        System.out.println(inte.hashCode());
        String str="AA";
        String strB="BB";
        System.out.println(str.hashCode());
        System.out.println(strB.hashCode());




        HashSet set=new HashSet<>();
        set.add(new User("Aom",12));
        set.add(new User("Aom",12));
        set.add(new User("Berry",32));
        set.add(new User("Jim",2));
        set.add(new User("Cike",65));
        set.add(new User("Dack",33));
        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }



        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,1234);
        map.put("BB",56);
        //遍历所有的key集：keySet()
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        //遍历所有的value集：values()

        Collection values = map.values();//value作为结合子类有集合方法iterator
        Iterator iterator3 = values.iterator();
        while(iterator3.hasNext()){
            System.out.println(iterator3.next().getClass());
        }
        System.out.println();
        for(Object obj : values){
            System.out.println(obj);
        }
        System.out.println();
        //遍历所有的key-value
        //方式一：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + 		entry.getValue());

        }
        System.out.println();
        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "=====" + value);

        }

        List list = new ArrayList();
        list.add(12);
        list.add(23);
        list.add(345);
        list.add(56);
        List<Object> list2 = Arrays.asList(new Object[list.size()]);

        List list1 = Collections.synchronizedList(list2);



        Collections.copy(list2,list);
        System.out.println(list2);

        ArrayList arrayList = new ArrayList();
        arrayList.add(new User("lisi",1));
        arrayList.add(123);
        System.out.println(arrayList.get(1).getClass());


        List<? extends Person> list01 = null;
        List<? super Person> list02 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();
        list01=list3;
        list02=list4;
        list02.add(new Person());


        list01=list4;
        list02=list4;

        File file = new File("hello1.txt");
*/

    }

}


