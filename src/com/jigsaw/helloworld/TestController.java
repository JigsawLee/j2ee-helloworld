package com.jigsaw.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "${adminPath}/test")
public class TestController {
	@ModelAttribute
	public String get(@RequestParam(required = false) String id) {
		return "jdsljfls";
	}
}
