package himedia.dvd.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.dvd.repositories.vo.UserVo;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	 @GetMapping("/home")
	    public String getHome(Model model) {
	        logger.info("admin home");
	        return "admin/home";  
	    }
	
	 @GetMapping("/add")
	    public String getGoodsRegister(HttpSession session) {
	        UserVo authUser = (UserVo) session.getAttribute("authUser");
	        if (authUser == null) {
	            return "redirect:/";
	        }
	        logger.info("product add");
	        return "products/addproduct";
	    }
	}
