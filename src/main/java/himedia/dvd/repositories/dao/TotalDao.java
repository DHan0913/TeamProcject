package himedia.dvd.repositories.dao;

import java.util.List;

import himedia.dvd.repositories.vo.TotalVo;

public interface TotalDao {
    List<TotalVo> getTotalRank();
    String getTotalAmt();
	List<TotalVo> getUsrList();
	
	// 쿠폰 카운트 가져오는 메서드
    long getCouponCount();
}
