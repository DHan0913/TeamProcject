package himedia.dvd.services;

import himedia.dvd.repositories.vo.UserVo;

public interface UpdateService {
	public boolean update(UserVo vo);
	public UserVo getUser(String email);
	public UserVo getUser(String emial, String birth);
	
}
