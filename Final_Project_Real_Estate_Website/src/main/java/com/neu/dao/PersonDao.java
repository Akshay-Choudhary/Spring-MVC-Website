package com.neu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.neu.exception.AdException;
import com.neu.pojo.Agent;
import com.neu.pojo.Buyer;
import com.neu.pojo.Person;
import com.neu.pojo.Seller;

public class PersonDao extends DAO {

	public PersonDao() {

	}

	public void create(String userName, String password, String firstName, String lastName, String city,
			String personType, String gender, String contactInfo, String email) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			if (personType.equals("agent")) {
				Agent agent = new Agent();
				agent.setUserName(userName);
				agent.setPassword(password);
				agent.setFirstName(firstName);
				agent.setLastName(lastName);
				agent.setCity(city);
				agent.setPersonType(personType);
				agent.setGender(gender);
				agent.setContactInfo(contactInfo);
				agent.setEmail(email);
				getSession().save(agent);

			} else if(personType.equals("seller")) {
				Seller seller = new Seller();
				seller.setUserName(userName);
				seller.setPassword(password);
				seller.setFirstName(firstName);
				seller.setLastName(lastName);
				seller.setCity(city);
				seller.setPersonType(personType);
				seller.setGender(gender);
				seller.setContactInfo(contactInfo);
				seller.setEmail(email);
				// Person person = new
				// Person(userName,password,firstName,lastName,city,dateOfBirth,gender,contactInfo,email);
				getSession().save(seller);

			}else {
				Buyer buyer = new Buyer();
				buyer.setUserName(userName);
				buyer.setPassword(password);
				buyer.setFirstName(firstName);
				buyer.setLastName(lastName);
				buyer.setCity(city);
				buyer.setPersonType(personType);
				buyer.setGender(gender);
				buyer.setContactInfo(contactInfo);
				buyer.setEmail(email);
				getSession().save(buyer);
			}

			commit();

		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}

	public Person authenticate(String userName, String password) throws AdException {

		try {
			begin();
			Query q = getSession().createQuery("from Person where userName = :userName and password = :password");
			q.setParameter("userName", userName);
			q.setParameter("password", password);
			Person p = (Person) q.uniqueResult();
			commit();
			return p;

		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}

	public Person findAgent(String agentWindow) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Person where userName = :agentWindow");
			q.setParameter("agentWindow", agentWindow);
			Person p = (Person) q.uniqueResult();
			commit();
			return p;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}

	public Person findSeller(long sellerId) throws AdException {

		begin();
		Query q = getSession().createQuery("from Person where personID = :sellerId");
		q.setLong("sellerId", sellerId);
		Person p = (Person) q.uniqueResult();
		commit();
		return p;

	}

}
