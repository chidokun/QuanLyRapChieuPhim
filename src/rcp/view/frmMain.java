/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;
import rcp.view.page.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class frmMain extends Shell {

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmMain(Display display) {
		super(display, SWT.SHELL_TRIM);
		setSize(973, 529);
		setText("Quản lý Rạp chiếu phim");
		setMinimumSize(new Point(136, 50));
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.marginHeight = 0;
		gl_composite.horizontalSpacing = 0;
		gl_composite.verticalSpacing = 0;
		gl_composite.marginWidth = 0;
		composite.setLayout(gl_composite);
		GridData gd_composite = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_composite.heightHint = 100;
		composite.setLayoutData(gd_composite);
		
		TabFolder tabFolder = new TabFolder(composite, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TabItem tbtmDanhMc = new TabItem(tabFolder, SWT.NONE);
		tbtmDanhMc.setText("Danh mục");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmDanhMc.setControl(composite_1);
		
		
		
		TabItem tbtmNghipV = new TabItem(tabFolder, SWT.NONE);
		tbtmNghipV.setText("Nghiệp vụ");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmNghipV.setControl(composite_2);
		
		TabItem tbtmHThng = new TabItem(tabFolder, SWT.NONE);
		tbtmHThng.setText("Hệ thống");
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		tbtmHThng.setControl(composite_3);
		
		Composite content = new Composite(this, SWT.NONE);
		content.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridLayout gl_content = new GridLayout(1, false);
		gl_content.marginTop = 3;
		gl_content.verticalSpacing = 0;
		gl_content.marginWidth = 0;
		gl_content.marginHeight = 0;
		gl_content.horizontalSpacing = 0;
		content.setLayout(gl_content);
		content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Quản lý Rạp chiếu phim");
		setSize(667, 398);
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
