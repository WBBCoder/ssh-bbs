package bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.biz.*;
import bbs.entity.*;

@SuppressWarnings("serial")
public class doRegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");

		UserBiz userBiz = new UserBiz();
		String userName = request.getParameter("userName");
		
		PrintWriter out = response.getWriter();
		
		if (userBiz.isExistUser(userName)) {
			out.println("<script>window.alert('�û����Ѿ����ڣ�����������');history.back(-2);</script>");
		} else {
			String userPwd = request.getParameter("userPwd");
			boolean gender = Boolean.valueOf(request.getParameter("gender"));
			String head = request.getParameter("head");

			User regUser = new User();
			regUser.setGender(gender);
			regUser.setHead(head);
			regUser.setUserName(userName);
			regUser.setUserPwd(userPwd);

			if (userBiz.addUser(regUser)) {
				request.getRequestDispatcher("doLoginServlet").forward(request, response); //ת��
			} else {
				out.println("<script>window.alert('ע��ʧ�ܣ������µ�½');history.back(-2);</script>");
				response.sendRedirect("");
			}
		}
		
	}

}
