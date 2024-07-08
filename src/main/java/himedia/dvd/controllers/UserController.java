package himedia.dvd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.dvd.repositories.vo.UserVo;
import himedia.dvd.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RequestMapping("/users")
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// 가입 폼
	@GetMapping({ "", "/", "/join" })
	public String join(@ModelAttribute UserVo userVo) {
		return "users/joinform";
	}

	// 가입 처리
	@PostMapping("/join")
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result, Model model) {
		System.out.println("회원 가입 폼: " + userVo);

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

	// 로그인 액션
	@PostMapping("/login")
	public String loginAction(
			@RequestParam(value="email",
						required=false,
						defaultValue="") String email,
			@RequestParam(value="password",
						required=false,
						defaultValue="") String password,
			HttpSession session) {
		System.out.println("email:" + email);
		System.out.println("password:" + password);
		
		if(email.length() == 0 || password.length() == 0) {
			System.out.println("email 혹은 password가 입력되지 않음");
			return "redirect:/users/login";
		}
		
		UserVo authUser = userService.login(email, password);
		
		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		} else {
			return "redirect:/users/login";
		}
	}
	
	//	로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
	
}
