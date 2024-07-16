package himedia.dvd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.dvd.repositories.dao.UserDao;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean hasPermission(Long userNo, Long productNo) {
		int count = userDao.hasPermission(userNo, productNo);
		return count > 0;
	}
}
