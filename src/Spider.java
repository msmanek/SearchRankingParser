import java.awt.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.io.*;
import jsoup-1.8.3.jar;

public class Spider {
	private static final int _MAX_PAGES_TO_SEARCH_ = 3;
	private Set<String> pagesVisited = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();
    
    public static void main(String[] args) {
    	System.out.print("Hello World");
    }
    
    private String nextURL() {
    	String nextUrl;
    	
    	do {
    		
    	} while(this.pagesVisited.contains(nextUrl));
    }
}
