package himedia.dvd.services;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.dvd.repositories.dao.UserDao;
import himedia.dvd.repositories.vo.CashVo;
import himedia.dvd.repositories.vo.CouponVo;
import himedia.dvd.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public boolean join(UserVo vo) {
		if (userDao.selectUserByEmail(vo.getEmail()) != null) {
			return false; // 중복 이메일 존재
		}
		return userDao.insert(vo) == 1;
	}

	@Override
	public UserVo login(String email) {
		UserVo userVo = userDao.selectUserByEmail(email);
		System.out.println("Service UserVo:" + userVo);
		return userVo;
	}

	@Override
	public UserVo login(String email, String password) {
		UserVo userVo = userDao.selectUserByEmailAndPassword(email, password);
		return userVo;
	}

	@Override
	public boolean isAuthenticated(HttpServletRequest request) {
		// 세션을 통해서 사용자 인증 상태 체크
		HttpSession session = request.getSession(false);

		if (session != null) { // 인증했을 가능성이 있다
			UserVo authUser = (UserVo) session.getAttribute("authUser");
			return authUser != null;
		}
		return false;
	}

	@Override
	public List<UserVo> getAllUsers() {
		List<UserVo> list = userDao.selectAllUsers();
		return list;
	}

	@Override
	public UserVo getUserByEmail(String email) {
		return userDao.selectUserByEmail(email);
	}

	@Override
	public boolean updateUser(UserVo vo) {
		return userDao.update(vo);
	}

	// 탈퇴 요청
	@Override
	public boolean deleteUser(String email) {
		return userDao.deactivateUser(email) > 0;
	}

	// 캐시 요청
	@Override
	public boolean requestCash(String requestId, Double amount) {
		CashVo cashVo = userDao.insertCashRequest(requestId, amount);
		return cashVo != null;
	}

	// 요청리스트
	@Override
	public List<CashVo> getAllCashRequests() {
		return userDao.selectAllCashRequests();
	}

	// 요청 승인
	@Override
	public boolean approveCashRequest(CashVo cashVo) {
		cashVo.setApproveDate(new Date(System.currentTimeMillis()));
		return userDao.approveCashRequest(cashVo);
	}

	// 요청 거절
	@Override
	public boolean rejectCashRequest(CashVo cashVo) {
		return userDao.rejectCashRequest(cashVo);
	}

	@Override
	public boolean resetPassword(Long userNo) {
		return userDao.reset(userNo);

	}

	// 충전된 금액
	@Override
	public double getApprovedCashAmountByEmail(String email) {
		return userDao.getApprovedCashAmountByEmail(email);
	}

	// 충전내역
	@Override
	public List<CashVo> getCashHistory(String requestId) {
		return userDao.getCashHistory(requestId);
	}

	////////////// 예성씌 파트
	@Override
	public boolean insertCash(String requestId) {
		CashVo cashVo = userDao.insertCash(requestId);
		return cashVo != null;
	}

	// 쿠폰 코드의 유효성 검사 메서드
    @Override
    public boolean isCouponValid(String couponCode, String expiryYn) {
        Map<String, Object> params = new HashMap<>();
        params.put("couponCode", couponCode);
        params.put("expiryYn", expiryYn);

        CouponVo coupon = userDao.getCouponByCodeAndStatus(params);
        if (coupon != null && coupon.getExpiryYn().equals("N") && coupon.getExpiryDate().compareTo(new java.util.Date()) >= 0) {
            return true;
        }
        return false;
    }

	// 쿠폰 코드 중복 여부 확인 메서드
	@Override
	public boolean checkCouponExistence(String couponCode) {
		CouponVo coupon = userDao.getCouponByCode(couponCode);
		return coupon != null;
	}

}
