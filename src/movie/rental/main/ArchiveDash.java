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

public class ArchiveDash extends JFrame{
	
	private Controller controller;
	
	public ArchiveDash(Controller controller) {
		this.controller = controller;
		
		attributesSetter();
        components();
        validation();
	}
	
	private void attributesSetter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(350,500);
        this.setTitle("Archive options");
		
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
		JLabel welcomeLabel = new JLabel("ITEMS");
		
		// Buttons with its ActionListeners
		JButton addTitle = new JButton("Add new");
		addTitle.addActionListener((ActionListener) controller);
		addTitle.setActionCommand("add_new_title");
		
		JButton updateTitle = new JButton("Update title");
		updateTitle.addActionListener((ActionListener) controller);
		updateTitle.setActionCommand("update_title");
		
		JTextField findTitleTxt = new JTextField(15);
		JButton findTitle = new JButton("Find title");
		findTitle.addActionListener((ActionListener) controller);
		findTitle.setActionCommand("find_title");
		
		JButton goBack = new JButton("GO BACK");
		goBack.addActionListener((ActionListener) controller);
		goBack.setActionCommand("go_back");
		
		// Adding everything to its panels
		panel1.add(welcomeLabel);
		panel1.add(Box.createRigidArea(new Dimension(50,50)));
		panel1.add(addTitle);
		panel1.add(updateTitle);
		panel2.add(goBack);
		panel3.add(findTitleTxt);
		panel3.add(findTitle);
		
		
	}
	
	private void validation() {
		this.validate();
        this.repaint();
	}

}
