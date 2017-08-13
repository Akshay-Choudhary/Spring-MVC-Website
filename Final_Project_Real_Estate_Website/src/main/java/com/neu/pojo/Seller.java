package com.neu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.jws.Oneway;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "seller")
@PrimaryKeyJoinColumn(name = "personID")

public class Seller extends Person {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sellerId")
	private int sellerId;*/

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "seller")
	private Set<Listing> sellerListings = new HashSet<Listing>();

	@Column(name="isBuyer")
	public String isBuyer;
	
	public String getIsBuyer() {
		return isBuyer;
	}

	public void setIsBuyer(String isBuyer) {
		this.isBuyer = isBuyer;
	}

	public Seller() {

	}

	public Set<Listing> getSellerListings() {
		return sellerListings;
	}

	public void setSellerListings(Set<Listing> sellerListings) {
		this.sellerListings = sellerListings;
	}

	public void addListing(Listing listing){
		getSellerListings().add(listing);
	}
	// public int getSellerId() {
	// return sellerId;
	// }
	//
	// public void setSellerId(int sellerId) {
	// this.sellerId = sellerId;
	// }

}
