package login;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import member.MemberBean;
import member.MemberDao;



@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/login/resign")
public class resign extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String memberid = "";
		String password = "";

		Collection<Part> parts = request.getParts();

		if (parts != null) {
			for (Part p : parts) {
				String fldname = p.getName();
				String value = request.getParameter(fldname);

				if (p.getContentType() == null) {
					if (fldname.equals("mid")) {
						memberid = value;
					} else if (fldname.equals("password")) {
						password = value;
					}
				}
			}
		}
		try {
			MemberDao md = new MemberDao();
			MemberBean mb = new MemberBean(memberid, password);
			int n = md.saveMember(mb);
			if (n == 1) {
				response.sendRedirect("/trip/index.jsp");
			}
//			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
//			rd.forward(request, response);
//			return;
		} catch (Exception e) {

		}
	}
}