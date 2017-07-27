package kpage.chklists.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import kpage.chklists.Checklist;
import kpage.chklists.utils.ChecklistParser;

public class TextListIO implements FileIOAgent {

	@Override
	public Checklist load(String path) {
		return load(Paths.get(path));
	}

	@Override
	public Checklist load(Path path) {
		try {
			String file = new String(Files.readAllBytes(path));
			return ChecklistParser.parseChecklist(file);
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public boolean save(String path, Checklist checklist) {
		return save(Paths.get(path), checklist);
	}

	@Override
	public boolean save(Path path, Checklist checklist) {
		try {
			String text = checklist.toString();
			Files.write(path, text.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
