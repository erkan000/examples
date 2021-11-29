package jakarta.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@RequestScoped
@Named
public class TestBean {

    @Inject
    private TaskService taskService;

    private String name;
    private String message;
    
    public void doSomeTask() {
    	setMessage(taskService.doSomeJob("test"));
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
