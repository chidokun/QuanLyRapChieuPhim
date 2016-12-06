package rcp.view.popup;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ComboViewer;

public class frmThemSuaNhanVien extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			frmThemSuaNhanVien shell = new frmThemSuaNhanVien(display);
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
	public frmThemSuaNhanVien(Display display) {
		super(display, SWT.SHELL_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 495, 714, 64);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setBounds(457, 29, 94, 33);
		btnNewButton.setText("Lưu");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setBounds(579, 29, 94, 33);
		btnNewButton_1.setText("Hủy");
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(37, 89, 88, 15);
		lblNewLabel.setText("Mã nhân viên :");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(131, 89, 197, 24);
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Thêm sửa nhân viên");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(34, 139, 34));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(174, 16, 197, 35);
		
		Label lblHnh = new Label(this, SWT.NONE);
		lblHnh.setText("hình");
		lblHnh.setForeground(SWTResourceManager.getColor(34, 139, 34));
		lblHnh.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblHnh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHnh.setBounds(106, 16, 64, 64);
		
		Label lblTnNhnVin = new Label(this, SWT.NONE);
		lblTnNhnVin.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnNhnVin.setText("Họ tên :");
		lblTnNhnVin.setBounds(37, 139, 70, 15);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(131, 136, 197, 24);
		
		Label lblNgySinh = new Label(this, SWT.NONE);
		lblNgySinh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgySinh.setText("Ngày sinh :");
		lblNgySinh.setBounds(37, 185, 70, 15);
		
		DateTime dateTime = new DateTime(this, SWT.BORDER);
		dateTime.setBounds(131, 185, 197, 24);
		
		Label lblaCh = new Label(this, SWT.NONE);
		lblaCh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblaCh.setText("Địa chỉ :");
		lblaCh.setBounds(37, 238, 55, 15);
		
		text_2 = new Text(this, SWT.BORDER);
		text_2.setBounds(131, 238, 197, 24);
		
		Label lblCmnd = new Label(this, SWT.NONE);
		lblCmnd.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblCmnd.setText("CMND :");
		lblCmnd.setBounds(37, 289, 55, 15);
		
		text_3 = new Text(this, SWT.BORDER);
		text_3.setBounds(131, 289, 197, 24);
		
		Label lblTrngThi = new Label(this, SWT.NONE);
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTrngThi.setText("Trạng thái :");
		lblTrngThi.setBounds(37, 338, 55, 15);
		
		Button btnNam = new Button(this, SWT.RADIO);
		btnNam.setText("Nam");
		btnNam.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNam.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNam.setBounds(487, 88, 90, 16);
		
		Button btnN = new Button(this, SWT.RADIO);
		btnN.setText("Nữ");
		btnN.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnN.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnN.setBounds(594, 88, 90, 16);
		
		text_4 = new Text(this, SWT.BORDER);
		text_4.setBounds(487, 133, 197, 24);
		
		Label lblEmail = new Label(this, SWT.NONE);
		lblEmail.setText("Email :");
		lblEmail.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEmail.setBounds(383, 136, 55, 15);
		
		Label lblSt = new Label(this, SWT.NONE);
		lblSt.setText("SĐT :");
		lblSt.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSt.setBounds(383, 185, 55, 15);
		
		text_5 = new Text(this, SWT.BORDER);
		text_5.setBounds(487, 185, 197, 24);
		
		Label lblChcV = new Label(this, SWT.NONE);
		lblChcV.setText("Chức vụ :");
		lblChcV.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblChcV.setBounds(383, 238, 55, 15);
		
		Label lblNgyVoLm = new Label(this, SWT.NONE);
		lblNgyVoLm.setText("Ngày vào làm :");
		lblNgyVoLm.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgyVoLm.setBounds(388, 289, 93, 15);
		
		DateTime dateTime_1 = new DateTime(this, SWT.BORDER);
		dateTime_1.setBounds(487, 289, 197, 24);
		
		Label lblTnngNhp = new Label(this, SWT.NONE);
		lblTnngNhp.setText("Tên đăng nhập :");
		lblTnngNhp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnngNhp.setBounds(37, 429, 88, 15);
		
		text_6 = new Text(this, SWT.BORDER);
		text_6.setBounds(131, 426, 197, 24);
		
		Label lblQuyn = new Label(this, SWT.NONE);
		lblQuyn.setText("Quyền :");
		lblQuyn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblQuyn.setBounds(388, 426, 55, 15);
		
		Label lblGiiTnh = new Label(this, SWT.NONE);
		lblGiiTnh.setText("Giới tính :");
		lblGiiTnh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGiiTnh.setBounds(383, 89, 55, 15);
		
		Button btnToTiKhon = new Button(this, SWT.CHECK);
		btnToTiKhon.setText("Tạo tài khoản");
		btnToTiKhon.setSelection(true);
		btnToTiKhon.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnToTiKhon.setBounds(64, 390, 197, 16);
		
		ComboViewer comboViewer = new ComboViewer(this, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setBounds(131, 335, 197, 23);
		
		ComboViewer comboViewer_1 = new ComboViewer(this, SWT.NONE);
		Combo combo_1 = comboViewer_1.getCombo();
		combo_1.setBounds(487, 238, 197, 23);
		
		ComboViewer comboViewer_2 = new ComboViewer(this, SWT.NONE);
		Combo combo_2 = comboViewer_2.getCombo();
		combo_2.setBounds(487, 418, 197, 23);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("Vui lòng nhập đầy đủ thông tin");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(174, 57, 201, 15);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Thêm sửa nhân viên :");
		setSize(730, 605);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
