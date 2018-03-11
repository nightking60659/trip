package getsonView;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.simple.JSONValue;

/**
 * Servlet implementation class getView
 */
@WebServlet("/getView")
public class getView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Acess-Control-Allow-Origin","*");
		response.setHeader("content-type","application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs= null;
		Context ctx=null;
		DataSource ds = null;
		
		String sql = "select placeno,name,date,type,main,ImageName,tdate from trip where type=?";
		
		String sqlall = "select placeno,name,date,type,main,ImageName,tdate from trip";
		
		String type = request.getParameter("type");
		if(type==null) {
			sql=sqlall;
		}else {
			
		}
		try { 
			ctx= new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/tripDEMO");
		}catch(NamingException e) {
				e.printStackTrace();
		}
			
		try {
				conn=ds.getConnection();
				stmt=conn.prepareStatement(sql);
				stmt.setString(1, type);
				rs=stmt.executeQuery();
				
				LinkedList<HashMap<String,String>> l1=new LinkedList<HashMap<String,String>>();
				while(rs.next()) {
					HashMap<String, String> m1 = new HashMap<String,String>();
					m1.put("name", rs.getString("name"));
					m1.put("date",rs.getString("date"));
					m1.put("main",rs.getString("main"));
					m1.put("ImageName",rs.getString("ImageName"));
					m1.put("tdate",rs.getString("tdate"));
					l1.add(m1);
				}
				
				String jsonString = JSONValue.toJSONString(l1);
				out.print(jsonString);
		}catch(SQLException e) {
			out.println("Error:"+e.getMessage());
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException e) {
				
			}
		}
	

}
	}
