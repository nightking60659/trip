package _trip.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _trip.model.MemberBean;

public class MemberDao implements  MemberDAOI{
	private DataSource ds = null;
	
	public MemberDao() {
		try {
			
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/tripDEMO");
		} catch (NamingException e) {
		
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see trip.DAO.MemberBean#saveMember(trip.model.MemberBean)
	 */
	/* (non-Javadoc)
	 * @see trip.DAO.MemberDAOI#saveMember(trip.model.MemberBean)
	 */
	@Override
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
