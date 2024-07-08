package himedia.dvd.repositories.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import himedia.dvd.repositories.vo.ProductVo;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SqlSession sqlSession;

    // 리스트 출력
    @Override
    public List<ProductVo> selectAllProducts() {
    	List<ProductVo> list = sqlSession.selectList("products.selectAllProducts");
    	return list;
    }
    
    // 상세정보
	@Override
	public ProductVo getProductdetail(Long productNo) {
		return sqlSession.selectOne("products.getProductdetail", productNo);
	}

}
