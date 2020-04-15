package com.Spring.Service;

import java.util.List;
import com.Spring.Json.Advertise;

public interface AdvertiseService {
	public List<Advertise> getAllAds();

	public Advertise getAdById(String aid);

	public Advertise save(Advertise advertise);

	public Advertise update(Advertise advertise, String aid);

	public boolean delete(String aid);

	public Advertise createNewAdvertise(Advertise advertise);
}