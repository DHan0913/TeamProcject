package himedia.dvd.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import himedia.dvd.repositories.dao.ProductDao;
import himedia.dvd.repositories.vo.ProductVo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductVo> getAllProducts() {
        return productDao.selectAllProducts();
    }

    @Override
    public List<ProductVo> searchProductsByName(String keyword) {
        return productDao.selectProductsByName(keyword);
    }

    @Override
    public List<ProductVo> searchProductsByGenre(String keyword) {
        return productDao.selectProductsByGenre(keyword);
    }
}
