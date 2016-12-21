/**
 * Quản lý Rạp chiếu phim RPP
 * Author_giaodien: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 * Author_xuly: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.view.page;

import java.text.NumberFormat;
import java.util.ArrayList;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.HoaDonController;
import rcp.entity.ChiTietHDThucAn;
import rcp.entity.HoaDonThucAn;
import rcp.util.DateF;
import rcp.util.Message;

public class pageHoaDon extends Composite {
	private NumberFormat c = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	
	private Table gridCTHD;
	private Button chkMaHoaDon;
	private Text txtMaHoaDon;
	private Button chkKhoangThoiGian;
	private DateTime dateTime_TuNgay;
	private DateTime dateTime_DenNgay;
	private Button btnTimKiem;
	private Button btnDatLai;
	private Table gridHoaDon;
	private Button btnInHoaDon;
	private Button btnHienTatCa;

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
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblTraCuKha = new Label(composite, SWT.NONE);
		lblTraCuKha.setText("Tra cứu hóa đơn");
		lblTraCuKha.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblTraCuKha.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuKha.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblTraCuKha.setBounds(29, 17, 176, 23);

		chkMaHoaDon = new Button(composite, SWT.CHECK);
		chkMaHoaDon.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtMaHoaDon.setEnabled(chkMaHoaDon.getSelection());
			}
		});
		chkMaHoaDon.setText("Theo mã hóa đơn");
		chkMaHoaDon.setSelection(true);
		chkMaHoaDon.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		chkMaHoaDon.setBounds(29, 54, 197, 16);

		txtMaHoaDon = new Text(composite, SWT.BORDER);
		txtMaHoaDon.setBounds(29, 85, 228, 25);

		chkKhoangThoiGian = new Button(composite, SWT.CHECK);
		chkKhoangThoiGian.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dateTime_TuNgay.setEnabled(chkKhoangThoiGian.getSelection());
				dateTime_DenNgay.setEnabled(chkKhoangThoiGian.getSelection());
			}
		});
		chkKhoangThoiGian.setText("Theo khoảng thời gian");
		chkKhoangThoiGian.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		chkKhoangThoiGian.setBounds(29, 131, 197, 16);

		dateTime_TuNgay = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_TuNgay.setEnabled(false);
		dateTime_TuNgay.setBounds(98, 162, 156, 24);

		dateTime_DenNgay = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_DenNgay.setEnabled(false);
		dateTime_DenNgay.setBounds(98, 202, 156, 24);

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel.setBounds(29, 205, 66, 15);
		lblNewLabel.setText("Đến ngày:");

		Label lblT = new Label(composite, SWT.NONE);
		lblT.setText("Từ ngày:");
		lblT.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblT.setBounds(29, 165, 62, 16);

		btnTimKiem = new Button(composite, SWT.NONE);
		btnTimKiem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				timKiem();
			}
		});
		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.setImage(SWTResourceManager.getImage(pageHoaDon.class, "/rcp/view/page/zoom_16x16.png"));
		btnTimKiem.setBounds(78, 256, 86, 30);

		btnDatLai = new Button(composite, SWT.NONE);
		btnDatLai.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				datLai();
			}
		});
		btnDatLai.setText("Đặt lại");
		btnDatLai.setImage(SWTResourceManager.getImage(pageHoaDon.class, "/rcp/view/page/refresh2_16x16.png"));
		btnDatLai.setBounds(168, 256, 86, 30);

		Composite composite_1 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(2, false);
		gl_composite_1.marginWidth = 15;
		gl_composite_1.marginTop = 10;
		gl_composite_1.marginBottom = 15;
		composite_1.setLayout(gl_composite_1);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite_1.widthHint = 999;
		gd_composite_1.heightHint = 427;
		composite_1.setLayoutData(gd_composite_1);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		btnInHoaDon = new Button(composite_1, SWT.NONE);
		GridData gd_btnInHoaDon = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnInHoaDon.heightHint = 30;
		gd_btnInHoaDon.widthHint = 100;
		btnInHoaDon.setLayoutData(gd_btnInHoaDon);
		btnInHoaDon.setText("In hóa đơn");
		btnInHoaDon.setImage(SWTResourceManager.getImage(pageHoaDon.class, "/rcp/view/page/print_16x16.png"));

		btnHienTatCa = new Button(composite_1, SWT.NONE);
		btnHienTatCa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				hienTatCa();
			}
		});
		GridData gd_btnHienTatCa = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnHienTatCa.widthHint = 100;
		gd_btnHienTatCa.heightHint = 30;
		btnHienTatCa.setLayoutData(gd_btnHienTatCa);
		btnHienTatCa.setText("Hiện tất cả");
		btnHienTatCa.setImage(SWTResourceManager.getImage(pageHoaDon.class, "/rcp/view/page/show_16x16.png"));

		gridHoaDon = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		gridHoaDon.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				layCTHD(gridHoaDon.getSelection()[0].getText(1));
			}
		});
		GridData gd_gridHoaDon = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_gridHoaDon.widthHint = 465;
		gd_gridHoaDon.heightHint = 143;
		gridHoaDon.setLayoutData(gd_gridHoaDon);
		gridHoaDon.setHeaderVisible(true);
		gridHoaDon.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(gridHoaDon, SWT.NONE);
		tblclmnNewColumn.setWidth(34);
		tblclmnNewColumn.setText("STT");

		TableColumn tblclmnNewColumn_1 = new TableColumn(gridHoaDon, SWT.NONE);
		tblclmnNewColumn_1.setWidth(120);
		tblclmnNewColumn_1.setText("Mã hóa đơn");

		TableColumn tblclmnNewColumn_2 = new TableColumn(gridHoaDon, SWT.NONE);
		tblclmnNewColumn_2.setWidth(88);
		tblclmnNewColumn_2.setText("Ngày tạo");

		TableColumn tblclmnNewColumn_3 = new TableColumn(gridHoaDon, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("Tổng tiền");

		TableColumn tblclmnNewColumn_4 = new TableColumn(gridHoaDon, SWT.NONE);
		tblclmnNewColumn_4.setWidth(87);
		tblclmnNewColumn_4.setText("Mã nhân viên");

		gridCTHD = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_gridCTHD = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_gridCTHD.heightHint = 209;
		gridCTHD.setLayoutData(gd_gridCTHD);
		gridCTHD.setHeaderVisible(true);
		gridCTHD.setLinesVisible(true);

		TableColumn tblclmnStt = new TableColumn(gridCTHD, SWT.NONE);
		tblclmnStt.setWidth(35);
		tblclmnStt.setText("STT");

		TableColumn tblclmnNewColumn_5 = new TableColumn(gridCTHD, SWT.NONE);
		tblclmnNewColumn_5.setWidth(95);
		tblclmnNewColumn_5.setText("Mã thức ăn");

		TableColumn tblclmnTnThcn = new TableColumn(gridCTHD, SWT.NONE);
		tblclmnTnThcn.setWidth(152);
		tblclmnTnThcn.setText("Tên thức ăn");

		TableColumn tblclmnKchC = new TableColumn(gridCTHD, SWT.NONE);
		tblclmnKchC.setWidth(87);
		tblclmnKchC.setText("Kích cỡ");

		TableColumn tblclmnnGi = new TableColumn(gridCTHD, SWT.NONE);
		tblclmnnGi.setWidth(98);
		tblclmnnGi.setText("Đơn giá");

		TableColumn tblclmnSLng = new TableColumn(gridCTHD, SWT.NONE);
		tblclmnSLng.setWidth(77);
		tblclmnSLng.setText("Số lượng");

		hienThiGiaoDien();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * Hàm hiển thị giao diện ban đầu
	 */
	public void hienThiGiaoDien() {
		hienTatCa();
		datLai();
	}

	/**
	 * Hàm đặt lại điều kiện tìm kiếm
	 */
	public void datLai() {
		chkMaHoaDon.setSelection(true);
		txtMaHoaDon.setText("");
		txtMaHoaDon.setEnabled(chkMaHoaDon.getSelection());

		chkKhoangThoiGian.setSelection(false);
		dateTime_TuNgay.setEnabled(chkKhoangThoiGian.getSelection());
		dateTime_DenNgay.setEnabled(chkKhoangThoiGian.getSelection());

	}

	/**
	 * Hàm hiện thông tin của tất cả hóa đơn
	 */
	public void hienTatCa() {
		try {
			ArrayList<HoaDonThucAn> arr = HoaDonController.taiTatCa();

			gridHoaDon.removeAll();
			int stt = 1;
			for (HoaDonThucAn i : arr) {
				TableItem item = new TableItem(gridHoaDon, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaHoaDon(), DateF.toString(i.getNgayHoaDon()),
						c.format(i.getTongTien()), i.getMaNhanVien() });
				stt++;
			}

			gridHoaDon.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hàm tìm kiếm hóa đơn
	 */
	public void timKiem() {
		try {
			kiemTraHopLe();
			ArrayList<HoaDonThucAn> arr = HoaDonController.traCuu(
					chkMaHoaDon.getSelection() ? txtMaHoaDon.getText() : null,
					chkKhoangThoiGian.getSelection() ? DateF.toDate(dateTime_TuNgay.getYear(),
							dateTime_TuNgay.getMonth(), dateTime_TuNgay.getDay()) : null,
					chkKhoangThoiGian.getSelection() ? DateF.toDate(dateTime_DenNgay.getYear(),
							dateTime_DenNgay.getMonth(), dateTime_DenNgay.getDay()) : null);

			gridHoaDon.removeAll();
			int stt = 1;
			for (HoaDonThucAn i : arr) {
				TableItem item = new TableItem(gridHoaDon, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaHoaDon(), DateF.toString(i.getNgayHoaDon()),
						c.format(i.getTongTien()), i.getMaNhanVien() });
				stt++;
			}

			gridHoaDon.select(0);
		} catch (ParameterValuesException e) {
			Message.show(e.getMessage(), "Cảnh báo", SWT.ICON_WARNING | SWT.OK, getShell());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Kiểm tra các trường trong điều kiện có nhập đầy đủ hay không
	 */
	public void kiemTraHopLe() throws ParameterValuesException {
		if (chkMaHoaDon.getSelection() && txtMaHoaDon.getText().isEmpty())
			throw new ParameterValuesException("Mã hóa đơn không được trống", null);
		if (chkKhoangThoiGian.getSelection()
				&& (DateF.toDate(dateTime_TuNgay.getYear(), dateTime_TuNgay.getMonth(), dateTime_TuNgay.getDay())
						.after(DateF.toDate(dateTime_DenNgay.getYear(), dateTime_DenNgay.getMonth(), dateTime_DenNgay.getDay()))))
			throw new ParameterValuesException("Từ ngày không được sau Đến ngày", null);
	}

	/**
	 * Lấy chi tiết hóa đơn theo mã hóa đơn
	 */
	public void layCTHD(String maHoaDon) {
		try {
			ArrayList<ChiTietHDThucAn> arr = HoaDonController.layCTHoaDon(maHoaDon);

			gridCTHD.removeAll();
			int stt = 1;
			for (ChiTietHDThucAn i : arr) {
				TableItem item = new TableItem(gridCTHD, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaThucAn(), i.getTenThucAn(), i.getKichCo(),
						c.format(i.getDonGia()), String.valueOf(i.getSoLuong()) });
				stt++;
			}

			gridCTHD.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
