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
	
	// 회원 상세정보 폼
	@GetMapping("/{email}/userinfo")
	public String userInfo(@PathVariable("email")String email, Model model) {
		model.addAttribute("email", email);
		return "users/userinfo";
	}

	
	// 회원정보 수정 폼
	@GetMapping("/updateform")
	public String updateForm() {
		return "users/updateform";
	}
	
//	 회원정보 수정 액션
	@PostMapping("/updateform")
	public String updateUserAction(@ModelAttribute UserVo vo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError e : list) {
				System.err.println("Error" + e);
			} model.addAllAttributes(result.getModel());
			return "users/updateform";
		}
		boolean success = userService.updateUser(vo);
		if(success) {
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
	
	// 회원 탈퇴 액션
	@PostMapping("/deleteconfirm")
	public String deleteAction() {
		return "users/deleteconfirm";
	}
	
//	@RequestMapping("/deleteconfirm")
//	public String deleteconfirm(@RequestParam UserVo vo, Model model) {
//		
//		boolean result = userService.deleteUser(vo);	
//		if(result) {
//			userService.deleteUser(vo);
//			return "redirect:/home";
//		} else {
//			model.addAttribute("message", "비밀번호가 틀립니다.");
//			return "/deleteconfirm";
//		} 
//		
	
	// 회원 삭제 완료 폼
	@RequestMapping("/deletesuccess")
	public String deleteSuccess() {
		return "users/deletesuccess";
	}
}




