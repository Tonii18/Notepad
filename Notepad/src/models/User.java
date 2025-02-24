package models;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String email;
	private String name;
	private String password;
	private List<Section> sections;
	
	public User(){
		
	}

	public User(String email, String name, String password, List<Section> sections) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.sections = sections;
	}
	

	public User(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.sections = new ArrayList<>();
	}
	

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", password=" + password + ", sections=" + sections + "]";
	}
	
	
	

}
