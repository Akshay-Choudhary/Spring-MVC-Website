package com.neu.controller;






import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.ListingDao;
import com.neu.dao.PersonDao;
import com.neu.exception.AdException;
import com.neu.pojo.Listing;
import com.neu.pojo.Person;
import com.neu.pojo.Seller;



@Controller
@RequestMapping("/sell.htm")
public class SellerController {
	
	
	
	@RequestMapping(method=RequestMethod.POST)
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
			System.out.println(context);
			
			listing.getPhoto().transferTo(file);
			listing.setImageName(context +"/"+fileNameWithExt);
		}
		HttpSession session = request.getSession();
		Seller s = (Seller)session.getAttribute("seller");
		ListingDao listingDao = new ListingDao();
		listingDao.insert(listing.getListingType(),listing.getNoOfRooms(),listing.getNoOfBaths(),listing.getAreaSize(),listing.getPrice(),listing.getImageName(),listing.getPropertyType(),listing.getAddress(),s);
		System.out.print(listing.getPhoto());
		
		}catch(Exception e){
			System.out.println(e);
		}

		return "sell";
	}
	
	
	
	 @RequestMapping(method = RequestMethod.GET) 
	 public String initializeForm(@ModelAttribute("listing")Listing listing, BindingResult result,HttpServletRequest request)throws Exception { 
		 
		 HttpSession session = request.getSession();
			
			if (session.getAttribute("user")!= null){
				return "sell";
	        }
			else
				return "UserLogin";
	    } 
	 /*@RequestMapping(method = RequestMethod.GET)
	 protected ModelAndView populateValues(HttpServletRequest request, HttpServletResponse response) throws Exception {  
	   
		 
		 ModelAndView model = new ModelAndView("sell");
		 Listing listing = new Listing();
		 model.addObject(listing);
	        return model; 
	    } */
}
