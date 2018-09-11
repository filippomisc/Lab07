package it.polito.tdp.poweroutages.model;

import java.time.LocalDateTime;


public class PowerOutages {
	
	private int id;
	private EventType eventType;
//	private Tag tag;
	private Area area;
	private Nerc nerc;
	private Responsible responsible;
	private int customersAffected;
	private LocalDateTime eventBegan;
	private LocalDateTime eventFinished;
//	private int demandLoss;
	
	
	public PowerOutages(int id, EventType eventType, Area area, Nerc nerc, Responsible responsible,
			int customersAffected, LocalDateTime eventBegan, LocalDateTime eventFinished) {
		super();
		this.id = id;
		this.eventType = eventType;
		this.area = area;
		this.nerc = nerc;
		this.responsible = responsible;
		this.customersAffected = customersAffected;
		this.eventBegan = eventBegan;
		this.eventFinished = eventFinished;
	}


	public int getId() {
		return id;
	}


	public EventType getEventType() {
		return eventType;
	}


	public Area getArea() {
		return area;
	}


	public Nerc getNerc() {
		return nerc;
	}


	public Responsible getResponsible() {
		return responsible;
	}


	public int getCustomersAffected() {
		return customersAffected;
	}


	public LocalDateTime getEventBegan() {
		return eventBegan;
	}


	public LocalDateTime getEventFinished() {
		return eventFinished;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PowerOutages [id=");
		builder.append(id);
		builder.append(", eventType=");
		builder.append(eventType);
		builder.append(", responsible=");
		builder.append(responsible);
		builder.append(", customersAffected=");
		builder.append(customersAffected);
		builder.append(", eventBegan=");
		builder.append(eventBegan);
		builder.append(", eventFinished=");
		builder.append(eventFinished);
		builder.append("]\n");
		return builder.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerOutages other = (PowerOutages) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	

}
