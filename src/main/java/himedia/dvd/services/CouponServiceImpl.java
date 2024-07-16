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
        return couponDao.getAllCoupons();
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
    public boolean issueCoupon(Long couponId, Long userId) {
        try {
            couponDao.issueCoupon(couponId, userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean expireCoupon(Long couponId) {
        try {
            couponDao.expireCoupon(couponId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
}
