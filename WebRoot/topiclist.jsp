<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@page import="bbs.entity.*"%>
<%@page import="bbs.biz.*"%>
<%@page import="java.util.*"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
	<HEAD>
		<TITLE>���ݿ�ó��̳--�����б�</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=GBK">
		<Link rel="stylesheet" type="text/css" href="style/style.css" />
	</HEAD>

	<BODY>
	<html:errors property="TipInfo"/>
		<center>
			<div id="content">
				<DIV>
					<IMG src="image/logo.gif" width="100%" height="100">
				</DIV>
				<!--      �û���Ϣ����¼��ע��        -->

				<%@include file="pageheader.jsp"%>
				<bean:define id="board" name="tipForm" property="board"/>
				
				<!--      ����        -->
				<DIV>
					<!--      ����        -->
					<br />
					<DIV align="left">
						<div style="float: left; padding-top: 6px;">
							&gt;&gt;
							<B><a href="index.jsp">��̳��ҳ</a> </B>&gt;&gt;
							<B><A
								href="tip.do?op=toTopicList&page=1&board.boardId=<bean:write name='board' property='boardId'/>">
								<bean:write name='board' property='boardName'/></A>
							</B>
						</div>

						<!--      ����        -->
						
						<logic:present name="LoginedUser" scope="session">
						<DIV align="right" style="float: right">
							<p>
								<A href="tip.do?op=toNewTip&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=-1">
								<IMG src="image/newTopic.gif" name="newTopic" border="0" id="newTopic"> </A>
							</p>
						</DIV>
						</logic:present>						
						<logic:notPresent name="LoginedUser" scope="session">
						<DIV align="right" style="float: right">
							<p>
								<img alt="newTopic" id="newTopic" name="neiTopic"
									src="image/newTopic.gif"
									onclick="javascript:window.alert('�㻹δ��¼�����ܷ���')">
							</p>
						</DIV>
						</logic:notPresent>
												
					</DIV>
					<br />

					<DIV class="t">
						<TABLE cellSpacing="0" cellPadding="0" width="100%">
							<TR>
								<TH class="h" style="WIDTH: 100%" colSpan="4">
									<SPAN>&nbsp;</SPAN>
								</TH>
							</TR>
							<!--       �� ͷ           -->
							<TR class="tr2">
								<TD>
									&nbsp;

								</TD>
								<TD style="WIDTH: 80%" align="center">
									����
								</TD>
								<TD style="WIDTH: 10%" align="center">
									����
								</TD>
								<TD style="WIDTH: 10%" align="center">
									�ظ�
								</TD>
							</TR>
							<!--         �� �� �� ��        -->						
							
						<logic:iterate id="topicBean" name="topicList" scope="request">											
								<TR class="tr3">
								<TD>
									<IMG src="image/topic.gif" border=0>
								</TD>
								<TD style="FONT-SIZE: 15px">
									<A
										href="tip.do?op=toTopicDetail&page=1&board.boardId=<bean:write name='board' property='boardId'/>&topic.topicId=<bean:write name='topicBean' property='topic.topicId'/>">
										<bean:write name="topicBean" property="topic.title"/></A>
								</TD>
								<TD align="center">
									<bean:write name="topicBean" property="user.userName"/>
								</TD>
								<TD align="center">
									<bean:write name="topicBean" property="replyCount"/>
								</TD>
							</TR>							
						</logic:iterate>	
						
						</TABLE>
					</DIV>
				</DIV>
				<!--            �� ҳ          -->
				<DIV align="right">
				<bean:define id="currPage" name="tipForm" property="page"/>
				<bean:define id="pageCount" name="tipForm" property="pageCount"/>
				<logic:equal value="1" name="currPage">
					<span style="color: gray;">��һҳ</span>				
				</logic:equal>
				
				<logic:greaterThan value="1" name="currPage">
					<a href="tip.do?op=toTopicList&page=${currPage-1}&board.boardId=<bean:write name='board' property='boardId'/>">��һҳ</a>
				</logic:greaterThan>						
						
				<logic:equal value="${tipForm.pageCount}" name="currPage">
					<span style="color: gray;">��һҳ</span>
				</logic:equal>			
				
				<logic:lessThan value="${tipForm.pageCount}" name="currPage">
					<a href="tip.do?op=toTopicList&page=${currPage+1}&board.boardId=<bean:write name='board' property='boardId'/>">��һҳ</a>
				</logic:lessThan>					
				<span>&nbsp;��ǰ��&nbsp;${currPage}&nbsp;ҳ����&nbsp;${pageCount}&nbsp;ҳ&nbsp;</span>
				<span><input id=yeshu style="width: 15px" type="text" value="${currPage}" />&nbsp;<input type="button" value="��ת" onclick="tzym()"/> </span>
				<script type="text/javascript">
					function tzym(){
						/*var reg=new RegExp("^[0-9]*$");*/						
						ys = document.getElementById("yeshu").value;
						if(ys>${pageCount} || ys<=0){
							alert("�����ڸ�ҳ��");
							ys = ${currPage};
						}
						window.location.href="tip.do?op=toTopicList&page="+ys+"&board.boardId=<bean:write name='board' property='boardId'/>";
					}
				</script>
				</DIV>
				<!--             �� ��          -->
				<BR />
				<%@include file="pagefooter.jsp"%>
			</div>
		</center>

	</BODY>
</HTML>