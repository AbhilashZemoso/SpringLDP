package learningDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LearningController {
	
	@RequestMapping("/home")
	public String showPage() {
		return "home";
	}

	@RequestMapping("/display")
	public String showName(@RequestParam String myName,Model theModel) {
		
		theModel.addAttribute("message","This is "+myName);
		
		return "displayName";
	}
	
	@RequestMapping("/fillForm")
	public String apply(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "applyForm";
	}

	
}
