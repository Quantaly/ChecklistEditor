package kpage.chklists;

import java.util.ArrayList;
import java.util.List;

public class Checklist {
	protected List<ChecklistItem> items;
	protected List<Heading> subheadings;

	public static Checklist getEmpty() {
		return new Checklist(null);
	}

	public Checklist(List<ChecklistItem> items) {
		this(items, new ArrayList<Heading>());
	}

	public Checklist(List<ChecklistItem> items, List<Heading> subheadings) {
		if (items != null) this.items = items;
		else this.items = new ArrayList<>();
		if (subheadings != null) this.subheadings = subheadings;
		else this.subheadings = new ArrayList<>();
	}

	public List<ChecklistItem> getItems() {
		return items;
	}

	public void addItem(ChecklistItem item) {
		items.add(item);
	}

	public void setChecked(int index, boolean checked) {
		items.get(index).setChecked(checked);
	}

	public List<Heading> getSubheadings() {
		return subheadings;
	}

	public void addSubheading(Heading heading) {
		subheadings.add(heading);
	}

	@Override
	public String toString() {
		String ret = "";
		for (ChecklistItem ci : items) {
			if (!ret.isEmpty()) ret += "\n";
			ret += ci.toString();
		}
		for (Heading h : subheadings) {
			if (!ret.isEmpty()) ret += "\n\n";
			ret += h.toString();
		}
		return ret;
	}

	public String toXML() {
		String ret = "<list>";
		//int indent = 4;
		for (ChecklistItem ci : items) {
			ret += "\n\t" + ci.toXML();
		}
		for (Heading h : subheadings) {
			String shxml = h.toXML();
			shxml = shxml.replaceAll("\n", "\n\t");
			ret += "\n\t" + shxml;
		}
		ret += "\n</list>";
		return ret;
	}

}
