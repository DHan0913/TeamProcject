package himedia.dvd.services;

import java.util.List;
import himedia.dvd.repositories.vo.ProductVo;

public interface ProductService {
    List<ProductVo> getAllProducts();
}
