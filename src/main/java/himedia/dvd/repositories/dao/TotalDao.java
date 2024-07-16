package himedia.dvd.repositories.dao;

import java.util.List;

import himedia.dvd.repositories.vo.TotalVo;

public interface TotalDao {
    List<TotalVo> getTotalRank();
    String getTotalAmt();
}
