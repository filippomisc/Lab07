package it.polito.tdp.poweroutages.model;

import java.util.HashMap;
import java.util.Map;

public class AreaIdMap {

private Map<Integer, Area> idMap;
	
	public AreaIdMap() {
		idMap = new HashMap<>();
	}
	
	public Area get(int id) {
		return idMap.get(id);
	}
	
	public Area get(Area area) {
		Area old = idMap.get(area.getId());
		if (old == null) {
			idMap.put(area.getId(), area);
			return area;
		}
		return old;
	}
	
	public void put(Area area, int id) {
		idMap.put(id, area);
	}
}
