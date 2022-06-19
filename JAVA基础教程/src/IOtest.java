import org.junit.Test;

import java.io.*;

public class IOtest {


    @Test
     public void ootest(){
         ObjectOutputStream oos = null;

         try {
             //1.
             oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
             //2.
             oos.writeObject(new String("我爱北京天安门"));
             oos.flush();//刷新操作

             oos.writeObject(new Person("王铭",23,1));
             oos.flush();


         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             if(oos != null){
                 //3.
                 try {
                     oos.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
         }
     }


    /*
   反序列化：将磁盘文件中的对象还原为内存中的一个java对象
   使用ObjectInputStream来实现
    */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);

            Person p = (Person) ois.readObject();
//            Person p1 = (Person) ois.readObject();

//            System.out.println(str);
            System.out.println(p);
//            System.out.println(p1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



    }



    @Test
    public void test1(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File("爱情与友情.jpg");
            File destFile = new File("爱情与友情3.jpg");
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);

                //BufferedOutputStream会在内部缓存区满了之后刷新缓存区，不然每次write都刷新，输出缓存流失去意义会影响性能。
                //                bos.flush();//刷新缓冲区

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
            //        fos.close();
            //        fis.close();
        }

    }

    public static void main(String[] args) throws IOException {
        FileInputStream fsI=null;
        FileOutputStream fsO=null;
        try {
            File file = new File("C:\\Users\\Desktop\\hehei.txt");
            File file1 = new File("new.txt");
            fsI=new FileInputStream(file);
            fsO=new FileOutputStream(file1);
            byte[] buffer=new byte[5];
            int len;
            while((len=fsI.read(buffer))!=-1){
                fsO.write(buffer,0,len);
            }
        } finally {
            if(fsI!=null)
            try {
                fsI.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(fsO!=null)
            try {
                fsO.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

