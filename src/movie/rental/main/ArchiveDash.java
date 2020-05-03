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
		
		// Adding panel1 to the CENTER
		this.add(panel1, BorderLayout.CENTER);
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		this.add(panel1);
		panel1.add(Box.createRigidArea(new Dimension(100,100)));
		
		// Panel 2
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.DARK_GRAY);
		
		// Adding panel2 to the NORTH
		this.add(panel2, BorderLayout.NORTH);
		
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.add(Box.createRigidArea(new Dimension(200,0)));
		
		// Panel 3
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.LIGHT_GRAY);
		
		// Adding the panel3 to the SOUTH
		this.add(panel3, BorderLayout.SOUTH);
		
		// Label
		JLabel welcomeLabel = new JLabel("ITEMS");
		
		// Buttons with its ActionListeners
		
		// Btn to add a new title
		JButton addTitle = new JButton("Add new title");
		addTitle.addActionListener((ActionListener) controller);
		addTitle.setActionCommand("add_new_title");
		
		// Btn to update a existent title
		JButton updateTitle = new JButton("Update title");
		updateTitle.addActionListener((ActionListener) controller);
		updateTitle.setActionCommand("update_title");
		
		// Btn to display the list of movie titles
		JButton movieList = new JButton("Movie");
		movieList.addActionListener((ActionListener) controller);
		movieList.setActionCommand("movie_list");
		
		// Btn to display the list of music titles
		JButton musicList = new JButton("Music");
		musicList.addActionListener((ActionListener) controller);
		musicList.setActionCommand("music_list");
		
		// Btn to display the list of TV box titles
		JButton tvBoxList = new JButton("TV Box");
		tvBoxList.addActionListener((ActionListener) controller);
		tvBoxList.setActionCommand("tv_box_list");
		
		// Btn to display the list of Live Concert titles
		JButton liveConcertList = new JButton("Live Concert");
		liveConcertList.addActionListener((ActionListener) controller);
		liveConcertList.setActionCommand("live_concert_list");
		
		// TextField to make the search on titles
		JTextField findTitleTxt = new JTextField(15);
		
		// Btn to search the titles
		JButton findTitle = new JButton("Find title");
		findTitle.addActionListener((ActionListener) controller);
		findTitle.setActionCommand("find_title");
		
		// Btn to go back to main dashboard
		JButton goBack = new JButton("GO BACK");
		goBack.addActionListener((ActionListener) controller);
		goBack.setActionCommand("go_back_items");
		
		// Adding everything to its panels
		
		// Components on panel1
		panel1.add(welcomeLabel);
		panel1.add(Box.createRigidArea(new Dimension(50,50)));
		panel1.add(movieList);
		panel1.add(musicList);
		panel1.add(tvBoxList);
		panel1.add(liveConcertList);
		panel1.add(addTitle);
		panel1.add(updateTitle);
		
		// Buttons on panel2
		panel2.add(goBack);
		
		// Components on panel3
		panel3.add(findTitleTxt);
		panel3.add(findTitle);
		
		
	}
	
	private void validation() {
		this.validate();
        this.repaint();
	}

}
