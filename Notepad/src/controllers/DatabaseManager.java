package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Section;
import models.User;
import views.SectionPanel;

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

	// TODAY PROGRESS
	
	public static int getUserId(User u) {
		String email = u.getEmail();
		int userId = -1;
		
		String sql = "SELECT id FROM users WHERE email = ?";
		
		try {
			Connection conn = Connections.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, u.getEmail());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				userId = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userId;
	}
	
	public static void addSection(User u, String name) {
		String sql = "INSERT INTO sections (user_id, name) VALUES (?, ?)";
		
		try {
			Connection conn = Connections.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, getUserId(u));
			ps.setString(2, name);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Section> getSections(User u){
		List<Section> sections = new ArrayList<>();
		
		String sql = "SELECT * FROM sections where user_id = ?";
		
		try {
			Connection conn = Connections.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, getUserId(u));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String sectionName = rs.getString("name");
				Section section = new Section(sectionName);
				sections.add(section);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sections;
	}
	
	public static boolean deleteSection(String section) {
		boolean deleted = false;
		
		String sql = "DELETE FROM sections WHERE name = ?";
		
		try {
			Connection conn = Connections.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, section);
			
			ps.executeUpdate();
			
			deleted = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deleted;
	}

}
