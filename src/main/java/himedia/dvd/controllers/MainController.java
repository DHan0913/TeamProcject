package himedia.dvd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import himedia.dvd.repositories.vo.ProductVo;
import himedia.dvd.services.ProductService;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping({ "/", "/main" })
    public String main(Model model) {
        // 여기서 제품 목록을 조회하고 모델에 추가
        List<ProductVo> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "home"; // home.jsp로 이동
    }
}
