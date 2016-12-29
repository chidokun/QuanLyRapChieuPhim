/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.page;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.Settings;
import rcp.controller.PhimController;
import rcp.entity.BaoCaoPhim;
import rcp.util.Database;
import rcp.util.DateF;
import rcp.util.Message;
import rcp.util.Window;
import rcp.view.popup.frmBaoCao;

public class pageBaoCaoDoanhThuPhimKhoangThoiGian extends Composite {
	private Table gridBaoCao;
	private DateTime dateTuNgay;
	private DateTime dateDenNgay;
	private Button btnXem;
	private Button btnIn;
	private Label lblTongDoanhThu;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageBaoCaoDoanhThuPhimKhoangThoiGian(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);

		Composite composite = new Composite(this, SWT.NONE);
		GridLayout gl_composite = new GridLayout(6, false);
		gl_composite.marginTop = 7;
		gl_composite.marginRight = 15;
		gl_composite.marginLeft = 15;
		composite.setLayout(gl_composite);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite.heightHint = 49;
		composite.setLayoutData(gd_composite);

		Label label = new Label(composite, SWT.NONE);
		label.setText("Từ ngày");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label.setBackground(SWTResourceManager.getColor(240, 240, 240));

		dateTuNgay = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
		GridData gd_dateTuNgay = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateTuNgay.heightHint = 27;
		gd_dateTuNgay.widthHint = 125;
		dateTuNgay.setLayoutData(gd_dateTuNgay);
		dateTuNgay.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));

		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("Đến ngày");
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_1.setBackground(SWTResourceManager.getColor(240, 240, 240));

		dateDenNgay = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
		GridData gd_dateDenNgay = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateDenNgay.heightHint = 27;
		gd_dateDenNgay.widthHint = 125;
		dateDenNgay.setLayoutData(gd_dateDenNgay);
		dateDenNgay.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));

		btnXem = new Button(composite, SWT.NONE);
		btnXem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				xemBaoCao();
			}
		});
		GridData gd_btnXem = new GridData(SWT.RIGHT, SWT.FILL, true, false, 1, 1);
		gd_btnXem.widthHint = 120;
		gd_btnXem.heightHint = 27;
		btnXem.setLayoutData(gd_btnXem);
		btnXem.setText("Xem báo cáo");
		btnXem.setImage(SWTResourceManager.getImage(pageBaoCaoDoanhThuPhimKhoangThoiGian.class,
				"/rcp/view/page/show_16x16.png"));
		btnXem.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));

		btnIn = new Button(composite, SWT.NONE);
		btnIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					inBaoCao();
				} catch (ParameterValuesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridData gd_btnIn = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_btnIn.widthHint = 106;
		gd_btnIn.heightHint = 27;
		btnIn.setLayoutData(gd_btnIn);
		btnIn.setText("In báo cáo");
		btnIn.setImage(SWTResourceManager.getImage(pageBaoCaoDoanhThuPhimKhoangThoiGian.class,
				"/rcp/view/page/print_16x16.png"));
		btnIn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));

		Composite composite_1 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.marginRight = 15;
		gl_composite_1.marginLeft = 15;
		gl_composite_1.marginTop = 10;
		gl_composite_1.marginBottom = 15;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		gridBaoCao = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		gridBaoCao.setLinesVisible(true);
		gridBaoCao.setHeaderVisible(true);
		gridBaoCao.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		gridBaoCao.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TableColumn tableColumn = new TableColumn(gridBaoCao, SWT.NONE);
		tableColumn.setWidth(41);
		tableColumn.setText("STT");

		TableColumn tableColumn_1 = new TableColumn(gridBaoCao, SWT.NONE);
		tableColumn_1.setWidth(130);
		tableColumn_1.setText("Mã phim");

		TableColumn tableColumn_2 = new TableColumn(gridBaoCao, SWT.NONE);
		tableColumn_2.setWidth(202);
		tableColumn_2.setText("Tên phim");

		TableColumn tableColumn_3 = new TableColumn(gridBaoCao, SWT.NONE);
		tableColumn_3.setWidth(263);
		tableColumn_3.setText("Doanh thu");

		lblTongDoanhThu = new Label(composite_1, SWT.NONE);
		lblTongDoanhThu.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblTongDoanhThu.setAlignment(SWT.RIGHT);
		lblTongDoanhThu.setText("Tổng doanh thu: 0 đ");
		lblTongDoanhThu.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblTongDoanhThu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * Nạp báo cáo lên giao diện
	 */
	public void xemBaoCao() {
		NumberFormat c = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		try {
			kiemTraDieuKien();

			Date tuNgay = DateF.toDate(dateTuNgay.getYear(), dateTuNgay.getMonth(), dateTuNgay.getDay());
			Date denNgay = DateF.toDate(dateDenNgay.getYear(), dateDenNgay.getMonth(), dateDenNgay.getDay());
			ArrayList<BaoCaoPhim> arr = PhimController.baoCaoPhim(tuNgay, denNgay);

			gridBaoCao.removeAll();
			int stt = 1;
			for (BaoCaoPhim i : arr) {
				TableItem item = new TableItem(gridBaoCao, SWT.NONE);
				item.setText(
						new String[] { String.valueOf(stt), i.getMaPhim(), i.getTenPhim(), c.format(i.getDoanhThu()) });
				stt++;
			}

			gridBaoCao.select(0);
			lblTongDoanhThu.setText("Tổng doanh thu: " + c.format(tongDoanhThu(arr)));
		} catch (ParameterValuesException e0) {
			Message.show(e0.getMessage(), "Cảnh báo", SWT.OK | SWT.ICON_WARNING, getShell());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tính tổng doanh thu
	 * 
	 * @param arr
	 * @return
	 */
	public double tongDoanhThu(ArrayList<BaoCaoPhim> arr) {
		double tong = 0;
		for (BaoCaoPhim i : arr) {
			tong += i.getDoanhThu();
		}

		return tong;
	}

	/**
	 * Kiểm tra các điều kiện nhập liệu
	 * 
	 * @throws ParameterValuesException
	 */
	public void kiemTraDieuKien() throws ParameterValuesException {
		Date tuNgay = DateF.toDate(dateTuNgay.getYear(), dateTuNgay.getMonth(), dateTuNgay.getDay());
		Date denNgay = DateF.toDate(dateDenNgay.getYear(), dateDenNgay.getMonth(), dateDenNgay.getDay());
		if (!tuNgay.before(denNgay))
			throw new ParameterValuesException("Từ ngày phải ở thời điểm trước đến ngày", null);
	}
	public void inBaoCao() throws ParameterValuesException
	{
		if(gridBaoCao.getItemCount()==0)
		{
			Message.show("Mời bạn xem báo cáo trước khi in", "Thông báo",SWT.OK|SWT.ICON_INFORMATION, getShell());
			return;
		}
		xemBaoCao();
		Connection connection = null;
	        try {
	            connection = Database.connect();
	            HashMap<String,Object> parameterMap = new HashMap<>();
	            parameterMap.put("tuNgay", DateF.toDate(dateTuNgay.getYear(), dateTuNgay.getMonth(), dateTuNgay.getDay()));
	            parameterMap.put("denNgay", DateF.toDate(dateDenNgay.getYear(), dateDenNgay.getMonth(), dateDenNgay.getDay()));
	            parameterMap.put("Sum_DoanhThu",lblTongDoanhThu.getText() );
	            parameterMap.put("cinemaName", Settings.get("cinemaName"));
				parameterMap.put("cinemaAddr", Settings.get("cinemaAddr"));
				
	            Window.open(new frmBaoCao(getDisplay(),parameterMap,connection,"Report_DoanhThu_Phim"));    
	        }
	        catch (SQLException ex) {
	          ex.printStackTrace();
	        }
}

}
