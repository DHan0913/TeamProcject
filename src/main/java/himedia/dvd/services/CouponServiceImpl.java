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
}
