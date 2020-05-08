package movie.rental.customers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import movie.rental.main.Controller;

public class CustomerFound extends JFrame {
	
	Controller controller;
	
	public CustomerFound(Controller controller, String customer) {
		
		this.controller = controller;
		
		attributesSetter();
        components(customer);
        validation();
	}
	
	private void attributesSetter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500,500);
        this.setTitle("Customer Found List");
		
	}
	
	private void components(String customer) {

        // Here we will have all the components to load the View of customer's list
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
		JLabel welcomeLabel = new JLabel("Customer Found");
		
		// Table with customer's list
		
		String[][] data = null;
		
		String[] columnNames = {"membership", "id", "name", "phone_no", "email", "address", "points", "rents"};
		
		data = controller.model.findCustomer(customer);
		
		JTable myTable = new JTable(data, columnNames);
		
		JScrollPane myPane = new JScrollPane(myTable);

		panel1.add(myPane);
		System.out.println(columnNames);
		
		
		
		// Buttons
		JButton goBack = new JButton("GO BACK");
		goBack.addActionListener((ActionListener) controller);
		goBack.setActionCommand("go_back_to_customer_options_from_customer_found");
		
		JButton rent = new JButton("Proceed rent");
		rent.addActionListener((ActionListener) controller);
		rent.setActionCommand("proceed_rent_from_customer_found");
		
		// Adding everything to its panels
		panel1.add(welcomeLabel);
		panel1.add(myPane);
		panel2.add(goBack);
		panel3.add(rent);
		
	}
	
	private void validation() {
		this.validate();
        this.repaint();
	}

}
