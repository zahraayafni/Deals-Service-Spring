package id.ac.its.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

	@ResponseBody
	@GetMapping("")
	public String openDocumentation() {
		return "Kindly find the full endpoint documentation on: https://github.com/zahraayafni/Deals-Service-Spring";
	}
}
