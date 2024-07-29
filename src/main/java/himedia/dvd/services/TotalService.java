package himedia.dvd.services;

import java.util.List;

import himedia.dvd.repositories.vo.TotalVo;

public interface TotalService {
    List<TotalVo> getTotalRank();
    String getTotalAmt();
	List<TotalVo> getUsrList();
	
	// 쿠폰 카운트를 가져오고 계산하는 메서드 추가
    long getCalculatedCouponCount();
}
