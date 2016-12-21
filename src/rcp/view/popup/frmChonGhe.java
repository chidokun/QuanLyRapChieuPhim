/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.popup;

import java.util.ArrayList;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.GheController;
import rcp.util.Window;

public class frmChonGhe extends Shell {
	private Image imgGheThuong = SWTResourceManager.getImage(frmChonGhe.class, "/rcp/view/popup/gheThuong.png");
	private Image imgGheVip = SWTResourceManager.getImage(frmChonGhe.class, "/rcp/view/popup/gheVip.png");
	private Image imgGheDoi = SWTResourceManager.getImage(frmChonGhe.class, "/rcp/view/popup/gheDoi.png");
	private Image imgGheDaChon = SWTResourceManager.getImage(frmChonGhe.class, "/rcp/view/popup/gheDaChon.png");
	private Image imgGheChon = SWTResourceManager.getImage(frmChonGhe.class, "/rcp/view/popup/gheChon.png");

	private ArrayList<CLabel> dsGhe = new ArrayList<>(); // dùng lưu tất cả
															// thằng ghế trên
															// giao diện
	private ArrayList<String> dsGheDaChon = new ArrayList<>();
	private Composite pnlGhe;
	private String maSuatChieu;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmChonGhe(Display display,String maSuatChieu) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		this.maSuatChieu=maSuatChieu;
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);

		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite.heightHint = 34;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(531, 10, 75, 15);
		lblNewLabel_1.setText("Ghế thường");
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblGhVip = new Label(composite, SWT.NONE);
		lblGhVip.setText("Ghế VIP");
		lblGhVip.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGhVip.setBounds(636, 10, 69, 15);

		Label lblGhi = new Label(composite, SWT.NONE);
		lblGhi.setText("Ghế đôi");
		lblGhi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGhi.setBounds(723, 10, 69, 15);

		Label lblGhC = new Label(composite, SWT.NONE);
		lblGhC.setText("Ghế đã có người");
		lblGhC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGhC.setBounds(819, 10, 101, 15);

		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(193, 215, 204));
		label_1.setBounds(507, 10, 15, 15);

		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setBackground(SWTResourceManager.getColor(138, 217, 235));
		label_2.setBounds(612, 10, 15, 15);

		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setBackground(SWTResourceManager.getColor(229, 131, 241));
		label_3.setBounds(702, 10, 15, 15);

		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setBackground(SWTResourceManager.getColor(241, 111, 111));
		label_4.setBounds(798, 10, 15, 15);

		Composite composite_1 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(3, false);
		gl_composite_1.marginTop = 7;
		composite_1.setLayout(gl_composite_1);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite_1.widthHint = 973;
		composite_1.setLayoutData(gd_composite_1);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		new Label(composite_1, SWT.NONE);

		CLabel lblNewLabel = new CLabel(composite_1, SWT.NONE);
		lblNewLabel.setTopMargin(0);
		lblNewLabel.setImage(SWTResourceManager.getImage(frmChonGhe.class, "/rcp/view/popup/screen.png"));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setText("");
		new Label(composite_1, SWT.NONE);

		Composite pnlTenHang = new Composite(composite_1, SWT.NONE);
		GridLayout gl_pnlTenHang = new GridLayout(1, false);
		gl_pnlTenHang.verticalSpacing = 3;
		pnlTenHang.setLayout(gl_pnlTenHang);
		GridData gd_pnlTenHang = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_pnlTenHang.widthHint = 72;
		pnlTenHang.setLayoutData(gd_pnlTenHang);
		pnlTenHang.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		pnlGhe = new Composite(composite_1, SWT.NONE);
		GridData gd_pnlGhe = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_pnlGhe.heightHint = 465;
		gd_pnlGhe.widthHint = 782;
		pnlGhe.setLayoutData(gd_pnlGhe);
		pnlGhe.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_pnlGhe = new GridLayout(18, false);
		gl_pnlGhe.verticalSpacing = 3;
		gl_pnlGhe.horizontalSpacing = 3;
		gl_pnlGhe.marginBottom = 5;
		pnlGhe.setLayout(gl_pnlGhe);

		Composite composite_3 = new Composite(composite_1, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		new Label(composite_1, SWT.NONE);

		Composite pnlTenCot = new Composite(composite_1, SWT.NONE);
		pnlTenCot.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_pnlTenCot = new GridLayout(18, false);
		gl_pnlTenCot.horizontalSpacing = 3;
		pnlTenCot.setLayout(gl_pnlTenCot);
		pnlTenCot.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		new Label(composite_1, SWT.NONE);

		for (char i = 'A'; i <= 'K'; i++) {
			CLabel tenHang = new CLabel(pnlTenHang, SWT.NONE);
			GridData gd_tenHang = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
			gd_tenHang.widthHint = 40;
			gd_tenHang.heightHint = 40;
			tenHang.setLayoutData(gd_tenHang);
			tenHang.setBackground(SWTResourceManager.getColor(240, 240, 240));
			tenHang.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
			tenHang.setAlignment(SWT.CENTER);
			tenHang.setText(String.valueOf(i));

			for (int j = 1; j <= 18; j++) {
				CLabel label = new CLabel(pnlGhe, SWT.NONE);
				GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
				gd_label.widthHint = 40;
				gd_label.heightHint = 40;
				label.setLayoutData(gd_label);
				label.setTopMargin(0);
				label.setRightMargin(0);
				label.setLeftMargin(0);
				label.setBottomMargin(0);
				label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				label.setText("");

				// ghế thường
				if (!(i == 'K') || !(j < 5 || j > 14)) {
					// ghế vip
					if (i > 'B' && i < 'K' && j > 4 && j < 15) {
						label.setImage(imgGheVip);
					} else if (i == 'K') {
						label.setImage(imgGheDoi);
					} else {
						label.setImage(imgGheThuong);
					}
					label.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseDown(MouseEvent e) {
							label.setImage(imgGheChon);
							System.out.println(layMaGhe(label));
							dsGheDaChon.add(layMaGhe(label));
						}
					});

					dsGhe.add(label);
				}
			}
		}

		for (int i = 1; i <= 18; i++) {
			CLabel tenCot = new CLabel(pnlTenCot, SWT.NONE);
			GridData gd_tenHang = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
			gd_tenHang.widthHint = 40;
			gd_tenHang.heightHint = 40;
			tenCot.setLayoutData(gd_tenHang);
			tenCot.setBackground(SWTResourceManager.getColor(240, 240, 240));
			tenCot.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
			tenCot.setAlignment(SWT.CENTER);
			tenCot.setText(String.valueOf(i));
		}

		Composite composite_2 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_2 = new GridLayout(2, false);
		gl_composite_2.marginBottom = 5;
		gl_composite_2.marginTop = 5;
		composite_2.setLayout(gl_composite_2);
		composite_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		Button btnLuu = new Button(composite_2, SWT.NONE);
		btnLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				luu();
			}
		});
		GridData gd_btnLuu = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnLuu.heightHint = 33;
		gd_btnLuu.widthHint = 94;
		btnLuu.setLayoutData(gd_btnLuu);
		btnLuu.setText("Lưu");

		Button btnHuyBo = new Button(composite_2, SWT.NONE);
		btnHuyBo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		GridData gd_btnHuyBo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_btnHuyBo.widthHint = 94;
		gd_btnHuyBo.heightHint = 33;
		btnHuyBo.setLayoutData(gd_btnHuyBo);
		btnHuyBo.setText("Hủy bỏ");
		createContents();

		///
		/// Vị trí làm phần Hiện ghế đã có người
		///

		// cần lấy danh sách mã ghế đã có người lưu vào một ArrayList<String>
		// sau đó với từng mã thì bóc thằng đó ra tô đỏ lên
		// đồng thời hủy sự kiện click của nó, ko cho người dùng chọn ghế có
		// người
		try {
			ArrayList<String> dsGheCoNguoi = GheController.layDanhSach(maSuatChieu); // load danh sách đó vào đây

			for (String i : dsGheCoNguoi) {
				CLabel item = layGhe(i);
				item.setImage(imgGheDaChon); // tô đỏ lên
				item.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						// do nothing
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Bán vé");
		setSize(989, 708);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/*public static void main(String[] args) {
		Window.open(new frmChonGhe(Display.getCurrent(),maSuatChieu));
	}*/

	/**
	 * Trả về đối tượng đại diện cho mã ghế đó trên giao diện
	 * 
	 * @param maGhe
	 *            Mã ghế không bao gồm mã phòng, ví dụ: A01, E15, ...
	 * @return
	 * @throws ParameterValuesException
	 */
	public CLabel layGhe(String maGhe) throws ParameterValuesException {
		char p = maGhe.charAt(0);
		int m = Integer.parseInt(maGhe.substring(1));

		if (p > 'K' || (p == 'K' && (m < 5 || m > 14)))
			throw new ParameterValuesException(String.format("Mã ghế không hợp lệ: %1$c%2$d", p, m), null);

		return dsGhe.get(18 * (p - 'A') + m - (p < 'K' ? 1 : 5));
	}

	/**
	 * Trả về mã ghế từ đối tượng giao diện
	 * 
	 * @param item
	 * @return
	 */
	public String layMaGhe(CLabel item) {
		int index = dsGhe.indexOf(item);

		int m = index % 18;
		char p = (char) ('A' + index / 18);

		return String.format("%1$c%2$02d", p, p < 'K' ? m + 1 : m + 5);
	}
	
	public void luu() {
		//làm gì đó là tùy Hoàng
	}
}
