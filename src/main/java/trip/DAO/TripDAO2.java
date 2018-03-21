package trip.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import trip.model.TripBean;





public class TripDAO2 {
	
	

	DataSource ds = null;

	public TripDAO2(){
//		String conUrl = "jdbc:sqlserver://localhost:1433;databaseName=tripdb";
		try {
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/tripDEMO");
			
		} catch (NamingException e) {
		
			e.printStackTrace();
		}
	}

	private static final String SeletById = "select no,placeno,name,date,type,main,tdate from trip where no=?";

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
				result.setNo(rset.getString("no"));
				result.setPlace(rset.getString("placeno"));
				result.setName(rset.getString("name"));
				result.setDate(rset.getString("date"));
				result.setType(rset.getString("type"));
				result.setMain(rset.getString("main"));
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
	public List<TripBean> getDatas() {
		return select();
	}

	private static final String Select_all = "select no,placeno,name,date,type,main,tdate from trip";

	public List<TripBean> select() {
		List<TripBean> result = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt = conn.prepareStatement(Select_all);
			rset = stmt.executeQuery();
			result = new ArrayList<TripBean>();
			while (rset.next()) {
				TripBean temp = new TripBean();
				temp.setNo(rset.getString("no"));
				temp.setPlace(rset.getString("placeno"));
				temp.setName(rset.getString("name"));
				temp.setDate(rset.getString("date"));
				temp.setType(rset.getString("type"));
				temp.setMain(rset.getString("main"));
//				temp.setIs(rset.getBinaryStream("trippic"));
				temp.setTdate(rset.getTimestamp("tdate"));
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
	
	private static final String Insert="insert into trip (placeno,name,date,type,main,trip_image,tdate) values (?,?,?,?,?,?,?)";
	
	public TripBean insertTrip(TripBean bean) throws SQLException{
		TripBean result=null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try{
			conn=ds.getConnection();

			stmt=conn.prepareStatement(Insert);
			
//			stmt.setString(1, bean.getNo());
			stmt.setString(1, bean.getPlace());
			stmt.setString(2, bean.getName());
//			String temp=bean.getDate();
//			if(temp!=null){
//				java.sql.Date someTime=new temp.getTime();
//				stmt.setDate(3,someTime);
//			}else{
//				stmt.setDate(3, null);
//			}	
			stmt.setString(3, bean.getDate());
			stmt.setString(4, bean.getType());
			stmt.setString(5, bean.getMain());
			stmt.setBlob(6, bean.getImage());
			Timestamp ts=new Timestamp(System.currentTimeMillis());
			stmt.setTimestamp(7, ts);
			
			int i = stmt.executeUpdate();
			if(i==1){
			result=this.select(bean.getNo());	
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
private static final String update="update trip set placeno=?,name=?,date=?,type=?,main=?,tdate=? where no=?";
	
	public TripBean updateTrip(TripBean bean) throws SQLException{
		TripBean result=null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try{
			conn=ds.getConnection();

			stmt=conn.prepareStatement(update);
			
//			stmt.setString(1, bean.getNo());
			stmt.setString(1, bean.getPlace());
			stmt.setString(2, bean.getName());
//			java.util.Date temp=bean.getDate();
//			if(temp!=null){
//				java.sql.Date someTime=new java.sql.Date(temp.getTime());
//				stmt.setDate(3,someTime);
//			}else{
//				stmt.setDate(3, null);
//			}	
			stmt.setString(3, bean.getDate());
			stmt.setString(4, bean.getType());
			stmt.setString(5, bean.getMain());
			stmt.setBlob(6, bean.getImage());
			Timestamp ts=new Timestamp(System.currentTimeMillis());
			stmt.setTimestamp(6, ts);
			stmt.setString(7, bean.getNo());
			
			int i = stmt.executeUpdate();
			if(i==1){
			result=this.select(bean.getNo());	
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
	private static final String Delect = "DELETE  from trip where no=?";
	
	public int delete(String tripno){
	int result=0;
	Connection conn = null;
	PreparedStatement stmt=null;
	try{
		conn=ds.getConnection();
		stmt=conn.prepareStatement(Delect);
		stmt.setString(1, tripno);
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
