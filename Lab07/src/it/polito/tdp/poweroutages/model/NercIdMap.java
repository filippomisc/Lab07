package it.polito.tdp.poweroutages.model;

import java.util.HashMap;
import java.util.Map;

public class NercIdMap {
private Map<Integer, Nerc> idMap;
	
	public NercIdMap() {
		idMap = new HashMap<>();
	}
	
	public Nerc get(int id) {
		return idMap.get(id);
	}
	
	public Nerc get(Nerc nerc) {
		Nerc old = idMap.get(nerc.getId());
		if (old == null) {
			idMap.put(nerc.getId(), nerc);
			return nerc;
		}
		return old;
	}
	
	public void put(Nerc nerc, int id) {
		idMap.put(id, nerc);
	}
}
