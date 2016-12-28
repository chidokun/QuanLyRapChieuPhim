/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.control;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.Settings;
import rcp.controller.QuyenHanController;
import rcp.entity.QuyenHan;
import rcp.util.Window;
import rcp.view.page.pageTaiKhoan;
import rcp.view.popup.frmKetNoiCSDL;
import rcp.view.popup.frmQuyDinh;
import rcp.view.popup.frmSaoLuuPhucHoi;
import rcp.view.popup.frmThongTinPhanMem;
import rcp.view.popup.frmThongTinRapPhim;

public class toolHeThong extends Composite {
	@SuppressWarnings("unused")
	private CTabFolder controlled;
	private CLabel lblSaoLuuPhucHoi;
	private CLabel lblKtNiCsdl;
	private CLabel lblTaiKhoan;
	private CLabel lblQuyDinh;
	private CLabel lblThongTinRapPhim;
	private CLabel lblThongTinPhanMem;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public toolHeThong(Composite parent, int style, CTabFolder controlled) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(240, 240, 240));
		GridLayout gridLayout = new GridLayout(6, false);
		gridLayout.marginHeight = 7;
		gridLayout.marginWidth = 7;
		setLayout(gridLayout);

		this.controlled = controlled;

		lblSaoLuuPhucHoi = new CLabel(this, SWT.NONE);
		lblSaoLuuPhucHoi.setImage(SWTResourceManager.getImage(toolHeThong.class, "/rcp/view/control/imgSaoLuuPhucHoi_32p.png"));
		lblSaoLuuPhucHoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblSaoLuuPhucHoi);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblSaoLuuPhucHoi);
				Window.open(new frmSaoLuuPhucHoi(getDisplay()));				
			}
		});
		lblSaoLuuPhucHoi.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblSaoLuuPhucHoi);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblSaoLuuPhucHoi);
			}
		});
		GridData gd_lblSaoLuuPhucHoi = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_lblSaoLuuPhucHoi.widthHint = 140;
		lblSaoLuuPhucHoi.setLayoutData(gd_lblSaoLuuPhucHoi);
		lblSaoLuuPhucHoi.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblSaoLuuPhucHoi.setText("Sao lưu phục hồi");
		
		lblKtNiCsdl = new CLabel(this, SWT.NONE);
		lblKtNiCsdl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblKtNiCsdl);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblKtNiCsdl);
				Window.open(new frmKetNoiCSDL(getDisplay()));
				
			}
		});
		lblKtNiCsdl.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblKtNiCsdl);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblKtNiCsdl);
			}
		});
		GridData gd_lblKtNiCsdl = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_lblKtNiCsdl.widthHint = 120;
		lblKtNiCsdl.setLayoutData(gd_lblKtNiCsdl);
		lblKtNiCsdl.setText("Kết nối CSDL");
		lblKtNiCsdl.setImage(SWTResourceManager.getImage(toolHeThong.class, "/rcp/view/control/imgketNoiCSDL_32p.png"));
		lblKtNiCsdl.setBackground(SWTResourceManager.getColor(240, 240, 240));

		lblTaiKhoan = new CLabel(this, SWT.NONE);
		lblTaiKhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblTaiKhoan);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblTaiKhoan);
				Window.openPageInTab(controlled, new pageTaiKhoan(controlled, SWT.NONE), "Quản lý Tài khoản");
				
			}
		});
		lblTaiKhoan.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblTaiKhoan);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblTaiKhoan);
			}
		});
		lblTaiKhoan.setImage(SWTResourceManager.getImage(toolHeThong.class, "/rcp/view/control/imgTaiKhoan_32p.png"));
		GridData gd_lblTaiKhoan = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblTaiKhoan.widthHint = 110;
		lblTaiKhoan.setLayoutData(gd_lblTaiKhoan);
		lblTaiKhoan.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblTaiKhoan.setText("Tài khoản");

		lblQuyDinh = new CLabel(this, SWT.NONE);
		lblQuyDinh.setImage(SWTResourceManager.getImage(toolHeThong.class, "/rcp/view/control/imgQuyDinh_32p.png"));
		lblQuyDinh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblQuyDinh);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblQuyDinh);
				Window.open(new frmQuyDinh(getDisplay()));
			}
		});
		lblQuyDinh.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblQuyDinh);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblQuyDinh);
			}
		});
		GridData gd_lblQuyDinh = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblQuyDinh.widthHint = 100;
		lblQuyDinh.setLayoutData(gd_lblQuyDinh);
		lblQuyDinh.setText("Quy định");
		lblQuyDinh.setBackground(SWTResourceManager.getColor(240, 240, 240));
		
		lblThongTinRapPhim = new CLabel(this, SWT.NONE);
		lblThongTinRapPhim.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblThongTinRapPhim);
			}
			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblThongTinRapPhim);
			}
		});
		lblThongTinRapPhim.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		lblThongTinRapPhim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblThongTinRapPhim);
			}
			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblThongTinRapPhim);
				Window.open(new frmThongTinRapPhim(getDisplay()));
			}
		});
		lblThongTinRapPhim.setText("Thông tin rạp phim");
		lblThongTinRapPhim.setImage(SWTResourceManager.getImage(toolHeThong.class, "/rcp/view/control/imgRapPhim_32p.png"));
		lblThongTinRapPhim.setBackground(SWTResourceManager.getColor(240, 240, 240));
		
		lblThongTinPhanMem = new CLabel(this, SWT.NONE);
		lblThongTinPhanMem.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblThongTinPhanMem);
			}
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblThongTinPhanMem);
			}
		});
		lblThongTinPhanMem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblThongTinPhanMem);
			}
			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblThongTinPhanMem);
				Window.open(new frmThongTinPhanMem(getDisplay()));
			}
		});
		lblThongTinPhanMem.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		lblThongTinPhanMem.setText("Thông tin phần mềm");
		lblThongTinPhanMem.setImage(SWTResourceManager.getImage(toolHeThong.class, "/rcp/view/control/imgThongTin_32p.png"));
		lblThongTinPhanMem.setBackground(SWTResourceManager.getColor(240, 240, 240));
	

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

			GridData gd_lblSaoLuuPhucHoi = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
			gd_lblSaoLuuPhucHoi.widthHint = 140;
			gd_lblSaoLuuPhucHoi.exclude = !q.isSaoLuuPhucHoi();
			lblSaoLuuPhucHoi.setLayoutData(gd_lblSaoLuuPhucHoi);
			
			GridData gd_lblTaiKhoan = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
			gd_lblTaiKhoan.widthHint = 110;
			gd_lblTaiKhoan.exclude = !q.isThayDoiQuyDinh();
			lblTaiKhoan.setLayoutData(gd_lblTaiKhoan);
	
			GridData gd_lblQuyDinh = new GridData(SWT.FILL, SWT.FILL, false,true, 1, 1);
			gd_lblQuyDinh.widthHint = 100;
			gd_lblQuyDinh.exclude = !q.isThayDoiQuyDinh();
			lblQuyDinh.setLayoutData(gd_lblQuyDinh);
			
			GridData gd_lblThongTinRapPhim = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
			gd_lblThongTinRapPhim.exclude = !q.isThayDoiQuyDinh();
			lblThongTinRapPhim.setLayoutData(gd_lblThongTinRapPhim);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

