package io.github.sruby.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 入门springmvc
 * @author liuwf on 2017年3月30日 下午8:57:19
 */
@Controller
public class GreetingController
{
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, 
		defaultValue = "world") String name, Model model)
	{
		model.addAttribute("name", name);
		return "greeting";
	}
}
