package com.neu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.dao.DisplayAgentDao;
import com.neu.exception.AdException;

@Controller
public class SellThroughAgentController {

	@RequestMapping(value = "/sellThruAgent.htm", method = RequestMethod.GET)
	public String initializeForm(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();

		if (session.getAttribute("user") != null) {
			List<String> listOfAgents = new ArrayList<String>();
			DisplayAgentDao displayAgentDao = new DisplayAgentDao();
			listOfAgents = displayAgentDao.getAgents();
			request.setAttribute("agentList", listOfAgents);
			return "SellThroughAgent";
		} else
			return "UserLogin";
	}

}
