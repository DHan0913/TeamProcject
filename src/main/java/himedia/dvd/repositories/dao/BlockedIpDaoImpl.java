package himedia.dvd.repositories.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.dvd.repositories.vo.BlockedIpVo;

@Repository
public class BlockedIpDaoImpl implements BlockedIpDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public Optional<BlockedIpVo> findByIpAddress(String ipAddress) {
        return Optional.ofNullable(sqlSession.selectOne("BlockedIp.findByIpAddress", ipAddress));
    }

    @Override
    public List<BlockedIpVo> findAll() {
        return sqlSession.selectList("BlockedIp.findAll");
    }

    @Override
    public void insert(BlockedIpVo blockedIp) {
        sqlSession.insert("BlockedIp.insert", blockedIp);
    }

    @Override
    public void deleteByIpAddress(String ipAddress) {
        sqlSession.delete("BlockedIp.deleteByIpAddress", ipAddress);
    }

}
