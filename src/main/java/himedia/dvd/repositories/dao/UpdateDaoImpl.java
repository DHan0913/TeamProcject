package himedia.dvd.repositories.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.dvd.repositories.vo.UserVo;

@Repository("updateDao")
public class UpdateDaoImpl implements UpdateDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public boolean update(UserVo user) {
        int count = sqlSession.update("update.update", user);
        return count == 1;
    }

    @Override
    public UserVo getUserById(Long userNo) {
        return sqlSession.selectOne("update.getUserById", userNo);
    }
}
