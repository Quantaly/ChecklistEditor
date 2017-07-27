package kpage.chklists.tests;

import kpage.chklists.Checklist;
import kpage.chklists.fileio.*;

public class XMLTest {
	public static void main(String[] args) {
		Checklist orig = IOAgents.TEXT.load("C:\\Users\\kaibu\\workspace\\ChecklistEditor\\sample.ckl");
		System.out.println("Original checklist");
		System.out.println(orig);
		System.out.println();
		
		Checklist xmlList = IOAgents.XML.load("C:\\Users\\kaibu\\workspace\\ChecklistEditor\\sample.xml");
		System.out.println("XML Checklist");
		System.out.println(xmlList);
		System.out.println();
		
		System.out.println("XML of Checklist");
		System.out.println(xmlList.toXML());
		System.out.println();
	}
}
