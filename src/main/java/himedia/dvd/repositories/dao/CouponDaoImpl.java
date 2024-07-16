package himedia.dvd.repositories.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.dvd.repositories.vo.CouponVo;

@Repository("couponDao")
public class CouponDaoImpl implements CouponDao {
	@Autowired
    private SqlSession sqlSession;
	
	//	쿠폰 리스트 출력
	@Override
    public List<CouponVo> getAllCoupons() {
		List<CouponVo> list = sqlSession.selectList("coupons.getAllCoupons");
        return list;
    }

    @Override
    public CouponVo getCouponById(Long couponId) {
        return sqlSession.selectOne("getCouponById", couponId);
    }
    
    //	쿠폰 추가
    @Override
    public int insertCoupon(CouponVo couponVo) {
    	return sqlSession.insert("coupons.createCoupon", couponVo);
    }

    //	쿠폰 지급
    @Override
    public void issueCoupon(Long couponId, Long userId) {
        CouponVo coupon = new CouponVo();
        coupon.setCouponId(couponId);
        coupon.setUserId(userId);
        sqlSession.update("issueCoupon", coupon);
    }

    
    //	쿠폰 만료
    @Override
    public void expireCoupon(Long couponId) {
        sqlSession.update("expireCoupon", couponId);
    }
}