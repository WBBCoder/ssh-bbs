<%@ page language="java" import="java.util.*,bbs.entity.*,bbs.biz.*" pageEncoding="gbk"%>


<%
	request.setCharacterEncoding("gbk");
	response.setCharacterEncoding("gbk");
	
	UserBiz userBiz = new UserBiz();
	String userName = request.getParameter("userName");
	if(userBiz.isExistUser(userName)){
		out.println("<script>window.alert('�û����Ѿ����ڣ����������룡');history.back(-2);</script>");
		
	}else{
		String userPwd = request.getParameter("userPwd");
		boolean gender = Boolean.valueOf(request.getParameter("gender"));
		String head = request.getParameter("head");
		
		User regUser = new User();
		regUser.setGender(gender);
		regUser.setHead(head);
		regUser.setUserName(userName);
		regUser.setUserPwd(userPwd);
		
		if(userBiz.addUser(regUser)){
			request.getRequestDispatcher("doLogin.jsp").forward(request,response);//ת����¼
			
		}else{
			out.println("<script>window.alert('ע��ʧ�ܣ�������ע�ᣡ');history.back(-2);</script>");
		}
	}
	
%>