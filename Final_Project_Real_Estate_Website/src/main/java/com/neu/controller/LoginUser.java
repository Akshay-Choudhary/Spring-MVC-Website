package com.neu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.ListingDao;
import com.neu.dao.PersonDao;
import com.neu.exception.AdException;
import com.neu.pojo.Listing;
import com.neu.pojo.Person;
import com.neu.pojo.Seller;

@Controller
public class LoginUser {
	@Autowired
	@Qualifier("roleValidator")
	RoleValidator roleValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(roleValidator);
	}

	/*@RequestMapping(value="/logout.htm",method=RequestMethod.POST)
	protected String doSubmitAction(HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();
		session.getAttribute("user");
		session.invalidate();
		return "index";
	}*/
	@RequestMapping(value="/login.htm",method = RequestMethod.POST)
	protected ModelAndView populateValues(@ModelAttribute("person") Person person, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		PersonDao personDao = new PersonDao();
		String userName = person.getUserName();
		String password = person.getPassword();
		HttpSession session = request.getSession();
		Person p = personDao.authenticate(userName, password);
		session.setAttribute("user", p);
		if (p != null) {
			if (p.getPersonType().equals("agent")) {
				session.setAttribute("agent", p);
			}
			 else if(p.getPersonType().equals("seller")){
				session.setAttribute("seller", p);
			 }else{ session.setAttribute("buyer", p);
				/*int searched = Integer.parseInt(request.getParameter("sellerDetails"));
				System.out.println("hi");
				if(searched != 0){
					ListingDao listingDao = new ListingDao();
					Listing l = listingDao.getSeller(searched);
					Seller s = l.getSeller();
					long sellerId = s.getPersonID();
					Person person1 = personDao.findSeller(sellerId);
					session.setAttribute("sellerDetail", person1);
					session.setAttribute("buyListing", l);
					return new ModelAndView("Buy");*/
				
			}return new ModelAndView("index");
		}
		
		return new ModelAndView("UserLogin");	
	}
		
	/*
	 * @RequestMapping(method = RequestMethod.POST) protected String
	 * doSubmitAction(@ModelAttribute("person") Person person, BindingResult
	 * result) throws Exception { roleValidator.validate(person, result);
	 * if(result.hasErrors()){ return "Register"; }
	 * 
	 * try { PersonDao personDao = new PersonDao(); String userName =
	 * person.getUserName(); String password = person.getPassword(); Person p =
	 * personDao.authenticate(userName,password); if(p != null){
	 * 
	 * return "index"; }else return "UserLogin";
	 * 
	 * } catch (AdException e) { System.out.println("Exception: " +
	 * e.getMessage()); }
	 * 
	 * return "Register"; }
	 */
	@RequestMapping(value="/logout.htm",method=RequestMethod.GET)
	protected String SubmitAction(HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();
		session.getAttribute("user");
		session.invalidate();
		return "Logout";
	}
	@RequestMapping(value="/login.htm",method = RequestMethod.GET)
	public String initializeForm() {

		return "UserLogin";
	}
	

}
