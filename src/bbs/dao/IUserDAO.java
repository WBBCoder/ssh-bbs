package bbs.dao;

import bbs.entity.User;

public interface IUserDAO {

	public boolean addUser(User user); // �û�ע��

	public User findUserByUserId(int userId); // ����userid�����û�

	public User findUserByUserName(String userName); // �û���¼

}
