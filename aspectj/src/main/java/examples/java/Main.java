package examples.java;

public class Main {
	
    public static void main(String[] args) {
    	
        UserService userService = new UserService();
        
        userService.createUser("John Doe");
        
        try {
            userService.createUser(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
        
        String user = userService.getUser("John Doe");
        System.out.println("Retrieved user: " + user);
    }
    
} 