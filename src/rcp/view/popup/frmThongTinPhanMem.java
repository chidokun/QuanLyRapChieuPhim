/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.popup;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;

public class frmThongTinPhanMem extends Shell {

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmThongTinPhanMem(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(107, 57, 201, 15);
		lblNewLabel.setText("Một sản phẩm của nhóm Ricepaper");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Phần mềm Quản lý Rạp chiếu phim");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(107, 28, 288, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(SWTResourceManager.getImage(frmThongTinPhanMem.class, "/rcp/view/popup/imgRapPhim_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 447, 460, 56);
		
		Button btnHyB = new Button(composite, SWT.NONE);
		btnHyB.setImage(SWTResourceManager.getImage(frmThongTinPhanMem.class, "/rcp/view/popup/yes_16x16.png"));
		btnHyB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHyB.setText("Đóng");
		btnHyB.setBounds(356, 10, 94, 33);
		
		Group grpThngTinPhn = new Group(this, SWT.NONE);
		grpThngTinPhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpThngTinPhn.setText("Thông tin phần mềm");
		grpThngTinPhn.setBounds(41, 104, 380, 116);
		
		Label lblTnPhnMm = new Label(grpThngTinPhn, SWT.NONE);
		lblTnPhnMm.setText("Tên phần mềm:");
		lblTnPhnMm.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnPhnMm.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnPhnMm.setBounds(23, 28, 95, 15);
		
		Label lblPhinBn = new Label(grpThngTinPhn, SWT.NONE);
		lblPhinBn.setText("Phiên bản:");
		lblPhinBn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblPhinBn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPhinBn.setBounds(23, 54, 95, 15);
		
		Label lblBnQuyn = new Label(grpThngTinPhn, SWT.NONE);
		lblBnQuyn.setText("Bản quyền:");
		lblBnQuyn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblBnQuyn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblBnQuyn.setBounds(23, 82, 95, 15);
		
		Label lblPhnMmQun = new Label(grpThngTinPhn, SWT.NONE);
		lblPhnMmQun.setText("Phần mềm Quản lý Rạp chiếu phim");
		lblPhnMmQun.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblPhnMmQun.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPhnMmQun.setBounds(124, 28, 232, 15);
		
		Label label = new Label(grpThngTinPhn, SWT.NONE);
		label.setText("1.0.0.0");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(124, 54, 253, 15);
		
		Label lblRicpaper = new Label(grpThngTinPhn, SWT.NONE);
		lblRicpaper.setText("© 2016, Ricpaper");
		lblRicpaper.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblRicpaper.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblRicpaper.setBounds(124, 82, 253, 15);
		
		Group grpThngTinNhm = new Group(this, SWT.NONE);
		grpThngTinNhm.setText("Thông tin nhóm phát triển");
		grpThngTinNhm.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpThngTinNhm.setBounds(41, 233, 380, 186);
		
		Label lblTnNhmRicepaper = new Label(grpThngTinNhm, SWT.NONE);
		lblTnNhmRicepaper.setText("Tên nhóm:");
		lblTnNhmRicepaper.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnNhmRicepaper.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnNhmRicepaper.setBounds(23, 28, 95, 15);
		
		Label lblThngTinThnh = new Label(grpThngTinNhm, SWT.NONE);
		lblThngTinThnh.setText("Thông tin thành viên:");
		lblThngTinThnh.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblThngTinThnh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThngTinThnh.setBounds(23, 54, 130, 15);
		
		Label lblRicepaper = new Label(grpThngTinNhm, SWT.NONE);
		lblRicepaper.setText("Ricepaper");
		lblRicepaper.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblRicepaper.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblRicepaper.setBounds(124, 28, 232, 15);
		
		Label lblH = new Label(grpThngTinNhm, SWT.NONE);
		lblH.setText("14520308 - Hồ Thị Kim Hoàng (Leader)");
		lblH.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblH.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblH.setBounds(55, 75, 253, 15);
		
		Label lblHunh = new Label(grpThngTinNhm, SWT.NONE);
		lblHunh.setText("14520967 - Huỳnh Duy Anh Toàn");
		lblHunh.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblHunh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHunh.setBounds(55, 101, 253, 15);
		
		Label lblNguyn = new Label(grpThngTinNhm, SWT.NONE);
		lblNguyn.setText("14521047 - Nguyễn Lê Hoàng Tuấn");
		lblNguyn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNguyn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNguyn.setBounds(55, 127, 253, 15);
		
		Label lblV = new Label(grpThngTinNhm, SWT.NONE);
		lblV.setText("14521110 - Võ Xuân Vương");
		lblV.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblV.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblV.setBounds(55, 153, 253, 15);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Thông tin phần mềm");
		setSize(466, 532);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
