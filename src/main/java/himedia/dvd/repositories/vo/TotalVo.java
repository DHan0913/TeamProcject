package himedia.dvd.repositories.vo;

public class TotalVo {
	private String totalAmt;	// 총매출액
	private String productname; // 상품명
	private String productamt; 	// 상품매출
	private String userNo;		// 유저넘버
	private String username;	// 유저이름
	private String useramt;		// 유저 총 매출
	

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductamt() {
		return productamt;
	}

	public void setProductamt(String productamt) {
		this.productamt = productamt;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseramt() {
		return useramt;
	}

	public void setUseramt(String useramt) {
		this.useramt = useramt;
	}

	
	
	
}
