package examples.mvcexam01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StarController {
	// http://localhost:8080/mvcexam/star1
	@GetMapping("/star1")
	public String star1() {
		return "star1";
	}
	// count파라미터가 없으면 별을 1개만찍고
	// count파라미터가 있으면 그 값만큼 별을 찍을 것이다.
	// http://localhost:8080/mvcexam/star2
	// http://localhost:8080/mvcexam/star2?count=5
	@GetMapping("/star2")
	public String star2(
			@RequestParam(name="count", required=false, defaultValue="1") int count,
			ModelMap modelMap){
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < count; i++) {
			sb.append("*");
		}
		modelMap.addAttribute("star",sb.toString());
		return "star2";
	}
	
	// http://localhost:8080/mvcexam/star3?str=A&length=5
	// AAAAA
	// http://localhost:8080/mvcexam/star3?str=X&length=2
	// XX
	//파라미터가 없으면 Exception이 발생
	@GetMapping("/star3")
	public String star3(
			@RequestParam(name="str") String str,
			@RequestParam(name="length") int length,
			ModelMap modelMap
			) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < length; i++) {
			sb.append(str);
		}
		modelMap.addAttribute("mystr",sb.toString());		
		return "star3";
	}
	
}
