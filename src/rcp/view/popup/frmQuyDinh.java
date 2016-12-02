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
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;

public class frmQuyDinh extends Shell {
	private Table table;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmQuyDinh(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setText("Quy định và khuyến mãi");
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 251, 15);
		lblNewLabel.setText("Chỉnh sửa thiết đặt quy định và khuyến mãi");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Quy định và khuyến mãi");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 220, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/imgQuyDinh_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 475, 639, 56);
		
		Button button = new Button(composite, SWT.NONE);
		button.setText("Lưu");
		button.setBounds(435, 10, 94, 33);
		
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.setText("Hủy bỏ");
		button_1.setBounds(535, 10, 94, 33);
		
		Group grpSaoLu = new Group(this, SWT.NONE);
		grpSaoLu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpSaoLu.setText("Quy định");
		grpSaoLu.setBounds(30, 101, 584, 197);
		
		Label lblTnThcn = new Label(grpSaoLu, SWT.NONE);
		lblTnThcn.setBounds(22, 25, 75, 15);
		lblTnThcn.setText("Tên quy định:");
		lblTnThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Button btnDuyt = new Button(grpSaoLu, SWT.NONE);
		btnDuyt.setBounds(503, 24, 58, 26);
		btnDuyt.setText("Đặt");
		
		Spinner spinner = new Spinner(grpSaoLu, SWT.BORDER);
		spinner.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		spinner.setBounds(416, 25, 81, 24);
		
		Label label = new Label(grpSaoLu, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		label.setText("<quy định>");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(103, 25, 307, 22);
		
		Label lblChnMtQuy = new Label(grpSaoLu, SWT.NONE);
		lblChnMtQuy.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblChnMtQuy.setText("Chọn một quy định để thay đổi giá trị");
		lblChnMtQuy.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblChnMtQuy.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblChnMtQuy.setBounds(22, 48, 260, 15);
		
		TableViewer tableViewer = new TableViewer(grpSaoLu, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(22, 69, 539, 114);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMQuynh = tableViewerColumn.getColumn();
		tblclmnMQuynh.setWidth(90);
		tblclmnMQuynh.setText("Mã quy định");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTnQuynh = tableViewerColumn_1.getColumn();
		tblclmnTnQuynh.setWidth(332);
		tblclmnTnQuynh.setText("Tên quy định");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnGiTr = tableViewerColumn_2.getColumn();
		tblclmnGiTr.setWidth(100);
		tblclmnGiTr.setText("Giá trị");
		
		Group grpKhuynMi = new Group(this, SWT.NONE);
		grpKhuynMi.setText("Khuyến mãi");
		grpKhuynMi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpKhuynMi.setBounds(30, 304, 584, 150);
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Sao lưu phục hồi");
		setSize(645, 560);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
