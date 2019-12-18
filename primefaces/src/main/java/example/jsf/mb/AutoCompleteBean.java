package example.jsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AutoCompleteBean implements Serializable {

	private static final long serialVersionUID = -7284582765200382943L;

	private String name;

	public List<String> completeName(String query){
		List<String> results = new ArrayList<>();
		for(int i = 0; i < query.length(); i++) {
			results.add(query + "-" + i);
		}
		return results;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
