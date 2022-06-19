package com.chapter22.dao;

import com.chapter22.pojo.UserRedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRedPacketDao {

    //save user red packets information
    public int grapRedPacket(UserRedPacket userRedPacket);
}
