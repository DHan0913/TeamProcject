package himedia.dvd.repositories.dao;

import java.util.List;
import java.util.Optional;

import himedia.dvd.repositories.vo.BlockedIpVo;

public interface BlockedIpDao {
	// 널 참조 방지
	// 의미 명확화 없을수도 있음
	Optional<BlockedIpVo> findByIpAddress(String ipAddress);

	List<BlockedIpVo> findAll();

	void insert(BlockedIpVo blockedIp);

	void deleteByIpAddress(String ipAddress);
}
