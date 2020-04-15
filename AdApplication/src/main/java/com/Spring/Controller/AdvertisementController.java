package com.Spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Json.Advertise;
import com.Spring.Service.AdvertiseService;
import com.Spring.Service.UserService;

@RestController
@RequestMapping("/Ad")
public class AdvertisementController {
	@Autowired
	private AdvertiseService advService;

	@PostMapping(value = "/advertise", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Advertise createNewAdvertise(@RequestBody Advertise advertise,
			@RequestHeader(value = "auth-token") String authToken) {
		if (UserService.isValid(authToken)) {
			return advService.createNewAdvertise(advertise);
		} else
			return null;
	}

	@GetMapping("/advertise")
	public List<Advertise> getAllAdvertises() {
		return advService.getAllAds();
	}

	@GetMapping("/advertise/{id}")
	public Advertise getAdvertisesById(@PathVariable(value = "aid") String Aid) {
		return advService.getAdById(Aid);
	}

	@PutMapping(value = "/advertise/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Advertise updateAdvertise(@RequestBody Advertise advertise,
			@PathVariable(value = "aid") String Aid) {
		return advService.update(advertise, Aid);
	}

	@DeleteMapping(value = "/advertise/{id}")
	public boolean deleteAd(@PathVariable(value = "id") String Aid) {
		return advService.delete(Aid);
	}
}