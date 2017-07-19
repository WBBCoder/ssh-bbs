package bbs.dao;

import java.sql.*;

public interface IBaseDAO {

	public final static String SQLDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public final static String URL = "jdbc:sqlserver://localhost:1433;databaseName=bbs";
	public final static String DBNAME = "sa";
	public final static String DBPASSWORD = "123456";

	public Connection getConnection(); // �������ݿ�����

	public void closeDB(); // �ر����ݿ�����

	public ResultSet findDB(String sql, String[] param); // ���ݿ��ѯ

	public boolean updateDB(String sql, String[] param); // ���ݿ����
}
