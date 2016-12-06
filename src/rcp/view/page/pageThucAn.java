/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.view.page;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

public class pageThucAn extends Composite {
	private Text text;
	private Table table;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageThucAn(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);

		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblNewLabel.setBounds(29, 17, 176, 23);
		lblNewLabel.setText("Tra cứu thức ăn");

		Button btnCheckButton = new Button(composite, SWT.CHECK);
		btnCheckButton.setSelection(true);
		btnCheckButton.setBounds(29, 54, 197, 16);
		btnCheckButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnCheckButton.setText("Theo tên thức ăn");

		text = new Text(composite, SWT.BORDER);
		text.setBounds(29, 85, 228, 25);

		Button btnTheoChcV = new Button(composite, SWT.CHECK);
		btnTheoChcV.setText("Theo loại thức ăn");
		btnTheoChcV.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnTheoChcV.setBounds(29, 131, 197, 16);

		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBounds(29, 164, 228, 23);

		Button btnTheoCmnd = new Button(composite, SWT.CHECK);
		btnTheoCmnd.setText("Theo kích cỡ");
		btnTheoCmnd.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnTheoCmnd.setBounds(29, 212, 197, 16);

		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage(
				"D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\zoom_16x16.png"));
		btnNewButton.setBounds(81, 301, 86, 30);
		btnNewButton.setText("Tìm kiếm");

		Button btntLi = new Button(composite, SWT.NONE);
		btntLi.setImage(SWTResourceManager.getImage(
				"D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\refresh2_16x16.png"));
		btntLi.setText("Đặt lại");
		btntLi.setBounds(171, 301, 86, 30);

		Combo combo_1 = new Combo(composite, SWT.NONE);
		combo_1.setBounds(29, 246, 228, 23);

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
		tblclmnMNhnVin.setWidth(50);
		tblclmnMNhnVin.setText("STT");

		TableColumn tblclmnHVTn_1 = new TableColumn(table, SWT.NONE);
		tblclmnHVTn_1.setWidth(111);
		tblclmnHVTn_1.setText("Mã số");

		TableColumn tblclmnHVTn = new TableColumn(table, SWT.NONE);
		tblclmnHVTn.setWidth(170);
		tblclmnHVTn.setText("Tên thức ăn");

		TableColumn tblclmnGiiTnh = new TableColumn(table, SWT.NONE);
		tblclmnGiiTnh.setWidth(100);
		tblclmnGiiTnh.setText("Kích cỡ");

		TableColumn tblclmnaCh = new TableColumn(table, SWT.NONE);
		tblclmnaCh.setWidth(127);
		tblclmnaCh.setText("Đơn giá");

		TableColumn tblclmnCmnd = new TableColumn(table, SWT.NONE);
		tblclmnCmnd.setWidth(100);
		tblclmnCmnd.setText("Loại thức ăn");
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
