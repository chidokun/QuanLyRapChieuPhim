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
import org.eclipse.swt.widgets.Spinner;

public class pageBanThucAn extends Composite {
	private Table table_1;
	private Table table;
	private Text text;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public pageBanThucAn(Composite parent, int style) {
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
		
		Label lblTraCuThucAn = new Label(composite, SWT.NONE);
		lblTraCuThucAn.setText("Loại thức ăn");
		lblTraCuThucAn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblTraCuThucAn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuThucAn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTraCuThucAn.setBounds(31, 10, 176, 23);
		
		Button btnTheoTnPhim = new Button(composite, SWT.CHECK);
		btnTheoTnPhim.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnTheoTnPhim.setText("Đồ ăn");
		btnTheoTnPhim.setSelection(true);
		btnTheoTnPhim.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnTheoTnPhim.setBounds(31, 39, 67, 16);
		
		Button btnTimKiem = new Button(composite, SWT.NONE);
		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\zoom_16x16.png"));
		btnTimKiem.setBounds(92, 324, 86, 30);
		
		Button btnDatLai = new Button(composite, SWT.NONE);
		btnDatLai.setText("Chọn");
		btnDatLai.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\refresh2_16x16.png"));
		btnDatLai.setBounds(184, 324, 86, 30);
		
		Button btnNcUng = new Button(composite, SWT.CHECK);
		btnNcUng.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNcUng.setText("Nước uống");
		btnNcUng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnNcUng.setBounds(121, 39, 149, 16);
		
		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table_1 = tableViewer.getTable();
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setBounds(10, 61, 260, 229);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMThcn = tableViewerColumn.getColumn();
		tblclmnMThcn.setWidth(70);
		tblclmnMThcn.setText("Mã thức ăn");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTnThcn_1 = tableViewerColumn_1.getColumn();
		tblclmnTnThcn_1.setWidth(60);
		tblclmnTnThcn_1.setText("Tên thức ăn");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnKchC_1 = tableViewerColumn_2.getColumn();
		tblclmnKchC_1.setWidth(70);
		tblclmnKchC_1.setText("Kích cỡ");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnnGi_1 = tableViewerColumn_3.getColumn();
		tblclmnnGi_1.setWidth(80);
		tblclmnnGi_1.setText("Đơn giá");
		
		Label lblSLng = new Label(composite, SWT.NONE);
		lblSLng.setText("Số lượng: ");
		lblSLng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSLng.setBounds(157, 296, 60, 15);
		
		Spinner spinner = new Spinner(composite, SWT.BORDER);
		spinner.setBounds(223, 296, 47, 23);
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_1 = new GridLayout(5, false);
		gl_composite_1.marginTop = 10;
		gl_composite_1.marginWidth = 15;
		composite_1.setLayout(gl_composite_1);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite_1.widthHint = 785;
		gd_composite_1.heightHint = 346;
		composite_1.setLayoutData(gd_composite_1);
		
		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 60;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setText("Ngày bán:");
		
		DateTime dateTime = new DateTime(composite_1, SWT.BORDER);
		GridData gd_dateTime = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateTime.widthHint = 103;
		dateTime.setLayoutData(gd_dateTime);
		
		Label lblNgyBn = new Label(composite_1, SWT.NONE);
		GridData gd_lblNgyBn = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblNgyBn.widthHint = 119;
		lblNgyBn.setLayoutData(gd_lblNgyBn);
		lblNgyBn.setText("                    Tổng tiền:");
		lblNgyBn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label label = new Label(composite_1, SWT.NONE);
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.widthHint = 87;
		label.setLayoutData(gd_label);
		label.setText("0đ");
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Button btnBn = new Button(composite_1, SWT.NONE);
		GridData gd_btnBn = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnBn.widthHint = 76;
		btnBn.setLayoutData(gd_btnBn);
		btnBn.setText("Bán");
		btnBn.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\refresh2_16x16.png"));
		
		TableViewer tableViewer_1 = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer_1.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1);
		gd_table.heightHint = 303;
		table.setLayoutData(gd_table);
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnStt = tableViewerColumn_4.getColumn();
		tblclmnStt.setWidth(40);
		tblclmnStt.setText("STT");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnMThcn_1 = tableViewerColumn_5.getColumn();
		tblclmnMThcn_1.setWidth(81);
		tblclmnMThcn_1.setText("Mã thức ăn");
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn_6.getColumn();
		tblclmnNewColumn.setWidth(88);
		tblclmnNewColumn.setText("Tên thức ăn");
		
		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnKchC = tableViewerColumn_7.getColumn();
		tblclmnKchC.setWidth(65);
		tblclmnKchC.setText("Kích cỡ");
		
		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnnGi = tableViewerColumn_8.getColumn();
		tblclmnnGi.setWidth(80);
		tblclmnnGi.setText("Đơn giá");
		
		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnSLng = tableViewerColumn_9.getColumn();
		tblclmnSLng.setWidth(65);
		tblclmnSLng.setText("Số lượng");
		
		TableViewerColumn tableViewerColumn_10 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_10.getColumn();
		tblclmnNewColumn_1.setWidth(80);
		tblclmnNewColumn_1.setText("Thành tiền");
		
		Label lblMHan = new Label(composite_1, SWT.NONE);
		lblMHan.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMHan.setText("Mã hóa đơn:");
		lblMHan.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		text = new Text(composite_1, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
