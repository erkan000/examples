package example.jsf;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Bean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1292315409067940127L;
	private int aValue = 12;
	
	public void test() {
		System.out.println("Test");
	}

	public int getaValue() {
		return aValue;
	}

	public void setaValue(int aValue) {
		this.aValue = aValue;
	}

}