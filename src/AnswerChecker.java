/**
 * 
 * @author Joe
 * class takes in a Qustion_Answer object as well as a string
 * class check to see if answer stored in Qustio_Answer object matches String provied by caller
 */

public class AnswerChecker {
	
	public Qustion_Answer QustionToCheck;
	public String userAnswer, correctAnswer;
	
	AnswerChecker(Qustion_Answer qa, String s){
		
		QustionToCheck = qa;
		userAnswer = s.replaceAll("\\s","");  
		correctAnswer = QustionToCheck.getAnswer().replaceAll("\\s",""); 
		
	}
	
	/**
	 * 
	 * @return true if String input matches Answer from Qustion_Answer Object
	 */
	public boolean CheckAnswer(){
		String temU = userAnswer.toUpperCase().trim(); 
	String temC =	correctAnswer.toUpperCase().trim();
			
				
			return temU.equals(temC);
			
		
		
	}
	

}
