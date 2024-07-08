package himedia.dvd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.dvd.repositories.vo.ProductVo;
import himedia.dvd.services.ProductService;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping({ "/", "/main" })
    public String main(Model model) {
        List<ProductVo> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "home";
    }

    @GetMapping("/products/search")
    public String search(@RequestParam(value = "filter", required = false, defaultValue = "productName") String filter,
                         @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword, Model model) {
        List<ProductVo> products;
        if ("productName".equals(filter)) {
            products = productService.searchProductsByName(keyword);
        } else {
            products = productService.searchProductsByGenre(keyword);
        }
        model.addAttribute("products", products);
        return "home";
    }
}
