/* Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.view.page;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;

public class pageVe extends Composite {
	private Text text;
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public pageVe(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(31, 78, 228, 25);
		
		Label lblTraCuV = new Label(composite, SWT.NONE);
		lblTraCuV.setText("Tra cứu vé");
		lblTraCuV.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblTraCuV.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuV.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTraCuV.setBounds(31, 10, 176, 23);
		
		Button btnTheoMV = new Button(composite, SWT.CHECK);
		btnTheoMV.setText("Theo mã vé");
		btnTheoMV.setSelection(true);
		btnTheoMV.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnTheoMV.setBounds(31, 47, 197, 16);
		
		Button btnTheoTnKhch = new Button(composite, SWT.CHECK);
		btnTheoTnKhch.setText("Theo tên khách hàng");
		btnTheoTnKhch.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnTheoTnKhch.setBounds(31, 124, 197, 16);
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBounds(31, 157, 228, 23);
		
		Button btnTheoKhongThi = new Button(composite, SWT.CHECK);
		btnTheoKhongThi.setText("Theo khoảng thời gian bán vé");
		btnTheoKhongThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnTheoKhongThi.setBounds(31, 205, 197, 16);
		
		Button button_3 = new Button(composite, SWT.NONE);
		button_3.setText("Tìm kiếm");
		button_3.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\zoom_16x16.png"));
		button_3.setBounds(83, 304, 86, 30);
		
		Button button_4 = new Button(composite, SWT.NONE);
		button_4.setText("Đặt lại");
		button_4.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\refresh2_16x16.png"));
		button_4.setBounds(173, 304, 86, 30);
		
		DateTime dateTime = new DateTime(composite, SWT.BORDER);
		dateTime.setBounds(31, 250, 90, 24);
		
		DateTime dateTime_1 = new DateTime(composite, SWT.BORDER);
		dateTime_1.setBounds(169, 250, 90, 24);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(135, 258, 31, 15);
		lblNewLabel.setText("Đến");
		
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
		gd_btnIn.widthHint = 86;
		btnIn.setLayoutData(gd_btnIn);
		btnIn.setText("In");
		btnIn.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\additem_16x16.png"));
		
		Button btnHinTtC = new Button(composite_1, SWT.NONE);
		GridData gd_btnHinTtC = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnHinTtC.widthHint = 86;
		gd_btnHinTtC.heightHint = 30;
		btnHinTtC.setLayoutData(gd_btnHinTtC);
		btnHinTtC.setText("Hiện tất cả");
		btnHinTtC.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\additem_16x16.png"));
		
		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(50);
		tblclmnNewColumn.setText("STT");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Mã vé");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Mã suất chiếu");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("Mã ghế");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_4 = tableViewerColumn_4.getColumn();
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("Ngày bán vé");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_5 = tableViewerColumn_5.getColumn();
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("Mã nhân viên");
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_6 = tableViewerColumn_6.getColumn();
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("Giá vé");
		
		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_7 = tableViewerColumn_7.getColumn();
		tblclmnNewColumn_7.setWidth(100);
		tblclmnNewColumn_7.setText("Mã khuyến mãi");
		
		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_8 = tableViewerColumn_8.getColumn();
		tblclmnNewColumn_8.setWidth(100);
		tblclmnNewColumn_8.setText("Mã khách hàng");
		
		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_9 = tableViewerColumn_9.getColumn();
		tblclmnNewColumn_9.setWidth(100);
		tblclmnNewColumn_9.setText("Điểm tích lũy");
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
