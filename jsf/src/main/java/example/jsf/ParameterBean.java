package example.jsf;

import java.io.Serializable;
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
	private String param1;

	// Getting all variables
	// Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
	
	public void method1(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		String var1 = request.getParameter("var1");
		HttpSession session = request.getSession();
		session.setAttribute("var1Response", var1);
	}

	public void method2(ActionEvent e){
		String var2 = (String)e.getComponent().getAttributes().get("var2");
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("var2Response", var2);
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

}