package com.humanServices.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.humanServices.controller.ProviderController;
import com.humanServices.controller.ProviderSearchBO;
import com.humanServices.entity.Provider;
import com.humanServices.entity.ProviderType;
import com.humanServices.entity.QualityStarRating;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/application-context.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class ProviderSearchTest {

	@Autowired
	private ProviderController providerController;

	@Test
	public void testGetCityList() throws Exception {

		String county = "NY";

		List<String> cityList = providerController.getCityList(county);

		assertNotNull(cityList);

	}

	@Test
	public void testGetCountyList() throws Exception {

		List<String> countyList = providerController.getCountyList();

		assertNotNull(countyList);

	}

	@Test
	public void testGetProviderList() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		List<Provider> providerList = new ArrayList<Provider>();

		QualityStarRating qualityRating = new QualityStarRating();

		qualityRating.setDescription("QuallityRatingDesc");
		qualityRating.setRatingId(1);

		ProviderType providerType = new ProviderType();

		providerType.setDescription("providerDesc");
		providerType.setTypeId(new Long(1231));

		providerSearchBo.setCity("Delhi");

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setQualityRating(qualityRating);

		providerSearchBo.setProviderName("ProviderName");

		providerSearchBo.setCounty("DL");

		providerList = providerController.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList1() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		ProviderType providerType = new ProviderType();

		providerType.setDescription("slot Contractor");
		providerType.setTypeId(new Long(1231));

		providerSearchBo.setProviderType(providerType);

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList2() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		providerSearchBo.setCity("Bangalore");

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList3() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		QualityStarRating qualityRating = new QualityStarRating();

		qualityRating.setDescription("3");
		qualityRating.setRatingId(2312);

		providerSearchBo.setQualityRating(qualityRating);

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList4() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		providerSearchBo.setCounty("KA");
		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList5() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("ProviderTest");

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList6() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("ProviderTest12");

		providerSearchBo.setCounty("MP");

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList7() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("ProviderTest45");

		QualityStarRating qualityRating = new QualityStarRating();

		qualityRating.setDescription("QuallityRatingDesc12");
		qualityRating.setRatingId(2);

		providerSearchBo.setQualityRating(qualityRating);

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList8() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("ProviderName");

		providerSearchBo.setCity("MH");
		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList9() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("ProviderName_test");

		ProviderType providerType = new ProviderType();

		providerType.setDescription("GROUND");
		providerType.setTypeId(new Long(1231));

		providerSearchBo.setProviderType(providerType);

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList10() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("ProviderName");

		ProviderType providerType = new ProviderType();

		providerType.setDescription("GroupHome");
		providerType.setTypeId(new Long(1231));

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setCity("Bhopal");

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList11() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("YangKi");

		ProviderType providerType = new ProviderType();

		providerType.setDescription("Center");
		providerType.setTypeId(new Long(1231));

		providerSearchBo.setProviderType(providerType);

		QualityStarRating qualityRating = new QualityStarRating();

		qualityRating.setDescription("QuallityRatingDesc");
		qualityRating.setRatingId(7);

		providerSearchBo.setQualityRating(qualityRating);

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList12() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("ProviderNameYZ");

		ProviderType providerType = new ProviderType();

		providerType.setDescription("relativeInhome");
		providerType.setTypeId(new Long(1231));

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setCounty("HP");

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList13() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("ProviderName");

		ProviderType providerType = new ProviderType();

		providerType.setDescription("RelativeOutOfhome");
		providerType.setTypeId(new Long(1231));

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setCounty("UP");

		QualityStarRating qualityRating = new QualityStarRating();

		qualityRating.setDescription("QuallityRatingDesc123");
		qualityRating.setRatingId(8);

		providerSearchBo.setQualityRating(qualityRating);

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList14() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("ProviderName");

		ProviderType providerType = new ProviderType();

		providerType.setDescription("NonRelativeInHome");
		providerType.setTypeId(new Long(1231));

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setCounty("BJ");

		providerSearchBo.setCity("Bijnor");

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList15() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		ProviderType providerType = new ProviderType();

		providerType.setDescription("NOnRelativeOutOfHome");
		providerType.setTypeId(new Long(1231));

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setCounty("TN");

		providerSearchBo.setCity("Chennai");
		QualityStarRating qualityRating = new QualityStarRating();

		qualityRating.setDescription("QuallityRatingDesc");
		qualityRating.setRatingId(2);

		providerSearchBo.setQualityRating(qualityRating);

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList16() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		ProviderType providerType = new ProviderType();

		providerType.setDescription("NOnRelativeOutOfHome");
		providerType.setTypeId(new Long(1231));

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setCounty("MH");

		providerSearchBo.setCity("Mumbai");

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertNotNull(providerList);

	}

	@Test
	public void testGetProviderList17() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		List<Provider> providerList = new ArrayList<Provider>();

		try {

			providerList = providerController.getProviderList(providerSearchBo);

			if (providerList.size() >= 1) {
				assertNotNull(providerList);
			} else {
				System.out.println("List is empty");
				assertNull(providerList);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetProviderTypeList() throws Exception {

		List<ProviderType> providerTypeList = providerController
				.getProviderTypeList();

		assertNotNull(providerTypeList);

	}

	@Test
	public void testGetRatingList() throws Exception {

		List<QualityStarRating> qualityStarRatingList = providerController
				.getRatingList();

		assertNotNull(qualityStarRatingList);

	}

}
