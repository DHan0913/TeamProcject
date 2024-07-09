package himedia.dvd.services;

import himedia.dvd.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    boolean join(UserVo vo); // 회원 가입
    UserVo login(String email);
    UserVo login(String email, String password); // 로그인
    
    boolean isAuthenticated(HttpServletRequest request); // 인증 체크 메서드
    
    boolean updateuser(UserVo vo);	// 회원정보 수정
}
