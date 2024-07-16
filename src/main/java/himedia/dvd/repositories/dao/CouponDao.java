package himedia.dvd.repositories.dao;

import java.util.List;

import himedia.dvd.repositories.vo.CouponVo;

public interface CouponDao {

	List<CouponVo> getAllCoupons();

	CouponVo getCouponById(Long couponId);

	void addCoupon(CouponVo couponVo);

	void issueCoupon(Long couponId, Long userId);

	void useCoupon(Long couponId, Long userId);

	void expireCoupon(Long couponId);
}
