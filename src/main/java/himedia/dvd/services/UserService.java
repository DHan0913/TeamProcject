package himedia.dvd.services;

import java.util.List;
import java.util.Map;

import himedia.dvd.repositories.vo.CashVo;
import himedia.dvd.repositories.vo.CommentVo;
import himedia.dvd.repositories.vo.NoticeVo;
import himedia.dvd.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	boolean join(UserVo vo); // 회원 가입

	UserVo login(String email);

	UserVo login(String email, String password); // 로그인

	List<UserVo> getAllUsers();

	boolean isAuthenticated(HttpServletRequest request); // 인증 체크 메서드

	UserVo getUserByEmail(String email); // 이메일로 회원정보 불러오기

	boolean updatePassword(Long userNo, String password); // 비밀번호 변경

	boolean deleteUser(String email); // 회원정보 삭제 요청

	boolean requestCash(String requestId, Double amount); // 캐시 요청

	List<CashVo> getAllCashRequests(); // 요청 리스트

	boolean approveCashRequest(CashVo cashVo); // 요청 승인

	boolean rejectCashRequest(CashVo cashVo); // 요청 거절

	double getApprovedCashAmountByEmail(String email); // 충전된 금액

	List<CashVo> getCashHistory(String requestId); // 충전 내역 조회

	// 예성씌 파트
	boolean insertCash(String requestId); // 캐시 차감

	boolean resetPassword(Long userNo); // 유저 비밀번호 초기화

	void deleteUser(Long userNo); // 유저 삭제

	long getCouponCountByCodeAndStatus(String couponCode); // 쿠폰 코드와 상태로 쿠폰 수 조회
	void expiryCouponByCouponCode(String couponCode); // 사용한 쿠폰 만료
	void chargeCashByCoupon(CashVo cashVo); //  캐시 충전
	
	

	List<Map<String, Object>> getWatchHistory(Long userNo); // 시청 내역 조회
	
	
	boolean addNotice(NoticeVo notice); // 공지사항 등록
	List<NoticeVo> getAllNotices(); // 공지사항 목록
	List<NoticeVo> getAlladminNotices(); // 관리자 공지사항
	NoticeVo getLatestNotice(); // 최근공지사항 띄우기
	boolean deleteNotice(Long id); // 공지사항 삭제
	NoticeVo getNoticedetail(Long id); // 공지사항 상세조회
 
	List<CommentVo> getComment(Long id); // 댓글 리스트
    boolean addComment(CommentVo commentVo); // 댓글 추가
    boolean addReply(CommentVo commentVo);// 대댓글 추가
    List<CommentVo> getReplies(Long commentId); // 대댓글 리스트
    boolean updateReplies(Long commentId, List<CommentVo> replies); // 대댓글 리스트 띄우기
	List<CommentVo> getCommentFromAdmin(Long id); // 댓글 리스트

	boolean updateComment(Map<String, Object> params); // 댓글 수정
	boolean updateReply(Map<String, Object> params); // 대댓글 수정
 
	boolean deleteComment(Map<String, Object> params); // 댓글 삭제
	boolean deleteReply(Map<String, Object> params); // 대댓글 삭제






}
