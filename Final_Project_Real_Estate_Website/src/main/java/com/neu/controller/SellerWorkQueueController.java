package com.neu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.dao.ListingDao;
import com.neu.pojo.Buyer;
import com.neu.pojo.Seller;

@Controller
public class SellerWorkQueueController {
	
	@RequestMapping(value="/contactSeller.htm",method=RequestMethod.POST)
	public String initailise(HttpServletRequest request)throws Exception
	{
		HttpSession session = request.getSession();
		Buyer buyer = (Buyer)session.getAttribute("buyer");
		int listingId = Integer.parseInt(request.getParameter("ListingName"));
		long buyerId = buyer.getPersonID();
		ListingDao listingDao = new ListingDao();
		int result = listingDao.buyRequest(listingId,buyerId);
		if(result == 1){
		return "RequestSentToSeller";
		}
		else
			return "error";
	}
}
