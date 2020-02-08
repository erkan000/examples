package example.jsf.listeners;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import example.jsf.listeners.CommonBean;

public class CustomValueChangeListener implements ValueChangeListener{

	@Override
	public void processValueChange(ValueChangeEvent e) throws AbortProcessingException {		
		FacesContext context = FacesContext.getCurrentInstance();
		
		CommonBean bean = (CommonBean)context.getViewRoot().getViewMap().get("commonBean");
		//CommonBean bean = (CommonBean)context.getExternalContext().getSessionMap().get("commonBean");
		
		bean.setCode2(e.getNewValue().toString());		
	}

	
}
