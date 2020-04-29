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

public class CustomerDash extends JFrame{
	
	private Controller controller;
	
	public CustomerDash(Controller controller) {
		this.controller = controller;
		
		attributesSetter();
        components();
        validation();
        
	}
	
	private void attributesSetter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(350,500);
        this.setTitle("Customer options");
		
	}
	
	private void components() {

        // Here we will have all the components to load the Customer Dashboard view
		// Border Layout
		BorderLayout border = new BorderLayout();
		this.setLayout(border);
		
		// Panels
		// Panel 1
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		
		this.add(panel1, BorderLayout.CENTER);
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		this.add(panel1);
		panel1.add(Box.createRigidArea(new Dimension(100,100)));
		
		// Panel 2
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.DARK_GRAY);
		
		this.add(panel2, BorderLayout.NORTH);
		
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.add(Box.createRigidArea(new Dimension(200,0)));
		
		// Panel 3
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.LIGHT_GRAY);
		
		this.add(panel3, BorderLayout.SOUTH);
		
		// Label
		JLabel welcomeLabel = new JLabel("CUSTOMERS");
		
		// Buttons with its ActionListeners
		JButton addCustomer = new JButton("Add new");
		addCustomer.addActionListener((ActionListener) controller);
		addCustomer.setActionCommand("add_new_customer");
		
		JButton updateCustomer = new JButton("Update info");
		updateCustomer.addActionListener((ActionListener) controller);
		updateCustomer.setActionCommand("update_info");
		
		JButton rentBtn = new JButton("Renting");
		rentBtn.addActionListener((ActionListener) controller);
		rentBtn.setActionCommand("rent_menu");
		
		JTextField findCustomerTxt = new JTextField(15);
		JButton findCustomer = new JButton("Find customer");
		findCustomer.addActionListener((ActionListener) controller);
		findCustomer.setActionCommand("find_customer");
		
		JButton goBack = new JButton("GO BACK");
		goBack.addActionListener((ActionListener) controller);
		goBack.setActionCommand("go_back_customer");
		
		// Adding everything to its panels
		panel1.add(welcomeLabel);
		panel1.add(Box.createRigidArea(new Dimension(50,50)));
		panel1.add(addCustomer);
		panel1.add(updateCustomer);
		panel1.add(rentBtn);
		panel2.add(goBack);
		panel3.add(findCustomerTxt);
		panel3.add(findCustomer);
		
		
	}
	
	private void validation() {
		this.validate();
        this.repaint();
	}

}
