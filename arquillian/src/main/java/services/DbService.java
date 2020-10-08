package services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class DbService {

	public String getUser() {
		return "Test User";
	}

	@PostConstruct
	public void construct() {
		System.out.println("---------- before Construction ---------- ");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("---------- before Destruction ---------- ");
	}
}
