package com.humanServices.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.humanServices.entities.Address;
import com.humanServices.entities.Provider;
import com.humanServices.entities.ProviderType;
import com.humanServices.entities.QualityStarRating;
import com.humanServices.searchBo.ProviderSearchBo;

@Repository("providerDao")
public class ProviderDaoImpl implements ProviderDao {
	
	@Autowired
	 private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Provider> searchProviders(ProviderSearchBo searchBo) {
		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(Provider.class,"provider");
		createCriteria.createAlias("provider.providerType", "providerType");
		createCriteria.createAlias("provider.address", "address");
		createCriteria.createAlias("provider.rating", "rating");
		if(searchBo.getProviderName() != null && !searchBo.getProviderName().trim().equals(""))
			createCriteria.add(Restrictions.eq("provider.name", searchBo.getProviderName()));
		if( null != searchBo.getProviderType())
			createCriteria.add(Restrictions.eq("providerType.typeId", searchBo.getProviderType().getTypeId()));
		if( null != searchBo.getAddressCounty())
			createCriteria.add(Restrictions.eq("address.county", searchBo.getAddressCounty().getCounty()));
		if( null != searchBo.getAddressCity())
			createCriteria.add(Restrictions.eq("address.city", searchBo.getAddressCity().getCity()));
		if( null != searchBo.getQualityRating())
			createCriteria.add(Restrictions.eq("rating.ratingId", searchBo.getQualityRating().getRatingId()));
		return (List<Provider>) createCriteria.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ProviderType> searchProviderTypes() {
		return (List<ProviderType>) sessionFactory.getCurrentSession().createCriteria(ProviderType.class).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<QualityStarRating> listRatings() {
		return (List<QualityStarRating>) sessionFactory.getCurrentSession().createCriteria(QualityStarRating.class).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Address> listAddresses() {
		return (List<Address>) sessionFactory.getCurrentSession().createCriteria(Address.class).list();
	}

}
