package com.Spring.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.Spring.Entity.Advertises;
import com.Spring.Json.Advertise;

public class AdvertisementUtils {
	public static List<Advertise> converAdvertiseEntityListToAdvertiseList(List<Advertises> advertiseEntityList) {
		List<Advertise> advertiseList = new ArrayList<Advertise>();
		Consumer<Advertises> consumer = (Advertises advertiseEntity) -> advertiseList
				.add(convertAdvertiseEntityToAdvertise(advertiseEntity));
		advertiseEntityList.stream().forEach(consumer);
		return advertiseList;
	}

	public static Advertise convertAdvertiseEntityToAdvertise(Advertises advertise) {
		return new Advertise(advertise.getAid(), advertise.getTitle(), advertise.getCategory(), advertise.getDesc());
	}

	public static Advertises convertAdvertiseToAdvertiseEntity(Advertise advertise) {
		return new Advertises(advertise.getTitle(), advertise.getCategory(), advertise.getDesc());
	}
}