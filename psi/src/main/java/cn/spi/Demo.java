package cn.spi;

import java.util.ServiceLoader;

public class Demo {
    public static void main(String[] args) {
        ServiceLoader.load(PayService.class).forEach(PayService::pay);
    }
}
