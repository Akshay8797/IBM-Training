package com.Spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Spring.Entity.Advertises;
import com.Spring.Entity.Users;
import com.Spring.Json.Advertise;
import com.Spring.Repository.AdvertisementRepo;
import com.Spring.Utils.AdvertisementUtils;
import com.Spring.Utils.UserUtils;

public class AdvertiseServiceImpl implements AdvertiseService {
	@Autowired
	private AdvertisementRepo advRepository;

	@Override
	public List<Advertise> getAllAds() {
		List<Advertises> advertiseEntityList = advRepository.findAll();
		return AdvertisementUtils.converAdvertiseEntityListToAdvertiseList(advertiseEntityList);
	}

	@Override
	public Advertise getAdById(String aid) {
		Advertises advEntity = advRepository.findById(Long.valueOf(aid)).get();
		return AdvertisementUtils.convertAdvertiseEntityToAdvertise(advEntity);
	}

	@Override
	public Advertise save(Advertise advertise) {
		Advertises advEntity = advRepository.save(AdvertisementUtils.convertAdvertiseToAdvertiseEntity(advertise));
		return AdvertisementUtils.convertAdvertiseEntityToAdvertise(advEntity);
	}

	@Override
	public Advertise update(Advertise advertise, String aid) {
		Advertises advEntity = advRepository.findById(Long.valueOf(aid)).get();
		if (advEntity != null) {
			advEntity.setTitle(advertise.getTitle());
			advEntity.setCategory(advertise.getCategory());
			advEntity.setDesc(advertise.getDesc());
			return AdvertisementUtils.convertAdvertiseEntityToAdvertise(advEntity);
		}
		return null;
	}

	@Override
	public boolean delete(String aid) {
		if (advRepository.existsById(Long.valueOf(aid))) {
			advRepository.deleteById(Long.valueOf(aid));
			return true;
		}
		return false;
	}

	@Override
	public Advertise createNewAdvertise(Advertise advertise) {
		Advertises advEntity = AdvertisementUtils.convertAdvertiseToAdvertiseEntity(advertise);
		advEntity = advRepository.save(advEntity);
		Advertise advReturn = AdvertisementUtils.convertAdvertiseEntityToAdvertise(advEntity);
		return advReturn;
	}
}