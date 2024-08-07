package himedia.dvd.repositories.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import himedia.dvd.repositories.vo.CouponVo;

public interface CouponDao {
	
    List<CouponVo> getAllCoupons();	//	모든 쿠폰 조회

    CouponVo getCouponById(Long couponId);	//	

    int insertCoupon(CouponVo couponVo);

    void issuedCoupon(Long couponId, Long userNo);

    void expiryCoupon(Long couponId);
    
    void updateCouponExpiryStatus(Long couponId, String isExpired);
    
    // 만료된 쿠폰 목록 보기
    List<CouponVo> getExpiredCoupons();

    String couponCheck(CouponVo couponVo);

    CouponVo getCouponByCode(String couponCode);
    
    CouponVo getCouponByCodeAndStatus(String couponCode, String expiryYn);
    
    // 24.07.18 예성
    // 지급한 쿠폰 목록
    List<CouponVo> getCouponList();
}
