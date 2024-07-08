package himedia.dvd.repositories.dao;

import himedia.dvd.repositories.vo.UserVo;

public interface UserDao {
    int insert(UserVo user);	//	회원 가입
    UserVo selectUserByEmail(String email);	//	중복 이메일	
    UserVo selectUserByEmailAndPassword(String email, String password);	//	로그인용
}
