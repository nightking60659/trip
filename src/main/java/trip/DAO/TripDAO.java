package trip.DAO;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.simple.JSONValue;

import trip.model.TripBean;





public class TripDAO {
	
	

	DataSource ds = null;

	public TripDAO(){
//		String conUrl = "jdbc:sqlserver://localhost:1433;databaseName=tripdb";
		try {
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/tripDEMO");
			
		} catch (NamingException e) {
		
			e.printStackTrace();
		}
	}

	private static final String SeletById = "select memberid,viewid,placeno,name,date,type,main,imageName,tdate from trip where viewid=?";

	public TripBean select(String tripno) {
		TripBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt = conn.prepareStatement(SeletById);
			stmt.setString(1, tripno);
			rset = stmt.executeQuery();
			
			if (rset.next()) {
				result = new TripBean();
				result.setMemberid(rset.getString("memberid"));
				result.setViewid(rset.getString("viewid"));
				result.setPlace(rset.getString("placeno"));
				result.setName(rset.getString("name"));
				result.setDate(rset.getString("date"));
				result.setType(rset.getString("type"));
				result.setMain(rset.getString("main"));
				result.setImage(rset.getString("imagename"));
				result.setTdate(rset.getTimestamp("tdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
		
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
			
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
			
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	

	private static final String Select_all = "select memberid,viewid,placeno,name,date,type,main,imagename,tdate from trip";

	public LinkedList<HashMap<String,String>> select() {
		LinkedList<HashMap<String,String>> result = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt = conn.prepareStatement(Select_all);
			rset = stmt.executeQuery();
			result = new LinkedList<HashMap<String,String>>();
			while (rset.next()) {
				HashMap<String,String> h1=new HashMap();
				h1.put("memberid", rset.getString("memberid"));
				h1.put("viewid",rset.getString("viewid"));
				h1.put("placeno", rset.getString("placeno"));
				h1.put("name", rset.getString("name"));
				h1.put("date", rset.getString("date"));
				h1.put("type", rset.getString("type"));
				h1.put("main", rset.getString("main"));
				h1.put("imagename", rset.getString("ImageName"));
				h1.put("tdate", rset.getString("tdate"));
				result.add(h1);
			}
			return result;
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
			
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
		
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
			
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static final String Insert="insert into trip (memberid,viewid,placeno,name,date,type,main,ImageName,tdate) values (?,?,?,?,?,?,?,?,?)";
	
	public TripBean insertTrip(TripBean bean) throws SQLException{
		TripBean result=null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try{
			conn=ds.getConnection();

			stmt=conn.prepareStatement(Insert);
			stmt.setString(1, bean.getMemberid());
			stmt.setString(2, bean.getViewid());
			stmt.setString(3, bean.getPlace());
			stmt.setString(4, bean.getName());

			stmt.setString(5, bean.getDate());
			stmt.setString(6, bean.getType());
			stmt.setString(7, bean.getMain());
			stmt.setString(8, bean.getImage());
			
			stmt.setTimestamp(9, bean.getTdate());
			
			int i = stmt.executeUpdate();
			if(i==1){
			result=this.select(bean.getViewid());	
			}
			}catch(SQLException e){
			e.printStackTrace();
		}
	finally{
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
		return result;
	}
private static final String update="update trip set placeno=?,name=?,date=?,type=?,main=?,tdate=? where viewid=?";
	
	public TripBean updateTrip(TripBean bean) throws SQLException{
		TripBean result=null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try{
			conn=ds.getConnection();

			stmt=conn.prepareStatement(update);
		
		
			stmt.setString(3, bean.getPlace());
			stmt.setString(4, bean.getName());
	
			stmt.setString(5, bean.getDate());
			stmt.setString(6, bean.getType());
			stmt.setString(7, bean.getMain());

			Timestamp ts=new Timestamp(System.currentTimeMillis());
			stmt.setTimestamp(8, bean.getTdate());
			stmt.setString(9, bean.getViewid());
			
			int i = stmt.executeUpdate();
			if(i==1){
			result=this.select(bean.getViewid());	
			}
			}catch(SQLException e){
			e.printStackTrace();
		}
	finally{
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
		return result;
	}
	private static final String Delect = "DELETE  from trip where viewid=?";
	
	public int delete(String viewid){
	int result=0;
	Connection conn = null;
	PreparedStatement stmt=null;
	try{
		conn=ds.getConnection();
		stmt=conn.prepareStatement(Delect);
		stmt.setString(1, viewid);
		result = stmt.executeUpdate();
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return result;
	}
}
