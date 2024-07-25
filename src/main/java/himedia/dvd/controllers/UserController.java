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
import himedia.dvd.repositories.vo.CouponVo;
import himedia.dvd.repositories.vo.UserVo;
import himedia.dvd.services.CouponService;
import himedia.dvd.services.IamportService;
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
	@Autowired
	private IamportService iamportService;

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

		/// 이메일 형식 검증
		if (!userVo.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
			result.rejectValue("email", "error.email", "올바른 이메일 형식을 입력하십시오.");
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
	@ResponseBody
	@RequestMapping("/checkEmail")
	public Object checkEmail(@RequestParam(value = "email", required = true, defaultValue = "") String email) {
		Map<String, Object> json = new HashMap<>();

		// 이메일 형식 검증
		if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
			json.put("result", "error");
			json.put("message", "올바른 이메일 형식을 입력하십시오.");
			return json;
		}

		// 이메일 중복 여부 확인
		UserVo vo = userService.login(email);
		boolean exists = vo != null;

		json.put("result", "success");
		json.put("exists", exists);

		return json;
	}

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

	// 비밀번호 변경
	@PostMapping("/updateform")
	public String updateUserAction(@RequestParam("userNo") Long userNo, @RequestParam("password") String password,
			Model model) {
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
			return "redirect:/users/deleteconfirm?error=fail"; // 실패시
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
	public String requestCash(@RequestParam String requestId, @RequestParam Double amount, HttpSession session, Model model) {
	    UserVo authUser = (UserVo) session.getAttribute("authUser");

	    if (authUser == null) {
	        model.addAttribute("errorMessage", "세션이 만료되었거나 로그인 상태가 아닙니다. 다시 로그인 해주세요.");
	        return "redirect:/login"; // 로그인 페이지로 리디렉션
	    }

	    String loggedInEmail = authUser.getEmail();

	    if (!requestId.equals(loggedInEmail)) {
	        model.addAttribute("errorMessage", "요청 ID가 로그인된 이메일과 일치하지 않습니다.");
	        return "users/requestcashform";
	    }

	    if (amount == null || amount <= 0) {
	        model.addAttribute("errorMessage", "충전 금액은 0보다 커야 합니다.");
	        return "users/requestcashform";
	    }

	    try {
	        // 요청 ID와 금액만으로 캐시 충전 처리
	        boolean success = userService.requestCash(requestId, amount);
	        if (success) {
	            double approvedCashAmount = userService.getApprovedCashAmountByEmail(authUser.getEmail());
	            session.setAttribute("approvedCashAmount", approvedCashAmount);
	            model.addAttribute("message", "캐시 충전 요청이 성공적으로 제출되었습니다.");
	            return "redirect:/";
	        } else {
	            model.addAttribute("errorMessage", "캐시 충전 요청에 실패했습니다.");
	        }
	    } catch (Exception e) {
	        model.addAttribute("errorMessage", "시스템 오류가 발생했습니다. 다시 시도해 주세요.");
	        e.printStackTrace(); // 오류 로그 출력
	    }
	    return "users/requestcashform";
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

	// 쿠폰 입력 창
	@GetMapping("/coupon")
	public String couponForm() {
		return "/users/selectcoupon";
	}

	@ResponseBody
	@RequestMapping("/validateCoupon")
	public Object validateCoupon(@RequestParam(value = "couponCode", required = true) String couponCode) {
		Map<String, Object> json = new HashMap<>();
		try {
			long count = userService.getCouponCountByCodeAndStatus(couponCode);

			System.out.println("쿠폰 유효성 검사 결과:" + count);
			boolean exists = count > 0;

			json.put("result", "success");
			json.put("exists", exists);
		} catch (Exception e) {
			json.put("result", "error");
			json.put("message", e.getMessage());
			e.printStackTrace(); // 로그에 오류 출력
		}
		return json;
	}

	// 쿠폰 등록 및 만료 처리
	@PostMapping("/useCoupon")
	public String useCoupon(@RequestParam("couponCode") String couponCode, HttpSession session, Model model) {
		try {
			long count = userService.getCouponCountByCodeAndStatus(couponCode);

			if (count > 0) {
				// 쿠폰 만료
				userService.expiryCouponByCouponCode(couponCode);

				// 현재 로그인된 유저의 이메일을 가져옵니다.
				UserVo authUser = (UserVo) session.getAttribute("authUser");
				String email = authUser.getEmail();

				// 캐시 충전
				CashVo cashVo = new CashVo();
				cashVo.setRequestId(email);
				cashVo.setAmount(3000.0);

				userService.chargeCashByCoupon(cashVo);

				double approvedCashAmount = userService.getApprovedCashAmountByEmail(email);
				session.setAttribute("approvedCashAmount", approvedCashAmount);
				model.addAttribute("message", "쿠폰이 성공적으로 사용되었으며, 3000원이 충전되었습니다.");

				return "redirect:/users/couponsuccess";
			} else {
				return "redirect:/users/coupon?error=invalid";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/users/coupon?error=exception";
		}
	}

	// 쿠폰등록 성공 페이지
	@RequestMapping("/couponsuccess")
	public String couponsuccess() {
		return "users/couponsuccess";
	}

	// 240718 예성
	// 쿠폰 리스트로 이동 내 쿠폰 확인
	@GetMapping("/couponlist")
	public String getCouponList(Model model) {
		List<CouponVo> couponList = couponService.getCouponList();
		model.addAttribute("coupons", couponList);
		return "users/couponlist";
	}

	// 시청내역
	@GetMapping("/watchhistory")
	public String getwatchhistory(@RequestParam("userNo") Long userNo, Model model) {
		List<Map<String, Object>> watchHistoryList = userService.getWatchHistory(userNo);
		model.addAttribute("watchHistory", watchHistoryList);
		return "users/watchhistory";
	}

}
