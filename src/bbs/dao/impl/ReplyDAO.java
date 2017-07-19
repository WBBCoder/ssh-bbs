package bbs.dao.impl;

import java.sql.Timestamp;
import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import bbs.dao.IBaseDAO;
import bbs.dao.IReplyDAO;
import bbs.entity.Reply;

public class ReplyDAO extends BaseHibernateDAO implements IReplyDAO {
	IBaseDAO baseDAO = new BaseDAO();

	public int findCountReply(int topicId) {
		Session session = super.getSession();
		Criteria criteria = session.createCriteria(Reply.class);
		criteria.add(Restrictions.eq("topicId", topicId));//��ѯ����������topicId
		criteria.setProjection(Projections.rowCount());//ͳ�Ƽ�¼����
		Integer result = (Integer) criteria.uniqueResult();
		return result.intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Reply> findReplyList(int page, int topicId) {
		Session session = super.getSession();
		Criteria criteria = session.createCriteria(Reply.class);
		int rowBegin = 0; // ��ʼ��������ʾÿҳ��һ����¼�����ݿ��е�����
		if (page > 1) {
			rowBegin = (page - 1) * 10; // ��ҳ��ȡ�ÿ�ʼ����������ÿҳ����ʾ10����¼
		}
		criteria.setFirstResult(rowBegin);	//ȡ��һ����¼��������λ��
		criteria.setMaxResults(10);			//ȡ��¼������
		criteria.add(Restrictions.eq("topicId", topicId));//��ѯ����������topicId
		criteria.addOrder(Order.desc("publishTime")); //����������������
		return criteria.list();
	}

	public Reply findReplyById(int replyId) {
		return (Reply) super.findById(Reply.class, replyId);
	}

	public boolean addReply(Reply reply) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		reply.setModifyTime(time);
		reply.setPublishTime(time);
		return super.add(reply);
	}

	public boolean updateReply(Reply reply) {
		Reply temp = (Reply) this.findReplyById(reply.getReplyId());
		temp.setModifyTime(new Timestamp(System.currentTimeMillis()));
		temp.setContent(reply.getContent());
		temp.setTitle(reply.getTitle());
		return super.update(temp);
	}

	public boolean deleteReply(int replyId) {
		
		return super.delete(Reply.class, replyId);
	}

}
