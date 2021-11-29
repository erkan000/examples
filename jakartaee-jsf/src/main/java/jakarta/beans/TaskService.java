package jakarta.beans;

public class TaskService {
	
	public String doSomeJob(String data) {
		return data.concat(" enriched from service");
	}

}
