package himedia.dvd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.dvd.repositories.dao.UserDao;
import himedia.dvd.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

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
        return userDao.selectUserByEmailAndPassword(email, password);
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
	public boolean update(UserVo vo) {
		int updatedCount = userDao.update(vo);
		return updatedCount == 1;
	}
    
}
