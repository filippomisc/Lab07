package it.polito.tdp.poweroutages.model;

import java.time.Year;
import java.time.YearMonth;

public class AnnoEUtentiCoinvolti {
	
	private Year anno;
	private int utentiCoinvolti;
	
	
	public AnnoEUtentiCoinvolti(Year anno, int utentiCoinvolti) {
		super();
		this.anno = anno;
		this.utentiCoinvolti = utentiCoinvolti;
	}


	public Year getAnno() {
		return anno;
	}


	public int getUtentiCoinvolti() {
		return utentiCoinvolti;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(anno);
		builder.append(" ");
		builder.append(utentiCoinvolti);
		builder.append("\n");
		return builder.toString();
	}
	
	

}
