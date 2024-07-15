package himedia.dvd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.dvd.repositories.vo.ProductVo;
import himedia.dvd.repositories.vo.UserVo;
import himedia.dvd.services.PermissionService;
import himedia.dvd.services.ProductService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/detail")
    public String showProductDetail(@RequestParam("productNo") Long productNo, HttpSession session, Model model) {
        ProductVo product = productService.getProductdetail(productNo);
        model.addAttribute("product", product);

        UserVo authUser = (UserVo) session.getAttribute("authUser");
        UserVo authAdmin = (UserVo) session.getAttribute("authAdmin");

        boolean hasPermission = false;
        if (authAdmin != null && authAdmin.getRole() == 1) {
            hasPermission = true;
        } else if (authUser != null) {
            Long userNo = authUser.getUserNo();
            hasPermission = permissionService.hasPermission(userNo, productNo);
        }

        model.addAttribute("hasPermission", hasPermission);

        return "products/productdetail";
    }
}
