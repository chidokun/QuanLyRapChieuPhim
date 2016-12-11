/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp;

import java.util.*;
import java.io.*;
import org.w3c.dom.*;
import rcp.util.XML;

/**
 * @author Tuan
 *
 */
public class Settings {
	private static String fileName = System.getenv("appdata") + "\\settings.xml";
	public static Map<String, Object> settings = new Hashtable<>();

	/**
	 * Nạp cài đặt
	 * 
	 * @throws Exception
	 */
	public static void load() throws Exception {
		File f = new File(fileName);
		if (!f.exists())
			loadDefaultSettings();
		else
			loadSettings();
	}

	/**
	 * Nạp cài đặt từ file
	 * 
	 * @throws Exception
	 */
	private static void loadSettings() throws Exception {
		Document doc = XML.open(fileName);
		Element root = doc.getDocumentElement();

		NodeList list = root.getElementsByTagName("item");
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) n;
				String name = e.getAttribute("name");
				Object value = null;

				String type = e.getAttribute("type");
				String tempValue = e.getAttribute("value");
				if (type.equals("double")) {
					value = Double.parseDouble(tempValue);
				} else if (type.equals("int")) {
					value = Integer.parseInt(tempValue);
				} else if (type.equals("string")) {
					value = tempValue;
				} else if (type.equals("boolean")) {
					value = Boolean.parseBoolean(tempValue);
				}

				settings.put(name, value);
			}
		}
	}

	/**
	 * Nạp cài đặt mặc định
	 */
	private static void loadDefaultSettings() {
		settings.clear();
		settings.put("hostname", "");
		settings.put("schemaName", true);
		settings.put("userName", 5.06);
		settings.put("password", 5);
		settings.put("connectionString", "");
		// còn tiếp

	}

	/**
	 * Lấy giá trị một cài đặt
	 * 
	 * @param entry
	 * @return
	 */
	public static Object get(String entry) {
		return settings.get(entry);
	}

	/**
	 * Đặt giá trị một cài đặt
	 * 
	 * @param entry
	 * @param value
	 */
	public static void set(String entry, Object value) {
		settings.replace(entry, value);
	}

	/**
	 * Lưu tất cả cài đặt hiện tại
	 * 
	 * @throws Exception
	 */
	public static void save() throws Exception {
		File f = new File(fileName);
		if (!f.exists())
			saveDefaultSettings();
		else
			saveSettings();
	}

	/**
	 * Lưu tất cả cài đặt vào file
	 * 
	 * @throws Exception
	 */
	private static void saveSettings() throws Exception {
		Document doc = XML.newDocument();
		Element root = doc.createElement("Settings");
		doc.appendChild(root);

		Set<String> keySet = settings.keySet();
		for (String i : keySet) {
			Element e = doc.createElement("item");
			e.setAttribute("name", i);

			Object nValue = settings.get(i);
			String type = null;
			if (nValue instanceof Double) {
				type = "double";
			} else if (nValue instanceof Integer) {
				type = "int";
			} else if (nValue instanceof String) {
				type = "string";
			} else if (nValue instanceof Boolean) {
				type = "boolean";
			}
			e.setAttribute("type", type);
			e.setAttribute("value", String.valueOf(nValue));
			
			root.appendChild(e);
		}

		XML.writeDocument(doc, fileName);
	}

	/**
	 * Lưu cài đặt mặc định
	 * 
	 * @throws Exception
	 */
	private static void saveDefaultSettings() throws Exception {
		loadDefaultSettings();
		saveSettings();
	}
}
