package chapter22.service;

import chapter22.pojo.RedPacket;

public interface RedPacketService {
	
	/**
	 * ��ȡ���
	 * @param id �������
	 * @return �����Ϣ
	 */
	public RedPacket getRedPacket(Long id);

	/**
	 * �ۼ����
	 * @param id�������
	 * @return Ӱ������.
	 */
	public int decreaseRedPacket(Long id);
	
}