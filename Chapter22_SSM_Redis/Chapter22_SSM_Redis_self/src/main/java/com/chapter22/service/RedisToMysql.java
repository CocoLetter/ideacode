package com.chapter22.service;

public interface RedisToMysql {

	/**
	 * ����redis������б�
	 * @param redPacketId --��������
	 * @param unitAmount -- ������
	 */
	public void redisToMysql(Long redPacketId, Double unitAmount);
}
