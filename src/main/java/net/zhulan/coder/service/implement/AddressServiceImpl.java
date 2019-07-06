package net.zhulan.coder.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zhulan.coder.dao.IAddressDao;
import net.zhulan.coder.dao.ICacheDao;
import net.zhulan.coder.entity.Address;
import net.zhulan.coder.service.IAddressService;

@Service("addressService")
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressDao addressDao;
	
	@Autowired
	private ICacheDao cacheDao;

	public AddressServiceImpl() {
	}

	@Override
	public boolean addAddress(Address address) {
		cacheDao.clearCache();
		return addressDao.addModel(address);
	}

	@Override
	public List<Address> findAll() {
		List<Address> addresses = cacheDao.getAddressCache();
		
		if(addresses!=null) {
			return addresses;
		}else {
			addresses = addressDao.findAll();
			cacheDao.addAddressCache(addresses);
			return addresses;
		}
		
	}

	@Override
	public boolean delAddress(Integer did) {
		cacheDao.clearCache();
		return addressDao.deleteByPrimaryKey(did);
	}

	@Override
	public boolean upAddress(Address address) {
		cacheDao.clearCache();
		int result = addressDao.updateByPrimaryKey(address);
		if (result > 0) {
			return true;
		} else {
			return false;
		}

	}

}
