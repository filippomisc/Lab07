package it.polito.tdp.poweroutages.model;

import java.util.HashMap;
import java.util.Map;

public class ResposibleIdMap {
private Map<Integer, Responsible> idMap;
	
	public ResposibleIdMap() {
		idMap = new HashMap<>();
	}
	
	public Responsible get(int id) {
		return idMap.get(id);
	}
	
	public Responsible get(Responsible responsible) {
		Responsible old = idMap.get(responsible.getId());
		if (old == null) {
			idMap.put(responsible.getId(), responsible);
			return responsible;
		}
		return old;
	}
	
	public void put(Responsible responsible, int id) {
		idMap.put(id, responsible);
	}

}
