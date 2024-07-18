package himedia.dvd.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.dvd.repositories.vo.CouponVo;

@Repository("couponDao")
public class CouponDaoImpl implements CouponDao {

	@Autowired
	private SqlSession sqlSession;

	// 쿠폰 리스트 출력
	@Override
	public List<CouponVo> getAllCoupons() {
		List<CouponVo> coupons = sqlSession.selectList("coupons.getAllCoupons");
		for (CouponVo coupon : coupons) {
			System.out.println("쿠폰 아이디: " + coupon.getCouponId());
			System.out.println("쿠폰 코드: " + coupon.getCouponCode());
			System.out.println("만료일: " + coupon.getExpiryDate());
			System.out.println("발급일: " + coupon.getIssuedDate());
		}
		return coupons;
	}

	@Override
	public CouponVo getCouponById(Long couponId) {
		CouponVo coupon = sqlSession.selectOne("getCouponById", couponId);
		return coupon;
	}

	// 쿠폰 추가
	@Override
	public int insertCoupon(CouponVo couponVo) {
		return sqlSession.insert("coupons.createCoupon", couponVo);
	}

	// 쿠폰 지급
	@Override
	public void issuedCoupon(Long couponId, Long userNo) {
		CouponVo coupon = new CouponVo();
		coupon.setCouponId(couponId);
		coupon.setUserId(userNo);
		sqlSession.update("coupons.issuedCoupon", coupon);
	}

	// 쿠폰 만료
	@Override
	public void expiryCoupon(Long couponId) {
		sqlSession.update("coupons.expiryCoupon", couponId);
	}

	// 쿠폰 만료 상태 업데이트
	@Override
	public void updateCouponExpiryStatus(Long couponId, String isExpired) {
		CouponVo coupon = new CouponVo();
		coupon.setCouponId(couponId);
		coupon.setExpiryYn(isExpired);
		sqlSession.update("coupons.updateCouponExpiryStatus", coupon);
	}
	
	// 만료된 쿠폰 목록 보기
	@Override
	public List<CouponVo> getExpiredCoupons() {
	    return sqlSession.selectList("coupons.getExpiredCoupons");
	}
	
	@Override
	public String couponCheck(CouponVo couponVo) {
		String couponChk = sqlSession.selectOne("getCouponCheck", couponVo);
		return couponChk;
	}
}
