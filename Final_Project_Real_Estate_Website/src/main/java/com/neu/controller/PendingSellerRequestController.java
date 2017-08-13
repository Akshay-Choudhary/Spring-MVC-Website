package com.neu.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.dao.ListingDao;
import com.neu.pojo.Agent;
import com.neu.pojo.Listing;
import com.neu.pojo.Person;
import com.neu.pojo.Seller;

@Controller

public class PendingSellerRequestController {
	
	
	@RequestMapping(value = "/sellerRequest.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("listing") Listing listing, BindingResult result,HttpServletRequest request) throws Exception{

		HttpSession session = request.getSession();
		Agent agent = (Agent)session.getAttribute("agent");
		List<Seller> sellerList = new ArrayList<Seller>();
		long agentId = agent.getPersonID();
		ListingDao listingDao = new ListingDao();
		List<Listing> sellerRequest = listingDao.findAgentById(agentId);
		 Iterator listOfListings = sellerRequest.iterator();
		 while(listOfListings.hasNext())
		 {
			 Listing listing2 = (Listing) listOfListings.next();
			 Seller seller = listing2.getSeller();
			 sellerList.add(seller);
		 }
		 session.setAttribute("sellerList", sellerList);
		return "AgentView";
	}
}
