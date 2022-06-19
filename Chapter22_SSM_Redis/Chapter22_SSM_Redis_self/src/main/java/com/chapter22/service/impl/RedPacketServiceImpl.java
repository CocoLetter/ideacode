package com.chapter22.service.impl;

import com.chapter22.dao.RedPacketDao;
import com.chapter22.pojo.RedPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RedPacketServiceImpl implements RedPacketDao {

    @Autowired
    RedPacketDao redPacketDao = null;

    @Override
    @Transactional(isolation= Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public RedPacket getRedPackage(Long id) {


        return redPacketDao.getRedPackage(id);
    }

    @Override
    @Transactional(isolation=Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int decreaseRedPackage(Long id) {
        return redPacketDao.decreaseRedPackage(id);
    }
}
