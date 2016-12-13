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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;

public class pageTaiKhoan extends Composite {
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public pageTaiKhoan(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label label = new Label(composite, SWT.NONE);
		label.setText("<Tên Nhân Viên>");
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		label.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(44, 30, 176, 23);
		
		Label lblTnngNhp = new Label(composite, SWT.NONE);
		lblTnngNhp.setText("Tên đăng nhập :");
		lblTnngNhp.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblTnngNhp.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnngNhp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnngNhp.setBounds(22, 82, 90, 23);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setText("<Tên Đăng Nhập>");
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setBounds(145, 82, 112, 23);
		
		Label lblQuyn = new Label(composite, SWT.NONE);
		lblQuyn.setText("Quyền :");
		lblQuyn.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblQuyn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblQuyn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblQuyn.setBounds(22, 135, 63, 20);
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBounds(107, 132, 150, 23);
		
		Label lblTrngThi = new Label(composite, SWT.NONE);
		lblTrngThi.setText("Trạng Thái :");
		lblTrngThi.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblTrngThi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTrngThi.setBounds(22, 186, 112, 23);
		
		Button btnRadioButton = new Button(composite, SWT.RADIO);
		btnRadioButton.setSelection(true);
		btnRadioButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnRadioButton.setBounds(44, 215, 90, 16);
		btnRadioButton.setText("Active");
		btnRadioButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Button btnRadioButton_1 = new Button(composite, SWT.RADIO);
		btnRadioButton_1.setBounds(167, 215, 90, 16);
		btnRadioButton_1.setText("Deactive");
		btnRadioButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setText("Lưu");
		btnLu.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\zoom_16x16.png"));
		btnLu.setBounds(10, 282, 120, 30);
		
		Button btntLiMt = new Button(composite, SWT.NONE);
		btntLiMt.setText(" Đặt lại mật khẩu");
		btntLiMt.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\refresh2_16x16.png"));
		btntLiMt.setBounds(137, 282, 120, 30);
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.marginRight = 5;
		gl_composite_1.marginLeft = 5;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Button btnNewButton = new Button(composite_1, SWT.NONE);
		GridData gd_btnNewButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.heightHint = 30;
		gd_btnNewButton.widthHint = 86;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("Thêm");
		
		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(50);
		tblclmnNewColumn.setText("STT");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(150);
		tblclmnNewColumn_1.setText("Tên đăng nhập");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setWidth(150);
		tblclmnNewColumn_2.setText("Mã nhân viên");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTnNhnVin = tableViewerColumn_5.getColumn();
		tblclmnTnNhnVin.setWidth(150);
		tblclmnTnNhnVin.setText("Tên nhân viên");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_3.setWidth(150);
		tblclmnNewColumn_3.setText("Mã quyền");
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTnQuyn = tableViewerColumn_6.getColumn();
		tblclmnTnQuyn.setWidth(150);
		tblclmnTnQuyn.setText("Tên quyền");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_4 = tableViewerColumn_4.getColumn();
		tblclmnNewColumn_4.setWidth(150);
		tblclmnNewColumn_4.setText("Trạng thái");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
