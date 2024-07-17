package himedia.dvd.repositories.dao;

import java.util.List;

import himedia.dvd.repositories.vo.CouponVo;

public interface CouponDao {

	List<CouponVo> getAllCoupons();

	CouponVo getCouponById(Long couponId);

	int insertCoupon(CouponVo couponVo);

	void issuedCoupon(Long couponId, Long userId);

	void expiryCoupon(Long couponId);
	
	
}

