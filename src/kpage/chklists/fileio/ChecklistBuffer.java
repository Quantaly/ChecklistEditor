package kpage.chklists.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import kpage.chklists.Checklist;
import kpage.chklists.utils.ChecklistParser;

public class ChecklistBuffer extends Checklist {
	private String path;
	
	public ChecklistBuffer(String path) {
		super(null);
		this.path = path;
	}
	
	public boolean load() {
		boolean worked = true;
		try {
			String file = new String(Files.readAllBytes(Paths.get(path)));
			Checklist fromFile = ChecklistParser.parseChecklist(file);
			items = fromFile.getItems();
			subheadings = fromFile.getSubheadings();
		} catch (IOException e) {
			worked = false;
		}
		return worked;
	}
	
	public boolean save() {
		boolean worked = true;
		try {
			String text = toString();
			Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			worked = false;
		}
		return worked;
	}
	
	public boolean saveAs(String path, boolean changeOwnPath) {
		boolean worked = true;
		try {
			String text = toString();
			Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.CREATE);
			if (changeOwnPath) this.path = path;
		} catch (IOException e) {
			worked = false;
		}
		return worked;
	}
	
	public String getPath() {
		return path;
	}
}
