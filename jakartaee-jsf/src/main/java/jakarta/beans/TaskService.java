package jakarta.beans;

import jakarta.ejb.Stateless;

@Stateless
public class TaskService {
	
	public String doSomeJob(String data) {
		return data.concat(" enriched from service");
	}

}
