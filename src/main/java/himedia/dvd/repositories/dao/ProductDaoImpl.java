package himedia.dvd.repositories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.dvd.repositories.vo.ProductVo;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<ProductVo> selectAllProducts() {
        return sqlSession.selectList("products.selectAllProducts");
    }

    @Override
    public int insertProduct(ProductVo productVo) {
        return sqlSession.insert("products.insertProduct", productVo);
    }

    @Override
    public ProductVo getProductdetail(Long productNo) {
        return sqlSession.selectOne("products.getProductdetail", productNo);
    }

    @Override
    public List<ProductVo> selectProductsByName(String name) {
        return sqlSession.selectList("products.selectProductsByName", name);
    }

    @Override
    public List<ProductVo> selectProductsByGenre(String genre) {
        return sqlSession.selectList("products.selectProductsByGenre", genre);
    }

    @Override
    public List<ProductVo> selectProductsByPage(int start, int end) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("end", end);
        return sqlSession.selectList("products.selectProductsByPage", params);
    }

    @Override
    public int countProducts() {
        return sqlSession.selectOne("products.countProducts");
    }

    @Override
    public int delete(Long productNo) {
        return sqlSession.delete("products.deleteProduct", productNo);
    }

    @Override
    public int modify(ProductVo productVo) {
        return sqlSession.update("products.modifyProduct", productVo);
    }

    @Override
    public ProductVo modifyproduct(Long productNo) {
        return sqlSession.selectOne("products.modifyProduct", productNo);
    }
}
