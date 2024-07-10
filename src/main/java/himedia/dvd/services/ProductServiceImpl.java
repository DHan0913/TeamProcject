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
	public boolean add(ProductVo productVo) {
		int insertedCount = productDao.insertProduct(productVo);
        return insertedCount == 1;
	}

    @Override
    public ProductVo getProductdetail(Long productNo) {
        ProductVo productVo = productDao.getProductdetail(productNo);
        return productVo;
    }

    @Override
    public List<ProductVo> searchProductsByName(String keyword) {
        return productDao.selectProductsByName(keyword);
    }

    @Override
    public List<ProductVo> searchProductsByGenre(String keyword) {
        return productDao.selectProductsByGenre(keyword);
    }
    
	@Override
	public boolean deleteProduct(Long productNo) {
		int deletedCount = productDao.delete(productNo);
		return deletedCount == 1;
	}
	@Override
	public ProductVo modifyProduct(Long productNo) {
		return productDao.modifyproduct(productNo);
	}
	@Override
	public boolean modify(ProductVo productVo) {
		int modifyCount = productDao.modify(productVo);
		return modifyCount ==1;
	}

}
