package kpage.chklists;

import java.util.List;

public class Heading extends Checklist {
	
	private String name;

	public Heading(String name, List<ChecklistItem> items) {
		super(items);
		this.name = name;
	}
	
	public Heading(String name, List<ChecklistItem> items, List<Heading> subheadings) {
		super(items, subheadings);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String ret = "~~ " + name + " ~~";
		for (ChecklistItem ci : items) {
			ret += "\n" + ci.toString();
		}
		for (Heading h : subheadings) {
			ret += "\n" + h.toStringAsSub();
		}
		return ret;
	}
	
	protected String toStringAsSub() {
		String ret = "~ " + name;
		for (ChecklistItem ci : items) {
			ret += "\n" + ci.toString();
		}
		for (Heading h : subheadings) {
			ret += "\n" + h.toStringAsSub();
		}
		return ret;
	}

}
