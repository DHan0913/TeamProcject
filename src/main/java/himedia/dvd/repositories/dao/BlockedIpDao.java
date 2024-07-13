package himedia.dvd.repositories.dao;

import java.util.List;
import java.util.Optional;

import himedia.dvd.repositories.vo.BlockedIpVo;

public interface BlockedIpDao {
	// 널 참조 방지
	// 의미 명확화 없을수도 있음
	// 아이피로 검색
	Optional<BlockedIpVo> findByIpAddress(String ipAddress);

	// 차단 아이피 전체 조회
	List<BlockedIpVo> findAll();

	// 아이피 차단
	void insert(BlockedIpVo blockedIp);

	// 아이피 차단 해제
	void deleteByIpAddress(String ipAddress);
}
