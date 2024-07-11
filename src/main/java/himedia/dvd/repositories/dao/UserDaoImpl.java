package himedia.dvd.repositories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.dvd.repositories.vo.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<UserVo> selectAllUsers() {
        List<UserVo> list = sqlSession.selectList("users.selectAllUsers");
        return list;
    }
    @Override
    public int insert(UserVo user) {
        return sqlSession.insert("users.insert", user);
    }

    @Override
    public UserVo selectUserByEmail(String email) {
    	UserVo vo = sqlSession.selectOne("users.selectUserByEmail", email); 
        return vo;
    }

    @Override
    public UserVo selectUserByEmailAndPassword(String email, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        return sqlSession.selectOne("users.selectUserByEmailAndPassword", params);
    }
	
	@Override
	public int update(UserVo uservo) {
		return sqlSession.update("updateuser.getUpdate", uservo);
	}
	
    
	@Override
	public UserVo getUpdate(Long updateNo) {
		return sqlSession.selectOne("updateuser.getUpdate", updateNo);
	}
	
    

	
}
