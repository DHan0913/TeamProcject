package himedia.dvd.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.dvd.repositories.vo.ProductVo;
import himedia.dvd.repositories.vo.UserVo;
import himedia.dvd.services.ProductService;
import himedia.dvd.services.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;

	@GetMapping("/home")
	public String getHome(Model model) {
		logger.info("admin home");
		return "admin/home";
	}

	// 상품추가
	@GetMapping("/add")
	public String getGoodsRegister(HttpSession session) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/";
		}
		logger.info("product add");
		return "admin/products/addproduct";
	}

	// 상품 리스트
	@GetMapping("/productlist")
	public String getProductList(HttpSession session, Model model) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/";
		}
		List<ProductVo> products = productService.getAllProducts();
		model.addAttribute("products", products);
		logger.info("productlist");
		return "admin/products/productlist";
	}

	@GetMapping("/users")
	public String main(Model model) {
		// 여기서 제품 목록을 조회하고 모델에 추가
		List<UserVo> users = userService.getAllUsers();
		model.addAttribute("users", users);

		return "admin/users/userList"; // home.jsp로 이동
	}
}
