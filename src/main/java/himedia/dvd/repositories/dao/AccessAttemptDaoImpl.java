package himedia.dvd.repositories.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.dvd.repositories.vo.AccessAttemptVo;

@Repository
public class AccessAttemptDaoImpl implements AccessAttemptDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public Optional<AccessAttemptVo> findByIpAddress(String ipAddress) {
        return Optional.ofNullable(sqlSession.selectOne("AccessAttempt.findByIpAddress", ipAddress));
    }

    @Override
    public void insert(AccessAttemptVo accessAttempt) {
        sqlSession.insert("AccessAttempt.insert", accessAttempt);
    }

    @Override
    public void update(AccessAttemptVo accessAttempt) {
        sqlSession.update("AccessAttempt.update", accessAttempt);
    }

    @Override
    public void deleteByIpAddress(String ipAddress) {
        sqlSession.delete("AccessAttempt.deleteByIpAddress", ipAddress);
    }
    @Override
    public List<AccessAttemptVo> findAllAccessAttempts() {
        return sqlSession.selectList("findAllAccessAttempts");
    }
}
