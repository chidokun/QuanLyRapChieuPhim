/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
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
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;

public class frmSuatChieu extends Shell {
	private Text text;
	private Table table;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmSuatChieu(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Thêm sửa suất chiếu");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 176, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/imgKetNoiCSDL_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Label lblMThcn = new Label(this, SWT.NONE);
		lblMThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMThcn.setText("Mã suất chiếu:");
		lblMThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMThcn.setBounds(30, 102, 75, 15);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(109, 99, 141, 24);
		
		Label lblTnThcn = new Label(this, SWT.NONE);
		lblTnThcn.setText("Tên phim:");
		lblTnThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnThcn.setBounds(30, 147, 75, 15);
		
		Label lblnGi = new Label(this, SWT.NONE);
		lblnGi.setText("Giờ: ");
		lblnGi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblnGi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblnGi.setBounds(30, 195, 75, 15);
		
		Label lblLoiThcn = new Label(this, SWT.NONE);
		lblLoiThcn.setText("Phòng:");
		lblLoiThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblLoiThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLoiThcn.setBounds(277, 102, 75, 15);
		
		ComboViewer comboViewer = new ComboViewer(this, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setBounds(358, 99, 141, 23);
		
		Label lblKchC = new Label(this, SWT.NONE);
		lblKchC.setText("Thời gian:");
		lblKchC.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblKchC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblKchC.setBounds(277, 150, 75, 15);
		
		ComboViewer comboViewer_2 = new ComboViewer(this, SWT.NONE);
		Combo combo_2 = comboViewer_2.getCombo();
		combo_2.setBounds(358, 193, 141, 23);
		
		Label lblTrngThi = new Label(this, SWT.NONE);
		lblTrngThi.setText("Trạng thái:");
		lblTrngThi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTrngThi.setBounds(277, 196, 75, 15);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 373, 529, 56);
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setText("Lưu");
		btnLu.setBounds(325, 10, 94, 33);
		
		Button btnHyB = new Button(composite, SWT.NONE);
		btnHyB.setText("Hủy bỏ");
		btnHyB.setBounds(425, 10, 94, 33);
		
		ComboViewer comboViewer_3 = new ComboViewer(this, SWT.NONE);
		Combo combo_3 = comboViewer_3.getCombo();
		combo_3.setBounds(109, 147, 141, 23);
		
		DateTime dateTime = new DateTime(this, SWT.BORDER);
		dateTime.setBounds(358, 147, 141, 24);
		
		TableViewer tableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(32, 226, 467, 141);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMSutPhim = tableViewerColumn.getColumn();
		tblclmnMSutPhim.setWidth(105);
		tblclmnMSutPhim.setText("Mã suất phim");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnnhDng = tableViewerColumn_1.getColumn();
		tblclmnnhDng.setWidth(118);
		tblclmnnhDng.setText("Định dạng");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnHnhThc = tableViewerColumn_2.getColumn();
		tblclmnHnhThc.setWidth(120);
		tblclmnHnhThc.setText("Hình thức");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNgnNg = tableViewerColumn_3.getColumn();
		tblclmnNgnNg.setWidth(120);
		tblclmnNgnNg.setText("Ngôn ngữ");
		
		DateTime dateTime_1 = new DateTime(this, SWT.BORDER| SWT.TIME );
		dateTime_1.setBounds(109, 192, 141, 24);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Thêm sửa suất chiếu");
		setSize(535, 458);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
