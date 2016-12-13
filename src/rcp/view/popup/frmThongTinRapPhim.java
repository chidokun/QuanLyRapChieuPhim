/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.popup;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.fieldassist.ControlDecoration;

public class frmThongTinRapPhim extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmThongTinRapPhim(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Chỉnh sửa thông tin rạp phim");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 245, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(SWTResourceManager.getImage(frmThongTinRapPhim.class, "/rcp/view/popup/imgRapPhim_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Label lblMThcn = new Label(this, SWT.NONE);
		lblMThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMThcn.setText("Tên rạp phim:");
		lblMThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMThcn.setBounds(39, 103, 75, 15);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(130, 100, 241, 24);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 287, 409, 56);
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setText("Lưu");
		btnLu.setBounds(205, 10, 94, 33);
		
		Button btnHyB = new Button(composite, SWT.NONE);
		btnHyB.setText("Hủy bỏ");
		btnHyB.setBounds(305, 10, 94, 33);
		
		Label lblaCh = new Label(this, SWT.NONE);
		lblaCh.setText("Địa chỉ:");
		lblaCh.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblaCh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblaCh.setBounds(39, 145, 75, 15);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(130, 142, 241, 24);
		
		Label lblSinThoi = new Label(this, SWT.NONE);
		lblSinThoi.setText("Số điện thoại:");
		lblSinThoi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblSinThoi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSinThoi.setBounds(39, 188, 75, 15);
		
		text_2 = new Text(this, SWT.BORDER);
		text_2.setBounds(130, 185, 241, 24);
		
		Label lblEmailHTr = new Label(this, SWT.NONE);
		lblEmailHTr.setText("Email hỗ trợ:");
		lblEmailHTr.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblEmailHTr.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblEmailHTr.setBounds(39, 233, 75, 15);
		
		text_3 = new Text(this, SWT.BORDER);
		text_3.setBounds(130, 230, 241, 24);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Chỉnh sửa thông tin rạp phim");
		setSize(415, 372);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
