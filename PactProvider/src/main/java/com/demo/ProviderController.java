package com.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

	@GetMapping("/pro/{name}/{age}")
	public @ResponseBody WorkModel hello(@PathVariable String name, @PathVariable int age) {
		if(age==50) throw new CustomExceptionOne("This is not accepted.");
		else if(age==55) throw new CustomExceptionOne("This is not ok too.");
		return new WorkModel(name, age);
	}

}
