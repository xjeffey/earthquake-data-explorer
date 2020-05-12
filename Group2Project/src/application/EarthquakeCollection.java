package application;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class EarthquakeCollection {
	

	
	//toString() method that says the data size of the earthquake arrayList
	public String toString(ArrayList<Earthquake> quakes) {
		String reply = "The earthquake data size is: ";
		
		reply += "" + quakes.size();
		
		return reply;
		
	}
	
	//Prints out all explanations of each command
	public static String help() {
		String help = "the summary command prints out a summary of the data and the collection";
		help += "\nthe print command prints out all earthquake events";
		help += "\nthe printByDate prints all earthquakes sorted by date";
		help += "\nthe printByDepth prints all earthquakes sorted by depth";
		help += "\nthe printByMag prints all earthquakes sorted by magnitude";
		help += "\nthe printByPlace prints all earthquakes sorted by place";
		help += "\nthe printByStatus prints all earthquakes sorted by status";
		help += "\nthe searchDate command uses a date and finds earthquakes occuring during the entered date";
		help += "\nthe searchLocation command searches for earthquakes occuring at the entered location";
		help += "\nthe searchDepth command searches for earthquakes at the entered depth";
		help += "\nthe searchMag command searches for earhtquakes with the entered mag";
		help += "\nthe searchMagType command searches for earthquakes with the entered magType";
		help += "\nthe searchPlace command searches for earthquakes located at the entered place";
		help += "\nthe searchStatus command searches for earthquakes with the entered status";
		help += "\nthe searchDepthRange command searches for earthquakes in that depth range";
		help += "\nthe searchMagRange command searches for earthquakes in a range of magnitudes";
		help += "\nthe searchLocationRange command searches for earthquakes within a range of lattitudes and longitudes";
		help += "\nthe searchDateRange command searches for earthquakes within a range of dates";
		help += "\nthe stop function exits the program";
		return help;

	}
	
	//prints number of events and the date range
	public static String summary(ArrayList<Earthquake> quakes) throws FileNotFoundException {
		String summary = "Number of events: ";
		
		//ArrayList<Earthquake> newList = CsvOpen.StringCSVOpener();
		int intCounter = 0;
		
		for(int i = 0; i < quakes.size(); i++) {
			intCounter += 1;
		}
		summary += intCounter;
		summary += "\nDate Range of events: \n";
		String dateBetween = CsvOpen.returnTimeLine(quakes);
		summary += "\n" + dateBetween;
		return summary;
	}
	
	
	//printing information of earthquakes from given list of earthquakes
	public static String printAll(ArrayList<Earthquake> quakes) {
		String output = "";
		
		//checking if anything was found
		if(quakes.size() == 0) {
			return "No results found";
		}
		
		//looping through all the earthquakes
		for(Earthquake e : quakes) {
			//adding each earthquake to the string
			output += e.toString() + "\n";
		}
		
		//returning the string
		return output;
	}
	
	//searching for earthquakes by certain date
	public static ArrayList<Earthquake> searchByDate (ArrayList<Earthquake> earthquakeList, String search_date) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		//looping through each earthquake
		for(Earthquake e : earthquakeList) {
			//just getting the YYYY-mm-dd
			String date = e.time.substring(0, 10);
			
			//dates match
			if(date.equalsIgnoreCase(search_date)) {
				result.add(e);
			}
		}

		return result;
	}
	
	//searching for earthquakes between 2 date ranges
	public static ArrayList<Earthquake> searchByDateRange (ArrayList<Earthquake> earthquakeList, String d1, String d2) throws ParseException{
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		
		//looping through each earthquake
		for(Earthquake e : earthquakeList) {
			String date = e.time.substring(0, 10);
			
			if(date.compareTo(d1) >= 0 && date.compareTo(d2) <= 0) {
				result.add(e);
			}
		}

		return result;
	}
	
	//searching for earthquakes by a specific depth
	public static ArrayList<Earthquake> searchByDepth(ArrayList<Earthquake> earthquakeList, double search_depth) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		//looping through each earthquake
		for(Earthquake e : earthquakeList) {
			//converting the earthquakes depth to a double to compare values
			double depth = Double.parseDouble(e.getDepth());
			
			//matches the depth
			if(depth == search_depth) {
				result.add(e);
			}
		}

		return result;
	}
	
	//searching for earthquakes between 2 depth ranges
	public static ArrayList<Earthquake> searchByDepthRange(ArrayList<Earthquake> earthquakeList, double d1, double d2) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		for(Earthquake e : earthquakeList) {
			double depth = Double.parseDouble(e.getDepth());
			
			if (depth >= d1 && depth <= d2) {
				result.add(e);
			}
		}
		
		return result;
	}

	//SearchByMag will take a mag argument go through the array list and see if any earthqauke has the same mag as the argument and prints out the data of the earthquake
	public static  ArrayList<Earthquake> searchByMag(ArrayList<Earthquake> earthquakeList, double search_mag) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		//looping through each earthquake
		for(Earthquake e : earthquakeList) {
			
			//converting the earthquakes mag to a double to compare values
			double mag = Double.parseDouble(e.mag);
					
			//matches the mag
			if(mag == search_mag) {
				result.add(e);
			}
		}
		
		return result;
	}
	
	//finding earthquakes between 2 mags
		public static  ArrayList<Earthquake> searchByMagRange(ArrayList<Earthquake> earthquakeList, double m1, double m2) {
			ArrayList<Earthquake> result = new ArrayList<Earthquake>();
			
			//looping through each earthquake
			for(Earthquake e : earthquakeList) {
				
				//converting the earthquakes mag to a double to compare values
				double mag = Double.parseDouble(e.mag);
						
				//matches the mag
				if(mag >= m1 && mag <= m2) {
					result.add(e);
				}
			}
			
			return result;
		}
	
	//SearchByMagType seaches through earthquakes to find matching mag type wanted
	public static  ArrayList<Earthquake> searchByMagType(ArrayList<Earthquake> earthquakeList, String search_mag_type) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		//looping through each earthquake
		for(Earthquake e : earthquakeList) {
			
			//matches the mag type
			if(e.magType.equalsIgnoreCase(search_mag_type)) {
				result.add(e);
			}
		}

		return result;
	}
	
	//SearchByLocation takes two arguments, longitude and latitude, and tries to find the earthquake that matches those arguments and prints the data
	public static  ArrayList<Earthquake> searchByLocation(ArrayList<Earthquake> earthquakeList, double search_lat, double search_lon) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		//looping through each earthquake
		for(Earthquake e : earthquakeList) {
			//converting the earthquakes long and lat to a double to compare values
			double lon = Double.parseDouble(e.getLongitude());
			double lat = Double.parseDouble(e.getLatitude());
			
			//long and lat matches
			if(lon == search_lon && lat == search_lat) {
				result.add(e);
			}
		}

		return result;
	}
	
	//looking for earthquakes between 2 locations
		public static  ArrayList<Earthquake> searchByLocationRange(ArrayList<Earthquake> earthquakeList, double lon1, double lon2, double lat1, double lat2) {
			ArrayList<Earthquake> result = new ArrayList<Earthquake>();
			
			//looping through each earthquake
			for(Earthquake e : earthquakeList) {
				//converting the earthquakes long and lat to a double to compare values
				double lon = Double.parseDouble(e.getLongitude());
				double lat = Double.parseDouble(e.getLatitude());
				
				//long and lat between values
				if(lon >= lon1 && lon <= lon2 && lat >= lat1 && lat <= lat2) {
					result.add(e);
				}
			}

			return result;
		}
	
	//SearchByPlace can take an argument and it can be a direction, city, or distance. If the earthquake list contains pieces of the information wanted, it prints earthquake data
	public static  ArrayList<Earthquake> searchByPlace(ArrayList<Earthquake> earthquakeList, String search_place) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		//looping through each earthquake
		for(Earthquake e : earthquakeList) {
			//part of word given is in the earthquake's place
			if(e.place.contains(search_place)) {
				result.add(e);
			}
		}

		return result;
	}
	
	//SearchByStatus would loop through the arrayList and try to find the status of each earthquake, prints out data if there is a match
	public static  ArrayList<Earthquake> searchByStatus(ArrayList<Earthquake> earthquakeList, String search_status) {
		ArrayList<Earthquake> result = new ArrayList<Earthquake>();
		
		//looping through each earthquake
		for(Earthquake e : earthquakeList) {
			//status matches earthquake's status
			if(e.status.equalsIgnoreCase(search_status)) {
				result.add(e);
			}
		}

		return result;
	}
	
	//printing out earthquake data by a specific value
	public static String printByValue(ArrayList<Earthquake> earthquakes, Comparator c) {
		//creating copy of arraylist
		ArrayList<Earthquake> copy = (ArrayList<Earthquake>) earthquakes.clone();
		
		//sorting the arraylist
		Collections.sort(copy, c);
		
		//creating string to show the data
		String reply = EarthquakeCollection.printAll(copy);
		
		return reply;
	}

	public static void main(String[] args) throws Exception {

  }
}
