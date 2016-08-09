package com.gpl.module.good.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/good")
public class GoodController {
	
	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public ModelAndView list(){
		return new ModelAndView("/good/list");
	}

}
