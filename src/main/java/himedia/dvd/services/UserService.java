package himedia.dvd.services;

import java.util.List;

import himedia.dvd.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	boolean join(UserVo vo); // 회원 가입

	UserVo login(String email);

	UserVo login(String email, String password); // 로그인

	List<UserVo> getAllUsers();

	boolean isAuthenticated(HttpServletRequest request); // 인증 체크 메서드

	UserVo getUserByEmail(String email); // 이메일로 회원정보 불러오기

	boolean updateUser(UserVo vo); // 회원정보 수정

	boolean deleteUser(String email); // 회원정보 삭제

	boolean deleteUser(Long userNo); // 유저 번호로 삭제


}
