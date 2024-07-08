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

    @Override
    public List<ProductVo> selectProductsByName(String name) {
        return sqlSession.selectList("products.selectProductsByName", name);
    }

    @Override
    public List<ProductVo> selectProductsByGenre(String genre) {
        return sqlSession.selectList("products.selectProductsByGenre", genre);
    }
}
