import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
/**
 * class takes in a text file
 * each line is scanned and broken up to determine type of question and then to construct the qustion_answer object
 * parts of questions are separated by the char :
 * @author Joe
 *
 */

public class Loader {

	public ArrayList<Qustion_Answer> fQandA;
	private Scanner scant;
	public boolean test;
	
	public   Loader(File file) throws IOException {
		test = false;
		try {
			
			//BufferedReader br = new BufferedReader(new FileReader(file));
			
			fQandA = new ArrayList<Qustion_Answer>();
			
			Scanner scan = new Scanner(file);
			
			while( scan.hasNext()  ){
				
				String qustionData = scan.nextLine(); //.next() returns next saved question
			  
				 scant = new Scanner(qustionData);
			    scant = scant.useDelimiter(":");
			 
			 String type = scant.next().trim().toLowerCase(); 
					 
			 	if(type.length() < 2 ) {//if 1 then question is short answer
				  
			 		
			 		String q = scant.next(); 
					String a = scant.next(); 
			        Qustion_Answer temp = new Qustion_Answer(q, a);
				    fQandA.add(temp);	
				 
			 }
			 
			 	else if(type.length() > 1 ){//if 2 than question is multichioce
			 		
			 		String q = scant.next(); 
			 		ArrayList<String> choices = new ArrayList<String>();
			 		
			 		//loop 5 times for questions
			 		for(int i = 0; i < 5; i++){
			 			String a = scant.next();
			 			choices.add(a );
			 		}//end for
			 		String ci = scant.next().trim(); 
			 		int correctIndex = Integer.parseInt( ci );
			 		
			 	 Qustion_Answer temp = new Qustion_Answer(q, choices, correctIndex);
				 fQandA.add(temp); }//end multichioce
			 
			  else {   //if question type can not be found
				 throw  new Exception();  }
  
			   }//end while loop	
			scan.close(); scant.close();
		test = true;
		} 
		catch (Exception e){
			e.printStackTrace();
			JOptionPane option = new JOptionPane("There was a problem reading in the File And it wont run");
			JDialog  dialog = option.createDialog("Well...This isn't good.");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			return;
		}
		
		
		
		
		
		
		
	}
	
	
}
