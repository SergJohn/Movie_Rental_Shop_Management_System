package movie.rental.titles;

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

import movie.rental.main.Controller;

public class AddNewTitle extends JFrame {
	
	public JTextField name;
    public JTextField director;
    public JTextField genre;
    public JTextField duration;
    public JTextField media;
    public JTextField year;
    public JTextField membership;
	private Controller controller;
	
	public AddNewTitle(Controller controller) {
		
		this.controller = controller;
		
		attributesSetter();
        components();
        validation();
	}
	
	private void attributesSetter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(380,700);
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
        JLabel title_name = new JLabel("Name");
        JLabel title_director = new JLabel("Director");
        JLabel title_genre = new JLabel("Genre");
        JLabel title_duration = new JLabel("Duration");
        JLabel title_media = new JLabel("Media");
        JLabel title_year = new JLabel("Year");
        JLabel memberships_membership_id = new JLabel("Membership ID");
        JLabel subtitle = new JLabel("Membership:");
        JLabel sub2 = new JLabel("1 = ML");
        JLabel sub3 = new JLabel("2 = VL");
        JLabel sub4 = new JLabel("3 = TL");
        JLabel sub5 = new JLabel("4 = PR");
		
		// Buttons
		JButton goBack = new JButton("GO BACK");
		goBack.addActionListener((ActionListener) controller);
		goBack.setActionCommand("go_back_archive_from_add_new_title");
		
		JButton addNewTitle = new JButton("ADD");
		addNewTitle.addActionListener((ActionListener) controller);
		addNewTitle.setActionCommand("add_new_title");
		
		// Declaring TextFields
        name = new JTextField(20);
        director = new JTextField(20);
        genre = new JTextField(20);
        duration = new JTextField(20);
        media = new JTextField(20);
        year = new JTextField(20);
        membership = new JTextField(20);
       
        // Adding everything to its panels
     	// Panel2 - NORTH
     	panel2.add(goBack);
     	
     	// Panel3 - EAST
     	panel3.add(subtitle);
     	panel3.add(sub2);
     	panel3.add(sub3);
     	panel3.add(sub4);
     	panel3.add(sub5);
     	
     	// Panel1 - CENTER
     	panel1.add(welcomeLabel);
     	panel1.add(title_name);
     	panel1.add(name);
     	panel1.add(title_director);
     	panel1.add(director);
     	panel1.add(title_genre);
     	panel1.add(genre);
     	panel1.add(title_duration);
     	panel1.add(duration);
     	panel1.add(title_media);
     	panel1.add(media);
     	panel1.add(title_year);
     	panel1.add(year);
     	panel1.add(memberships_membership_id);
     	panel1.add(membership);
     	panel1.add(addNewTitle);	
	}
	
	private void validation() {
		this.validate();
        this.repaint();
	}

}
