package kpage.chklists;

import java.util.ArrayList;
import java.util.List;

public class Checklist {
    protected List<ChecklistItem> items;
	protected List<Heading> subheadings;
    
    public Checklist(List<ChecklistItem> items) {
    	this(items, new ArrayList<Heading>());
    }
    
    public Checklist(List<ChecklistItem> items, List<Heading> subheadings) {
    	this.items = items;
    	this.subheadings = subheadings;
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
    
}
