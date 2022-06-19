package com.proxy;

public class DogOne implements Dog {
    @Override
    public void run() {
        System.out.println("DogOne is running");
    }
    public void sleep(String word){
        System.out.println("DogOne is sleeping");
        System.out.println("it says "+word);
    }
}
