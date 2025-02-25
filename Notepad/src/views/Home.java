package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.DatabaseManager;
import models.Section;
import models.User;
import roundedComponents.RoundButton;
import roundedComponents.RoundButtonImage;
import roundedComponents.RoundPanel;
import roundedComponents.RoundTextField;
import javax.swing.ScrollPaneConstants;

public class Home extends JFrame {

	private JPanel contentPane;
	private RoundButton logout;
	private RoundButton addSection;
	private RoundButtonImage delete;
	private JTextField textField;
	private RoundPanel sectionsPanel;
	private JScrollPane scrollPane;
	
	private User u;
	private List<Section> sections;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Home(User u) {
		this.u = u;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 635);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 46, 46));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RoundPanel notesPanel = new RoundPanel(10, 10);
		notesPanel.setBackground(new Color(68, 68, 68));
		notesPanel.setBounds(314, 11, 651, 574);
		contentPane.add(notesPanel);
		notesPanel.setLayout(null);
		
		JScrollPane notesScrollpane = new JScrollPane();
		notesScrollpane.setBounds(10, 11, 631, 489);
		notesPanel.add(notesScrollpane);
		
		RoundPanel writer = new RoundPanel(5, 5);
		writer.setBackground(new Color(46, 46, 46));
		writer.setBounds(10, 511, 631, 52);
		notesPanel.add(writer);
		writer.setLayout(null);
		
		JLabel iconLabel = new JLabel("");
		iconLabel.setBounds(10, 8, 35, 35);
		iconLabel.setIcon(new ImageIcon(getClass().getResource("/Ellipse.png")));
		writer.add(iconLabel);
		
		textField = new RoundTextField(15, 5, 5);
		textField.setCaretColor(new Color(255, 255, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(255, 255, 255));
		textField.setFont(new Font("Inter 24pt SemiBold", Font.PLAIN, 15));
		textField.setBackground(new Color(68, 68, 68));
		textField.setBorder(null);
		textField.setBounds(67, 10, 554, 32);
		writer.add(textField);
		textField.setColumns(10);
		
		sectionsPanel = new RoundPanel(10, 10);
		sectionsPanel.setBackground(new Color(46, 46, 46));
		sectionsPanel.setBounds(10, 11, 294, 485);
		contentPane.add(sectionsPanel);
		sectionsPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setBackground(new Color(46, 46, 46));
		scrollPane.setBackground(new Color(46, 46, 46));
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 11, 274, 463);
		sectionsPanel.add(scrollPane);
		
		/*scrollPane.getVerticalScrollBar().setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = new Color(91, 92, 92); // Color del "agarre" de la barra
		        this.trackColor = new Color(46, 46, 46); // Color del fondo de la barra
		    }
		});*/

		
		logout = new RoundButton("Log Out", 5, 5);
		logout.setForeground(new Color(255, 255, 255));
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.setBackground(new Color(146, 87, 255));
		logout.setBorder(null);
		logout.setFont(new Font("Inter 24pt SemiBold", Font.PLAIN, 15));
		logout.setBounds(10, 555, 294, 30);
		contentPane.add(logout);
		
		addSection = new RoundButton("Add Section", 5, 5);
		addSection.setBackground(new Color(34, 194, 184));
		addSection.setForeground(new Color(255, 255, 255));
		addSection.setFont(new Font("Inter 24pt SemiBold", Font.PLAIN, 15));
		addSection.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addSection.setBorder(null);
		addSection.setBounds(10, 507, 196, 37);
		contentPane.add(addSection);
		
		delete = new RoundButtonImage("", 5, 5);
		delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delete.setBackground(new Color(255, 92, 92));
		delete.setBorder(null);
		delete.setBounds(215, 507, 89, 37);
		delete.setIcon(new ImageIcon(getClass().getResource("/delete2.png")));
		contentPane.add(delete);
		
		// Functions
		loadSections();
		
		// Buttons actions
		addSection.addActionListener(new buttons());
	}
	
	/*
	 * PRIVATE CLASSES
	 */
	
	private class buttons implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			if(button == addSection) {
				addSection();
			}
		}
		
	}
	
	// EXTERNAL METHODS
	
	public void addSection() {
		String sectionName = JOptionPane.showInputDialog("Enter section name:");
        if (sectionName != null && !sectionName.trim().isEmpty()) {
            DatabaseManager.addSection(u, sectionName);
            addSectionToUI(sectionName);
        }
	}
	
	private void addSectionToUI(String sectionName) {
	    SectionPanel sectionButton = new SectionPanel(sectionName, 10, 10);
	    sectionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	    JPanel panel = (JPanel) scrollPane.getViewport().getView();

	    if (panel == null) {
	        panel = new JPanel();
	        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
	        scrollPane.setViewportView(panel);
	    }

	    sectionButton.setPreferredSize(new java.awt.Dimension(250, 60)); 

	    panel.add(sectionButton);

	    panel.revalidate();
	    panel.repaint();
	}

	private void loadSections() {
	    sections = DatabaseManager.getSections(u);

	    JPanel panel = (JPanel) scrollPane.getViewport().getView();

	    if (panel == null) {
	        panel = new JPanel();
	        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Márgenes (arriba, izquierda, abajo, derecha)

	        panel.setLayout(new GridLayout(0, 1, 15, 15));
	        panel.setBackground(new Color(46, 46, 46));
	        scrollPane.setViewportView(panel);
	    }
	    
	    scrollPane.getViewport().setBackground(new Color(46, 46, 46));
	    scrollPane.setBackground(new Color(46, 46, 46));
	    scrollPane.setBorder(null);

	    panel.removeAll();

	    for (Section section : sections) {
	        SectionPanel sectionButton = new SectionPanel(section.getName(), 10, 10);
	        sectionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	        sectionButton.setPreferredSize(new java.awt.Dimension(240, 60));

	        panel.add(sectionButton);
	    }

	    panel.revalidate();
	    panel.repaint();
	}




	
	

}
