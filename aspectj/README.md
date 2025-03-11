# AspectJ Demo Application

To compile and run the application, use the following Maven commands:

```bash
# Clean and compile the project
mvn clean compile

# Run the application
mvn exec:java
```

## Features Demonstrated

The application demonstrates several AspectJ features through a simple user service:

1. Before advice: Logs method calls before execution
2. After returning advice: Logs return values from methods
3. After throwing advice: Logs exceptions when they occur
4. After advice: Logs when method execution completes

The `Main` class demonstrates these features by:
- Creating a user successfully
- Attempting to create a user with invalid input (demonstrates exception handling)
- Retrieving a user (demonstrates return value handling) 