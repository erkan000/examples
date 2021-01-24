package application;

import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Controller  implements Initializable {

	@FXML
	private TextField txtAd;
	@FXML
	private TextField txtSifre;

	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	private void kontrolEt(){
		if(txtAd.getText()=="admin" && txtSifre.getText()=="1234")
			JOptionPane.showMessageDialog(null, "User valid", "info", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "User not valid", "info", JOptionPane.INFORMATION_MESSAGE);
	}
}
