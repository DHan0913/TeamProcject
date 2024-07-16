package himedia.dvd.services;

import java.util.List;

import himedia.dvd.repositories.vo.CouponVo;

public interface CouponService {
	List<CouponVo> getAllCoupons();

    CouponVo getCouponById(Long couponId);

    boolean addCoupon(CouponVo couponVo);

    boolean issueCoupon(Long couponId, Long userId);

    boolean expireCoupon(Long couponId);

}
