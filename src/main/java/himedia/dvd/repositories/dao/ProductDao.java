package himedia.dvd.repositories.dao;

import java.util.List;
import himedia.dvd.repositories.vo.ProductVo;

public interface ProductDao {
    public List<ProductVo> selectAllProducts();
	public ProductVo getProductdetail(Long productNo);
}
