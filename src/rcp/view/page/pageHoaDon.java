/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */

package rcp.view.page;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;

public class pageHoaDon extends Composite {
	private Text text;
	private Table table;
	private Table table_1;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageHoaDon(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);

		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblTraCuKha = new Label(composite, SWT.NONE);
		lblTraCuKha.setText("Tra cứu hóa đơn");
		lblTraCuKha.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblTraCuKha.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuKha.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTraCuKha.setBounds(26, 22, 176, 23);

		Button btnTheoMHa = new Button(composite, SWT.CHECK);
		btnTheoMHa.setText("Theo mã hóa đơn");
		btnTheoMHa.setSelection(true);
		btnTheoMHa.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnTheoMHa.setBounds(26, 59, 197, 16);

		text = new Text(composite, SWT.BORDER);
		text.setBounds(26, 90, 228, 25);

		Button btnTheoKhongThi = new Button(composite, SWT.CHECK);
		btnTheoKhongThi.setText("Theo khoảng thời gian");
		btnTheoKhongThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnTheoKhongThi.setBounds(26, 136, 197, 16);

		Button button_3 = new Button(composite, SWT.NONE);
		button_3.setText("Tìm kiếm");
		button_3.setImage(SWTResourceManager.getImage(
				"D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\zoom_16x16.png"));
		button_3.setBounds(78, 256, 86, 30);

		Button button_4 = new Button(composite, SWT.NONE);
		button_4.setText("Đặt lại");
		button_4.setImage(SWTResourceManager.getImage(
				"D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\refresh2_16x16.png"));
		button_4.setBounds(168, 256, 86, 30);
		
		DateTime dateTime = new DateTime(composite, SWT.BORDER);
		dateTime.setBounds(98, 162, 156, 24);
		
		DateTime dateTime_1 = new DateTime(composite, SWT.BORDER);
		dateTime_1.setBounds(98, 202, 156, 24);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(26, 207, 66, 15);
		lblNewLabel.setText("Đến ngày");
		
		Label lblT = new Label(composite, SWT.NONE);
		lblT.setText("Từ ngày");
		lblT.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblT.setBounds(26, 168, 62, 16);

		Composite composite_1 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(2, false);
		gl_composite_1.marginRight = 5;
		gl_composite_1.marginLeft = 5;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Button btnIn = new Button(composite_1, SWT.NONE);
		GridData gd_btnIn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnIn.heightHint = 30;
		gd_btnIn.widthHint = 100;
		btnIn.setLayoutData(gd_btnIn);
		btnIn.setText("In hóa đơn");
		btnIn.setImage(SWTResourceManager.getImage(
				"D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\zoom_16x16.png"));
		
		Button button = new Button(composite_1, SWT.NONE);
		button.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		button.setText("Hiện tất cả");
		button.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\show_16x16.png"));
		
		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_table.widthHint = 485;
		table.setLayoutData(gd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(50);
		tblclmnNewColumn.setText("STT");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(120);
		tblclmnNewColumn_1.setText("Mã hóa đơn");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Ngày tạo");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(130);
		tblclmnNewColumn_3.setText("Tổng tiền");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("Mã nhân viên");
		
		table_1 = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_table_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table_1.widthHint = 538;
		table_1.setLayoutData(gd_table_1);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnStt = new TableColumn(table_1, SWT.NONE);
		tblclmnStt.setWidth(50);
		tblclmnStt.setText("STT");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_5.setWidth(85);
		tblclmnNewColumn_5.setText("Mã thức ăn");
		
		TableColumn tblclmnTnThcn = new TableColumn(table_1, SWT.NONE);
		tblclmnTnThcn.setWidth(100);
		tblclmnTnThcn.setText("Tên thức ăn");
		
		TableColumn tblclmnKchC = new TableColumn(table_1, SWT.NONE);
		tblclmnKchC.setWidth(100);
		tblclmnKchC.setText("Kích cỡ");
		
		TableColumn tblclmnnGi = new TableColumn(table_1, SWT.NONE);
		tblclmnnGi.setWidth(100);
		tblclmnnGi.setText("Đơn giá");
		
		TableColumn tblclmnSLng = new TableColumn(table_1, SWT.NONE);
		tblclmnSLng.setWidth(100);
		tblclmnSLng.setText("Số lượng");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
