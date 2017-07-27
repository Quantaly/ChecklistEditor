package kpage.chklists.utils;

import java.util.ArrayList;

import kpage.chklists.*;

public class ChecklistParser {
	private ChecklistParser() {
	}

	public static Checklist parseChecklist(String text) {
		ArrayList<ChecklistItem> items = new ArrayList<>();
		ArrayList<Heading> heads = new ArrayList<>();
		String[] lines = text.split("\n");
		int line = 0;
		String curLine;
		ChecklistItem curItem;

		// Uncategorized items loop
		for (; line < lines.length; line++) {
			curLine = lines[line];
			curItem = itemFrom(curLine);
			if (curItem != null) items.add(curItem);
			else if (curLine.startsWith("~")) break; // headers are starting
		}

		// Headers loop
		for (; line < lines.length; line++) {
			curLine = lines[line];
			if (curLine.startsWith("~~ ") && curLine.endsWith(" ~~")) {

				String headName = curLine.substring(3, curLine.length() - 3);
				ArrayList<ChecklistItem> headItems = new ArrayList<>();
				ArrayList<Heading> subHeads = new ArrayList<>();
				line++;
				for (; line < lines.length; line++) { // begin header
					curLine = lines[line];
					curItem = itemFrom(curLine);
					if (curItem != null) headItems.add(curItem);
					while (curLine.startsWith("~ ")) {

						String subHeadName = curLine.substring(2);
						ArrayList<ChecklistItem> subHeadItems = new ArrayList<>();
						line++;
						for (; line < lines.length; line++) { // begin subheader
							curLine = lines[line];
							curItem = itemFrom(curLine);
							if (curItem != null) subHeadItems.add(curItem);
							else if (curLine.startsWith("~")) break; // could be a new header or subheader
						}
						subHeads.add(new Heading(subHeadName, subHeadItems));
					}
					if (curLine.startsWith("~~ ")) break; // new header
				}
				heads.add(new Heading(headName, headItems, subHeads));
				line--; // make sure header loop looks at this line again
			}
		}

		return new Checklist(items, heads);
	}

	protected static ChecklistItem itemFrom(String text) {
		boolean checked;
		try {
			switch (text.substring(0, 4)) {
			case "[ ] ":
				checked = false;
				break;
			case "[*] ":
				checked = true;
				break;
			default:
				return null;
			}
		} catch (StringIndexOutOfBoundsException e) {
			return null;
		}
		String[] itemProp = text.substring(4).split(" \\| ");
		if (itemProp.length > 1) return new ChecklistItem(checked, itemProp[0], itemProp[1]);
		else return new ChecklistItem(checked, itemProp[0], null);
	}
}
