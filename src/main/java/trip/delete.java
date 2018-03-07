package trip;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("tripno");
		TripDAO tdb= new TripDAO();
		tdb.delete(no);
		
		RequestDispatcher rd = request.getRequestDispatcher("/SucessDelete.jsp");
		rd.forward(request, response);
	}

}
