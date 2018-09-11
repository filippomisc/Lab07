package it.polito.tdp.poweroutages.db;

import it.polito.tdp.poweroutages.model.AreaIdMap;
import it.polito.tdp.poweroutages.model.EventTypeIdMap;
import it.polito.tdp.poweroutages.model.NercIdMap;
import it.polito.tdp.poweroutages.model.POIdMap;
import it.polito.tdp.poweroutages.model.ResposibleIdMap;

public class TestDAO {

	public static void main(String[] args) {

		PowerOutageDAO dao = new PowerOutageDAO();
		
		NercIdMap nercIdMap = new NercIdMap();
		AreaIdMap areaIdMap = new AreaIdMap();
		ResposibleIdMap resposibleIdMap = new ResposibleIdMap();
		EventTypeIdMap eventTypeIdMap = new EventTypeIdMap();
		POIdMap poIdMap = new POIdMap();
		
		
		
		System.out.println(dao.getNercList(nercIdMap).size());
		System.out.println(dao.getAreaList(areaIdMap).size());
		System.out.println(dao.getResponibleList(resposibleIdMap).size());
		System.out.println(dao.getEventTypeList(eventTypeIdMap).size());
		System.out.println(dao.getpowerOutagesList(poIdMap, eventTypeIdMap, nercIdMap, areaIdMap, resposibleIdMap).size());
		System.out.println();

		System.out.println(poIdMap.get(0).toString());
		System.out.println();
		
		System.out.println();
		System.out.println(dao.getAnni().toString());
		
	}

}
