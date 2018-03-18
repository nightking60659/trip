package trip;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

import trip.DAO.TripDAO;


/**
 * Servlet implementation class select
 */
@WebServlet("/select")
public class select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setHeader("Access-Control","*");
		response.setHeader("content-Type", "application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		
		TripDAO tdo = new TripDAO();
		LinkedList l1= tdo.select();
		String json = JSONValue.toJSONString(l1);
		out.println(json);
		
	}

	
	

}
