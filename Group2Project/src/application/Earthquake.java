package application;

import java.util.Comparator;

public class Earthquake{
	
	//data fields
	public  String time;
	public  String latitude;
	public  String longitude;
	public  String depth;
	public  String mag;
	public  String magType;
	public  String nst;
	public  String gap;
	public  String dmin;
	public  String rms;
	public  String net;
	public  String id;
	public  String updated;
	public  String place;
	public  String type;
	public  String locationSource;
	public  String magSource;
	public  String horizontalError;
	public  String depthError;
	public  String magError;
	public  String magNst;
	public  String status;

	//fixing how data loads, incorrectly placed compared to CSV file
	public Earthquake (String time, String latitude, String longitude, String depth, String mag, String magType, String nst, String gap, String dmin, String rms, 
			String net, String id, String updated, String place, String type, String horizontalError, String depthError, String magError, String magNst,
			String status, String locationSource, String magSource) {
		// Variable declaration
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.depth = depth;
		this.mag = mag;
		this.magType = magType;
		this.nst = nst;
		this.gap = gap;
		this.dmin = dmin;
		this.rms = rms;
		this.net = net;
		this.id = id;
		this.updated = updated;
		this.place = place;
		this.type = type;
		this.horizontalError = horizontalError;
		this.depthError = depthError;
		this.magError = magError;
		this.magNst = magNst;
		this.status = status;
		this.locationSource = locationSource;
		this.magSource = magSource;
	}
	
	//toString method
	@Override
	public String toString() {
		//formatting string according to the CSV file
		String newString = "Time: " + this.time;
		newString += "\nLatitude: " + this.latitude;
		newString += "\nLongitude: " + this.longitude;
		newString += "\nDepth: " + this.depth;
		newString += "\nMagnitude: " + this.mag;
		newString += "\nMagnitude Type: " + this.magType;
		newString += "\nNST: " + this.nst;
		newString += "\nGap: " + this.gap;
		newString += "\nDMinutes: " + this.dmin;
		newString += "\nRMS: " + this.rms;
		newString += "\nNet: " + this.net;
		newString += "\nID: " + this.id;
		newString += "\nUpdated: " + this.updated;
		newString += "\nPlace: " + this.place.substring(1);
		newString += "\nType: " + this.type;
		newString += "\nHorizontal Error: " + this.horizontalError;
		newString += "\nDepth Error: " + this.depthError;
		newString += "\nMagnitude Error: " + this.magError;
		newString += "\nMagnitude NST: " + this.magNst;
		newString += "\nStatus: " + this.status;
		newString += "\nLocation Source: " + this.locationSource;
		newString += "\nMagnitude Source: " + this.magSource;
		newString += "\n";
 		
		return newString;	
	}
	
	//getter methods
		public String getTime() { return time;}
		public String getLatitude() { return latitude;}
		public String getLongitude() {return longitude;}
		public String getDepth() {	return depth;}
		public String getMag() { return mag;}
		public String getMagType() { return magType;}
		public String getNst() { return nst;}
		public String getGap() { return gap;}
		public String getDmin() { return dmin;}
		public String getRms() { return rms;}
		public String getNet() { return net;}
		public String getID() { return id;}
		public String getUpdated() { return updated;}
		public String getPlace() { return place;}
		public String getType() { return type;}
		public String getMagSource() { return magSource;}
		public String getLocationSource() { return locationSource;}
		public String getHorizontalError() { return horizontalError;}
		public String getDepthError() { return depthError;}
		public String getMagError() { return magError;}
		public String getMagNst() { return magNst;}
		public String getStatus() { return status;}
		
		//Setter methods
		public void setTime(String dateStr)throws Exception {
			this.time = dateStr;
		}
		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}
		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		public void setDepth(String depth) {
			this.depth = depth;
		}
		public void setMag(String mag) {
			this.mag = mag;
		}
		public void setMagType(String magType) {
			this.magType = magType;
		}
		public void setNst(String nst) {
			this.nst = nst;
		}
		public void setGap(String gap) {
			this.gap = gap;
		}
		public void setDmin(String dmin) {
			this.dmin = dmin;
		}
		public void setRms(String rms) {
			this.rms = rms;
		}
		public void setNet(String net) {
			this.net = net;
		}
		public void setId(String id) {
			this.id = id;
		}
		public void setUpdated(String updatedStr) {
			this.updated = updatedStr;
		}
		public void setPlace(String place) {
			this.place = place;
		}
		public void setType(String type) {
			this.type = type;
		}
		public void setHorizontalError(String horizontalError) {
			this.horizontalError = horizontalError;
		}
		public void setDepthError(String depthError) {
			this.depthError = depthError;
		}
		public void setMagError(String magError) {
			this.magError = magError;
		}
		public void setMagNst(String magNst) {
			this.magNst = magNst;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public void setLocationSource(String locationSource) {
			this.locationSource = locationSource;
		}
		public void setMagSource(String magSource) {
			this.magSource = magSource;
		}
		
		// Sort by depth
		static class DepthSort implements Comparator<Earthquake>{

			@Override
			public int compare(Earthquake e1, Earthquake e2) {
				//comparing depths
				double depth1 = Double.parseDouble(e1.getDepth());
				double depth2 = Double.parseDouble(e2.getDepth());
				
				return Double.compare(depth1, depth2);
			}
		}
		
		// Sort by magnitude
		static class MagSort implements Comparator<Earthquake>{

			@Override
			public int compare(Earthquake e1, Earthquake e2) {
				return Double.compare(Double.parseDouble(e1.getMag()), Double.parseDouble(e2.getMag()));
			}
			
		}
		
		// Sort by status
		static class StatusSort implements Comparator<Earthquake>{

			@Override
			public int compare(Earthquake e1, Earthquake e2) {
				return e1.getStatus().compareTo(e2.getStatus());
			}
		}
		
		// Sort by place
		static class PlaceSort implements Comparator<Earthquake>{

			@Override
			public int compare(Earthquake e1, Earthquake e2) {
				String[] e1_place = e1.getPlace().split(", ");
				String[] e2_place = e2.getPlace().split(", ");
				
				return e1_place[1].compareTo(e2_place[1]);
			}	
		}
		
		//sorting by date
		static class DateSort implements Comparator<Earthquake>{

			@Override
			public int compare(Earthquake e1, Earthquake e2) {
				// TODO Auto-generated method stub
				return e1.time.compareTo(e2.time);
			}
		}
		
		//sorting by mag type
		static class MagTypeSort implements Comparator<Earthquake>{

			@Override
			public int compare(Earthquake e1, Earthquake e2) {
				// TODO Auto-generated method stub
				return e1.getMagType().compareTo(e2.getMagType());
			}
		}
				
		//sorting by long and alt
		static class LocationSort implements Comparator<Earthquake>{

			@Override
			public int compare(Earthquake e1, Earthquake e2) {
				// TODO Auto-generated method stub
				int latitudeAns = Double.compare(Double.parseDouble(e1.getLatitude()), Double.parseDouble(e2.getLatitude()));
						
				//checking if latitudes are different
				if (latitudeAns != 0) {
					return latitudeAns;
				}
						
				//if they are the same, compare longitude
				return Double.compare(Double.parseDouble(e1.getLongitude()), Double.parseDouble(e2.getLongitude()));
			}
		}
}
