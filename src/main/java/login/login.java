package login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		
		System.out.println(session);
		Map<String,String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsgMap", errorMsg);
		
		String userId=request.getParameter("userId");
		String password= request.getParameter("pswd");
		String requestURI=(String)session.getAttribute("requestURI");
		System.out.println(requestURI);
		//驗證
		if(userId==null||userId.length()==0) {
			errorMsg.put("AccountError","請輸入帳號" );
		}
		if(password==null||password.length()==0) {
			errorMsg.put("passwordError","請輸入密碼" );
		}
		if(!errorMsg.isEmpty()) {
			RequestDispatcher rd=request.getRequestDispatcher("/login/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		loginService  ls =new loginService();
		MemberBean mb=null;
		try {
			mb=ls.checkIdPassword(userId, password);
			if(mb!=null) {
				session.setAttribute("LoginOK", mb);
			}else {
				errorMsg.put("loginError", "帳號密碼錯誤");
				
			}
		}catch(RuntimeException e) {
			
		}
		
		if(!errorMsg.isEmpty()) {
			RequestDispatcher rd=request.getRequestDispatcher("/login/login.jsp");
			rd.forward(request, response);
			return;
		}
		if(requestURI !=null) {
		
			requestURI=(requestURI.length()==0?request.getContextPath() : requestURI);
		response.sendRedirect(response.encodeRedirectURL(requestURI));	
		return;
		}else {
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
		return;
		}
//		RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
//		rd.forward(request, response);
//		return;
	}

}
