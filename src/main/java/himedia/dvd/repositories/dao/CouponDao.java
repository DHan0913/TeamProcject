package himedia.dvd.repositories.dao;

import java.util.List;

import himedia.dvd.repositories.vo.CouponVo;

public interface CouponDao {

	List<CouponVo> getAllCoupons();

	CouponVo getCouponById(Long couponId);

	int insertCoupon(CouponVo couponVo);

	void issuedCoupon(Long couponId, Long userNo);

	void expiryCoupon(Long couponId);
	
	void updateCouponExpiryStatus(Long couponId, String isExpired);
	
	// 만료된 쿠폰 목록 보기
	List<CouponVo> getExpiredCoupons();

	String couponCheck(CouponVo couponVo);
}

