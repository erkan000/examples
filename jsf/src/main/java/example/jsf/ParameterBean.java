package example.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class ParameterBean implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 7781585654619412685L;

	@PostConstruct
	public void init() {

	}
	
public String gonder(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		String adi = request.getParameter("isim");
		System.out.println("Parameter is : " + adi);
		
		HttpSession session = request.getSession();
		session.setAttribute("kullanici", "");
		
		return null;
	}

public void listenerMetodu(ActionEvent e){
	String adi = (String)e.getComponent().getAttributes().get("isim");
	System.out.println("ADI: " + adi);
}
		

}