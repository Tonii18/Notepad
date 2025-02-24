package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.DatabaseManager;
import models.User;
import roundedComponents.RoundButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField emailTF;
	private JPasswordField passwordField;
	private RoundButton loginButton;
	private JButton signUp;
	private JLabel logoLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 635);
		setTitle("Login in your Notepad account");
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 15));
		contentPane.setBackground(new Color(0, 37, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginButton = new RoundButton("Login", 10, 10);
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setFocusPainted(false);
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButton.setBorderPainted(false);
		loginButton.setBackground(new Color(34, 194, 184));
		loginButton.setBorder(null);
		loginButton.setFont(new Font("Inter 24pt Black", Font.PLAIN, 20));
		loginButton.setBounds(367, 456, 240, 46);
		contentPane.add(loginButton);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(new Color(34, 194, 184));
		separator1.setBackground(new Color(34, 194, 184));
		separator1.setBounds(367, 258, 240, 1);
		contentPane.add(separator1);
		
		emailTF = new JTextField();
		emailTF.setToolTipText("Email");
		emailTF.setBorder(null);
		emailTF.setForeground(new Color(255, 255, 255));
		emailTF.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 17));
		emailTF.setBackground(new Color(0, 37, 64));
		emailTF.setBounds(367, 223, 240, 31);
		contentPane.add(emailTF);
		emailTF.setColumns(10);
		
		JSeparator separator2 = new JSeparator();
		separator2.setForeground(new Color(34, 194, 184));
		separator2.setBackground(new Color(34, 194, 184));
		separator2.setBounds(367, 372, 240, 1);
		contentPane.add(separator2);
		
		JLabel ask = new JLabel("Don´t have an account?");
		ask.setHorizontalAlignment(SwingConstants.CENTER);
		ask.setForeground(new Color(255, 255, 255));
		ask.setFont(new Font("Inter 24pt Light", Font.PLAIN, 14));
		ask.setBounds(367, 513, 171, 21);
		contentPane.add(ask);
		
		signUp = new JButton("Sign Up");
		signUp.setFocusable(false);
		signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signUp.setContentAreaFilled(false);
		signUp.setBorder(null);
		signUp.setForeground(new Color(34, 194, 184));
		signUp.setFont(new Font("Inter 24pt ExtraBold", Font.PLAIN, 14));
		signUp.setBounds(515, 512, 103, 23);
		contentPane.add(signUp);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setBackground(new Color(0, 37, 64));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 17));
		passwordField.setBorder(null);
		passwordField.setBounds(367, 337, 240, 31);
		contentPane.add(passwordField);
		
		logoLabel = new JLabel("  ");
		logoLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		logoLabel.setBounds(423, 27, 128, 128);
		contentPane.add(logoLabel);
		logoLabel.setIcon(new ImageIcon(getClass().getResource("/book.png")));
		
		/*
		 * Events Handlers
		 */
		
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				loginButton.setBackground(new Color(66, 209, 219));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setBackground(new Color(34, 194, 184)); 
			}
		});
		
		// Actions
		signUp.addActionListener(new buttons());
		loginButton.addActionListener(new buttons());
		
		
	}
	
	/*
	 * Private Class
	 */
	
	private class buttons implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			if(button == signUp) {
				Signup s = new Signup();
				s.setVisible(true);
				dispose();
			}else if(button == loginButton) {
				loginUser();
			}
		}
		
	}
	
	/*
	 * External methods
	 */
	
	public void loginUser() {
		boolean logged = false;
		
		String email = emailTF.getText();
		String password = passwordField.getText();
		
		User u = new User(email, password);
		
		logged = DatabaseManager.loginUser(u);
		
		if(logged) {
			JOptionPane.showMessageDialog(null, "You have logged succesfully!");
			Home h = new Home();
			h.setVisible(true);
			dispose(); 
		}else {
			JOptionPane.showMessageDialog(null, "Your credentials are wrong!");
			emailTF.setText("");
			passwordField.setText("");
		}
	}

	
}
