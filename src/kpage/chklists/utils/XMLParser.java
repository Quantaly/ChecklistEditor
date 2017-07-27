package kpage.chklists.utils;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import kpage.chklists.*;

public class XMLParser {
	private XMLParser() {
	}

	public static Checklist parseChecklist(String path) throws Exception {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(path);
		doc.getDocumentElement().normalize();
		Node root = doc.getDocumentElement();
		return getList(root);
	}

	protected static Checklist getList(Node list) {
		ArrayList<ChecklistItem> items = new ArrayList<>();
		ArrayList<Heading> subheadings = new ArrayList<>();
		for (Node next = list.getFirstChild(); next != null; next = next.getNextSibling()) {
			if (next.getNodeType() == Node.ELEMENT_NODE) {
				if (next.getNodeName() == "item") {
					ChecklistItem nitem = itemFrom(next);
					if (nitem != null) items.add(nitem);
				} else if (next.getNodeName() == "head") {
					Heading nhead = headFrom(next);
					if (nhead != null) subheadings.add(nhead);
				}
			}
		}
		return new Checklist(items, subheadings);
	}

	protected static ChecklistItem itemFrom(Node node) {
		String name = node.getTextContent();

		boolean checked;
		Node rchk = node.getAttributes().getNamedItem("checked");
		if (rchk == null) checked = false;
		else checked = rchk.getNodeValue().equals("true");

		String notes = null;
		Node rnte = node.getAttributes().getNamedItem("notes");
		if (rnte != null) notes = rnte.getNodeValue();

		return new ChecklistItem(checked, name, notes);
	}

	protected static Heading headFrom(Node node) {
		String name;
		Node rname = node.getAttributes().getNamedItem("name");
		if (rname != null) name = rname.getNodeValue();
		else return null; if (name == null) return null; // you can't have a heading without a name

		Checklist list = getList(node);
		return new Heading(name, list.getItems(), list.getSubheadings());
	}
}
