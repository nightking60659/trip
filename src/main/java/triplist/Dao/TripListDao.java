package triplist.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tripAll.model.TripAllBean;
import triplist.model.TripListBean;

public class TripListDao  {

	DataSource ds = null;

	public TripListDao(){
		try {
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/tripDEMO");
			
		} catch (NamingException e) {
		
			e.printStackTrace();
		}
	}
	
	
	private static final String Select_Tripid= "select viewName ,StartTime, endTime, tripType, tripname, tripid, tripday, viewid from tripALL where tripid=? ";
	public TripListBean Select_Tripid(TripListBean bean) {
		TripListBean result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt=conn.prepareStatement(Select_Tripid);
			stmt.setInt(1, bean.getTripid());
			rset =stmt.executeQuery();
			
			if(rset.next()) {
				result = new TripListBean();
				result.setViewName(rset.getString("viewName"));
				result.setStartTime(rset.getDate("StartTime"));
				result.setEndTime(rset.getDate("endTime"));
				result.setTripType(rset.getString("tripType"));
				result.setTripname(rset.getString("tripname"));
				result.setTripid(rset.getInt("tripid"));
				result.setTripday(rset.getInt("tripday"));
				result.setViewid(rset.getInt("viewid"));
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

	private static final String Select= "select viewName ,StartTime, endTime, tripType, tripname, tripid, tripday, viewid from tripALL";
	public TripListBean select() {
		
		
		TripListBean result=null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rset = null;
			try {
				conn=ds.getConnection();
				stmt=conn.prepareStatement(Select);
				rset =stmt.executeQuery();
				
				if(rset.next()) {
					result = new TripListBean();
					result.setViewName(rset.getString("viewName"));
					result.setStartTime(rset.getDate("StartTime"));
					result.setEndTime(rset.getDate("endTime"));
					result.setTripType(rset.getString("tripType"));
					result.setTripname(rset.getString("tripname"));
					result.setTripid(rset.getInt("tripid"));
					result.setTripday(rset.getInt("tripday"));
					result.setViewid(rset.getInt("viewid"));
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
	private static final String insert = "insert into tripALL (viewName ,StartTime, endTime, tripType, tripname, tripid, tripday, viewid) values (?,?,?,?,?,?,?,?)";

	public TripListBean insert(TripListBean bean) {
		
		TripListBean result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt=conn.prepareStatement(insert);
			stmt.setString(1, bean.getTripname());
			stmt.setDate(2, bean.getStartTime());
			stmt.setDate(3, bean.getEndTime());
			stmt.setString(4, bean.getTripType());
			stmt.setString(5, bean.getTripname());
			stmt.setInt(6, bean.getTripid());
			stmt.setInt(7, bean.getTripday());
			stmt.setInt(8, bean.getViewid());
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

	private static final String update="update trip set viewName=? ,StartTime=?, endTime=?, tripType=?, tripname=?,  tripday=?, viewid=? where tripid=?";
	public TripListBean updateTrip(TripListBean bean) throws SQLException {
		
		TripListBean result=null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try{
			conn=ds.getConnection();

			stmt=conn.prepareStatement(update);
		
		
			stmt.setString(1, bean.getTripname());
			stmt.setDate(2, bean.getStartTime());
			stmt.setDate(3, bean.getEndTime());
			stmt.setString(4, bean.getTripType());
			stmt.setString(5, bean.getTripname());
			stmt.setInt(6, bean.getTripday());
			stmt.setInt(7, bean.getViewid());
			stmt.setInt(8, bean.getTripid());
			int sucess =stmt.executeUpdate();

			
			
			if(sucess==1){
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

	private static final String Delete = "DELETE  from triplist where tripid=?";
	public int delete(TripListBean bean) {
	
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
