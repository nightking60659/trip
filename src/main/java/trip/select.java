package trip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trip.DAO.TripDAO;
import trip.model.TripBean;

/**
 * Servlet implementation class select
 */
@WebServlet("/select")
public class select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		String no = request.getParameter("tripno");
		
		
		TripDAO tdb = new TripDAO();
		TripBean tb=tdb.select(no);
		
		request.setAttribute("tripbean",tb);
		String type =tb.getType();
		String image=tb.getImage();
		String saveDir=getServletContext().getRealPath("/")+"images/clients/"+type+"/";
		FileInputStream is = new FileInputStream(saveDir+image);
		OutputStream os=response.getOutputStream();
		
		int len=0;
		byte[] b= new byte[8192];
		while((len=is.read(b))!=-1) {
			os.write(b,0,len);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/selectanddelete.jsp");
		rd.forward(request, response);
	}

}
