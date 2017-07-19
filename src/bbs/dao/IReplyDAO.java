package bbs.dao;

import java.util.List;

import bbs.entity.Reply;

public interface IReplyDAO {

	public boolean addReply(Reply reply); // ��������

	public boolean deleteReply(int replyId); // ɾ������

	public boolean updateReply(Reply reply); // �޸Ļ���

	public Reply findReplyById(int replyId); // ����id���һ���

	public List<Reply> findReplyList(int page, int topicId); // ��ѯ������ػ����б�

	public int findCountReply(int topicId); // ������ػ�����
}
