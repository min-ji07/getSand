package model;

public class User {
	private String userName;
	private String userid;
	private String password;
	private int point;
	private String cardNumber;
	private String order;
	private int accOder; // 누적 주문횟수 (쿠폰용)
	
	
	static private User loginedUser;   //로그인한 회원의 회원정보 담기는 변수
	
	public User() {
		
	}

	public User(String userName, String userid, String password, int point, String cardNumber,int accOder) {
		
		this.userName = userName;
		this.userid = userid;
		this.password = password;
		this.point = point;
		this.cardNumber = cardNumber;
		this.accOder = accOder;
	}
	
	
	
	
	public static void setLoginedUser(User loginedUser) {
		
		User.loginedUser = loginedUser;
		
	}
	
	public static User getLoginedUser() {
		return  User.loginedUser;
	}
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getAccOder() {
		return accOder;
	}

	public void setAccOder(int accOder) {
		this.accOder = accOder;
	}
	
	

}
