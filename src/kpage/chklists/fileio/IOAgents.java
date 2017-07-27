package kpage.chklists.fileio;

public class IOAgents {
	public static final FileIOAgent TEXT = new TextListIO();
	public static final FileIOAgent XML = new XMLIO();
}
