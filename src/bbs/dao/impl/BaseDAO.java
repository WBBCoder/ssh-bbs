package bbs.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bbs.dao.IBaseDAO;

public class BaseDAO implements IBaseDAO {

	private static Connection connection = null; // ���ݿ����Ӷ���
	private static ResultSet rs = null; // ���ݿ��ѯ�����
	private static PreparedStatement pstmt = null; // ���ݿ��������

	// �������ݿ�����
	public Connection getConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				closeDB();
			}
			Class.forName(SQLDRIVER); // ע������
			connection = DriverManager.getConnection(URL, DBNAME, DBPASSWORD); // ��ȡ���ݿ�����

		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ����������ʧ�ܣ�");
		} catch (SQLException e) {
			System.out.println("���ݿ������쳣!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ϵͳ�����쳣!");
			e.printStackTrace();
		}
		return connection;
	}

	// �ر����ݿ�����
	public void closeDB() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("���ݿ������쳣!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ϵͳ�����쳣!");
			e.printStackTrace();
		}
	}

	// ���ݿ��ѯ
	public ResultSet findDB(String sql, String[] param) {
		try {
			connection = getConnection(); // ��ȡ���Ӷ���
			pstmt = connection.prepareStatement(sql); // �õ�һ��PreparedStatement����
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]); // ����SQL��ѯ����
				}
			}
			rs = pstmt.executeQuery(); // ִ��SQL����ȡ��ѯ�����
		} catch (SQLException e) {
			System.out.println("���ݿ������쳣!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ϵͳ�����쳣!");
			e.printStackTrace();
		}
		return rs;
	}

	// ���ݿ����
	public boolean updateDB(String sql, String[] param) {
		boolean updated = false;
		try {
			connection = getConnection(); // ��ȡ���Ӷ���
			pstmt = connection.prepareStatement(sql); // �õ�һ��PreparedStatement����
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]); // ����SQL��ѯ����
				}
			}
			if (pstmt.executeUpdate() > 0) { // ִ�����ݿ����
				updated = true;
			}
		} catch (SQLException e) {
			System.out.println("���ݿ������쳣!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ϵͳ�����쳣!");
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return updated;
	}
}
