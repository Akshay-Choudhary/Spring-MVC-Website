package com.neu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.neu.dao.ListingDao;
import com.neu.dao.PersonDao;
import com.neu.pojo.Agent;
import com.neu.pojo.Listing;
import com.neu.pojo.Person;


@Controller
public class AgentWorkQueueController {
	
	
	@RequestMapping(value="/addAgentListing.htm",method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("listing") Listing listing, BindingResult result,HttpServletRequest request) throws Exception {
		int price =Integer.parseInt(request.getParameter("price"));
		String propertyTpe = request.getParameter("propertyType");
		HttpSession session = request.getSession();
		Listing l = (Listing)session.getAttribute("sellerRequestFound");
		int listingId = l.getListingId();
		ListingDao listingDao = new ListingDao();
		listingDao.updateListing(listingId,price,propertyTpe);
		String requestApproved = request.getParameter("processed");
		request.setAttribute("requestApproved", requestApproved);
		return "AgentView";
	}
	
	
	@RequestMapping(value="/sellerAgentRequest.htm",method=RequestMethod.GET)
	public String SubmitAction(HttpServletRequest request)throws Exception{
		
		long sellerId = Long.parseLong(request.getParameter("sellerWindow"));
		ListingDao listingDao = new ListingDao();
		HttpSession session = request.getSession();
		Agent a = (Agent)session.getAttribute("agent");
		long agentId= a.getPersonID();
		Listing results = listingDao.findSellerDetails(agentId,sellerId);
		session.setAttribute("sellerRequestFound",results );
		return "HandleSellingRequest";
	}
	
	
	
}
