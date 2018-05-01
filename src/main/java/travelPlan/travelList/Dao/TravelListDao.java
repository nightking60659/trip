package travelPlan.travelList.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import travelPlan.travelList.model.TravelListBean;

public class TravelListDao  {

	DataSource ds = null;

	public TravelListDao(){
		try {
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/tripDEMO");
			
		} catch (NamingException e) {
		
			e.printStackTrace();
		}
	}
	
	
	private static final String Select_Tripid= "select viewName ,StartTime, endTime, tripType, tripname, tripid, tripday, viewid from tripALL where tripid=? ";
	public TravelListBean Select_Tripid(TravelListBean bean) {
		TravelListBean result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt=conn.prepareStatement(Select_Tripid);
			stmt.setInt(1, bean.getTravelId());
			rset =stmt.executeQuery();
			
			if(rset.next()) {
				result = new TravelListBean();
				result.setViewName(rset.getString("viewName"));
				result.setStartTime(rset.getDate("StartTime"));
				result.setEndTime(rset.getDate("endTime"));
				result.setTravelType(rset.getString("tripType"));
				result.setTravelName(rset.getString("tripname"));
				result.setTravelId(rset.getInt("tripid"));
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
	public TravelListBean select() {
		
		
		TravelListBean result=null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rset = null;
			try {
				conn=ds.getConnection();
				stmt=conn.prepareStatement(Select);
				rset =stmt.executeQuery();
				
				if(rset.next()) {
					result = new TravelListBean();
					result.setViewName(rset.getString("viewName"));
					result.setStartTime(rset.getDate("StartTime"));
					result.setEndTime(rset.getDate("endTime"));
					result.setTravelType(rset.getString("tripType"));
					result.setTravelName(rset.getString("tripname"));
					result.setTravelId(rset.getInt("tripid"));
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

	public TravelListBean insert(TravelListBean bean) {
		
		TravelListBean result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt=conn.prepareStatement(insert);
			stmt.setString(1, bean.getTravelName());
			stmt.setDate(2, bean.getStartTime());
			stmt.setDate(3, bean.getEndTime());
			stmt.setString(4, bean.getTravelType());
			stmt.setString(5, bean.getTravelName());
			stmt.setInt(6, bean.getTravelId());
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
	public TravelListBean updateTrip(TravelListBean bean) throws SQLException {
		
		TravelListBean result=null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try{
			conn=ds.getConnection();

			stmt=conn.prepareStatement(update);
		
		
			stmt.setString(1, bean.getTravelName());
			stmt.setDate(2, bean.getStartTime());
			stmt.setDate(3, bean.getEndTime());
			stmt.setString(4, bean.getTravelType());
			stmt.setString(5, bean.getTravelName());
			stmt.setInt(6, bean.getTripday());
			stmt.setInt(7, bean.getViewid());
			stmt.setInt(8, bean.getTravelId());
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
	public int delete(TravelListBean bean) {
	
			int result=0;
			Connection conn = null;
			PreparedStatement stmt=null;
			try{
				conn=ds.getConnection();
				stmt=conn.prepareStatement(Delete);
				stmt.setInt(1, bean.getTravelId());
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
