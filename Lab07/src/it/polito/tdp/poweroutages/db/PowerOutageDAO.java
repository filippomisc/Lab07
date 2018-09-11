package it.polito.tdp.poweroutages.db;

import java.lang.reflect.AnnotatedArrayType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.model.AnnoEUtentiCoinvolti;
import it.polito.tdp.poweroutages.model.Area;
import it.polito.tdp.poweroutages.model.AreaIdMap;
import it.polito.tdp.poweroutages.model.EventType;
import it.polito.tdp.poweroutages.model.EventTypeIdMap;
import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.NercIdMap;
import it.polito.tdp.poweroutages.model.POIdMap;
import it.polito.tdp.poweroutages.model.PowerOutages;
import it.polito.tdp.poweroutages.model.Responsible;
import it.polito.tdp.poweroutages.model.ResposibleIdMap;

public class PowerOutageDAO {

	public List<Nerc> getNercList(NercIdMap nercIdMap) {

		String sql = "SELECT * FROM nerc";
		
		List<Nerc> nercList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(nercIdMap.get(n));
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}
	
	
	
	public List<Area> getAreaList(AreaIdMap areaIdMap) {

		String sql = "SELECT * FROM area";
		
		List<Area> areaList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Area a = new Area(res.getInt("id"), res.getString("value"));
				areaList.add(areaIdMap.get(a));
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return areaList;
	}
	
	
	
	public List<EventType> getEventTypeList(EventTypeIdMap eventTypeIdMap) {

		String sql = "SELECT * FROM eventtype";
		
		List<EventType> eventTypeList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				EventType eventType = new EventType(res.getInt("id"), res.getString("value"));
				eventTypeList.add(eventTypeIdMap.get(eventType));
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return eventTypeList;
	}
	
	
	public List<Responsible> getResponibleList(ResposibleIdMap resposibleIdMap) {

		String sql = "SELECT * FROM responsible";
		
		List<Responsible> responsibleList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Responsible r = new Responsible(res.getInt("id"), res.getString("value"));
				responsibleList.add(resposibleIdMap.get(r));
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return responsibleList;
	}
	
	
	
	public List<PowerOutages> getpowerOutagesList(POIdMap poIdMap, EventTypeIdMap eventTypeIdMap, NercIdMap nercIdMap, AreaIdMap areaIdMap, ResposibleIdMap resposibleIdMap) {

		String sql = "SELECT * FROM poweroutages";
		
		List<PowerOutages> powerOutagesList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				EventType eventType = eventTypeIdMap.get(res.getInt("event_type_id"));
				Area area = areaIdMap.get(res.getInt("area_id"));
				Nerc nerc = nercIdMap.get(res.getInt("nerc_id"));
				Responsible responsible = resposibleIdMap.get(res.getInt("responsible_id"));
				
				
				PowerOutages powerOutages = new PowerOutages(res.getInt("id"), eventType, area, nerc, responsible, res.getInt("customers_affected"), res.getTimestamp("date_event_began").toLocalDateTime(), res.getTimestamp("date_event_finished").toLocalDateTime());
				
				
				powerOutagesList.add(poIdMap.get(powerOutages));
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return powerOutagesList;
	}

	
	public List<AnnoEUtentiCoinvolti> getAnni(){
String sql = "select distinct year(p.date_event_began) as anno, sum(customers_affected) as persone_coinvolte\n" + 
		"from poweroutages as p\n" + 
		"group by anno\n" + 
		"order by anno asc\n";
		
		List<AnnoEUtentiCoinvolti> anniEcc = new ArrayList<>();

		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				AnnoEUtentiCoinvolti aEUtentiCoinvolti = new AnnoEUtentiCoinvolti(Year.of(res.getInt("anno")), res.getInt("persone_coinvolte"));
				
				anniEcc.add(aEUtentiCoinvolti);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return anniEcc;
		
	}
}
