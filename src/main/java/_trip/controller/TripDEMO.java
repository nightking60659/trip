package _trip.controller;

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

import _trip.DAO.TripDAO;
import _trip.DAO.TripDAOI;
import _trip.model.MemberBean;
import _trip.model.TripBean;
import _trip_tool.GlobalService;

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

		//建立空變數
		String viewid = "";
		String name = "";
		String address = "";
		String web = "";
		String phone = "";
		String main = "";
		String imagename="";
		Timestamp tdate=null;
		String fileName = "";
		long sizeInByte = 0;
		InputStream is = null;
		
		//取得現有的session的資料
		HttpSession session = request.getSession(false);
		//取得login的資料
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		String memberid = mb.getMid();
		request.setAttribute("memberid", memberid);

		Timestamp ts=new Timestamp(System.currentTimeMillis());
		tdate = Timestamp.valueOf(new SimpleDateFormat("yyyyMMddhhmmss").format(ts));
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
				
					if (fldName.equals("ViewName")) {
						name = value;
						if(value==null) {
							System.out.print("null");
						}else {
						request.setAttribute("name", name);
						}
					} else if (fldName.equals("ViewAddress")) {
						address = value;
						if(value==null) {
							System.out.print("null");
						}else {
						request.setAttribute("address", address);
						}
					}  else if (fldName.equals("ViewWeb")) {
						web = value;
						System.out.print("web");
						if(value==null) {
							System.out.print("null");
							}else {
						request.setAttribute("web", web);
						}
					} else if (fldName.equals("phone")) {
						main = value;
						if(value==null) {
							System.out.print("null");
						}else {
						request.setAttribute("phone", phone);
						}
					}else if (fldName.equals("ViewMain")) {
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
						
						String saveDir=getServletContext().getRealPath("/")+"images\\clients\\"+memberid;
					
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
						
						String outputPath = saveDir+"\\"+fileName;
						
						FileOutputStream fos=new FileOutputStream(outputPath);
						System.out.println(outputPath);
						
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
					TripDAOI td = new TripDAO();// connection

					TripBean tb = new TripBean(memberid, viewid, fileName, address, web, phone, main, imagename, tdate);
					td.insertTrip(tb);
					msgOK.put("insertOK", "新增成功");
					response.sendRedirect("index.jsp");
					return;

				} catch (SQLException e) {
			
					e.printStackTrace();
				}
			

		}
	}
}
