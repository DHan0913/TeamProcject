package himedia.dvd.repositories.dao;

import java.util.List;

import himedia.dvd.repositories.vo.UserVo;

public interface UserDao {
	List<UserVo> selectAllUsers();
    int insert(UserVo user);	//	회원 가입
    UserVo selectUserByEmail(String email);	//	중복 이메일	
    UserVo selectUserByEmailAndPassword(String email, String password);	//	로그인용
    
    boolean update(UserVo user);	// 회원정보수정
    boolean delete(UserVo user);	// 회원정보삭제
    
    boolean delete(Long userNo);	//	유저 번호로 삭제
    UserVo selectUserByUserNo(Long userNo);    // 유저 번호로 사용자 조회
}
