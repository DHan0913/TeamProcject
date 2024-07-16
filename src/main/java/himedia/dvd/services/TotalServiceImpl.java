package himedia.dvd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.dvd.repositories.dao.TotalDao;
import himedia.dvd.repositories.vo.TotalVo;

@Service("totalService")
public class TotalServiceImpl implements TotalService {

    @Autowired
    private TotalDao totalDao;

    @Override
    public List<TotalVo> getTotalRank() {
        List<TotalVo> list = totalDao.getTotalRank();
        return list;
    }
    
	@Override
	public String getTotalAmt() {
		String totalAmt = totalDao.getTotalAmt();
        return totalAmt;
	}
}
