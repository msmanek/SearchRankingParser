import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class SearchRankingsParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<SearchTarget> 
		
		
		printWelcomeMessage();
		
		
		
		
		Spider spider = new Spider();
		spider.search("http://arstechnica.com/", "Steve Jobs");


	}
	
	public static void printWelcomeMessage() {
		System.out.print("Search Engine Rankings Parser Bot\n" +
						"By: MohammedShabbar Manek\n\n");
	}//end printWelcomeMessage function
	
	
	public static ArrayList<SearchTarget> loadSitesAndKeywords() throws FileNotFoundException {
		File sitesAndKeywordsToParse = BasicFunctions.getFile("Enter the filename " +
				"of the CSV that has the sites and keywords");
		
		if(sitesAndKeywordsToParse == null) { return null; }
		
		BufferedReader fileInput = new BufferedReader(new FileReader(sitesAndKeywordsToParse));

		
	}//end loadSitesAndKeywords Function

}
