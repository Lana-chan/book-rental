package util;
public class StringUtils {

	public static String fillOrTruncate(String str, int size, char c) {
		if (str.length() < size) {
			StringBuffer buff = new StringBuffer(str);
			while (buff.length() < size) {
				buff.append(c);
			}

			return buff.toString();
		} else {
			return str.substring(0, size);
		}
	}
}
