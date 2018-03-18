package trip.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import _trip_tool.GlobalService;
import member.MemberBean;
import trip.DAO.TripDAO;
import trip.model.TripBean;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/TripDEMO")
public class TripDEMO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		
		
		request.setAttribute("MsgMap", "erroMsg");
		request.setAttribute("MsgOK", "msgOK");

		
		String viewid = "";
		
		String place = "";
		String name = "";
		String date = null;
		String type = "";
		String main = "";
		String imagename="";
		String tdate=null;
		
		String fileName = "";
		long sizeInByte = 0;
		InputStream is = null;
		
		HttpSession session = request.getSession(false);
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		
		String memberid = mb.getMid();
		request.setAttribute("memberid", memberid);

		Timestamp ts=new Timestamp(System.currentTimeMillis());
		tdate = new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
		viewid= memberid+tdate;
		request.setAttribute("viewid", viewid);
		Collection<Part> parts = request.getParts();
		
		GlobalService.exploreParts(parts, request);// 印出part的所有東西
		if (parts != null) {
			int count=1;
			for (Part p : parts) {
				String fldName = p.getName();
				System.out.println("fldName=" + fldName);
				String value = request.getParameter(fldName);

				if (p.getContentType() == null) {
				
					if (fldName.equals("tripplace")) {
						place = value;
						if(value==null) {
							System.out.print("null");
						}else {
						request.setAttribute("place", place);
						}
					} else if (fldName.equals("tripname")) {
						name = value;
						if(value==null) {
							System.out.print("null");
						}else {
						request.setAttribute("name", name);
						}
					} else if (fldName.equals("tripdate")) {
						date = value;
						if(value==null) {
							System.out.print("null");
						}else {
						request.setAttribute("date", date);
						}
					} else if (fldName.equals("triptype")) {
						type = value;
						if(value==null) {
							System.out.print("null");
						}else {
						request.setAttribute("type", type);
						}
					} else if (fldName.equals("editor1")) {
						main = value;
						if(value==null) {
							System.out.print("null");
						}else {
						request.setAttribute("main", main);
						}
					}
				} else {
					
					fileName = GlobalService.getFileName(p);

					String f = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			
		
					if (fileName != null && fileName.trim().length() > 0) {
						sizeInByte = p.getSize();
						is = p.getInputStream();
						System.out.println(type);
						String saveDir=getServletContext().getRealPath("/")+"images\\clients\\"+type;
//						String saveDir=application
						System.out.println(saveDir);
						int len;
						Path mir =Paths.get(saveDir); 
						//判斷有無資料夾
						if(Files.exists(mir)) {
							System.out.println("exist");
						}else if(!Files.exists(mir) ){
							Files.createDirectory(mir);
						}
						
						fileName = memberid+"_"+tdate+f;
						imagename=fileName;
						System.out.println(fileName);
						String outputPath = saveDir+"\\"+fileName;
						System.out.println(outputPath);
						FileOutputStream fos=new FileOutputStream(outputPath);
						
						
						byte[] b= new byte[8192];
						while((len=is.read(b))!=-1) {
							fos.write(b,0,len);
							
						}
						fos.flush();
						fos.close();
					} else {
						errorMsg.put("errpicture", "請放入圖片檔");
					}
					
					
					
				}
			}
				try {
					TripDAO td = new TripDAO();// connection
//					Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
////					Blob blob = SystemUtils.fileToBlob(is, sizeInByte);
					
					TripBean tb = new TripBean(memberid, viewid, place, name, date, type, main,imagename , ts);
					td.insertTrip(tb);
					msgOK.put("insertOK", "新增成功");
					response.sendRedirect("index.jsp");
					return;

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

		}
	}
}
