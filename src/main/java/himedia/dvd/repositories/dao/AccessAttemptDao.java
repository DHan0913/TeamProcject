package himedia.dvd.repositories.dao;

import java.util.List;
import java.util.Optional;

import himedia.dvd.repositories.vo.AccessAttemptVo;

public interface AccessAttemptDao {
	// 널 참조 방지
	// 의미 명확화 없을수도 있음
	Optional<AccessAttemptVo> findByIpAddress(String ipAddress);

	void insert(AccessAttemptVo accessAttempt);

	void update(AccessAttemptVo accessAttempt);

	void deleteByIpAddress(String ipAddress);

	List<AccessAttemptVo> findAllAccessAttempts();

	
	
	
}
