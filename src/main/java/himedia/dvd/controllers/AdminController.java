package himedia.dvd.controllers;

import java.util.List;

import org.apache.catalina.tribes.membership.Membership;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.dvd.repositories.vo.MembershipVo;
import himedia.dvd.repositories.vo.ProductVo;
import himedia.dvd.repositories.vo.UserVo;
import himedia.dvd.services.MembershipService;
import himedia.dvd.services.ProductService;
import himedia.dvd.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MembershipService membershipService;



	@GetMapping("/home")
	public String getHome(Model model) {
		logger.info("admin home");
		return "admin/home";
	}

	// 상품 추가 페이지
	@GetMapping("/add")
	public String getGoodsRegister() {
		return "admin/products/addproduct";
	}

	@PostMapping("/add")
	public String addProduct(@ModelAttribute ProductVo productVo) {
		productService.add(productVo);
		return "redirect:/admin/productlist";
	}

	// 사용자 목록 조회
	@GetMapping("/users")
	public String main(Model model) {
		List<UserVo> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "admin/users/userList"; // home.jsp로 이동
	}

	// 상품 삭제
	@GetMapping("/{productNo}/delete")
	public String deleteProduct(@PathVariable("productNo") Long productNo, Model model) {
		boolean deleted = productService.deleteProduct(productNo);
		if (deleted) {
			model.addAttribute("successMessage", "Product deleted successfully");
		} else {
			model.addAttribute("errorMessage", "Failed to delete product");
		}
		return "redirect:/admin/productlist"; 
	}

	// 상품 리스트
	@GetMapping("/productlist")
	public String getProductList(Model model) {
		List<ProductVo> products = productService.getAllProducts();
		model.addAttribute("products", products);
		logger.info("productlist");
		return "admin/products/productlist";
	}

	// 상품 수정 페이지 이동
	@GetMapping("/{productNo}/modify")
	public String modifyForm(@PathVariable("productNo") Long productNo, Model model) {
		ProductVo productVo = productService.getProductdetail(productNo);
		model.addAttribute("productVo", productVo);
		return "admin/products/modify"; 
	}

	// 상품 수정
	@PostMapping("/modify")
	public String modifyAction(@ModelAttribute ProductVo updatedVo) {
		boolean success = productService.modify(updatedVo);
		if (success) {
			return "redirect:/admin/productlist"; 
		} else {
			return "redirect:/admin"; 
		}
	}

	// 멤버쉽 페이지 이동
	@GetMapping("/membership")
	public String getmembership(Model model) {
		List<MembershipVo> memberships = membershipService.getAllmembers();
		model.addAttribute("memberships", memberships);
		return "admin/membership/membership";
	}

	// 멤버쉽 수정 페이지 이동
	@GetMapping("/membershipmodify/{id}")
	public String memberModifyForm(@PathVariable("id") int id, Model model) {
		Membership membership = membershipService.getMembershipById(id);
		model.addAttribute("membership", membership);
		return "admin/membership/membershipmodify";
	}

	// 멤버쉽 수정
	@PostMapping("/membershipmodify")
	public String saveMembership(@ModelAttribute MembershipVo membershipVo) {
		boolean success = membershipService.membershipmodify(membershipVo);
		if (success) {
			return "redirect:/admin/productlist";
		} else {
			return "redirect:/admin";
		}
	}

//	// 사용자 정보 수정 폼
//	@GetMapping("/users/{email}/updateform")
//	public String updateUserForm(@PathVariable("email") String email, Model model) {
//		UserVo user = updateService.getUserById(email);
//		model.addAttribute("email", email);
//		return "admin/users/updateform";
//	}

//	// 사용자 정보 수정 액션
//	@PostMapping("/users/updateform")
//	public String updateUserAction(@ModelAttribute UserVo vo, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError e : list) {
//				System.err.println("Error: " + e);
//			}
//			model.addAttribute(result.getModel());
//			return "admin/users/updateform";
//		}
//
//		boolean success = updateService.updateUser(vo);
//		if (success) {
//			return "redirect:/admin/users";
//		} else {
//			return "admin/users/updateform";
//		}
//	}
}
