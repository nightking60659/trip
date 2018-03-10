package member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao{
	private DataSource ds = null;
	
	public MemberDao() {
		try {
			
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/tripDEMO");
		} catch (NamingException e) {
		
			e.printStackTrace();
		}
	}
	
	public int saveMember(MemberBean mb) {
		String sql="insert into member(memberid,password) values(?,?)";
		int n=0;
		try(Connection con=ds.getConnection();PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, mb.getMid());
			ps.setString(2, mb.getPassword());
			n=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			return n;
	}
	
	

}
