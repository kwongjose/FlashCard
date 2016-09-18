import java.awt.Desktop;
import java.net.URL;
import java.util.ArrayList;
/**
 * class has hardcoded websites in arraylist
 * sends users default browser to a random site from list
 * 
 * @author Joe
 *
 */

public class BreakSite {

	private static String url;
	
    	 BreakSite(){
		 makeList();	
	}
    	 
    	 
	/**
	 * method makes hardcoded list of sites for break
	 * calls openWebpage to random site.
	 */
	@SuppressWarnings("unchecked")
	public void makeList(){
		@SuppressWarnings("rawtypes")
		ArrayList<String> messages = new ArrayList();
		messages.add("http://www.staggeringbeauty.com/");
		messages.add("http://www.youtube.com/watch?v=eh7lp9umG2I");
		messages.add("http://www.reddit.com/");
		messages.add("http://www.hristu.net/");
		messages.add("http://www.partridgegetslucky.com/");
		messages.add("https://www.facebook.com/");
		messages.add("https://www.facebook.com/joseph.kwong.33");
		messages.add("http://www.sanger.dk/");
		messages.add("http://www.trypap.com/");
		messages.add("http://www.reddit.com/r/programming/");
		messages.add("http://starwars.wikia.com/wiki/Main_Page");
		
		
		int size = messages.size();
		int mesg = (int)(Math.random()*size);
		 url = (String)messages.get(mesg);
		
		openWebpage(url);
		
	}
	
	
	/**
	 * method takes in a url as a string and opens a browser to that page
	 * @param urlString
	 */
	public static void openWebpage(String urlString) {
	    try {
	        Desktop.getDesktop().browse(new URL(urlString).toURI());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}