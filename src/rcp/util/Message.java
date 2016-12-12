/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */
package rcp.util;

import org.eclipse.swt.widgets.*;

/**
 * @author Tuan
 *
 */
public class Message {
	/**
	 * Hiển thị hộp thoại
	 * 
	 * @param message
	 *            Nội dung hộp thoại
	 * @param title
	 *            Tiêu đề
	 * @param style
	 *            Kiểu hộp thoại. Gồm: Kiểu icon: SWT.ICON_xxxx, ... . Kiểu nút:
	 *            SWT.OK, SWT.CANCEL, ... . Kết hợp bằng toán tử |
	 * @param parent
	 *            Cửa sổ cha
	 * @return
	 */
	public static int show(String message, String title, int style, Shell parent) {
		MessageBox ms = new MessageBox(parent, style);
		ms.setMessage(message);
		ms.setText(title);
		return ms.open();
	}
}
