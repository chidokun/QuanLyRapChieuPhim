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

public class frmThucAn extends Shell {
	private Text text;
	private Text text_1;
	private Table table;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmThucAn(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Thêm sửa thức ăn");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 176, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/imgThucAn_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 447, 540, 56);
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setText("Lưu");
		btnLu.setBounds(336, 10, 94, 33);
		
		Button btnHyB = new Button(composite, SWT.NONE);
		btnHyB.setText("Hủy bỏ");
		btnHyB.setBounds(436, 10, 94, 33);
		
		Group group = new Group(this, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group.setBounds(24, 90, 495, 104);
		
		Label lblMThcn = new Label(group, SWT.NONE);
		lblMThcn.setBounds(10, 25, 75, 15);
		lblMThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMThcn.setText("Mã thức ăn:");
		lblMThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(89, 22, 141, 24);
		
		Label lblLoiThcn = new Label(group, SWT.NONE);
		lblLoiThcn.setBounds(257, 25, 75, 15);
		lblLoiThcn.setText("Loại thức ăn:");
		lblLoiThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblLoiThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		ComboViewer comboViewer = new ComboViewer(group, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setBounds(338, 22, 141, 23);
		
		Label lblTnThcn = new Label(group, SWT.NONE);
		lblTnThcn.setBounds(10, 69, 75, 15);
		lblTnThcn.setText("Tên thức ăn:");
		lblTnThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setBounds(89, 66, 141, 24);
		
		Label lblTrngThi = new Label(group, SWT.NONE);
		lblTrngThi.setBounds(257, 70, 75, 15);
		lblTrngThi.setText("Trạng thái:");
		lblTrngThi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		ComboViewer comboViewer_2 = new ComboViewer(group, SWT.NONE);
		Combo combo_2 = comboViewer_2.getCombo();
		combo_2.setBounds(338, 67, 141, 23);
		
		Group group_1 = new Group(this, SWT.NONE);
		group_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group_1.setBounds(24, 200, 495, 112);
		
		Label lblKchC = new Label(group_1, SWT.NONE);
		lblKchC.setBounds(10, 25, 75, 15);
		lblKchC.setText("Kích cỡ:");
		lblKchC.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblKchC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		ComboViewer comboViewer_1 = new ComboViewer(group_1, SWT.NONE);
		Combo combo_1 = comboViewer_1.getCombo();
		combo_1.setBounds(91, 22, 141, 23);
		
		Label lblnGi = new Label(group_1, SWT.NONE);
		lblnGi.setBounds(257, 25, 75, 15);
		lblnGi.setText("Đơn giá:");
		lblnGi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblnGi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Spinner spinner = new Spinner(group_1, SWT.BORDER);
		spinner.setBounds(338, 22, 141, 24);
		
		Button btnThm = new Button(group_1, SWT.NONE);
		btnThm.setText("Thêm");
		btnThm.setBounds(323, 65, 75, 33);
		
		Button btnXa = new Button(group_1, SWT.NONE);
		btnXa.setText("Xóa");
		btnXa.setBounds(404, 65, 75, 33);
		
		TableViewer tableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBounds(24, 325, 495, 116);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnStt = tableViewerColumn.getColumn();
		tblclmnStt.setWidth(44);
		tblclmnStt.setText("STT");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnKchC = tableViewerColumn_1.getColumn();
		tblclmnKchC.setWidth(191);
		tblclmnKchC.setText("Kích cỡ");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnnGi = tableViewerColumn_2.getColumn();
		tblclmnnGi.setWidth(255);
		tblclmnnGi.setText("Đơn giá");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Thêm sửa thức ăn");
		setSize(546, 532);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
