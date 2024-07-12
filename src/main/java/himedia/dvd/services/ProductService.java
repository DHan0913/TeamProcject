package himedia.dvd.services;

import java.util.List;
import himedia.dvd.repositories.vo.ProductVo;

public interface ProductService {
    List<ProductVo> getAllProducts();
    ProductVo getProductdetail(Long productNo);
    public boolean add(ProductVo productVo);
    List<ProductVo> searchProductsByName(String keyword);
    List<ProductVo> searchProductsByGenre(String genre);
	boolean deleteProduct(Long productNo);
	ProductVo modifyProduct(Long productNo);
	boolean modify(ProductVo productVo);
}
