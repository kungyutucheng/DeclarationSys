package com.gpl.module.imports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/import")
public class ImportController {

	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public ModelAndView list(){
		return  new ModelAndView("import/list");
	}
}
