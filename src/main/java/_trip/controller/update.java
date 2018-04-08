package _trip.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _trip.DAO.MemberDao;
import _trip.DAO.TripDAO;
import _trip.model.MemberBean;
import _trip.model.TripBean;


@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,String> errorMessage=new HashMap<String,String>();
		request.setAttribute("ErrorMsg", errorMessage);
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		
		String memeberid = mb.getMid();
		TripDAO td = new TripDAO();
		TripBean bean = td.select(memeberid);
		
		
		
		
		
		Timestamp ts=new Timestamp(System.currentTimeMillis());
	
	if(!errorMessage.isEmpty()) {
		RequestDispatcher rd= request.getRequestDispatcher("/createtrip.jsp");
		rd.forward(request, response);
		return;
	}
		TripBean tb = new TripBean(memberid, viewid, name, address, web, phone, main, imagename, tdate);
		try {
		
		TripDAO tdb=new TripDAO();
			tdb.updateTrip(tb);
		request.setAttribute("tripBean", tb);
		RequestDispatcher rd = request.getRequestDispatcher("/Sucess.jsp");
		rd.forward(request, response);

		} catch (SQLException e) {
//			e.getMessage().indexOf("重複索引鍵")!=-1||
			e.printStackTrace();
			errorMessage.put("exception", "資料庫存取錯誤"+e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("/createtrip.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}


   
	


	

}
