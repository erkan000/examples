package example.jsf.mb;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Date;
import java.util.Deque;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import example.jsf.dto.ProvDTO;

@ManagedBean
@ViewScoped
public class ChartBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4983748534846578934L;
	private LineChartModel provModel;	
	private Deque<ProvDTO> stackProv = new ArrayDeque<>();
	private ChartSeries listeProv = new ChartSeries();
	private String sonAn = "";	 
	private byte grafikGecmis = 20;
	private SimpleDateFormat saatDakikaDF = new SimpleDateFormat("HH:mm");
	
	@PostConstruct
	public void init() {
		createProvModel();
	}
	private void createLineChartModel(){
		provModel = new LineChartModel();
		provModel.setTitle("LineChart Demo");
		provModel.setLegendPosition("s");
		provModel.setAnimate(true);
		provModel.setShowPointLabels(true);
		provModel.getAxes().put(AxisType.X, new CategoryAxis("Updated on = " + sonAn));
		Axis yAxis = provModel.getAxis(AxisType.Y);
		yAxis.setLabel("Count");
		yAxis.setMin(0);		
	}
	
	private void createProvModel() {
		try {		      
		      Calendar cal = Calendar.getInstance();          
		      String saatDakika = saatDakikaDF.format(cal.getTime());
		             
		      createLineChartModel();
		      
		      Date d = saatDakikaDF.parse(saatDakika);
		      cal.setTime(d);
		      cal.add(Calendar.MINUTE, -grafikGecmis);
		      
		      for (int z = 0; z < grafikGecmis - 1 ; z++) {  
		             cal.add(Calendar.MINUTE, 1);
		             String eskiZaman = saatDakikaDF.format(cal.getTime());

		             ProvDTO tmp = new ProvDTO();
		             
		             tmp.setSayi(getRamdomInt());		             
		             tmp.setZaman(eskiZaman);
		             stackProv.addLast(tmp);
		             listeProv.set(String.valueOf(z), z);    
		      }
		      
		      listeProv.setLabel("Prov Sayısı");
		      provModel.addSeries(listeProv);      
		      
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public LineChartModel getProvModel(){
//		4 tekrar	
		ProvDTO veri = new ProvDTO();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE , -1);
		String saatDakika = saatDakikaDF.format(cal.getTime());

		veri.setZaman(saatDakika); 

		if(!sonAn.equals(saatDakika)){
			sonAn = saatDakika; 
			createLineChartModel();
			Map<Object, Number> data = new TreeMap<>();

			veri.setSayi(getRamdomInt());
			stackProv.pop();
			stackProv.addLast(veri);
			
			data.clear();
			listeProv.setData(data);  

			for (Object object : stackProv) {
				ProvDTO provSaatDTO = (ProvDTO)object;                 
				listeProv.set(provSaatDTO.getZaman(), provSaatDTO.getSayi());
			}
			provModel.addSeries(listeProv);
		}
		return provModel;
	}
	
	private int getRamdomInt() {
		return new Random().nextInt(100);
	}

	public void setProvModel(LineChartModel provModel) {
		this.provModel = provModel;
	}

}