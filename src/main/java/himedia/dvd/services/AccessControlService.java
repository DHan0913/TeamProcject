package himedia.dvd.services;

import himedia.dvd.repositories.vo.AccessAttemptVo;
import himedia.dvd.repositories.vo.BlockedIpVo;

import java.util.List;

public interface AccessControlService {

	List<BlockedIpVo> getBlockedIps();

	void recordAttempt(String ipAddress);

	void resetAttempts(String ipAddress);

	void blockIp(String ipAddress, String adminId);

	boolean isBlocked(String ipAddress);

	void unblockIp(String ipAddress);

	List<AccessAttemptVo> getRecentAccessAttempts();

}
