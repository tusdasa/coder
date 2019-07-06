package net.zhulan.coder.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;

import net.zhulan.coder.dao.BaseDaoObject;
import net.zhulan.coder.dao.IAddressDao;
import net.zhulan.coder.entity.Address;

import net.zhulan.coder.utils.DaoUtils;

public class AddressDaoImpl extends BaseDaoObject implements IAddressDao {

	private DaoUtils<Address> dao = new DaoUtils<>();
	
	public AddressDaoImpl() {}

	@Override
	public boolean deleteByPrimaryKey(Integer did) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("AddressDao.deleteByPrimaryKey");
		
		boolean result = dao.delete(em, jsql, did);
		
		dao.close(em);
		
		return result;
	}

	@Override
	public boolean addModel(Address model) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		boolean result =  dao.add(em, model);
		
		dao.close(em);
		
		return result;
	}

	@Override
	public Address selectByPrimaryKey(Integer did) {
		return null;
	}

	@Override
	public int updateByPrimaryKey(Address model) {
		
		int result = 0;
		
		if(model.getDid()==0) {
			return 0;
		}
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("AddressDao.updateByPrimaryKey");
		
		result = dao.update(em, jsql, 3, model.getAddress(),model.getTitle(),model.getDid());
		
		return result;
	}

	@Override
	public List<Address> findAll() {
		
		List<Address> result = null;
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("AddressDao.findAll");
		
		result = dao.selectList(em, jsql);
		
		return result;
	}

}
