import java.util.LinkedList;
import java.util.HashSet;

public class Spider {
	private static final int _MAX_PAGES_TO_SEARCH_ = 3;
	private HashSet<String> pagesVisited = new HashSet<String>();
    private LinkedList<String> pagesToVisit = new LinkedList<String>();
        
    private String nextUrl() {
		String nextUrl;
		do{
		    nextUrl = this.pagesToVisit.remove(0);
		} while(this.pagesVisited.contains(nextUrl));
		
		this.pagesVisited.add(nextUrl);
		
		return nextUrl;
    }//end nextUrL function
}//end Spider class
