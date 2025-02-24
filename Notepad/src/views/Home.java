package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import roundedComponents.RoundButton;
import roundedComponents.RoundButtonImage;
import roundedComponents.RoundPanel;
import javax.swing.JScrollPane;

public class Home extends JFrame {

	private JPanel contentPane;
	private RoundButton logout;
	private RoundButton addSection;
	private RoundButtonImage delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
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
		
		RoundPanel sectionsPanel = new RoundPanel(10, 10);
		sectionsPanel.setBounds(10, 11, 294, 485);
		contentPane.add(sectionsPanel);
		sectionsPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 274, 463);
		sectionsPanel.add(scrollPane);
		
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
	}
}
