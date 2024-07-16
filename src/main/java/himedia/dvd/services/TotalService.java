package himedia.dvd.services;

import java.util.List;

import himedia.dvd.repositories.vo.TotalVo;

public interface TotalService {
    List<TotalVo> getTotalRank();
    String getTotalAmt();
}
