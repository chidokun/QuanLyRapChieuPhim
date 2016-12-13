package rcp.view.control;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;

import rcp.util.Window;
import rcp.view.page.*;

public class toolNghiepVu extends Composite {
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
		GridLayout gridLayout = new GridLayout(3, false);
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

		CLabel lblBaoCaoThongKe = new CLabel(this, SWT.NONE);
		lblBaoCaoThongKe.setImage(SWTResourceManager.getImage(toolNghiepVu.class, "/rcp/view/control/imgBaoCao_32p.png"));
		lblBaoCaoThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblBaoCaoThongKe);
			}

			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblBaoCaoThongKe);
				Window.openPageInTab(controlled, new pageBaoCao(controlled, SWT.NONE), "Báo cáo thống kê");
			}
		});
		lblBaoCaoThongKe.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblBaoCaoThongKe);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblBaoCaoThongKe);
			}
		});
		GridData gd_lblBaoCaoThongKe = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblBaoCaoThongKe.widthHint = 150;
		lblBaoCaoThongKe.setLayoutData(gd_lblBaoCaoThongKe);
		lblBaoCaoThongKe.setText("Báo cáo thống kê");
		lblBaoCaoThongKe.setBackground(SWTResourceManager.getColor(240, 240, 240));

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