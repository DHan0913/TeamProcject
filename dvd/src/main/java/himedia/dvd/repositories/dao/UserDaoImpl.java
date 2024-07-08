package himedia.dvd.repositories.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import himedia.dvd.repositories.vo.UserVo;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int insert(UserVo user) {
        return sqlSession.insert("users.insert", user);
    }

    @Override
    public UserVo selectUserByEmail(String email) {
        return sqlSession.selectOne("users.selectUserByEmail", email);
    }

    @Override
    public UserVo selectUserByEmailAndPassword(String email, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        return sqlSession.selectOne("users.selectUserByEmailAndPassword", params);
    }
}
