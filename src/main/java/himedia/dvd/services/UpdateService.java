package himedia.dvd.services;

import himedia.dvd.repositories.vo.UserVo;

public interface UpdateService {
	boolean updateUser(UserVo user);

	UserVo getUserById(Long userNo);

}