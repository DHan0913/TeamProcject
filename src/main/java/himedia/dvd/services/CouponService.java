package himedia.dvd.services;

import java.util.List;

import himedia.dvd.repositories.vo.CouponVo;

public interface CouponService {
	List<CouponVo> getAllCoupons();

    CouponVo getCouponById(Long couponId);

    boolean addCoupon(CouponVo couponVo);

    boolean issuedCoupon(Long couponCode, Long userNo);

    boolean expiryCoupon(Long couponId);
    
    void updateCouponExpiryStatus(Long couponId, boolean isExpired);

    // 만료된 쿠폰 목록 보기
    List<CouponVo> getExpiredCoupons();
}
