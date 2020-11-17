package learningDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class MVCDemoController {
	
	@RequestMapping("/giveData")
	public String showForm() {
		return "addContent";
	}

	@RequestMapping("/showData")
	public String processFormVersionThree(@RequestParam("someText") String theText, Model model) {
		
		String newText = "'This is added to your text' : "+theText;
		
		model.addAttribute("message",newText);
		
		return "displayContent";
	}
}
