package _trip.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

import _trip.DAO.TripDAO;
import _trip.DAO.TripDAOI;
import _trip.model.TripBean;


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
//		String memberid = request.getParameter("memberid");
		
//		memberid="1";
		TripDAOI tdo = new TripDAO();
//		if(memberid!=null) {
//
//		TripBean bean= tdo.select(memberid);
//		HashMap<String, String> h1 = new HashMap<>();
//		h1.put("memberid", bean.getMemberid());
//		h1.put("viewid",bean.getViewid());
//		h1.put("viewname",bean.getName());
//		h1.put("viewaddress",bean.getAddress());
//		h1.put("web",bean.getWeb());
//		h1.put("phone", bean.getPhone());
//		h1.put("ViewMain", bean.getMain());
//		
//		
//		String json = JSONValue.toJSONString(h1);
//		out.println(json);
//		}
//		if(memberid==null) {
			
			LinkedList<HashMap<String, String>> bean= tdo.select();
			String json = JSONValue.toJSONString(bean);
			out.println(json);
		}
//	}

	
	

}
