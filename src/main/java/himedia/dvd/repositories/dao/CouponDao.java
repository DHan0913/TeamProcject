package himedia.dvd.repositories.dao;

import java.util.List;

import himedia.dvd.repositories.vo.CouponVo;

public interface CouponDao {

	List<CouponVo> getAllCoupons();

	CouponVo getCouponById(Long couponId);

	int insertCoupon(CouponVo couponVo);

	void issueCoupon(Long couponId, Long userId);

	void expireCoupon(Long couponId);
	
	
}
