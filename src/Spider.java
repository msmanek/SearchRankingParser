import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider {
	private static final int MAX_PAGES_TO_SEARCH = 10;
	private Set<String> pagesVisited = new HashSet<String>();
	private List<String> pagesToVisit = new LinkedList<String>();
	private ArrayList<SearchTarget> targetsAndKeywords = new ArrayList<SearchTarget>();

	/**
	 * Our main launching point for the Spider's functionality. Internally it
	 * creates spider legs that make an HTTP request and parse the response (the
	 * web page).
	 * 
	 * @param url
	 *            - The starting point of the spider
	 * @param searchWord
	 *            - The word or string that you are searching for
	 */
	
	public Spider(ArrayList<SearchTarget> sT) {
		this.targetsAndKeywords = sT;
	}
	
	
	public void searchGoogle() {
		String url;
		StringBuilder urlBuilder;
		
		for(int i = 0; i < this.targetsAndKeywords.size(); i++) {
			url = buildGoogleUrl(this.targetsAndKeywords.get(i).getKeywordArray());			
		}
		
	}
	
	/**
	 * this function will create a google url for the first page of results
	 * of the keywords
	 * 
	 * @param a string array 
	 * @return a google url that will search for the keywords
	 */
	private String buildGoogleUrl(String[] keywords) {
		
		StringBuilder googleUrlBuilder = new StringBuilder("google.ca/#q=");
		
		
		for(int i = 0; i < keywords.length; i++) {
			googleUrlBuilder.append(keywords[i]);
			if(i + 1 < keywords.length)
				googleUrlBuilder.append("+");
		}
				
		return googleUrlBuilder.toString();
	}
	
	public void search(String url, String searchWord) {

		while (this.pagesVisited.size() < MAX_PAGES_TO_SEARCH) {

			String currentUrl;
			SpiderLeg leg = new SpiderLeg();

			if (this.pagesToVisit.isEmpty()) {
				currentUrl = url;
				this.pagesVisited.add(url);
			}// end if
			else
				currentUrl = this.nextUrl();

			leg.crawl(currentUrl); // Look at the crawl method in SpiderLeg

			boolean success = leg.searchForWord(searchWord);
			if (success) {
				System.out.println(String.format(
						"**Success** Word %s found at %s", searchWord,
						currentUrl));
				break;
			}

			this.pagesToVisit.addAll(leg.getLinks());
		}
		System.out.println("\n**Done** Visited " + this.pagesVisited.size()
				+ " web page(s)");
	}

	/**
	 * Returns the next URL to visit (in the order that they were found). We
	 * also do a check to make sure this method doesn't return a URL that has
	 * already been visited.
	 * 
	 * @return
	 */
	private String nextUrl() {
		String nextUrl;
		do {
			nextUrl = this.pagesToVisit.remove(0);
		} while (this.pagesVisited.contains(nextUrl));
		this.pagesVisited.add(nextUrl);
		return nextUrl;
	}// end nextUrl method

}// end Spider class

