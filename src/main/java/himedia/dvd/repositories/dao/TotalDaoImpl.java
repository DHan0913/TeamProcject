package himedia.dvd.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.dvd.repositories.vo.TotalVo;

@Repository("totalDao")
public class TotalDaoImpl implements TotalDao {

    @Autowired
    private SqlSession sqlSession;

    // 리스트 출력
    @Override
    public List<TotalVo> getTotalRank() {
        List<TotalVo> list = sqlSession.selectList("total.selectTotalRank");
        return list;
    }
    
    //총매출액 
    @Override
    public String getTotalAmt() {
        return sqlSession.selectOne("total.totalAmt");
    }
    
    // 유저랭킹 리스트 출력
    @Override
    public List<TotalVo> getUsrList() {
    	List<TotalVo> list = sqlSession.selectList("total.selectUsrList");
    	return list;
    }
    
    //	쿠폰 매출액
    @Override
    public long getCouponCount() {
        return sqlSession.selectOne("total.totalCoupon"); 
    }

}
