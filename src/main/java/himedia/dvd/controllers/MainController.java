package himedia.dvd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.dvd.repositories.vo.NoticeVo;
import himedia.dvd.repositories.vo.ProductVo;
import himedia.dvd.services.ProductService;
import himedia.dvd.services.UserService;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    
    private static final int PAGE_SIZE = 10; // 페이지당 항목 수를 상수로 정의

    @GetMapping({ "/", "/main" })
    public String main(@RequestParam(defaultValue = "1") int page, Model model) {
        if (page < 1) {
            page = 1; // 페이지가 1보다 작을 경우 기본값으로 설정
        }
        
        int start = (page - 1) * PAGE_SIZE + 1;
        int end = page * PAGE_SIZE;

        List<ProductVo> products = productService.getProductsByPage(start, end);
        int totalProducts = productService.getProductCount();
        int totalPages = (int) Math.ceil((double) totalProducts / PAGE_SIZE);

        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "home";
    }

    @GetMapping("/products/search")
    public String search(
            @RequestParam("filter") String filter, 
            @RequestParam(value = "keyword", defaultValue = "") String keyword, 
            @RequestParam(value = "genre", defaultValue = "") String genre, 
            Model model) {
        
        List<ProductVo> products;
        
        if ("productName".equals(filter)) {
            products = productService.searchProductsByName(keyword);
        } else if ("genre".equals(filter)) {
            products = productService.searchProductsByGenre(genre);
        } else {
            // filter 값이 잘못된 경우를 처리하는 로직 추가
            products = List.of(); // 빈 리스트 반환
        }
        
        model.addAttribute("products", products);
        return "home";
    }
    
    @ModelAttribute("latestNotice")
    public NoticeVo getLatestNotice() {
        return userService.getLatestNotice();
    }
}
