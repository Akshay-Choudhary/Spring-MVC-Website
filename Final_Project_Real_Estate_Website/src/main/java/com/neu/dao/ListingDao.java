package com.neu.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.neu.pojo.Agent;
import com.neu.pojo.Listing;
import com.neu.pojo.Seller;

public class ListingDao extends DAO{

	
	public Listing insert(String listingType,int noOfRooms,int noOfBaths,int areaSize, int price,String imageName,String postedProperty,String address,Seller s)
	{
		begin();
		
		Listing listing = new Listing();
		listing.setListingType(listingType);
		listing.setNoOfRooms(noOfRooms);
		listing.setNoOfBaths(noOfBaths);
		listing.setAreaSize(areaSize);
		listing.setPrice(price);
		listing.setImageName(imageName);
		listing.setPropertyType(postedProperty);
		listing.setAddress(address);
		listing.setSeller(s);
		getSession().save(listing);
		
		commit();
		return listing;
	}
	public Listing requestAgentListing(String listingType,int noOfRooms,int noOfBaths,int areaSize, String imageName,String address,Seller s,Agent agent)
	{
		begin();
		
		Listing listing = new Listing();
		listing.setListingType(listingType);
		listing.setNoOfRooms(noOfRooms);
		listing.setNoOfBaths(noOfBaths);
		listing.setAreaSize(areaSize);
		
		listing.setImageName(imageName);
		
		listing.setAddress(address);
		listing.setSeller(s);
		listing.setAgent(agent);
		getSession().save(listing);
		
		commit();
		return listing;
	}
	public int buyRequest(int listingId,long buyerId){
		begin();
		Query q = getSession().createQuery("update Listing set buyRequest = :buyRequest,buyer = :buyerId" + " where listingId = :listingId");
		q.setInteger("listingId", listingId);
		q.setLong("buyerId", buyerId);
		q.setString("buyRequest", "Yes");
		int result = q.executeUpdate();
		commit();
		return result;
		
	}
	
	public List<Listing> findAgentById(Long agentId)
	{
		Query q = getSession().createQuery("from Listing where agentId = :agentId");
		q.setParameter("agentId",agentId);
		List<Listing> results = q.list();
		return results;
		
	}
	public List getListing()
	{
		begin();
		Query q = getSession().createQuery("from Listing where listingType = :listingType and sold = :sold");
		q.setParameter("listingType","Sell");
		q.setBoolean("sold", false);
		
		q.setMaxResults(6);
		List results = q.list();
		 return results;
	}
	public List getRentListing()
	{
		begin();
		Query q = getSession().createQuery("from Listing where listingType = :listingType and sold = :sold");
		q.setParameter("listingType","Rent");
		q.setBoolean("sold", false);
		
		q.setMaxResults(6);
		List results = q.list();
		 return results;
	}
	public List getOnlySellListing(){
		begin();
		Query q = getSession().createQuery("from Listing where listingType = :listingType");
		q.setParameter("listingType","Sell");
		q.setMaxResults(9);
		List results = q.list();
		 return results;
	}
	public List getOnlyRentListing(){
		begin();
		Query q = getSession().createQuery("from Listing where listingType = :listingType");
		q.setParameter("listingType","Rent");
		q.setMaxResults(9);
		List results = q.list();
		 return results;
	}
	public Listing findSellerDetails(long agentId,long sellerId){
			
			Query q = getSession().createQuery("from Listing where agent = :agentId and seller = :sellerId");
			q.setLong("sellerId", sellerId);
			q.setLong("agentId", agentId);
			Listing l = (Listing) q.uniqueResult();
			return l;
			
			
	}
	public void updateListing(int listingId,int price,String propertyType)
	{	
		begin();
		Query q = getSession().createQuery("update Listing set price = :price,propertyType = :propertyType" + " where listingId = :listingId");
		q.setParameter("price", price);
		q.setParameter("propertyType", propertyType);
		q.setParameter("listingId", listingId);
		int  result = q.executeUpdate();
		commit();
		
	}
	
	public List getTotalSellerListing(long sellerId)
	{
		Query q = getSession().createQuery("from Listing where seller = :sellerId");
		q.setLong("sellerId", sellerId);
		List results = q.list();
		return results;
	}
	
	public List getListingNotSold(long sellerId){
		Query q = getSession().createQuery("from Listing where sold = :sold");
		q.setBoolean("sold", false);
		List results = q.list();
		return results;
	}
	public List getListingSold(long sellerId){
		Query q = getSession().createQuery("from Listing where sold = :sold and seller = :sellerId");
		q.setBoolean("sold", Boolean.TRUE);
		q.setLong("sellerId", sellerId);
		List results = q.list();
		return results;
	}
	public List getBuyRequests(long sellerId){
		Query q = getSession().createQuery("from Listing where seller = :sellerId and buyRequest = :buyRequest and sold = :sold");
		q.setLong("sellerId",sellerId);
		q.setBoolean("sold", Boolean.FALSE);
		q.setString("buyRequest", "Yes");
		List results = q.list();
		return results;
	}
	
	public List getBuyerPendingListing(long buyerId){
		Query q = getSession().createQuery("from Listing where buyRequest = :buyRequest and buyerId = :buyerId and sold = :sold");
		q.setString("buyRequest","Yes");
		q.setLong("buyerId", buyerId);
		q.setBoolean("sold", Boolean.FALSE);
		List results = q.list();
		return results;
	}
	public List getSellerApprovedListing(long buyerId){
		Query q = getSession().createQuery("from Listing where sold = :sold and buyer = :buyerId");
		q.setBoolean("sold", Boolean.TRUE);
		q.setLong("buyerId", buyerId);
		List results = q.list();
		return results;
	}

	public Listing getSeller(int listingId)
	{
		begin();
		Query q = getSession().createQuery("from Listing where listingId = :listingId");
		q.setInteger("listingId", listingId);
		Listing listing = (Listing)q.uniqueResult();
		return listing;
	}
	public void setSoldTrue(int listingId){
		begin();
		Query q = getSession().createQuery("update Listing set sold = :sold where listingId = :listingId");
		q.setBoolean("sold", Boolean.TRUE);
		q.setInteger("listingId", listingId);
		int result = q.executeUpdate();
		commit();
	}
	
}
