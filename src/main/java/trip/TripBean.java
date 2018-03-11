package trip;

import java.sql.Blob;
import java.sql.Date;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TripBean {
	private String no;
	private String place;
	private String name;
	// private java.sql.Date date;
	private String date;
	private String type;
	private String main;
	private String image;
	private java.sql.Timestamp tdate;

	public TripBean() {

	}

	public TripBean(String no,String place, String name, String date, String type, String main, Timestamp tdate) {
		this.no = no;
		this.place = place;
		this.name = name;
		this.date = date;
		this.type = type;
		this.main = main;
//		this.image = image;
		this.tdate = tdate;
	}

	public TripBean(String no,String place, String name, String date, String type, String main,String image, Timestamp tdate) {
		this.no = no;
		this.place = place;
		this.name = name;
		this.date = date;
		this.type = type;
		this.main = main;
		this.image = image;
		this.tdate = tdate;
	}

	public void getConnection() {

	}

	public java.sql.Timestamp getTdate() {
		return tdate;
	}

	public void setTdate(java.sql.Timestamp tdate) {
		this.tdate = tdate;
	}

	private static SimpleDateFormat sdf = new SimpleDateFormat();

	public static java.util.Date convertDate(String temp) {
		java.util.Date result = new java.util.Date();

		try {
			result = sdf.parse(temp);
		} catch (ParseException e) {
			result = null;
			e.printStackTrace();
		}
		return result;
	}

//	private static long convertFile(String image) {
//
//		File file = new File(image);
//		long l1 = file.length();
//		
//		return l1;
//
//	}
//
//	private static FileInputStream convertFIS(File file) {
//
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//			
//			e.printStackTrace();
//		}
//
//		return fis;
//
//	}
	public String getNo() {
		return no;
	}
		
	public String getPlace() {
		return place;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getType() {

		return type;
	}

	public String getMain() {
		return main;
	}

	public String getImage() {
		
		return image;
	}

	public void setNo(String no) {
		this.no = no;

	}
	
	public void setPlace(String place) {
		this.place = place;

	}

	public void setName(String name) {
		this.name = name;

	}

	// public void setDate(java.sql.Date date){
	// this.date=date;
	// }
	public void setDate(String date) {
		this.date = date;
	}

	public void setType(String type) {

		this.type = type;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public void setImage(String image) {

		this.image = image;

	}
}

//
// FileOutputStream fileOutputStream = new FileOutputStream(path);
// byte[] buf = new byte[1024];
// int len = 0;
// while ((len = inputStream.read(buf)) != -1) {
// fileOutputStream.write(buf, 0, len);// 写
// }
// inputStream.close();
// fileOutputStream.close();
// } catch (FileNotFoundException e) {
// e.printStackTrace();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }
