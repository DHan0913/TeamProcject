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

    // 기타 필요한 메서드 구현
}
