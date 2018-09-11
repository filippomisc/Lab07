package it.polito.tdp.poweroutages.model;

import java.util.HashMap;
import java.util.Map;

public class EventTypeIdMap {

private Map<Integer, EventType> idMap;
	
	public EventTypeIdMap() {
		idMap = new HashMap<>();
	}
	
	public EventType get(int id) {
		return idMap.get(id);
	}
	
	public EventType get(EventType eventType) {
		EventType old = idMap.get(eventType.getId());
		if (old == null) {
			idMap.put(eventType.getId(), eventType);
			return eventType;
		}
		return old;
	}
	
	public void put(EventType eventType, int id) {
		idMap.put(id, eventType);
	}
}
