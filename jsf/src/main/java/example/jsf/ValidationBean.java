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
	
	private Date utilDate;

	public Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(Date utilDate) {
		this.utilDate = utilDate;
	}
	
}