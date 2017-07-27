package kpage.chklists.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import kpage.chklists.Checklist;
import kpage.chklists.utils.XMLParser;

@Deprecated
public class XMLChecklistBuffer extends ChecklistBuffer {

	public XMLChecklistBuffer(String path) {
		super(path);
	}

	@Override
	public boolean load() {
		try {
			Checklist fromFile = XMLParser.parseChecklist(path);
			items = fromFile.getItems();
			subheadings = fromFile.getSubheadings();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean save() {
		try {
			String xml = toXML();
			Files.write(Paths.get(path), xml.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean saveAs(String path, boolean copy) {
		try {
			String xml = toXML();
			Files.write(Paths.get(path), xml.getBytes(), StandardOpenOption.CREATE);
			if (!copy) this.path = path;
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
