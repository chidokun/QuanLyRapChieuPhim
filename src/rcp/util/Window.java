/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */
package rcp.util;

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Window {
	/**
	 * Hiển thị cửa sổ ra giữa màn hình
	 * @param display
	 * @param shell
	 */
	public static void center(Display display, Shell shell) {
		Rectangle dBound = display.getPrimaryMonitor().getBounds();
		Rectangle sBound = shell.getBounds();
		
		int h = dBound.y + (dBound.height - sBound.height) / 2;
		int w = dBound.x + (dBound.width - sBound.width) / 2;
		
		shell.setLocation(w, h);
	}
}
