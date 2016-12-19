/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 */

package rcp.view.popup;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.PhimController;
import rcp.util.DateF;
import rcp.util.Message;

import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import rcp.entity.*;
import rcp.controller.*;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;

public class frmThemSuaPhim extends Shell {
	private Text txtMaPhim;
	private Text txtTenPhim;
	private Text txtDienVien;
	private Text txtDoanhThu;
	private Table tableSuatPhim;
	private Button btnLuu;
	private Button btnHuy;
	private Button btnThem;
	private Button btnXoa;
	private CTabFolder tabFolder;
	private CTabItem tabPhim;
	private CTabItem tabSuatPhim;
	private StyledText txtTomTat;
	private Spinner spnNamSX;
	private Spinner spnThoiLuong;
	private Combo cobTrangThai;
	private Combo cobNgonNgu;
	private Combo cobNhaSX;
	private Combo cobNuocSX;
	private Combo cobDinhDang;
	private DateTime dateTimeNgayChieu;
	private Combo cobHinhThuc;
	private Combo cobNgonNgu_SuatPhim;
	private Label labTenForm;
	private boolean isInsert;
	private Combo cobGioiHanTuoi;
	private ControlDecoration controlDecoration;
	private ArrayList<SuatPhim> aSuatPhim = new ArrayList<SuatPhim>();
	private Phim phim = new Phim();
	private String maPhim;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmThemSuaPhim(Display display, boolean isInsert, String maPhim) {
		super(display, SWT.MIN | SWT.TITLE);
		this.isInsert = isInsert;
		this.maPhim = maPhim;
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");

		labTenForm = new Label(this, SWT.NONE);
		labTenForm.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		labTenForm.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		labTenForm.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		labTenForm.setBounds(101, 26, 176, 23);

		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/imgThucAn_64p.png"));
		label_1.setBounds(30, 20, 64, 64);

		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 582, 561, 56);

		btnLuu = new Button(composite, SWT.NONE);
		btnLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				if (isInsert) {
					themPhim();
				} else
					suaPhim();

			}
		});
		btnLuu.setText("Lưu");
		btnLuu.setBounds(330, 10, 94, 33);

		btnHuy = new Button(composite, SWT.NONE);
		btnHuy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHuy.setText("Hủy bỏ");
		btnHuy.setBounds(442, 10, 94, 33);

		tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.marginWidth = 5;
		tabFolder.marginHeight = 5;
		tabFolder.setTabHeight(25);
		tabFolder.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		tabFolder.setBounds(10, 90, 541, 486);
		tabFolder.setSelectionBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		tabPhim = new CTabItem(tabFolder, SWT.NONE);
		tabPhim.setText("Phim");
		tabFolder.setSelection(tabPhim);

		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tabPhim.setControl(composite_1);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblMPhim = new Label(composite_1, SWT.NONE);
		lblMPhim.setText("Mã phim:");
		lblMPhim.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMPhim.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMPhim.setBounds(23, 33, 75, 15);

		txtMaPhim = new Text(composite_1, SWT.BORDER | SWT.READ_ONLY);
		txtMaPhim.setBounds(102, 30, 141, 24);

		Label lblTnPhim = new Label(composite_1, SWT.NONE);
		lblTnPhim.setText("Tên phim:");
		lblTnPhim.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnPhim.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnPhim.setBounds(23, 78, 64, 15);

		txtTenPhim = new Text(composite_1, SWT.BORDER | SWT.WRAP);
		txtTenPhim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (txtTenPhim.getText().isEmpty())
					controlDecoration.show();
				else
					controlDecoration.hide();
			}
		});
		txtTenPhim.setBounds(102, 75, 141, 72);

		Label lblTrngThi = new Label(composite_1, SWT.NONE);
		lblTrngThi.setText("Trạng thái:");
		lblTrngThi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTrngThi.setBounds(270, 33, 75, 15);

		ComboViewer comboViewer = new ComboViewer(composite_1, SWT.NONE);
		cobTrangThai = comboViewer.getCombo();
		cobTrangThai.setItems(new String[] { "Công chiếu", "Không công chiếu" });
		cobTrangThai.setBounds(351, 30, 141, 24);

		Label label = new Label(composite_1, SWT.NONE);
		label.setText("Thời lượng:");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(25, 172, 75, 15);

		ComboViewer comboViewer_1 = new ComboViewer(composite_1, SWT.NONE);
		cobNgonNgu = comboViewer_1.getCombo();
		cobNgonNgu.setBounds(353, 215, 141, 23);
		cobNgonNgu.select(0);

		Label label_3 = new Label(composite_1, SWT.NONE);
		label_3.setText("Ngôn ngữ:");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setBounds(272, 218, 75, 15);

		Label label_4 = new Label(composite_1, SWT.NONE);
		label_4.setText("Năm sản xuất:");
		label_4.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_4.setBounds(23, 218, 75, 15);

		Label label_5 = new Label(composite_1, SWT.NONE);
		label_5.setText("Giới hạn tuổi:");
		label_5.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_5.setBounds(23, 263, 75, 15);

		Label lblNhSnXut = new Label(composite_1, SWT.NONE);
		lblNhSnXut.setText("Nhà sản xuất:");
		lblNhSnXut.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNhSnXut.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNhSnXut.setBounds(272, 263, 75, 15);

		ComboViewer comboViewer_3 = new ComboViewer(composite_1, SWT.NONE);
		cobNhaSX = comboViewer_3.getCombo();
		cobNhaSX.setBounds(353, 260, 141, 23);
		cobNhaSX.select(0);

		Label label_9 = new Label(composite_1, SWT.NONE);
		label_9.setText("Tóm tắt:");
		label_9.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_9.setBounds(25, 353, 75, 15);

		txtTomTat = new StyledText(composite_1, SWT.WRAP | SWT.V_SCROLL | SWT.BORDER | SWT.WRAP);
		txtTomTat.setBounds(107, 353, 385, 81);

		spnNamSX = new Spinner(composite_1, SWT.BORDER);
		spnNamSX.setBounds(104, 215, 141, 24);
		spnNamSX.setMaximum(3000);

		spnThoiLuong = new Spinner(composite_1, SWT.BORDER);
		spnThoiLuong.setBounds(104, 171, 141, 24);
		spnThoiLuong.setMaximum(1000);

		Label label_8 = new Label(composite_1, SWT.NONE);
		label_8.setText("Diễn viên:");
		label_8.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_8.setBounds(270, 80, 75, 15);

		txtDienVien = new Text(composite_1, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtDienVien.setBounds(351, 78, 141, 69);

		Label label_10 = new Label(composite_1, SWT.NONE);
		label_10.setText("Doanh thu:");
		label_10.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_10.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_10.setBounds(272, 308, 75, 15);

		txtDoanhThu = new Text(composite_1, SWT.BORDER | SWT.READ_ONLY);
		txtDoanhThu.setBounds(353, 305, 141, 24);

		Label label_2 = new Label(composite_1, SWT.NONE);
		label_2.setText("Nước sản xuất:");
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setBounds(270, 175, 75, 15);

		ComboViewer comboViewer_2 = new ComboViewer(composite_1, SWT.NONE);
		cobNuocSX = comboViewer_2.getCombo();
		cobNuocSX.setBounds(351, 172, 141, 23);
		cobNuocSX.select(0);

		dateTimeNgayChieu = new DateTime(composite_1, SWT.BORDER);
		dateTimeNgayChieu.setBounds(102, 305, 141, 24);

		Label lblNgyChiu = new Label(composite_1, SWT.NONE);
		lblNgyChiu.setText("Ngày chiếu");
		lblNgyChiu.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNgyChiu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgyChiu.setBounds(23, 308, 75, 15);

		ComboViewer comboViewer_7 = new ComboViewer(composite_1, SWT.NONE);
		cobGioiHanTuoi = comboViewer_7.getCombo();
		cobGioiHanTuoi.setItems(new String[] { "0", "16", "18", "21" });
		cobGioiHanTuoi.setBounds(102, 260, 141, 23);
		cobGioiHanTuoi.select(0);

		tabSuatPhim = new CTabItem(tabFolder, SWT.NONE);
		tabSuatPhim.setText("Suất phim");

		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		tabSuatPhim.setControl(composite_2);

		TableViewer tableViewer = new TableViewer(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		tableSuatPhim = tableViewer.getTable();
		tableSuatPhim.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
			}
		});
		tableSuatPhim.setHeaderVisible(true);
		tableSuatPhim.setBounds(10, 134, 505, 300);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(53);
		tblclmnNewColumn.setText("STT");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_3.setWidth(137);
		tblclmnNewColumn_3.setText("Định dạng");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setWidth(165);
		tblclmnNewColumn_2.setText("Hình thức");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(145);
		tblclmnNewColumn_1.setText("Ngôn ngữ");

		Group group = new Group(composite_2, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group.setBounds(10, 10, 505, 105);

		Label lblnhDng = new Label(group, SWT.NONE);
		lblnhDng.setText("Định dạng");
		lblnhDng.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblnhDng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblnhDng.setBounds(24, 24, 75, 15);

		ComboViewer comboViewer_4 = new ComboViewer(group, SWT.NONE);
		cobDinhDang = comboViewer_4.getCombo();
		cobDinhDang.setBounds(105, 21, 141, 23);

		Label lblNgnNg = new Label(group, SWT.NONE);
		lblNgnNg.setText("Ngôn ngữ");
		lblNgnNg.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNgnNg.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgnNg.setBounds(24, 64, 75, 15);

		ComboViewer comboViewer_5 = new ComboViewer(group, SWT.NONE);
		cobNgonNgu_SuatPhim = comboViewer_5.getCombo();
		cobNgonNgu_SuatPhim.setBounds(105, 61, 141, 23);

		Label lblHnhThc = new Label(group, SWT.NONE);
		lblHnhThc.setText("Hình thức");
		lblHnhThc.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblHnhThc.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHnhThc.setBounds(273, 27, 75, 15);

		ComboViewer comboViewer_6 = new ComboViewer(group, SWT.NONE);
		cobHinhThuc = comboViewer_6.getCombo();
		cobHinhThuc.setBounds(354, 24, 141, 23);

		btnThem = new Button(group, SWT.NONE);
		btnThem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				themSuatPhim();
			}
		});
		btnThem.setText("Thêm");
		btnThem.setBounds(339, 61, 75, 25);

		btnXoa = new Button(group, SWT.NONE);
		btnXoa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				XoaSuatPhim();
			}
		});
		btnXoa.setText("Xóa");
		btnXoa.setBounds(420, 61, 75, 25);
		createContents();
		controlDecoration = new ControlDecoration(txtTenPhim, SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText("Tên phim là bắt buộc");
		org.eclipse.swt.graphics.Image image = FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_REQUIRED).getImage();
		controlDecoration.setImage(image);
		controlDecoration.hide();
		hienThi();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Thêm sửa phim");
		setSize(570, 667);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void hienThi() {
		taiNgonNgu();
		taiNhaSanXuat();
		taiNuocSX();
		taiHinhThuc();
		taiDinhDang();
		try {
			if (isInsert) {
				setText("Thêm phim");
				labTenForm.setText("Thêm phim");
				hienMa();

				spnThoiLuong.setSelection(100);
				spnNamSX.setSelection(Calendar.getInstance().get(Calendar.YEAR));
				txtDoanhThu.setText("0");
				cobTrangThai.setEnabled(false);

				cobGioiHanTuoi.select(0);
				cobNuocSX.select(0);
				cobDinhDang.select(0);
				cobHinhThuc.select(0);
				cobNgonNgu.select(0);
				cobNgonNgu_SuatPhim.select(0);
				cobNhaSX.select(0);
				cobTrangThai.select(0);
			} else {
				setText("Sửa phim");
				labTenForm.setText("Sửa phim");

				cobDinhDang.select(0);
				cobHinhThuc.select(0);
				cobNgonNgu_SuatPhim.select(0);
				taiSuatPhim();
				taiPhim();

			}
		} catch (Exception e) {
			Message.show(e.toString(), "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
		}
	}

	public void hienMa() {
		try {
			txtMaPhim.setText(PhimController.hienMa());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void taiNgonNgu() {
		try {
			ArrayList<NgonNgu> aNgonNgu = NgonNguController.taiTatCa();
			int i = 0;
			for (NgonNgu nn : aNgonNgu) {
				cobNgonNgu.add(nn.getTenNgonNgu(), i);
				cobNgonNgu.setData(nn.getTenNgonNgu(), nn.getMaNgonNgu());
				cobNgonNgu_SuatPhim.add(nn.getTenNgonNgu(), i);
				cobNgonNgu_SuatPhim.setData(nn.getTenNgonNgu(), nn.getMaNgonNgu());
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void taiNhaSanXuat() {
		try {
			ArrayList<NhaSanXuat> aNhaSX = NhaSanXuatController.taiTatCa();
			int i = 0;
			for (NhaSanXuat nsx : aNhaSX) {
				cobNhaSX.add(nsx.getTenNhaSX(), i);
				cobNhaSX.setData(nsx.getTenNhaSX(), nsx.getMaNhaSX());
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void taiNuocSX() {
		try {
			ArrayList<NuocSX> aNuocSX = NuocSXController.taiTatCa();
			int i = 0;
			for (NuocSX nsx : aNuocSX) {
				cobNuocSX.add(nsx.getTenNuocSX(), i);
				cobNuocSX.setData(nsx.getTenNuocSX(), nsx.getMaNuocSX());
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void taiDinhDang() {
		try {
			ArrayList<DinhDang> aDinhDang = DinhDangController.taiTatCa();
			int i = 0;
			for (DinhDang dd : aDinhDang) {
				cobDinhDang.add(dd.getTenDinhDang(), i);
				cobDinhDang.setData(dd.getTenDinhDang(), dd.getMaDinhDang());
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void taiHinhThuc() {
		try {
			ArrayList<HinhThuc> aHinhThuc = HinhThucController.taiTatCa();
			int i = 0;
			for (HinhThuc ht : aHinhThuc) {
				cobHinhThuc.add(ht.getTenHinhThuc(), i);
				cobHinhThuc.setData(ht.getTenHinhThuc(), ht.getMaHinhThuc());
				i++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void themSuatPhim() {
		if (themMang((String) cobDinhDang.getData(cobDinhDang.getText()),
				(String) cobHinhThuc.getData(cobHinhThuc.getText()),
				(String) cobNgonNgu_SuatPhim.getData(cobNgonNgu_SuatPhim.getText()))) {
			if (!isInsert) {
				SuatPhim tempt = aSuatPhim.get(aSuatPhim.size() - 1);
				try {
					if (SuatPhimController.them(tempt)) {
						taiSuatPhim();
						Message.show("Thêm suất phim thành công", "Thông báo", SWT.OK | SWT.ICON_INFORMATION,
								getShell());
					} else {
						Message.show("Thêm suất phim không thành công", "Thông báo", SWT.OK | SWT.ICON_INFORMATION,
								getShell());
						return;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				TableItem item = new TableItem(tableSuatPhim, SWT.NONE);
				item.setText(new String[] { String.valueOf(tableSuatPhim.getItemCount()), cobDinhDang.getText(),
						cobHinhThuc.getText(), cobNgonNgu_SuatPhim.getText() });
				tableSuatPhim.select(0);
			}

		} else
			Message.show("Suất phim đã tồn tại", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
	}

	public boolean themMang(String MaDD, String MaHT, String MaNN) {
		for (SuatPhim sp : aSuatPhim)
			if (sp.getMaDinhDang().equals(MaDD) && sp.getMaHinhThuc().equals(MaHT) && sp.getMaNgonNgu().equals(MaNN))
				return false;
		aSuatPhim.add(new SuatPhim(null, maPhim, MaDD, MaHT, MaNN));
		return true;
	}

	public void XoaSuatPhim() {
		try {
			String maSuatPhim = null;
			TableItem item = tableSuatPhim.getItem(tableSuatPhim.getSelectionIndex());
			Iterator<SuatPhim> iter = aSuatPhim.iterator();
			while (iter.hasNext()) {
				SuatPhim sp = iter.next();
				if (sp.getMaDinhDang().equals((String) cobDinhDang.getData(item.getText(1)))
						&& sp.getMaHinhThuc().equals((String) cobHinhThuc.getData(item.getText(2)))
						&& sp.getMaNgonNgu().equals((String) cobNgonNgu_SuatPhim.getData(item.getText(3)))) {
					// Use iterator to remove this User object.
					maSuatPhim = sp.getMaSuatPhim();
					if (!isInsert) {
						try {
							if (SuatPhimController.xoa(maSuatPhim))
								Message.show("Xóa suất phim thành công", "Thông báo", SWT.OK | SWT.ICON_INFORMATION,
										getShell());
							else {
								Message.show("Xóa suất phim không thành công", "Thông báo",
										SWT.OK | SWT.ICON_INFORMATION, getShell());
								return;
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					iter.remove();
				}
			}
			tableSuatPhim.remove(tableSuatPhim.getSelectionIndex());
		} catch (Exception e) {

		}

	}

	public boolean kiemTraDayDu() {

		if (txtTenPhim.getText().isEmpty()) {
			Message.show("Mời bạn nhập tên phim", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
			return false;
		}
		if (tableSuatPhim.getItemCount() == 0) {
			tabFolder.setSelection(tabSuatPhim);
			Message.show("Mời bạn nhập suất phim", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
			return false;

		}
		return true;
	}

	public void themPhim() {
		if (kiemTraDayDu()) {
			themMaPhim_SuatPhim();
			taoPhim();
			try {
				if (PhimController.them(phim, aSuatPhim))
					Message.show("Thêm phim thành công", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
				else
					Message.show("Thêm phim không thành công", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void themMaPhim_SuatPhim() {
		for (SuatPhim sp : aSuatPhim) {
			sp.setMaPhim(txtMaPhim.getText());
		}
	}

	public void taoPhim() {
		phim.setMaPhim(txtMaPhim.getText());
		phim.setCacDienVien(txtDienVien.getText());
		phim.setGioiHanTuoi(Integer.parseInt(cobGioiHanTuoi.getText()));
		phim.setMaNgonNgu((String) cobNgonNgu.getData(cobNgonNgu.getText()));
		phim.setMaNhaSX((String) cobNhaSX.getData(cobNhaSX.getText()));
		phim.setMaNuocSX((String) cobNuocSX.getData(cobNuocSX.getText()));
		phim.setMaPhim(txtMaPhim.getText());
		phim.setNamSX(Integer.parseInt(spnNamSX.getText()));
		phim.setNgayKhoiChieu(
				DateF.toDate(dateTimeNgayChieu.getYear(), dateTimeNgayChieu.getMonth(), dateTimeNgayChieu.getDay()));
		phim.setTenPhim(txtTenPhim.getText());
		phim.setThoiLuong(Integer.parseInt(spnThoiLuong.getText()));
		phim.setTomTat(txtTomTat.getText());
		phim.setTrangThai((cobTrangThai.getText().equals("Công chiếu")) ? 1 : 0);
		phim.setDoanhThu(Double.parseDouble(txtDoanhThu.getText()));
	}

	public void taiSuatPhim() {
		try {
			aSuatPhim.clear();
			ArrayList<SuatPhim> aSP = SuatPhimController.taiDanhSach(maPhim);
			tableSuatPhim.removeAll();
			for (SuatPhim sp : aSP) {
				TableItem item = new TableItem(tableSuatPhim, SWT.NONE);
				item.setText(new String[] { String.valueOf(tableSuatPhim.getItemCount()), sp.getMaDinhDang(),
						sp.getMaHinhThuc(), sp.getMaNgonNgu() });
				aSuatPhim.add(new SuatPhim(sp.getMaSuatPhim(), maPhim, (String) cobDinhDang.getData(sp.getMaDinhDang()),
						(String) cobHinhThuc.getData(sp.getMaHinhThuc()),
						(String) cobNgonNgu.getData(sp.getMaNgonNgu())));
			}
			tableSuatPhim.select(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void taiPhim() {
		try {
			phim = PhimController.layThongTin(maPhim);
			txtDienVien.setText(phim.getCacDienVien());
			txtDoanhThu.setText(String.valueOf(phim.getDoanhThu()));
			txtMaPhim.setText(phim.getMaPhim());
			txtTenPhim.setText(phim.getTenPhim());
			txtTomTat.setText(phim.getTomTat());
			cobGioiHanTuoi.setText(String.valueOf(phim.getGioiHanTuoi()));
			cobNgonNgu.setText(phim.getMaNgonNgu());
			cobNhaSX.setText(phim.getMaNhaSX());
			cobNuocSX.setText(phim.getMaNuocSX());
			cobTrangThai.setText((phim.getTrangThai() == 1) ? "Công chiếu" : "Không công chiếu");
			spnNamSX.setSelection(phim.getNamSX());
			spnThoiLuong.setSelection(phim.getThoiLuong());
			dateTimeNgayChieu.setDate(DateF.getYear(phim.getNgayKhoiChieu()), DateF.getMonth(phim.getNgayKhoiChieu()),
					DateF.getDay(phim.getNgayKhoiChieu()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void suaPhim() {
		if (kiemTraDayDu()) {
			try {
				taoPhim();
				if (PhimController.sua(phim))
					Message.show("Cập nhật phim thành công", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
				else
					Message.show("Cập nhât phim không thành công", "Thông báo", SWT.OK | SWT.ICON_INFORMATION,
							getShell());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
