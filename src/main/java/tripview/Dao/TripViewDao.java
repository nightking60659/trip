package tripview.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tripAll.model.TripAllBean;
import tripview.model.TripViewBean;

public class TripViewDao {
	DataSource ds = null;
	public TripViewDao(){
		try {
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/tripDEMO");
			
		} catch (NamingException e) {
		
			e.printStackTrace();
		}
	}
	
//viewid, imageSource, memberid, Viewname, viewQuery, viewPicQuery, viewadr, viewWeb, viewPhone, viewOpenTime, coordx, coordy, tdate;
	public static final String Select_ViewId="Select viewid, imageSource, memberid, Viewname, viewQuery, viewPicQuery, viewadr, viewWeb, viewPhone, viewOpenTime, coordx, coordy, tdate from tripView where viewid=?";
	public TripViewBean select_tripid(TripViewBean bean) {
		TripViewBean result=null;Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt=conn.prepareStatement(Select_ViewId);
			stmt.setInt(1, bean.getViewid());
			rset =stmt.executeQuery();
			
			if(rset.next()) {
				result = new TripViewBean();
				result.setViewid(rset.getInt("viewid"));
				result.setImageSource(rset.getString("imageSource"));
				result.setMemberid(rset.getInt("memberid"));
				result.setViewname(rset.getString("Viewname"));
				result.setViewQuery(rset.getString("viewQuery"));
				result.setViewPicQuery(rset.getString("viewPicQuery"));
				result.setViewadr(rset.getString("viewadr"));
				result.setViewWeb(rset.getString("viewWeb"));
				result.setViewPhone(rset.getString("viewPhone"));
				result.setViewOpenTime(rset.getString("viewOpenTime"));
				result.setCoordx(rset.getString("x"));
				result.setCoordy(rset.getString("y"));
				result.setTdate(rset.getDate("tdate"));
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
	public static final String Select="select viewid, imageSource, memberid, Viewname, viewQuery, viewPicQuery, viewadr, viewWeb, viewPhone, viewOpenTime, coordx, coordy, tdate from tripview";
	public TripViewBean select(TripViewBean bean) {
		TripViewBean result=null;Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt=conn.prepareStatement(Select);
		
			rset =stmt.executeQuery();
			
			if(rset.next()) {
				result = new TripViewBean();
				result.setViewid(rset.getInt("viewid"));
				result.setImageSource(rset.getString("imageSource"));
				result.setMemberid(rset.getInt("memberid"));
				result.setViewname(rset.getString("Viewname"));
				result.setViewQuery(rset.getString("viewQuery"));
				result.setViewPicQuery(rset.getString("viewPicQuery"));
				result.setViewadr(rset.getString("viewadr"));
				result.setViewWeb(rset.getString("viewWeb"));
				result.setViewPhone(rset.getString("viewPhone"));
				result.setViewOpenTime(rset.getString("viewOpenTime"));
				result.setCoordx(rset.getString("x"));
				result.setCoordy(rset.getString("y"));
				result.setTdate(rset.getDate("tdate"));
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
	public static final String Insert="Insert into tripview(viewid, imageSource, memberid, Viewname, viewQuery, viewPicQuery, viewadr, viewWeb, viewPhone, viewOpenTime, coordx, coordy, tdate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,)";
	public TripViewBean insert(TripViewBean bean) {
		TripViewBean result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt=conn.prepareStatement(Insert);
			stmt.setInt(1, bean.getViewid());
			stmt.setString(2, bean.getImageSource());
			stmt.setInt(3, bean.getMemberid());
			stmt.setString(4, bean.getViewname());
			stmt.setString(5, bean.getViewQuery());
			stmt.setString(6, bean.getViewPicQuery());
			stmt.setString(7, bean.getViewadr());
			stmt.setString(8, bean.getViewWeb());
			stmt.setString(9, bean.getViewPhone());
			stmt.setString(10, bean.getViewOpenTime());
			stmt.setString(11, bean.getCoordx());
			stmt.setString(12, bean.getCoordy());
			stmt.setDate(13, bean.getTdate());
			int sucess =stmt.executeUpdate();
			if(sucess ==1) {
				result= this.select_tripid(bean);
				
			}else {
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
	public static final String Update="Update tripview set  imageSource=?, memberid=?, Viewname=?, viewQuery=?, viewPicQuery=?, viewadr=?, viewWeb=?, viewPhone=?, viewOpenTime=?, coordx=?, coordy=?, tdate=? where viewid=?";
	public TripViewBean update(TripViewBean bean) {
		TripViewBean result=null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn=ds.getConnection();
			stmt=conn.prepareStatement(Update);
			stmt.setString(1, bean.getImageSource());
			stmt.setInt(2, bean.getMemberid());
			stmt.setString(3, bean.getViewname());
			stmt.setString(4, bean.getViewQuery());
			stmt.setString(5, bean.getViewPicQuery());
			stmt.setString(6, bean.getViewadr());
			stmt.setString(7, bean.getViewWeb());
			stmt.setString(8, bean.getViewPhone());
			stmt.setString(9, bean.getViewOpenTime());
			stmt.setString(10, bean.getCoordx());
			stmt.setString(11, bean.getCoordy());
			stmt.setDate(12, bean.getTdate());
			stmt.setInt(13, bean.getViewid());
			int sucess =stmt.executeUpdate();
			if(sucess ==1) {
				result= this.select_tripid(bean);
				
			}else {
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
	public static final String Delete="Delete from tripview where viewid=?";
	public int delete(TripViewBean bean) {
		int result=0;
		Connection conn = null;
		PreparedStatement stmt=null;
		try{
			conn=ds.getConnection();
			stmt=conn.prepareStatement(Delete);
			stmt.setInt(1, bean.getViewid());
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
