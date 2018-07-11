package examples.guestbook.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import examples.guestbook.dto.Guestbook;
import examples.guestbook.form.GuestbookForm;
import examples.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping("/list")
	public String list(ModelMap modelMap) {
		modelMap.addAttribute("list", guestbookService.getGuestbooks());
		return "list";
	}
	
	@GetMapping("/writeform")
	public String writeform(GuestbookForm personForm) {
		return "writeform";
	}
	
	@PostMapping("/write")
	public String write(@Valid GuestbookForm guestbookForm, BindingResult bindingResult) {
		System.out.println(guestbookForm.getName());
		System.out.println(guestbookForm.getContent());

        if (bindingResult.hasErrors()) {
            return "writeform";
        }
        
        Guestbook guestbook = new Guestbook();
        guestbook.setName(guestbookForm.getName());
        guestbook.setContent(guestbookForm.getContent());
        guestbook.setRegdate(new Date());
        guestbookService.addGuestbook(guestbook);
        
		return "redirect:list";  // list페이지로 이
	}
}
