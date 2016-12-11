/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.util;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

/**
 * @author Tuan
 *
 */
public class XML {
	/**
	 * Mở tài liệu XML
	 * 
	 * @param fileName
	 *            Đường dẫn đến tài liệu
	 * @return Đối tượng <Document> đến tài liệu đó
	 * @throws Exception
	 */
	public static Document open(String fileName) throws Exception {
		return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileName);
	}

	/**
	 * Tạo mới tài liệu XML trên bộ nhớ
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Document newDocument() throws Exception {
		return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	}

	/**
	 * Ghi tài liệu XML
	 * 
	 * @param doc
	 *            Đối tượng <Document> chứa cây tài liệu cần ghi
	 * @param fileName
	 *            Đường dẫn đến tài liệu
	 * @throws Exception
	 */
	public static void writeDocument(Document doc, String fileName) throws Exception {
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(fileName));
		TransformerFactory.newInstance().newTransformer().transform(source, result);
	}
}
