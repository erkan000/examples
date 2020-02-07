package example.jsf.listeners;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;


public class ButonListener implements ActionListener {

	@Override
	public void processAction(ActionEvent e) throws AbortProcessingException {
		System.out.println("processAction");		
	}
	
	

}
