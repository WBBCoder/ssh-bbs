<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
	<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
	<head>
		<title>���ݿ�ó��̳--ע��</title>
		<meta http-equiv="content-type" content="text/html; charset=GBK">
		<link rel="stylesheet" type="text/css" href="style/style.css">
		<style type="text/css">
			table {
				font-size: "12px";
			}
		</style>
	</head>
	
	<body>
		<center>
			<div id="content">
				<div style="height: 100%">
					<div style="height: 10%">
						<img src="image/logo.gif" width="100%" height="100">
					</div>
					<%@include file="pageheader.jsp"%>
					<div style="height: auto;">
						<FORM name="registerForm" action="user.do?op=doRegister"
							method="post">
							<table class="t" style="width: 100%">
								<tr height="30px">
									<td align="right" style="width: 40%">
										�� �� ����
									</td>
									<td style="width: 50%;" align="left">
										<INPUT class="input" tabIndex="1" type="text" maxLength="20"
											size="40" name="userName" id="userName" style="width: 350px">
									</td>
								</tr>
								<tr height="30px">
									<td align="right" style="width: 40%">
										��&nbsp;&nbsp;�룺
									</td>
									<td style="width: 50%" align="left">
										<INPUT class="input" tabIndex="2" type="password"
											maxLength="20" size="40" name="userPwd" style="width: 350px">
									</td>
								</tr>
								<tr height="30px">
									<td align="right" style="width: 40%">
										�ظ����룺
									</td>
									<td style="width: 50%" align="left">
										<INPUT class="input" tabIndex="2" type="password"
											maxLength="20" size="40" name="userRePwd"
											style="width: 350px">
									</td>
								</tr>
								<tr height="30px">
									<td align="right" style="width: 40%">
										��&nbsp;&nbsp;��
									</td>
									<td style="width: 50%" align="left">
										<INPUT type="radio" id="male" name="gender" checked="checked">
										��
										<INPUT type="radio" id="female" name="gender">
										Ů
									</td>
								</tr>
								<tr height="30px">
									<td align="right" style="width: 40%">
										ѡ��ͷ��
									</td>
									<td align="left">
										<img src="image/heads/1.bmp" />
										<input type="radio" name="head" value="1.bmp"
											checked="checked">
										<img src="image/heads/2.bmp" />
										<input type="radio" name="head" value="2.bmp">
										<img src="image/heads/3.bmp" />
										<input type="radio" name="head" value="3.bmp">
										<img src="image/heads/4.bmp" />
										<input type="radio" name="head" value="4.bmp">
										<img src="image/heads/5.bmp" />
										<input type="radio" name="head" value="5.bmp">
										<BR />
										<img src="image/heads/6.bmp" />
										<input type="radio" name="head" value="6.bmp">
										<img src="image/heads/7.bmp" />
										<input type="radio" name="head" value="7.bmp">
										<img src="image/heads/8.bmp" />
										<input type="radio" name="head" value="8.bmp">
										<img src="image/heads/9.bmp" />
										<input type="radio" name="head" value="9.bmp">
										<img src="image/heads/10.bmp" />
										<input type="radio" name="head" value="10.bmp">
										<BR />
										<img src="image/heads/11.bmp" />
										<input type="radio" name="head" value="11.bmp">
										<img src="image/heads/12.bmp" />
										<input type="radio" name="head" value="12.bmp">
										<img src="image/heads/13.bmp" />
										<input type="radio" name="head" value="13.bmp">
										<img src="image/heads/14.bmp" />
										<input type="radio" name="head" value="14.bmp">
										<img src="image/heads/15.bmp" />
										<input type="radio" name="head" value="15.bmp">
										<BR />
									</td>
								</tr>
								<tr height="30px">
								<html:errors property="RegisterInfo"/>
									<td colspan="2" align="center">
										<INPUT class="btn" tabIndex="16" type="submit" value="ע  ��">
										&nbsp;&nbsp;
										<INPUT class="btn" tabIndex="16" type="reset" value="��  ��">
									</td>
								</tr>

							</table>
						</FORM>
					</div>
					<%@include file="pagefooter.jsp"%>
				</div>
			</div>
		</center>
	</body>
</html>