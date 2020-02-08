package example.jsf.listeners;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named
@RequestScoped
public class CommonBean implements Serializable{

	private static final long serialVersionUID = -3789498230918369184L;
  
	private String code1 = "31";
	private String code2 = "06";
	private Map<String, String> cities;
	private String id;
	
	@PostConstruct
    private void init(){
    	cities = new HashMap<String, String>();
    	cities.put("Ankara", "06");
    	cities.put("Istanbul", "34");
    	cities.put("Izmir", "35");
    	cities.put("Isparta", "32");
    }
	
	public void listenerMetodu(ActionEvent e){
		System.out.println("Listener Component id:" + e.getComponent().getId());
		setId(e.getComponent().getId());
	}
	
	public void changeCity(ValueChangeEvent e){
		setCode1(e.getNewValue().toString());
	}	
	
	public Map<String, String> getCities() {
		return cities;
	}
	public void setCities(Map<String, String> cities) {
		this.cities = cities;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}
	
}
