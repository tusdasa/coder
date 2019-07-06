package net.zhulan.coder.service;

import java.util.List;

import net.zhulan.coder.entity.Address;

public interface IAddressService {
	
	boolean addAddress(Address address);
	List<Address> findAll();
	boolean delAddress(Integer did);
	boolean upAddress(Address address);

}
