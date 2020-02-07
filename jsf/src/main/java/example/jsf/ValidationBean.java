package example.jsf;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ValidationBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1266554561908530156L;
	private Date tarih;

	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
		

}