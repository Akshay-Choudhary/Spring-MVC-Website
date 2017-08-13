package com.neu.controller;

import javax.servlet.http.HttpServletRequest;
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

import com.neu.dao.PersonDao;
import com.neu.exception.AdException;
import com.neu.pojo.Person;

@Controller
@RequestMapping("register")
public class RegisterUser {
	@Autowired
	@Qualifier("personValidator")
	PersonValidator personValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(personValidator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("person") Person person, BindingResult result,
			HttpServletRequest request) throws Exception {
		personValidator.validate(person, result);
		if (result.hasErrors()) {
			return "Register";
		}

		try {
			System.out.print("test");
			PersonDao personDao = new PersonDao();
			System.out.print("test1");

			personDao.create(person.getUserName(), person.getPassword(), person.getFirstName(), person.getLastName(),
					person.getCity(), person.getPersonType(), person.getGender(), person.getContactInfo(),
					person.getEmail());

			request.setAttribute("success", person);
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "Register";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("person") Person person, BindingResult result) {

		return "Register";
	}
}
