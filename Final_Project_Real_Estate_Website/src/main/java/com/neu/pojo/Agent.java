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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Agent")
@PrimaryKeyJoinColumn(name="personID")

public class Agent extends Person{
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="AgentId")
//	private int agentId;
	
	@Column(name="licenceno")
	private int LicenceNo;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="agent")
	private Set<Listing> agentListings = new HashSet<Listing>();

	

	public Set<Listing> getAgentListings() {
		return agentListings;
	}

	public void setAgentListings(Set<Listing> agentListings) {
		this.agentListings = agentListings;
	}
	
	public void addListing(Listing listing){
		getAgentListings().add(listing);
	}

//	public int getAgentId() {
//		return agentId;
//	}
//
//	public void setAgentId(int agentId) {
//		this.agentId = agentId;
//	}

	public int getLicenceNo() {
		return LicenceNo;
	}

	public void setLicenceNo(int licenceNo) {
		LicenceNo = licenceNo;
	}
}
