/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.view.popup;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.PhimController;
import rcp.controller.PhongChieuController;
import rcp.controller.SuatChieuController;
import rcp.entity.Phim;
import rcp.entity.PhongChieu;
import rcp.entity.SuatChieu;
import rcp.entity.SuatPhim;
import rcp.util.DateF;
import rcp.util.Message;

public class frmSuatChieu extends Shell {
	private boolean isInsert = false;
	private SuatChieu sc = null;

	private Table gridSuatPhim;
	private Combo cbTenPhim;
	private Combo cbPhong;
	private DateTime dateTime;
	private DateTime dateTime_Gio;
	private Button btnLu;
	private Button btnHyB;
	private Text txtMaSuatChieu;
	private Combo cbTrangThai;
	private Text txtMaSuatPhim;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmSuatChieu(Display display, String title, SuatChieu sc) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		setText(title);

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");

		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText(title);
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 176, 23);

		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(SWTResourceManager.getImage(frmSuatChieu.class, "/rcp/view/popup/imgSuatChieu_64p.png"));
		label_1.setBounds(30, 20, 64, 64);

		Label lblMThcn = new Label(this, SWT.NONE);
		lblMThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMThcn.setText("Mã suất chiếu:");
		lblMThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMThcn.setBounds(30, 102, 82, 15);

		txtMaSuatChieu = new Text(this, SWT.BORDER);
		txtMaSuatChieu.setEnabled(false);
		txtMaSuatChieu.setBounds(112, 99, 141, 24);

		Label lblTnThcn = new Label(this, SWT.NONE);
		lblTnThcn.setText("Tên phim:");
		lblTnThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnThcn.setBounds(30, 147, 75, 15);

		Label lblnGi = new Label(this, SWT.NONE);
		lblnGi.setText("Giờ: ");
		lblnGi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblnGi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblnGi.setBounds(30, 195, 75, 15);

		Label lblLoiThcn = new Label(this, SWT.NONE);
		lblLoiThcn.setText("Phòng:");
		lblLoiThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblLoiThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLoiThcn.setBounds(277, 102, 75, 15);

		ComboViewer comboViewer = new ComboViewer(this, SWT.NONE);
		cbPhong = comboViewer.getCombo();
		cbPhong.setBounds(358, 99, 141, 23);

		Label lblKchC = new Label(this, SWT.NONE);
		lblKchC.setText("Thời gian:");
		lblKchC.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblKchC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblKchC.setBounds(277, 150, 75, 15);

		ComboViewer comboViewer_2 = new ComboViewer(this, SWT.NONE);
		cbTrangThai = comboViewer_2.getCombo();
		cbTrangThai.setEnabled(false);
		cbTrangThai.setBounds(358, 192, 141, 23);

		Label lblTrngThi = new Label(this, SWT.NONE);
		lblTrngThi.setText("Trạng thái:");
		lblTrngThi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTrngThi.setBounds(277, 196, 75, 15);

		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 438, 529, 56);

		btnLu = new Button(composite, SWT.NONE);
		btnLu.setImage(SWTResourceManager.getImage(frmSuatChieu.class, "/rcp/view/page/save_16x16.png"));
		btnLu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (luu())
					close();
			}
		});
		btnLu.setText("Lưu");
		btnLu.setBounds(325, 10, 94, 33);

		btnHyB = new Button(composite, SWT.NONE);
		btnHyB.setImage(SWTResourceManager.getImage(frmSuatChieu.class, "/rcp/view/page/cancel_16x16.png"));
		btnHyB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHyB.setText("Hủy bỏ");
		btnHyB.setBounds(425, 10, 94, 33);

		ComboViewer comboViewer_3 = new ComboViewer(this, SWT.NONE);
		cbTenPhim = comboViewer_3.getCombo();
		cbTenPhim.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtMaSuatPhim.setText("");
				layThongTinSuatPhim((String) cbTenPhim.getData(cbTenPhim.getText()));
			}
		});
		cbTenPhim.setBounds(112, 144, 141, 23);

		dateTime = new DateTime(this, SWT.BORDER | SWT.DROP_DOWN);
		dateTime.setBounds(358, 144, 141, 24);

		TableViewer tableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		gridSuatPhim = tableViewer.getTable();
		gridSuatPhim.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtMaSuatPhim.setText((String) gridSuatPhim.getSelection()[0].getText(0));
			}
		});
		gridSuatPhim.setLinesVisible(true);
		gridSuatPhim.setHeaderVisible(true);
		gridSuatPhim.setBounds(30, 281, 469, 135);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMSutPhim = tableViewerColumn.getColumn();
		tblclmnMSutPhim.setWidth(105);
		tblclmnMSutPhim.setText("Mã suất phim");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnnhDng = tableViewerColumn_1.getColumn();
		tblclmnnhDng.setWidth(118);
		tblclmnnhDng.setText("Định dạng");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnHnhThc = tableViewerColumn_2.getColumn();
		tblclmnHnhThc.setWidth(120);
		tblclmnHnhThc.setText("Hình thức");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNgnNg = tableViewerColumn_3.getColumn();
		tblclmnNgnNg.setWidth(120);
		tblclmnNgnNg.setText("Ngôn ngữ");

		dateTime_Gio = new DateTime(this, SWT.BORDER | SWT.TIME);
		dateTime_Gio.setBounds(112, 189, 141, 24);

		Label lblMSutPhim = new Label(this, SWT.NONE);
		lblMSutPhim.setText("Mã suất phim:");
		lblMSutPhim.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMSutPhim.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMSutPhim.setBounds(30, 238, 75, 15);

		txtMaSuatPhim = new Text(this, SWT.BORDER);
		txtMaSuatPhim.setEnabled(false);
		txtMaSuatPhim.setBounds(112, 235, 141, 25);
		
		isInsert = sc == null;
		this.sc = sc;
		createContents();
		setDefaultButton(btnLu);
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		hienThiGiaoDien();
		setSize(534, 523);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * Hiển thị giao diện
	 */
	public void hienThiGiaoDien() {
		hienPhong();
		hienTrangThai();
		hienPhim();

		try {
			if (isInsert) {
				txtMaSuatChieu.setText(SuatChieuController.taoMa());
				layThongTinSuatPhim((String) cbTenPhim.getData(cbTenPhim.getText()));
			} else {
				dateTime.setDate(DateF.getYear(sc.getNgayChieu()), DateF.getMonth(sc.getNgayChieu()),
						DateF.getDay(sc.getNgayChieu()));
				txtMaSuatPhim.setText(sc.getMaSuatPhim());
				txtMaSuatChieu.setText(sc.getMaSuatChieu());
				cbPhong.setText(sc.getPhong());
				cbTenPhim.setText(sc.getTenPhim());

				dateTime_Gio.setTime(DateF.getHour(sc.getGioChieu()), DateF.getMinute(sc.getGioChieu()), 0);
				cbTrangThai.select(sc.getTrangThai());

				layThongTinSuatPhim((String) cbTenPhim.getData(cbTenPhim.getText()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Chuyển các thông tin trên giao diện thành đối tượng Suất chiếu
	 * 
	 * @return
	 */
	public SuatChieu laySuatChieu() {
		return new SuatChieu(txtMaSuatChieu.getText(),
				DateF.toDate(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay()),
				gridSuatPhim.getSelection()[0].getText(0), (String) cbPhong.getData(cbPhong.getText()),
				cbTrangThai.getSelectionIndex());
	}

	/**
	 * Hiển thị phòng lên combobox phòng
	 */
	public void hienPhong() {
		try {
			ArrayList<PhongChieu> arr = PhongChieuController.taiTatCa();

			cbPhong.removeAll();
			for (PhongChieu i : arr) {
				cbPhong.add(i.getTenPhong());
				cbPhong.setData(i.getTenPhong(), i.getMaPhong());
			}

			cbPhong.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hiển thị trạng thái lên combobox Trạng Thái
	 */
	public void hienTrangThai() {
		cbTrangThai.add("Đã chiếu", 0);
		cbTrangThai.add("Đang chiếu", 1);
		cbTrangThai.add("Sắp chiếu", 2);
		cbTrangThai.select(2);
	}

	/**
	 * Hiển thị tên phim lên combobox Phim
	 */
	public void hienPhim() {
		try {
			ArrayList<Phim> arr = PhimController.taiTatCa_phimdangchieu();

			cbTenPhim.removeAll();
			for (Phim i : arr) {
				cbTenPhim.add(i.getTenPhim());
				cbTenPhim.setData(i.getTenPhim(), i.getMaPhim());
			}
			cbTenPhim.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Thực hiện hành động lưu thông tin
	 * 
	 * @return
	 */
	public boolean luu() {
		try {
			Calendar c=Calendar.getInstance();
			c.set(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), dateTime_Gio.getHours(), dateTime_Gio.getMinutes());
			if(Calendar.getInstance().after(c))
			{
				Message.show("Thời điểm chiếu không hợp lệ", "Lỗi", SWT.OK, getShell());
				return false;
			}
			if (isInsert) {
				
				if (!SuatChieuController.them(laySuatChieu_them()))
					throw new SQLException();
			} else {
				if (!SuatChieuController.sua(laySuatChieu_sua()))
					throw new SQLException();
			}
			Message.show("Lưu thông tin suất chiếu thành công", "Thành công", SWT.OK | SWT.ICON_INFORMATION,
					getShell());
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
			Message.show("Không thể lưu thông tin suất chiếu", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
		}
		return false;
	}

	/**
	 * Lấy thông tin suất phim theo mã phim
	 */
	public void layThongTinSuatPhim(String maPhim) {
		try {
			ArrayList<SuatPhim> arr = SuatChieuController.layDanhSachSuatPhim(maPhim);

			gridSuatPhim.removeAll();
			for (SuatPhim i : arr) {
				TableItem item = new TableItem(gridSuatPhim, SWT.NONE);
				item.setText(
						new String[] { i.getMaSuatPhim(), i.getMaDinhDang(), i.getMaHinhThuc(), i.getMaNgonNgu() });
			}

			gridSuatPhim.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Chuyển các thông tin trên giao diện thành đối tượng suất chiếu để thêm
	 * 
	 * @return
	 */
	public SuatChieu laySuatChieu_them() {
		return new SuatChieu(txtMaSuatChieu.getText(),
				DateF.toDate(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), dateTime_Gio.getHours(),
						dateTime_Gio.getMinutes(), dateTime_Gio.getSeconds()),
				txtMaSuatPhim.getText(), (String) cbPhong.getData(cbPhong.getText()));
	}

	/**
	 * Chuyển các thông tin trên giao diện thành đối tượng suất chiếu để sửa
	 * 
	 * @return
	 */
	public SuatChieu laySuatChieu_sua() {
		return new SuatChieu(txtMaSuatChieu.getText(),
				DateF.toDate(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), dateTime_Gio.getHours(),
						dateTime_Gio.getMinutes(), dateTime_Gio.getSeconds()),
				txtMaSuatPhim.getText(), (String) cbPhong.getData(cbPhong.getText()), cbTrangThai.getSelectionIndex());
	}

}
