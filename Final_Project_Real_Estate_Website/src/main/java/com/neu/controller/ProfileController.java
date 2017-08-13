package com.neu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.dao.ListingDao;
import com.neu.pojo.Listing;
import com.neu.pojo.Person;
import com.neu.pojo.Seller;

@Controller
public class ProfileController {
	
	@RequestMapping(value="/profile.htm",method = RequestMethod.GET) 
    public String initializeForm(@ModelAttribute("person")Person person,HttpServletRequest request) { 
		
		HttpSession session = request.getSession();
		Person p = (Person)session.getAttribute("user");
		if(p.getPersonType().equals("seller")){
		Seller s = (Seller)session.getAttribute("seller");
		long sellerId = s.getPersonID();
		ListingDao listingDao = new ListingDao();
		//List<Listing> l = listingDao.getTotalSellerListing(sellerId);
		List<Listing> notSold = listingDao.getListingNotSold(sellerId);
		List<Listing> sold = listingDao.getListingSold(sellerId);
		List<Listing> buyerRequests = listingDao.getBuyRequests(sellerId);
		session.setAttribute("buyerRequests", buyerRequests);
		session.setAttribute("mySoldListings",sold);
		
		session.setAttribute("notSold", notSold);
		//session.setAttribute("sold", sold);
		
		}
		else if(p.getPersonType().equals("buyer")){
		long buyerId = p.getPersonID();	
		ListingDao listingDao = new ListingDao();
		List<Listing> l = listingDao.getBuyerPendingListing(buyerId);
		List<Listing> approvedListings = listingDao.getSellerApprovedListing(buyerId);
		session.setAttribute("buyerPendingListings", l);
		session.setAttribute("sellerApprovedListing", approvedListings);
		}
        return "Profile"; 
    } 
	
	@RequestMapping(value="/mySellingList.htm",method = RequestMethod.GET)
	public String showCurrentSellerListing(@ModelAttribute("person")Person person,HttpServletRequest request) throws Exception { 
		
		HttpSession session = request.getSession();
		int listingId = Integer.parseInt(request.getParameter("currentSeller"));
		ListingDao listingDao = new ListingDao();
		Listing listing = listingDao.getSeller(listingId);
		session.setAttribute("foundSellerDetails", listing);
		return "Success";
}
	@RequestMapping(value="/backProfile.htm",method = RequestMethod.GET)
	public String initialise(){
		return "Profile";
	}
	@RequestMapping(value="/backIndex.htm",method = RequestMethod.GET)
	public String indexReturn(){
		return "index";
	}
	@RequestMapping(value="/myApproval.htm",method = RequestMethod.GET)
	public String initialize(HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();
		int listingId = Integer.parseInt(request.getParameter("currentSeller"));
		ListingDao listingDao = new ListingDao();
		Listing listing = listingDao.getSeller(listingId);
		session.setAttribute("foundSellerDetail", listing);
		return "RequestPage";
	}
	@RequestMapping(value="/approveRequest.htm",method = RequestMethod.POST)
	public String initialise(HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();
		Listing listing = (Listing)session.getAttribute("foundSellerDetail");
		int listingId = listing.getListingId();
		ListingDao listingDao = new ListingDao();
		listingDao.setSoldTrue(listingId);
		return "Profile";
	}
}