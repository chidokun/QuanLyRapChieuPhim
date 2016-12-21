/**
 * Quản lý Rạp chiếu phim RPP
 * Author_giaodien: Nguyễn Tuấn - nguyentuanit96@gmail.com
 * Author_suly: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.view.popup;

import java.sql.SQLException;
import java.util.ArrayList;

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

import rcp.controller.LoaiThucAnController;
import rcp.controller.ThucAnController;
import rcp.entity.LoaiThucAn;
import rcp.entity.ThucAn;
import rcp.util.Message;

public class frmThucAn extends Shell {
	private boolean isInsert = false;
	
	private ThucAn ta = null;
	private Text txtMaThucAn;
	private Text txtTenThucAn;
	private Combo cbLoaiThucAn;
	private Combo cbTrangThai;

	/**
	 * Create the shell.
	 * @param display
	 * @param ta
	 * @param title
	 */
	public frmThucAn(Display display, String title, ThucAn ta) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setText(title);
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText(title);
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 176, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(SWTResourceManager.getImage(frmThucAn.class, "/rcp/view/popup/imgThucAn2_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 353, 356, 56);
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setImage(SWTResourceManager.getImage(frmThucAn.class, "/rcp/view/page/save_16x16.png"));
		btnLu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (luu())
					close();
			}
		});
		btnLu.setText("Lưu");
		btnLu.setBounds(152, 10, 94, 33);
		
		Button btnHyB = new Button(composite, SWT.NONE);
		btnHyB.setImage(SWTResourceManager.getImage(frmThucAn.class, "/rcp/view/page/cancel_16x16.png"));
		btnHyB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHyB.setText("Hủy bỏ");
		btnHyB.setBounds(252, 10, 94, 33);
		isInsert = ta == null;
		this.ta = ta;
		
		ComboViewer comboViewer = new ComboViewer(this, SWT.NONE);
		cbLoaiThucAn = comboViewer.getCombo();
		cbLoaiThucAn.setBounds(121, 224, 181, 23);
		cbLoaiThucAn.select(0);
		
		ComboViewer comboViewer_1 = new ComboViewer(this, SWT.NONE);
		cbTrangThai = comboViewer_1.getCombo();
		cbTrangThai.setEnabled(false);
		cbTrangThai.setBounds(121, 277, 181, 23);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("Trạng thái:");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(40, 280, 75, 15);
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("Loại thức ăn:");
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setBounds(40, 227, 75, 15);
		
		txtMaThucAn = new Text(this, SWT.BORDER);
		txtMaThucAn.setEnabled(false);
		txtMaThucAn.setBounds(121, 122, 181, 24);
		
		txtTenThucAn = new Text(this, SWT.BORDER);
		txtTenThucAn.setBounds(121, 174, 181, 24);
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setText("Tên thức ăn:");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setBounds(40, 177, 75, 15);
		
		Label label_4 = new Label(this, SWT.NONE);
		label_4.setText("Mã thức ăn:");
		label_4.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_4.setBounds(40, 125, 75, 15);

		isInsert = ta == null;
		this.ta = ta;
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setSize(362, 438);
		hienThiGiaoDien();

	}

	/**
	 * Hàm hiển thị giao diện ban đầu
	 */
	public void hienThiGiaoDien() {
		hienLoaiThucAn();
		hienTrangThai();

		try {
			if (isInsert) {
				txtMaThucAn.setText(ThucAnController.taoMa());
			} else {
				cbTrangThai.setEnabled(true);
				txtMaThucAn.setText(ta.getMaThucAn());
				cbLoaiThucAn.setText(ta.getLoaiThucAn());
				txtTenThucAn.setText(ta.getTenThucAn());
				cbTrangThai.select(ta.getTrangThai());
			}
		} catch (Exception e) {
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
			if (isInsert) {
				if (!ThucAnController.them(layThucAn_them()))
					throw new SQLException();
			} else {
				if (!ThucAnController.sua(layThucAn_sua()))
					throw new SQLException();
			}
			Message.show("Lưu thông tin thức ăn thành công", "Thành công", SWT.OK | SWT.ICON_INFORMATION,
					getShell());
			return true;
		} catch (ParameterValuesException e0) {
			Message.show(e0.getMessage(), "Cảnh báo", SWT.OK | SWT.ICON_WARNING, getShell());
		} catch (Exception e1) {
			e1.printStackTrace();
			Message.show("Không thể lưu thông tin thức ăn", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
		}
		return false;
	}

	/**
	 * Chuyển các thông tin trên giao diện thành đối tượng thức ăn để sửa
	 */
	public ThucAn layThucAn_sua() {
		return new ThucAn(txtMaThucAn.getText(), txtTenThucAn.getText(),
				(String) cbLoaiThucAn.getData(cbLoaiThucAn.getText()), cbTrangThai.getSelectionIndex());
	}

	/**
	 * Chuyển các thông tin trên giao diện thành đối tượng thức ăn để thêm
	 */
	public ThucAn layThucAn_them() {
		return new ThucAn(txtMaThucAn.getText(), txtTenThucAn.getText(),
				(String) cbLoaiThucAn.getData(cbLoaiThucAn.getText()));
	}
	/**
	 * Hiển thị loại thức ăn lên comboBox
	 */
	public void hienLoaiThucAn() {
		try {
			ArrayList<LoaiThucAn> arr = LoaiThucAnController.taiTatCa();
			for (LoaiThucAn i : arr) {
				cbLoaiThucAn.add(i.getTenLoaiThucAn());
				cbLoaiThucAn.setData(i.getTenLoaiThucAn(), i.getMaLoaiThucAn());
			}
			cbLoaiThucAn.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Hiển thị trạng thái lên comboBox
	 */
	public void hienTrangThai() {
		cbTrangThai.add("Không còn bán", 0);
		cbTrangThai.add("Đang được bán", 1);
		cbTrangThai.select(1);
	}
	
	/**
	 * 
	 * Kiểm tra các trường có được nhập đầy đủ hay không
	 */
	public void kiemTraDieuKien() throws ParameterValuesException {
		if (txtTenThucAn.getText() == null || txtTenThucAn.getText().isEmpty())
			throw new ParameterValuesException("Tên thức ăn không được trống", null);
	}

	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
