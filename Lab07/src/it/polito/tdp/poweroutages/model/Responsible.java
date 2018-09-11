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
	public String toString() {
		return id + " " + name;
	}
	
	

}
