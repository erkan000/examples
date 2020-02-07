package example.jsf.listeners;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import example.jsf.listeners.beans.SehirlerBean;




public class SehirlerListener implements ValueChangeListener{

	@Override
	public void processValueChange(ValueChangeEvent e) throws AbortProcessingException {		
		
		FacesContext context = FacesContext.getCurrentInstance();
		SehirlerBean bean = (SehirlerBean)context.getViewRoot().getViewMap().get("sehirlerBean");
		//  session a erismek icin
		//SehirlerBean bean = (SehirlerBean)context.getExternalContext().getSessionMap().get("sehirlerBean");
		
		bean.setPlakaKodu( e.getNewValue().toString());		
	}

	
}
