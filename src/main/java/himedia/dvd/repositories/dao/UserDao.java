package himedia.dvd.repositories.dao;

import java.util.List;
import java.util.Map;

import himedia.dvd.repositories.vo.CashVo;
import himedia.dvd.repositories.vo.CouponVo;
import himedia.dvd.repositories.vo.UserVo;

public interface UserDao {
	List<UserVo> selectAllUsers();
	int insert(UserVo user); // 회원 가입
	UserVo selectUserByEmail(String email); // 중복 이메일
	UserVo selectUserByEmailAndPassword(String email, String password); // 로그인용
	boolean update(UserVo user); // 회원정보수정
	int deactivateUser(String email); // 삭제요청
	CashVo insertCashRequest(String requestId, Double amount); //충전요청
	List<CashVo> selectAllCashRequests();//요청 리스트
	boolean approveCashRequest(CashVo cashVo); // 요청 승인
	boolean rejectCashRequest(CashVo cashVo); // 요청 거절
	int hasPermission(Long userNo, Long productNo); // 권한 확인
	boolean reset(Long userNo); // 회원 비밀번호 초기화
	List<CashVo> getCashHistory(String requestId); // 충전 내역 조회
	double getApprovedCashAmountByEmail(String email); //충전된 금액


	
	// 예성씌 파트
	void setPermission(Long userNo, Long productNo);	// 시청권한 부여
	CashVo insertCash(String requestId);	// 구매 후 캐시 차감

	CouponVo getCouponByCode(String couponCode);
    CouponVo getCouponByCodeAndStatus(Map<String, Object> params);
}
