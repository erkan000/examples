package example.jsf.mb;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import tr.gov.sgk.gss.dto.yonetim.ProvSaatDTO;
import tr.gov.sgk.gss.ejb.istatistik.IstatistikEJB;

/**
 * @date 21.05.2014
 * @author esaricoban
 * 
 */

@ViewScoped
@ManagedBean
public class Tmp implements Serializable {

	private static final long serialVersionUID = -1570638727671164738L;
	
	private LineChartModel provizyonModel;	
	Stack<ProvSaatDTO> stackProvizyon = new Stack<ProvSaatDTO>();
	ChartSeries listeProvizyon = new ChartSeries();
	private String sonAn = "";	 
	byte grafikGecmis = 20;
	SimpleDateFormat saatDakikaDF = new SimpleDateFormat("HH:mm");
	static int yil;
	@EJB
	IstatistikEJB istatistikEJB;
	
	@PostConstruct
	public void init() {
		createProvizyonModel();
	}
	private void createLineChartModel(){
		
		provizyonModel = new LineChartModel();
		provizyonModel.setTitle("Anlık Provizyon/Hizmet Kayıt/Reçete Sayıları");
		provizyonModel.setLegendPosition("s");
		provizyonModel.setAnimate(true);
		provizyonModel.setShowPointLabels(true);
		provizyonModel.getAxes().put(AxisType.X, new CategoryAxis("Son Güncelleme Zamanı = " + sonAn));
		Axis yAxis = provizyonModel.getAxis(AxisType.Y);
		yAxis = provizyonModel.getAxis(AxisType.Y);
		yAxis.setLabel("Sayı");
		yAxis.setMin(0);
		
	}
	
	private void createProvizyonModel() {
		try {		      
		      Calendar cal = Calendar.getInstance();          
		      String saatDakika = saatDakikaDF.format(cal.getTime());
		      yil = cal.get(Calendar.YEAR);
		             
		      createLineChartModel();
		      
		      Date d = saatDakikaDF.parse(saatDakika);
		      cal.setTime(d);
		      cal.add(Calendar.MINUTE, -grafikGecmis);
		      
		      for (int z = 0; z < grafikGecmis - 1 ; z++) {  
		             cal.add(Calendar.MINUTE, 1);
		             String eskiZaman = saatDakikaDF.format(cal.getTime());

		             ProvSaatDTO tmp = new ProvSaatDTO();

		             int saat = Integer.valueOf(eskiZaman.substring(0, 2));
		             int dakika = Integer.valueOf(eskiZaman.substring(3, 5));
		             
		             tmp.setSayi(istatistikEJB.getProvizyonIstatistik(saat, dakika));		             
		             tmp.setZaman(eskiZaman);
		             stackProvizyon.add(0, tmp);
		             listeProvizyon.set(String.valueOf(z), z);    
		             
		              
		      }
		      
		      listeProvizyon.setLabel("Provizyon Sayısı");

		      
		      provizyonModel.addSeries(listeProvizyon);      

		      
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public LineChartModel getProvizyonModel(){
		
		ProvSaatDTO veri = new ProvSaatDTO();


		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE , -1);
		String saatDakika = saatDakikaDF.format(cal.getTime());
		int saat = cal.get(Calendar.HOUR_OF_DAY);
		int dakika = cal.get(Calendar.MINUTE);

		veri.setZaman(saatDakika); 

		if(!sonAn.equals(saatDakika)){
			sonAn = saatDakika; 
			createLineChartModel();
			Map<Object, Number> data = new TreeMap<Object, Number>();

			int provSayisi = istatistikEJB.getProvizyonIstatistik(saat, dakika);
			veri.setSayi(provSayisi);
			stackProvizyon.pop();
			stackProvizyon.add(0, veri);
			
			data.clear();
			listeProvizyon.setData(data);  

			for (Object object : stackProvizyon) {
				ProvSaatDTO provSaatDTO = (ProvSaatDTO)object;                 
				listeProvizyon.set(provSaatDTO.getZaman(), provSaatDTO.getSayi());
			}
			
		}
		//provizyonModel = new LineChartModel();
		provizyonModel.addSeries(listeProvizyon);

		return provizyonModel;

	}

	public void setProvizyonModel(LineChartModel provizyonModel) {
		this.provizyonModel = provizyonModel;
	}

}
