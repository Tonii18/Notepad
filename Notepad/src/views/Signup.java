package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controllers.DatabaseManager;
import models.User;
import roundedComponents.RoundButton;

public class Signup extends JFrame {

	private JPanel contentPane;
	private RoundButton signUp;
	private JTextField email;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setBackground(new Color(0, 37, 64));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 635);
		setTitle("Create your account");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 37, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(34, 194, 184));
		separator.setBounds(367, 232, 240, 1);
		contentPane.add(separator);
		
		JSeparator separator2 = new JSeparator();
		separator2.setForeground(new Color(34, 194, 184));
		separator2.setBounds(367, 344, 240, 1);
		contentPane.add(separator2);
		
		JSeparator separator3 = new JSeparator();
		separator3.setForeground(new Color(34, 194, 184));
		separator3.setBounds(367, 456, 240, 1);
		contentPane.add(separator3);
		
		signUp = new RoundButton("Create Account", 10, 10);
		signUp.setBorderPainted(true);
		signUp.setFont(new Font("Inter 24pt Black", Font.PLAIN, 20));
		signUp.setForeground(new Color(255, 255, 255));
		signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signUp.setBackground(new Color(34, 194, 184));
		signUp.setBorder(null);
		signUp.setBounds(367, 515, 240, 46);
		contentPane.add(signUp);
		
		JLabel logo = new JLabel("");
		logo.setBounds(423, 30, 128, 128);
		logo.setIcon(new ImageIcon(getClass().getResource("/book.png")));
		contentPane.add(logo);
		
		email = new JTextField();
		email.setToolTipText("email");
		email.setBackground(new Color(0, 37, 64));
		email.setForeground(new Color(255, 255, 255));
		email.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 17));
		email.setBorder(null);
		email.setBounds(367, 198, 240, 31);
		contentPane.add(email);
		email.setColumns(10);
		
		username = new JTextField();
		username.setToolTipText("username");
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 17));
		username.setColumns(10);
		username.setBorder(null);
		username.setBackground(new Color(0, 37, 64));
		username.setBounds(367, 310, 240, 31);
		contentPane.add(username);
		
		password = new JPasswordField();
		password.setToolTipText("password");
		password.setForeground(new Color(255, 255, 255));
		password.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 17));
		password.setBorder(null);
		password.setBackground(new Color(0, 37, 64));
		password.setBounds(367, 422, 240, 31);
		contentPane.add(password);
		
		JButton back = new JButton("Back to Login");
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setContentAreaFilled(false);
		back.setBorder(null);
		back.setForeground(new Color(34, 194, 184));
		back.setFont(new Font("Inter 24pt ExtraBold", Font.PLAIN, 15));
		back.setBounds(10, 562, 151, 23);
		contentPane.add(back);
		
		/*
		 * Events Handlers
		 */
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
			
		});
		
		signUp.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				signUp.setBackground(new Color(66, 209, 219));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				signUp.setBackground(new Color(34, 194, 184)); 
			}
		});
		
		/*
		 *  Actions
		 */
		
		signUp.addActionListener(new buttons());
		
		
	}
	
	// Private Classes
	
	private class buttons implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			if(button == signUp) {
				registerUser();
			}
		}
		
	}
	
	// External Methods
	
	public void registerUser() {
		String userEmail = email.getText();
		String userName = username.getText();
		String userPassword = password.getText();
		
		User u = new User(userEmail, userName, userPassword);
		DatabaseManager.registerUser(u);
		JOptionPane.showMessageDialog(null, "You have been registered succesfully!");
		
		Home h = new Home(u);
		h.setVisible(true);
		dispose();
	}
}
