package it.polito.tdp.poweroutages.model;

public class Area {
	
	private int id;
	private String state;
	
	
	public Area(int id, String state) {
		super();
		this.id = id;
		this.state = state;
	}


	public int getId() {
		return id;
	}


	public String getState() {
		return state;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(state);
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
		Area other = (Area) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
