package services;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserService {
	
	@Inject
	private DbService dbService;
	
	public String getUser() {
		return dbService.getUser();
	}

}
