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
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;

import rcp.util.Window;
import rcp.view.page.*;

public class toolNghiepVu extends Composite {
	@SuppressWarnings("unused")
	private CTabFolder controlled;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public toolNghiepVu(Composite parent, int style, CTabFolder controlled) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(240, 240, 240));
		GridLayout gridLayout = new GridLayout(5, false);
		gridLayout.marginHeight = 7;
		gridLayout.marginWidth = 7;
		setLayout(gridLayout);

		this.controlled = controlled;

		CLabel lblBanVe = new CLabel(this, SWT.NONE);
		lblBanVe.setImage(SWTResourceManager.getImage(toolNghiepVu.class, "/rcp/view/control/imgVe_32p.png"));
		lblBanVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblBanVe);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblBanVe);
				Window.openPageInTab(controlled, new pageBanVe(controlled, SWT.NONE), "Bán vé");
			}
		});
		lblBanVe.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblBanVe);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblBanVe);
			}
		});
		GridData gd_lblBanVe = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_lblBanVe.widthHint = 100;
		lblBanVe.setLayoutData(gd_lblBanVe);
		lblBanVe.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblBanVe.setText("Bán vé");

		CLabel lblBanThucAn = new CLabel(this, SWT.NONE);
		lblBanThucAn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblBanThucAn);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblBanThucAn);
				Window.openPageInTab(controlled, new pageBanThucAn(controlled, SWT.NONE), "Bán thức ăn");
			}
		});
		lblBanThucAn.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblBanThucAn);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblBanThucAn);
			}
		});
		lblBanThucAn.setImage(SWTResourceManager.getImage(toolNghiepVu.class, "/rcp/view/control/imgThucAn_32p.png"));
		GridData gd_lblBanThucAn = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblBanThucAn.widthHint = 110;
		lblBanThucAn.setLayoutData(gd_lblBanThucAn);
		lblBanThucAn.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblBanThucAn.setText("Bán thức ăn");

		CLabel lblBCPhimTG = new CLabel(this, SWT.WRAP | SWT.CENTER);
		lblBCPhimTG.setImage(SWTResourceManager.getImage(toolNghiepVu.class, "/rcp/view/control/imgBaoCaoPhim_32p.png"));
		lblBCPhimTG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblBCPhimTG);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblBCPhimTG);
				Window.openPageInTab(controlled, new pageBaoCaoDoanhThuPhimKhoangThoiGian(controlled, SWT.NONE), "Doanh thu phim theo khoảng thời gian");
			}
		});
		lblBCPhimTG.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblBCPhimTG);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblBCPhimTG);
			}
		});
		GridData gd_lblBCPhimTG = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblBCPhimTG.widthHint = 197;
		lblBCPhimTG.setLayoutData(gd_lblBCPhimTG);
		lblBCPhimTG.setText("Báo cáo doanh thu phim\r\ntheo khoảng thời gian");
		lblBCPhimTG.setBackground(SWTResourceManager.getColor(240, 240, 240));
		
		
		CLabel lblBCKhachHang = new CLabel(this, SWT.WRAP | SWT.CENTER);
		GridData gd_lblBCKhachHang = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblBCKhachHang.widthHint = 168;
		lblBCKhachHang.setLayoutData(gd_lblBCKhachHang);
		lblBCKhachHang.setText("Báo cáo doanh thu\r\nkhách hàng");
		lblBCKhachHang.setImage(SWTResourceManager.getImage(toolNghiepVu.class, "/rcp/view/control/imgBaoCaoKhachHang_32p.png"));
		lblBCKhachHang.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblBCKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblBCKhachHang);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblBCKhachHang);
				Window.openPageInTab(controlled, new pageBaoCaoDoanhThuKhachHang(controlled, SWT.NONE), "Doanh thu theo khách hàng");
			}
		});
		lblBCKhachHang.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblBCKhachHang);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblBCKhachHang);
			}
		});
		
		CLabel lblBCThucAn = new CLabel(this, SWT.NONE);
		GridData gd_lblBCThucAn = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblBCThucAn.widthHint = 165;
		lblBCThucAn.setLayoutData(gd_lblBCThucAn);
		lblBCThucAn.setText("Báo cáo doanh thu\r\nthức ăn hàng tháng");
		lblBCThucAn.setImage(SWTResourceManager.getImage(toolNghiepVu.class, "/rcp/view/control/imgBaoCaoThucAn_32p.png"));
		lblBCThucAn.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblBCThucAn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblBCThucAn);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblBCThucAn);
				Window.openPageInTab(controlled, new pageBaoCaoDoanhThuThucAn(controlled, SWT.NONE), "Doanh thu thức ăn");
			}
		});
		lblBCThucAn.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblBCThucAn);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblBCThucAn);
			}
		});

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
}
