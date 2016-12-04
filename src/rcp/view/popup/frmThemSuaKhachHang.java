/* Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.view.popup;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;

public class frmThemSuaKhachHang extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_7;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			frmThemSuaKhachHang shell = new frmThemSuaKhachHang(display);
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
	 */
	public frmThemSuaKhachHang(Display display) {
		super(display, SWT.SHELL_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lblThmSaKhch = new Label(this, SWT.NONE);
		lblThmSaKhch.setText("Thêm sửa khách hàng");
		lblThmSaKhch.setForeground(SWTResourceManager.getColor(34, 139, 34));
		lblThmSaKhch.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblThmSaKhch.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaKhch.setBounds(147, 10, 197, 35);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("hình");
		label_1.setForeground(SWTResourceManager.getColor(34, 139, 34));
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setBounds(79, 10, 64, 64);
		
		Label lblMKhchHng = new Label(this, SWT.NONE);
		lblMKhchHng.setText("Mã khách hàng");
		lblMKhchHng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMKhchHng.setBounds(37, 89, 88, 15);
		
		Label lblHTnKhch = new Label(this, SWT.NONE);
		lblHTnKhch.setText("Họ tên ");
		lblHTnKhch.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHTnKhch.setBounds(37, 139, 64, 15);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(131, 86, 197, 24);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(131, 136, 197, 24);
		
		text_2 = new Text(this, SWT.BORDER);
		text_2.setBounds(131, 190, 197, 24);
		
		Label lblCmnd = new Label(this, SWT.NONE);
		lblCmnd.setText("CMND");
		lblCmnd.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblCmnd.setBounds(37, 193, 88, 15);
		
		text_3 = new Text(this, SWT.BORDER);
		text_3.setBounds(131, 245, 197, 24);
		
		Label lblEmail = new Label(this, SWT.NONE);
		lblEmail.setText("Email");
		lblEmail.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEmail.setBounds(37, 248, 88, 15);
		
		Button btnRadioButton = new Button(this, SWT.RADIO);
		btnRadioButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnRadioButton.setBounds(131, 304, 90, 16);
		btnRadioButton.setText("Nam");
		
		Button btnRadioButton_1 = new Button(this, SWT.RADIO);
		btnRadioButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnRadioButton_1.setBounds(238, 304, 90, 16);
		btnRadioButton_1.setText("Nữ");
		
		text_4 = new Text(this, SWT.BORDER);
		text_4.setBounds(454, 86, 197, 24);
		
		Label lblNgyngK = new Label(this, SWT.NONE);
		lblNgyngK.setText("Ngày đăng ký");
		lblNgyngK.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgyngK.setBounds(360, 89, 88, 15);
		
		Label lblLoi = new Label(this, SWT.NONE);
		lblLoi.setText("Loại");
		lblLoi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLoi.setBounds(360, 142, 88, 15);
		
		text_7 = new Text(this, SWT.BORDER);
		text_7.setBounds(454, 245, 197, 24);
		
		Label lblDienThoai = new Label(this, SWT.NONE);
		lblDienThoai.setText("Điện thoại");
		lblDienThoai.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDienThoai.setBounds(360, 248, 88, 15);
		
		Label lblGioiTinh = new Label(this, SWT.NONE);
		lblGioiTinh.setText("Giới tính");
		lblGioiTinh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGioiTinh.setBounds(37, 305, 55, 15);
		
		DateTime dateTime = new DateTime(this, SWT.BORDER);
		dateTime.setBounds(454, 190, 197, 24);
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("Ngày sinh");
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setBounds(360, 190, 55, 15);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(null);
		composite.setBackground(SWTResourceManager.getColor(245, 245, 245));
		composite.setBounds(0, 353, 677, 53);
		
		Button button = new Button(composite, SWT.NONE);
		button.setText("Thoát");
		button.setBounds(571, 11, 94, 33);
		
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.setText("Đăng nhập");
		button_1.setBounds(471, 11, 94, 33);
		
		ComboViewer comboViewer = new ComboViewer(this, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setBounds(454, 137, 197, 23);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(693, 440);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
