package himedia.dvd.services;

import java.util.List;
import himedia.dvd.repositories.vo.CouponVo;

public interface CouponService {
    List<CouponVo> getAllCoupons();	//	모든 쿠폰 조회

    CouponVo getCouponById(Long couponId);	//	특정 ID 쿠폰 조회

    boolean addCoupon(CouponVo couponVo);	//	쿠폰 추가

    boolean issuedCoupon(Long couponId, Long userNo);	//	쿠폰 발급

    boolean expiryCoupon(Long couponId);	//	쿠폰 만료
    
    void updateCouponExpiryStatus(Long couponId, String isExpired);	//	특정 쿠폰 만료상태 업데이트

    List<CouponVo> getExpiredCoupons();	 // 만료된 쿠폰 목록 보기

    String couponCheck(CouponVo couponVo);	//	쿠폰 중복 여부 확인

    boolean isCouponValid(String couponCode, String expiryYn);	//	쿠폰 유효성 검사

    boolean checkCouponExistence(String couponCode);	//	쿠폰 코드 존재 여부
    
    // 24.07.18 예성
    // 지급한 쿠폰 리스트 목록
    List<CouponVo> getCouponList();
}
 