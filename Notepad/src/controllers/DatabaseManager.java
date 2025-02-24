package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.User;
import views.Section;

public class DatabaseManager {
	
	public static void registerUser(User u) {
		String email = u.getEmail();
		String name = u.getName();
		String password = u.getPassword();
		
		String sql = "INSERT INTO users (email, name, password) VALUES(?, ?, ?)";
		
		try {
			Connection conn = Connections.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, password);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean loginUser(User u) {
		boolean logged = false;
		
		String email = u.getEmail();
		String password = u.getPassword();
		
		String sql = "SELECT * FROM USERS WHERE email = ? AND password = ?";
		
		try {
			Connection conn = Connections.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			logged = ps.executeQuery().next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return logged;
		
	}

}
