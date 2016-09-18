import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.Font;
/*
 * class takes list of Q&A
 * displays q and ask for a input
 * then checks if correct
 * 
 */
import java.awt.Window;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class quizer extends JFrame {

	/**
	 * quizer class takes in a arraylist of qustion_Answer objects
	 * Ranmonizes the order of qustions in list
	 * tracks if quiz has been started and when last qustion in quiz has been compleated
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel shortAnswerUi, multiChoicePane;
	private ArrayList<JRadioButton> option;
	private ArrayList<Qustion_Answer> qustion_Anser;
	private JTextArea answerField, qustion ;
	private boolean start, done; //has start been pressed
	private int qustionIndex ;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton choice1, choice2, choice3, choice4, choice5;
	private String userAnswer;
	private AnswerChecker checker;

	/**
	 * Create the frame.
	 */
	public quizer( ArrayList<Qustion_Answer> q) {
		
		start = false;
		 qustion_Anser = q;
		
		//RANDOMIZES QUSTION LIST. COMMENTED OUT FOR DEV PURPOS.
		Collections.shuffle(qustion_Anser, new Random(qustion_Anser.size() )	); 
		
		setBounds(100, 100, 727, 465);
		shortAnswerUi = new JPanel();
		shortAnswerUi.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(shortAnswerUi);
		shortAnswerUi.setLayout(null);
		
		qustion = new JTextArea("");
		qustion.setFont(new Font("SansSerif", Font.PLAIN, 15));
		qustion.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		qustion.setBounds(0, 13, 697, 57);
		shortAnswerUi.add(qustion);
		 qustion.setEditable(false);
		
		JButton btnDone = new JButton("Next");
		btnDone.addActionListener(new ActionListener() {
			
			/*checks if correct answer to qustion
			 * if correct marks true in Q&A objc
			 * advance to next qustion
			 * if last Q display total correct out of total answer
			 */
			public void actionPerformed(ActionEvent arg0) {		
				
			
				if(start  && !(done) ){  //has qustions startedf
					
					
					if( !(qustion_Anser.get(qustionIndex).getType() ) 	){  //set userAnswer to answer entered by user in text field
						userAnswer =  answerField.getText(); 
						
					}
					
					if(qustionIndex < qustion_Anser.size()-1){  //is it last qustion
						
						
						checker = new AnswerChecker(qustion_Anser.get(qustionIndex), userAnswer);///checks stored answer to user answer
						
							if( checker.CheckAnswer() ){
								
								//code for correct answer	
								message("CORRECT! GOOD JOB", "AWESOME!!");
								qustion_Anser.get(qustionIndex).setCorrect(); 
								answerField.setText("");
							}
							else{
								//code for wrong answer
								message("Correct Answer: " + qustion_Anser.get(qustionIndex).getAnswer() 
										+ "  Your Answer: " + userAnswer, "Wrong" ); 
								answerField.setText("");
							}
							//advance next qustion
							qustionIndex++;
							
							Qustion_Answer temp = qustion_Anser.get(qustionIndex);
							boolean type = temp.getType();
						
							if(type ){ //if type is true send to multichoice
								buttonGroup.clearSelection();
							  multiChoice(temp);
								}
							else{
								shortAnswer(temp);
							}
							
					}
					else{
						
						if( qustion_Anser.get(qustionIndex).getType() 	){ //set userAnser to answer inputed by user in text field
							userAnswer =  answerField.getText();
						}
						 
						checker = new AnswerChecker(qustion_Anser.get(qustionIndex), userAnswer);///checks stored answer to user answer
						
						if( (checker.CheckAnswer() ) ){//if answer is correct
							
							
							//code for correct answer	
							message("CORRECT! GOOD JOB", "AWESOME!!");
							qustion_Anser.get(qustionIndex).setCorrect(); 
							
						}
						else{
							//code for wrong answer
							message("Correct Answer: " + qustion_Anser.get(qustionIndex).getAnswer() 
									+ "  Your Answer: " + userAnswer, "Wrong" );
						}
						//display quiz results
						message(quizResult(qustion_Anser), "Done!");
						done = true;
						
						
					}//end last qustion 
					
				}///end if start has been pressed
				
				
				
			}//end next button
			
		} );
		final JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(332, 98, 56, 16);
		shortAnswerUi.add(lblAnswer);
		
		
		btnDone.setBounds(125, 342, 97, 25);
		shortAnswerUi.add(btnDone);
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			
			/**
			 * checks to see if Start is true
			 * if not set to true
			 * check qustin type of first qustion then display qustions
			 */
			public void actionPerformed(ActionEvent e) {
				
				
				if ( !(start )){
					qustionIndex = 0;
					start = true;
					
					Qustion_Answer temp = qustion_Anser.get(qustionIndex);
					boolean type = temp.getType();
				
					if(type ){
					  multiChoice(temp);
						}
					else{
						shortAnswer(temp);
					}
				
					}	
			}
		});
		
		btnStart.setBounds(251, 342, 97, 25);
		shortAnswerUi.add(btnStart);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			
			/**
			 * restarts qustionIndex 
			 * Quiz is then re suffeled and user is quized
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				qustionIndex = 0;
				done = false;
					
				//Randomizes quiz qustions
				Collections.shuffle(qustion_Anser, new Random(qustion_Anser.size() )	); 
				
				Qustion_Answer temp = qustion_Anser.get(qustionIndex);
				answerField.setText("");
				boolean type = temp.getType();
			
				if(type){
				  multiChoice(temp);
					}
				else{
					shortAnswer(temp); 
					}
	
			}
			
		});
		btnRestart.setBounds(381, 342, 97, 25);
		shortAnswerUi.add(btnRestart);
		/**
		 * sends to study break for some fun!!!
		 */
		JButton btnStudyBreak = new JButton("Study Break!!");
		btnStudyBreak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new BreakSite();
				
			}
		});
		btnStudyBreak.setBounds(274, 380, 178, 25);
		shortAnswerUi.add(btnStudyBreak);
		
		 multiChoicePane = new JPanel();
		multiChoicePane.setBounds(16, 126, 687, 169);
		shortAnswerUi.add(multiChoicePane);
		multiChoicePane.setVisible(false);
		
		choice1 = new JRadioButton("");
		choice1.setBackground(Color.WHITE);
		choice1.setBorderPainted(true);
		choice1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		choice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				userAnswer = choice1.getText();
			}
		});
		multiChoicePane.setLayout(new GridLayout(0, 1, 0, 0));
		buttonGroup.add(choice1);
		multiChoicePane.add(choice1);
		
		 choice2 = new JRadioButton("");
		 choice2.setBackground(Color.WHITE);
		 choice2.setBorderPainted(true);
		 choice2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		 choice2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		userAnswer = choice2.getText();
		 	}
		 });
		buttonGroup.add(choice2);
		multiChoicePane.add(choice2);
		
		choice3 = new JRadioButton("");
		choice3.setBackground(Color.WHITE);
		choice3.setBorderPainted(true);
		choice3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		choice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userAnswer = choice3.getText();
			}
		});
		buttonGroup.add(choice3);
		multiChoicePane.add(choice3);
		
		choice4 = new JRadioButton("");
		choice4.setBackground(Color.WHITE);
		choice4.setBorderPainted(true);
		choice4.setFont(new Font("SansSerif", Font.PLAIN, 15));
		choice4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userAnswer = choice4.getText();
			}
		});
		buttonGroup.add(choice4);
		multiChoicePane.add(choice4);
		
		choice5 = new JRadioButton("");
		choice5.setBackground(Color.WHITE);
		choice5.setBorderPainted(true);
		choice5.setFont(new Font("SansSerif", Font.PLAIN, 15));
		choice5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userAnswer = choice5.getText();
			}
		});
		buttonGroup.add(choice5);
		multiChoicePane.add(choice5);
		 option = new ArrayList<JRadioButton>();
		option.add(choice1) ; option.add(choice2); option.add(choice3); option.add(choice4); option.add(choice5); //array of multichoice options
 
 answerField = new JTextArea();
 answerField.setBounds(16, 126, 687, 110);
 shortAnswerUi.add(answerField);
 answerField.setFont(new Font("SansSerif", Font.PLAIN, 15));
 answerField.setColumns(10);
 answerField.setLineWrap(true);
 
 
 /**
  * Moves back to window GUI for user to load new quiz 
  */
 JButton NewQuiz = new JButton("New Quiz");
 NewQuiz.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		start = false; done = false;
 		window.frame.setVisible(true);
 		//close quizer 
 		Window w = SwingUtilities.getWindowAncestor(shortAnswerUi);
 		qustion_Anser.clear();
 		w.setVisible(false	);

 	}
 });
 
 
 
 NewQuiz.setBounds(507, 342, 97, 25);
 shortAnswerUi.add(NewQuiz);
 answerField.setVisible(false);
	}

	//displays  pop up message s
	private void message(String s, String t){
		JOptionPane option = new JOptionPane(s);
		JDialog  dialog = option.createDialog(t);
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
	}
	
	
	
	/**
	 * 
	 * method takes qusstion and sets GUI
	 * 
	 */
	private void multiChoice(Qustion_Answer mC){
		answerField.setVisible(false);
		multiChoicePane.setVisible(true);
		qustion.setText(mC.getQustion());
		
		ArrayList<String> anserOption = mC.getChoices(); //list of answer options
		for(int i = 0; i < anserOption.size(); i++){  //loops displays answers to screen 
			
			
				option.get(i).setText(anserOption.get(i));
				
		}
		
		
	}
	
	/**
	 * method takes qustion and sets Gui
	 * 
	 */
	private void shortAnswer(Qustion_Answer sA){
		multiChoicePane.setVisible(false);
		answerField.setVisible(true);
		qustion.setText(sA.getQustion());
			
	}
		/**
		 * 
		 * @param qR
		 * @return a String of the number of correct answer out of quiz number
		 */
	private String quizResult(ArrayList<Qustion_Answer> qR){
		
		int totalRight = 0; int totalQustions = qR.size(); int index = 0; boolean answerR = false;
		
		for(index = 0; index < totalQustions; index++){
			
			answerR = qR.get(index).getResult();
			
			if(answerR ){ //if answered correct increase totalRight
				totalRight++; 
				 qR.get(index).setWrong(); 
			}
			
		}
		
		String result = "You Got " + totalRight + " out of " + totalQustions;
		
		return result;
		
		
	}
	}	

