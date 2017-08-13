package com.neu.controller;

import java.io.File;

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
import com.neu.pojo.Seller;

@Controller
public class AgentInfoController {
		
	@RequestMapping(value="/contactAgent.htm",method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("listing") Listing listing, BindingResult result,@RequestParam("photo")MultipartFile photoFile,HttpServletRequest request) throws Exception {
	 System.out.println(listing);
		try{
		listing.setPhoto(photoFile);
		File file;
		String check = File.separator;
		String path = null;
		System.out.print("test");
		if(check.equalsIgnoreCase("\\")){
			path = request.getSession().getServletContext().getRealPath("").replace("build\\","");
		}
		if(check.equalsIgnoreCase("/")) {
		       path = request.getSession().getServletContext().getRealPath("").replace("build\\","");
		       path += "/"; //Adding trailing slash for Mac systems.

		    }
		if(listing.getPhoto()!=null)
		{
			
			String fileNameWithExt = System.currentTimeMillis() + listing.getPhoto().getOriginalFilename();
			file = new File(path + fileNameWithExt);
			String context = request.getSession().getServletContext().getContextPath();
			listing.getPhoto().transferTo(file);
			listing.setImageName(context + "/" +fileNameWithExt);
		}
		HttpSession session = request.getSession();
		Seller s = (Seller)session.getAttribute("seller");
		Agent agent=(Agent)session.getAttribute("agentFound");
		ListingDao listingDao = new ListingDao();
		listingDao.requestAgentListing(listing.getListingType(),listing.getNoOfRooms(),listing.getNoOfBaths(),listing.getAreaSize(),listing.getImageName(),listing.getAddress(),s,agent);
		System.out.print(listing.getPhoto());
		}catch(Exception e){
			System.out.println(e);
		}

		return "index";
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="/approach.htm",method=RequestMethod.GET)
	protected String SubmitAction(HttpServletRequest request)throws Exception{
		
		String agentWindow = request.getParameter("agentWindow");
		PersonDao personDao = new PersonDao();
		HttpSession session = request.getSession();
		Person p = personDao.findAgent(agentWindow);
		session.setAttribute("agentFound", p);
		return "AgentInfo";
	}
}
