/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.page;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.*;

public class pageBaoCao extends Composite {
	private Composite content;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageBaoCao(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 163;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Button btnPhimKhoangTG = new Button(composite, SWT.WRAP | SWT.CENTER);
		btnPhimKhoangTG.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pageBaoCaoDoanhThuPhimKhoangThoiGian page = new pageBaoCaoDoanhThuPhimKhoangThoiGian(content, SWT.NONE);
				content.layout();
			}
		});
		btnPhimKhoangTG.setText("Báo cáo tổng doanh thu phim trong khoảng thời gian");

		Button btnPhimKhungGio = new Button(composite, SWT.WRAP | SWT.CENTER);
		btnPhimKhungGio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pageBaoCaoDoanhThuPhimKhungGio page = new pageBaoCaoDoanhThuPhimKhungGio(content, SWT.NONE);
				content.layout();
			}
		});
		btnPhimKhungGio.setText("Báo cáo tổng doanh thu theo khung giờ hàng tháng");

		Button btnThucAn = new Button(composite, SWT.WRAP | SWT.CENTER);
		btnThucAn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pageBaoCaoDoanhThuThucAn page = new pageBaoCaoDoanhThuThucAn(content, SWT.NONE);
				content.layout();
			}
		});
		btnThucAn.setText("Báo cáo tổng doanh thu theo loại thức ăn");

		content = new Composite(this, SWT.NONE);
		content.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_content = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_content.heightHint = 369;
		gd_content.widthHint = 398;
		content.setLayoutData(gd_content);
		content.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
