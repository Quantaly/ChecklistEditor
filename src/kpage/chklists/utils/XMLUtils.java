package kpage.chklists.utils;

public class XMLUtils {
	private XMLUtils() {
	}

	public static String escapeChars(String str) {
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("'", "&apos;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
}
