/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.control;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.*;
import rcp.view.page.*;
import rcp.Settings;
import rcp.controller.QuyenHanController;
import rcp.entity.QuyenHan;
import rcp.util.*;

public class toolDanhMuc extends Composite {
	@SuppressWarnings("unused")
	private CTabFolder controlled;
	private CLabel lblPhim;
	private CLabel lblSuatChieu;
	private CLabel lblThucAn;
	private CLabel lblNhanVien;
	private CLabel lblKhachHang;
	private CLabel lblHoaDon;
	private CLabel lblV;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public toolDanhMuc(Composite parent, int style, CTabFolder controlled) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(240, 240, 240));
		GridLayout gridLayout = new GridLayout(7, false);
		gridLayout.marginHeight = 7;
		gridLayout.marginWidth = 7;
		setLayout(gridLayout);

		this.controlled = controlled;

		lblPhim = new CLabel(this, SWT.NONE);
		lblPhim.setImage(SWTResourceManager.getImage(toolDanhMuc.class, "/rcp/view/control/imgPhim_32p.png"));
		lblPhim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblPhim);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblPhim);
				Window.openPageInTab(controlled, new pagePhim(controlled, SWT.NONE), "Quản lý Phim");
			}
		});
		lblPhim.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblPhim);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblPhim);
			}
		});
		GridData gd_lblPhim = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_lblPhim.widthHint = 100;
		lblPhim.setLayoutData(gd_lblPhim);
		lblPhim.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblPhim.setText("Phim");

		lblSuatChieu = new CLabel(this, SWT.NONE);
		lblSuatChieu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblSuatChieu);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblSuatChieu);
				Window.openPageInTab(controlled, new pageSuatChieu(controlled, SWT.NONE), "Quản lý Suất chiếu");
			}
		});
		lblSuatChieu.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblSuatChieu);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblSuatChieu);
			}
		});
		lblSuatChieu.setImage(SWTResourceManager.getImage(toolDanhMuc.class, "/rcp/view/control/imgSuatChieu_32p.png"));
		GridData gd_lblSuatChieu = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_lblSuatChieu.widthHint = 100;
		lblSuatChieu.setLayoutData(gd_lblSuatChieu);
		lblSuatChieu.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblSuatChieu.setText("Suất chiếu");

		lblThucAn = new CLabel(this, SWT.NONE);
		lblThucAn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblThucAn);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblThucAn);
				Window.openPageInTab(controlled, new pageThucAn(controlled, SWT.NONE), "Quản lý Thức ăn");
			}
		});
		lblThucAn.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblThucAn);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblThucAn);
			}
		});
		lblThucAn.setImage(SWTResourceManager.getImage(toolDanhMuc.class, "/rcp/view/control/imgThucAn_32p.png"));
		GridData gd_lblThucAn = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_lblThucAn.widthHint = 100;
		lblThucAn.setLayoutData(gd_lblThucAn);
		lblThucAn.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblThucAn.setText("Thức ăn");

		lblNhanVien = new CLabel(this, SWT.NONE);
		lblNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblNhanVien);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblNhanVien);
				Window.openPageInTab(controlled, new pageNhanVien(controlled, SWT.NONE), "Quản lý Nhân viên");
			}
		});
		lblNhanVien.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblNhanVien);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblNhanVien);
			}
		});
		lblNhanVien.setImage(SWTResourceManager.getImage(toolDanhMuc.class, "/rcp/view/control/imgNhanVien_32p.png"));
		GridData gd_lblNhanVien = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_lblNhanVien.widthHint = 100;
		lblNhanVien.setLayoutData(gd_lblNhanVien);
		lblNhanVien.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblNhanVien.setText("Nhân viên");

		lblKhachHang = new CLabel(this, SWT.NONE);
		lblKhachHang.setImage(SWTResourceManager.getImage(toolDanhMuc.class, "/rcp/view/control/imgKhachHang_32p.png"));
		lblKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblKhachHang);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblKhachHang);
				Window.openPageInTab(controlled, new pageKhachHang(controlled, SWT.NONE), "Quản lý Khách hàng");
			}
		});
		lblKhachHang.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblKhachHang);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblKhachHang);
			}
		});
		GridData gd_lblKhachHang = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_lblKhachHang.widthHint = 120;
		lblKhachHang.setLayoutData(gd_lblKhachHang);
		lblKhachHang.setText("Khách hàng");
		lblKhachHang.setBackground(SWTResourceManager.getColor(240, 240, 240));

		lblHoaDon = new CLabel(this, SWT.NONE);
		lblHoaDon.setImage(SWTResourceManager.getImage(toolDanhMuc.class, "/rcp/view/control/imgHoaDon_32p.png"));
		lblHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblHoaDon);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblHoaDon);
				Window.openPageInTab(controlled, new pageHoaDon(controlled, SWT.NONE), "Hóa đơn thức ăn");
			}
		});
		lblHoaDon.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblHoaDon);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblHoaDon);
			}
		});
		GridData gd_lblHoaDon = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_lblHoaDon.widthHint = 100;
		lblHoaDon.setLayoutData(gd_lblHoaDon);
		lblHoaDon.setText("Hóa đơn");
		lblHoaDon.setBackground(SWTResourceManager.getColor(240, 240, 240));

		lblV = new CLabel(this, SWT.NONE);
		lblV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblV);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblV);
				Window.openPageInTab(controlled, new pageVe(controlled, SWT.NONE), "Tra cứu vé");
			}
		});
		lblV.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblV);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblV);
			}
		});
		GridData gd_lblV = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_lblV.widthHint = 80;
		lblV.setLayoutData(gd_lblV);
		lblV.setText("Vé");
		lblV.setImage(SWTResourceManager.getImage(toolDanhMuc.class, "/rcp/view/control/imgVe_32p.png"));
		lblV.setBackground(SWTResourceManager.getColor(240, 240, 240));


		phanQuyen();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void mouseEnterColor(CLabel item) {
		item.setBackground(SWTResourceManager.getColor(220, 220, 220));
	}

	public void mouseExitColor(CLabel item) {
		item.setBackground(SWTResourceManager.getColor(240, 240, 240));
	}

	public void mouseDownColor(CLabel item) {
		item.setBackground(SWTResourceManager.getColor(200, 200, 200));
	}
	
	
	public void phanQuyen() {
		try {
			QuyenHan q = QuyenHanController.layThongTin(Settings.currentRightId);

			GridData gd_lblPhim = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
			gd_lblPhim.widthHint = 100;
			gd_lblPhim.exclude=!q.isQuanLyPhim();
			lblPhim.setLayoutData(gd_lblPhim);
			
			GridData gd_lblSuatChieu = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
			gd_lblSuatChieu.widthHint = 100;
			gd_lblSuatChieu.exclude = !q.isQuanLySuatChieu();
			lblSuatChieu.setLayoutData(gd_lblSuatChieu);
	
			GridData gd_lblThucAn = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
			gd_lblThucAn.widthHint = 100;
			gd_lblThucAn.exclude = !q.isQuanLyThucAn();
			lblThucAn.setLayoutData(gd_lblThucAn);
		
			GridData gd_lblNhanVien = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
			gd_lblNhanVien.widthHint = 100;
			gd_lblNhanVien.exclude = !q.isQuanLyNhanVien();
			lblNhanVien.setLayoutData(gd_lblNhanVien);
			
			GridData gd_lblKhachHang = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
			gd_lblKhachHang.widthHint = 120;
			gd_lblKhachHang.exclude = !q.isQuanLyKhachHang();
			lblKhachHang.setLayoutData(gd_lblKhachHang);
			
			GridData gd_lblHoaDon = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
			gd_lblHoaDon.widthHint = 100;
			gd_lblHoaDon.exclude = !q.isQuanLyThucAn();
			lblHoaDon.setLayoutData(gd_lblHoaDon);
			
			GridData gd_lblV = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
			gd_lblV.widthHint = 80;
			gd_lblV.exclude = !q.isTraCuuVe();
			lblV.setLayoutData(gd_lblV);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
