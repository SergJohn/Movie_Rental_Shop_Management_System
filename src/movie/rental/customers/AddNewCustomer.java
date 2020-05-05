package movie.rental.customers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import movie.rental.main.Controller;

public class AddNewCustomer extends JFrame{
	
	public JTextField name;
    public JTextField phone;
    public JTextField email;
    public JTextField address;
    public JTextField subscription;
	Controller controller;
	
	public AddNewCustomer(Controller controller) {
		
		this.controller = controller;
		attributesSetter();
        components();
        validation();
	}
	
	private void attributesSetter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(390,700);
        this.setTitle("Add New Title");
		
	}
	
	private void components() {

        // Here we will have all the components to load the View of AddNewTitle Class
		// Border Layout
		BorderLayout border = new BorderLayout();
		this.setLayout(border);
		
		// Panels
		// Panel 1
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		
		this.add(panel1, BorderLayout.CENTER);
		
		panel1.add(Box.createRigidArea(new Dimension(100,100)));
		
		// Panel 2
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.DARK_GRAY);
		
		this.add(panel2, BorderLayout.NORTH);
		
		// Panel 3
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.LIGHT_GRAY);
		
		this.add(panel3, BorderLayout.EAST);
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
		//this.add(panel3);
		panel3.add(Box.createRigidArea(new Dimension(100,100)));
		
		// Label
		JLabel welcomeLabel = new JLabel("Add New Title");
        JLabel cust_name = new JLabel("Name");
        JLabel cust_phone_no = new JLabel("Phone No");
        JLabel cust_email = new JLabel("Email");
        JLabel cust_address = new JLabel("Address");
        JLabel membership_id = new JLabel("Subscription");
        JLabel sub = new JLabel("Subscriptions");
        JLabel sub2 = new JLabel("1 = ML");
        JLabel sub3 = new JLabel("2 = VL");
        JLabel sub4 = new JLabel("3 = TL");
        JLabel sub5 = new JLabel("4 = PR");
		
		// Buttons
		JButton goBack = new JButton("GO BACK");
		goBack.addActionListener((ActionListener) controller);
		goBack.setActionCommand("go_back_cust_options_from_add_new_customer");
		
		JButton addNewCustomer = new JButton("ADD");
		addNewCustomer.addActionListener((ActionListener) controller);
		addNewCustomer.setActionCommand("add_new_customer");
		
		// Adding an Anonymous ActionListener
		JButton clear = new JButton("Clear");
		clear.setActionCommand("clear");
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getActionCommand().equals("clear")) {
					name.setText(null);
					phone.setText(null);
					email.setText(null);
					address.setText(null);
				}
			}
		});
		
		// Declaring TextFields
        name = new JTextField(20);
        phone = new JTextField(20);
        email = new JTextField(20);
        address = new JTextField(20);
        subscription = new JTextField(20);
       
        // Adding everything to its panels
     	// Panel2 - NORTH
     	panel2.add(goBack);
     	
     	// Panel3 - EAST
     	panel3.add(sub);
     	panel3.add(sub2);
     	panel3.add(sub3);
     	panel3.add(sub4);
     	panel3.add(sub5);
     	
     	// Panel1 - CENTER
     	panel1.add(welcomeLabel);
     	panel1.add(cust_name);
     	panel1.add(name);
     	panel1.add(cust_phone_no);
     	panel1.add(phone);
     	panel1.add(cust_email);
     	panel1.add(email);
     	panel1.add(cust_address);
     	panel1.add(address);
     	panel1.add(membership_id);
     	panel1.add(subscription);
     	panel1.add(addNewCustomer);
     	panel1.add(clear);
	}
	
	private void validation() {
		this.validate();
        this.repaint();
	}

}
