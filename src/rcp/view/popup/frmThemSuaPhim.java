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
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;

public class frmThemSuaPhim extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Table table;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmThemSuaPhim(Display display) {
		super(display, SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setText("Vui lòng nhập đầy đủ thông tin");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setText("Thêm sửa phim");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblThmSaNhn.setBounds(101, 26, 176, 23);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/imgThucAn_64p.png"));
		label_1.setBounds(30, 20, 64, 64);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 582, 561, 56);
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setText("Lưu");
		btnLu.setBounds(330, 10, 94, 33);
		
		Button btnHyB = new Button(composite, SWT.NONE);
		btnHyB.setText("Hủy bỏ");
		btnHyB.setBounds(442, 10, 94, 33);
		
		CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.marginWidth = 5;
		tabFolder.marginHeight = 5;
		tabFolder.setTabHeight(25);
		tabFolder.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		tabFolder.setBounds(10, 90, 541, 486);
		tabFolder.setSelectionBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		CTabItem tbtmPhim = new CTabItem(tabFolder, SWT.NONE);
		tbtmPhim.setText("Phim");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmPhim.setControl(composite_1);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lblMPhim = new Label(composite_1, SWT.NONE);
		lblMPhim.setText("Mã phim:");
		lblMPhim.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMPhim.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMPhim.setBounds(23, 33, 75, 15);
		
		text = new Text(composite_1, SWT.BORDER);
		text.setBounds(102, 30, 141, 24);
		
		Label lblTnPhim = new Label(composite_1, SWT.NONE);
		lblTnPhim.setText("Tên phim:");
		lblTnPhim.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTnPhim.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnPhim.setBounds(23, 78, 75, 15);
		
		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setBounds(102, 75, 141, 72);
		
		Label lblTrngThi = new Label(composite_1, SWT.NONE);
		lblTrngThi.setText("Trạng thái:");
		lblTrngThi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTrngThi.setBounds(270, 33, 75, 15);
		
		ComboViewer comboViewer = new ComboViewer(composite_1, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setBounds(351, 30, 141, 24);
		
		Label label = new Label(composite_1, SWT.NONE);
		label.setText("Thời lượng:");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(25, 172, 75, 15);
		
		ComboViewer comboViewer_1 = new ComboViewer(composite_1, SWT.NONE);
		Combo combo_1 = comboViewer_1.getCombo();
		combo_1.setBounds(353, 215, 141, 23);
		
		Label label_3 = new Label(composite_1, SWT.NONE);
		label_3.setText("Ngôn ngữ:");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setBounds(272, 218, 75, 15);
		
		Label label_4 = new Label(composite_1, SWT.NONE);
		label_4.setText("Năm sản xuất:");
		label_4.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_4.setBounds(23, 218, 75, 15);
		
		Label label_5 = new Label(composite_1, SWT.NONE);
		label_5.setText("Giới hạn tuổi:");
		label_5.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_5.setBounds(23, 263, 75, 15);
		
		Label label_7 = new Label(composite_1, SWT.NONE);
		label_7.setText("Nước sản xuất:");
		label_7.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_7.setBounds(272, 263, 75, 15);
		
		ComboViewer comboViewer_3 = new ComboViewer(composite_1, SWT.NONE);
		Combo combo_3 = comboViewer_3.getCombo();
		combo_3.setBounds(353, 260, 141, 23);
		
		Label label_9 = new Label(composite_1, SWT.NONE);
		label_9.setText("Tóm tắt:");
		label_9.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_9.setBounds(25, 353, 75, 15);
		
		StyledText styledText = new StyledText(composite_1, SWT.WRAP| SWT.V_SCROLL|SWT.BORDER | SWT.WRAP);
		styledText.setBounds(107, 353, 385, 81);
		
		Spinner spinner = new Spinner(composite_1, SWT.BORDER);
		spinner.setBounds(104, 215, 141, 24);
		
		Spinner spinner_1 = new Spinner(composite_1, SWT.BORDER);
		spinner_1.setBounds(104, 171, 141, 24);
		
		Spinner spinner_2 = new Spinner(composite_1, SWT.BORDER);
		spinner_2.setBounds(104, 261, 141, 24);
		
		Label label_8 = new Label(composite_1, SWT.NONE);
		label_8.setText("Diễn viên:");
		label_8.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_8.setBounds(270, 80, 75, 15);
		
		text_2 = new Text(composite_1, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		text_2.setBounds(351, 78, 141, 69);
		
		Label label_10 = new Label(composite_1, SWT.NONE);
		label_10.setText("Doanh thu:");
		label_10.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_10.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_10.setBounds(272, 308, 75, 15);
		
		text_3 = new Text(composite_1, SWT.BORDER);
		text_3.setBounds(353, 305, 141, 24);
		
		Label label_2 = new Label(composite_1, SWT.NONE);
		label_2.setText("Nước sản xuất:");
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setBounds(270, 175, 75, 15);
		
		ComboViewer comboViewer_2 = new ComboViewer(composite_1, SWT.NONE);
		Combo combo_2 = comboViewer_2.getCombo();
		combo_2.setBounds(351, 172, 141, 23);
		
		DateTime dateTime = new DateTime(composite_1, SWT.BORDER);
		dateTime.setBounds(102, 305, 141, 24);
		
		Label lblNgyChiu = new Label(composite_1, SWT.NONE);
		lblNgyChiu.setText("Ngày chiếu");
		lblNgyChiu.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNgyChiu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgyChiu.setBounds(23, 308, 75, 15);
		
		CTabItem tbtmSutPhim = new CTabItem(tabFolder, SWT.NONE);
		tbtmSutPhim.setText("Suất phim");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		tbtmSutPhim.setControl(composite_2);
		
		TableViewer tableViewer = new TableViewer(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setBounds(10, 134, 505, 300);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(53);
		tblclmnNewColumn.setText("STT");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_3.setWidth(137);
		tblclmnNewColumn_3.setText("Định dạng");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setWidth(165);
		tblclmnNewColumn_2.setText("Hình thức");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(145);
		tblclmnNewColumn_1.setText("Ngôn ngữ");
		
		Group group = new Group(composite_2, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group.setBounds(10, 10, 505, 105);
		
		Label lblnhDng = new Label(group, SWT.NONE);
		lblnhDng.setText("Định dạng");
		lblnhDng.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblnhDng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblnhDng.setBounds(24, 24, 75, 15);
		
		ComboViewer comboViewer_4 = new ComboViewer(group, SWT.NONE);
		Combo combo_4 = comboViewer_4.getCombo();
		combo_4.setBounds(105, 21, 141, 23);
		
		Label lblNgnNg = new Label(group, SWT.NONE);
		lblNgnNg.setText("Ngôn ngữ");
		lblNgnNg.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNgnNg.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgnNg.setBounds(24, 64, 75, 15);
		
		ComboViewer comboViewer_5 = new ComboViewer(group, SWT.NONE);
		Combo combo_5 = comboViewer_5.getCombo();
		combo_5.setBounds(105, 61, 141, 23);
		
		Label lblHnhThc = new Label(group, SWT.NONE);
		lblHnhThc.setText("Hình thức");
		lblHnhThc.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblHnhThc.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHnhThc.setBounds(273, 27, 75, 15);
		
		ComboViewer comboViewer_6 = new ComboViewer(group, SWT.NONE);
		Combo combo_6 = comboViewer_6.getCombo();
		combo_6.setBounds(354, 24, 141, 23);
		
		Button button = new Button(group, SWT.NONE);
		button.setText("Thêm");
		button.setBounds(339, 61, 75, 25);
		
		Button button_1 = new Button(group, SWT.NONE);
		button_1.setText("Xóa");
		button_1.setBounds(420, 61, 75, 25);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Thêm sửa phim");
		setSize(570, 667);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
