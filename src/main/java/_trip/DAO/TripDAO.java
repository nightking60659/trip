package _trip.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.HashMap;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _trip.model.TripBean;





public class TripDAO implements TripDAOI {
	
	

	DataSource ds = null;

	public TripDAO(){
		try {
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/tripDEMO");
			
		} catch (NamingException e) {
		
			e.printStackTrace();
		}
	}

	private static final String SeletById = "select memberid,viewid,viewname,viewaddress,web,phone,viewmain,imagename,tdate from trip where memberid=?";

	/* (non-Javadoc)
	 * @see trip.DAO.TripDAOI#select(java.lang.String)
	 */
	@Override
	public TripBean select(String memberid) {
		 TripBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt = conn.prepareStatement(SeletById);
			stmt.setString(1, memberid);
			rset = stmt.executeQuery();
			
			
			if (rset.next()) {
				
				 result= new TripBean();
				 result.setMemberid(rset.getString("memberid"));
				 result.setViewid(rset.getString("viewid"));
				 result.setName(rset.getString("viewname"));
				 result.setAddress(rset.getString("viewaddress"));
				 result.setWeb(rset.getString("web"));
				 result.setPhone(rset.getString("phone"));
				 result.setMain(rset.getString("viewmain"));
				 result.setImagename(rset.getString("imagename"));
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
	

	private static final String Select_all = "select memberid,viewid,viewname,viewaddress,web,phone,viewMain,imageName,tdate from trip";

	
	@Override
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
				h1.put("viewname", rset.getString("viewname"));
				h1.put("viewaddress", rset.getString("viewaddress"));
				h1.put("web", rset.getString("web"));
				h1.put("phone", rset.getString("phone"));
				h1.put("viewmain", rset.getString("viewmain"));
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
	
	private static final String Insert="insert into trip (memberid,viewid,viewname,viewaddress,web,phone,viewvain,imagename,tdate) values (?,?,?,?,?,?,?,?,?)";
	
	
	@Override
	public TripBean insertTrip(TripBean bean) throws SQLException{
		TripBean result=null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try{
			conn=ds.getConnection();

			stmt=conn.prepareStatement(Insert);
			stmt.setString(1, bean.getMemberid());
			stmt.setString(2, bean.getViewid());
			stmt.setString(3, bean.getName());
			stmt.setString(4, bean.getAddress());

			stmt.setString(5, bean.getWeb());
			stmt.setString(6, bean.getPhone());
			stmt.setString(7, bean.getMain());
			stmt.setString(8, bean.getImagename());
			
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
private static final String update="update trip set viewname=?,viewaddress=?,web=?,phone=?,main=?,tdate=? where viewid=?";
	
	/* (non-Javadoc)
	 * @see trip.DAO.TripDAOI#updateTrip(trip.model.TripBean)
	 */
	@Override
	public TripBean updateTrip(TripBean bean) throws SQLException{
		TripBean result=null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try{
			conn=ds.getConnection();

			stmt=conn.prepareStatement(update);
		
		
			stmt.setString(3, bean.getName());
			stmt.setString(4, bean.getAddress());
	
			stmt.setString(5, bean.getWeb());
			stmt.setString(6, bean.getPhone());
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
	
	/* (non-Javadoc)
	 * @see trip.DAO.TripDAOI#delete(java.lang.String)
	 */
	@Override
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
