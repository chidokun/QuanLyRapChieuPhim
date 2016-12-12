/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.popup;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;
import rcp.Settings;
import rcp.util.*;

public class frmSaoLuuPhucHoi extends Shell {
	private Text txtSaoLuu;
	private Text txtPhucHoi;
	private Text txtBin;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmSaoLuuPhucHoi(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		Window.center(display, this);
		setLayout(null);

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 47, 251, 15);
		lblNewLabel.setText("Chọn vị trí để sao lưu hoặc file để phục hồi");

		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Sao lưu và phục hồi");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 18, 176, 23);

		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(
				SWTResourceManager.getImage(frmSaoLuuPhucHoi.class, "/rcp/view/popup/imgSaoLuuPhucHoi_64p.png"));
		label_1.setBounds(30, 10, 64, 64);

		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 455, 510, 56);

		Button btnDong = new Button(composite, SWT.NONE);
		btnDong.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnDong.setText("Đóng");
		btnDong.setBounds(408, 10, 94, 33);

		Group grpSaoLu = new Group(this, SWT.NONE);
		grpSaoLu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpSaoLu.setText("Sao lưu");
		grpSaoLu.setBounds(30, 184, 452, 122);

		Label lblTnThcn = new Label(grpSaoLu, SWT.NONE);
		lblTnThcn.setBounds(30, 25, 75, 15);
		lblTnThcn.setText("Vị trí sao lưu:");
		lblTnThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtSaoLuu = new Text(grpSaoLu, SWT.BORDER);
		txtSaoLuu.setBounds(31, 46, 307, 24);

		Button btnDuyetSaoLuu = new Button(grpSaoLu, SWT.NONE);
		btnDuyetSaoLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(getShell(), SWT.SAVE);
				dlg.setText("Chọn file sao lưu");
				dlg.setFilterNames(new String[] { "SQL File (*.sql)" });
				dlg.setFilterExtensions(new String[] { "*.sql" });
				String file = dlg.open();
				if (file != null)
					txtSaoLuu.setText(file);
			}
		});
		btnDuyetSaoLuu.setBounds(344, 45, 85, 26);
		btnDuyetSaoLuu.setText("Duyệt...");

		Button btnSaoLuu = new Button(grpSaoLu, SWT.NONE);
		btnSaoLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					if(Database.backup(txtSaoLuu.getText()))
						Message.show("Sao lưu thành công!", "Thành công",
								SWT.OK | SWT.ICON_INFORMATION, getShell());
					else
						Message.show("Không thể sao lưu, có lỗi xảy ra. Vui lòng thử lại sau", "Không thể sao lưu",
								SWT.OK | SWT.ERROR, getShell());
				} catch (Exception e1) {
					Message.show("Không thể sao lưu, có lỗi xảy ra. Vui lòng thử lại sau", "Không thể sao lưu",
							SWT.OK | SWT.ERROR, getShell());
				}
			}
		});
		btnSaoLuu.setText("Sao lưu");
		btnSaoLuu.setBounds(30, 79, 94, 33);

		Group grpPhcHi = new Group(this, SWT.NONE);
		grpPhcHi.setText("Phục hồi");
		grpPhcHi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpPhcHi.setBounds(30, 312, 452, 122);

		Label lblChnTpSao = new Label(grpPhcHi, SWT.NONE);
		lblChnTpSao.setText("Chọn tệp sao lưu:");
		lblChnTpSao.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblChnTpSao.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblChnTpSao.setBounds(30, 25, 129, 15);

		txtPhucHoi = new Text(grpPhcHi, SWT.BORDER);
		txtPhucHoi.setBounds(31, 46, 307, 24);

		Button btnDuyetPhucHoi = new Button(grpPhcHi, SWT.NONE);
		btnDuyetPhucHoi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(getShell(), SWT.OPEN);
				dlg.setText("Chọn file phục hồi");
				dlg.setFilterNames(new String[] { "SQL File (*.sql)" });
				dlg.setFilterExtensions(new String[] { "*.sql" });
				String file = dlg.open();
				if (file != null)
					txtPhucHoi.setText(file);
			}

		});
		btnDuyetPhucHoi.setText("Duyệt...");
		btnDuyetPhucHoi.setBounds(344, 45, 85, 26);

		Button btnPhucHoi = new Button(grpPhcHi, SWT.NONE);
		btnPhucHoi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					if(Database.restore(txtPhucHoi.getText()))
						Message.show("Phục hồi thành công!", "Thành công",
								SWT.OK | SWT.ICON_INFORMATION, getShell());
					else
						Message.show("Không thể phục hồi, có lỗi xảy ra. Vui lòng thử lại sau", "Không thể phục hồi",
								SWT.OK | SWT.ERROR, getShell());
				} catch (Exception e1) {
					Message.show("Không thể phục hồi, có lỗi xảy ra. Vui lòng thử lại sau", "Không thể phục hồi",
							SWT.OK | SWT.ERROR, getShell());
				}
			}
		});
		btnPhucHoi.setText("Phục hồi");
		btnPhucHoi.setBounds(30, 79, 94, 33);

		Group grpngDnTi = new Group(this, SWT.NONE);
		grpngDnTi.setText("Đường dẫn tới MySQL binary");
		grpngDnTi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpngDnTi.setBounds(30, 89, 452, 89);

		Label lblTinchDump = new Label(grpngDnTi, SWT.NONE);
		lblTinchDump.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblTinchDump.setText("Thư mục bin của MySQL phải được chỉ định để có thể sao lưu và phục hồi");
		lblTinchDump.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTinchDump.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTinchDump.setBounds(30, 25, 399, 15);

		txtBin = new Text(grpngDnTi, SWT.BORDER);
		txtBin.setBounds(31, 46, 307, 24);

		Button btnDuyetBin = new Button(grpngDnTi, SWT.NONE);
		btnDuyetBin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					DirectoryDialog f = new DirectoryDialog(getShell(), SWT.OPEN);
					f.setText("Chọn thư mục bin");

					String dir = f.open();
					if (dir != null) {
						txtBin.setText(dir);
						Settings.set("mySQLBin", dir);
						Settings.save();
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDuyetBin.setText("Duyệt...");
		btnDuyetBin.setBounds(344, 45, 85, 26);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Sao lưu phục hồi");
		setSize(516, 540);

		txtBin.setText((String) Settings.get("mySQLBin"));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
