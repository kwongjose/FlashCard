import java.awt.Image;
import java.util.ArrayList;


public class Qustion_Answer {
/**
 * class has two constructors for both short answer and multi-choice qustions
 * 
 */
	
	
	
	public String answer, qustion;
	public ArrayList<String> choices;
	public boolean inputAnswer, multiAnswer, asked;
	public int answerIndex;
	
	
	/**
	 * 
	 * constructor for short answer
	 * 
	 */
	Qustion_Answer( String q, String a ){
		
		multiAnswer = false;
		inputAnswer = false;
		asked = false;
		qoury(q);
		answer(a);
		}
	
	/**
	 * 
	 * constructor for muliple choice qustions
	 * q = qustion, a = list of possible answers, i = index of correct answers
	 */
	
	Qustion_Answer(String q, ArrayList<String> a, int i){
		
		multiAnswer = true;
		inputAnswer = false;
		asked = false;
		choices = a;
		answerIndex = i;
		answer(choices.get(i-1)); //sets answer to correct index of arraylist
		qoury(q);
		}
	
	/**
	 * constructor for futur updates take in a image type and and description for idification
	 */
	
		Qustion_Answer(Image s, String d){
			
			
		}
	
	/**
	 * 
	 * Takes in a String that is the qustion
	 */
	private void qoury(String s){
		
		qustion = s;
		}
	/**
	 * Takes in a String for Answer
	 */
	private void answer(String s){
		
		answer = s;
		}
	/**
	 * 
	 * @return the correct answer
	 */
	public String getAnswer(){
		
		return answer;
		}
	/**
	 * 
	 * @return the qustion
	 */
	public String getQustion(){
		
		return qustion;
		}
	/**
	 * 
	 * @return if inputAnswer is correct return true
	 */
	public boolean getResult(){
		
		return inputAnswer;
		}
	/**
	 * user selected correct answer
	 */
	public void setCorrect(){
		
		inputAnswer = true;
		}
	/**
	 * user selected wrong answer
	 */
	public void setWrong(){
		
		inputAnswer = false;
		}
	
	/**
	 * 
	 * @return List of possible answers for muli-choice qustions
	 * this will be called to show possible qustion types
	 */
	public ArrayList<String> getChoices(){
		
		return choices;		
		}
	
	/**
	 * 
	 * @return the type of qustion 
	 * returns true if multichioce
	 */
	public boolean getType(){
		
		return multiAnswer;
		}
	
	
	public String toString(){
		
		return "Qustion: " + qustion  + " Answer: " + answer;
		}
	
	/**
	 * 
	 * @return true when question been asked
	 */
	public boolean beenAsked(){
		
		return asked;
		}
	/**
	 * 
	 * @param t set the question to asked
	 */
	public void setAsked(boolean t){
		
		asked = t;
	}
	/**
	 * 
	 * @return the index of the correct answer for a  multichoice qustions
	 */
	
	public int getIndexOfAnswer(){
		
		return answerIndex;
		
	}
}
