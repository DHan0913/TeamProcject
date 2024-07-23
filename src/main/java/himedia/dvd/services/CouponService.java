package himedia.dvd.services;

import java.util.List;
import himedia.dvd.repositories.vo.CouponVo;

public interface CouponService {
    List<CouponVo> getAllCoupons();

    CouponVo getCouponById(Long couponId);

    boolean addCoupon(CouponVo couponVo);

    boolean issuedCoupon(Long couponId, Long userNo);

    boolean expiryCoupon(Long couponId);
    
    void updateCouponExpiryStatus(Long couponId, String isExpired);

    // 만료된 쿠폰 목록 보기
    List<CouponVo> getExpiredCoupons();

    String couponCheck(CouponVo couponVo);

    boolean isCouponValid(String couponCode, String expiryYn);

    boolean checkCouponExistence(String couponCode);
    
    // 24.07.18 예성
    // 지급한 쿠폰 리스트 목록
    List<CouponVo> getCouponList();
}
 