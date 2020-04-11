package com.corana.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.corana.pojo.CoronaStatus;
import com.corana.services.CoronaService;

@Controller
public class HomeController {
	
	@Autowired
	CoronaService coronaService;
	
	@RequestMapping("/coronaStatus")

	public String fetch(Model m)
	{
		List<CoronaStatus> state=coronaService.getStatus();
		m.addAttribute("stats",state);
		m.addAttribute("total",state.stream().mapToInt(s -> s.getTotalCases()).sum());
			return "status";
	}

}
