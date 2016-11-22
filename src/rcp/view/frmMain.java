package rcp.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FormLayout;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.custom.StackLayout;
import swing2swt.layout.BoxLayout;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.graphics.Point;

public class frmMain extends Shell {

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmMain(Display display) {
		super(display, SWT.SHELL_TRIM);
		setMinimumSize(new Point(136, 50));
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(new BorderLayout(0, 0));
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		composite_1.setLayoutData(BorderLayout.NORTH);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(BorderLayout.CENTER);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Quản lý Rạp chiếu phim");
		setSize(594, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
