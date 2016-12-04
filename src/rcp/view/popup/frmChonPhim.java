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
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;

public class frmChonPhim extends Shell {
	private Text text;
	private Table table;

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmChonPhim(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblMThcn = new Label(this, SWT.NONE);
		lblMThcn.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblMThcn.setText("Tên phim:");
		lblMThcn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMThcn.setBounds(27, 23, 75, 15);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(106, 20, 220, 24);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 258, 529, 56);
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setText("Chọn");
		btnLu.setBounds(325, 10, 94, 33);
		
		Button btnHyB = new Button(composite, SWT.NONE);
		btnHyB.setText("Hủy bỏ");
		btnHyB.setBounds(425, 10, 94, 33);
		
		TableViewer tableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(26, 57, 479, 186);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMSutPhim = tableViewerColumn.getColumn();
		tblclmnMSutPhim.setResizable(false);
		tblclmnMSutPhim.setWidth(120);
		tblclmnMSutPhim.setText("Mã suất phim");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnnhDng = tableViewerColumn_1.getColumn();
		tblclmnnhDng.setWidth(120);
		tblclmnnhDng.setText("Định dạng");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnHnhThc = tableViewerColumn_2.getColumn();
		tblclmnHnhThc.setWidth(120);
		tblclmnHnhThc.setText("Hình thức");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNgnNg = tableViewerColumn_3.getColumn();
		tblclmnNgnNg.setWidth(116);
		tblclmnNgnNg.setText("Ngôn ngữ");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Chọn suất phim");
		setSize(535, 341);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
