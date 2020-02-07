package example.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import example.jsf.pojos.User;

@Named
@RequestScoped
public class AjaxBean implements Serializable{
	
	private static List<User> users;
	private double aNumber;

	@PostConstruct
	public void init() {
		users = new ArrayList<User>();
		users.add(new User("Siyah Beyaz", "Besiktas"));
		users.add(new User("Siyah Beyaz", "PAOK"));
		users.add(new User("Siyah Beyaz", "NewCastle"));
		users.add(new User("Siyah Beyaz", "AydinSpor"));
	}

	public void changeWithAjax(AjaxBehaviorEvent e){
		Integer takimId = Integer.parseInt(((UIInput)e.getComponent()).getValue().toString());
//	    setFutbolcular(ServiceGetters.getFutbolcularByTakimId(takimId));	
	}
	
	private String olay;
	private String deger;
	
	public void onFocus(AjaxBehaviorEvent e){
	    olay = "Focus Event calisti";	
	}
	
	public void onKeyup(AjaxBehaviorEvent e){
	    olay = "Keyup Event Calisti";	
	}
	
	public void rasgeleSayiUret(){		
		aNumber = Math.random() ;		
	}
	public String getOlay() {
		return olay;
	}
	public void setOlay(String olay) {
		this.olay = olay;
	}
	public String getDeger() {
		return deger;
	}
	public void setDeger(String deger) {
		this.deger = deger;
	}
	
	public static List<User> getUsers() {
		return users;
	}

	public static void setUsers(List<User> users) {
		AjaxBean.users = users;
	}

	public double getaNumber() {
		return aNumber;
	}

	public void setaNumber(double aNumber) {
		this.aNumber = aNumber;
	}
	
	
		

}