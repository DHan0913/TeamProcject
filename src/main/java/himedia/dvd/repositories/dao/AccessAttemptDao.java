package himedia.dvd.repositories.dao;

import java.util.List;
import java.util.Optional;

import himedia.dvd.repositories.vo.AccessAttemptVo;

public interface AccessAttemptDao {
	// 널 참조 방지
	// 의미 명확화 없을수도 있음
	Optional<AccessAttemptVo> findByIpAddress(String ipAddress);

	// 추가
	void insert(AccessAttemptVo accessAttempt);

	// 수정
	void update(AccessAttemptVo accessAttempt);

	// 삭제
	void deleteByIpAddress(String ipAddress);

	// 목록 조회
	List<AccessAttemptVo> findAllAccessAttempts();

}
