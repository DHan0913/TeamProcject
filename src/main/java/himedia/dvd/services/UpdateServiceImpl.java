package himedia.dvd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.dvd.repositories.dao.UpdateDao;
import himedia.dvd.repositories.vo.UserVo;

@Service("updateService")
public class UpdateServiceImpl implements UpdateService {
	@Autowired
	private UpdateDao updateDao;

	@Override
	public boolean update(UserVo vo) {

		return false;
	}

	@Override
	public UserVo getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVo getUser(String emial, String birth) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
