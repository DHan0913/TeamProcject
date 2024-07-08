package himedia.dvd.services;

import java.util.List;
import himedia.dvd.repositories.vo.ProductVo;

public interface ProductService {
    public List<ProductVo> getAllProducts();
	public ProductVo getProductdetail(Long productNo);
}
