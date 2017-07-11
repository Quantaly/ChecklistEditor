package kpage.chklists;

public class ChecklistItem {
	private boolean checked;
	private String name;
	private String notes;
	
	public ChecklistItem(boolean checked, String name) {
		this(checked, name, null);
	}
	
	public ChecklistItem(boolean checked, String name, String notes) {
		setChecked(checked);
		setName(name);
		setNotes(notes);
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public boolean getChecked() {
		return checked;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNotes(String notes) {
		if (notes != null && !notes.isEmpty()) this.notes = notes;
		else clearNotes();
	}
	
	public void clearNotes() {
		this.notes = null;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public boolean hasNotes() {
		return this.notes != null;
	}
	
	public String getNotesNoNull() {
		if (this.notes != null) return this.notes;
		return "";
	}
	
	@Override
	public String toString() {
		String ret = getChecked() ? "[*] " : "[ ] ";
		ret += getName();
		if (hasNotes()) ret += " | " + getNotes();
		return ret;
	}
}
