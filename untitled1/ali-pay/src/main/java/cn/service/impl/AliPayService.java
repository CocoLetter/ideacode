package cn.service.impl;

import cn.service.interfaces.PayService;

public class AliPayService implements PayService {
    @Override
    public void pay() {
        System.out.println("Ali - pay");
    }
}
