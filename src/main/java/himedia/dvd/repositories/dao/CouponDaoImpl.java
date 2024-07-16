//package himedia.dvd.repositories.dao;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import himedia.dvd.repositories.vo.CouponVo;
//
//@Repository("couponDao")
//public class CouponDaoImpl implements CouponDao {
//	
//	private List<CouponVo> coupons = new ArrayList<>();
//
//    @Override
//    public List<CouponVo> getAllCoupons() {
//        return coupons;
//    }
//
//    @Override
//    public CouponVo getCouponById(Long couponId) {
//        for (CouponVo coupon : coupons) {
//            if (coupon.getCouponId().equals(couponId)) {
//                return coupon;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void addCoupon(CouponVo couponVo) {
//        couponVo.setCouponId((long) (coupons.size() + 1)); // 간단한 예시용
//        coupons.add(couponVo);
//    }
//
//    @Override
//    public void issueCoupon(Long couponId, Long userId) {
//        CouponVo coupon = getCouponById(couponId);
//        if (coupon != null && coupon.getUserId() == null) {
//            coupon.setUserId(userId);
//            coupon.setIssueDate(new Date());
//        }
//    }
//
//    @Override
//    public void useCoupon(Long couponId, Long userId) {
//        CouponVo coupon = getCouponById(couponId);
//        if (coupon != null && coupon.getUserId().equals(userId)) {
//            coupon.setUsed(true);
//        }
//    }
//
//    @Override
//    public void expireCoupon(Long couponId) {
//        CouponVo coupon = getCouponById(couponId);
//        if (coupon != null) {
//            coupon.setExpiryDate(new Date());
//        }
//    }
//}
