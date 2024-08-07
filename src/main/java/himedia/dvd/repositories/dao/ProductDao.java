package himedia.dvd.repositories.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import himedia.dvd.repositories.vo.ProductVo;

public interface ProductDao {
    List<ProductVo> selectAllProducts();

    int insertProduct(ProductVo productVo);

    ProductVo getProductdetail(Long productNo);

    List<ProductVo> selectProductsByName(String name);

    List<ProductVo> selectProductsByGenre(String genre);

    int delete(Long productNo);

    int modify(ProductVo productVo);

    ProductVo modifyproduct(Long productNo);

    List<ProductVo> selectProductsByPage(@Param("start") int start, @Param("end") int end);

    int countProducts();
}
