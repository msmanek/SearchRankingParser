
public class SearchTarget {
	
	private String searchKeywords;
	private String websiteToFind;
	
	//constructors
	public SearchTarget(String website, String keywords) {
		this.searchKeywords = keywords;
		this.websiteToFind = website;
	}
	public SearchTarget() {
		this.searchKeywords = null;
		this.websiteToFind = null;
	}
	
	//getters
	public String getSearchKeywords() { return this.searchKeywords; }
	public String getWebsiteToFind() { return this.websiteToFind; }
	public String[] getKeywordArray() { return this.getSearchKeywords().split(" "); }

}//end SearchTarget class
