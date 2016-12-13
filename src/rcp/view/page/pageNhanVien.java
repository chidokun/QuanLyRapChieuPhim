/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.page;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.ResourceManager;

public class pageNhanVien extends Composite {
	private Text text;
	private Text text_1;
	private Table table;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageNhanVien(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);

		Composite searchPan = new Composite(this, SWT.NONE);
		GridData gd_searchPan = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_searchPan.widthHint = 280;
		searchPan.setLayoutData(gd_searchPan);
		searchPan.setBackground(SWTResourceManager.getColor(240,240,240));

		Label lblNewLabel = new Label(searchPan, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(31,116,71));
		lblNewLabel.setBackground(SWTResourceManager.getColor(240,240,240));
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblNewLabel.setBounds(29, 17, 176, 23);
		lblNewLabel.setText("Tra cứu nhân viên");

		Button btnCheckButton = new Button(searchPan, SWT.CHECK);
		btnCheckButton.setSelection(true);
		btnCheckButton.setBounds(29, 54, 197, 16);
		btnCheckButton.setBackground(SWTResourceManager.getColor(240,240,240));
		btnCheckButton.setText("Theo tên nhân viên");

		text = new Text(searchPan, SWT.BORDER);
		text.setBounds(29, 85, 228, 25);

		Button btnTheoChcV = new Button(searchPan, SWT.CHECK);
		btnTheoChcV.setText("Theo chức vụ");
		btnTheoChcV.setBackground(SWTResourceManager.getColor(240,240,240));
		btnTheoChcV.setBounds(29, 131, 197, 16);

		Combo combo = new Combo(searchPan, SWT.NONE);
		combo.setBounds(29, 164, 228, 23);

		Button btnTheoCmnd = new Button(searchPan, SWT.CHECK);
		btnTheoCmnd.setText("Theo CMND");
		btnTheoCmnd.setBackground(SWTResourceManager.getColor(240,240,240));
		btnTheoCmnd.setBounds(29, 212, 197, 16);

		text_1 = new Text(searchPan, SWT.BORDER);
		text_1.setBounds(29, 246, 228, 25);

		Button btnNewButton = new Button(searchPan, SWT.NONE);
		btnNewButton.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/zoom_16x16.png"));
		btnNewButton.setBounds(81, 301, 86, 30);
		btnNewButton.setText("Tìm kiếm");

		Button btntLi = new Button(searchPan, SWT.NONE);
		btntLi.setImage(SWTResourceManager.getImage(
				"D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\refresh2_16x16.png"));
		btntLi.setText("Đặt lại");
		btntLi.setBounds(171, 301, 86, 30);

		Composite composite_2 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_2 = new GridLayout(3, false);
		gl_composite_2.horizontalSpacing = 4;
		gl_composite_2.marginTop = 10;
		gl_composite_2.marginWidth = 15;
		composite_2.setLayout(gl_composite_2);
		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite_2.heightHint = 369;
		gd_composite_2.widthHint = 398;
		composite_2.setLayoutData(gd_composite_2);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Button btnThm = new Button(composite_2, SWT.NONE);
		btnThm.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/additem_16x16.png"));
		GridData gd_btnThm = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnThm.widthHint = 86;
		gd_btnThm.heightHint = 30;
		btnThm.setLayoutData(gd_btnThm);
		btnThm.setText("Thêm");

		Button btnSa = new Button(composite_2, SWT.NONE);
		btnSa.setImage(SWTResourceManager.getImage(
				"D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\edit_16x16.png"));
		GridData gd_btnSa = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSa.widthHint = 86;
		gd_btnSa.heightHint = 30;
		btnSa.setLayoutData(gd_btnSa);
		btnSa.setText("Sửa");

		Button btnHinTtC = new Button(composite_2, SWT.NONE);
		btnHinTtC.setImage(SWTResourceManager.getImage(
				"D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\show_16x16.png"));
		GridData gd_btnHinTtC = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnHinTtC.widthHint = 100;
		gd_btnHinTtC.heightHint = 30;
		btnHinTtC.setLayoutData(gd_btnHinTtC);
		btnHinTtC.setText("Hiện tất cả");

		TableViewer tableViewer = new TableViewer(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.setColumnProperties(new String[] { "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính",
				"Địa chỉ", "CMND", "Email", "SĐT", "Chức vụ", "Ngày vào làm", "Trạng thái" });
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		TableColumn tblclmnMNhnVin = new TableColumn(table, SWT.NONE);
		tblclmnMNhnVin.setWidth(100);
		tblclmnMNhnVin.setText("Mã nhân viên");

		TableColumn tblclmnHVTn_1 = new TableColumn(table, SWT.NONE);
		tblclmnHVTn_1.setWidth(100);
		tblclmnHVTn_1.setText("Họ và tên");

		TableColumn tblclmnHVTn = new TableColumn(table, SWT.NONE);
		tblclmnHVTn.setWidth(100);
		tblclmnHVTn.setText("Ngày sinh");

		TableColumn tblclmnGiiTnh = new TableColumn(table, SWT.NONE);
		tblclmnGiiTnh.setWidth(100);
		tblclmnGiiTnh.setText("Giới tính");

		TableColumn tblclmnaCh = new TableColumn(table, SWT.NONE);
		tblclmnaCh.setWidth(100);
		tblclmnaCh.setText("Địa chỉ");

		TableColumn tblclmnCmnd = new TableColumn(table, SWT.NONE);
		tblclmnCmnd.setWidth(100);
		tblclmnCmnd.setText("CMND");

		TableColumn tblclmnEmail = new TableColumn(table, SWT.NONE);
		tblclmnEmail.setWidth(100);
		tblclmnEmail.setText("Email");

		TableColumn tblclmnSt = new TableColumn(table, SWT.NONE);
		tblclmnSt.setWidth(100);
		tblclmnSt.setText("SĐT");

		TableColumn tblclmnChcV = new TableColumn(table, SWT.NONE);
		tblclmnChcV.setWidth(100);
		tblclmnChcV.setText("Chức vụ");

		TableColumn tblclmnNgyVoLm = new TableColumn(table, SWT.NONE);
		tblclmnNgyVoLm.setWidth(100);
		tblclmnNgyVoLm.setText("Ngày vào làm");

		TableColumn tblclmnTrngThi = new TableColumn(table, SWT.NONE);
		tblclmnTrngThi.setWidth(100);
		tblclmnTrngThi.setText("Trạng thái");
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
