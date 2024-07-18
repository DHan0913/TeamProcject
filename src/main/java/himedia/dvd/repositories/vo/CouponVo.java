package himedia.dvd.repositories.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CouponVo {

	private Long couponId; // 쿠폰 아이디
	private String couponCode; // 쿠폰 코드
	private Date issuedDate; // 지급일
	private Date expiryDate; // 만료일
	private Long userId; // 발급된 사용자 ID
	private String expiryYn; // 쿠폰 만료 상태


	public CouponVo() {

	}

	public CouponVo(Long couponId, String couponCode, Date issuedDate, Date expiryDate, Long userId,
			String expiryYn) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.issuedDate = issuedDate;
		this.expiryDate = expiryDate;
		this.userId = userId;
		this.expiryYn = expiryYn;
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

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
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


	public String getExpiryYn() {
		return expiryYn;
	}

	public void setExpiryYn(String expiryYn) {
		this.expiryYn = expiryYn;
	}

	@Override
	public String toString() {
		return "CouponVo [couponId=" + couponId + ", couponCode=" + couponCode + ", issuedDate=" + issuedDate
				+ ", expiryDate=" + expiryDate + ", userId=" + userId + ", expiryYn=" + expiryYn + "]";
	}

}
