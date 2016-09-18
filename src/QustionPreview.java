import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

/**
 * this class takes in a list of qustion_answer objects
 * extracsts the qustions fromm the list and displays them to the user
 * @author Joe
 *
 */
public class QustionPreview extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8706674505493307526L;
	public JPanel contentPane;
	private ArrayList<Qustion_Answer> PreviewQustions;
	private JTextArea QustionFiled;

	/**
	 * Launch the application.
	 */
	public QustionPreview(ArrayList<Qustion_Answer> a) {
		
		PreviewQustions = a;
		
		
		setBounds(100, 100, 638, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 208, 432, -193);
		contentPane.add(scrollPane);
		
		QustionFiled = new JTextArea();
		QustionFiled.setBounds(10, 13, 610, 354);
		contentPane.add(QustionFiled);
		QustionFiled.setColumns(10);
		
		SendToScreen( ReturnQustions( PreviewQustions ) );
	}
	
	
	private ArrayList<String> ReturnQustions(ArrayList<Qustion_Answer> t){
		
		ArrayList<String> qustions = new ArrayList<String>();
		
		for(int i = 0; i < t.size(); i++ ){
			
			qustions.add( t.get(i).getQustion() );
		}
		
		
		return qustions;
		
	}//end retrunqustions
	
	
	private void SendToScreen(ArrayList<String> t){
		
		for(int i = 0; i < t.size(); i++){
			
			QustionFiled.append(i + ": " + t.get(i) + "\n" );
		}
	}
}
