package tripAll.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _trip.DAO.TripDaoInterface;
import tripAll.model.TripAllBean;


public class TripAllDAO implements TripDaoInterface {

	
	DataSource ds = null;

	public TripAllDAO(){
		try {
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/tripDEMO");
			
		} catch (NamingException e) {
		
			e.printStackTrace();
		}
	}
	
	
	private static final String Select_Tripid= "select tripid ,tripName, StartDate, endDate, tripDays from tripALL where tripid=? ";

	
	@Override
	public TripAllBean Select_Tripid(TripAllBean bean) {
		TripAllBean result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt=conn.prepareStatement(Select_Tripid);
			stmt.setInt(1, bean.getTripid());
			rset =stmt.executeQuery();
			
			if(rset.next()) {
				result = new TripAllBean();
				result.setTripid(rset.getInt("tripid"));
				result.setTripName(rset.getString("tripName"));
				result.setStartDate(rset.getDate("StartDate"));
				result.setEndDate(rset.getDate("endDate"));
				result.setTripDays(rset.getInt("tripDays"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	private static final String Select= "select tripid ,tripName, StartDate, endDate, tripDays from tripALL";
	
	
	@Override
	public TripAllBean select() {
		TripAllBean result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt=conn.prepareStatement(Select);
			rset =stmt.executeQuery();
			
			if(rset.next()) {
				result = new TripAllBean();
				result.setTripid(rset.getInt("tripid"));
				result.setTripName(rset.getString("tripName"));
				result.setStartDate(rset.getDate("StartDate"));
				result.setEndDate(rset.getDate("endDate"));
				result.setTripDays(rset.getInt("tripDays"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public static final String insert = "insert into tripALL (tripid ,tripName, StartDate, endDate, tripDays) values (?,?,?,?,?)";
	@Override
	public TripAllBean insert(TripAllBean bean) {
		TripAllBean result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt=conn.prepareStatement(insert);
			stmt.setInt(1, bean.getTripid());
			stmt.setString(2, bean.getTripName());
			stmt.setDate(3, bean.getStartDate());
			stmt.setDate(4, bean.getEndDate());
			stmt.setInt(5, bean.getTripDays());
			int sucess =stmt.executeUpdate();
			if(sucess==1) {
				
				result= this.Select_Tripid(bean);
				
			}else {
				System.out.println("新增失敗");
				result=null;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	private static final String update="update trip set tripName=?,StartDate=?,endDate=?,tripDays=? where tripid=?";
	
	
	@Override
	public TripAllBean updateTrip(TripAllBean bean) throws SQLException{
		TripAllBean result=null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try{
			conn=ds.getConnection();

			stmt=conn.prepareStatement(update);
		
		
			stmt.setString(1, bean.getTripName());
			stmt.setDate(2, bean.getStartDate());
	
			stmt.setDate(3, bean.getEndDate());
			stmt.setInt(4, bean.getTripDays());
			stmt.setInt(5, bean.getTripid());

			
			int i = stmt.executeUpdate();
			if(i==1){
			result=this.Select_Tripid(bean);	
			}else {
				result=null;
			}
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
	
private static final String Delete = "DELETE  from trip where tripid=?";
	
	
	@Override
	public int delete(TripAllBean bean){
	int result=0;
	Connection conn = null;
	PreparedStatement stmt=null;
	try{
		conn=ds.getConnection();
		stmt=conn.prepareStatement(Delete);
		stmt.setInt(1, bean.getTripid());
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
