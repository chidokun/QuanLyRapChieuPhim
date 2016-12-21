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
	private static Hashtable<String, Object> settings = new Hashtable<>();
	public static String currentUser;

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
		
		//cài đặt kết nối CSDL
		settings.put("hostName", "");
		settings.put("schemaName", "");
		settings.put("userName", "");
		settings.put("password", "");
		settings.put("connectionString", "");
		
		//cài đặt mysql
		settings.put("mySQLBin", "");
		
		//cài đặt login
		settings.put("saveLoginName", true);
		settings.put("loginName", "");
		
		//cài đặt thông tin rạp phim
		settings.put("cinemaName", "Rạp chiếu phim RPP");
		settings.put("cinemaAddr", "Khu phố 6, phường Linh Trung, quận Thủ Đức, TP. HCM");
		settings.put("cinemaTel", "0123456789");
		settings.put("cinemaEmail", "support@rpp.com");
		
		//cài đặt theme
		settings.put("theme_ribbonTabBackground", 0x227447);
		settings.put("theme_ribbonTabActive", 0xf1f1f1);
		settings.put("theme_ribbonTabHeaderActive", 0x227447);
		settings.put("theme_ribbonTabHeaderInactive", 0xffffff);
		settings.put("theme_ribbonButtonText", 0xffffff);
		settings.put("theme_ribbonButtonHoverBackground", 0x2e955d);
		settings.put("theme_ribbonButtonClickBackground", 0x0d582f);
		settings.put("theme_ribbonToolbarBackground", 0xf1f1f1);
		settings.put("theme_ribbonToolbarTextColor", 0x444444);
		settings.put("theme_ribbonToolbarButtonHoverBackground", 0xc5c5c5);
		settings.put("theme_ribbonToolbarButtonClickBackground", 0xaeaeae);
		
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
}
