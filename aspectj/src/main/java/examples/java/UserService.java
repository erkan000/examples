package examples.java;

import java.util.HashMap;
import java.util.Map;

public class UserService {
	
    private Map<String, String> users = new HashMap<>();

    public void createUser(String name) {
        if (name == null) {
            throw new IllegalArgumentException("User name cannot be null");
        }
        users.put(name, name);
        System.out.println("User created: " + name);
    }

    public String getUser(String name) {
        return users.get(name);
    }
} 