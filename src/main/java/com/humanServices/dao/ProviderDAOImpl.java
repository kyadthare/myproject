package com.humanServices.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.humanServices.controller.ProviderSearchBO;
import com.humanServices.entity.Provider;
import com.humanServices.entity.ProviderType;
import com.humanServices.entity.QualityStarRating;

/**
 * Implements the functionalities of ProviderDAO.
 * 
 * @author balachandra
 *
 */

@Repository("providerDao")
public class ProviderDAOImpl implements ProviderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Provider> searchProviders(ProviderSearchBO searchBO) {

		Criteria createCriteria = sessionFactory.getCurrentSession().createCriteria(Provider.class, "provider");
		createCriteria.createAlias("provider.providerType", "providerType");
		createCriteria.createAlias("provider.address", "address");
		createCriteria.createAlias("provider.rating", "rating");

		if (searchBO.getProviderName() != null && !searchBO.getProviderName().trim().equals("")) {
			createCriteria.add(Restrictions.like("provider.name", "%"+ searchBO.getProviderName() + "%").ignoreCase());
		}

		if (null != searchBO.getProviderType()) {
			createCriteria.add(Restrictions.eq("providerType.typeId", searchBO.getProviderType().getTypeId()));
		}

		if (null != searchBO.getCounty()) {
			createCriteria.add(Restrictions.eq("address.county", searchBO.getCounty()).ignoreCase());
		}

		if (null != searchBO.getCity()) {
			createCriteria.add(Restrictions.eq("address.city", searchBO.getCity()).ignoreCase());
		}

		if (null != searchBO.getQualityRating()) {
			createCriteria.add(Restrictions.eq("rating.ratingId", searchBO.getQualityRating().getRatingId()));
		}

		return (List<Provider>) createCriteria.list();
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ProviderType> getProviderTypes() {

		return (List<ProviderType>) sessionFactory.getCurrentSession()
				.createCriteria(ProviderType.class).list();
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<QualityStarRating> getRatings() {

		return (List<QualityStarRating>) sessionFactory.getCurrentSession()
				.createCriteria(QualityStarRating.class).list();
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<String> getCounties() {

		String sql = "SELECT DISTINCT COUNTY FROM ADDRESS ORDER BY COUNTY ASC";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		return query.list();
	}
	

	@SuppressWarnings("unchecked")
	@Transactional
	public List<String> getCities(String county) {

		StringBuilder sql = new StringBuilder("");
		StringBuilder whereClause = new StringBuilder("");

		if (null != county && !county.trim().equals("")) {
			whereClause.append(" WHERE COUNTY='").append(county).append("' ");
		}

		sql.append("SELECT DISTINCT CITY FROM ADDRESS ").append(whereClause).append(" ORDER BY CITY ASC");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());

		return query.list();
	}

	
}
