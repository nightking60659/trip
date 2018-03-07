package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberBean;


@WebServlet("/login/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String userId=request.getParameter("userId");
		String password= request.getParameter("pswd");
		
		loginService  ls =new loginService();
		MemberBean mb=null;
		try {
			mb=ls.checkIdPassword(userId, password);
			if(mb!=null) {
				session.setAttribute("LoginOK", mb);
			}else {
				
			}
		}catch(RuntimeException e) {
			
		}
		String contextPath = getServletContext().getContextPath();
		String target = (String)session.getAttribute("target");
		if(target!= null) {
			session.removeAttribute(target);
			response.sendRedirect(contextPath+target);
		}else {
			response.sendRedirect(contextPath+"/index.jsp");
		}
		return;
		
//		RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
//		rd.forward(request, response);
//		return;
	}

}
