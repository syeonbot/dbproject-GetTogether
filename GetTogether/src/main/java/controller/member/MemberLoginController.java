package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Member;
import model.service.MemberManager;

public class MemberLoginController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String memberId = request.getParameter("memberId");
		String passwd = request.getParameter("passwd");
		
		try {
			MemberManager.getInstance().login(memberId, passwd);
			
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberId);
			
			MemberManager manager = MemberManager.getInstance();
			Member member = manager.findMemberByMid(memberId);
			
			session.setAttribute("mnum", member.getMnum());
			
			return "redirect:/";
		}
		catch(Exception e){
			request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
			e.printStackTrace();
			
			return "redirect:/member/login/form";
		}
	}
}
