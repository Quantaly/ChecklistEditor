package kpage.chklists.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import kpage.chklists.Checklist;
import kpage.chklists.utils.ChecklistParser;

@Deprecated
public class ChecklistBuffer extends Checklist {
	protected String path;

	public ChecklistBuffer(String path) {
		super(null);
		this.path = path;
	}

	public boolean load() {
		try {
			String file = new String(Files.readAllBytes(Paths.get(path)));
			Checklist fromFile = ChecklistParser.parseChecklist(file);
			items = fromFile.getItems();
			subheadings = fromFile.getSubheadings();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public boolean save() {
		try {
			String text = toString();
			Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public boolean saveAs(String path, boolean copy) {
		try {
			String text = toString();
			Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.CREATE);
			if (!copy) this.path = path;
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public String getPath() {
		return path;
	}
}
