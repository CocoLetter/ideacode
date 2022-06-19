package com.company;

public class Main {



    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
	// write your code here

//        new JavaDynamicProxy()

//        Main.class.getClassLoader().forNam
        //com/company/NotNull.java

        NotNull heihei = (NotNull) Class.forName("com.company.NotNull").newInstance();
        heihei.newProxyInstance("liusheng");
//        Main.get
                //.getClassClass.forName("NotNull").newInstance();



    }
}
