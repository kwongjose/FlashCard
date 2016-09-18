/**
 * This class takes an arraylist object 
 * it then stores it in a file or database form for later retrival.
 */


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class Saver {

	public PrintWriter writer;
	
	//constructor
	public Saver(ArrayList<Qustion_Answer> q, String fileName){
		
		try {
			saveFile(fileName, q);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void saveFile(String Name, ArrayList<Qustion_Answer> qAndA) throws FileNotFoundException, UnsupportedEncodingException{
		
	    writer = new PrintWriter(Name, "UTF-8");
		
		Iterator<Qustion_Answer> it = qAndA.iterator();
		
		while(it.hasNext()){
			
			Qustion_Answer temp = it.next();
			
			if( temp.getType() ){
				saveMultiChoice(temp);
			}
			else{
				saveShortAnser(temp);
			}
			
			}//end loop
		
			writer.close();
			JOptionPane option = new JOptionPane("Save compleate");
			JDialog  dialog = option.createDialog(" ");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
	
	}
	
	/**
	 * 
	 * takes a Qustion_Answer in and saves 
	 */
	private void saveShortAnser(Qustion_Answer temp){
		
		writer.println( "1 : " +   temp.getQustion() + " : " + temp.getAnswer() + ":" );
		}
	
	/*
	 * saves mulitchioce qustions to file
	 */
	private void saveMultiChoice(Qustion_Answer temp){
		
		
		String answerOptions = PrepAnswers( temp.getChoices().toString() );
		System.out.println(temp.choices);
		
		writer.println( "10 : " + temp.getQustion() +  " : " + answerOptions + " : " + temp.getIndexOfAnswer() + " : " );
		
	}
	
	/**
	 * 
	 * @param takes in string of choices set as "[ a, b, c, d, e]" 
	 * @return returns sting of answers as " a : b : c : d : e:"
	 */
	private String PrepAnswers(String s){
		
	String choices = s.replace("[", "");
	choices = s.replace("]", "");	
	
		Scanner scan = new Scanner(choices);
		String resetAn = "";
		
		resetAn = scan.next();
		
		while(scan.hasNext()){
			
			resetAn = resetAn + " : " + scan.next();
		}
		
		resetAn = resetAn.replace(",", "");
		resetAn = resetAn.replace("[", "");
		
		scan.close();
		return resetAn;
	}
	
	
	
	
}
