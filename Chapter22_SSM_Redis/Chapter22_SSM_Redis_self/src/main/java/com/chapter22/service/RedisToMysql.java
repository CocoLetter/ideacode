package com.chapter22.service;

public interface RedisToMysql {

	/**
	 * 保存redis抢红包列表
	 * @param redPacketId --抢红包编号
	 * @param unitAmount -- 红包金额
	 */
	public void redisToMysql(Long redPacketId, Double unitAmount);
}
