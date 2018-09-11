package it.polito.tdp.poweroutages.model;

public class Responsible {
	
	private int id;
	private String name;
	
	
	public Responsible(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public String getName() {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsible other = (Responsible) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		return builder.toString();
	}



	
	

}
