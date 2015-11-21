import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchRankingsParser {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ArrayList<SearchTarget> inputtedTargets = null;
		
		
		printWelcomeMessage();
		inputtedTargets = loadSitesAndKeywords();
		
		if(inputtedTargets == null) {
			System.out.print("\n\nGoodbye!");
			System.exit(0);
		}
		
		
		
//		Spider spider = new Spider();
//		spider.search("http://arstechnica.com/", "Steve Jobs");


	}
	
	public static void printWelcomeMessage() {
		System.out.print("Search Engine Rankings Parser Bot\n" +
						"By: MohammedShabbar Manek\n\n");
	}//end printWelcomeMessage function
	
	
	public static ArrayList<SearchTarget> loadSitesAndKeywords() throws IOException, FileNotFoundException {
		
		//initializing variables
		ArrayList<SearchTarget> sitesAndKeywords = new ArrayList<SearchTarget>();
		String inputRow;
		String[] splitInputRow;
		int totalTargetsCounter = 0;
		
		File sitesAndKeywordsToParse = BasicFunctions.getFile("Enter the filename " +
				"of the CSV that has the sites and keywords ");
		
		//if user cancels loading process, return null
		if(sitesAndKeywordsToParse == null) { return null; }
		
		BufferedReader fileInput = new BufferedReader(new FileReader(sitesAndKeywordsToParse));
		
		do {
			
			inputRow = fileInput.readLine();
			if(inputRow != null) {
				totalTargetsCounter++;
				splitInputRow = inputRow.split(",");
				
				//if the row is not the correct length, continue loop
				if(splitInputRow.length != 2) {
					System.out.printf("The row:\n%s\n has not been loaded because it is invalid", inputRow);
					continue;
				}
								
				sitesAndKeywords.add(new SearchTarget(splitInputRow[0], splitInputRow[1]));
				
			}//end if inputRow != null
						
		}while(inputRow != null);
		
		
		System.out.println();
				
		//output verifier text
		System.out.printf("\n\n%d targets loaded out of %d targets in the file.\n",
				sitesAndKeywords.size(), totalTargetsCounter);
		
		fileInput.close();
		
		return sitesAndKeywords;
		
	}//end loadSitesAndKeywords Function
	

}//end SearchRankingsParser class
