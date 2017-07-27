package kpage.chklists.tests;

import kpage.chklists.fileio.ChecklistBuffer;
import kpage.chklists.fileio.XMLChecklistBuffer;

public class XMLTest {
	public static void main(String[] args) {
		ChecklistBuffer load = new ChecklistBuffer("C:\\Users\\kaibu\\workspace\\ChecklistEditor\\sample.ckl");
		load.load();
		System.out.println("Original checklist");
		System.out.println(load);
		System.out.println();
		
		ChecklistBuffer xml = new XMLChecklistBuffer("C:\\Users\\kaibu\\workspace\\ChecklistEditor\\sample.xml");
		xml.load();
		System.out.println("XML Checklist");
		System.out.println(xml);
		System.out.println();
		
		System.out.println("XML of Checklist");
		System.out.println(xml.toXML());
		System.out.println();
	}
}
