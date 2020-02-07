package example.jsf.listeners.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean
public class ListenerBean {

	private String id;

	//  ajax kullaniyorsak baska. focus-deger degisme gibi icin baska, butona basma gibi seyler icin baska event aliyor
	public void listenerMetodu(ActionEvent e){
		System.out.println("listener");
		id = e.getComponent().getId();
	}
	
	
	//  action metodu	
	public String giris(){
		System.out.println("giris");
		return "sonuc";
	}
	
	public String getId() {
		System.out.println("getter");
		return id;
	}
	public void setId(String id) {
		System.out.println("setter");
		this.id = id;
	}
	
	
}
