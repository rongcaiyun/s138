package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
	@RequestMapping("/test")
	public String test(){
		int a=1/0;
		return "test";
	}
	/*@ExceptionHandler
	public ModelAndView handleException(Exception exception){
	    ModelAndView mv = new ModelAndView("error/500");
	    mv.addObject("ex",exception);
	    return mv;
	}*/

	@ExceptionHandler
	public String handleException(Exception exception){
	    return "error";
	}
}
