package cn.service.impl;

import cn.service.interfaces.PayService;

public class AliPayService1 implements PayService {
    @Override
    public void pay() {
        System.out.println("Ali - pay");
    }
}
