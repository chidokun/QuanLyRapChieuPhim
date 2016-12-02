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
import org.eclipse.swt.widgets.Group;

public class frmSaoLuuPhucHoi extends Shell {
	private Text text_1;
	private Text text;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmSaoLuuPhucHoi(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 251, 15);
		lblNewLabel.setText("Chọn vị trí để sao lưu hoặc file để phục hồi");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Sao lưu và phục hồi");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 176, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/imgSaoLuuPhucHoi_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 372, 510, 56);
		
		Button btnHyB = new Button(composite, SWT.NONE);
		btnHyB.setText("Đóng");
		btnHyB.setBounds(408, 10, 94, 33);
		
		Group grpSaoLu = new Group(this, SWT.NONE);
		grpSaoLu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpSaoLu.setText("Sao lưu");
		grpSaoLu.setBounds(30, 101, 452, 122);
		
		Label lblTnThcn = new Label(grpSaoLu, SWT.NONE);
		lblTnThcn.setBounds(30, 25, 75, 15);
		lblTnThcn.setText("Vị trí sao lưu:");
		lblTnThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		text_1 = new Text(grpSaoLu, SWT.BORDER);
		text_1.setBounds(31, 46, 307, 24);
		
		Button btnDuyt = new Button(grpSaoLu, SWT.NONE);
		btnDuyt.setBounds(344, 45, 85, 26);
		btnDuyt.setText("Duyệt...");
		
		Button btnSaoLu = new Button(grpSaoLu, SWT.NONE);
		btnSaoLu.setText("Sao lưu");
		btnSaoLu.setBounds(30, 79, 94, 33);
		
		Group grpPhcHi = new Group(this, SWT.NONE);
		grpPhcHi.setText("Phục hồi");
		grpPhcHi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpPhcHi.setBounds(30, 229, 452, 122);
		
		Label lblChnTpSao = new Label(grpPhcHi, SWT.NONE);
		lblChnTpSao.setText("Chọn tệp sao lưu:");
		lblChnTpSao.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblChnTpSao.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblChnTpSao.setBounds(30, 25, 129, 15);
		
		text = new Text(grpPhcHi, SWT.BORDER);
		text.setBounds(31, 46, 307, 24);
		
		Button button = new Button(grpPhcHi, SWT.NONE);
		button.setText("Duyệt...");
		button.setBounds(344, 45, 85, 26);
		
		Button btnPhcHi = new Button(grpPhcHi, SWT.NONE);
		btnPhcHi.setText("Phục hồi");
		btnPhcHi.setBounds(30, 79, 94, 33);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Sao lưu phục hồi");
		setSize(516, 456);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
