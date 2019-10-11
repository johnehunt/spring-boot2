package com.jjh.domain;

public class Address {
	private int id;
	private int number;
	private String street;
	private String town;
	private String county;
	private String postcode;
	
	public Address(int id, int number, String street, String town, String county, String postcode) {
		super();
		this.id = id;
		this.number = number;
		this.street = street;
		this.town = town;
		this.county = county;
		this.postcode = postcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return String.format("Address [id=%s, number=%s, street=%s, town=%s, county=%s, postcode=%s]", id, number,
				street, town, county, postcode);
	}
	
	
}
