package travelPlan.travelView.tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;







public class jsson2 {


	
	 public static void main(String[] args) {  
//		 Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction tx = null;
//		  tx = session.beginTransaction();
//			int count = 0;
			
		 String name;
		 String tel;
		 String add;
		 String px;
		 String py;
		 String orgclass;
		 String keyword;
		 String pic;

	        // 读取原始json文件并进行操作和输出  
	        try {  
	            BufferedReader br = new BufferedReader(new FileReader( "E:\\f5.json"));// 读取原始json文件  
	        	
	            String s = null;  
	            
	            
	            while ((s = br.readLine()) != null) {  
//	            	System.out.println(s);
	            
	            	String[] sa=s.split("}");
	            	System.out.println(sa[0]);
//	                JSONObject dataJson = new JSONObject(sa[0]);
//	                System.out.println(dataJson.getString("Add"));
	           
	            	
//	                System.out.println(dataJson.toString());
//	                for(int i = 0;i<sa.length;i++) {
//	                	 JSONObject dataJson = new JSONObject(sa[i]);// 创建一个包含原始json串的json对象  
//		                  System.out.println(dataJson.getString("Add"));
//	                	
//	                }
	                
	                
	                
//	                try {
//	                	
//	                    JSONObject dataJson = new JSONObject(s);// 创建一个包含原始json串的json对象  
//	                   System.out.println(dataJson==null);
//	                    System.out.println(dataJson.getJSONObject("Info"));
//	                    
//	                    
//	                	
//	                   name =dataJson.getJSONObject("properties").getString("Name");
//	                   tel = dataJson.getJSONObject("properties").getString("Tel");
//	                   add = dataJson.getJSONObject("properties").getString("Add");
//	                   px = dataJson.getJSONObject("properties").getString("Px");
//	                   py = dataJson.getJSONObject("properties").getString("Py");
//	                   orgclass = dataJson.getJSONObject("properties").getString("Orgclass");
//	                   keyword = dataJson.getJSONObject("properties").getString("Keyword");
//	                   pic = dataJson.getJSONObject("properties").getString("Picture1");
//	                   TravelViewBean bean  = new TravelViewBean( pic, name, add, tel, px, py,orgclass,keyword);
//	                   int pk = (Integer) session.save(bean);
//	                  
	                   
//	                } catch (JSONException e) {  
//	                    // TODO Auto-generated catch block  
//	                    e.printStackTrace();  
//	                }
//	            	br.close();
	              }  
	            
	           
//	            session.flush();
//                tx.commit();
//                count++;
//                session.close();
//                HibernateUtil.close();
//	            
//	             br.close();  
	  	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
		 
	    }  
}


