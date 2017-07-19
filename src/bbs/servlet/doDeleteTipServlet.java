package bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.biz.*;

@SuppressWarnings("serial")
public class doDeleteTipServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");

		int boardId = Integer.valueOf(request.getParameter("boardId")); //�����ֳ�
		int topicId = Integer.valueOf(request.getParameter("topicId")); //�����ֳ�
		int replyId = Integer.valueOf(request.getParameter("replyId"));
		
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		if (replyId == -1) {
			String href = String.format("toTopicListServlet?page=1&boardId=%d", boardId);
			
			TopicBiz topicBiz = new TopicBiz();
			
			if (topicBiz.deleteTopic(topicId)) {
				out.println("<script>window.alert('����ɾ���ɹ�');window.location.href='"+ href + "'</script>");
			} else {
				out.println("<script>window.alert('����ɾ��ʧ��');window.location.href='"+ href + "'</script>");
			}
		} else {
			String href = String.format("toTopicDetailServlet?page=1&boardId=%d&topicId=%d",boardId, topicId);
			
			ReplyBiz replyBiz = new ReplyBiz();
			
			if (replyBiz.deleteReply(replyId)) {
				out.println("<script>window.alert('����ɾ���ɹ�');window.location.href='"+ href + "'</script>");
			} else {
				out.println("<script>window.alert('����ɾ��ʧ��');window.location.href='"+ href + "'</script>");
			}
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

		
	}

}
