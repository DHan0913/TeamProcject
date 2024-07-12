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

    // 모든 사용자를 조회
    @Override
    public List<UserVo> selectAllUsers() {
        List<UserVo> list = sqlSession.selectList("users.selectAllUsers");
        return list;
    }
    
    // 새로운 사용자를 삽입	    
    @Override
    public int insert(UserVo user) {
        return sqlSession.insert("users.insert", user);
    }

    // 이메일과 비밀번호로 사용자를 조회
    @Override
    public UserVo selectUserByEmailAndPassword(String email, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        return sqlSession.selectOne("users.selectUserByEmailAndPassword", params);
    }
    
    // 이메일로 사용자를 조회
    @Override
    public UserVo selectUserByEmail(String email) {
    	UserVo vo = sqlSession.selectOne("users.selectUserByEmail", email); 
    	return vo;
    }
    
    // 사용자의 정보를 업데이트
	@Override
	public boolean update(UserVo user) {
		int count = sqlSession.update("users.updateUser", user);
		return count == 1;
	}
	
	// 사용자를 삭제
	@Override
	public int delete(Long userNo) {
		return sqlSession.delete("users.deleteUser", userNo);
	}

	// 유저 번호로 사용자 조회
	@Override
    public UserVo selectUserByUserNo(Long userNo) {
        return sqlSession.selectOne("users.selectUserByUserNo", userNo);
    }
	
	//	유저 번호로 삭제
	@Override
	public boolean delete(Long userNo) {
		int count = sqlSession.delete("users.deleteUser", userNo);
		return count == 1;
	}
	
	
	
	
	
}
