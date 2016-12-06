/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.view.popup;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;

public class frmThongTinNhanVien extends Shell {
	private Text text;
	private Text text_2;
	private Text text_1;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmThongTinNhanVien(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Thông tin nhân viên");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 176, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/imgKetNoiCSDL_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Label lblMThcn = new Label(this, SWT.NONE);
		lblMThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMThcn.setText("Mã nhân viên:");
		lblMThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMThcn.setBounds(30, 102, 75, 15);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(109, 99, 141, 24);
		
		Label lblTnThcn = new Label(this, SWT.NONE);
		lblTnThcn.setText("Ngày sinh:");
		lblTnThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnThcn.setBounds(30, 147, 75, 15);
		
		Label lblnGi = new Label(this, SWT.NONE);
		lblnGi.setText("CMND:");
		lblnGi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblnGi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblnGi.setBounds(30, 195, 75, 15);
		
		Label lblLoiThcn = new Label(this, SWT.NONE);
		lblLoiThcn.setText("Tên nhân viên:");
		lblLoiThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblLoiThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLoiThcn.setBounds(277, 102, 77, 15);
		
		Label lblKchC = new Label(this, SWT.NONE);
		lblKchC.setText("Giới tính:");
		lblKchC.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblKchC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblKchC.setBounds(277, 150, 75, 15);
		
		Label lblTrngThi = new Label(this, SWT.NONE);
		lblTrngThi.setText("Chức vụ");
		lblTrngThi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTrngThi.setBounds(277, 196, 75, 15);
		
		text_2 = new Text(this, SWT.BORDER);
		text_2.setBounds(109, 192, 141, 24);
		
		DateTime dateTime = new DateTime(this, SWT.BORDER);
		dateTime.setBounds(109, 147, 141, 24);
		
		ComboViewer comboViewer_1 = new ComboViewer(this, SWT.NONE);
		Combo combo_1 = comboViewer_1.getCombo();
		combo_1.setBounds(358, 147, 141, 23);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(358, 192, 141, 24);
		
		text_3 = new Text(this, SWT.BORDER);
		text_3.setBounds(358, 99, 141, 24);
		
		Label lblSinThoi = new Label(this, SWT.NONE);
		lblSinThoi.setText("Số điện thoại:");
		lblSinThoi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblSinThoi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSinThoi.setBounds(30, 242, 75, 15);
		
		text_4 = new Text(this, SWT.BORDER);
		text_4.setBounds(109, 239, 141, 24);
		
		Label lblEmail = new Label(this, SWT.NONE);
		lblEmail.setText("Email:");
		lblEmail.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblEmail.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEmail.setBounds(279, 242, 75, 15);
		
		text_5 = new Text(this, SWT.BORDER);
		text_5.setBounds(358, 239, 141, 24);
		
		Label lblaCh = new Label(this, SWT.NONE);
		lblaCh.setText("Địa chỉ:");
		lblaCh.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblaCh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblaCh.setBounds(30, 290, 75, 15);
		
		text_6 = new Text(this, SWT.BORDER);
		text_6.setBounds(109, 287, 390, 24);
		
		Label lblNgyVoLm = new Label(this, SWT.NONE);
		lblNgyVoLm.setText("Ngày vào làm:");
		lblNgyVoLm.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNgyVoLm.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgyVoLm.setBounds(30, 334, 75, 15);
		
		DateTime dateTime_1 = new DateTime(this, SWT.BORDER);
		dateTime_1.setBounds(109, 332, 141, 24);
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBounds(0, 558, 526, 56);
		
		Button button = new Button(composite_1, SWT.NONE);
		button.setText("Lưu");
		button.setBounds(325, 10, 94, 33);
		
		Button button_1 = new Button(composite_1, SWT.NONE);
		button_1.setText("Hủy bỏ");
		button_1.setBounds(425, 10, 94, 33);
		
		Group grpThayiMt = new Group(this, SWT.NONE);
		grpThayiMt.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpThayiMt.setText("Thay đổi mật khẩu");
		grpThayiMt.setBounds(30, 377, 469, 166);
		
		Label lblMtKhuC = new Label(grpThayiMt, SWT.NONE);
		lblMtKhuC.setBounds(28, 35, 75, 15);
		lblMtKhuC.setText("Mật khẩu cũ:");
		lblMtKhuC.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMtKhuC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		text_7 = new Text(grpThayiMt, SWT.BORDER);
		text_7.setBounds(164, 35, 264, 24);
		
		Label lblMtKhuMi = new Label(grpThayiMt, SWT.NONE);
		lblMtKhuMi.setBounds(28, 78, 75, 15);
		lblMtKhuMi.setText("Mật khẩu mới:");
		lblMtKhuMi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMtKhuMi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		text_8 = new Text(grpThayiMt, SWT.BORDER);
		text_8.setBounds(164, 78, 264, 24);
		
		Label lblNhpLiMt = new Label(grpThayiMt, SWT.NONE);
		lblNhpLiMt.setBounds(28, 121, 130, 15);
		lblNhpLiMt.setText("Nhập lại mật khẩu mới:");
		lblNhpLiMt.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNhpLiMt.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		text_9 = new Text(grpThayiMt, SWT.BORDER);
		text_9.setBounds(164, 121, 264, 24);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Thông tin nhân viên");
		setSize(530, 643);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
