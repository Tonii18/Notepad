package models;

import views.NotePanel;

public class Note {
	
	private String content;
	private boolean done;
	
	public Note() {
		
	}

	public Note(String content) {
		super();
		this.content = content;
		this.done = false;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Note [content=" + content + ", done=" + done + "]";
	}
	

}
