/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */

package rcp.view.page;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.jface.viewers.TableViewer;

import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.wb.swt.ResourceManager;

import rcp.controller.LoaiThucAnController;
import rcp.controller.ThucAnController;
import rcp.entity.LoaiThucAn;
import rcp.entity.ThucAn;
import rcp.entity.ThucAnKichCo;
import rcp.util.Message;
import rcp.util.Window;
import rcp.view.popup.frmThucAn;
import rcp.view.popup.frmThucAnKichCo;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class pageThucAn extends Composite {
	private Table gridThucAn;
	private Table gridTAKC;
	private Button chkTenThucAn;
	private Button chkLoaiThucAn;
	private Button btnTimKiem;
	private Button btnDatLai;
	private Text txtTenThucAn;
	private Combo cbLoaiThucAn;
	private Button btnHienTatCa;
	private Button btnThemTAKC;
	private Button btnXoaTAKC;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageThucAn(Composite parent, int style) {
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
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblTraCuKha = new Label(composite, SWT.NONE);
		lblTraCuKha.setText("Tra cứu thức ăn");
		lblTraCuKha.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblTraCuKha.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuKha.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTraCuKha.setBounds(26, 22, 176, 23);

		chkTenThucAn = new Button(composite, SWT.CHECK);
		chkTenThucAn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtTenThucAn.setEnabled(chkTenThucAn.getSelection());
			}
		});
		chkTenThucAn.setText("Theo tên thức ăn");
		chkTenThucAn.setSelection(true);
		chkTenThucAn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		chkTenThucAn.setBounds(26, 59, 197, 16);

		txtTenThucAn = new Text(composite, SWT.BORDER);
		txtTenThucAn.setBounds(26, 94, 228, 25);

		chkLoaiThucAn = new Button(composite, SWT.CHECK);
		chkLoaiThucAn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cbLoaiThucAn.setEnabled(chkLoaiThucAn.getSelection());
			}
		});
		chkLoaiThucAn.setText("Theo loại thức ăn");
		chkLoaiThucAn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		chkLoaiThucAn.setBounds(26, 142, 197, 16);

		btnTimKiem = new Button(composite, SWT.NONE);
		btnTimKiem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				timKiem();
			}
		});
		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "src/rcp/view/page/zoom_16x16.png"));
		btnTimKiem.setBounds(78, 256, 86, 30);

		btnDatLai = new Button(composite, SWT.NONE);
		btnDatLai.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				datLai();
			}
		});
		btnDatLai.setText("Đặt lại");
		btnDatLai.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "src/rcp/view/page/refresh2_16x16.png"));
		btnDatLai.setBounds(168, 256, 86, 30);
		
		cbLoaiThucAn = new Combo(composite, SWT.NONE);
		cbLoaiThucAn.setEnabled(false);
		cbLoaiThucAn.setBounds(26, 175, 228, 23);
		cbLoaiThucAn.select(0);

		Composite composite_1 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(5, false);
		gl_composite_1.marginRight = 5;
		gl_composite_1.marginLeft = 5;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Button btnThemThucAn = new Button(composite_1, SWT.NONE);
		btnThemThucAn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Window.open(new frmThucAn(getDisplay(), "Thêm thức ăn", null));
				hienTatCa();
			}
		});
		GridData gd_btnThemThucAn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnThemThucAn.heightHint = 30;
		gd_btnThemThucAn.widthHint = 86;
		btnThemThucAn.setLayoutData(gd_btnThemThucAn);
		btnThemThucAn.setText("Thêm");
		btnThemThucAn.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "src/rcp/view/page/additem_16x16.png"));
		
		Button btnSuaThucAn = new Button(composite_1, SWT.NONE);
		btnSuaThucAn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Window.open(new frmThucAn(getDisplay(), "Sửa thức ăn",
							ThucAnController.layThongTin(gridThucAn.getSelection()[0].getText(1))));
					hienTatCa();
				} catch (SQLException e1) {
					e1.printStackTrace();
					Message.show("Thức ăn không hợp lệ", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
				}
			}
		});
		GridData gd_btnSuaThucAn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSuaThucAn.heightHint = 30;
		gd_btnSuaThucAn.widthHint = 86;
		btnSuaThucAn.setLayoutData(gd_btnSuaThucAn);
		btnSuaThucAn.setText("Sửa");
		btnSuaThucAn.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "src/rcp/view/page/edit_16x16.png"));
		
		btnHienTatCa = new Button(composite_1, SWT.NONE);
		btnHienTatCa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				hienTatCa();
			}
		});
		GridData gd_btnHienTatCa = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnHienTatCa.widthHint = 86;
		gd_btnHienTatCa.heightHint = 30;
		btnHienTatCa.setLayoutData(gd_btnHienTatCa);
		btnHienTatCa.setText("Hiện tất cả");
		btnHienTatCa.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "src/rcp/view/page/show_16x16.png"));
		
		btnThemTAKC = new Button(composite_1, SWT.NONE);
		btnThemTAKC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Window.open(new frmThucAnKichCo(getDisplay(), "Sửa thức ăn",
							ThucAnController.layThongTin(gridThucAn.getSelection()[0].getText(1))));
					hienTatCa();
				} catch (SQLException e1) {
					e1.printStackTrace();
					Message.show("Thức ăn không hợp lệ", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
				}
			}
		});
		btnThemTAKC.setEnabled(false);
		GridData gd_btnThemTAKC = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnThemTAKC.widthHint = 86;
		gd_btnThemTAKC.heightHint = 30;
		btnThemTAKC.setLayoutData(gd_btnThemTAKC);
		btnThemTAKC.setText("Thêm");
		btnThemTAKC.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "src/rcp/view/page/additem_16x16.png"));
		
		btnXoaTAKC = new Button(composite_1, SWT.NONE);
		btnXoaTAKC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				xoa();
				layThongTinTAKC(gridThucAn.getSelection()[0].getText(1));
			}
		});
		btnXoaTAKC.setEnabled(false);
		GridData gd_btnXoaTAKC = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnXoaTAKC.widthHint = 86;
		gd_btnXoaTAKC.heightHint = 30;
		btnXoaTAKC.setLayoutData(gd_btnXoaTAKC);
		btnXoaTAKC.setText("Xóa");
		btnXoaTAKC.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "src/rcp/view/page/edit_16x16.png"));
		
		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		gridThucAn = tableViewer.getTable();
		gridThucAn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnThemTAKC.setEnabled(true);
				btnXoaTAKC.setEnabled(true);
				gridTAKC.setEnabled(true);
				layThongTinTAKC(gridThucAn.getSelection()[0].getText(1));
			}
		});
		gridThucAn.setLinesVisible(true);
		gridThucAn.setHeaderVisible(true);
		GridData gd_gridThucAn = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2);
		gd_gridThucAn.heightHint = 259;
		gd_gridThucAn.widthHint = 630;
		gridThucAn.setLayoutData(gd_gridThucAn);

		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnStt = tableViewerColumn.getColumn();
		tblclmnStt.setWidth(60);
		tblclmnStt.setText("STT");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMThcn = tableViewerColumn_1.getColumn();
		tblclmnMThcn.setWidth(120);
		tblclmnMThcn.setText("Mã thức ăn");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTnThcn = tableViewerColumn_2.getColumn();
		tblclmnTnThcn.setWidth(280);
		tblclmnTnThcn.setText("Tên thức ăn");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnLoiThcn = tableViewerColumn_5.getColumn();
		tblclmnLoiThcn.setWidth(150);
		tblclmnLoiThcn.setText("Loại thức ăn");
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTrngThi = tableViewerColumn_6.getColumn();
		tblclmnTrngThi.setWidth(120);
		tblclmnTrngThi.setText("Trạng thái");
		
		TableViewer tableViewer_1 = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		gridTAKC = tableViewer_1.getTable();
		gridTAKC.setEnabled(false);
		gridTAKC.setLinesVisible(true);
		gridTAKC.setHeaderVisible(true);
		GridData gd_gridTAKC = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 2);
		gd_gridTAKC.widthHint = 21;
		gridTAKC.setLayoutData(gd_gridTAKC);
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnKchC = tableViewerColumn_3.getColumn();
		tblclmnKchC.setWidth(100);
		tblclmnKchC.setText("Kích cỡ");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnnGi = tableViewerColumn_4.getColumn();
		tblclmnnGi.setWidth(100);
		tblclmnnGi.setText("Đơn giá");
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);

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
		hienLoaiThucAn();
		hienTatCa();
		datLai();
	}

	/**
	 * Hàm đặt lại điều kiện tìm kiếm
	 */
	public void datLai() {
		chkTenThucAn.setSelection(true);
		txtTenThucAn.setText("");
		txtTenThucAn.setEnabled(chkTenThucAn.getSelection());

		chkLoaiThucAn.setSelection(false);
		cbLoaiThucAn.select(0);
		cbLoaiThucAn.setEnabled(chkLoaiThucAn.getSelection());

	}

	/**
	 * Hiển thị loại thức ăn lên comboBox
	 */
	public void hienLoaiThucAn() {
		try {
			ArrayList<LoaiThucAn> arr = LoaiThucAnController.taiTatCa();

			cbLoaiThucAn.removeAll();
			for (LoaiThucAn i : arr) {
				cbLoaiThucAn.add(i.getTenLoaiThucAn());
				cbLoaiThucAn.setData(i.getTenLoaiThucAn(), i.getMaLoaiThucAn());
			}

			cbLoaiThucAn.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Hàm hiện thông tin của tất cả thức ăn
	 */
	public void hienTatCa() {
		try {
			ArrayList<ThucAn> arr = ThucAnController.taiTatCa();

			gridThucAn.removeAll();
			int stt = 1;
			for (ThucAn i : arr) {
				TableItem item = new TableItem(gridThucAn, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaThucAn(), 
						i.getTenThucAn(), i.getLoaiThucAn(),String.valueOf(i.getTrangThai())});
				stt++;
			}

			gridThucAn.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hàm tìm kiếm thức ăn
	 */
	public void timKiem() {
		try {
			kiemTraHopLe();
			ArrayList<ThucAn> arr = ThucAnController.traCuu(
					chkTenThucAn.getSelection() ? txtTenThucAn.getText() : null,
					chkLoaiThucAn.getSelection() ? cbLoaiThucAn.getText() : null);

			gridThucAn.removeAll();
			int stt = 1;
			for (ThucAn i : arr) {
				TableItem item = new TableItem(gridThucAn, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaThucAn(), i.getTenThucAn(), i.getLoaiThucAn(), String.valueOf(i.getTrangThai()) });
				stt++;
			}

			gridThucAn.select(0);
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
		if (chkTenThucAn.getSelection() && txtTenThucAn.getText().isEmpty())
			throw new ParameterValuesException("Tên khách hàng không được trống", null);

	}
	
	/**
	 * Lấy thông tin kích cỡ theo mã thức ăn
	 */
	public void layThongTinTAKC(String maThucAn)
	{
		try {
			ArrayList<ThucAnKichCo> arr = ThucAnController.layThongTin_TAKC(maThucAn);

			gridTAKC.removeAll();
			for (ThucAnKichCo i : arr) {
				TableItem item = new TableItem(gridTAKC, SWT.NONE);
				item.setText(new String[] {  i.getKichCo(),String.valueOf(i.getDonGia())});
			}

			gridTAKC.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Hàm thực xóa
	 */
	public boolean xoa() {
		try {
			if (!ThucAnController.xoaKichCo(layThucAnKichCo_xoa()))
					throw new SQLException();
			Message.show("Xóa thông tin thức ăn thành công", "Thành công", SWT.OK | SWT.ICON_INFORMATION,
					getShell());
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
			Message.show("Không thể xóa kích cỡ của thức ăn", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
		}
		return false;
	}
	
	/**
	 * Lấy thức ăn kích cỡ (MaThucAn,KichCo) để xóa
	 */
	public ThucAnKichCo layThucAnKichCo_xoa() {
		return new ThucAnKichCo(gridThucAn.getSelection()[0].getText(1),gridTAKC.getSelection()[0].getText(0));
	}

}
