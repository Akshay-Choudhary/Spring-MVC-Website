package com.neu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.dao.ListingDao;
import com.neu.dao.PersonDao;
import com.neu.exception.AdException;
import com.neu.pojo.Listing;
import com.neu.pojo.Person;

@Controller
public class HomeController {
	
	
	
	@RequestMapping(value="/index.htm",method = RequestMethod.GET) 
    public String initializeForm(@ModelAttribute("listing") Listing listing, BindingResult result,HttpServletRequest request)throws Exception { 
   
		try {
			System.out.print("test");
			ListingDao listingDao = new ListingDao();
			System.out.print("test1");
			List<Listing> listingDetails = listingDao.getListing();
			List<Listing> rentalDetails = listingDao.getRentListing();
			HttpSession session = request.getSession();
		
			session.setAttribute("listingDetails",listingDetails);
			session.setAttribute("rentalDetails", rentalDetails);
			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
        return "index"; 
    }
	
	@RequestMapping(value="/ownHome.htm",method=RequestMethod.GET)
	public String onlySell(HttpServletRequest request)throws Exception
	{
		ListingDao listingDao = new ListingDao();
		List<Listing> sellDetails = listingDao.getOnlySellListing();
		HttpSession session = request.getSession();
		session.setAttribute("sellDetails",sellDetails);
		return "OwnYourHome";
	}
	@RequestMapping(value="/rentHome.htm",method=RequestMethod.GET)
	public String onlyRent(HttpServletRequest request)throws Exception
	{
		ListingDao listingDao = new ListingDao();
		List<Listing> onlyRentDetails = listingDao.getOnlyRentListing();
		HttpSession session = request.getSession();
		session.setAttribute("onlyRentDetails",onlyRentDetails);
		return "RentHome";
	}
	
}
