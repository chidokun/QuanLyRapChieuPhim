/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
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
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;

public class pageSuatChieu extends Composite {
	private Text text;
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public pageSuatChieu(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		setLayout(gridLayout);
		
		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.heightHint = 385;
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lblTraCuPhim = new Label(composite, SWT.NONE);
		lblTraCuPhim.setText("Tra cứu");
		lblTraCuPhim.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblTraCuPhim.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuPhim.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTraCuPhim.setBounds(31, 27, 176, 23);
		
		Button btnTheoTnPhim = new Button(composite, SWT.CHECK);
		btnTheoTnPhim.setText("Theo tên phim");
		btnTheoTnPhim.setSelection(true);
		btnTheoTnPhim.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnTheoTnPhim.setBounds(31, 64, 197, 16);
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(31, 95, 228, 25);
		
		Button btnTheoKhongThi = new Button(composite, SWT.CHECK);
		btnTheoKhongThi.setText("Theo khoảng thời gian");
		btnTheoKhongThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnTheoKhongThi.setBounds(31, 141, 197, 16);
		
		Button btnTimKiem = new Button(composite, SWT.NONE);
		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\zoom_16x16.png"));
		btnTimKiem.setBounds(83, 311, 86, 30);
		
		Button btnDatLai = new Button(composite, SWT.NONE);
		btnDatLai.setText("Đặt lại");
		btnDatLai.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\refresh2_16x16.png"));
		btnDatLai.setBounds(173, 311, 86, 30);
		
		DateTime dateTime = new DateTime(composite, SWT.BORDER);
		dateTime.setBounds(103, 214, 156, 24);
		
		DateTime dateTime_1 = new DateTime(composite, SWT.BORDER);
		dateTime_1.setBounds(103, 174, 156, 24);
		
		Label label = new Label(composite, SWT.NONE);
		label.setText("Từ ngày");
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(31, 180, 62, 16);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("Đến ngày");
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setBounds(31, 219, 66, 15);
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_1 = new GridLayout(3, false);
		gl_composite_1.marginTop = 10;
		gl_composite_1.marginWidth = 15;
		composite_1.setLayout(gl_composite_1);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite_1.widthHint = 785;
		gd_composite_1.heightHint = 371;
		composite_1.setLayoutData(gd_composite_1);
		
		Button button = new Button(composite_1, SWT.NONE);
		GridData gd_button = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button.heightHint = 30;
		gd_button.widthHint = 86;
		button.setLayoutData(gd_button);
		button.setText("Thêm");
		button.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\additem_16x16.png"));
		
		Button button_1 = new Button(composite_1, SWT.NONE);
		GridData gd_button_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button_1.heightHint = 30;
		gd_button_1.widthHint = 86;
		button_1.setLayoutData(gd_button_1);
		button_1.setText("Sửa");
		button_1.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\edit_16x16.png"));
		
		Button button_2 = new Button(composite_1, SWT.NONE);
		GridData gd_button_2 = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_button_2.heightHint = 30;
		gd_button_2.widthHint = 100;
		button_2.setLayoutData(gd_button_2);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_2.setText("Hiện tất cả");
		button_2.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\show_16x16.png"));
		
		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnStt = tableViewerColumn.getColumn();
		tblclmnStt.setWidth(40);
		tblclmnStt.setText("STT");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMSutChiu = tableViewerColumn_1.getColumn();
		tblclmnMSutChiu.setWidth(95);
		tblclmnMSutChiu.setText("Mã suất chiếu");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMPhim = tableViewerColumn_2.getColumn();
		tblclmnMPhim.setWidth(75);
		tblclmnMPhim.setText("Mã phim");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTnPhim = tableViewerColumn_3.getColumn();
		tblclmnTnPhim.setWidth(150);
		tblclmnTnPhim.setText("Tên phim");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnGi = tableViewerColumn_4.getColumn();
		tblclmnGi.setWidth(70);
		tblclmnGi.setText("Giờ");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnnhDng = tableViewerColumn_5.getColumn();
		tblclmnnhDng.setWidth(75);
		tblclmnnhDng.setText("Định dạng");
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnHnhThc = tableViewerColumn_6.getColumn();
		tblclmnHnhThc.setWidth(75);
		tblclmnHnhThc.setText("Hình thức");
		
		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNgnNg = tableViewerColumn_7.getColumn();
		tblclmnNgnNg.setWidth(73);
		tblclmnNgnNg.setText("Ngôn ngữ");
		
		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnPhng = tableViewerColumn_8.getColumn();
		tblclmnPhng.setWidth(60);
		tblclmnPhng.setText("Phòng");
		
		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTrngThi = tableViewerColumn_9.getColumn();
		tblclmnTrngThi.setWidth(80);
		tblclmnTrngThi.setText("Trạng thái");
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
