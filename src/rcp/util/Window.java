/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */
package rcp.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
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
	
	
	/**
	 * Mở page lên tabs
	 * @param controller
	 * @param page
	 * @param title
	 */
	public static void openPageInTab(CTabFolder controller, Composite page, String title) {
		/*for (Control i : controlled.getChildren()) {
			if (i.getClass().equals(page.getClass())) {
				i.setFocus();
				return;
			}
		}*/

		CTabItem tabItem = new CTabItem(controller, SWT.NONE);
		tabItem.setText(title);
		tabItem.setControl(page);
		tabItem.setShowClose(true);
		controller.setSelection(tabItem);
		controller.layout();
	}
	
	public static void open(Shell shell) {
		shell.open();
		shell.layout();

		while (!shell.isDisposed()) {
			if (!shell.getDisplay().readAndDispatch()) {
				shell.getDisplay().sleep();
			}
		}
	}
}
