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
    // 제품등록
    @Override
    public int insert(ProductVo productVo) {
    	int insertedCount = sqlSession.insert("products.insertProduct", productVo);
    	return insertedCount;
    }
    
    @Override
    public int insertProduct(ProductVo productVo) {
        return sqlSession.insert("products.insertProduct", productVo);
    }

    // 상세정보
    @Override
    public ProductVo getProductdetail(Long productNo) {
        return sqlSession.selectOne("products.getProductdetail", productNo);
    }

    // 이름으로 제품 검색
    @Override
    public List<ProductVo> selectProductsByName(String name) {
        return sqlSession.selectList("products.selectProductsByName", name);
    }

    // 장르로 제품 검색
    @Override
    public List<ProductVo> selectProductsByGenre(String genre) {
        return sqlSession.selectList("products.selectProductsByGenre", genre);
    }
    
    //상품삭제
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
