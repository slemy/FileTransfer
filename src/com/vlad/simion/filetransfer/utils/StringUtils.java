package com.vlad.simion.filetransfer.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtils {

	public static boolean isEmptyOrBlank(String str) {
		return (str == null) || (str.trim().length() == 0);
	}

	public static boolean equals(Object value1, Object value2) {
		if (value1 == value2) {
			return true;
		}

		if (value1 != null) {
			return value1.equals(value2);
		}

		return false;
	}

	public static boolean equalsStrings(String value1, String value2) {

		if ((value1 == null && "".equals(value2))
				|| ("".equals(value1) && value2 == null))
			return true;

		return equals(value1, value2);
	}

	public static boolean containsOnlyNumberCharacters(String str) {
		if (str == null || str.length() == 0)
			return false;

		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}
		return true;
	}

	public static String[] TokenateString(String toTokenate, String delimiter) {
		StringTokenizer st1 = new StringTokenizer(toTokenate, delimiter);

		List<String> strings = new ArrayList<String>();
		while (st1.hasMoreTokens())
			strings.add(st1.nextToken());

		return strings.toArray(new String[] {});
	}

	public static String createTokenableString(String[] tokens, String delimiter) {
		if (tokens == null || tokens.length == 0)
			return "";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tokens.length; i++) {
			sb.append(tokens[i]);
			if (i != tokens.length - 1)
				sb.append(delimiter);
		}
		return sb.toString();
	}

	public static boolean hasThisEndings(String fullString, String prefix,
			String suffix) {
		return fullString.startsWith(prefix) && fullString.endsWith(suffix);
	}

	public static String eliminateEndings(String fullString, String prefix,
			String suffix) {
		return fullString.substring(fullString.indexOf(prefix) + 1,
				fullString.indexOf(suffix));
	}

	static public boolean getBoolean(String v) {

		if (v == null || v.equalsIgnoreCase("n") || v.equalsIgnoreCase("0")
				|| v.equalsIgnoreCase("false") || v.equalsIgnoreCase("f")) {

			return false;
		}

		return true;
	}
}