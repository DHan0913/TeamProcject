package himedia.dvd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.dvd.repositories.dao.CouponDao;
import himedia.dvd.repositories.vo.CouponVo;

@Service("couponService")
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponDao couponDao;

    @Override
    public List<CouponVo> getAllCoupons() {
        List<CouponVo> coupons = couponDao.getAllCoupons();
        System.out.println("서비스에서 가져온 쿠폰 목록: " + coupons);
        return coupons;
    }

    @Override
    public CouponVo getCouponById(Long couponId) {
        return couponDao.getCouponById(couponId);
    }

    @Override
    public boolean addCoupon(CouponVo couponVo) {
        int addCount = couponDao.insertCoupon(couponVo);
        return addCount == 1;
    }

    @Override
    public boolean issuedCoupon(Long couponId, Long userNo) {
        try {
            couponDao.issuedCoupon(couponId, userNo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean expiryCoupon(Long couponId) {
        try {
            couponDao.expiryCoupon(couponId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateCouponExpiryStatus(Long couponId, String isExpired) {
        couponDao.updateCouponExpiryStatus(couponId, isExpired);
    }

    // 만료된 쿠폰 목록 보기
    @Override
    public List<CouponVo> getExpiredCoupons() {
        return couponDao.getExpiredCoupons();
    }

    @Override
    public String couponCheck(CouponVo couponVo) {
        return couponDao.couponCheck(couponVo);
    }

    // 쿠폰 코드의 유효성 검사 메서드
    @Override
    public boolean isCouponValid(String couponCode, String expiryYn) {
        CouponVo coupon = couponDao.getCouponByCodeAndStatus(couponCode, expiryYn);
        return coupon != null;
    }

    // 쿠폰 코드 중복 여부 확인 메서드
    @Override
    public boolean checkCouponExistence(String couponCode) {
        CouponVo coupon = couponDao.getCouponByCode(couponCode);
        return coupon != null;
    }

    // 지급된 쿠폰 리스트
    @Override
    public List<CouponVo> getCouponList() {
        return couponDao.getCouponList();
    }
}
