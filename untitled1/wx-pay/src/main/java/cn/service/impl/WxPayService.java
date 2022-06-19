package cn.service.impl;

import cn.service.interfaces.PayService;

class WxPayService implements PayService {
    @Override
    public void pay() {
        System.out.println("Wx - pay");
    }
}
