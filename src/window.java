import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.ScrollPane;


public class window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static window frame;
	private JTextArea answerField, qustionField, answerA,answerB,answerC,answerD,answerE;
	public static ArrayList<Qustion_Answer> qAndA;
	private boolean ismultiChoice, typeSelc; //when type is true qustion is short answer
	private final ButtonGroup typeSel = new ButtonGroup();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public static int indexOfAnswer_MC;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		qAndA = new ArrayList<Qustion_Answer>();
		indexOfAnswer_MC = 0;
		final Font font = new Font("helvetica", 15, Font.PLAIN);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new window();
					 frame.setVisible(true);
					 frame.setFont(font);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		/**
	 * Create the frame.
	 */
	public window() {
		
		Image icon = Toolkit.getDefaultToolkit().getImage("Icon");
		setIconImage(icon);
		
		
		
		setBounds(100, 100, 1018, 631);
		contentPane = new JPanel();
		contentPane.setFont(new Font("SansSerif", Font.PLAIN, 15));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.updateUI();
		
		qustionField = new JTextArea();
		qustionField.setBounds(100, 6, 858, 54);
		qustionField.setColumns(10);
		qustionField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		qustionField.setLineWrap(true);
		qustionField.setBorder(BorderFactory.createLineBorder(Color.black));
		
		 final JPanel MultiChoicePan_1 = new JPanel();
		 MultiChoicePan_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		 MultiChoicePan_1.setBounds(59, 111, 918, 249);
		 contentPane.add(MultiChoicePan_1);
		 MultiChoicePan_1.setLayout(null);
		 
		 JRadioButton ChoiceC = new JRadioButton();
		 ChoiceC.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		indexOfAnswer_MC = 3;
		 	}
		 });
		 buttonGroup.add(ChoiceC);
		 ChoiceC.setBounds(44, 115, 24, 18);
		 MultiChoicePan_1.add(ChoiceC);
		 
		  JRadioButton choiceA = new JRadioButton();
		  choiceA.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		indexOfAnswer_MC = 1;
		  	}
		  });
		  buttonGroup.add(choiceA);
		  choiceA.setBounds(44, 20, 24, 18);
		  MultiChoicePan_1.add(choiceA);
		  
		  JRadioButton ChoiceD = new JRadioButton();
		  ChoiceD.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		indexOfAnswer_MC = 4;
		  	}
		  });
		  buttonGroup.add(ChoiceD);
		  ChoiceD.setBounds(44, 169, 24, 18);
		  MultiChoicePan_1.add(ChoiceD);
		  
		  JRadioButton ChoiceE = new JRadioButton();
		  ChoiceE.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		indexOfAnswer_MC = 5;
		  	}
		  });
		  buttonGroup.add(ChoiceE);
		  ChoiceE.setBounds(44, 219, 24, 18);
		  MultiChoicePan_1.add(ChoiceE);
		  
		  JRadioButton ChoiceB = new JRadioButton();
		  ChoiceB.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		indexOfAnswer_MC = 2;
		  	}
		  });
		  buttonGroup.add(ChoiceB);
		  ChoiceB.setBounds(44, 70, 24, 18);
		  MultiChoicePan_1.add(ChoiceB);
		  
		  answerA = new JTextArea();
		  answerA.setBounds(80, 6, 774, 44);
		  MultiChoicePan_1.add(answerA);
		  answerA.setColumns(10);
		  answerA.setText("");
		  answerA.setBorder(BorderFactory.createLineBorder(Color.black));
		  answerA.setLineWrap(true);
		  
		  answerB = new JTextArea();
		  answerB.setBounds(80, 55, 774, 44);
		  MultiChoicePan_1.add(answerB);
		  answerB.setColumns(10);
		  answerB.setText("");
		  answerB.setLineWrap(true);
		  answerB.setBorder(BorderFactory.createLineBorder(Color.black));
		  
		  answerC = new JTextArea();
		  answerC.setBounds(80, 104, 774, 44);
		  MultiChoicePan_1.add(answerC);
		  answerC.setColumns(10);
		  answerC.setText("");
		  answerC.setLineWrap(true);
		  answerC.setBorder(BorderFactory.createLineBorder(Color.black));
		  
		  answerE = new JTextArea();
		  answerE.setBounds(80, 202, 774, 44);
		  MultiChoicePan_1.add(answerE);
		  answerE.setText("");
		  answerE.setColumns(10);
		  answerE.setLineWrap(true);
		  answerE.setBorder(BorderFactory.createLineBorder(Color.black));
		  
		  answerD = new JTextArea();
		  answerD.setBounds(80, 153, 774, 44);
		  answerD.setText("");
		  MultiChoicePan_1.add(answerD);
		  answerD.setColumns(10);
		  answerD.setLineWrap(true);
		  answerD.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(770, 541, 101, 25);
		contentPane.add(btnSave);
		
		JLabel lblQustion = new JLabel("Question");
		lblQustion.setBounds(6, 32, 54, 16);
		contentPane.add(lblQustion);
		
		
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(12, 111, 54, 16);
		contentPane.add(lblAnswer);
		 
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(59, 372, 97, 25);
		contentPane.add(btnDone);
		
		JButton btnNewQustion = new JButton("New Question");
		btnNewQustion.setBounds(743, 380, 149, 25);
		contentPane.add(btnNewQustion);
		
		final JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(39, 541, 97, 25);
		contentPane.add(btnLoad);
		
		final TextField saveName = new TextField();
		saveName.setBounds(743, 511, 154, 24);
		contentPane.add(saveName);
		
		final JRadioButton shortAnswer = new JRadioButton("Short Answer");
		typeSel.add(shortAnswer);
		
		shortAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeSelc = true;
				 ismultiChoice = false;
				MultiChoicePan_1.setVisible(false);
				
			}
		});
		shortAnswer.setBounds(110, 87, 115, 18);
		contentPane.add(shortAnswer);
		
		JRadioButton multiChoice = new JRadioButton("Mulipule choice");
		typeSel.add(multiChoice);
		multiChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 typeSelc = true;
				 ismultiChoice = true;
				 MultiChoicePan_1.setVisible(true);
			}
		});
		multiChoice.setBounds(803, 87, 115, 18);
		contentPane.add(multiChoice);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(71, 6, 906, 72);
		scrollPane.add(qustionField);
		contentPane.add(scrollPane);
		
		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(71, 111, 906, 139);
		
		contentPane.add(scrollPane_1);
		
		answerField = new JTextArea();
		answerField.setBounds(69, 110, 888, 232);
		answerField.setColumns(10);
		answerField.setLineWrap(true);
		answerField.setBorder(BorderFactory.createLineBorder(Color.black));
		scrollPane_1.add(answerField);
		/**
		 * button opens window that displays questions in the quiz
		 */
		JButton btnPreviewQustions = new JButton("Preview Qustions");
		btnPreviewQustions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		    AddQustions();
			QustionPreview temp = 	new QustionPreview(qAndA);
			temp.setVisible(true);
			temp.contentPane.setVisible(true);
			}
		});
		btnPreviewQustions.setBounds(351, 539, 159, 28);
		contentPane.add(btnPreviewQustions);
		
		btnLoad.addActionListener(new ActionListener() {       //load file to be quized on. currently not functional
			final JFileChooser fc = new JFileChooser();
			
			public void actionPerformed(ActionEvent e) {
				 int returnVal = fc.showDialog(btnLoad, null);
				
				 File file = fc.getSelectedFile();
				 
				 Loader load = null;
				try {
					load = new Loader(file );
					
					boolean goTo = true;
					if( !( load.test) ){
						throw new IOException() ;
					}
					while(goTo){
					String temp = JOptionPane.showInputDialog("Do you want to add qustions to this quiz? Y/N ");
					String s = temp.toUpperCase().trim();
					 
					if( s.equals("Y")){//user wants to add new qustions to loaded quix
						
						qAndA = load.fQandA; goTo = false;
					}
					
					else if(s.equals("N")){  //user wants to be quized on loaded data
						
						quizer tests = new quizer(load.fQandA); //opens quizer closes entry window
						tests.setVisible(true);
					    frame.setVisible(false); 
					    goTo = false;
					}
					
					else{
						message("Invalid Entry", "Do you know the letters Y and N?");
					}
				}//end loop
					}
				catch(IOException e1){
					
					System.out.println("opps excption in load");
					e1.printStackTrace();
					return;
				}	 
			}
		});
		btnNewQustion.addActionListener(new ActionListener() {
			
			/**
			 * NewQustion button
			 * When Pressed prgm loads Q&A into list 
			 * clears text areas when done
			 */
			public void actionPerformed(ActionEvent e) {
				
				AddQustions();
			}
		});
		btnDone.addActionListener(new ActionListener() {
			
			/**
			 * stores final Q&A into list
			 * Passes list to quizer
			 * sets frame no visible
			 */
			public void actionPerformed(ActionEvent e) {
				
                 
				AddQustions();
				quizer tests = new quizer(qAndA);
				tests.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			//save qustions and answers to text file to load later
			public void actionPerformed(ActionEvent e) {
				AddQustions();
				Saver sav = new Saver(qAndA, saveName.getText());
			}
		});
		
		
	}
	
	/**
	 *  loads string of answers for multichoice into arraylist(answers)
	 */
	private ArrayList<String> toArrayList(String s){
		
		try{ ArrayList<String> answers = new ArrayList<String>();
		
		Scanner scan = new Scanner(s); //parse lines of answers
		scan = scan.useDelimiter(":");
		 while(scan.hasNext()){
			 
			 answers.add(scan.next());
		 }
		
		if(answers.size() > 5){
			throw new ArrayIndexOutOfBoundsException();
			
		}
		
		return answers; } catch(ArrayIndexOutOfBoundsException e){
			message("Please put in NO MORE than 5 options", "OPPS!");
		}
		return null;
		
	}
	
	
	/**
	 * method takes two strings to display messaage to user
	 * @param s message to be displayed
	 * @param t message for title
	 */
		private void message(String s, String t){
			JOptionPane option = new JOptionPane(s);
			JDialog  dialog = option.createDialog(t);
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
		
		
		private void AddQustions(){
			
			
			if( !(typeSelc )){
				message("Please Select a Qustion Type", "We Have A Problem!!");
			}
             else if(qustionField.getText().isEmpty()){            ///lines of error checking to ensure there are valid qustions and answers inputed
				
				message("But What is the qustion?", "The Answer is 42");
			}
			else if( !(ismultiChoice ) && answerField.getText().isEmpty() ){
				
				message("Please Enter or Selcet an Answer", "Nothing is seldom the Answer");
			}
			else if( ismultiChoice  && indexOfAnswer_MC == 0	){
				
				message("Please Enter or Selcet an Answer", "Is the Answer C?");
			}
			
			
			else if( !(ismultiChoice ) ){ ///qustion is short answer
				
				Qustion_Answer temp = new Qustion_Answer(qustionField.getText(), answerField.getText()); //stores final qustion/answer
				qAndA.add(temp);  
				qustionField.setText("");answerField.setText(""); answerA.setText(""); answerB.setText(""); answerC.setText(""); answerD.setText(""); answerE.setText("");
				 	
			}
			else if(  ismultiChoice ){ ///qustion is multichoice
			
			String Answers = answerA.getText() + " : " + answerB.getText() + ":" + answerC.getText() + ":" + answerD.getText() + ":" + answerE.getText() + ":"; 
			Qustion_Answer temp = new Qustion_Answer(qustionField.getText(), toArrayList(Answers), indexOfAnswer_MC );
			buttonGroup.clearSelection();
			qAndA.add(temp);  
			qustionField.setText(" ");answerField.setText(" "); answerA.setText(" "); answerB.setText(" "); answerC.setText(" "); answerD.setText(" "); answerE.setText(" ");	}
			
		
		}
}
