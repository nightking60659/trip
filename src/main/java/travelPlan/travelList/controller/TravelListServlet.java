package travelPlan.travelList.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelPlan.travelList.Dao.TravelListDao;
import travelPlan.travelList.model.TravelListBean;

public class TravelListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("MsgMap", "erroMsg");
		Map<String, String> msgOK = new HashMap<String, String>();
		request.setAttribute("MsgOK", "msgOK");

		String viewName = request.getParameter("viewName");
		 java.sql.Date  StartTime = java.sql.Date.valueOf(request.getParameter("StartTime"));
		 java.sql.Date  endTime=java.sql.Date.valueOf(request.getParameter("endTime"));
		 String tripType=request.getParameter("tripType");
		 String tripname=request.getParameter("tripname");
		 int tripid=Integer.parseInt(request.getParameter("tripid"));
		 int tripday=Integer.parseInt(request.getParameter("tripday"));
		 int viewid=Integer.parseInt(request.getParameter("viewid"));
		 
		 //驗證
		 
		 //service
		 
		 //DAO
		 TravelListBean bean = new TravelListBean(viewName, StartTime, endTime, tripType, tripname, tripid, tripday, viewid);
		 TravelListDao dao = new TravelListDao();
		 bean =dao.insert(bean);
		 
		 msgOK.put("insertOK", "新增成功");
		 request.setAttribute("bean", bean);
		 response.sendRedirect("index.jsp");
		 return;
		 
		 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
