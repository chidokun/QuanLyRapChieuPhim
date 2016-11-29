package rcp.view.popup;



import java.io.IOException;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;

import rcp.util.*;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class frmDangNhap extends Shell {
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			frmDangNhap shell = new frmDangNhap(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 * @throws IOException 
	 */
	public frmDangNhap(Display display) throws IOException {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite.setLayout(null);
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_1.setBackgroundImage(Images.get(getDisplay(),"res/imgDangNhap_64p.png"));
		composite_1.setBounds(66, 37, 64, 64);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblNewLabel.setForeground(SWTResourceManager.getColor(34, 139, 34));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(145, 37, 197, 35);
		lblNewLabel.setText("Đăng nhập");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setBounds(145, 70, 233, 31);
		lblNewLabel_1.setText("Vui lòng nhập tên đăng nhập và mật khẩu");
		
		Label lblTnngNhp = new Label(composite, SWT.NONE);
		lblTnngNhp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnngNhp.setBounds(66, 120, 89, 15);
		lblTnngNhp.setText("Tên đăng nhập:");
		
		Label lblMtKhu = new Label(composite, SWT.NONE);
		lblMtKhu.setText("Mật khẩu:");
		lblMtKhu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMtKhu.setBounds(66, 165, 81, 15);
		
		text = new Text(composite, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text.setBounds(163, 117, 203, 26);
		
		text_1 = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		text_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		text_1.setBounds(163, 159, 203, 26);
		
		Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(245, 245, 245));
		composite_2.setBounds(0, 207, 453, 53);
		composite_2.setLayout(null);
		
		Button btnThot = new Button(composite_2, SWT.NONE);
		btnThot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getDisplay().close();
			}
		});
		btnThot.setBounds(349, 10, 94, 33);
		btnThot.setText("Thoát");
		
		Button btnngNhp = new Button(composite_2, SWT.NONE);
		btnngNhp.setBounds(249, 10, 94, 33);
		btnngNhp.setText("Đăng nhập");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Đăng nhập");
		setSize(459, 289);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
