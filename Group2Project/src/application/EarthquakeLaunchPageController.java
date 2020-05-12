package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// GMaps imports
// Help from: http://rterp.github.io/GMapsFX/
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.javascript.object.Marker;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EarthquakeLaunchPageController implements Initializable, MapComponentInitializedListener {
	@FXML
	private Pane mapPane;
	@FXML
	private TextArea earthquakeInfoLabel;
	@FXML
	private Button printCurrentEarthquakeButton;
	@FXML
	private Button printAllEarthquakes;
	@FXML
	private Button filterButton;
	@FXML
	private GoogleMapView mapView;
	private GoogleMap map;
	@FXML
	private Label searchCriteriaLabel;
	@FXML 
	private TextField filterTextField;
	private static ChoiceBox<String> filterChoiceBox;
	
	public static CsvOpen opener = new CsvOpen();
	public static ArrayList<Earthquake> earthquakeList = opener.StringCSVOpener();

	
	//reverse communication set up (to pop up window)
	private Stage popUpStage;
	private EarthquakePopUpWindowController popUpController;

	//make variable for data to be sent to file
	public static String printData = "";
	
	//make map in GUI
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		mapView.addMapInializedListener(this);
	}
	
	@Override
	public void mapInitialized() {
		//Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();
        
        mapOptions.center(new LatLong(26.8206, 30.8025))
        		.overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(2);
                   
        map = mapView.createMap(mapOptions);
        
        makeNewMarkers(earthquakeList);

	}

	//make choicebox for filter choices
	public static void makeChoiceBox(AnchorPane mainPane) {
		//make a new choiceBox
		filterChoiceBox = new ChoiceBox<String>();
		//place it on the pane
		AnchorPane.setTopAnchor(filterChoiceBox, 97.0);
		AnchorPane.setLeftAnchor(filterChoiceBox, 1200.0);

		
		//add choices
		//date, location, depth, mag, magType, place, status)
		filterChoiceBox.getItems().add("Date");
		filterChoiceBox.getItems().add("Date Range");
		filterChoiceBox.getItems().add("Location");
		filterChoiceBox.getItems().add("Location Range");
		filterChoiceBox.getItems().add("Depth");
		filterChoiceBox.getItems().add("Depth Range");
		filterChoiceBox.getItems().add("Mag");
		filterChoiceBox.getItems().add("Mag Range");
		filterChoiceBox.getItems().add("MagType");
		filterChoiceBox.getItems().add("Place");
		filterChoiceBox.getItems().add("Status");
		filterChoiceBox.getItems().add("None");
		
		filterChoiceBox.getSelectionModel().selectLast();
		
		//populate choicebox
		mainPane.getChildren().addAll(filterChoiceBox);

	}
	
	
	//print functions
	
	//Writes data about the currently selected earthquake to file
	@FXML
	public String printCurrentClicked(ActionEvent event) {
		//window setup
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/EarthquakePopUpWindow.fxml"));
		AnchorPane popUpRoot;
		
		//if a window is already made, use it. If not make a new one
		if (popUpStage == null) {
			//make the window
			try {
				popUpRoot = (AnchorPane)loader.load();
				Scene popUpScene = new Scene(popUpRoot);
				popUpStage = new Stage();
				popUpStage.setScene(popUpScene);
				popUpController = (EarthquakePopUpWindowController) loader.getController();
				
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		//show the window
		popUpStage.show();
		//set print data to current selected of earthquake
		printData = earthquakeInfoLabel.getText();
		return printData;
	}
	
	
	//Writes data about the current filter of earthquakes to file
	@FXML
	public String printAllClicked(ActionEvent event) throws Exception {
		//window setup
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/EarthquakePopUpWindow.fxml"));
		AnchorPane popUpRoot;
		//if a window is already made, use it. If not make a new one
		if (popUpStage == null) {
			//make the window
			try {
				popUpRoot = (AnchorPane)loader.load();
				Scene popUpScene = new Scene(popUpRoot);
				popUpStage = new Stage();
				popUpStage.setScene(popUpScene);
				popUpController = (EarthquakePopUpWindowController) loader.getController();
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		//show the window
		popUpStage.show();

		//set print data to info from all filtered earthquakes
		//checks to see what filter is chosen and prints based on that
		
		String selected =  filterChoiceBox.getValue();
		String filterCriteria = filterTextField.getText();
		
		switch (selected) {
		
		case ("Date"): printData = EarthquakeCollection.printAll(EarthquakeCollection.searchByDate(consoleInterface.earthquakeList, filterCriteria)); break;
		
		case ("Date Range"): 
			String[] dates = filterCriteria.split(";");
			String date1 = dates[0];
			String date2 = dates[1];
			
			printData = EarthquakeCollection.printByValue(EarthquakeCollection.searchByDateRange(consoleInterface.earthquakeList, date1, date2), new Earthquake.DateSort());
		
		case ("Location"):
			String[] locations = filterCriteria.split(",");
			Double loc1 = Double.parseDouble(locations[0]);
			Double loc2 = Double.parseDouble(locations[1]);	
			
			printData = EarthquakeCollection.printAll(EarthquakeCollection.searchByLocation(consoleInterface.earthquakeList, loc1, loc2)); break;
			
		case ("Location Range"):
			String[] locationRange = filterCriteria.split(";");
			String firstLocation = locationRange[0];
			String secondLocation = locationRange[1];
			
			String[] location1 = firstLocation.split(",");
			Double lat1 = Double.parseDouble(location1[0]);
			Double long1 = Double.parseDouble(location1[1]);	
			
			String[] location2 = secondLocation.split(",");
			Double lat2 = Double.parseDouble(location2[0]);
			Double long2 = Double.parseDouble(location2[1]);	
			
			printData = EarthquakeCollection.printByValue(EarthquakeCollection.searchByLocationRange(consoleInterface.earthquakeList, long1, long2, lat1, lat2), new Earthquake.LocationSort()); break;
			
		case ("Depth"): printData = EarthquakeCollection.printAll(EarthquakeCollection.searchByDepth(consoleInterface.earthquakeList, Double.parseDouble(filterCriteria))); break;
			
		case ("Depth Range"): 
			String[] depths = filterCriteria.split(";");
			Double depth1 = Double.parseDouble(depths[0]);
			Double depth2 = Double.parseDouble(depths[1]);
			
			printData = EarthquakeCollection.printByValue(EarthquakeCollection.searchByDepthRange(consoleInterface.earthquakeList, depth1, depth2), new Earthquake.DepthSort()); break;
		
		case ("Mag"): printData = EarthquakeCollection.printAll(EarthquakeCollection.searchByMag(consoleInterface.earthquakeList, Double.parseDouble(filterCriteria))); break;
		
		case ("Mag Range"): 
			String[] mags = filterCriteria.split(";");
			Double mag1 = Double.parseDouble(mags[0]);
			Double mag2 = Double.parseDouble(mags[1]);
			
			printData = EarthquakeCollection.printByValue(EarthquakeCollection.searchByMagRange(consoleInterface.earthquakeList, mag1, mag2), new Earthquake.MagSort()); break;

		case ("MagType"): printData = EarthquakeCollection.printAll(EarthquakeCollection.searchByMagType(consoleInterface.earthquakeList, filterCriteria)); break;
			
		case ("Place"): printData = EarthquakeCollection.printAll(EarthquakeCollection.searchByPlace(consoleInterface.earthquakeList, filterCriteria)); break;
			
		case ("Status"): printData = EarthquakeCollection.printAll(EarthquakeCollection.searchByStatus(consoleInterface.earthquakeList, filterCriteria)); break;
			
		case ("None"): printData = EarthquakeCollection.printAll(consoleInterface.earthquakeList); break;
			
		default: printData = EarthquakeCollection.printAll(consoleInterface.earthquakeList); break;
		
		}

		return printData;
	}
	
	//Applies filters to earthquake data
	@FXML
	public void filterButtonClicked(ActionEvent event) {
		String selected =  filterChoiceBox.getValue();
		String filterCriteria = filterTextField.getText();
		
		//alters the info label based on the filter choicebox

		switch (selected) {

		case "Date": try {
			ArrayList<Earthquake> filteredData = EarthquakeCollection.searchByDate(consoleInterface.earthquakeList, filterCriteria);
			earthquakeInfoLabel.setText(EarthquakeCollection.printAll(filteredData)); 
			
			makeNewMarkers(filteredData); break;
			
		} catch (Exception e) {
			earthquakeInfoLabel.setText("Invalid input. Please try again"); break;
		}
		
		
		case "Date Range": try {
			String[] dates = filterCriteria.split(";");
			String date1 = dates[0];
			String date2 = dates[1];
			
			ArrayList<Earthquake> filteredData = EarthquakeCollection.searchByDateRange(consoleInterface.earthquakeList, date1, date2);
			earthquakeInfoLabel.setText(EarthquakeCollection.printAll(filteredData));
			
			makeNewMarkers(filteredData); break;
		} catch (Exception e) {
			earthquakeInfoLabel.setText("Invalid input. Please try again"); break;
		}
		
		case "Location": try {
			String[] locations = filterCriteria.split(",");
			Double loc1 = Double.parseDouble(locations[0]);
			Double loc2 = Double.parseDouble(locations[1]);	
			
			ArrayList<Earthquake> filteredData = EarthquakeCollection.searchByLocation(consoleInterface.earthquakeList, loc1, loc2);
			earthquakeInfoLabel.setText(EarthquakeCollection.printAll(filteredData));
			
			makeNewMarkers(filteredData); break;
			
		} catch (Exception e) {
			earthquakeInfoLabel.setText("Invalid input. Please try again"); break;
		}

		
		case "Location Range": try {
			String[] locationRange = filterCriteria.split(";");
			String firstLocation = locationRange[0];
			String secondLocation = locationRange[1];
			
			String[] location1 = firstLocation.split(",");
			Double lat1 = Double.parseDouble(location1[0]);
			Double long1 = Double.parseDouble(location1[1]);	
			
			String[] location2 = secondLocation.split(",");
			Double lat2 = Double.parseDouble(location2[0]);
			Double long2 = Double.parseDouble(location2[1]);
			
			ArrayList<Earthquake> filteredData = EarthquakeCollection.searchByLocationRange(consoleInterface.earthquakeList, long1, long2, lat1, lat2);
			earthquakeInfoLabel.setText(EarthquakeCollection.printAll(filteredData));
			
			makeNewMarkers(filteredData); break;
			
		} catch (Exception e) {
			earthquakeInfoLabel.setText("Invalid input. Please try again"); break;
		}
		
		case "Depth": try {
			ArrayList<Earthquake> filteredData = EarthquakeCollection.searchByDepth(consoleInterface.earthquakeList, Double.parseDouble(filterCriteria));
			earthquakeInfoLabel.setText(EarthquakeCollection.printAll(filteredData)); 
			
			makeNewMarkers(filteredData); break;
		
		} catch (Exception e) {
			earthquakeInfoLabel.setText("Invalid input. Please try again"); break;
		}
		
		
		case "Depth Range": try {
			String[] depths = filterCriteria.split(";");
			Double depth1 = Double.parseDouble(depths[0]);
			Double depth2 = Double.parseDouble(depths[1]);
			
			ArrayList<Earthquake> filteredData = EarthquakeCollection.searchByDepthRange(consoleInterface.earthquakeList, depth1, depth2);
			earthquakeInfoLabel.setText(EarthquakeCollection.printAll(filteredData)); 
			
			makeNewMarkers(filteredData); break;
		
		} catch (Exception e) {
			earthquakeInfoLabel.setText("Invalid input. Please try again"); break;
		}


		case "Mag": try {
			ArrayList<Earthquake> filteredData = EarthquakeCollection.searchByMag(consoleInterface.earthquakeList, Double.parseDouble(filterCriteria));
			earthquakeInfoLabel.setText(EarthquakeCollection.printAll(filteredData)); 
			
			makeNewMarkers(filteredData); break;
		
		} catch (Exception e) {
			earthquakeInfoLabel.setText("Invalid input. Please try again"); break;
		}
		
		
		case "Mag Range": try {
			String[] mags = filterCriteria.split(";");
			Double mag1 = Double.parseDouble(mags[0]);
			Double mag2 = Double.parseDouble(mags[1]);
			
			ArrayList<Earthquake> filteredData = EarthquakeCollection.searchByMagRange(consoleInterface.earthquakeList, mag1, mag2);
			earthquakeInfoLabel.setText(EarthquakeCollection.printAll(filteredData)); 
			
			makeNewMarkers(filteredData); break;
		
		} catch (Exception e) {
			earthquakeInfoLabel.setText("Invalid input. Please try again"); break;
		}

		case "MagType": try {
			ArrayList<Earthquake> filteredData = EarthquakeCollection.searchByMagType(consoleInterface.earthquakeList, filterCriteria);
			earthquakeInfoLabel.setText(EarthquakeCollection.printAll(filteredData)); 
			
			makeNewMarkers(filteredData); break;
		
		} catch (Exception e) {
			earthquakeInfoLabel.setText("Invalid input. Please try again"); break;
		}
		

		case "Place": try {
			ArrayList<Earthquake> filteredData = EarthquakeCollection.searchByPlace(consoleInterface.earthquakeList, filterCriteria);
			earthquakeInfoLabel.setText(EarthquakeCollection.printAll(filteredData));
			
			makeNewMarkers(filteredData); break;

		} catch (Exception e) {
			earthquakeInfoLabel.setText("Invalid input. Please try again"); break;
		}
		

		case "Status":  try {
			ArrayList<Earthquake> filteredData = EarthquakeCollection.searchByStatus(consoleInterface.earthquakeList, filterCriteria);
			earthquakeInfoLabel.setText(EarthquakeCollection.printAll(filteredData)); 
			
			makeNewMarkers(filteredData); break;

		} catch (Exception e) {
			earthquakeInfoLabel.setText("Invalid input. Please try again"); break;
		}
		
		case "None": makeNewMarkers(earthquakeList); earthquakeInfoLabel.setText("Select a filter to display results");
		
		default: earthquakeInfoLabel.setText("Select a filter to display results");
		}
		
		filterTextField.clear();
	}
	
	//send data to popup window so it can be written to file
	public static String sendData() {
		
		//make printData pretty for the texteditors -- replace \n with \r\n
		printData = printData.replaceAll("\n", "\r\n");		
		return printData;
	}
	
	
	// Add markers to map
	public void makeNewMarkers(ArrayList<Earthquake> earthquakeList) {
		// Clear existing markers
		map.clearMarkers();
		
		// Loop through each earthquake and add markers
	    for(int i=0; i < earthquakeList.size(); i++) {
	        
	        // Get longitude and latitude 
	    	double latitude = Double.parseDouble(earthquakeList.get(i).getLatitude());
	    	double longitude = Double.parseDouble(earthquakeList.get(i).getLongitude());
	        LatLong location = new LatLong(latitude, longitude);
	        
	        // Create marker
	        MarkerOptions markerOption = new MarkerOptions();
	        markerOption.position(location);
	        Marker marker = new Marker(markerOption);
	        
	        // Add marker to map
	        map.addMarker(marker);
	     }
	}
}