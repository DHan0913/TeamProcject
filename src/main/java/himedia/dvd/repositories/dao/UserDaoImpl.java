package himedia.dvd.repositories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.dvd.repositories.vo.CashVo;
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

	// 유저 번호로 삭제
	@Override
	public boolean delete(Long userNo) {
		int count = sqlSession.delete("users.deleteUser", userNo);
		return count == 1;
	}
	//요청
		 @Override
		    public CashVo insertCashRequest(String requestId, Double amount) {
		        CashVo cashVo = new CashVo();
		        cashVo.setRequestId(requestId);
		        cashVo.setAmount(amount);


	// 유저 비밀번호 초기화
	@Override
	public boolean reset(Long userNo) {
		return sqlSession.update("users.resetUser", userNo) == 1;
	}

		        int count = sqlSession.insert("users.insertCashRequest", cashVo);

		        if (count > 0) {
		            return cashVo; // 캐시 요청이 성공적으로 추가되었으면 CashVo 객체를 반환
		        } else {
		            return null; // 실패 시 null 반환
		        }
		    }
		 
		//요청 리스트
		 	@Override
		    public List<CashVo> selectAllCashRequests() {
		        return sqlSession.selectList("users.selectAllCashRequests");
		    }
		 
		 	// 요청 승인
		 	@Override
		 	public boolean approveCashRequest(CashVo cashVo) {
		 	    int count = sqlSession.update("users.approveCashRequest", cashVo);
		 	    return count == 1;
		 	}


		 	//요청 거절
		 	@Override
		 	public boolean rejectCashRequest(CashVo cashVo) {
		 	    int count = sqlSession.update("users.rejectCashRequest", cashVo);
		 	    return count == 1;
		 	}
		    
}
