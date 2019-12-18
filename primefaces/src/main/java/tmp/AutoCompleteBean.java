package tmp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

//@ViewScoped
@ManagedBean
public class AutoCompleteBean implements Serializable {


	private static final long serialVersionUID = -7284582765200382943L;

	public AutoCompleteBean() {
		// TODO Auto-generated constructor stub
	}

	private String txt1;


	public List<String> completeText(String query){
		List<String> results = new ArrayList<String>();
		for(int i = 0; i < 10; i++) {
			results.add(query + i);

		}

		return results;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}
}
