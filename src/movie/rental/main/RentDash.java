package movie.rental.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RentDash extends JFrame{
	
	public JTextField date;
	public JTextField customer;
	public JTextField title1;
	public JTextField title2;
	public JTextField title3;
	public JTextField title4;
	private Controller controller;
	
	public RentDash(Controller controller) {
		
		this.controller = controller;
		
		attributesSetter();
        components();
        validation();
	}
	
	private void attributesSetter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(250,500);
        this.setTitle("Rent");
		
	}
	
	private void components() {

        // Here we will have all the components to load the Rent view
		// Border Layout
		BorderLayout border = new BorderLayout();
		this.setLayout(border);
		
		// Panels
		// Panel 1
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		
		this.add(panel1, BorderLayout.CENTER);
		
//		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
//		this.add(panel1);
//		panel1.add(Box.createRigidArea(new Dimension(100,100)));
		
		// Panel 2
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.DARK_GRAY);
		
		this.add(panel2, BorderLayout.NORTH);
		
//		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
//		panel2.add(Box.createRigidArea(new Dimension(200,0)));
		
		// Panel 3
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.LIGHT_GRAY);
		
		this.add(panel3, BorderLayout.SOUTH);
		
		// Label
		JLabel welcomeLabel = new JLabel("RENT");
		JLabel customer_label = new JLabel("Customer email");
		JLabel title1_label = new JLabel("First Title id");
		JLabel title2_label = new JLabel("Second Title id");
		JLabel title3_label = new JLabel("Third Title id");
		JLabel title4_label = new JLabel("Fourth Title id");
		
		// Buttons
		JButton goBack = new JButton("GO BACK");
		goBack.addActionListener((ActionListener) controller);
		goBack.setActionCommand("go_back_rent");
		
		JButton rent = new JButton("Rent");
		rent.addActionListener((ActionListener) controller);
		rent.setActionCommand("proceed_rent");
		
		// Declaring the TextField's
		customer = new JTextField(20);
		title1 = new JTextField(20);
		title2 = new JTextField(20);
		title3 = new JTextField(20);
		title4 = new JTextField(20);
		
		// Adding everything to its panels
		panel1.add(welcomeLabel);
		panel1.add(Box.createRigidArea(new Dimension(100,100)));
		panel1.add(customer_label);
		panel1.add(customer);
		panel1.add(title1_label);
		panel1.add(title1);
		panel1.add(title2_label);
		panel1.add(title2);
		panel1.add(title3_label);
		panel1.add(title3);
		panel1.add(title4_label);
		panel1.add(title4);
		panel2.add(goBack);
		panel3.add(rent);
		
		
	}
	
	private void validation() {
		this.validate();
        this.repaint();
	}

}
