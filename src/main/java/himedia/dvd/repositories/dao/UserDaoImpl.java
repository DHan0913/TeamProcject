package himedia.dvd.repositories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.dvd.repositories.vo.CashVo;
import himedia.dvd.repositories.vo.CommentVo;
import himedia.dvd.repositories.vo.CouponVo;
import himedia.dvd.repositories.vo.NoticeVo;
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
        int result = sqlSession.insert("users.insert", user);
        return result;
    }

    // 이메일과 비밀번호로 사용자를 조회
    @Override
    public UserVo selectUserByEmailAndPassword(String email, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        UserVo user = sqlSession.selectOne("users.selectUserByEmailAndPassword", params);
        return user;
    }

    // 이메일로 사용자를 조회
    @Override
    public UserVo selectUserByEmail(String email) {
        UserVo vo = sqlSession.selectOne("users.selectUserByEmail", email);
        return vo;
    }

    // 비밀번호 변경
    @Override
    public int updatePassword(Long userNo, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("userNo", userNo);
        params.put("password", password);
        return sqlSession.update("users.updatePassword", params);
    }

    // 삭제요청
    @Override
    public int deactivateUser(String email) {
        return sqlSession.update("users.deleteUser", email);
    }

    @Override
    public int hasPermission(Long userNo, Long productNo) {
        Map<String, Long> params = new HashMap<>();
        params.put("userNo", userNo);
        params.put("productNo", productNo);
        int count = sqlSession.selectOne("users.hasPermission", params);
        return count;
    }

    // 요청
    @Override
    public CashVo insertCashRequest(String requestId, Double amount) {
        CashVo cashVo = new CashVo();
        cashVo.setRequestId(requestId);
        cashVo.setAmount(amount);

        int count = sqlSession.insert("users.insertCashRequest", cashVo);

        if (count > 0) {
            return cashVo; // 캐시 요청이 성공적으로 추가되었으면 CashVo 객체를 반환
        } else {
            return null; // 실패 시 null 반환
        }
    }

    // 유저 비밀번호 초기화
    @Override
    public boolean reset(Long userNo) {
        int count = sqlSession.update("users.resetUser", userNo);
        return count == 1;
    }

    // 요청 리스트
    @Override
    public List<CashVo> selectAllCashRequests() {
        List<CashVo> list = sqlSession.selectList("users.selectAllCashRequests");
        return list;
    }

    // 요청 승인
    @Override
    public boolean approveCashRequest(CashVo cashVo) {
        int count = sqlSession.update("users.approveCashRequest", cashVo);
        return count == 1;
    }

    // 요청 거절
    @Override
    public boolean rejectCashRequest(CashVo cashVo) {
        int count = sqlSession.update("users.rejectCashRequest", cashVo);
        return count == 1;
    }
    
    // 충전된 금액
    @Override
    public double getApprovedCashAmountByEmail(String email) {
        Double totalAmount = sqlSession.selectOne("users.getApprovedCashAmountByEmail", email);
        return totalAmount != null ? totalAmount : 0.0;
    }
    
    // 충전 내역
    @Override
    public List<CashVo> getCashHistory(String requestId) {
        return sqlSession.selectList("users.getCashHistory", requestId);
    }
    
    // 예성씌 파트
    @Override
    public void setPermission(Long userNo, Long productNo) {
        Map<String, Long> params = new HashMap<>();
        params.put("userNo", userNo);
        params.put("productNo", productNo);
        sqlSession.insert("users.setPermission", params);
    }

    @Override
    public CashVo insertCash(String requestId) {
        CashVo cashVo = new CashVo();
        cashVo.setRequestId(requestId);

        int count = sqlSession.insert("users.insertCash", cashVo);

        if (count > 0) {
            return cashVo;
        } else {
            return null;
        }
    }

    

    //	쿠폰 코드와 상태로 쿠폰 수 조회
    @Override
    public long getCouponCountByCodeAndStatus(String couponCode) {
        return sqlSession.selectOne("users.getCouponCountByCodeAndStatus", couponCode);
    }

    // 사용한 쿠폰 만료
    @Override
    public void expiryCouponByCouponCode(String couponCode) {
        sqlSession.update("users.expiryCouponByCouponCode", couponCode);
    }

    //  캐시 충전
    @Override
    public void chargeCashByCoupon(CashVo cashVo) {
        sqlSession.insert("users.chargeCashByCoupon", cashVo);
    }

    // 탈퇴 시 회원정보 가림 처리
	@Override
	public void delete(Long userNo) {
		sqlSession.update("users.setdeleteUser", userNo);
		
	}

	@Override
	public List<Map<String, Object>> getWatchHistory(Long userNo) {
		 return sqlSession.selectList("users.watchhistory", userNo);
	}

	@Override
	public int insertNotice(NoticeVo notice) {
		int result = sqlSession.insert("users.insertNotice", notice);
		return result;
	}

	@Override
	public List<NoticeVo> getAllNotices() {
		List<NoticeVo> list = sqlSession.selectList("users.selectAllNotices");
		return list;
	}

	@Override
	public NoticeVo getLatestNotice() {
		return sqlSession.selectOne("users.selectLatestNotice");
	}

	@Override
	public int deleteNotice(Long id) {
		return sqlSession.delete("users.deleteNotice",id);
	}

	@Override
	public NoticeVo selectNoticeById(Long id) {
		return sqlSession.selectOne("users.selectNoticedetail", id);
	}

	@Override
	public List<CommentVo> selectCommentsByNoticeId(Long id) {
		return sqlSession.selectList("users.selectCommentsByNoticeId",id);
	}

	@Override
	public int insertComment(CommentVo commentVo) {
		return sqlSession.insert("users.insertComment", commentVo);
	}
	
	
}
