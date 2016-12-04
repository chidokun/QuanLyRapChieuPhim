/* Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */
package rcp.view.page;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;

public class pageKhachHang extends Composite {
	private Text text;
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public pageKhachHang(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(null);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lblTraCuuKH = new Label(composite, SWT.NONE);
		lblTraCuuKH.setText("Tra cứu khách hàng");
		lblTraCuuKH.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblTraCuuKH.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuuKH.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTraCuuKH.setBounds(22, 32, 176, 23);
		
		Button btnTheoTnKhch = new Button(composite, SWT.CHECK);
		btnTheoTnKhch.setText("Theo tên khách hàng");
		btnTheoTnKhch.setSelection(true);
		btnTheoTnKhch.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnTheoTnKhch.setBounds(22, 69, 197, 16);
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(22, 100, 228, 25);
		
		Button btnTheoCmnd = new Button(composite, SWT.CHECK);
		btnTheoCmnd.setText("Theo CMND");
		btnTheoCmnd.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnTheoCmnd.setBounds(22, 146, 197, 16);
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBounds(22, 179, 228, 23);
		
		Button button_2 = new Button(composite, SWT.NONE);
		button_2.setText("Tìm kiếm");
		button_2.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\zoom_16x16.png"));
		button_2.setBounds(70, 316, 86, 30);
		
		Button button_3 = new Button(composite, SWT.NONE);
		button_3.setText("Đặt lại");
		button_3.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\refresh2_16x16.png"));
		button_3.setBounds(162, 316, 86, 30);
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(3, false);
		gl_composite_1.marginTop = 10;
		gl_composite_1.marginRight = 5;
		gl_composite_1.marginLeft = 5;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Button button_4 = new Button(composite_1, SWT.NONE);
		GridData gd_button_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button_4.widthHint = 86;
		gd_button_4.heightHint = 30;
		button_4.setLayoutData(gd_button_4);
		button_4.setText("Thêm");
		button_4.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\additem_16x16.png"));
		
		Button btnSa = new Button(composite_1, SWT.NONE);
		GridData gd_btnSa = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSa.heightHint = 30;
		gd_btnSa.widthHint = 86;
		btnSa.setLayoutData(gd_btnSa);
		btnSa.setText("Sửa");
		btnSa.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\additem_16x16.png"));
		
		Button btnHinTtC = new Button(composite_1, SWT.NONE);
		GridData gd_btnHinTtC = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnHinTtC.heightHint = 30;
		gd_btnHinTtC.widthHint = 86;
		btnHinTtC.setLayoutData(gd_btnHinTtC);
		btnHinTtC.setText("Hiện tất cả");
		btnHinTtC.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\additem_16x16.png"));
		
		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gd_table.minimumWidth = 5;
		gd_table.minimumHeight = 5;
		table.setLayoutData(gd_table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnFff = tableViewerColumn.getColumn();
		tblclmnFff.setWidth(50);
		tblclmnFff.setText("STT");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnHhhh = tableViewerColumn_1.getColumn();
		tblclmnHhhh.setWidth(100);
		tblclmnHhhh.setText("Mã khách hàng");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn_2.getColumn();
		tblclmnNewColumn.setWidth(150);
		tblclmnNewColumn.setText("Họ tên");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Ngày sinh");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_4.getColumn();
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Giới tính");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnCmnd = tableViewerColumn_5.getColumn();
		tblclmnCmnd.setWidth(100);
		tblclmnCmnd.setText("CMND");
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_3 = tableViewerColumn_6.getColumn();
		tblclmnNewColumn_3.setWidth(150);
		tblclmnNewColumn_3.setText("Email");
		
		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_4 = tableViewerColumn_7.getColumn();
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("SĐT");
		
		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_5 = tableViewerColumn_8.getColumn();
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("Loại khách hàng");
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
