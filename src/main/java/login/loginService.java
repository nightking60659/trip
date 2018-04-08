package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _trip.DAO.MemberDao;
import _trip.model.MemberBean;



public class loginService{
	private DataSource ds=null;
	public loginService() {
		
		try {
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/tripDEMO");
			
		} catch (NamingException e) {
		
			e.printStackTrace();
		}
	}
	
	public MemberBean checkIdPassword(String userId,String password) {
		
		MemberBean mb = null;
		String sql = "select * from member m where m.memberid=? and m.password=?";
		try(
		Connection con = ds.getConnection();
		PreparedStatement ps =con.prepareStatement(sql);
		){
			ps.setString(1, userId);
			ps.setString(2, password);
			try(ResultSet rs=ps.executeQuery();){
				if(rs.next()) {
					mb=new MemberBean();
					mb.setMid(rs.getString("memberid"));
					mb.setPassword(rs.getString("password"));
					
				}
			}
			}catch(Exception e) {
				e.getMessage();
			}
			return mb;
			
		}
	}
