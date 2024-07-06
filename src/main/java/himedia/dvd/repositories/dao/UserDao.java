package himedia.dvd.repositories.dao;

import himedia.dvd.repositories.vo.UserVo;

public interface UserDao {
    int insert(UserVo user);
    UserVo selectUserByEmail(String email);
    UserVo selectUserByEmailAndPassword(String email, String password);
}
