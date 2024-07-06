package himedia.dvd.repositories.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import himedia.dvd.repositories.vo.ProductVo;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<ProductVo> selectAllProducts() {
        return sqlSession.selectList("products.selectAllProducts");
    }

    // 기타 필요한 메서드 구현
}
