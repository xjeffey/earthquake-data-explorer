package application;



import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class CsvOpen {

	//https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/ most code taken from webpage

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';
//    public static ArrayList<Earthquake> earthquakeList = new ArrayList<Earthquake>();
//    public static ArrayList<Earthquake> SecondearthquakeList = new ArrayList<Earthquake>();
    
    //function to load data from CSV into an ArrayList
    public static ArrayList<Earthquake> StringCSVOpener() {
    	
    	//arraylist to hold data from making objects of csv data
    	ArrayList<Earthquake> output = new ArrayList<Earthquake>();
    	
    	//file location
    	String csvFile = "./Data/all_month.csv";
    	
    	//TESTING USES THIS FILE
    	//String csvFile = "./Data/test_sample.csv";
    	
    	//creating file
    	java.io.File file = new java.io.File(csvFile);
    	
    	//determining if file exists
    	try {
    		//able to read data 
            Scanner input = new Scanner(file);
            input.nextLine();

            //checking for more lines in csv data
            while(input.hasNextLine()) {
            	//creating a list of strings from each row of data
            	List<String> line = parseLine(input.nextLine());
            	
            	//creating an earthquake object with each row
            	Earthquake newQuake = new Earthquake(line.get(0),line.get(1),line.get(2),line.get(3),line.get(4),line.get(5),line.get(6),line.get(7),line.get(8),line.get(9),line.get(10),
                		line.get(11),line.get(12),line.get(13),
                		line.get(14),line.get(15),line.get(16),line.get(17),line.get(18),line.get(19),line.get(20), line.get(21));
            	
            	output.add(newQuake);
            }
            input.close();
    	}
    	catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
        
        return output;   
    }

    //returns list of strings that is separated by commas
    public static List<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    //returns list of strings that is separated by commas
    public static List<String> parseLine(String cvsLine, char separators) {
        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
    }

    //returns list of strings that is separated by commas
    public static List<String> parseLine(String cvsLine, char separators, char customQuote) {
    	
    	//list to hold the data
        List<String> result = new ArrayList<>();

        //if empty, return an empty list
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        //considers a space as a quote
        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        //considers a space as a comma
        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        
        //assuming quote is on outside
        boolean inQuotes = false;
        
        //assume that we can't start adding characters
        boolean startCollectChar = false;
        
        //assuming that double quotes are on the outside
        boolean doubleQuotesInColumn = false;

        //breaking up the line from CSV file into a list of characters
        char[] chars = cvsLine.toCharArray();

        //looping through each character
        for (char ch : chars) {

        	//there is an inside quote
            if (inQuotes) {
            	
            	//allow to collect characters
                startCollectChar = true;
                //after finding 1 inside quote, restart the process
                if (ch == customQuote) {
                	//assume quotes on the outside of the string
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                    	//checking if there is an inside quote
                        if (!doubleQuotesInColumn) {
                        	//adding it to the list
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
            	//checking if the char is one of the identifers
                if (ch == customQuote) {
                	
                	//there is an inside quote
                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;

                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        //adding the chracters to list of strings
        result.add(curVal.toString());

        return result;
    }
    
    public static String returnTimeLine(ArrayList<Earthquake> quakeCollection) {
    	String timeBetween = "";
    	timeBetween = quakeCollection.get(0).time + " - " + quakeCollection.get(quakeCollection.size()-1).time;
    	return timeBetween;
    }
    
    public static void main(String[] args) throws Exception {
//        System.out.println(getDepth());
        CsvOpen.StringCSVOpener();
    }
}