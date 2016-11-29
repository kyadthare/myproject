package com.humanServices.Test;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.humanServices.controller.ProviderController;
import com.humanServices.entities.Address;
import com.humanServices.entities.Provider;
import com.humanServices.entities.ProviderType;
import com.humanServices.entities.QualityStarRating;
import com.humanServices.searchBo.ProviderSearchBo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/config/providerManagement-servlet.xml" })
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class ProviderSearchTest {
	
	@Autowired
	 private ProviderController providerController;
	
	 
	  @Test
	  public void testgetCityList() throws Exception{		  
		 
				 	  
		List<Address> cityList =  providerController.getCityList();
		
		assertNotNull(cityList);		  
		 		 
		  
	  }
	
	  
	  @Test
	  public void testgetCountyList() throws Exception{		  
		 
				 	  
		List<Address> countyList =  providerController.getCountyList();
		
		assertNotNull(countyList);		  
		 		 
		  
	  }
	
	  @Test
	  public void testgetProviderList() throws Exception{		
		  
		  ProviderSearchBo providerSearchBo = new ProviderSearchBo();
		  
		  Address addressCity = new Address();
		 
		  addressCity.setAddressId(12);
		  addressCity.setCity("Bangalore");
		  addressCity.setCounty("BANG");
		  addressCity.setCountyNumber(12);
		  addressCity.setZipcode(1233);
		  
		  QualityStarRating qualityRating = new QualityStarRating();
		  
		  qualityRating.setDescription("QuallityRatingDesc");
		  qualityRating.setRatingId(12);
		  
		  ProviderType providerType = new ProviderType();
		  
		  providerType.setDescription("providerDesc");
		  providerType.setTypeId(new Long(1231));
		  
		  
		  providerSearchBo.setAddressCounty(addressCity);
		  
		  providerSearchBo.setProviderType(providerType);
		  
		  providerSearchBo.setQualityRating(qualityRating);
		  		  
		  providerSearchBo.setProviderName("Provider");
		  
		  providerSearchBo.setAddressCity(addressCity);
		 
				 	  
	      List <Provider> providerList = providerController.getProviderList(providerSearchBo);
		
		  assertNotNull(providerList);		  
		 		 
		  
	  }
	  
	  @Test
	  public void testgetProviderTypeList() throws Exception{		
		  
				 	  
	      List <ProviderType> providerTypeList = providerController.getProviderTypeList();
		
		assertNotNull(providerTypeList);		  
		 		 
		  
	  }
	  
	  @Test
	  public void testgetRatingList() throws Exception{		
		  
				 	  
	     List<QualityStarRating> qualityStarRatingList = providerController.getRatingList();
		
		assertNotNull(qualityStarRatingList);		  
		 		 
		  
	  }
	  
	
	

}

