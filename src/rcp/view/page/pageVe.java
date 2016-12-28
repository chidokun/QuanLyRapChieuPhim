/**
 * Quản lý Rạp chiếu phim RPP 
 * Author: Võ Xuân Vương – vuongvo1809@gmail.com
 */

package rcp.view.page;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.mysql.cj.api.jdbc.Statement;

import rcp.controller.VeController;
import rcp.entity.Ve;
import rcp.util.Database;
import rcp.util.DateF;
import rcp.util.Message;
import rcp.util.Window;
import rcp.view.popup.frmBaoCao;

public class pageVe extends Composite {

	private Text txtMaVe;
	private Text txtTenKhachHang;
	private Button btnDatLai;
	private DateTime dateTuNgay;
	private DateTime dateDenNgay;
	private Button btnIn;
	private Button btnHienTatCa;
	private Button chkMaVe;
	private Button chkTenKhachHang;
	private Button chkTheoKhoangThoiGian;
	private Table gridVe;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageVe(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);

		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		txtMaVe = new Text(composite, SWT.BORDER);
		txtMaVe.setBounds(29, 85, 228, 25);

		Label lblTraCuV = new Label(composite, SWT.NONE);
		lblTraCuV.setText("Tra cứu vé");
		lblTraCuV.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblTraCuV.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuV.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblTraCuV.setBounds(29, 17, 176, 23);

		chkMaVe = new Button(composite, SWT.CHECK);
		chkMaVe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtMaVe.setEnabled(chkMaVe.getSelection());
			}
		});
		chkMaVe.setText("Theo mã vé");
		chkMaVe.setSelection(true);
		chkMaVe.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		chkMaVe.setBounds(29, 54, 197, 16);

		chkTenKhachHang = new Button(composite, SWT.CHECK);
		chkTenKhachHang.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtTenKhachHang.setEnabled(chkTenKhachHang.getSelection());
			}
		});
		chkTenKhachHang.setText("Theo tên khách hàng");
		chkTenKhachHang.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		chkTenKhachHang.setBounds(29, 124, 197, 16);

		chkTheoKhoangThoiGian = new Button(composite, SWT.CHECK);
		chkTheoKhoangThoiGian.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dateTuNgay.setEnabled(chkTheoKhoangThoiGian.getSelection());
				dateDenNgay.setEnabled(chkTheoKhoangThoiGian.getSelection());
			}
		});
		chkTheoKhoangThoiGian.setText("Theo khoảng thời gian bán vé");
		chkTheoKhoangThoiGian.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		chkTheoKhoangThoiGian.setBounds(29, 205, 197, 16);

		Button btnTimKiem = new Button(composite, SWT.NONE);
		btnTimKiem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				timKiem();
			}
		});
		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.setImage(SWTResourceManager.getImage(pageVe.class, "/rcp/view/page/zoom_16x16.png"));
		btnTimKiem.setBounds(81, 327, 86, 30);

		btnDatLai = new Button(composite, SWT.NONE);
		btnDatLai.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				datLai();
			}
		});
		btnDatLai.setText("Đặt lại");
		btnDatLai.setImage(SWTResourceManager.getImage(pageVe.class, "/rcp/view/page/refresh2_16x16.png"));
		btnDatLai.setBounds(171, 327, 86, 30);

		dateTuNgay = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
		dateTuNgay.setEnabled(false);
		dateTuNgay.setBounds(102, 235, 155, 24);

		dateDenNgay = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
		dateDenNgay.setEnabled(false);
		dateDenNgay.setBounds(102, 272, 155, 24);

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel.setBounds(29, 275, 67, 15);
		lblNewLabel.setText("Đến ngày:");

		txtTenKhachHang = new Text(composite, SWT.BORDER);
		txtTenKhachHang.setEnabled(false);
		txtTenKhachHang.setBounds(29, 161, 228, 25);

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(29, 241, 55, 15);
		lblNewLabel_1.setText("Từ ngày:");

		Composite composite_1 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(2, false);
		gl_composite_1.marginWidth = 15;
		gl_composite_1.marginTop = 10;
		gl_composite_1.marginBottom = 15;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		btnIn = new Button(composite_1, SWT.NONE);
		btnIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					inVe();
				} catch (ParameterValuesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridData gd_btnIn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnIn.heightHint = 30;
		gd_btnIn.widthHint = 86;
		btnIn.setLayoutData(gd_btnIn);
		btnIn.setText("In vé");
		btnIn.setImage(SWTResourceManager.getImage(pageVe.class, "/rcp/view/page/print_16x16.png"));

		btnHienTatCa = new Button(composite_1, SWT.NONE);
		btnHienTatCa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				hienTatCa();
			}
		});
		GridData gd_btnHienTatCa = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnHienTatCa.widthHint = 100;
		gd_btnHienTatCa.heightHint = 30;
		btnHienTatCa.setLayoutData(gd_btnHienTatCa);
		btnHienTatCa.setText("Hiện tất cả");
		btnHienTatCa.setImage(SWTResourceManager.getImage(pageVe.class, "/rcp/view/page/show_16x16.png"));

		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		gridVe = tableViewer.getTable();
		gridVe.setHeaderVisible(true);
		gridVe.setLinesVisible(true);
		gridVe.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(40);
		tblclmnNewColumn.setText("STT");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(150);
		tblclmnNewColumn_1.setText("Mã vé");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setWidth(150);
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
		tblclmnNewColumn_5.setText("Tên nhân viên");

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
		tblclmnNewColumn_8.setText("Tên khách hàng");

		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_9 = tableViewerColumn_9.getColumn();
		tblclmnNewColumn_9.setWidth(100);
		tblclmnNewColumn_9.setText("Điểm tích lũy");

		hienThiGiaoDien();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * Hàm đặt lại điều kiện tìm kiếm
	 */
	public void datLai() {
		chkMaVe.setSelection(true);
		txtMaVe.setText("");
		txtMaVe.setEnabled(chkMaVe.getSelection());

		chkTenKhachHang.setSelection(false);
		txtTenKhachHang.setText("");
		txtTenKhachHang.setEnabled(chkTenKhachHang.getSelection());

		chkTheoKhoangThoiGian.setSelection(false);
		dateTuNgay.setEnabled(chkTenKhachHang.getSelection());
		dateDenNgay.setEnabled(chkTheoKhoangThoiGian.getSelection());

	}

	/**
	 * Hiển thị giao diện ban đầu
	 */
	public void hienThiGiaoDien() {
		hienTatCa();
	}

	/**
	 * Hiện tất cả vé
	 */
	public void hienTatCa() {
		NumberFormat c = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		try {
			ArrayList<Ve> arr = VeController.taiTatCa();

			gridVe.removeAll();
			int stt = 1;
			for (Ve i : arr) {
				TableItem item = new TableItem(gridVe, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaVe(), i.getMaSuatChieu(), i.getMaGhe(),
						DateF.toString(i.getNgayBanVe()), i.getMaNhanVien(), c.format(i.getGiaVe()), i.getMaKM(),
						i.getMaKhachHang(), String.valueOf(i.getDiemTichLuy()) });
				stt++;
			}

			gridVe.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hàm tìm kiếm
	 */
	public void timKiem() {
		NumberFormat c = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		try {
			kiemTraHopLe();
			ArrayList<Ve> arr = VeController.traCuu(chkMaVe.getSelection() ? txtMaVe.getText() : null,
					chkTenKhachHang.getSelection() ? txtTenKhachHang.getText() : null,
					chkTheoKhoangThoiGian.getSelection()
							? DateF.toDate(dateTuNgay.getYear(), dateTuNgay.getMonth(), dateTuNgay.getDay()) : null,
					chkTheoKhoangThoiGian.getSelection()
							? DateF.toDate(dateDenNgay.getYear(), dateDenNgay.getMonth(), dateDenNgay.getDay()) : null);

			gridVe.removeAll();
			int stt = 1;
			for (Ve i : arr) {
				TableItem item = new TableItem(gridVe, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaVe(), i.getMaSuatChieu(), i.getMaGhe(),
						i.getNgayBanVe().toString(), i.getMaNhanVien(), c.format(i.getGiaVe()), i.getMaKM(),
						i.getMaKhachHang(), String.valueOf(i.getDiemTichLuy()) });
				stt++;
			}

			gridVe.select(0);
		} catch (ParameterValuesException e) {
			Message.show(e.getMessage(), "Cảnh báo", SWT.ICON_WARNING | SWT.OK, getShell());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Kiểm tra các trường thông tin có được điền đầy đủ hay không
	 * 
	 * @throws ParameterValuesException
	 */
	public void kiemTraHopLe() throws ParameterValuesException {
		if (chkMaVe.getSelection() && txtMaVe.getText().isEmpty())
			throw new ParameterValuesException("Mã vé không được trống", null);
		if (chkTenKhachHang.getSelection() && txtTenKhachHang.getText().isEmpty())
			throw new ParameterValuesException("Tên khách hàng không được trống", null);
		if (chkTheoKhoangThoiGian.getSelection()
				&& (DateF.toDate(dateTuNgay.getYear(), dateTuNgay.getMonth(), dateTuNgay.getDay())
						.after(DateF.toDate(dateDenNgay.getYear(), dateDenNgay.getMonth(), dateDenNgay.getDay()))))
			throw new ParameterValuesException("Từ ngày không được sau Đến ngày", null);
	}
	public void inVe() throws ParameterValuesException
	{
		try
		{
		Connection connection = null;
	    Statement statement = null;
	        try {
	            connection = Database.connect();
	            statement = (Statement) connection.createStatement();
	            HashMap parameterMap = new HashMap();
	            parameterMap.put("maVe", gridVe.getSelection()[0].getText(1));//sending the report title as a parameter.
	            Window.open(new frmBaoCao(getDisplay(),parameterMap,connection,"Ticket"));    
	        }
	        catch (SQLException ex) {
	          ex.printStackTrace();
	        }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
}
}
