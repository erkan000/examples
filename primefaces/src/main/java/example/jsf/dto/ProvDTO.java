package example.jsf.dto;

import java.io.Serializable;

public class ProvDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -405306754998917083L;
	private int sayi;
	private String zaman;
	
	public int getSayi() {
		return sayi;
	}
	public void setSayi(int sayi) {
		this.sayi = sayi;
	}
	public String getZaman() {
		return zaman;
	}
	public void setZaman(String zaman) {
		this.zaman = zaman;
	}	
}
