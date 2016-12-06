package com.humanServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.humanServices.entity.Address;
import com.humanServices.entity.Provider;
import com.humanServices.entity.ProviderType;
import com.humanServices.entity.QualityStarRating;
import com.humanServices.service.ProviderService;
/**
 * Controller which processes all the HTTP request from the angularJS controller.
 * 
 * @author balachandra
 *
 */
@Controller
public class ProviderController {

	@Autowired
	private ProviderService providerService;

	@RequestMapping(value = "/providers", method = RequestMethod.GET)
	public ModelAndView listProviders() {
		return new ModelAndView("providerSearch");
	}

	@RequestMapping(value = "/searchProvider", method = RequestMethod.POST)
	public @ResponseBody List<Provider> getProviderList(
			@RequestBody ProviderSearchBO searchBo) throws Exception {
		return providerService.searchProviders(searchBo);
	}

	@RequestMapping("/loadProviderType")
	public @ResponseBody List<ProviderType> getProviderTypeList()
			throws Exception {
		return providerService.getProviderTypes();
	}

	@RequestMapping("/loadCity")
	public @ResponseBody List<String> getCityList(@RequestBody String county) throws Exception {
		return providerService.getCities(county);
	}

	@RequestMapping("/loadCounty")
	public @ResponseBody List<String> getCountyList() throws Exception {
		return providerService.getCounties();
	}

	@RequestMapping("/loadRatings")
	public @ResponseBody List<QualityStarRating> getRatingList()
			throws Exception {
		return providerService.getRatings();
	}

}
