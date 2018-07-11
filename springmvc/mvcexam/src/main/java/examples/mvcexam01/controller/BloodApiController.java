package examples.mvcexam01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import examples.mvcexam01.dto.BloodDTO;
import examples.mvcexam01.dto.LoginInfo;

// http://localhost:8080/mvcexam/api/blood
@RestController
public class BloodApiController {
	@GetMapping("/api/blood")
	public BloodDTO blood(LoginInfo loginInfo) {
		System.out.println(loginInfo.getId());
		System.out.println(loginInfo.getName());
		
		BloodDTO blood = new BloodDTO();
		blood.setBloodType("A");
		blood.setMsg("Good!");
		blood.setName("Kim");
		return blood;
	}
	
	@PostMapping("/api/blood")
	public BloodDTO saveBlood(@RequestBody BloodDTO blood) {
		System.out.println(blood.getBloodType());
		System.out.println(blood.getMsg());
		System.out.println(blood.getName());
		return blood;
	}
}
