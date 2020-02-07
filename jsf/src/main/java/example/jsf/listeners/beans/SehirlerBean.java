package example.jsf.listeners.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@ViewScoped
public class SehirlerBean implements Serializable{

	private static final long serialVersionUID = -3789498230918369184L;
  
	private String plakaKodu = "31";
	private Map<String, String> sehirler;
	
	@PostConstruct
    private void init(){
    	sehirler = new HashMap<String, String>();
    	sehirler.put("Ankara", "06");
    	sehirler.put("Istanbul", "34");
    	sehirler.put("Izmir", "31");
    	sehirler.put("Hatay", "35");
    }

	
	public void sehirDegisti(ValueChangeEvent e){
		plakaKodu = e.getNewValue().toString();
	}
	
	
	public void sehirDegistiAjax(AjaxBehaviorEvent e){
		plakaKodu = ((UIInput)e.getComponent()).getValue().toString();
	}
	
	
	public String getPlakaKodu() {
		return plakaKodu;
	}
	public void setPlakaKodu(String plakaKodu) {
		this.plakaKodu = plakaKodu;
	}
	public Map<String, String> getSehirler() {
		return sehirler;
	}
	public void setSehirler(Map<String, String> sehirler) {
		this.sehirler = sehirler;
	}	
	
	
}
