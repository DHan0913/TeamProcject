package himedia.dvd.repositories.dao;

import java.util.List;

import himedia.dvd.repositories.vo.CashVo;
import himedia.dvd.repositories.vo.UserVo;

public interface UserDao {
	List<UserVo> selectAllUsers();

	int insert(UserVo user); // 회원 가입

	UserVo selectUserByEmail(String email); // 중복 이메일

	UserVo selectUserByEmailAndPassword(String email, String password); // 로그인용

	boolean update(UserVo user); // 회원정보수정

	boolean delete(Long userNo); // 유저 번호로 삭제
	CashVo insertCashRequest(String requestId, Double amount); //충전요청
	List<CashVo> selectAllCashRequests();//요청 리스트
	boolean approveCashRequest(CashVo cashVo); // 요청 승인
	boolean rejectCashRequest(CashVo cashVo); // 요청 거절


}
