package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Listing")
public class Listing {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="listingId")
	private int listingId;
	
	@Column(name="listingType")
	private String listingType;
	
	@Column(name="propertyType",nullable=true)
	private String propertyType;
	
	@Column(name="NoOfBedrooms")
	private int noOfRooms;
	
	@Column(name="NoOfBaths")
	private int noOfBaths;
	
	
	@Column(name="Area")
	private int areaSize;
	
	@Column(name="price")
	private int price;
	
	@Column(name="address")
	private String address;
	
	@Column(name="sold")
	boolean sold = false;
	
	@Column(name="image")
	private String imageName;
	
	@Column(name="buyRequest")
	private String buyRequest;
	
	public String getBuyRequest() {
		return buyRequest;
	}
	public void setBuyRequest(String buyRequest) {
		this.buyRequest = buyRequest;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	@Transient
	private MultipartFile photo;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=true)
	@JoinColumn(name="sellerId")
	private Seller seller;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=true)
	@JoinColumn(name="agentId")
	private Agent agent;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=true)
	@JoinColumn(name="buyerId")
	private Buyer buyer;
	
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public Listing()
	{
						
	}
	public Listing(String listingType,String propertyType,int noOfRooms,int noOfBaths,int areaSize,int price,String imageName,Seller seller)
	{
		this.listingType = listingType;
		this.propertyType = propertyType;
		this.noOfRooms = noOfRooms;
		this.noOfBaths = noOfBaths;
		this.areaSize = areaSize;
		this.price = price;
		this.imageName = imageName;
		this.seller = seller;
		this.sold = sold;
	}
	
	
	public int getListingId() {
		return listingId;
	}
	public void setListingId(int listingId) {
		this.listingId = listingId;
	}
	public String getListingType() {
		return listingType;
	}
	public void setListingType(String listingType) {
		this.listingType = listingType;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public int getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public int getAreaSize() {
		return areaSize;
	}
	public void setAreaSize(int areaSize) {
		this.areaSize = areaSize;
	}
	public int getPrice() {
		return price;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	public int getNoOfBaths() {
		return noOfBaths;
	}
	public void setNoOfBaths(int noOfBaths) {
		this.noOfBaths = noOfBaths;
	}
	

	
}
