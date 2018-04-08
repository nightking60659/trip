package _trip_tool;

import java.sql.Date;

public class DateDays{
	
	public static int daysOfTwo(String befor, String after) {
		Date beforDate=Date.valueOf(befor);
		Date afterDate=Date.valueOf(after);
        long m = afterDate.getTime() - beforDate.getTime();
        System.out.println(m);
        m=m/(24*60*60*1000);
        //判斷是不是同一天
       
        return (int)m;
    }
}
