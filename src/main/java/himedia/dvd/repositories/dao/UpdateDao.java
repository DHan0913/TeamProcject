package himedia.dvd.repositories.dao;

import himedia.dvd.repositories.vo.UserVo;

public interface UpdateDao {
	boolean update(UserVo user);

	UserVo getUserById(Long userNo);
}
