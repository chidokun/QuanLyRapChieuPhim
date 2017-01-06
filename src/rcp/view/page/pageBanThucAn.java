/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hoàng Hồ
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.Settings;
import rcp.controller.HoaDonController;
import rcp.controller.ThucAnController;
import rcp.controller.ThucAnKichCoController;
import rcp.entity.ChiTietHDThucAn;
import rcp.entity.HoaDonThucAn;
import rcp.entity.ThucAn;
import rcp.entity.ThucAnKichCo;
import rcp.util.Database;
import rcp.util.DateF;
import rcp.util.Message;
import rcp.util.Window;
import rcp.view.popup.frmBaoCao;

public class pageBanThucAn extends Composite {
	private NumberFormat c = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

	private Table tableThucAnKichCo;
	private Button ckbDoAn;
	private Button ckbNuocUong;
	private Button btnBan;
	private DateTime dateTimeNgayBan;
	private Button btnXoa;
	private Label labelTongTien;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageBanThucAn(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		setLayout(gridLayout);

		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.heightHint = 385;
		gd_composite.widthHint = 399;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblTraCuThucAn = new Label(composite, SWT.NONE);
		lblTraCuThucAn.setText("Loại thức ăn");
		lblTraCuThucAn.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblTraCuThucAn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuThucAn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblTraCuThucAn.setBounds(29, 17, 109, 23);

		ckbDoAn = new Button(composite, SWT.CHECK);
		ckbDoAn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				traCuu();
			}
		});
		ckbDoAn.setText("Đồ ăn");
		ckbDoAn.setSelection(true);
		ckbDoAn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		ckbDoAn.setBounds(157, 20, 67, 16);
		ckbDoAn.setSelection(true);

		ckbNuocUong = new Button(composite, SWT.CHECK);
		ckbNuocUong.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				traCuu();
			}
		});
		ckbNuocUong.setText("Nước uống");
		ckbNuocUong.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		ckbNuocUong.setBounds(250, 20, 122, 16);
		ckbNuocUong.setSelection(true);

		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableThucAnKichCo = tableViewer.getTable();
		tableThucAnKichCo.setLinesVisible(true);
		tableThucAnKichCo.setHeaderVisible(true);
		tableThucAnKichCo.setBounds(21, 126, 356, 431);

		TableColumn tblclmnNewColumn_2 = new TableColumn(tableThucAnKichCo, SWT.NONE);
		tblclmnNewColumn_2.setText("Mã thức ăn kích cỡ");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMThcn = tableViewerColumn.getColumn();
		tblclmnMThcn.setWidth(79);
		tblclmnMThcn.setText("Mã thức ăn");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTnThcn_1 = tableViewerColumn_1.getColumn();
		tblclmnTnThcn_1.setWidth(116);
		tblclmnTnThcn_1.setText("Tên thức ăn");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnKchC_1 = tableViewerColumn_2.getColumn();
		tblclmnKchC_1.setWidth(72);
		tblclmnKchC_1.setText("Kích cỡ");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnnGi_1 = tableViewerColumn_3.getColumn();
		tblclmnnGi_1.setWidth(80);
		tblclmnnGi_1.setText("Đơn giá");

		Group group = new Group(composite, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		group.setBounds(21, 46, 356, 64);

		Label lblSLng = new Label(group, SWT.NONE);
		lblSLng.setBounds(20, 27, 60, 15);
		lblSLng.setText("Số lượng: ");
		lblSLng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		spnSoLuong = new Spinner(group, SWT.BORDER);
		spnSoLuong.setMinimum(1);
		spnSoLuong.setBounds(103, 24, 88, 23);

		Button btnChon = new Button(group, SWT.NONE);
		btnChon.setBounds(258, 19, 88, 30);
		btnChon.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				themThucAnKichCo();
			}
		});
		btnChon.setText("Chọn");
		btnChon.setImage(SWTResourceManager.getImage(pageBanThucAn.class, "/rcp/view/popup/yes_16x16.png"));

		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_1 = new GridLayout(8, false);
		gl_composite_1.marginBottom = 15;
		gl_composite_1.marginTop = 10;
		gl_composite_1.marginWidth = 15;
		composite_1.setLayout(gl_composite_1);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite_1.widthHint = 823;
		gd_composite_1.heightHint = 346;
		composite_1.setLayoutData(gd_composite_1);

		btnBan = new Button(composite_1, SWT.NONE);
		btnBan.setImage(SWTResourceManager.getImage(pageBanThucAn.class, "/rcp/view/page/buy_16x16.png"));
		btnBan.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				them();
			}
		});
		GridData gd_btnBan = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnBan.heightHint = 30;
		gd_btnBan.widthHint = 78;
		btnBan.setLayoutData(gd_btnBan);
		btnBan.setText("Bán");

		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 94;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setText("          Ngày bán:");

		dateTimeNgayBan = new DateTime(composite_1, SWT.BORDER | SWT.DROP_DOWN);
		GridData gd_dateTimeNgayBan = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateTimeNgayBan.heightHint = 28;
		gd_dateTimeNgayBan.widthHint = 103;
		dateTimeNgayBan.setLayoutData(gd_dateTimeNgayBan);
		dateTimeNgayBan.setEnabled(false);

		Label lblMHan = new Label(composite_1, SWT.NONE);
		GridData gd_lblMHan = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblMHan.widthHint = 80;
		lblMHan.setLayoutData(gd_lblMHan);
		lblMHan.setText("   Mã hóa đơn:");
		lblMHan.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtMaHD = new Text(composite_1, SWT.BORDER);
		GridData gd_txtMaHD = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_txtMaHD.heightHint = 20;
		gd_txtMaHD.widthHint = 74;
		txtMaHD.setLayoutData(gd_txtMaHD);
		txtMaHD.setEnabled(false);

		Label lblNgyBn = new Label(composite_1, SWT.NONE);
		GridData gd_lblNgyBn = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_lblNgyBn.heightHint = 18;
		gd_lblNgyBn.widthHint = 77;
		lblNgyBn.setLayoutData(gd_lblNgyBn);
		lblNgyBn.setText("       Tổng tiền:");
		lblNgyBn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		labelTongTien = new Label(composite_1, SWT.NONE);
		labelTongTien.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		GridData gd_labelTongTien = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_labelTongTien.widthHint = 97;
		labelTongTien.setLayoutData(gd_labelTongTien);
		labelTongTien.setText("0 đ");
		labelTongTien.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		btnXoa = new Button(composite_1, SWT.NONE);
		btnXoa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				xoaCTHD();
			}
		});
		GridData gd_btnXoa = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnXoa.heightHint = 30;
		gd_btnXoa.widthHint = 76;
		btnXoa.setLayoutData(gd_btnXoa);
		btnXoa.setText("Xóa");
		btnXoa.setImage(SWTResourceManager.getImage(pageBanThucAn.class, "/rcp/view/page/deletelist_16x16.png"));

		TableViewer tableViewer_1 = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		tableCTHD = tableViewer_1.getTable();
		tableCTHD.setLinesVisible(true);
		tableCTHD.setHeaderVisible(true);
		tableCTHD.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 8, 1));

		TableColumn tableColumn = new TableColumn(tableCTHD, SWT.NONE);
		tableColumn.setText("Mã thức ăn kích cỡ");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_1 = tableViewerColumn_4.getColumn();
		tableColumn_1.setWidth(119);
		tableColumn_1.setText("Mã thức ăn");

		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_2 = tableViewerColumn_5.getColumn();
		tableColumn_2.setWidth(131);
		tableColumn_2.setText("Tên thức ăn");

		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_3 = tableViewerColumn_6.getColumn();
		tableColumn_3.setWidth(122);
		tableColumn_3.setText("Kích cỡ");

		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_4 = tableViewerColumn_7.getColumn();
		tableColumn_4.setWidth(120);
		tableColumn_4.setText("Đơn giá");

		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_5 = tableViewerColumn_8.getColumn();
		tableColumn_5.setWidth(109);
		tableColumn_5.setText("Số lượng");

		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn_6 = tableViewerColumn_9.getColumn();
		tableColumn_6.setWidth(130);
		tableColumn_6.setText("Thành tiền");

		traCuu();
		hienMa();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private Spinner spnSoLuong;
	private Text txtMaHD;
	private Table tableCTHD;
	/**
	 * Tra cứu thức ăn
	 */
	public void traCuu() {
		try {
			ArrayList<ThucAnKichCo> arr = new ArrayList<ThucAnKichCo>();
			int loaiThucAn = 0;
			if (ckbNuocUong.getSelection() && ckbDoAn.getSelection())
				loaiThucAn = 0;
			if (!ckbDoAn.getSelection() && ckbNuocUong.getSelection())
				loaiThucAn = 2;
			if (ckbDoAn.getSelection() && !ckbNuocUong.getSelection())
				loaiThucAn = 1;
			arr = ThucAnKichCoController.traCuu(loaiThucAn);
			tableThucAnKichCo.removeAll();
			for (ThucAnKichCo takc : arr) {
				ThucAn ta = ThucAnController.layThongTin(takc.getMaThucAn());
				TableItem item = new TableItem(tableThucAnKichCo, SWT.NONE);
				item.setText(new String[] { takc.getMaThucAnKichCo(), takc.getMaThucAn(), ta.getTenThucAn(),
						takc.getKichCo(), c.format(takc.getDonGia()) });
			}
			tableThucAnKichCo.select(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Thêm thức ăn vào hóa đơn tạm thời
	 */
	public void themThucAnKichCo() {
		try {
			if (spnSoLuong.getSelection() == 0) {
				Message.show("Mời bạn nhập số lượng thức ăn", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
				return;
			}
			TableItem i = tableThucAnKichCo.getItem(tableThucAnKichCo.getSelectionIndex());
			if (kiemTra(i.getText(0))) {
				TableItem item = new TableItem(tableCTHD, SWT.NONE);
				Double thanhTien = spnSoLuong.getSelection() * c.parse(i.getText(4)).doubleValue();
				item.setText(new String[] { i.getText(0), i.getText(1), i.getText(2), i.getText(3), i.getText(4),
						spnSoLuong.getText(), c.format(thanhTien) });
				capNhatTongTien(thanhTien);

			} else
				Message.show("Thức ăn này đã được chọn", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
			spnSoLuong.setSelection(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Kiểm tra thức ăn kích cỡ có tồn tại trong hóa đơn hay chưa?
	 */
	public boolean kiemTra(String maTAKC) {
		for (TableItem i : tableCTHD.getItems()) {
			if (i.getText(0).equals(maTAKC))
				return false;
		}
		return true;
	}
	/**
	 * Cập nhật tổng tiền
	 */
	public void capNhatTongTien(Double thanhTien) {
		try {
			Double tempt = labelTongTien.getText().isEmpty() ? 0 : c.parse(labelTongTien.getText()).doubleValue();
			labelTongTien.setText(c.format(tempt + thanhTien));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Hiển thị mã hóa đơn tự phát sinh
	 */
	public void hienMa() {
		try {
			txtMaHD.setText(HoaDonController.hienMa());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Thêm hóa đơn 
	 */
	public void them() {
		if (kiemtraCTHD()) {
			HoaDonThucAn hd = new HoaDonThucAn();
			hd.setMaHoaDon(txtMaHD.getText());
			hd.setMaNhanVien(Settings.currentEmpId);
			ArrayList<ChiTietHDThucAn> arr = new ArrayList<ChiTietHDThucAn>();
			for (TableItem i : tableCTHD.getItems()) {
				ChiTietHDThucAn ct = new ChiTietHDThucAn();
				ct.setMaHoaDon(txtMaHD.getText());
				ct.setMaThucAnKichCo(i.getText(0));
				ct.setSoLuong(Integer.parseInt(i.getText(5)));
				arr.add(ct);
			}
			try {
				if (HoaDonController.them(hd, arr))
				{
					MessageBox message=new MessageBox(getShell(), SWT.CANCEL |SWT.OK| SWT.ICON_QUESTION);
					message.setMessage("Thêm hóa đơn thành công. Bạn có muốn in hóa đơn?");
					message.setText("Hỏi");
					int buttonID=message.open();
					if(buttonID==SWT.OK)
						try {
							inHoaDon();
						} catch (ParameterValuesException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
				else
					Message.show("Thêm hóa đơn không thành công", "Thông báo", SWT.OK | SWT.ICON_INFORMATION,
							getShell());
				tableCTHD.removeAll();
				arr.clear();
				hienMa();
				labelTongTien.setText("0 đ");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * Kiểm tra chi tiết hóa đơn có trống hay không
	 */
	public boolean kiemtraCTHD() {
		if (tableCTHD.getItemCount() == 0) {
			Message.show("Mời bạn chọn thức ăn", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
			return false;
		}
		return true;

	}
	/**
	 * Xóa chi tiết hóa đơn ra khỏi hóa đơn tạm thời
	 */
	public void xoaCTHD() {
		try {
			capNhatTongTien(-c.parse(tableCTHD.getSelection()[0].getText(6)).doubleValue());
			tableCTHD.remove(tableCTHD.getSelectionIndex());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * In hóa đơn
	 */
	public void inHoaDon() throws ParameterValuesException
	{
		try
		{
		Connection connection = null;
	        try {
	            connection = Database.connect();
	            HashMap<String,Object> parameterMap = new HashMap<>();
	            parameterMap.put("MaHD", txtMaHD.getText());//sending the report title as a parameter.
	            parameterMap.put("NgayHD", DateF.toString(DateF.toDate(dateTimeNgayBan.getYear(), dateTimeNgayBan.getMonth(), dateTimeNgayBan.getDay())));
	            parameterMap.put("TongTien", labelTongTien.getText());
	            parameterMap.put("MaNV",Settings.currentEmpId);  
	            parameterMap.put("cinemaName", Settings.get("cinemaName"));
				parameterMap.put("cinemaAddr", Settings.get("cinemaAddr"));
				parameterMap.put("cinemaEmail", Settings.get("cinemaEmail"));
				parameterMap.put("cinemaTel", Settings.get("cinemaTel"));
	            Window.open(new frmBaoCao(getDisplay(),parameterMap,connection,"Invoice"));    
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
