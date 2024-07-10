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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.dvd.repositories.vo.UserVo;
import himedia.dvd.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RequestMapping("/users")
@Controller
public class UserController {
	@Autowired
	private UserService userService;
//	
//	 @Value("${Length.userVo.name}")
//	 private String nameLnth;
//	 
//	 @Value("${NotEmpty.userVo.name}")
//	 private String nameEmty;
//	 
//	 @Value("${NotEmpty.userVo.password}")
//	 private String pwLnth;
//	 
//	 @Value("${NotEmpty.userVo.password}")
//	 private String pwEmty;
//	 
//	 @Value("${NotEmpty.userVo.email}")
//	 private String emailEmty;
//	 
//	 @Value("${Email.userVo.email}")
//	 private String emailFail;
	 
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
            @RequestParam(value="email", required=false, defaultValue="") String email,
            @RequestParam(value="password", required=false, defaultValue="") String password,
            HttpSession session) {
        System.out.println("email:" + email);
        System.out.println("password:" + password);
        
        if(email.length() == 0 || password.length() == 0) {
            System.out.println("email 혹은 password가 입력되지 않음");
            return "redirect:/users/login";
        }
        
        UserVo authUser = userService.login(email, password);
        
        if (authUser != null) {
            if (authUser.getRole() == 1) {
                session.setAttribute("authAdmin", authUser);
                session.setAttribute("authUser", authUser);
                return "redirect:/admin/home";
            } else {
                session.setAttribute("authUser", authUser);
                return "redirect:/";
            }
        } else {
            return "redirect:/users/login";
        }
    }
	// 관리자용 페이지
	@GetMapping("/admin")
	public String adminHome() {
		return "admin/home";
	}
	
	//	로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
	//	중복 이메일 체크
	@ResponseBody	//	-> MessageConverter 사용
	@RequestMapping("/checkEmail")
	public Object checkEmail(@RequestParam(value="email", 
										required=true,
										defaultValue="") String email) {
		UserVo vo = userService.login(email);
		boolean exists = vo != null ? true: false;
		
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
	
	// 회원정보 수정 폼
	@GetMapping("/{userNo}/updateform")
	public String updateForm(@PathVariable("userNo") Long userNo, Model model) {
		UserVo userVo = userService.getUpdate(userNo);
		model.addAttribute("user", userVo);
		return "updateuser/updateform";
	}
	
	// 회원정보 수정 액션
	@PostMapping("/updateform")
	public String updateUserAction(@ModelAttribute UserVo vo) {
		boolean success = userService.getUpdate(vo);
		if(success) {
			return "redirect:/users/home";
		} else {
			return "redirect:/users/";
		}
	}
	
	// 회원 수정 완료 폼
//	@RequestMapping("/updatesucess")
//	public String updateSuccess() {
//		return "users/updatesuccess";
//	}
	
	
	
	

}
