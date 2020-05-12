/* Jamieson Allare
 * Laura Buckles
 * Jeff Tran
 * Earthquake Data: Part 2
 */

package application;

// FXML imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	//runs application GUI
	@Override
	public void start(Stage primaryStage) throws Exception {

		try {
			//set title of window
			primaryStage.setTitle("Earthquake Data Explorer");
			
			//get fxml loader and read in the fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/EarthquakeLaunchPage.fxml"));
			AnchorPane mainPane = (AnchorPane)loader.load();
			
			
			//create scene with layout from fxml
			Scene scene = new Scene(mainPane);
			primaryStage.setScene(scene);
			//add in the choicebox for the filter selections
			EarthquakeLaunchPageController.makeChoiceBox(mainPane);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
