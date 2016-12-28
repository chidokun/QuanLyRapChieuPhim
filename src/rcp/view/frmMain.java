/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view;

import java.io.IOException;
import java.sql.SQLException;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;

import rcp.Settings;
import rcp.controller.NhanVienController;
import rcp.controller.QuyenHanController;
import rcp.entity.QuyenHan;
import rcp.util.Window;
import rcp.view.control.*;
import rcp.view.popup.frmDangNhap;
import rcp.view.popup.frmThongTinNhanVien;

import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseTrackAdapter;

public class frmMain extends Shell {
	private CLabel lblDanhMuc;
	private CLabel lblNghiepVu;
	private CLabel lblHeThong;
	private Composite toolToolbar;
	private CTabFolder tabFolder;
	private CTabItem tabItem;
	private Composite composite;
	private Composite toolHeader;
	private CLabel lblUserName;
	private CLabel lblDangXuat;

	private Color tabBackground = SWTResourceManager
			.getColor(Window.color((int) Settings.get("theme_ribbonTabBackground")));
	private Color tabHeaderInactive = SWTResourceManager
			.getColor(Window.color((int) Settings.get("theme_ribbonTabHeaderInactive")));
	private Color tabActive = SWTResourceManager.getColor(Window.color((int) Settings.get("theme_ribbonTabActive")));
	private Color tabHeaderActive = SWTResourceManager
			.getColor(Window.color((int) Settings.get("theme_ribbonTabHeaderActive")));
	private Color buttonText = SWTResourceManager.getColor(Window.color((int) Settings.get("theme_ribbonButtonText")));
	private Color buttonHover = SWTResourceManager
			.getColor(Window.color((int) Settings.get("theme_ribbonButtonHoverBackground")));
	private Color buttonClick = SWTResourceManager
			.getColor(Window.color((int) Settings.get("theme_ribbonButtonClickBackground")));

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmMain(Display display) {
		super(display, SWT.SHELL_TRIM | SWT.BORDER);
		setSize(1038, 604);
		setText("Quản lý Rạp chiếu phim");
		setMinimumSize(new Point(136, 50));
		setBackground(SWTResourceManager.getColor(230, 230, 230));
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);

		Composite ribbon = new Composite(this, SWT.NONE);
		ribbon.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_ribbon = new GridLayout(1, false);
		gl_ribbon.verticalSpacing = 0;
		gl_ribbon.marginWidth = 0;
		gl_ribbon.marginHeight = 0;
		gl_ribbon.horizontalSpacing = 0;
		ribbon.setLayout(gl_ribbon);
		GridData gd_ribbon = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_ribbon.heightHint = 97;
		ribbon.setLayoutData(gd_ribbon);

		toolHeader = new Composite(ribbon, SWT.NONE);
		GridLayout gl_toolHeader = new GridLayout(5, false);
		gl_toolHeader.verticalSpacing = 0;
		gl_toolHeader.marginWidth = 0;
		gl_toolHeader.marginHeight = 0;
		gl_toolHeader.horizontalSpacing = 0;
		toolHeader.setLayout(gl_toolHeader);
		GridData gd_toolHeader = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_toolHeader.heightHint = 32;
		toolHeader.setLayoutData(gd_toolHeader);
		toolHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		lblDanhMuc = new CLabel(toolHeader, SWT.NONE);
		lblDanhMuc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				selectButton(lblDanhMuc);
				openToolbar(new toolDanhMuc(toolToolbar, SWT.NONE, tabFolder));
			}
		});
		lblDanhMuc.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblDanhMuc.setAlignment(SWT.CENTER);
		GridData gd_lblDanhMuc = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_lblDanhMuc.widthHint = 90;
		lblDanhMuc.setLayoutData(gd_lblDanhMuc);
		lblDanhMuc.setBackground(SWTResourceManager.getColor(240, 240, 240));
		lblDanhMuc.setText("Danh mục");

		lblNghiepVu = new CLabel(toolHeader, SWT.NONE);
		lblNghiepVu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				selectButton(lblNghiepVu);
				openToolbar(new toolNghiepVu(toolToolbar, SWT.NONE, tabFolder));
			}
		});
		lblNghiepVu.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNghiepVu.setAlignment(SWT.CENTER);
		GridData gd_lblNghiepVu = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_lblNghiepVu.widthHint = 90;
		lblNghiepVu.setLayoutData(gd_lblNghiepVu);
		lblNghiepVu.setText("Nghiệp vụ");
		lblNghiepVu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		lblHeThong = new CLabel(toolHeader, SWT.NONE);
		lblHeThong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				selectButton(lblHeThong);
				openToolbar(new toolHeThong(toolToolbar, SWT.NONE, tabFolder));
			}
		});
		lblHeThong.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblHeThong.setAlignment(SWT.CENTER);
		GridData gd_lblHeThong = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_lblHeThong.widthHint = 90;
		lblHeThong.setLayoutData(gd_lblHeThong);
		lblHeThong.setText("Hệ thống");
		lblHeThong.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		lblUserName = new CLabel(toolHeader, SWT.NONE);
		lblUserName.setRightMargin(7);
		lblUserName.setLeftMargin(7);
		lblUserName.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblUserName.setBackground(buttonHover);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblUserName.setBackground(tabBackground);
			}
		});
		lblUserName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lblUserName.setBackground(buttonClick);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				lblUserName.setBackground(buttonHover);
				try {
					Window.open(new frmThongTinNhanVien(getDisplay(), NhanVienController.layThongTin(Settings.currentEmpId)));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblUserName.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblUserName.setAlignment(SWT.CENTER);
		lblUserName.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, true, 1, 1));
		lblUserName.setText("<user name>");
		lblUserName.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		lblDangXuat = new CLabel(toolHeader, SWT.NONE);
		lblDangXuat.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblDangXuat.setBackground(buttonHover);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				lblDangXuat.setBackground(tabBackground);
			}
		});
		lblDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lblDangXuat.setBackground(buttonClick);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				try {
					lblDangXuat.setBackground(buttonHover);
					getShell().setVisible(false);

					Window.open(new frmDangNhap(getDisplay()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblDangXuat.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblDangXuat.setAlignment(SWT.CENTER);
		GridData gd_lblDangXuat = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_lblDangXuat.widthHint = 80;
		lblDangXuat.setLayoutData(gd_lblDangXuat);
		lblDangXuat.setText("Đăng xuất");
		lblDangXuat.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		toolToolbar = new Composite(ribbon, SWT.NONE);
		GridLayout gl_toolToolbar = new GridLayout(1, false);
		gl_toolToolbar.marginBottom = 5;
		gl_toolToolbar.verticalSpacing = 0;
		gl_toolToolbar.marginWidth = 0;
		gl_toolToolbar.marginHeight = 0;
		gl_toolToolbar.horizontalSpacing = 0;
		toolToolbar.setLayout(gl_toolToolbar);
		GridData gd_toolToolbar = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_toolToolbar.heightHint = 72;
		toolToolbar.setLayoutData(gd_toolToolbar);
		toolToolbar.setBackground(SWTResourceManager.getColor(220, 220, 220));

		tabFolder = new CTabFolder(this, SWT.CLOSE | SWT.FLAT);
		tabFolder.setSelectionBackground(SWTResourceManager.getColor(241, 241, 241));
		tabFolder.setTabHeight(26);
		tabFolder.setBackground(SWTResourceManager.getColor(230, 230, 230));
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		tabItem = new CTabItem(tabFolder, SWT.NONE);
		tabItem.setText("Chào mừng");

		composite = new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(composite);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private void selectButton(CLabel selected) {
		lblDanhMuc.setBackground(tabBackground);
		lblDanhMuc.setForeground(tabHeaderInactive);
		lblNghiepVu.setBackground(tabBackground);
		lblNghiepVu.setForeground(tabHeaderInactive);
		lblHeThong.setBackground(tabBackground);
		lblHeThong.setForeground(tabHeaderInactive);

		selected.setBackground(tabActive);
		selected.setForeground(tabHeaderActive);

		for (Control i : toolToolbar.getChildren()) {
			i.dispose();
		}
	}

	private void openToolbar(Composite tool) {
		tool.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolToolbar.layout();
	}

	private void loadTheme() {
		toolHeader.setBackground(tabBackground);
		lblUserName.setBackground(tabBackground);
		lblDangXuat.setBackground(tabBackground);
		lblUserName.setForeground(buttonText);
		lblDangXuat.setForeground(buttonText);
	}

	public void resetQuyen() {
		((GridData)lblDanhMuc.getLayoutData()).exclude = false;
		((GridData)lblNghiepVu.getLayoutData()).exclude = false;
	}
	
	public void hienThiGiaoDien() throws SQLException {
		loadTheme();
		lblUserName.setText(Settings.currentUser);
		setMaximized(true);

		resetQuyen();
		QuyenHan q = QuyenHanController.layThongTin(Settings.currentRightId);
		switch (q.getMaQuyen()) {
		case "Q04":
			((GridData)lblDanhMuc.getLayoutData()).exclude = true;
			selectButton(lblNghiepVu);
			openToolbar(new toolNghiepVu(toolToolbar, SWT.NONE, tabFolder));
			return;
		case "Q02":
			((GridData)lblNghiepVu.getLayoutData()).exclude = true;			
			break;
		default:
			break;
		}
		
		selectButton(lblDanhMuc);
		openToolbar(new toolDanhMuc(toolToolbar, SWT.NONE, tabFolder));
	}
}
