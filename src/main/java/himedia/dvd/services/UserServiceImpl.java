package himedia.dvd.services;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import himedia.dvd.repositories.dao.UserDao;
import himedia.dvd.repositories.vo.CashVo;
import himedia.dvd.repositories.vo.CommentVo;
import himedia.dvd.repositories.vo.CouponVo;
import himedia.dvd.repositories.vo.NoticeVo;
import himedia.dvd.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    private ObjectMapper objectMapper = new ObjectMapper();	
    
    @Override
    public boolean join(UserVo vo) {
        if (userDao.selectUserByEmail(vo.getEmail()) != null) {
            return false; // 중복 이메일 존재
        }
        return userDao.insert(vo) == 1;
    }

    @Override
    public UserVo login(String email) {
        UserVo userVo = userDao.selectUserByEmail(email);
        System.out.println("Service UserVo:" + userVo);
        return userVo;
    }

    @Override
    public UserVo login(String email, String password) {
        UserVo userVo = userDao.selectUserByEmailAndPassword(email, password);
        return userVo;
    }

    @Override
    public boolean isAuthenticated(HttpServletRequest request) {
        // 세션을 통해서 사용자 인증 상태 체크
        HttpSession session = request.getSession(false);

        if (session != null) { // 인증했을 가능성이 있다
            UserVo authUser = (UserVo) session.getAttribute("authUser");
            return authUser != null;
        }
        return false;
    }

    @Override
    public List<UserVo> getAllUsers() {
        List<UserVo> list = userDao.selectAllUsers();
        return list;
    }

    @Override
    public UserVo getUserByEmail(String email) {
        return userDao.selectUserByEmail(email);
    }

    @Override
    public boolean updatePassword(Long userNo, String password) {
        return userDao.updatePassword(userNo, password) > 0;
    }

    // 탈퇴 요청
    @Override
    public boolean deleteUser(String email) {
        return userDao.deactivateUser(email) > 0;
    }

    // 캐시 요청
    @Override
    public boolean requestCash(String requestId, Double amount) {
        CashVo cashVo = userDao.insertCashRequest(requestId, amount);
        return cashVo != null;
    }

    // 요청 리스트
    @Override
    public List<CashVo> getAllCashRequests() {
        return userDao.selectAllCashRequests();
    }

    // 요청 승인
    @Override
    public boolean approveCashRequest(CashVo cashVo) {
        cashVo.setApproveDate(new Date(System.currentTimeMillis()));
        return userDao.approveCashRequest(cashVo);
    }

    // 요청 거절
    @Override
    public boolean rejectCashRequest(CashVo cashVo) {
        return userDao.rejectCashRequest(cashVo);
    }

    //	유저 비밀번호 초기화
    @Override
    public boolean resetPassword(Long userNo) {
        return userDao.reset(userNo);
    }

    // 충전된 금액
    @Override
    public double getApprovedCashAmountByEmail(String email) {
        return userDao.getApprovedCashAmountByEmail(email);
    }

    // 충전 내역
    @Override
    public List<CashVo> getCashHistory(String requestId) {
        return userDao.getCashHistory(requestId);
    }

    // 예성씌 파트
    @Override
    public boolean insertCash(String requestId) {
        CashVo cashVo = userDao.insertCash(requestId);
        return cashVo != null;
    }
    // 유저 삭제
    @Override
    public void deleteUser(Long userNo) {
        userDao.delete(userNo);
    }

    // 쿠폰 코드의 유효성 검사 메서드
    @Override
    public long getCouponCountByCodeAndStatus(String couponCode) {
        return userDao.getCouponCountByCodeAndStatus(couponCode);
    }

    // 사용한 쿠폰 삭제
    @Override
    public void expiryCouponByCouponCode(String couponCode) {
        userDao.expiryCouponByCouponCode(couponCode);
    }
    
    //	캐시 충전
    @Override
    public void chargeCashByCoupon(CashVo cashVo) {
        userDao.chargeCashByCoupon(cashVo);
    }

    // 시청 내역 조회
    @Override
    public List<Map<String, Object>> getWatchHistory(Long userNo) {
        return userDao.getWatchHistory(userNo);
    }

	@Override
	public boolean addNotice(NoticeVo notice) {
		return userDao.insertNotice(notice) > 0;
	}

	@Override
	public List<NoticeVo> getAllNotices() {
		return userDao.getAllNotices();
	}

	@Override
	public NoticeVo getLatestNotice() {
		return userDao.getLatestNotice();
	}

	@Override
	public boolean deleteNotice(Long id) {
		return userDao.deleteNotice(id) > 0;
	}

	@Override
	public NoticeVo getNoticedetail(Long id) {
		return userDao.selectNoticeById(id);
	}
	
	//댓글 보기
	@Override
	public List<CommentVo> getComment(Long id) {
	   return userDao.selectCommentsByNoticeId(id);
	 }
	
	//댓글 달기
	@Override
	public boolean addComment(CommentVo commentVo) {
	   return userDao.insertComment(commentVo) > 0;
	}

	@Override
    public boolean addReply(CommentVo commentVo) {
        return userDao.insertReply(commentVo) > 0;
    }
	
	@Override
	public List<CommentVo> getReplies(Long commentId) {
		return userDao.selectRepliesByCommentId(commentId);
	}
	
	 @Override
	 public boolean updateReplies(Long commentId, List<CommentVo> replies) {
	        return userDao.updateReplies(commentId, replies) > 0;
	    }


	@Override
	public List<CommentVo> getCommentFromAdmin(Long userNo) {
		return userDao.selectCommentFromAdmin(userNo);
	}

	 @Override
	    public boolean updateComment(Map<String, Object> params) {
	        int result = userDao.updateComment(params);
	        return result > 0;
	    }
	 
	 @Override
	    public boolean updateReply(Map<String, Object> params) {
	        int result = userDao.updateReply(params);
	        return result > 0;
	    }

	}

