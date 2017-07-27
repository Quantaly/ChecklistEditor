package kpage.chklists.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import kpage.chklists.Checklist;
import kpage.chklists.utils.XMLParser;

public class XMLIO implements FileIOAgent {

	@Override
	public Checklist load(String path) {
		try {
			return XMLParser.parseChecklist(path);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Checklist load(Path path) {
		return load(path.toString());
	}

	@Override
	public boolean save(String path, Checklist checklist) {
		return save(Paths.get(path), checklist);
	}

	@Override
	public boolean save(Path path, Checklist checklist) {
		try {
			String xml = checklist.toXML();
			Files.write(path, xml.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
