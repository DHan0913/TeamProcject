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

import himedia.dvd.repositories.vo.UpdateVo;
import himedia.dvd.services.UpdateService;
import jakarta.validation.Valid;

@Controller
public class UpdateController {
	@Autowired
	private UpdateService userSerive;
	
	// 회원정보 수정 
	@GetMapping({"/update"})
	public String update(@ModelAttribute UpdateVo updateVo) {
		return "updateusers/update";
	}
	
	// 회원정보 수정 액션
	@PostMapping("/update")
	public String update(@ModelAttribute @Valid UpdateVo updateVo, BindingResult result, Model model) {
		System.out.println("회원정보 수정 폼: " + updateVo);
		
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError e: list) {
				System.err.println("Error: " + e);
			}
			model.addAllAttributes(result.getModel());
			return "updateusers/update";
		}
		boolean success = updateService.update(updateVo);
		if(success) {
			System.out.println("회원 정보 수정 완료");
			return "redirect:/updateusers/updatesuccess";
		} else {
			System.err.println("회원 정보수정을 하지 못했습니다.");
			return "redirect:/views/home";
		}
	} 
	
	// 수정 성공 페이지 
	@RequestMapping("/updatesuccess")
	public String updatesuccess() {
		return "updateusers/updatesuccess";
	}
}
