package himedia.dvd.repositories.dao;

import java.util.List;
import himedia.dvd.repositories.vo.ProductVo;

public interface ProductDao {
    List<ProductVo> selectAllProducts();
    List<ProductVo> selectProductsByName(String name);
    List<ProductVo> selectProductsByGenre(String genre);
}
