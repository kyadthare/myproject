package com.humanServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.humanServices.entities.Address;
import com.humanServices.entities.Provider;
import com.humanServices.entities.ProviderType;
import com.humanServices.entities.QualityStarRating;
import com.humanServices.searchBo.ProviderSearchBo;
import com.humanServices.service.ProviderService;

@Controller
public class ProviderController {

	@Autowired
	private ProviderService providerService;

	@RequestMapping(value = "/providers", method = RequestMethod.GET)
	public ModelAndView listProviders() {
		return new ModelAndView("providerSearchPage");
	}

	@RequestMapping(value = "/searchProvider", method = RequestMethod.POST)
	public @ResponseBody List<Provider> getProviderList(
			@RequestBody ProviderSearchBo searchBo) throws Exception {
		return providerService.searchProviders(searchBo);
	}

	@RequestMapping("/loadProviderType")
	public @ResponseBody List<ProviderType> getProviderTypeList()
			throws Exception {
		return providerService.searchProviderTypes();
	}

	@RequestMapping("/loadCity")
	public @ResponseBody List<Address> getCityList() throws Exception {
		return providerService.listCity();
	}

	@RequestMapping("/loadCounty")
	public @ResponseBody List<Address> getCountyList() throws Exception {
		return providerService.listCounty();
	}

	@RequestMapping("/loadRatings")
	public @ResponseBody List<QualityStarRating> getRatingList()
			throws Exception {
		return providerService.listRatings();
	}

}
