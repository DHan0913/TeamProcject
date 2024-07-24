package himedia.dvd.repositories.dao;

import java.util.List;
import java.util.Map;

import himedia.dvd.repositories.vo.CashVo;
import himedia.dvd.repositories.vo.CommentVo;
import himedia.dvd.repositories.vo.CouponVo;
import himedia.dvd.repositories.vo.NoticeVo;
import himedia.dvd.repositories.vo.UserVo;

public interface UserDao {
	List<UserVo> selectAllUsers(); // 모든 사용자 선택
	int insert(UserVo user); // 회원 가입
	UserVo selectUserByEmail(String email); // 중복 이메일 확인
	UserVo selectUserByEmailAndPassword(String email, String password); // 로그인용 사용자 선택
	int updatePassword(Long userNo, String password); // 비밀번호 수정
	int deactivateUser(String email); // 사용자 비활성화 (삭제 요청)
	CashVo insertCashRequest(String requestId, Double amount); // 충전 요청
	List<CashVo> selectAllCashRequests(); // 모든 충전 요청 리스트
	boolean approveCashRequest(CashVo cashVo); // 충전 요청 승인
	boolean rejectCashRequest(CashVo cashVo); // 충전 요청 거절
	int hasPermission(Long userNo, Long productNo); // 권한 확인
	boolean reset(Long userNo); // 회원 비밀번호 초기화
	List<CashVo> getCashHistory(String requestId); // 충전 내역 조회
	double getApprovedCashAmountByEmail(String email); // 승인된 충전 금액 조회
	void delete(Long userNo); // 사용자 삭제

	// 예성씌 파트
	void setPermission(Long userNo, Long productNo); // 시청 권한 부여
	CashVo insertCash(String requestId); // 구매 후 캐시 차감

	long getCouponCountByCodeAndStatus(String couponCode); // 쿠폰 유효성 검사
	void expiryCouponByCouponCode(String couponCode); // 사용한 쿠폰 삭제
	void chargeCashByCoupon(CashVo cashVo); //  캐시 충전
	
	List<Map<String, Object>> getWatchHistory(Long userNo); // 시청 내역 조회
	
	int insertNotice(NoticeVo notice); //공지사항 추가
	List<NoticeVo> getAllNotices(); //공지사항 출력
	NoticeVo getLatestNotice(); //최근 공지사항 띄우기
	int deleteNotice(Long id); // 공지사항 삭제
	NoticeVo selectNoticeById(Long id); //공지사항 조회
	List<CommentVo> selectCommentsByNoticeId(Long id); // 댓글 조회
	int insertComment(CommentVo commentVo); // 댓글달기
}
