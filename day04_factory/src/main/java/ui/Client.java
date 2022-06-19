package ui;


import service.IAccountService;
import factory.factory;

public class Client {

    public static void main(String[] args) {
        for(int i =0;i<5;i++){
            IAccountService as = (IAccountService) factory.getBean("IAccountService");
            System.out.println(as);
            as.findAll();
        }

    }



}
