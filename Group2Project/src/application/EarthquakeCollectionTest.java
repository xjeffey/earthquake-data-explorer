package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class EarthquakeCollectionTest {
	
	//variables to work with the testing
	public CsvOpen opener = new CsvOpen();
	public ArrayList<Earthquake> quakes = opener.StringCSVOpener();

	//testing to see if output data matches what we want
	@Test
	public void helpTest() throws FileNotFoundException {
		File file = new File("./Data/help.txt");
		Scanner input = new Scanner(file);
		
		String output = "";
		
		while(input.hasNextLine()) {
			output += input.nextLine() + "\n";
		}
		
		input.close();
		
		assertEquals(output, EarthquakeCollection.help() + "\n");
	}
	
	//testing to see if output data matches what we want
	@Test
	public void summaryTest() throws FileNotFoundException {
		
		String summary = "Number of events: ";
		
		int intCounter = 0;
		
		for(int i = 0; i < quakes.size(); i++) {
			intCounter += 1;
		}
		
		summary += intCounter;
		
		summary += "\nDate Range of events: \n";
		String dateBetween = CsvOpen.returnTimeLine(quakes);
		summary += "\n" + dateBetween;
		
		assertEquals(summary, EarthquakeCollection.summary(quakes));
	}
	
	//testing to see if output data matches what we want - All earthquakes
	@Test
	public void printAllTest() throws FileNotFoundException {
		File file = new File("./Data/printall.txt");
		Scanner input = new Scanner(file);
		
		String output = "";
		
		while(input.hasNextLine()) {
			output += input.nextLine() + "\n";
		}
		
		input.close();
		
		assertEquals(output, EarthquakeCollection.printAll(quakes) + "\n");
	}
	
	//testing to see if output data matches what we want - finding earthquakes by date
	@Test
	public void searchDateTest() throws FileNotFoundException {
		File file = new File("./Data/searchDate.txt");
		Scanner input = new Scanner(file);
		
		String output = "";
		
		while(input.hasNextLine()) {
			output += input.nextLine() + "\n";
		}
		
		input.close();
		
		assertEquals(output, EarthquakeCollection.printAll(EarthquakeCollection.searchByDate(quakes, "2019-02-05")));
	}
	
	//testing to see if output data matches what we want - finding earthquakes between 2 dates
	@Test
	public void searchDateRangeTest() throws FileNotFoundException, ParseException {
		File file = new File("./Data/searchDateRange.txt");
		Scanner input = new Scanner(file);
		
		String output = "";
		
		while(input.hasNextLine()) {
			output += input.nextLine() + "\n";
		}
		
		input.close();
		
		assertEquals(output, EarthquakeCollection.printByValue(EarthquakeCollection.searchByDateRange(quakes, "2019-02-05",  "2019-02-08"), new Earthquake.DateSort()) + "\n");
	}
	
	//testing to see if output data matches what we want - finding earthquakes by depth
	@Test
	public void searchDepthTest() throws FileNotFoundException {
		File file = new File("./Data/searchDepth.txt");
		Scanner input = new Scanner(file);
		
		String output = "";
		
		while(input.hasNextLine()) {
			output += input.nextLine() + "\n";
		}
		
		input.close();
		
		assertEquals(output, EarthquakeCollection.printAll(EarthquakeCollection.searchByDepth(quakes, 5)));
	}
	
	//testing to see if output data matches what we want - finding earthquakes between 2 depths
		@Test
		public void searchDepthRangeTest() throws FileNotFoundException {
			File file = new File("./Data/searchDepthRange.txt");
			Scanner input = new Scanner(file);
			
			String output = "";
			
			while(input.hasNextLine()) {
				output += input.nextLine() + "\n";
			}
			
			input.close();
			
			assertEquals(output, EarthquakeCollection.printByValue(EarthquakeCollection.searchByDepthRange(quakes, 0, 5), new Earthquake.DepthSort()) + "\n");
		}
		
	//testing to see if output data matches what we want - finding earthquakes by mag
	@Test
	public void searchMagTest() throws FileNotFoundException{
		File file = new File("./Data/searchMag.txt");
		Scanner input = new Scanner(file);
		
		String output = "";
		
		while(input.hasNextLine()) {
			output += input.nextLine() + "\n";
		}
		
		input.close();
		
		assertEquals(output, EarthquakeCollection.printAll(EarthquakeCollection.searchByDepth(quakes, 5)));
	}
	
	//testing to see if output data matches what we want - finding earthquakes between 2 mags
	@Test
	public void searchMagRangeTest() throws FileNotFoundException {
		File file = new File("./Data/searchMagRange.txt");
		Scanner input = new Scanner(file);
		
		String output = "";
		
		while(input.hasNextLine()) {
			output += input.nextLine() + "\n";
		}
		
		input.close();
		
		assertEquals(output, EarthquakeCollection.printByValue(EarthquakeCollection.searchByMagRange(quakes, 0, 5), new Earthquake.MagSort()));
	}
	
	//testing to see if output data matches what we want - finding earthquakes by magtype
	@Test
	public void searchMagTypeTest() throws FileNotFoundException{
		File file = new File("./Data/searchMagType.txt");
		Scanner input = new Scanner(file);
		
		String output = "";
		
		while(input.hasNextLine()) {
			output += input.nextLine() + "\n";
		}
		
		input.close();
		
		assertEquals(output, EarthquakeCollection.printAll(EarthquakeCollection.searchByMagType(quakes, "ml")));
	}
	
	//testing to see if output data matches what we want - finding earthquakes by location
	@Test
	public void searchLocationTest() throws FileNotFoundException{
		File file = new File("./Data/searchLocation.txt");
		Scanner input = new Scanner(file);
		
		String output = "";
		
		while(input.hasNextLine()) {
			output += input.nextLine() + "\n";
		}
		
		input.close();
		
		assertEquals(output, EarthquakeCollection.printAll(EarthquakeCollection.searchByLocation(quakes, 61.7884, -149.651)));
	}
	
	//testing to see if output data matches what we want - finding earthquakes between 2 locations
	@Test
	public void searchLocationRangeTest() throws FileNotFoundException {
		File file = new File("./Data/searchLocationRange.txt");
		Scanner input = new Scanner(file);
		
		String output = "";
		
		while(input.hasNextLine()) {
			output += input.nextLine() + "\n";
		}
		
		input.close();
		
		assertEquals(output, EarthquakeCollection.printByValue(EarthquakeCollection.searchByLocationRange(quakes, -100, 0, 0, 100), new Earthquake.LocationSort()));
	}
	
	//testing to see if output data matches what we want - finding earthquakes by place
	@Test
	public void searchPlaceTest() throws FileNotFoundException{
		File file = new File("./Data/searchPlace.txt");
		Scanner input = new Scanner(file);
		
		String output = "";
		
		while(input.hasNextLine()) {
			output += input.nextLine() + "\n";
		}
		
		input.close();
		
		assertEquals(output, EarthquakeCollection.printAll(EarthquakeCollection.searchByPlace(quakes, "Alaska")));
	}

	//testing to see if output data matches what we want - finding earthquakes by status
	@Test
	public void searchStatusTest() throws FileNotFoundException{
		File file = new File("./Data/searchStatus.txt");
		Scanner input = new Scanner(file);
		
		String output = "";
		
		while(input.hasNextLine()) {
			output += input.nextLine() + "\n";
		}
		
		input.close();
		
		assertEquals(output, EarthquakeCollection.printAll(EarthquakeCollection.searchByStatus(quakes, "automatic")));
	}
	
	//testing to see if out data matches what we want - printing earthquakes by date
		@Test
		public void printByDateTest() throws FileNotFoundException{
			File file = new File("./Data/printDate.txt");
			Scanner input = new Scanner(file);
			
			String output = "";
			
			while(input.hasNextLine()) {
				output += input.nextLine() + "\n";
			}
			
			input.close();
			
			assertEquals(output, EarthquakeCollection.printByValue(quakes, new Earthquake.DateSort()));
		}
	
	//testing to see if out data matches what we want - printing earthquakes by mag
		@Test
		public void printByMagTest() throws FileNotFoundException{
			File file = new File("./Data/printMag.txt");
			Scanner input = new Scanner(file);
			
			String output = "";
			
			while(input.hasNextLine()) {
				output += input.nextLine() + "\n";
			}
			
			input.close();
			
			assertEquals(output, EarthquakeCollection.printByValue(quakes, new Earthquake.MagSort()));
		}
		
		//testing to see if out data matches what we want - printing earthquakes by depth
		@Test
		public void printByStatusTest() throws FileNotFoundException{
			File file = new File("./Data/printStatus.txt");
			Scanner input = new Scanner(file);
			
			String output = "";
			
			while(input.hasNextLine()) {
				output += input.nextLine() + "\n";
			}
			
			input.close();
			
			assertEquals(output, EarthquakeCollection.printByValue(quakes, new Earthquake.StatusSort()));
		}
		
		@Test
		public void printByDepthTest() throws FileNotFoundException{
			File file = new File("./Data/printDepth.txt");
			Scanner input = new Scanner(file);
			
			String output = "";
			
			while(input.hasNextLine()) {
				output += input.nextLine() + "\n";
			}
			
			input.close();
			
			assertEquals(output, EarthquakeCollection.printByValue(quakes, new Earthquake.DepthSort()) + "\n");
		}
		
		
		@Test
		public void printByPlaceTest() throws FileNotFoundException{
			File file = new File("./Data/printPlace.txt");
			Scanner input = new Scanner(file);
			
			String output = "";
			
			while(input.hasNextLine()) {
				output += input.nextLine() + "\n";
			}
			
			input.close();
			
			assertEquals(output, EarthquakeCollection.printByValue(quakes, new Earthquake.PlaceSort()) + "\n");
		}
}
