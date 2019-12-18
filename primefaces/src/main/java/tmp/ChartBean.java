package tmp;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import tr.gov.sgk.dto.ProvSaatDTO;

@ViewScoped
@ManagedBean
public class ChartBean implements Serializable {

	
	private static final long serialVersionUID = -7284582765200382943L;

	private CartesianChartModel categoryModel;

    private LineChartModel linearModel;
    
    LineChartSeries liste = new LineChartSeries();
    LineChartSeries liste2 = new LineChartSeries();
    int i=0;
    String sonAn = "";
	Map<Object, Number> data = new TreeMap<Object, Number>();
	Object[][] veri = new Object[20][2];
	Stack stack = new Stack();
	byte grafikGecmis = 15;

    public ChartBean() {
    	try {
			createLinearModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }

	public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }
	
    public void initChart() {
    	
    }

    public LineChartModel getLinearModel() {
    	ProvSaatDTO veri = new ProvSaatDTO();
    	
		Calendar cal = Calendar.getInstance();    	
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");		  
		String saatDakika = df.format(cal.getTime());
		  
    	veri.setSayi(400);
    	veri.setZaman(saatDakika);    	

    	if(!sonAn.equals(saatDakika)){
	    	System.out.println(i);

	    	if(stack.size()<grafikGecmis){	    		
	    		stack.add(0, veri);
	    	}else{
	    		stack.pop();
	    		stack.add(0, veri);
	    		data.clear();
	    		liste.setData(data);
	    		
	    		System.out.println("silinen- yeni boyut " + data.size());
	    	}
	    	
	    	byte y = 0;

	    	for (Object object : stack) {
	    		ProvSaatDTO provSaatDTO = (ProvSaatDTO)object;
	    		
	    			liste.set(provSaatDTO.getZaman(), provSaatDTO.getSayi());
	    			liste2.set(provSaatDTO.getZaman(), 32);
	    		
				y++;
			}

	    	liste.set(saatDakika, 450);	    	
	    	i++;
	    	System.out.println(i);
	    	sonAn = saatDakika;
	    	
	    	System.out.println("yapt�m");
    	}else{
    		System.out.println("gectim");
    		
    	}
    	
    	liste.setShowLine(true);
    	    	
    	linearModel = new LineChartModel();
    	linearModel.addSeries(liste);

		linearModel.addSeries(liste2);

    	
        return linearModel;
    }   

    private void createLinearModel() throws Exception {


		Calendar cal = Calendar.getInstance();    	
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");		  
		String saatDakika = df.format(cal.getTime());
    	
    	linearModel = new LineChartModel();  
    	
		  Date d = df.parse(saatDakika);
		  cal.setTime(d);
		  cal.add(Calendar.MINUTE, -grafikGecmis);

    	
    	for (int z = 0; z < grafikGecmis; z++) {  
    		cal.add(Calendar.MINUTE, 1);
  		  String eskiZaman = df.format(cal.getTime());
  		  
        	ProvSaatDTO tmp = new ProvSaatDTO();
        	tmp.setSayi(300);
        	
    		tmp.setZaman(eskiZaman);
    		System.out.println(z);
    		stack.add(0, tmp);
    		liste.set(String.valueOf(z), z);
    		liste2.set("13", z);
    		
		}
    	
    	Thread.sleep(3000);
    	//liste.set(saatDakika, i);
    	liste.setLabel("Provizyon");
    	liste2.setLabel("testtt");
    	i++;

    	liste.setShowLine(true);
    	linearModel.addSeries(liste);
    	linearModel.addSeries(liste2);
    }
}
