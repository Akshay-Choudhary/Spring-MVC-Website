package com.neu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.dao.ListingDao;
import com.neu.dao.PersonDao;
import com.neu.pojo.Listing;
import com.neu.pojo.Person;
import com.neu.pojo.Seller;

@Controller
public class BuyController {
	
	
	@RequestMapping(value="/buy.htm",method = RequestMethod.GET) 
    public String initializeForm(@ModelAttribute("listing") Listing listing, BindingResult result,HttpServletRequest request)throws Exception { 
		HttpSession session = request.getSession();
		
		if(session.getAttribute("buyer") == null){
			return "UserLogin";
		}
		else{
		
		int sellerDetails = Integer.parseInt(request.getParameter("sellerDetails"));
		ListingDao listingDao = new ListingDao();
		Listing l = listingDao.getSeller(sellerDetails);
		Seller s = l.getSeller();
		long sellerId = s.getPersonID();
		PersonDao personDao = new PersonDao();
		Person p = personDao.findSeller(sellerId);
		session.setAttribute("sellerDetail", p);
		session.setAttribute("buyListing", l);
		return "Buy";
	}
	}

}
