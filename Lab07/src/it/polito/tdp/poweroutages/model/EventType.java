package it.polito.tdp.poweroutages.model;

public class EventType {
	
	private int id;
	private String name;
	
	
	public EventType(int id, String value) {
		this.id = id;
		this.name = value;
	}


	public int getId() {
		return id;
	}


	public String getValue() {
		return name;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		return builder.toString();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventType other = (EventType) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
