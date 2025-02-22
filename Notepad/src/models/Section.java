package models;

import java.util.ArrayList;
import java.util.List;

public class Section {
	
	private String name;
	private List<Note> notes;
	
	public Section() {
		
	}

	public Section(String name) {
		super();
		this.name = name;
		this.notes = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Section [name=" + name + ", notes=" + notes + "]";
	}
	
	

}
