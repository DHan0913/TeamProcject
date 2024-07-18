package himedia.dvd.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// 240718 예성 수정
	@Override
	public boolean issueCouponToUser(Long couponId, String email) {
		Long couponIdFromDB = couponDao.getCouponIdByCode(couponId.toString()); // 쿠폰 코드로 쿠폰 ID 조회
        
        if (couponIdFromDB != null) {
            // 쿠폰을 사용자에게 발급하는 로직 (DAO를 이용하여 데이터베이스에 저장)
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("couponId", couponIdFromDB);
            paramMap.put("email", email);
            
            int rowsAffected = couponDao.issueCouponToUser(paramMap);
            
            return rowsAffected > 0; // 발급 성공 여부를 리턴
        } else {
            return false; // 쿠폰 코드에 해당하는 쿠폰이 없을 경우 발급 실패
        }
	}
	
	
}
