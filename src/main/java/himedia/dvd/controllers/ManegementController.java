//package himedia.dvd.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import himedia.dvd.services.UserService;
//
//@Controller
//public class ManegementController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping({ "/", "/main" })
//    public String main(Model model) {
//        // 여기서 제품 목록을 조회하고 모델에 추가
//    //    List<UserVo> users = userService.getAllUsers();
//      //  model.addAttribute("users", users);
//
//        return "home2"; // home.jsp로 이동
//    }
//}
