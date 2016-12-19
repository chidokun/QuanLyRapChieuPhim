/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */

package rcp.view.popup;

import java.util.ArrayList;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.KhuyenMaiController;
import rcp.controller.QuyDinhController;
import rcp.entity.KhuyenMai;
import rcp.entity.QuyDinh;
import rcp.util.MathF;
import rcp.util.Message;

public class frmQuyDinh extends Shell {
	private Table gridQuyDinh;
	private Table gridKhuyenMai;
	private Label lblTenQuyDinh;
	private Spinner numGiaTri;
	private Button btnDat;
	private Button btnLuu;
	private Button btnHuy;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmQuyDinh(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setSize(642, 594);
		setText("Quy định và khuyến mãi");
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(101, 55, 251, 15);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setText("Chỉnh sửa thiết đặt quy định và khuyến mãi");

		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setBounds(101, 26, 220, 23);
		lblThmSaNhn.setText("Quy định và khuyến mãi");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBounds(30, 20, 64, 64);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(SWTResourceManager.getImage(frmQuyDinh.class, "/rcp/view/popup/imgQuyDinh_64p.png"));

		Group grpSaoLu = new Group(this, SWT.NONE);
		grpSaoLu.setBounds(30, 101, 584, 236);
		grpSaoLu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpSaoLu.setText("Quy định");

		Label lblTnThcn = new Label(grpSaoLu, SWT.NONE);
		lblTnThcn.setBounds(22, 25, 75, 15);
		lblTnThcn.setText("Tên quy định:");
		lblTnThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		btnDat = new Button(grpSaoLu, SWT.NONE);
		btnDat.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				datQuyDinh();
			}
		});
		btnDat.setBounds(503, 24, 58, 26);
		btnDat.setText("Đặt");

		numGiaTri = new Spinner(grpSaoLu, SWT.BORDER);
		numGiaTri.setIncrement(1000);
		numGiaTri.setMaximum(1000000000);
		numGiaTri.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		numGiaTri.setBounds(416, 25, 81, 24);
		numGiaTri.setDigits(3);

		lblTenQuyDinh = new Label(grpSaoLu, SWT.NONE);
		lblTenQuyDinh.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblTenQuyDinh.setText("<quy định>");
		lblTenQuyDinh.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblTenQuyDinh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTenQuyDinh.setBounds(103, 25, 307, 22);

		Label lblChnMtQuy = new Label(grpSaoLu, SWT.NONE);
		lblChnMtQuy.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblChnMtQuy.setText("Chọn một quy định để thay đổi giá trị");
		lblChnMtQuy.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblChnMtQuy.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblChnMtQuy.setBounds(22, 48, 260, 15);

		TableViewer tableViewer = new TableViewer(grpSaoLu, SWT.BORDER | SWT.FULL_SELECTION);
		gridQuyDinh = tableViewer.getTable();
		gridQuyDinh.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				chonQuyDinh();
			}
		});
		gridQuyDinh.setLinesVisible(true);
		gridQuyDinh.setHeaderVisible(true);
		gridQuyDinh.setBounds(22, 69, 539, 157);

		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnStt_1 = tableViewerColumn_7.getColumn();
		tblclmnStt_1.setWidth(36);
		tblclmnStt_1.setText("STT");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMQuynh = tableViewerColumn.getColumn();
		tblclmnMQuynh.setWidth(90);
		tblclmnMQuynh.setText("Mã quy định");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTnQuynh = tableViewerColumn_1.getColumn();
		tblclmnTnQuynh.setWidth(288);
		tblclmnTnQuynh.setText("Tên quy định");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnGiTr = tableViewerColumn_2.getColumn();
		tblclmnGiTr.setWidth(100);
		tblclmnGiTr.setText("Giá trị");

		Group grpKhuynMi = new Group(this, SWT.NONE);
		grpKhuynMi.setBounds(30, 343, 584, 150);
		grpKhuynMi.setText("Khuyến mãi");
		grpKhuynMi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblDanhMcCc = new Label(grpKhuynMi, SWT.NONE);
		lblDanhMcCc.setText("Danh mục các loại hình khuyến mãi");
		lblDanhMcCc.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblDanhMcCc.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDanhMcCc.setBounds(20, 24, 281, 15);

		TableViewer tableViewer_1 = new TableViewer(grpKhuynMi, SWT.BORDER | SWT.FULL_SELECTION);
		gridKhuyenMai = tableViewer_1.getTable();
		gridKhuyenMai.setBounds(20, 45, 539, 95);
		gridKhuyenMai.setLinesVisible(true);
		gridKhuyenMai.setHeaderVisible(true);

		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnStt = tableViewerColumn_6.getColumn();
		tblclmnStt.setWidth(40);
		tblclmnStt.setText("STT");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnMKhuynMi = tableViewerColumn_3.getColumn();
		tblclmnMKhuynMi.setWidth(113);
		tblclmnMKhuynMi.setText("Mã khuyến mãi");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnTnKhuynMi = tableViewerColumn_4.getColumn();
		tblclmnTnKhuynMi.setWidth(148);
		tblclmnTnKhuynMi.setText("Tên khuyến mãi");

		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnMT = tableViewerColumn_5.getColumn();
		tblclmnMT.setWidth(221);
		tblclmnMT.setText("Mô tả");

		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 509, 639, 56);

		btnLuu = new Button(composite, SWT.NONE);
		btnLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				luuQuyDinh();
				close();
			}
		});
		btnLuu.setText("Lưu");
		btnLuu.setBounds(435, 10, 94, 33);

		btnHuy = new Button(composite, SWT.NONE);
		btnHuy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHuy.setText("Hủy bỏ");
		btnHuy.setBounds(535, 10, 94, 33);

		hienThiGiaoDien();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * Hiển thị giao diện
	 */
	public void hienThiGiaoDien() {
		hienQuyDinh();
		hienKhuyenMai();
		chonQuyDinh();
	}

	/**
	 * Nạp khuyến mãi lên bảng
	 */
	public void hienKhuyenMai() {
		try {
			ArrayList<KhuyenMai> arr = KhuyenMaiController.taiTatCa();

			gridKhuyenMai.removeAll();
			int stt = 1;
			for (KhuyenMai i : arr) {
				TableItem item = new TableItem(gridKhuyenMai, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaKM(), i.getTenKM(), i.getMoTa() });
				stt++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Nạp quy định lên bảng
	 */
	public void hienQuyDinh() {
		try {
			ArrayList<QuyDinh> arr = QuyDinhController.taiTatCa();

			gridQuyDinh.removeAll();
			int stt = 1;
			for (QuyDinh i : arr) {
				TableItem item = new TableItem(gridQuyDinh, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), i.getMaQD(), i.getTenQD(),
						MathF.formatFloat(i.getGiaTri()) });
				stt++;
			}
			gridQuyDinh.select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hiển thị quy định từ bảng
	 */
	public void chonQuyDinh() {
		lblTenQuyDinh.setText(gridQuyDinh.getSelection()[0].getText(2));
		numGiaTri.setSelection(Integer.parseInt(MathF.removeDot(gridQuyDinh.getSelection()[0].getText(3))));
	}

	/**
	 * Ghi nhận quy định vào bảng
	 */
	public void datQuyDinh() {
		float value = (float) (numGiaTri.getSelection() / Math.pow(10, 3));
		TableItem item = gridQuyDinh.getSelection()[0];
		item.setText(3, MathF.formatFloat(value));
	}

	/**
	 * Lưu quy định
	 */
	public void luuQuyDinh() {
		try {
			for (TableItem i : gridQuyDinh.getItems()) {
				if (!QuyDinhController
						.sua(new QuyDinh(i.getText(1), i.getText(2), MathF.parseFloatVN(i.getText(3)), null)))
					throw new Exception();
			}
			Message.show("Lưu quy định thành công", "Thành công", SWT.OK | SWT.ICON_INFORMATION, getShell());
		} catch (Exception e) {
			e.printStackTrace();
			Message.show("Không thể lưu quy định", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
		}
	}
}
