package movie.rental.titles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import movie.rental.main.Controller;

public class ReturnTitle extends JFrame {
	
	public JTextField email;
	private Controller controller;
	
	public ReturnTitle(Controller controller) {
		
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
		
		// Panel 2
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.DARK_GRAY);
		
		this.add(panel2, BorderLayout.NORTH);
		
		// Panel 3
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.LIGHT_GRAY);
		
		this.add(panel3, BorderLayout.SOUTH);
		
		// Label
		JLabel welcomeLabel = new JLabel("Returning titles");
		JLabel customer_email_label = new JLabel("Customer email");
		
		// Buttons
		JButton goBack = new JButton("GO BACK");
		goBack.addActionListener((ActionListener) controller);
		goBack.setActionCommand("go_back_dash_from_return_title");
		
		JButton doReturn = new JButton("Return titles");
		doReturn.addActionListener((ActionListener) controller);
		doReturn.setActionCommand("do_return");
		
		// Declaring the TextField's
		email = new JTextField(20);
		
		// Adding everything to its panels
		panel1.add(welcomeLabel);
		panel1.add(Box.createRigidArea(new Dimension(100,100)));
		panel1.add(customer_email_label);
		panel1.add(email);
		panel1.add(doReturn);
		panel2.add(goBack);
		
		
	}
	
	private void validation() {
		this.validate();
        this.repaint();
	}

}
