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

import himedia.dvd.repositories.vo.UserVo;
import himedia.dvd.services.UserService;
import jakarta.validation.Valid;

@RequestMapping("/users")
@Controller
public class UserController {
   @Autowired
   private UserService userService;
   
   //   가입 폼
   @GetMapping({"", "/", "/join"})
   public String join(@ModelAttribute UserVo userVo) {
      return "users/joinform";
   }
   
   //   로그인 폼 페이지
   @GetMapping("/login")
   public String loginForm() {
      return "users/loginform";
   }
}
