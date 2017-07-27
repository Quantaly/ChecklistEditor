package kpage.chklists.fileio;

import java.nio.file.Path;

import kpage.chklists.Checklist;

public interface FileIOAgent {
	public Checklist load(String path);
	public Checklist load(Path path);
	
	public boolean save(String path, Checklist checklist);
	public boolean save(Path path, Checklist checklist);
}
