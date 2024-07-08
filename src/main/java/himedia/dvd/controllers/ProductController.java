package himedia.dvd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.dvd.repositories.vo.ProductVo;
import himedia.dvd.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/detail")
    public String showProductDetail(@RequestParam("productNo") Long productNo, Model model) {
        ProductVo product = productService.getProductdetail(productNo);
        model.addAttribute("product", product);
        return "products/productdetail"; 
    }
    
    @GetMapping("/addproduct")
    public String showAddProductForm(Model model) {
        model.addAttribute("productVo", new ProductVo()); 
        return "products/addproduct"; 
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute("productVo") ProductVo productVo, Model model) {
        boolean added = productService.add(productVo); 
        if (added) {
            return "redirect:/home";
        } else {
            model.addAttribute("error");
            return "products/addproduct"; 
        }
    }
}
