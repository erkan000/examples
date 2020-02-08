package example.jsf.listeners;

import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;


public class CustomActionListener implements ActionListener {

	@Override
	public void processAction(ActionEvent e) {
		System.out.println("CustomActionListener Component ID:" + e.getComponent().getId());		
	}

}
