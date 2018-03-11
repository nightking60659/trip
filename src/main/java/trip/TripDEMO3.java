package trip;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/TripDEMO")
public class TripDEMO3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", "erroMsg");
		request.setAttribute("MsgOK", "msgOK");

		String place = "";
		String name = "";
		String date = null;
		String type = "";
		String main = "";
		String fileName = "";
		long sizeInByte = 0;
		InputStream is = null;

		Collection<Part> parts = request.getParts();
		
		GlobalService.exploreParts(parts, request);// 印出part的所有東西
		if (parts != null) {
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
					} else if (fldName.equals("tripmain")) {
						main = value;
						if(value==null) {
							System.out.print("null");
						}else {
						request.setAttribute("main", main);
						}
					}
				} else {
					fileName = GlobalService.getFileName(p);
					fileName = GlobalService.adjustFileName(fileName,
					 GlobalService.IMAGE_FILENAME_LENGTH);
					if (fileName != null && fileName.trim().length() > 0) {
						sizeInByte = p.getSize();
						is = p.getInputStream();
						String saveDir=getServletContext().getRealPath("/")+"images/clients/"+type+"/";
						int len;
						Path mir =Paths.get(saveDir); 
						if(Files.exists(mir)) {
							System.out.println("exist");
						}else if(!Files.exists(mir) ){
							Files.createDirectory(mir);
						}
						FileOutputStream fos=new FileOutputStream(saveDir+fileName);
						byte[] b= new byte[8192];
						while((len=is.read(b))!=-1) {
							fos.write(b,0,len);
						}
					} else {
						errorMsg.put("errpicture", "請放入圖片檔");
					}
				}
			}
				try {
					TripDAO td = new TripDAO();// connection
					Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
//					Blob blob = SystemUtils.fileToBlob(is, sizeInByte);
					TripBean tb = new TripBean(null, place, name, date, type, main, fileName, ts);
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
