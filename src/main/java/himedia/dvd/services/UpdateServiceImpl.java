package himedia.dvd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.dvd.repositories.dao.UpdateDao; // UpdateDao 임포트
import himedia.dvd.repositories.vo.UserVo;

@Service
public class UpdateServiceImpl implements UpdateService {

	@Autowired
	private UpdateDao updateDao; // UpdateDao 주입

	@Override
	public boolean updateUser(UserVo user) {
		return updateDao.update(user); // UpdateDao 사용
	}

	@Override
	public UserVo getUserById(Long userNo) {
		return updateDao.getUserById(userNo); // UpdateDao 사용
	}
}
