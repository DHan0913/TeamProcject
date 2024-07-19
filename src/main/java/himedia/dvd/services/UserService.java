package himedia.dvd.services;

import java.util.List;

import himedia.dvd.repositories.vo.CashVo;
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

    boolean isCouponValid(String couponCode, String expiryYn); // 쿠폰 유효성 검사

    boolean checkCouponExistence(String couponCode); // 쿠폰 존재 여부 확인
}
