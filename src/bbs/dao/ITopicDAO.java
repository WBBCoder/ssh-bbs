package bbs.dao;

import java.util.List;

import bbs.entity.Topic;

public interface ITopicDAO {

	public boolean addTopic(Topic topic); // ��������

	public boolean deleteTopic(int topicId); // ɾ������

	public Topic findTopicById(int topicId); // ����id��������

	public List<Topic> findTopicList(int page, int boardId); // ��ѯ�����������б�

	public int findCountTopic(int boardId); // ������������
}
