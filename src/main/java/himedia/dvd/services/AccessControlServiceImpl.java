package himedia.dvd.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.dvd.repositories.dao.AccessAttemptDao;
import himedia.dvd.repositories.dao.BlockedIpDao;
import himedia.dvd.repositories.vo.AccessAttemptVo;
import himedia.dvd.repositories.vo.BlockedIpVo;

@Service
public class AccessControlServiceImpl implements AccessControlService {

    @Autowired
    private AccessAttemptDao accessAttemptDao;

    @Autowired
    private BlockedIpDao blockedIpDao;

    @Override
    public List<BlockedIpVo> getBlockedIps() {
        return blockedIpDao.findAll();
    }

    @Override
    public void recordAttempt(String ipAddress) {
        AccessAttemptVo attempt = accessAttemptDao.findByIpAddress(ipAddress)
                .orElse(new AccessAttemptVo());
        attempt.setIpAddress(ipAddress);
        attempt.setAttempts(attempt.getAttempts() + 1);
        attempt.setLastAttempt(LocalDateTime.now());
        if (attempt.getId() == null) {
            accessAttemptDao.insert(attempt);
        } else {
            accessAttemptDao.update(attempt);
        }
    }

    @Override
    public void resetAttempts(String ipAddress) {
        accessAttemptDao.deleteByIpAddress(ipAddress);
    }

    @Override
    public void blockIp(String ipAddress, String adminId) {
        BlockedIpVo blockedIp = new BlockedIpVo();
        blockedIp.setIpAddress(ipAddress);
        blockedIp.setBlockedAt(LocalDateTime.now());
        blockedIp.setBlockedBy(adminId);
        blockedIpDao.insert(blockedIp);
    }

    @Override
    public boolean isBlocked(String ipAddress) {
        return blockedIpDao.findByIpAddress(ipAddress).isPresent();
    }

    @Override
    public void unblockIp(String ipAddress) {
        blockedIpDao.deleteByIpAddress(ipAddress);
    }

    @Override
    public List<AccessAttemptVo> getRecentAccessAttempts() {
        return accessAttemptDao.findAllAccessAttempts();
    }

}
