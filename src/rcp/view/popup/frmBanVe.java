/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class frmBanVe extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_9;
	private Table table;
	private Text text_3;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmBanVe(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Bán vé");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 176, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/imgThucAn_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Label lblMThcn = new Label(this, SWT.NONE);
		lblMThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMThcn.setText("Mã nhân viên:");
		lblMThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMThcn.setBounds(23, 102, 75, 15);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(109, 99, 141, 24);
		
		ControlDecoration controlDecoration = new ControlDecoration(text, SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText("Some description");
		
		Label lblTnThcn = new Label(this, SWT.NONE);
		lblTnThcn.setText("Mã khách hàng");
		lblTnThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnThcn.setBounds(23, 147, 86, 15);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(109, 144, 141, 24);
		
		Label lblnGi = new Label(this, SWT.NONE);
		lblnGi.setText("Tên phim:");
		lblnGi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblnGi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblnGi.setBounds(23, 195, 75, 15);
		
		Label lblLoiThcn = new Label(this, SWT.NONE);
		lblLoiThcn.setText("Ngày bán vé:");
		lblLoiThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblLoiThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLoiThcn.setBounds(277, 102, 75, 15);
		
		Label lblKchC = new Label(this, SWT.NONE);
		lblKchC.setText("Mã suất chiếu");
		lblKchC.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblKchC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblKchC.setBounds(277, 150, 75, 15);
		
		Label lblTrngThi = new Label(this, SWT.NONE);
		lblTrngThi.setText("Suất phim");
		lblTrngThi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTrngThi.setBounds(277, 196, 75, 15);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 507, 529, 56);
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setText("Lưu");
		btnLu.setBounds(325, 10, 94, 33);
		
		Button btnHyB = new Button(composite, SWT.NONE);
		btnHyB.setText("Hủy bỏ");
		btnHyB.setBounds(425, 10, 94, 33);
		
		text_2 = new Text(this, SWT.BORDER);
		text_2.setBounds(358, 144, 141, 24);
		
		text_4 = new Text(this, SWT.BORDER);
		text_4.setBounds(109, 192, 141, 24);
		
		text_5 = new Text(this, SWT.BORDER);
		text_5.setBounds(358, 195, 141, 24);
		
		Label lblGiChiu = new Label(this, SWT.NONE);
		lblGiChiu.setText("Giờ chiếu:");
		lblGiChiu.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblGiChiu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGiChiu.setBounds(23, 245, 75, 15);
		
		text_6 = new Text(this, SWT.BORDER);
		text_6.setBounds(109, 242, 141, 24);
		
		Label lblPhngChiu = new Label(this, SWT.NONE);
		lblPhngChiu.setText("Phòng chiếu:");
		lblPhngChiu.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblPhngChiu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPhngChiu.setBounds(277, 245, 75, 15);
		
		text_9 = new Text(this, SWT.BORDER);
		text_9.setBounds(358, 242, 141, 24);
		
		DateTime dateTime = new DateTime(this, SWT.BORDER);
		dateTime.setBounds(358, 99, 141, 24);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(23, 336, 476, 165);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnMV = new TableColumn(table, SWT.NONE);
		tblclmnMV.setWidth(100);
		tblclmnMV.setText("Mã vé");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(78);
		tblclmnNewColumn.setText("Ghế");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Giá vé");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Khuyến mãi");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("Điểm tích lũy");
		
		Label lblTngTin = new Label(this, SWT.NONE);
		lblTngTin.setText("Tổng tiền:");
		lblTngTin.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTngTin.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTngTin.setBounds(277, 294, 75, 15);
		
		text_3 = new Text(this, SWT.BORDER);
		text_3.setBounds(358, 289, 141, 24);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Bán vé");
		setSize(535, 592);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
