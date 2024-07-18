package himedia.dvd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import himedia.dvd.repositories.vo.CashVo;
import himedia.dvd.repositories.vo.UserVo;
import himedia.dvd.services.CouponService;
import himedia.dvd.services.PermissionService;
import himedia.dvd.services.ProductService;
import himedia.dvd.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RequestMapping("/users")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
    private CouponService couponService;
	
	// 가입 폼
	@GetMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		return "users/joinform";
	}

	// 가입 처리
	@PostMapping("/join")
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result, Model model) {
		System.out.println("회원 가입 폼: " + userVo);

		// 비밀번호와 비밀번호 확인 검증
		if (!userVo.getPassword().equals(userVo.getPasswordConfirm())) {
			result.rejectValue("passwordConfirm", "error.passwordConfirm", "비밀번호가 일치하지 않습니다.");
		}

		// 약관 동의 확인 로직 추가
		if (userVo.getAgree() == null || !userVo.getAgree()) {
			result.rejectValue("agree", "agree.required");
		}

		// 검증 결과 확인
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError e : list) {
				System.err.println("Error" + e);
			}
			model.addAllAttributes(result.getModel());
			return "users/joinform";
		}
		boolean success = userService.join(userVo);
		if (success) { // 가입 성공
			// 가입 성공 페이지로
			System.out.println("회원 가입 성공");
			return "redirect:/users/joinsuccess";
		} else {
			// 실패
			System.err.println("회원 가입 실패");
			return "redirect:/users/join";
		}
	}

	// 가입 성공 페이지
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "users/joinsuccess";
	}

	// 로그인 폼 페이지
	@GetMapping("/login")
	public String loginForm() {
		return "users/loginform";
	}

	@PostMapping("/login")
	public String loginAction(@RequestParam(value = "email", required = false, defaultValue = "") String email,
			@RequestParam(value = "password", required = false, defaultValue = "") String password, HttpSession session,
			Model model) {
		System.out.println("email:" + email);
		System.out.println("password:" + password);

		// 이메일이나 비밀번호를 입력하지 않은 경우
		if (email.isEmpty() || password.isEmpty()) {
			System.out.println("email 혹은 password가 입력되지 않음");
			model.addAttribute("이메일 또는 비밀번호를 입력해주세요.");
			return "redirect:/users/login?error=empty";
		}

		// 사용자 인증
		UserVo authUser = userService.login(email, password);

		if (authUser != null) {
			double approvedCashAmount = userService.getApprovedCashAmountByEmail(authUser.getEmail());
			session.setAttribute("authUser", authUser);
			session.setAttribute("approvedCashAmount", approvedCashAmount);

			System.out.println("로그인 성공 - Role: " + authUser.getRole());

			if (authUser.getRole() == 1) { // 관리자
				session.setAttribute("authAdmin", authUser);
				session.setAttribute("authUser", authUser);
				System.out.println("관리자로 로그인 성공");
				return "redirect:/admin/home"; // 관리자 홈으로
			} else {
				return "redirect:/"; // 일반 사용자 홈으로
			}
		} else {
			// 로그인 실패시
			System.out.println("로그인 실패");
			model.addAttribute("로그인에 실패했습니다.");
			return "redirect:/users/login?error=fail";
		}
	}

	// 관리자용 페이지
	@GetMapping("/admin")
	public String adminHome() {
		return "admin/home";
	}

	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();

		return "redirect:/";
	}

	// 중복 이메일 체크
	@ResponseBody // -> MessageConverter 사용
	@RequestMapping("/checkEmail")
	public Object checkEmail(@RequestParam(value = "email", required = true, defaultValue = "") String email) {
		UserVo vo = userService.login(email);
		boolean exists = vo != null ? true : false;

		System.out.println("Controller UserVo: " + vo);

		Map<String, Object> json = new HashMap<>();
		json.put("result", "success");
		json.put("exists", exists);

		return json;

	}

	/*
	 * @GetMapping("/{userNo}") public String view(@PathVariable("userNo") Long no,
	 * Model model, HttpSession session, RedirectAttributes redirectAttributes) {
	 * UserVo authUser = (UserVo)session.getAttribute("authUser");
	 * 
	 * return "updateuser/updateform"; }
	 */

	// 회원 상세정보 폼
	@GetMapping("/{email}/userinfo")
	public String userInfo(@PathVariable("email") String email, Model model) {
		model.addAttribute("email", email);
		return "users/userinfo";
	}

	// 회원정보 수정 폼
	@GetMapping("/updateform")
	public String updateForm() {
		return "users/updateform";
	}

	//비밀번호 변경
	@PostMapping("/updateform")
	public String updateUserAction(@RequestParam("userNo") Long userNo, @RequestParam("password") String password, Model model) {
	    boolean success = userService.updatePassword(userNo, password);
	    if (success) {
	        return "users/updatesuccess";
	    } else {
	        return "users/updateform";
	    }
	}

	// 회원 수정 완료 폼
	@RequestMapping("/updatesuccess")
	public String updateSuccess() {
		return "users/updatesuccess";
	}

	// 회원 탈퇴(삭제) 폼
	@GetMapping("/deleteconfirm")
	public String deleteConfirm() {
		return "users/deleteconfirm";
	}

	@PostMapping("/{email}/deleteconfirm")
	public String deleteUserAction(@PathVariable("email") String email, @RequestParam("password") String password,
			HttpSession session) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null || !authUser.getEmail().equals(email) || !authUser.getPassword().equals(password)) {
			return "redirect:/users/deleteconfirm?error=fail";
		}
		boolean success = userService.deleteUser(email); // 회원 삭제 메서드 호출
		if (success) {
			session.invalidate();
			return "redirect:/users/deletesuccess"; // 회원 삭제 성공시 성공페이지로 리다이렉트
		} else {
			return "redirect:/users/deleteconfirm?error=fail"; // 실패시 ......
		}
	}

	// 회원 삭제 완료 폼
	@RequestMapping("/deletesuccess")
	public String deleteSuccess() {
		return "users/deletesuccess";
	}

	// 캐시 충전 요청 폼
	@GetMapping("/requestcash")
	public String requestCashForm() {
		return "users/requestcashform";
	}

	// 충전 요청
	@PostMapping("/requestcash")
	public String requestCash(@RequestParam String requestId, @RequestParam Double amount, HttpSession session,
			Model model) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		String loggedInEmail = authUser.getEmail();

		if (!requestId.equals(loggedInEmail)) {
			model.addAttribute("errorMessage", "요청 ID가 로그인된 이메일과 일치하지 않습니다.");
			return "users/requestcashform";
		}

		boolean success = userService.requestCash(requestId, amount);

		if (success) {
			double approvedCashAmount = userService.getApprovedCashAmountByEmail(authUser.getEmail());
			session.setAttribute("approvedCashAmount", approvedCashAmount);
			model.addAttribute("message", "캐시 충전 요청이 성공적으로 제출되었습니다.");
			return "redirect:/";
		} else {
			model.addAttribute("errorMessage", "캐시 충전 요청에 실패했습니다.");
			return "users/requestcashform";
		}
	}

	// 충전 내역
	@GetMapping("/cashhistory")
	public String getCashHistory(HttpSession session, Model model) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		List<CashVo> cashList = userService.getCashHistory(authUser.getEmail());
		double totalAmount = cashList.stream().mapToDouble(CashVo::getAmount).sum();

		model.addAttribute("cashList", cashList);
		model.addAttribute("totalAmount", totalAmount);

		return "users/cashhistory";
	}

	// 예성씌 파트 ----------------------------------------

	@GetMapping("/payment/{productNo}")
	public String paymentAction(@PathVariable("productNo") Long productNo, HttpSession session) {
		UserVo vo = (UserVo) session.getAttribute("authUser");
		String email = vo.getEmail();
		List<CashVo> cashList = userService.getCashHistory(email);
		double totalAmount = cashList.stream().mapToDouble(CashVo::getAmount).sum();
		System.out.println("잔액:" + totalAmount);

		if (totalAmount >= 3000) {
			boolean success = userService.insertCash(email);
			permissionService.setPermission(vo.getUserNo(), productNo);
			if (success) {
				double approvedCashAmount = userService.getApprovedCashAmountByEmail(email);
				session.setAttribute("approvedCashAmount", approvedCashAmount);
				  return "redirect:/products/detail?productNo=" + productNo;
			}
			return "redirect:/";
		}
		return "redirect:/";
	}

	// 예성씌 파트 end ----------------------------------------
	
	//	쿠폰 입력 창
	@GetMapping("/coupon")
	public String couponForm() {
		return "/users/selectcoupon";
	}
	
	// 쿠폰 관련 메서드 통합
    @PostMapping("/coupon/action")
    @ResponseBody
    public Object couponAction(@RequestParam(value = "actionType") String actionType,
                               @RequestParam(value = "couponCode", required = false, defaultValue = "") String couponCode,
                               @RequestParam(value = "couponStatus", required = false, defaultValue = "") String couponStatus) {
        if ("validate".equals(actionType)) {
            boolean isValid = couponService.isCouponValid(couponCode, couponStatus);
            Map<String, Object> result = new HashMap<>();
            result.put("actionType", "validate");
            result.put("isValid", isValid);
            return result;
        } else if ("checkCode".equals(actionType)) {
            boolean exists = couponService.checkCouponExistence(couponCode);
            Map<String, Object> result = new HashMap<>();
            result.put("actionType", "checkCode");
            result.put("exists", exists);
            return result;
        } else {
            // 알 수 없는 actionType인 경우 처리
            Map<String, Object> result = new HashMap<>();
            result.put("error", "Unknown actionType: " + actionType);
            return result;
        }
    }
	    
    // 쿠폰등록 성공 페이지
 	@RequestMapping("/couponsuccess")
 	public String couponsuccess() {
 		return "users/couponsuccess";
 	}
}
