package himedia.dvd.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public String search(@RequestParam("filter") String filter, @RequestParam("keyword") String keyword, @RequestParam("genre") String genre, Model model) {
        List<ProductVo> products;
        if ("productName".equals(filter)) {
            products = productService.searchProductsByName(keyword);
        } else {
            products = productService.searchProductsByGenre(genre);
        }
        model.addAttribute("products", products);
        return "home";
    }
}