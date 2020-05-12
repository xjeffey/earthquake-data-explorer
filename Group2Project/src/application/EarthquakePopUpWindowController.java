package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class EarthquakePopUpWindowController {
	@FXML
	private TextField fileNameTextField;
	@FXML
	private Button writeToFileButton;
	@FXML
	private Button cancelButton;
	@FXML
	private AnchorPane popUpPane;
	@FXML 
	private Label warningLabel;
	
	
	//reverse communication to launch page
	private EarthquakeLaunchPageController callingController;
	
	public void setCallingController(EarthquakeLaunchPageController c) {
		callingController = c;
	}
	
	//If cancel button is clicked hide the popup window
	@FXML
	public void cancelButtonClicked(ActionEvent event) {
		popUpPane.getScene().getWindow().hide();
	}
	
	//If the write to file button is clicked, take the printData and create a new text file with the name the user gives
	@FXML
	public void writeToFileButtonClicked(ActionEvent event) {
		
		String filename = fileNameTextField.getText();
		java.io.File file = new java.io.File(filename + ".txt");
		
		//send user an error if the file alread exists
		if (file.exists()) {
			warningLabel.setText("WARNING: this file already exists. Try a different file name");
		}
		
		//If file does not already exists, send data to the file
		else {
			try(java.io.PrintWriter output = new java.io.PrintWriter(file)) {
				System.out.println("Writing to file");
				
				//add stuff to output here
				String data = EarthquakeLaunchPageController.sendData();
				System.out.println(data);
				output.println(data);
				
				//close window when done
				popUpPane.getScene().getWindow().hide();
				
			}catch (Exception e) {
				//if it doesn't work - send error message
				System.out.println("Could not print file");
			
			}
		}
	}

}
