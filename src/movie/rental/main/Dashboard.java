package movie.rental.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
*
* @author mrosa
*/
public class Dashboard extends JFrame {
	
	private Controller controller;
	
	/**
	 * Dashboard Constructor
	 * @param Controller
	 * */
	public Dashboard(Controller controller) {
		
		this.controller = controller;
		
		attributesSetter();
        components();
        validation();
        
	}

	private void attributesSetter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(300,400);
        this.setTitle("Dashboard");
		
	}
	
	private void components() {

        // Here we will have all the components to load the Dashboard view
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		this.add(panel1);
		panel1.add(Box.createRigidArea(new Dimension(100,100)));
		
		JLabel welcomeLabel = new JLabel("ULTRA-VISION");
		
		JButton cusBtn = new JButton("Customer");
		cusBtn.addActionListener((ActionListener) controller);
		cusBtn.setActionCommand("customer_menu");
		
		JButton archivesBtn = new JButton("Titles");
		archivesBtn.addActionListener((ActionListener) controller);
		archivesBtn.setActionCommand("archive_menu");
		
		JButton rentBtn = new JButton("Rent");
		rentBtn.addActionListener((ActionListener) controller);
		rentBtn.setActionCommand("rent_menu");
		
		JButton returnBtn = new JButton("Return");
		returnBtn.addActionListener((ActionListener) controller);
		returnBtn.setActionCommand("open_return_view");
		
		
		panel1.add(welcomeLabel);
		panel1.add(Box.createRigidArea(new Dimension(50,50)));
		panel1.add(cusBtn);
		panel1.add(archivesBtn);
		panel1.add(rentBtn);
		panel1.add(returnBtn);
		
		
	}
	
	private void validation() {
		this.validate();
        this.repaint();
	}

}
