/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gamil.com
 */

package rcp.view.popup;

import java.sql.SQLException;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.ThucAnController;
import rcp.entity.ThucAn;
import rcp.entity.ThucAnKichCo;
import rcp.util.Message;

public class frmThucAnKichCo extends Shell {
	private ThucAn ta = null;
	private Combo cbKichCo;
	private Text txtGia;
	private Text txtTenThucAn;
	private Text txtMaThucAn;

	/**
	 * Create the shell.
	 * @param display
	 * @param ta
	 * @param title
	 */
	public frmThucAnKichCo(Display display, String title, ThucAn ta) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setText("Thêm kích cỡ thức ăn");
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Thêm kích cỡ thức ăn");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 244, 23);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 353, 352, 56);
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setImage(SWTResourceManager.getImage(frmThucAnKichCo.class, "/rcp/view/page/save_16x16.png"));
		btnLu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (luu())
					close();
			}
		});
		btnLu.setText("Lưu");
		btnLu.setBounds(148, 10, 94, 33);
		
		Button btnHyB = new Button(composite, SWT.NONE);
		btnHyB.setImage(SWTResourceManager.getImage(frmThucAnKichCo.class, "/rcp/view/page/cancel_16x16.png"));
		btnHyB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHyB.setText("Hủy bỏ");
		btnHyB.setBounds(248, 10, 94, 33);
		this.ta = ta;
		
		ComboViewer comboViewer = new ComboViewer(this, SWT.NONE);
		cbKichCo = comboViewer.getCombo();
		cbKichCo.setBounds(123, 223, 179, 23);
		cbKichCo.select(0);
		
		Label lblGi = new Label(this, SWT.NONE);
		lblGi.setText("Giá bán:");
		lblGi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblGi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGi.setBounds(42, 275, 75, 15);
		
		Label lblKchC = new Label(this, SWT.NONE);
		lblKchC.setText("Kích cỡ:");
		lblKchC.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblKchC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblKchC.setBounds(42, 226, 75, 15);
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setText("Tên thức ăn:");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setBounds(42, 176, 75, 15);
		
		Label label_4 = new Label(this, SWT.NONE);
		label_4.setText("Mã thức ăn:");
		label_4.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_4.setBounds(42, 125, 75, 15);

		this.ta = ta;
		
		txtGia = new Text(this, SWT.BORDER);
		txtGia.setBounds(123, 271, 179, 24);
		
		txtTenThucAn = new Text(this, SWT.BORDER);
		txtTenThucAn.setEnabled(false);
		txtTenThucAn.setBounds(123, 173, 179, 24);
		
		txtMaThucAn = new Text(this, SWT.BORDER);
		txtMaThucAn.setEnabled(false);
		txtMaThucAn.setBounds(123, 122, 179, 24);
		
		this.ta = ta;
		
		Label label = new Label(this, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(frmThucAnKichCo.class, "/rcp/view/popup/imgThucAn3_64p.png"));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(31, 26, 64, 64);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setSize(358, 438);
		hienThiGiaoDien();

	}

	/**
	 * Hàm hiển thị giao diện ban đầu
	 */
	public void hienThiGiaoDien() {
		hienKichCo();

		try {
			txtMaThucAn.setText(ta.getMaThucAn());
			txtTenThucAn.setText(ta.getTenThucAn());
			}
		 catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 
	 * Hàm thực hiện hành động lưu thông tin
	 */
	public boolean luu() {
		try {
			kiemTraDieuKien();
			if (!ThucAnController.them(layThucAnKichCo()))
					throw new SQLException();
			Message.show("Lưu thông tin thức ăn thành công", "Thành công", SWT.OK | SWT.ICON_INFORMATION,
					getShell());
			return true;
		} catch (ParameterValuesException e0) {
			Message.show(e0.getMessage(), "Cảnh báo", SWT.OK | SWT.ICON_WARNING, getShell());
		} catch (Exception e1) {
			e1.printStackTrace();
			Message.show("Không thể lưu thông tin kích cỡ của thức ăn", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
		}
		return false;
	}

	/**
	 * Chuyển các thông tin trên giao diện thành đối tượng thức ăn kích cỡ
	 */
	public ThucAnKichCo layThucAnKichCo() {
		return new ThucAnKichCo(txtMaThucAn.getText(), Double.parseDouble(txtGia.getText()),cbKichCo.getText());
	}



	/**
	 * Hiển thị kích cỡ lên comboBox
	 */
	public void hienKichCo() {
		cbKichCo.add("Nhỏ");
		cbKichCo.add("Vừa");
		cbKichCo.add("Lớn");
		cbKichCo.select(0);
	}
	

	
	/**
	 * 
	 * Kiểm tra các trường có được nhập đầy đủ hay không
	 */
	public void kiemTraDieuKien() throws ParameterValuesException {
		if (txtGia.getText() == null || txtGia.getText().isEmpty())
			throw new ParameterValuesException("Giá bán không được trống", null);
	}

	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
