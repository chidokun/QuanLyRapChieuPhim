/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package rcp.view.page;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import rcp.controller.PhimController;
import rcp.controller.SuatChieuController;
import rcp.controller.SuatPhimController;
import rcp.entity.Phim;
import rcp.entity.SuatChieu;
import rcp.util.DateF;
import rcp.util.Message;
import rcp.util.Window;
import rcp.view.popup.frmChonGhe;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class pageBanVe extends Composite {
	private Table tablePhim;
	private Table tableSuatChieu;
	private Button btnTim;
	private DateTime dateTime;
	private TableColumn tableSTT;
	private Button btnChon;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public pageBanVe(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);
		
		Composite composite = new Composite(this, SWT.NONE);
		GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.marginBottom = 5;
		gl_composite.marginTop = 10;
		gl_composite.marginRight = 5;
		gl_composite.marginLeft = 5;
		composite.setLayout(gl_composite);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 279;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		dateTime = new DateTime(composite, SWT.BORDER| SWT.DROP_DOWN);
		GridData gd_dateTime = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateTime.widthHint = 120;
		dateTime.setLayoutData(gd_dateTime);
		
		btnTim = new Button(composite, SWT.NONE);
		btnTim.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				traCuu();
			}
		});
		GridData gd_btnTim = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnTim.widthHint = 86;
		btnTim.setLayoutData(gd_btnTim);
		btnTim.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\zoom_16x16.png"));
		btnTim.setText("Tìm kiếm");
		
		tablePhim = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tablePhim.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				traCuuSuatChieu();
				
			}
		});
		GridData gd_tablePhim = new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1);
		gd_tablePhim.widthHint = 235;
		
		tablePhim.setLayoutData(gd_tablePhim);
		tablePhim.setHeaderVisible(true);
		tablePhim.setLinesVisible(true);
		
		tableSTT = new TableColumn(tablePhim, SWT.NONE);
		tableSTT.setWidth(50);
		tableSTT.setText("STT");
		
		TableColumn tblclmnMPhim = new TableColumn(tablePhim, SWT.NONE);
		tblclmnMPhim.setText("Mã Phim");
		
		TableColumn tblclmnNewColumn = new TableColumn(tablePhim, SWT.NONE);
		tblclmnNewColumn.setWidth(205);
		tblclmnNewColumn.setText("Tên phim");
		
		Composite composite_2 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_2 = new GridLayout(1, false);
		gl_composite_2.horizontalSpacing = 4;
		gl_composite_2.marginTop = 10;
		gl_composite_2.marginWidth = 15;
		composite_2.setLayout(gl_composite_2);
		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite_2.heightHint = 369;
		gd_composite_2.widthHint = 398;
		composite_2.setLayoutData(gd_composite_2);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		btnChon = new Button(composite_2, SWT.NONE);
		btnChon.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					if(tableSuatChieu.getSelection()[0].getText(7)!="Đã chiếu")
						Window.open(new frmChonGhe(getDisplay(), tableSuatChieu.getSelection()[0].getText(1)));
					else Message.show("Suất chiếu này đã chiếu", "Lỗi", SWT.OK| SWT.ICON_ERROR, getShell());
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		GridData gd_btnChon = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnChon.widthHint = 86;
		btnChon.setLayoutData(gd_btnChon);
		btnChon.setText("Chọn");
		btnChon.setImage(SWTResourceManager.getImage("D:\\Document\\PROGRAMING\\PROJECT\\QuanLyHocVien\\Source code\\QuanLyHocVien\\Resources\\zoom_16x16.png"));
		
		TableViewer tableViewer = new TableViewer(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.setColumnProperties(new String[] {"Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "Địa chỉ", "CMND", "Email", "SĐT", "Chức vụ", "Ngày vào làm", "Trạng thái"});
		tableSuatChieu = tableViewer.getTable();
		tableSuatChieu.setLinesVisible(true);
		tableSuatChieu.setHeaderVisible(true);
		tableSuatChieu.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableColumn tableColumn = new TableColumn(tableSuatChieu, SWT.NONE);
		tableColumn.setWidth(50);
		tableColumn.setText("STT");
		
		TableColumn tableColumn_1 = new TableColumn(tableSuatChieu, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("Mã suất chiếu");
		
		TableColumn tableColumn_2 = new TableColumn(tableSuatChieu, SWT.NONE);
		tableColumn_2.setWidth(165);
		tableColumn_2.setText("Giờ chiếu");
		
		TableColumn tableColumn_3 = new TableColumn(tableSuatChieu, SWT.NONE);
		tableColumn_3.setWidth(114);
		tableColumn_3.setText("Định dạng");
		
		TableColumn tableColumn_4 = new TableColumn(tableSuatChieu, SWT.NONE);
		tableColumn_4.setWidth(118);
		tableColumn_4.setText("Hình thức");
		
		TableColumn tableColumn_5 = new TableColumn(tableSuatChieu, SWT.NONE);
		tableColumn_5.setWidth(113);
		tableColumn_5.setText("Ngôn ngữ");
		
		TableColumn tableColumn_6 = new TableColumn(tableSuatChieu, SWT.NONE);
		tableColumn_6.setWidth(112);
		tableColumn_6.setText("Phòng");
		
		TableColumn tableColumn_7 = new TableColumn(tableSuatChieu, SWT.NONE);
		tableColumn_7.setWidth(117);
		tableColumn_7.setText("Trạng thái");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	public void traCuu()
	{
		try {
			ArrayList<Phim> aPhim = SuatChieuController.traCuuPhim_theoNgay(DateF.toDate(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay()));
			tablePhim.removeAll();
			for(Phim p: aPhim)
			{
				TableItem item = new TableItem(tablePhim, SWT.NONE);
				item.setText(new String[] {String.valueOf(tablePhim.getItemCount()), p.getMaPhim(),p.getTenPhim()});
			}
			tablePhim.select(0);	
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void traCuuSuatChieu()
	{
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		
		try {
			ArrayList<SuatChieu> a = SuatChieuController.traCuu(tablePhim.getSelection()[0].getText(2), 
					DateF.toDate(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay()), DateF.toDate(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay()));
		
			tableSuatChieu.removeAll();
			for(SuatChieu sc : a)
			{
				String trangThai="Đã chiếu";
				if(sc.getTrangThai()==1) trangThai="Đang chiếu";
				if(sc.getTrangThai()==2) trangThai="Sắp chiếu";
				TableItem item = new TableItem(tableSuatChieu, SWT.NONE);
				item.setText(new String[] {String.valueOf(tableSuatChieu.getItemCount()), sc.getMaSuatChieu(),
						localDateFormat.format(sc.getThoiGianChieu()),sc.getDinhDang(),sc.getHinhThuc(),sc.getNgonNgu(),
						sc.getPhong(),trangThai
						});
			}
			tableSuatChieu.select(0);	
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
