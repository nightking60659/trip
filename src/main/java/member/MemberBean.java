package member;

public class MemberBean {
String mid;
String password;

public MemberBean(String mid,String password) {
	this.mid=mid;
	this.password=password;
}
public MemberBean() {
	
}
public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
