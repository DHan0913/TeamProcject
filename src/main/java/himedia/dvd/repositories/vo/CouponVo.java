package himedia.dvd.repositories.vo;

import java.util.Date;

public class CouponVo {

	private Long couponId; // 쿠폰 아이디
	private String couponCode; // 쿠폰 코드
	private Date issueDate; // 지급일
	private Date expiryDate; // 만료일
	private Long userId; // 발급된 사용자 ID

	public CouponVo() {
		
	}
	
	public CouponVo(Long couponId, String couponCode, Date issueDate, Date expiryDate, Long userId) {
        this.couponId = couponId;
        this.couponCode = couponCode;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.userId = userId;
    }
	

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
