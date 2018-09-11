package it.polito.tdp.poweroutages.model;

import java.awt.font.GraphicAttribute;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.print.attribute.standard.NumberOfDocuments;
import javax.swing.text.AttributeSet.CharacterAttribute;
import javax.tools.Diagnostic;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.ListenableDirectedGraph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class Model {

	PowerOutageDAO dao;
	
	private NercIdMap nercIdMap;
	private AreaIdMap areaIdMap;
	private ResposibleIdMap resposibleIdMap;
	private EventTypeIdMap eventTypeIdMap;
	private POIdMap poIdMap;
	
	private List<Nerc> nercs;
	private List<Area> areas;
	private List<Responsible> responsibles;
	private List<EventType> eventTypes;
	private List<PowerOutages> powerOutages;
	
	//grafo diretto e peseato
	//TODO cambiarlo in base alla traccia dell'esame
	Graph<Responsible, DefaultWeightedEdge> graph;
	
	
	public Model() {
		dao = new PowerOutageDAO();
		
		this.nercIdMap = new NercIdMap();
		this.areaIdMap = new AreaIdMap();
		this.resposibleIdMap = new ResposibleIdMap();
		this.eventTypeIdMap = new EventTypeIdMap();
		this.poIdMap = new POIdMap();
		
		this.nercs = new ArrayList<>(dao.getNercList(nercIdMap));
		System.out.println("lista NERC: " + nercs.size());
		this.areas = dao.getAreaList(areaIdMap);
		System.out.println("lista stati: " + areas.size());
		this.responsibles = dao.getResponibleList(resposibleIdMap);
		System.out.println("lista aziende responsabili: " + responsibles.size());
		this.eventTypes = dao.getEventTypeList(eventTypeIdMap);
		System.out.println("Lista di tipologie di disservizi: " + eventTypes.size());
		this.powerOutages = dao.getpowerOutagesList(poIdMap, eventTypeIdMap, nercIdMap, areaIdMap, resposibleIdMap);
		System.out.println("lista di blackout: " + powerOutages.size());
		
		//TODO cambiarlo in base alla traccia dell'esame
		this.graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		

	}
	
	public void crerateGraph() {
		
		//TODO cambiare la lista degli vertici in base alla richiesta;
		Graphs.addAllVertices(this.graph, responsibles);getClass();
		System.out.println("numero di vertici aggiunti: " + this.graph.vertexSet().size());
		
		
		
		
		
		
	}
	

}
