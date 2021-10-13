package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Greatting;

import com.example.demo.repo.GreattingRepo;


@Controller

public class GreattingController {
	
	@Autowired
	
	GreattingRepo grt;
	
	@RequestMapping("/")
	public String home()

	{
		System.out.println("Cheacking");
		return "home.jsp";
		

	}
	
	@RequestMapping("/grt")
	// data coming from student will be asine to student obj
	public String addStudent(Greatting grtone) {

		grt.save(grtone);

		return "show.jsp";
		
	}
	@RequestMapping("/Getting")
	public ModelAndView getGreatting(@RequestParam int aid) {
		

		ModelAndView mv = new ModelAndView("New.jsp");
		Greatting st = grt.findById(aid).orElse(new Greatting());
		mv.addObject(st);
		return mv;
	
	
	}
}
