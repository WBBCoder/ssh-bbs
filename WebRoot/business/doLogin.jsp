<%@ page language="java" import="java.util.*,bbs.entity.*,bbs.biz.*" pageEncoding="gbk"%>


<%
	request.setCharacterEncoding("gbk");
	response.setCharacterEncoding("gbk");
	
	String userName = request.getParameter("userName");//��ȡ�û���
	String userPwd = request.getParameter("userPwd");// ��ȡ����
	
	UserBiz userBiz = new UserBiz();
	User user = userBiz.doLogin(userName,userPwd);
	if(user!=null){
		session.setAttribute("LoginedUser",user);
		response.sendRedirect("../index.jsp");
	}else{
		//out.println("<script>window.alert('�û���������������������룡');window.location.href='../login.jsp';</script>");
		out.println("<script>window.alert('�û���������������������룡');history.back(-2);</script>");
	}
%>