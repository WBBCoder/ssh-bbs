<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK" import="bbs.biz.*,bbs.entity.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"  %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<DIV class="h">
	&nbsp;&nbsp;
	
	<logic:present name="LoginedUser" scope="session">
	<a href="index.jsp" class="A">��ҳ</a> | ����:<bean:write name="LoginedUser" property="userName" scope="session"/>��ӭ����
	|&nbsp;
	<a href="user.do?op=doLoginout">ע�� </a>
	</logic:present>
	
	<logic:notPresent name="LoginedUser" scope="session">
	<a href="index.jsp" class="A">��ҳ</a> | ����δ
	<a href="login.jsp" class="A">��¼</a> |
	<a href="register.jsp">ע�� </a>	
	</logic:notPresent>	
	
</DIV>