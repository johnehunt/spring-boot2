package com.jjh.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jjh.domain.Address;

@Component
public class AddressServiceImpl implements AddressService {

	@Value("#{\"Supplier of Address Objects\"}")
	private String description;
	
	@Value("#{new String()}")
	private String information;
	
	@Value("#{company.name}")
	private String companyName;
	
	@Value("#{regionDAO.getRegion()}")
	private String region;
	
	@Value("#{ T(com.jjh.domain.AddressUtil).getServiceId()}")
	private int serviceId;
	
	public Address getAddress(int id) {
		Address address = new Address(id, 1, "High Street", "Tech Town", "Kent", "KT12 3RR");
		return address;
	}

}
