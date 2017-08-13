package com.neu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.exception.AdException;

public class DisplayAgentDao extends DAO {

	public DisplayAgentDao() {

	}

	public List getAgents() throws AdException {
		try {
			begin();
			
			Query q = getSession().createQuery("from Person p where p.personType='agent'");
			List results = q.list();
			return results;
		} catch (HibernateException e) {
			rollback();
			
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}
}
