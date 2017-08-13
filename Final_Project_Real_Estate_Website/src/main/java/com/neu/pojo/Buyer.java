package com.neu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Buyer")
@PrimaryKeyJoinColumn(name="personID")

public class Buyer extends Person{

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="BuyerId")
//	private int BuyerId;
	
	@Column(name="buyPropType")
	private String buyPropType;
	
	@Column(name="minArea")
	private int minArea;
	
	@Column(name="maxArea")
	private int maxArea;
	
	@Column(name="minBudget")
	private int minBudget;
	
	@Column(name="maxBudget")
	private int maxBudget;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "buyer")
	private Set<Listing> sellerListings = new HashSet<Listing>();
	
public Set<Listing> getSellerListings() {
		return sellerListings;
	}
	public void setSellerListings(Set<Listing> sellerListings) {
		this.sellerListings = sellerListings;
	}
	
	
	public Buyer(){
		
	}
	//	public int getBuyerId() {
//		return BuyerId;
//	}
//	public void setBuyerId(int buyerId) {
//		BuyerId = buyerId;
//	}
	public String getBuyPropType() {
		return buyPropType;
	}
	public void setBuyPropType(String buyPropType) {
		this.buyPropType = buyPropType;
	}
	public int getMinArea() {
		return minArea;
	}
	public void setMinArea(int minArea) {
		this.minArea = minArea;
	}
	public int getMaxArea() {
		return maxArea;
	}
	public void setMaxArea(int maxArea) {
		this.maxArea = maxArea;
	}
	public int getMinBudget() {
		return minBudget;
	}
	public void setMinBudget(int minBudget) {
		this.minBudget = minBudget;
	}
	public int getMaxBudget() {
		return maxBudget;
	}
	public void setMaxBudget(int maxBudget) {
		this.maxBudget = maxBudget;
	}
	
	
}
