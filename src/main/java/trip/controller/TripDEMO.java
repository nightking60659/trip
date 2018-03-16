package trip.controller;




import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trip.DAO.TripDAO;
import trip.model.TripBean;


@WebServlet("/TripDEMO2")
public class TripDEMO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String TripDBString;
	@Override
	public void init() throws ServletException {
		
		TripDBString = getInitParameter("DBString");
	}
	
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String> errorMessage=new HashMap<String,String>();
		request.setAttribute("ErrorMsg", errorMessage);
		
		request.setCharacterEncoding("UTF-8");
		
		String tno=request.getParameter("tripno");
//		if(tno==null||tno.trim().length()==0) {
//			errorMessage.put("no", "地區必須選擇");
//		}
		String place=request.getParameter("tripplace");
//		if(place==null||tno.trim().length()==0) {
//			errorMessage.put("place", "地區必須選擇");
//		}
		String name=request.getParameter("tripname");
//		if(name==null||name.trim().length()==0) {
//			errorMessage.put("name", "標題必須輸入");
//		}
		String tdate=request.getParameter("tripdate");
//		Date date=Date.valueOf(tdate);
		String type=request.getParameter("triptype");
//		if(type==null) {
//			errorMessage.put("type", "請選擇分類");
//		}
		
		String main= request.getParameter("tripmain");
//		if(main==null) {
//			errorMessage.put("main","請輸入內容");
//		}
//		String image = request.getParameter("trippic");
		
		Timestamp ts=new Timestamp(System.currentTimeMillis());
	
	if(!errorMessage.isEmpty()) {
		RequestDispatcher rd= request.getRequestDispatcher("/createtrip.jsp");
		rd.forward(request, response);
		return;
	}
		TripBean tb = new TripBean(tno,place,name,tdate,type,main,ts);
		try {
		
		TripDAO tdb=new TripDAO();
			tdb.insertTrip(tb);
			
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
