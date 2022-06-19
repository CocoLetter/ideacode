package com.chapter22.dao;

import com.chapter22.pojo.RedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface RedPacketDao {


    //get redpacket information
    public RedPacket getRedPackage(Long  id);

    /**
     * decrease number of RedPacket
     * @param id
     * @return
     */

    public int decreaseRedPackage(Long id);



}
