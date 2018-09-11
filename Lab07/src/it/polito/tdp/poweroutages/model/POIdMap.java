package it.polito.tdp.poweroutages.model;

import java.util.HashMap;
import java.util.Map;

public class POIdMap {
	

	private Map<Integer, PowerOutages> idMap;
	
	public POIdMap() {
		idMap = new HashMap<>();
	}
	
	public PowerOutages get(int id) {
		return idMap.get(id);
	}
	
	public PowerOutages get(PowerOutages powerOutages) {
		PowerOutages old = idMap.get(powerOutages.getId());
		if (old == null) {
			idMap.put(powerOutages.getId(), powerOutages);
			return powerOutages;
		}
		return old;
	}
	
	public void put(PowerOutages powerOutages, int id) {
		idMap.put(id, powerOutages);
	}
}



