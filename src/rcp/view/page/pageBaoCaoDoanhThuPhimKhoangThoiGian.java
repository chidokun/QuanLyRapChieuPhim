/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.page;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;

public class pageBaoCaoDoanhThuPhimKhoangThoiGian extends Composite {
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public pageBaoCaoDoanhThuPhimKhoangThoiGian(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gridLayout = new GridLayout(6, false);
		gridLayout.marginTop = 7;
		gridLayout.marginHeight = 7;
		gridLayout.verticalSpacing = 7;
		gridLayout.horizontalSpacing = 7;
		gridLayout.marginRight = 15;
		gridLayout.marginLeft = 15;
		setLayout(gridLayout);
		
		Label lblTNgy = new Label(this, SWT.NONE);
		lblTNgy.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblTNgy.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTNgy.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblTNgy.setText("Từ ngày");
		
		DateTime dateTime = new DateTime(this, SWT.BORDER);
		dateTime.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		GridData gd_dateTime = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateTime.heightHint = 30;
		gd_dateTime.widthHint = 100;
		dateTime.setLayoutData(gd_dateTime);
		
		Label lblnNgy = new Label(this, SWT.NONE);
		lblnNgy.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblnNgy.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblnNgy.setText("Đến ngày");
		
		DateTime dateTime_1 = new DateTime(this, SWT.BORDER);
		dateTime_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		GridData gd_dateTime_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateTime_1.widthHint = 100;
		gd_dateTime_1.heightHint = 30;
		dateTime_1.setLayoutData(gd_dateTime_1);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		GridData gd_btnNewButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 86;
		gd_btnNewButton.heightHint = 30;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("Xem");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		GridData gd_btnNewButton_1 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_btnNewButton_1.heightHint = 30;
		gd_btnNewButton_1.widthHint = 86;
		btnNewButton_1.setLayoutData(gd_btnNewButton_1);
		btnNewButton_1.setText("In");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 6, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnStt = new TableColumn(table, SWT.NONE);
		tblclmnStt.setWidth(41);
		tblclmnStt.setText("STT");
		
		TableColumn tblclmnMPhim = new TableColumn(table, SWT.NONE);
		tblclmnMPhim.setWidth(106);
		tblclmnMPhim.setText("Mã phim");
		
		TableColumn tblclmnTnPhim = new TableColumn(table, SWT.NONE);
		tblclmnTnPhim.setWidth(173);
		tblclmnTnPhim.setText("Tên phim");
		
		TableColumn tblclmnDoanhThu = new TableColumn(table, SWT.NONE);
		tblclmnDoanhThu.setWidth(100);
		tblclmnDoanhThu.setText("Doanh thu");
		
		Label lblTngDoanhThu = new Label(this, SWT.NONE);
		lblTngDoanhThu.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblTngDoanhThu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTngDoanhThu.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 6, 1));
		lblTngDoanhThu.setText("Tổng doanh thu: %f");
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
