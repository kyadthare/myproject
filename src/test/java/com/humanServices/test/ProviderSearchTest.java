package com.humanServices.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
		providerType.setTypeId(new Long(2));

		providerSearchBo.setProviderType(providerType);

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertFalse("slot Contractor", providerList.get(1).getProviderType()
				.equals("slot Contractor"));

	}

	@Test
	public void testGetProviderList2() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		providerSearchBo.setCity("WALLS");

		try

		{
			List<Provider> providerList = providerController
					.getProviderList(providerSearchBo);

			assertEquals(8, providerList.size());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Test
	public void testGetProviderList3() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		QualityStarRating qualityRating = new QualityStarRating();

		qualityRating.setDescription("Not Rated");
		qualityRating.setRatingId(0);

		providerSearchBo.setQualityRating(qualityRating);

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertTrue(providerList.get(1).getRating().getDescription()
				.equals("Not Rated"));

	}

	@Test
	public void testGetProviderList4() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		providerSearchBo.setCounty("DESOTO");
		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertEquals("DESOTO", providerList.get(0).getAddress().getCounty());

	}

	@Test
	public void testGetProviderList5() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("Irma");

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertEquals(10, providerList.size());

	}

	@Test
	public void testGetProviderList6() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("A Child's View");

		providerSearchBo.setCounty("DESOTO");

		List<Provider> providerList = providerController
				.getProviderList(providerSearchBo);

		assertEquals("OLIVE BRANCH", providerList.get(0).getAddress().getCity());

	}

	@Test
	public void testGetProviderList7() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("Alma Bernal");

		QualityStarRating qualityRating = new QualityStarRating();

		qualityRating.setDescription("Not Rated");
		qualityRating.setRatingId(0);

		providerSearchBo.setQualityRating(qualityRating);

		try {

			List<Provider> providerList = providerController
					.getProviderList(providerSearchBo);
			if (providerList.size() >= 1) {

				assertEquals("LAUDERDALE", providerList.get(0).getAddress()
						.getCounty());
			} else {
				assertNull(providerList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetProviderList8() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("Angelica Garza");
		providerSearchBo.setCity("JACKSON");
		try {
			List<Provider> providerList = providerController
					.getProviderList(providerSearchBo);
			if (providerList.size() >= 1) {
				assertEquals("Angelica Garza", providerList.get(0).getName());
			} else {
				assertNull(providerList);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetProviderList9() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("Ana Maria Salomon");

		ProviderType providerType = new ProviderType();

		providerType.setDescription("Group Home");
		providerType.setTypeId(new Long(3));

		providerSearchBo.setProviderType(providerType);

		try {

			List<Provider> providerList = providerController
					.getProviderList(providerSearchBo);
			if (providerList.size() >= 1) {
				assertEquals(new Long(26), providerList.get(0).getCapacity());
			} else {
				assertNull(providerList);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetProviderList10() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("Angelica Garza");

		ProviderType providerType = new ProviderType();

		providerType.setDescription("Relative Out-of-Home");
		providerType.setTypeId(new Long(8));

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setCity("JACKSON");

		try {

			List<Provider> providerList = providerController
					.getProviderList(providerSearchBo);
			if (providerList.size() >= 1) {
				assertEquals("Relative Out-of-Home", providerList.get(0)
						.getProviderType().getDescription());
			} else {
				assertNull(providerList);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetProviderList11() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("Angelia White");

		ProviderType providerType = new ProviderType();

		providerType.setDescription("Non-Relative Out-Of-Home");
		providerType.setTypeId(new Long(8));

		providerSearchBo.setProviderType(providerType);

		QualityStarRating qualityRating = new QualityStarRating();

		qualityRating.setDescription("Not Rated");
		qualityRating.setRatingId(2);

		providerSearchBo.setQualityRating(qualityRating);

		try {

			List<Provider> providerList = providerController
					.getProviderList(providerSearchBo);
			if (providerList.size() >= 1) {
				assertTrue(providerList.get(0).getRating().getDescription()
						.equals("Not Rated"));
			} else {
				assertNotNull(providerList);
			}
		} catch (Exception e)

		{
			e.printStackTrace();
		}

	}

	@Test
	public void testGetProviderList12() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo
				.setProviderName("A Step Above Preparatory Academy Inc.");

		ProviderType providerType = new ProviderType();

		providerType.setDescription("Center");
		providerType.setTypeId(new Long(4));

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setCounty("FORREST");

		try {

			List<Provider> providerList = providerController
					.getProviderList(providerSearchBo);

			if (providerList.size() >= 1) {
				assertEquals("FORREST", providerList.get(0).getAddress()
						.getCounty());
			} else {
				assertNotNull(providerList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetProviderList13() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo
				.setProviderName("Boone Elementary After School Program");

		ProviderType providerType = new ProviderType();

		providerType.setDescription("Center");
		providerType.setTypeId(new Long(4));

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setCounty("DE KALB");

		QualityStarRating qualityRating = new QualityStarRating();

		qualityRating.setDescription("QuallityRatingDesc123");
		qualityRating.setRatingId(5);

		providerSearchBo.setQualityRating(qualityRating);

		try {
			List<Provider> providerList = providerController
					.getProviderList(providerSearchBo);
			if (providerList.size() >= 1) {
				assertEquals(
						"Boone Elementary After School Program",
						providerList
								.get(0)
								.getName()
								.equals("Boone Elementary After School Program"));
			}

			else {
				assertNotNull(providerList);

			}

		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testGetProviderList14() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();
		providerSearchBo.setProviderName("Abigail Burross");

		ProviderType providerType = new ProviderType();

		providerType.setDescription("Non-Relative Out-Of-Home");
		providerType.setTypeId(new Long(7));

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setCounty("DESOTO");

		providerSearchBo.setCity("WALLS");

		try {

			List<Provider> providerList = providerController
					.getProviderList(providerSearchBo);
			if (providerList.size() >= 1) {
				assertEquals("WALLS", providerList.get(0).getAddress()
						.getCity());
			} else {
				assertNotNull(providerList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetProviderList15() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		ProviderType providerType = new ProviderType();

		providerType.setDescription("Group Home");
		providerType.setTypeId(new Long(3));

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setCounty("LINCOLN");

		providerSearchBo.setCity("BROOKHAVEN");
		QualityStarRating qualityRating = new QualityStarRating();

		qualityRating.setDescription("QuallityRatingDesc");
		qualityRating.setRatingId(3);

		providerSearchBo.setQualityRating(qualityRating);
		try {
			List<Provider> providerList = providerController
					.getProviderList(providerSearchBo);
			if (providerList.size() >= 1) {
				assertEquals(3, providerList.get(0).getRating().getRatingId());
			} else {
				assertNotNull(providerList);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetProviderList16() throws Exception {

		ProviderSearchBO providerSearchBo = new ProviderSearchBO();

		ProviderType providerType = new ProviderType();

		providerType.setDescription("Slot Contractor");
		providerType.setTypeId(new Long(2));

		providerSearchBo.setProviderType(providerType);

		providerSearchBo.setCounty("LEE");

		providerSearchBo.setCity("TUPELO");

		try {

			List<Provider> providerList = providerController
					.getProviderList(providerSearchBo);

			if (providerList.size() >= 1) {
				assertEquals("Slot Contractor", providerList.get(0)
						.getProviderType().getDescription());
			} else {
				assertNotNull(providerList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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