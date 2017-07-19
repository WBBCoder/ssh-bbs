package bbs.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import bbs.dao.IBaseDAO;
import bbs.dao.ITopicDAO;
import bbs.entity.Topic;

public class TopicDAO extends BaseHibernateDAO implements ITopicDAO {
	IBaseDAO baseDAO = new BaseDAO();

	public int findCountTopic(int boardId) {
		Session session = super.getSession();
		Criteria criteria = session.createCriteria(Topic.class);
		criteria.add(Restrictions.eq("boardId", boardId));//��ѯ����������boardId
		criteria.setProjection(Projections.rowCount());//ͳ�Ƽ�¼����
		Integer result = (Integer) criteria.uniqueResult();
		return result.intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Topic> findTopicList(int page, int boardId) {
		Session session = super.getSession();
		Criteria criteria = session.createCriteria(Topic.class);
		int rowBegin = 0; // ��ʼ��������ʾÿҳ��һ����¼�����ݿ��е�����
		if (page > 1) {
			rowBegin = (page - 1) * 10; // ��ҳ��ȡ�ÿ�ʼ����������ÿҳ����ʾ10����¼
		}
		criteria.setFirstResult(rowBegin);	//ȡ��һ����¼��������λ��
		criteria.setMaxResults(10);			//ȡ��¼������
		criteria.add(Restrictions.eq("boardId", boardId));//��ѯ����������boardId
		criteria.addOrder(Order.desc("publishTime")); //����������������
		return criteria.list();
	}

	public Topic findTopicById(int topicId) {
		return (Topic) super.findById(Topic.class, topicId);
	}

	public boolean addTopic(Topic topic) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		topic.setPublishTime(time);
		topic.setModifyTime(time);
		return super.add(topic);
	}

	public boolean deleteTopic(int topicId) {
		
		return super.delete(Topic.class, topicId);
	}

}
