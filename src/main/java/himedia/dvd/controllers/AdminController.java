package himedia.dvd.controllers;

import java.util.List;

import org.apache.catalina.tribes.membership.Membership;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.dvd.repositories.vo.CashVo;
import himedia.dvd.repositories.vo.MembershipVo;
import himedia.dvd.repositories.vo.ProductVo;
import himedia.dvd.repositories.vo.UserVo;
import himedia.dvd.services.AccessControlService;
import himedia.dvd.services.FileUploadService;
import himedia.dvd.services.MembershipService;
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

	@Autowired
	private MembershipService membershipService;

	@Autowired
	private AccessControlService accessControlService;

	@Autowired
	private FileUploadService fileUploadService;

	// 관리자 홈페이지
	@GetMapping("/home")
	public String getHome(HttpSession session) {
		logger.info("admin home");
		return "admin/home";
	}

	// 상품 추가 페이지
	@GetMapping("/add")
	public String getGoodsRegister() {
		return "admin/products/addproduct";
	}

	@PostMapping("/add")
	public String addProduct(@ModelAttribute ProductVo productVo, @RequestParam("imageFile") MultipartFile imageFile,
			RedirectAttributes redirectAttributes, Model model) {

		if (imageFile != null && !imageFile.isEmpty()) {
			System.out.println("원본파일명" + imageFile.getOriginalFilename());
			System.out.println("파일사이즈" + imageFile.getSize());
			System.out.println("파라미터이름" + imageFile.getName());
			
			String saveFilename = fileUploadService.store(imageFile);
			model.addAttribute("imageFilename", saveFilename);
			productVo.setImg(saveFilename);
			productService.add(productVo);
		} else {
			productService.add(productVo);
		}
		return "redirect:/admin/productlist";
	}

	// 사용자 목록 조회
	@GetMapping("/users")
	public String main(Model model) {
		List<UserVo> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "admin/users/userList"; // home.jsp로 이동
	}

	// 회원정보 삭제 처리
	@GetMapping("/users/{userNo}/delete")
	public String deleteAction(@PathVariable("userNo") Long userNo) {

		// 사용자 삭제 서비스 호출
		userService.deleteUser(userNo);

		return "redirect:/admin/users"; // 사용자 목록 페이지로 리디렉션
	}

	//	회원정보 암호 초기화
	@GetMapping("/users/{userNo}/reset")
	public String resetPassword(@PathVariable Long userNo, RedirectAttributes redirectAttributes) {
		boolean success = userService.resetPassword(userNo);
		if (success) {
	        redirectAttributes.addFlashAttribute("successMessage", "사용자의 비밀번호가 초기화되었습니다.");
	    } else {
	        redirectAttributes.addFlashAttribute("errorMessage", "비밀번호 초기화에 실패했습니다.");
	    }
		
		return "redirect:/admin/users";
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
	// 캐시 요청 목록
		@GetMapping("/acceptcash")
		public String getAllCashRequests(Model model) {
			List<CashVo> requests = userService.getAllCashRequests();
			model.addAttribute("requests", requests);
			return "admin/users/acceptcash";
		}
		
		// 캐시 요청 승인
	    @PostMapping("/approve-request")
	    @ResponseBody
	    public String approveRequest(@RequestParam Long id, @RequestParam Double amount) {
	        CashVo cashVo = new CashVo();
	        cashVo.setId(id);
	        cashVo.setAmount(amount);

	        boolean result = userService.approveCashRequest(cashVo);
	        return result ? "success" : "error";
	    }

	    // 요청 거절
	    @PostMapping("/reject-request")
	    @ResponseBody
	    public String rejectRequest(@RequestParam Long id) {
	        CashVo cashVo = new CashVo();
	        cashVo.setId(id);

	        boolean result = userService.rejectCashRequest(cashVo);
	        return result ? "success" : "error";
	    }

	@GetMapping("/ip-block")
	public String getBlockedIps(Model model) {
		model.addAttribute("attempts", accessControlService.getRecentAccessAttempts());
		model.addAttribute("blockedIps", accessControlService.getBlockedIps());
		return "admin/ip-block";
	}

	// IP 차단
	@PostMapping("/block-ip")
	public String blockIp(@RequestParam("ip") String ip, @RequestParam("adminId") String adminId) {
		accessControlService.blockIp(ip, adminId);
		return "redirect:/admin/ip-block";
	}

	// IP 차단 해제
	@PostMapping("/unblock-ip")
	public String unblockIp(@RequestParam("ip") String ip) {
		accessControlService.unblockIp(ip);
		return "redirect:/admin/ip-block";
	}

}
