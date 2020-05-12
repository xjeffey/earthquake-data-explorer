package application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class consoleInterface {
	//List of all the commands the user can input
	public static String[] menuList = new String[]{"help", "summary", "printall", "printbydate", "printbydepth", "printbymag", "printbyplace", "printbystatus", 
			"searchdate", "searchlocation", "searchdepth", "searchmag", "searchmagtype", "searchplace", "searchstatus", "searchdepthrange", 
			"searchmagrange", "searchlocationrange", "searchdaterange", "stop"};
	
	//creating a universal arraylist to work with
	//Opens the CSV file
	public static CsvOpen opener = new CsvOpen();
	public static ArrayList<Earthquake> earthquakeList = opener.StringCSVOpener();

	//creating the menu
	public static String menuSpace(String word) {
		//limiting spaces
		int spacesNum = 20;
		
		//getting the extra spaces for front and back of word
		int whiteSpace = 20 - word.length();
		String menuString = "";
		
		//adding dashes to the front
		for(int i = 0; i < (int)(whiteSpace/2); i++) {
			menuString += "-";
		}
		
		//adding the word to the string
		menuString += word;
		
		//adding dashes to the back
		for(int i = 0; i < whiteSpace - ((int)(whiteSpace / 2)); i++) {
			menuString += "-";
		}
		
		return menuString;
	}
	
	//sending over earthquake list
	public static ArrayList<Earthquake> sendEarthquakes(){
		return earthquakeList;
	}
	
	//creating the top and bottom string of dashes - the menu
	public static void startConsole(String[] menuList) {
		System.out.println("--------------------");
		for(int i = 0; i < menuList.length; i++) {
			
			//prints every item that the user can use in a list
			System.out.println(menuSpace(menuList[i]));
			
		}
		System.out.println("--------------------");
	}
	
	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
		startConsole(menuList);
		Scanner input = new Scanner(System.in);
		
		while(true) {
			//asking for a command
			System.out.println("\nWhat command would you like to choose: ");
			String command = input.nextLine();
			command = command.toLowerCase();
			
			if (Arrays.asList(menuList).contains(command)) {
				//help
				if (command.equals(menuList[0])) {
					System.out.println(EarthquakeCollection.help());
				}
				//summary
				if (command.equals(menuList[1])) {
					System.out.println(EarthquakeCollection.summary(earthquakeList));
				}
				//print all
				if (command.equals(menuList[2])) {
					System.out.println(EarthquakeCollection.printAll(earthquakeList));
				}
				//print by date
				if (command.equals(menuList[3])) {
					System.out.println(EarthquakeCollection.printByValue(earthquakeList, new Earthquake.DateSort()));
				}
				//print by depth
				if (command.equals(menuList[4])) {
					System.out.println(EarthquakeCollection.printByValue(earthquakeList, new Earthquake.DepthSort()));
				}
				//print by mag
				if (command.equals(menuList[5])) {
					System.out.println(EarthquakeCollection.printByValue(earthquakeList, new Earthquake.MagSort()));
				}
				//print by place
				if (command.equals(menuList[6])) {
					System.out.println(EarthquakeCollection.printByValue(earthquakeList, new Earthquake.PlaceSort()));
				}
				//print by status
				if (command.equals(menuList[7])) {
					System.out.println(EarthquakeCollection.printByValue(earthquakeList, new Earthquake.StatusSort()));
				}
				//search by date
				if (command.equals(menuList[8])) {
					//format on how we want our date
					String date_format = "yyyy-MM-dd";
					DateFormat date = new SimpleDateFormat(date_format);
					
					//asking for information
					System.out.println("Enter a date to search by (yyyy-MM-d): ");
					String date1 = input.nextLine();	
					
					//validating input of the date
					while(true) {
						try {
							date.parse(date1);
							break;
						}
						//asking for new date if given isnt what we want
						catch(Exception e) {
							System.out.println("Invalid Date. Enter a date (yyyy-MM-dd): ");
							date1 = input.nextLine();
						}
					}
					System.out.println(EarthquakeCollection.searchByDate(earthquakeList, date1));
				}
				//search by location
				if (command.equals(menuList[9])) {
					//getting latitude information
					System.out.println("Enter a latitude: ");
					String user_lat1 = input.nextLine();
					Double lat1;
					
					//validating the latitude input
					while(true) {
						try {
							lat1 = Double.parseDouble(user_lat1);
							break;
						}
						//getting new data if given doesn't work
						catch(Exception e) {
							System.out.println("Invalid latitude. Enter a latitude: ");
							user_lat1 = input.nextLine();
						}
					}
					
					//getting longitude information
					System.out.println("Enter a longitude: ");
					String user_long1 = input.nextLine();
					Double long1;
					
					//validating longitude input
					while(true) {
						try {
							long1 = Double.parseDouble(user_long1);
							break;
						}
						//getting new data if given doesn't work
						catch(Exception e) {
							System.out.println("Invalid longitude. Enter a longitude: ");
							user_long1 = input.nextLine();
						}
					}
						
					System.out.println(EarthquakeCollection.searchByLocation(earthquakeList, lat1, long1));
				}
				//search by depth
				if (command.equals(menuList[10])) {
					//getting depth information
					System.out.println("Enter depth: ");
					String user_depth1 = input.nextLine();
					Double depth1;
					
					//validating depth input
					while(true) {
						try {
							depth1 = Double.parseDouble(user_depth1);
							break;
						}
						//getting new data if given doesn't work
						catch(Exception e) {
							System.out.println("Invalid depth. Enter a depth: ");
							user_depth1 = input.nextLine();
						}
					}
					
					System.out.println(EarthquakeCollection.searchByDepth(earthquakeList, depth1));
				}
				
				//search by mag
				if (command.equals(menuList[11])) {
					//getting mag information
					System.out.println("Enter magnitude: ");
					String user_mag1 = input.nextLine();
					Double mag1;
					
					//validating mag input
					while(true) {
						try {
							mag1 = Double.parseDouble(user_mag1);
							break;
						}
						//getting new data if given doesn't work
						catch(Exception e) {
							System.out.println("Invalid depth. Enter a depth: ");
							user_mag1 = input.nextLine();
						}
					}
					
					System.out.println(EarthquakeCollection.searchByMag(earthquakeList, mag1));	
				}
				
				//search by magtype
				if (command.equals(menuList[12])) {
					System.out.println("Enter magType: ");
					String magType1 = input.nextLine();
					
					System.out.println(EarthquakeCollection.searchByMagType(earthquakeList, magType1));
				}
				//search by place
				if (command.equals(menuList[13])) {
					System.out.println("Enter place: ");
					String place1 = input.nextLine();
					
					System.out.println(EarthquakeCollection.searchByPlace(earthquakeList, place1));
				}
				///search by status
				if (command.equals(menuList[14])) {
					System.out.println("Enter status: ");
					String status1 = input.nextLine();
	
					System.out.println(EarthquakeCollection.searchByStatus(earthquakeList, status1));
				}
				
				//search by depth range
				if(command.equals(menuList[15])) {
					System.out.println("Enter the first depth: ");
					String user_depth1 = input.nextLine();
					Double depth1;
					
					//validating depth input
					while(true) {
						try {
							depth1 = Double.parseDouble(user_depth1);
							break;
						}
						//getting new data if given doesn't work
						catch(Exception e) {
							System.out.println("Invalid depth. Enter a depth: ");
							user_depth1 = input.nextLine();
						}
					}
					
					System.out.println("Enter the second depth: ");
					String user_depth2 = input.nextLine();
					Double depth2;
					
					//validating depth input
					while(true) {
						try {
							depth2 = Double.parseDouble(user_depth2);
							break;
						}
						//getting new data if given doesn't work
						catch(Exception e) {
							System.out.println("Invalid depth. Enter a depth: ");
							user_depth2 = input.nextLine();
						}
					}
					
					System.out.println(EarthquakeCollection.printByValue(EarthquakeCollection.searchByDepthRange(earthquakeList, depth1, depth2), new Earthquake.DepthSort()));	
				}
				
				//search by mag range
				if (command.equals(menuList[16])) {
					//getting mag information
					System.out.println("Enter first magnitude: ");
					String user_mag1 = input.nextLine();
					Double mag1;
					
					//validating mag input
					while(true) {
						try {
							mag1 = Double.parseDouble(user_mag1);
							break;
						}
						//getting new data if given doesn't work
						catch(Exception e) {
							System.out.println("Invalid depth. Enter a depth: ");
							user_mag1 = input.nextLine();
						}
					}
					
					System.out.println("Enter magnitude: ");
					String user_mag2 = input.nextLine();
					Double mag2;
					
					//validating mag input
					while(true) {
						try {
							mag2 = Double.parseDouble(user_mag2);
							break;
						}
						//getting new data if given doesn't work
						catch(Exception e) {
							System.out.println("Invalid depth. Enter a depth: ");
							user_mag2 = input.nextLine();
						}
					}
					
					System.out.println(EarthquakeCollection.printByValue(EarthquakeCollection.searchByMagRange(earthquakeList, mag1, mag2), new Earthquake.MagSort()));	
				}
				
				//search by location RANGE
				if (command.equals(menuList[17])) {
					//getting latitude information
					System.out.println("Enter the first latitude: ");
					String user_lat1 = input.nextLine();
					Double lat1;
					
					//validating the latitude input
					while(true) {
						try {
							lat1 = Double.parseDouble(user_lat1);
							break;
						}
						//getting new data if given doesn't work
						catch(Exception e) {
							System.out.println("Invalid latitude. Enter a latitude: ");
							user_lat1 = input.nextLine();
						}
					}
					
					System.out.println("Enter the second latitude: ");
					String user_lat2 = input.nextLine();
					Double lat2;
					
					//validating the latitude input
					while(true) {
						try {
							lat2 = Double.parseDouble(user_lat2);
							break;
						}
						//getting new data if given doesn't work
						catch(Exception e) {
							System.out.println("Invalid latitude. Enter a latitude: ");
							user_lat2 = input.nextLine();
						}
					}
					
					//getting longitude information
					System.out.println("Enter the first longitude: ");
					String user_long1 = input.nextLine();
					Double long1;
					
					//validating longitude input
					while(true) {
						try {
							long1 = Double.parseDouble(user_long1);
							break;
						}
						//getting new data if given doesn't work
						catch(Exception e) {
							System.out.println("Invalid longitude. Enter a longitude: ");
							user_long1 = input.nextLine();
						}
					}
					
					//getting longitude information
					System.out.println("Enter the second longitude: ");
					String user_long2 = input.nextLine();
					Double long2;
					
					//validating longitude input
					while(true) {
						try {
							long2 = Double.parseDouble(user_long2);
							break;
						}
						//getting new data if given doesn't work
						catch(Exception e) {
							System.out.println("Invalid longitude. Enter a longitude: ");
							user_long2 = input.nextLine();
						}
					}
					
					System.out.println(EarthquakeCollection.printByValue(EarthquakeCollection.searchByLocationRange(earthquakeList, long1, long2, lat1, lat2), new Earthquake.LocationSort()));
				}
				
				//search date range FIX
				if (command.equals(menuList[18])) {
					//format on how we want our date
					String date_format = "yyyy-MM-dd";
					DateFormat date1 = new SimpleDateFormat(date_format);
					
					//asking for information
					System.out.println("Enter the first date to search by (yyyy-MM-dd): ");
					String in_date1 = input.nextLine();	
					
					//validating input of the date
					while(true) {
						try {
							date1.parse(in_date1);
							break;
						}
						//asking for new date if given isnt what we want
						catch(Exception e) {
							System.out.println("Invalid Date. Enter a date (yyyy-MM-dd): ");
							in_date1 = input.nextLine();
						}
					}
					
					DateFormat date2 = new SimpleDateFormat(date_format);
					
					//asking for information
					System.out.println("Enter the second date to search by (yyyy-MM-dd): ");
					String in_date2 = input.nextLine();	
					
					//validating input of the date
					while(true) {
						try {
							date2.parse(in_date2);
							break;
						}
						//asking for new date if given isnt what we want
						catch(Exception e) {
							System.out.println("Invalid Date. Enter a date (yyyy-MM-dd): ");
							in_date2 = input.nextLine();
						}
					}
					
					System.out.println(EarthquakeCollection.printByValue(EarthquakeCollection.searchByDateRange(earthquakeList, in_date1, in_date2), new Earthquake.DateSort()));
				}
				
				//stop
				if (command.equals(menuList[19])) {
					System.out.println("Thanks have a nice day");
					input.close();
					break;
				}	
			}
			//user command isn't part of list of choices
			else {
				System.out.println("Invalid Command");
			}
		}
	}
}

