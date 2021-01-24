package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
            VBox root = (VBox)FXMLLoader.load(getClass().getClassLoader().getResource("ilk_gui.fxml"));
			Scene scene = new Scene(root,400,600);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
