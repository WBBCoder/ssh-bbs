/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package bbs.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import bbs.biz.BoardBiz;
import bbs.biz.ReplyBiz;
import bbs.biz.TopicBiz;
import bbs.struts.form.TipForm;

/** 
 * MyEclipse Struts
 * Creation date: 10-24-2016
 * 
 * XDoclet definition:
 * @struts.action path="/toModifyReplyAction" name="tipForm" scope="request"
 */
public class ToModifyReplyAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TipForm tipForm = (TipForm) form;

		
		BoardBiz boardBiz = new BoardBiz();		
		TopicBiz topicBiz = new TopicBiz();		
		ReplyBiz replyBiz = new ReplyBiz();
		
		tipForm.setBoard(boardBiz.findBoardById(tipForm.getBoard().getBoardId()));
		tipForm.setReply(replyBiz.findReplyById(tipForm.getReply().getReplyId()));
		tipForm.setTopic(topicBiz.findTopicById(tipForm.getTopic().getTopicId()));
		
		return mapping.findForward("modifyReply");
		
	}
}