/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;
import rcp.view.control.*;
import org.eclipse.swt.custom.CTabItem;


public class frmMain extends Shell {
	private CLabel lblDanhMuc;
	private CLabel lblNghiepVu;
	private CLabel lblHeThong;
	private Composite toolToolbar;
	private CTabFolder tabFolder;
	private CTabItem tabItem;
	private Composite composite;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmMain(Display display) {
		super(display, SWT.SHELL_TRIM | SWT.BORDER);
		setSize(1038, 604);
		setText("Quản lý Rạp chiếu phim");
		setMinimumSize(new Point(136, 50));
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.verticalSpacing = 10;
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
		
		Composite toolHeader = new Composite(ribbon, SWT.NONE);
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
			public void mouseUp(MouseEvent e) {
				selectButton(lblDanhMuc);
				openToolbar(new toolDanhMuc(toolToolbar, SWT.NONE, tabFolder));
			}
		});
		lblDanhMuc.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblDanhMuc.setAlignment(SWT.CENTER);
		GridData gd_lblDanhMuc = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_lblDanhMuc.widthHint = 90;
		lblDanhMuc.setLayoutData(gd_lblDanhMuc);
		lblDanhMuc.setBackground(SWTResourceManager.getColor(240,240,240));
		lblDanhMuc.setText("Danh mục");
		
		lblNghiepVu = new CLabel(toolHeader, SWT.NONE);
		lblNghiepVu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
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
			public void mouseUp(MouseEvent e) {
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
		
		CLabel label_2 = new CLabel(toolHeader, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_2.setAlignment(SWT.CENTER);
		GridData gd_label_2 = new GridData(SWT.RIGHT, SWT.FILL, true, true, 1, 1);
		gd_label_2.widthHint = 90;
		label_2.setLayoutData(gd_label_2);
		label_2.setText("<user name>");
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		CLabel lblngXut = new CLabel(toolHeader, SWT.NONE);
		lblngXut.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblngXut.setAlignment(SWT.CENTER);
		GridData gd_lblngXut = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_lblngXut.widthHint = 80;
		lblngXut.setLayoutData(gd_lblngXut);
		lblngXut.setText("Đăng xuất");
		lblngXut.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		toolToolbar = new Composite(ribbon, SWT.NONE);
		GridLayout gl_toolToolbar = new GridLayout(1, false);
		gl_toolToolbar.verticalSpacing = 0;
		gl_toolToolbar.marginWidth = 0;
		gl_toolToolbar.marginHeight = 0;
		gl_toolToolbar.horizontalSpacing = 0;
		toolToolbar.setLayout(gl_toolToolbar);
		GridData gd_toolToolbar = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_toolToolbar.heightHint = 72;
		toolToolbar.setLayoutData(gd_toolToolbar);
		toolToolbar.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		tabFolder = new CTabFolder(this, SWT.CLOSE | SWT.FLAT);
		tabFolder.setBorderVisible(true);
		tabFolder.setSelectionBackground(SWTResourceManager.getColor(227, 227, 227));
		tabFolder.setTabHeight(26);
		tabFolder.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		
		tabItem = new CTabItem(tabFolder, SWT.NONE);
		tabItem.setText("Chào mừng");
		
		composite = new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(composite);
		

		
		setMaximized(true);
		
		selectButton(lblDanhMuc);
		openToolbar(new toolDanhMuc(toolToolbar, SWT.NONE, tabFolder));
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Quản lý Rạp chiếu phim");
		setSize(667, 398);
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void selectButton(CLabel selected) {
		lblDanhMuc.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNghiepVu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHeThong.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		selected.setBackground(SWTResourceManager.getColor(240,240,240));
		
		for(Control i : toolToolbar.getChildren()) {
			i.dispose();
		}
	}
	
	private void openToolbar(Composite tool) {
		tool.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolToolbar.layout();	
	}
	
	private void loadTheme()
	{
		
	}
}
