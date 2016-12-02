/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.page;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;

public class pageBaoCaoDoanhThuPhimKhungGio extends Composite {
	private Table table;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageBaoCaoDoanhThuPhimKhungGio(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gridLayout = new GridLayout(10, false);
		gridLayout.marginTop = 7;
		gridLayout.marginHeight = 7;
		gridLayout.marginRight = 15;
		gridLayout.marginLeft = 15;
		setLayout(gridLayout);

		Label lblThng = new Label(this, SWT.NONE);
		lblThng.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblThng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThng.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblThng.setText("Tháng");

		Combo combo = new Combo(this, SWT.NONE);
		combo.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 30;
		combo.setLayoutData(gd_combo);

		Label lblNm = new Label(this, SWT.NONE);
		lblNm.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNm.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNm.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNm.setText("Năm");

		Combo combo_1 = new Combo(this, SWT.NONE);
		combo_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		GridData gd_combo_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo_1.widthHint = 40;
		combo_1.setLayoutData(gd_combo_1);

		Label lblKhungGi = new Label(this, SWT.NONE);
		lblKhungGi.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblKhungGi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblKhungGi.setText("Khung giờ:");

		Button btnhh = new Button(this, SWT.RADIO);
		btnhh.setSelection(true);
		btnhh.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnhh.setText("9h - 13h");
		btnhh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Button btnhh_1 = new Button(this, SWT.RADIO);
		btnhh_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnhh_1.setText("13h - 17h");
		btnhh_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Button btnhh_2 = new Button(this, SWT.RADIO);
		btnhh_2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnhh_2.setText("17h - 21h");
		btnhh_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Button btnNewButton = new Button(this, SWT.NONE);
		GridData gd_btnNewButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.heightHint = 30;
		gd_btnNewButton.widthHint = 86;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnNewButton.setText("Xem");

		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		GridData gd_btnNewButton_1 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_btnNewButton_1.widthHint = 86;
		gd_btnNewButton_1.heightHint = 30;
		btnNewButton_1.setLayoutData(gd_btnNewButton_1);
		btnNewButton_1.setText("In");

		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 10, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnStt = new TableColumn(table, SWT.NONE);
		tblclmnStt.setWidth(44);
		tblclmnStt.setText("STT");

		TableColumn tblclmnMPhim = new TableColumn(table, SWT.NONE);
		tblclmnMPhim.setWidth(118);
		tblclmnMPhim.setText("Mã phim");

		TableColumn tblclmnTnPhim = new TableColumn(table, SWT.NONE);
		tblclmnTnPhim.setWidth(211);
		tblclmnTnPhim.setText("Tên phim");

		TableColumn tblclmnDoanhThu = new TableColumn(table, SWT.NONE);
		tblclmnDoanhThu.setWidth(100);
		tblclmnDoanhThu.setText("Doanh Thu");

		Label lblTngDoanhThu = new Label(this, SWT.NONE);
		lblTngDoanhThu.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblTngDoanhThu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTngDoanhThu.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 10, 1));
		lblTngDoanhThu.setText("Tổng doanh thu: %f");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
