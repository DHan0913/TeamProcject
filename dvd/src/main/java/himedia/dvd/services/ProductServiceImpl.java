package himedia.dvd.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import himedia.dvd.repositories.dao.ProductDao;
import himedia.dvd.repositories.vo.ProductVo;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductVo> getAllProducts() {
    	List<ProductVo> list = productDao.selectAllProducts();
        return list;
    }

	@Override
	public ProductVo getProductdetail(Long productNo) {
		ProductVo productVo = productDao.getProductdetail(productNo);
		return productVo;
	}
}
