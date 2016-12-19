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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.FillLayout;

public class frmChonGhe extends Shell {

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmChonGhe(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(101, 55, 201, 15);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setText("Vui lòng chọn ghế");
		
		Label lblThmSaNhn = new Label(this, SWT.NONE);
		lblThmSaNhn.setBounds(101, 26, 176, 23);
		lblThmSaNhn.setText("Bán vé");
		lblThmSaNhn.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblThmSaNhn.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblThmSaNhn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setBounds(30, 20, 64, 64);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/imgThucAn_64p.png"));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 549, 736, 56);
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setText("Lưu");
		btnLu.setBounds(281, 10, 94, 33);
		
		Button btnHyB = new Button(composite, SWT.NONE);
		btnHyB.setText("Hủy bỏ");
		btnHyB.setBounds(381, 10, 94, 33);
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_1.setBounds(10, 90, 712, 453);
		composite_1.setLayout(null);
		
		Label A1 = new Label(composite_1, SWT.NONE);
		A1.setBackground(SWTResourceManager.getColor(154, 205, 50));
		A1.setBounds(41, 59, 31, 31);
		
		Label A2 = new Label(composite_1, SWT.NONE);
		A2.setBackground(SWTResourceManager.getColor(154, 205, 50));
		A2.setBounds(78, 59, 31, 31);
		
		Label A3 = new Label(composite_1, SWT.NONE);
		A3.setBackground(SWTResourceManager.getColor(154, 205, 50));
		A3.setBounds(115, 59, 31, 31);
		
		Label A4 = new Label(composite_1, SWT.NONE);
		A4.setBackground(SWTResourceManager.getColor(154, 205, 50));
		A4.setBounds(152, 59, 31, 31);
		
		Label A5 = new Label(composite_1, SWT.NONE);
		A5.setBackground(SWTResourceManager.getColor(50, 205, 50));
		A5.setBounds(189, 59, 31, 31);
		
		Label label_19 = new Label(composite_1, SWT.NONE);
		label_19.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_19.setBounds(559, 59, 31, 31);
		
		Label label_20 = new Label(composite_1, SWT.NONE);
		label_20.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_20.setBounds(596, 59, 31, 31);
		
		Label label_21 = new Label(composite_1, SWT.NONE);
		label_21.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_21.setBounds(633, 59, 31, 31);
		
		Label label_22 = new Label(composite_1, SWT.NONE);
		label_22.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_22.setBounds(670, 59, 31, 31);
		
		Label label_23 = new Label(composite_1, SWT.NONE);
		label_23.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_23.setBounds(41, 96, 31, 31);
		
		Label label_24 = new Label(composite_1, SWT.NONE);
		label_24.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_24.setBounds(41, 133, 31, 31);
		
		Label label_25 = new Label(composite_1, SWT.NONE);
		label_25.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_25.setBounds(41, 170, 31, 31);
		
		Label label_26 = new Label(composite_1, SWT.NONE);
		label_26.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_26.setBounds(41, 207, 31, 31);
		
		Label label_27 = new Label(composite_1, SWT.NONE);
		label_27.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_27.setBounds(41, 244, 31, 31);
		
		Label label_28 = new Label(composite_1, SWT.NONE);
		label_28.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_28.setBounds(41, 281, 31, 31);
		
		Label label_29 = new Label(composite_1, SWT.NONE);
		label_29.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_29.setBounds(41, 318, 31, 31);
		
		Label label_30 = new Label(composite_1, SWT.NONE);
		label_30.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_30.setBounds(41, 355, 31, 31);
		
		Label label_32 = new Label(composite_1, SWT.NONE);
		label_32.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_32.setBounds(78, 96, 31, 31);
		
		Label label_33 = new Label(composite_1, SWT.NONE);
		label_33.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_33.setBounds(78, 133, 31, 31);
		
		Label label_34 = new Label(composite_1, SWT.NONE);
		label_34.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_34.setBounds(78, 170, 31, 31);
		
		Label label_35 = new Label(composite_1, SWT.NONE);
		label_35.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_35.setBounds(78, 207, 31, 31);
		
		Label label_36 = new Label(composite_1, SWT.NONE);
		label_36.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_36.setBounds(78, 244, 31, 31);
		
		Label label_37 = new Label(composite_1, SWT.NONE);
		label_37.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_37.setBounds(78, 281, 31, 31);
		
		Label label_38 = new Label(composite_1, SWT.NONE);
		label_38.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_38.setBounds(78, 318, 31, 31);
		
		Label label_39 = new Label(composite_1, SWT.NONE);
		label_39.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_39.setBounds(78, 355, 31, 31);
		
		Label label_41 = new Label(composite_1, SWT.NONE);
		label_41.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_41.setBounds(115, 96, 31, 31);
		
		Label label_42 = new Label(composite_1, SWT.NONE);
		label_42.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_42.setBounds(115, 133, 31, 31);
		
		Label label_43 = new Label(composite_1, SWT.NONE);
		label_43.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_43.setBounds(115, 170, 31, 31);
		
		Label label_44 = new Label(composite_1, SWT.NONE);
		label_44.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_44.setBounds(115, 207, 31, 31);
		
		Label label_45 = new Label(composite_1, SWT.NONE);
		label_45.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_45.setBounds(115, 244, 31, 31);
		
		Label label_46 = new Label(composite_1, SWT.NONE);
		label_46.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_46.setBounds(115, 281, 31, 31);
		
		Label label_47 = new Label(composite_1, SWT.NONE);
		label_47.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_47.setBounds(115, 318, 31, 31);
		
		Label label_48 = new Label(composite_1, SWT.NONE);
		label_48.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_48.setBounds(115, 355, 31, 31);
		
		Label label_50 = new Label(composite_1, SWT.NONE);
		label_50.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_50.setBounds(152, 96, 31, 31);
		
		Label label_51 = new Label(composite_1, SWT.NONE);
		label_51.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_51.setBounds(152, 133, 31, 31);
		
		Label label_52 = new Label(composite_1, SWT.NONE);
		label_52.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_52.setBounds(152, 170, 31, 31);
		
		Label label_53 = new Label(composite_1, SWT.NONE);
		label_53.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_53.setBounds(152, 207, 31, 31);
		
		Label label_54 = new Label(composite_1, SWT.NONE);
		label_54.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_54.setBounds(152, 244, 31, 31);
		
		Label label_55 = new Label(composite_1, SWT.NONE);
		label_55.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_55.setBounds(152, 281, 31, 31);
		
		Label label_56 = new Label(composite_1, SWT.NONE);
		label_56.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_56.setBounds(152, 318, 31, 31);
		
		Label label_57 = new Label(composite_1, SWT.NONE);
		label_57.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_57.setBounds(152, 355, 31, 31);
		
		Label label_59 = new Label(composite_1, SWT.NONE);
		label_59.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_59.setBounds(670, 96, 31, 31);
		
		Label label_60 = new Label(composite_1, SWT.NONE);
		label_60.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_60.setBounds(670, 133, 31, 31);
		
		Label label_61 = new Label(composite_1, SWT.NONE);
		label_61.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_61.setBounds(670, 170, 31, 31);
		
		Label label_62 = new Label(composite_1, SWT.NONE);
		label_62.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_62.setBounds(670, 207, 31, 31);
		
		Label label_63 = new Label(composite_1, SWT.NONE);
		label_63.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_63.setBounds(670, 244, 31, 31);
		
		Label label_64 = new Label(composite_1, SWT.NONE);
		label_64.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_64.setBounds(670, 281, 31, 31);
		
		Label label_65 = new Label(composite_1, SWT.NONE);
		label_65.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_65.setBounds(670, 318, 31, 31);
		
		Label label_66 = new Label(composite_1, SWT.NONE);
		label_66.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_66.setBounds(670, 355, 31, 31);
		
		Label label_68 = new Label(composite_1, SWT.NONE);
		label_68.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_68.setBounds(633, 96, 31, 31);
		
		Label label_69 = new Label(composite_1, SWT.NONE);
		label_69.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_69.setBounds(633, 133, 31, 31);
		
		Label label_70 = new Label(composite_1, SWT.NONE);
		label_70.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_70.setBounds(633, 170, 31, 31);
		
		Label label_71 = new Label(composite_1, SWT.NONE);
		label_71.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_71.setBounds(633, 207, 31, 31);
		
		Label label_72 = new Label(composite_1, SWT.NONE);
		label_72.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_72.setBounds(633, 244, 31, 31);
		
		Label label_73 = new Label(composite_1, SWT.NONE);
		label_73.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_73.setBounds(633, 281, 31, 31);
		
		Label label_74 = new Label(composite_1, SWT.NONE);
		label_74.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_74.setBounds(633, 318, 31, 31);
		
		Label label_75 = new Label(composite_1, SWT.NONE);
		label_75.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_75.setBounds(633, 355, 31, 31);
		
		Label label_77 = new Label(composite_1, SWT.NONE);
		label_77.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_77.setBounds(596, 96, 31, 31);
		
		Label label_78 = new Label(composite_1, SWT.NONE);
		label_78.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_78.setBounds(596, 133, 31, 31);
		
		Label label_79 = new Label(composite_1, SWT.NONE);
		label_79.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_79.setBounds(596, 170, 31, 31);
		
		Label label_80 = new Label(composite_1, SWT.NONE);
		label_80.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_80.setBounds(596, 207, 31, 31);
		
		Label label_81 = new Label(composite_1, SWT.NONE);
		label_81.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_81.setBounds(596, 244, 31, 31);
		
		Label label_82 = new Label(composite_1, SWT.NONE);
		label_82.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_82.setBounds(596, 281, 31, 31);
		
		Label label_83 = new Label(composite_1, SWT.NONE);
		label_83.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_83.setBounds(596, 318, 31, 31);
		
		Label label_84 = new Label(composite_1, SWT.NONE);
		label_84.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_84.setBounds(596, 355, 31, 31);
		
		Label label_86 = new Label(composite_1, SWT.NONE);
		label_86.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_86.setBounds(559, 96, 31, 31);
		
		Label label_87 = new Label(composite_1, SWT.NONE);
		label_87.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_87.setBounds(559, 133, 31, 31);
		
		Label label_88 = new Label(composite_1, SWT.NONE);
		label_88.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_88.setBounds(559, 170, 31, 31);
		
		Label label_89 = new Label(composite_1, SWT.NONE);
		label_89.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_89.setBounds(559, 207, 31, 31);
		
		Label label_90 = new Label(composite_1, SWT.NONE);
		label_90.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_90.setBounds(559, 244, 31, 31);
		
		Label label_91 = new Label(composite_1, SWT.NONE);
		label_91.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_91.setBounds(559, 281, 31, 31);
		
		Label label_92 = new Label(composite_1, SWT.NONE);
		label_92.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_92.setBounds(559, 318, 31, 31);
		
		Label label_93 = new Label(composite_1, SWT.NONE);
		label_93.setBackground(SWTResourceManager.getColor(154, 205, 50));
		label_93.setBounds(559, 355, 31, 31);
		
		Label label_10 = new Label(composite_1, SWT.NONE);
		label_10.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_10.setBounds(226, 59, 31, 31);
		
		Label label_11 = new Label(composite_1, SWT.NONE);
		label_11.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_11.setBounds(263, 59, 31, 31);
		
		Label label_12 = new Label(composite_1, SWT.NONE);
		label_12.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_12.setBounds(300, 59, 31, 31);
		
		Label label_13 = new Label(composite_1, SWT.NONE);
		label_13.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_13.setBounds(337, 59, 31, 31);
		
		Label label_14 = new Label(composite_1, SWT.NONE);
		label_14.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_14.setBounds(374, 59, 31, 31);
		
		Label label_15 = new Label(composite_1, SWT.NONE);
		label_15.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_15.setBounds(411, 59, 31, 31);
		
		Label label_16 = new Label(composite_1, SWT.NONE);
		label_16.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_16.setBounds(448, 59, 31, 31);
		
		Label label_17 = new Label(composite_1, SWT.NONE);
		label_17.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_17.setBounds(485, 59, 31, 31);
		
		Label label_18 = new Label(composite_1, SWT.NONE);
		label_18.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_18.setBounds(522, 59, 31, 31);
		
		Label label_31 = new Label(composite_1, SWT.NONE);
		label_31.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_31.setBounds(189, 96, 31, 31);
		
		Label label_40 = new Label(composite_1, SWT.NONE);
		label_40.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_40.setBounds(226, 96, 31, 31);
		
		Label label_49 = new Label(composite_1, SWT.NONE);
		label_49.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_49.setBounds(263, 96, 31, 31);
		
		Label label_58 = new Label(composite_1, SWT.NONE);
		label_58.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_58.setBounds(300, 96, 31, 31);
		
		Label label_67 = new Label(composite_1, SWT.NONE);
		label_67.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_67.setBounds(337, 96, 31, 31);
		
		Label label_76 = new Label(composite_1, SWT.NONE);
		label_76.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_76.setBounds(374, 96, 31, 31);
		
		Label label_85 = new Label(composite_1, SWT.NONE);
		label_85.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_85.setBounds(411, 96, 31, 31);
		
		Label label_94 = new Label(composite_1, SWT.NONE);
		label_94.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_94.setBounds(448, 96, 31, 31);
		
		Label label_95 = new Label(composite_1, SWT.NONE);
		label_95.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_95.setBounds(485, 96, 31, 31);
		
		Label label_96 = new Label(composite_1, SWT.NONE);
		label_96.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_96.setBounds(522, 96, 31, 31);
		
		Label label_97 = new Label(composite_1, SWT.NONE);
		label_97.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_97.setBounds(189, 133, 31, 31);
		
		Label label_98 = new Label(composite_1, SWT.NONE);
		label_98.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_98.setBounds(226, 133, 31, 31);
		
		Label label_99 = new Label(composite_1, SWT.NONE);
		label_99.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_99.setBounds(263, 133, 31, 31);
		
		Label label_100 = new Label(composite_1, SWT.NONE);
		label_100.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_100.setBounds(300, 133, 31, 31);
		
		Label label_101 = new Label(composite_1, SWT.NONE);
		label_101.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_101.setBounds(337, 133, 31, 31);
		
		Label label_102 = new Label(composite_1, SWT.NONE);
		label_102.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_102.setBounds(374, 133, 31, 31);
		
		Label label_103 = new Label(composite_1, SWT.NONE);
		label_103.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_103.setBounds(411, 133, 31, 31);
		
		Label label_104 = new Label(composite_1, SWT.NONE);
		label_104.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_104.setBounds(448, 133, 31, 31);
		
		Label label_105 = new Label(composite_1, SWT.NONE);
		label_105.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_105.setBounds(485, 133, 31, 31);
		
		Label label_106 = new Label(composite_1, SWT.NONE);
		label_106.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_106.setBounds(522, 133, 31, 31);
		
		Label label_107 = new Label(composite_1, SWT.NONE);
		label_107.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_107.setBounds(189, 170, 31, 31);
		
		Label label_108 = new Label(composite_1, SWT.NONE);
		label_108.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_108.setBounds(226, 170, 31, 31);
		
		Label label_109 = new Label(composite_1, SWT.NONE);
		label_109.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_109.setBounds(263, 170, 31, 31);
		
		Label label_110 = new Label(composite_1, SWT.NONE);
		label_110.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_110.setBounds(300, 170, 31, 31);
		
		Label label_111 = new Label(composite_1, SWT.NONE);
		label_111.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_111.setBounds(337, 170, 31, 31);
		
		Label label_112 = new Label(composite_1, SWT.NONE);
		label_112.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_112.setBounds(374, 170, 31, 31);
		
		Label label_113 = new Label(composite_1, SWT.NONE);
		label_113.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_113.setBounds(411, 170, 31, 31);
		
		Label label_114 = new Label(composite_1, SWT.NONE);
		label_114.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_114.setBounds(448, 170, 31, 31);
		
		Label label_115 = new Label(composite_1, SWT.NONE);
		label_115.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_115.setBounds(485, 170, 31, 31);
		
		Label label_116 = new Label(composite_1, SWT.NONE);
		label_116.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_116.setBounds(522, 170, 31, 31);
		
		Label label_117 = new Label(composite_1, SWT.NONE);
		label_117.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_117.setBounds(189, 207, 31, 31);
		
		Label label_118 = new Label(composite_1, SWT.NONE);
		label_118.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_118.setBounds(226, 207, 31, 31);
		
		Label label_119 = new Label(composite_1, SWT.NONE);
		label_119.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_119.setBounds(263, 207, 31, 31);
		
		Label label_120 = new Label(composite_1, SWT.NONE);
		label_120.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_120.setBounds(300, 207, 31, 31);
		
		Label label_121 = new Label(composite_1, SWT.NONE);
		label_121.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_121.setBounds(337, 207, 31, 31);
		
		Label label_122 = new Label(composite_1, SWT.NONE);
		label_122.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_122.setBounds(374, 207, 31, 31);
		
		Label label_123 = new Label(composite_1, SWT.NONE);
		label_123.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_123.setBounds(411, 207, 31, 31);
		
		Label label_124 = new Label(composite_1, SWT.NONE);
		label_124.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_124.setBounds(448, 207, 31, 31);
		
		Label label_125 = new Label(composite_1, SWT.NONE);
		label_125.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_125.setBounds(485, 207, 31, 31);
		
		Label label_126 = new Label(composite_1, SWT.NONE);
		label_126.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_126.setBounds(522, 207, 31, 31);
		
		Label label_127 = new Label(composite_1, SWT.NONE);
		label_127.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_127.setBounds(189, 244, 31, 31);
		
		Label label_128 = new Label(composite_1, SWT.NONE);
		label_128.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_128.setBounds(226, 244, 31, 31);
		
		Label label_129 = new Label(composite_1, SWT.NONE);
		label_129.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_129.setBounds(263, 244, 31, 31);
		
		Label label_130 = new Label(composite_1, SWT.NONE);
		label_130.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_130.setBounds(300, 244, 31, 31);
		
		Label label_131 = new Label(composite_1, SWT.NONE);
		label_131.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_131.setBounds(337, 244, 31, 31);
		
		Label label_132 = new Label(composite_1, SWT.NONE);
		label_132.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_132.setBounds(374, 244, 31, 31);
		
		Label label_133 = new Label(composite_1, SWT.NONE);
		label_133.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_133.setBounds(411, 244, 31, 31);
		
		Label label_134 = new Label(composite_1, SWT.NONE);
		label_134.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_134.setBounds(448, 244, 31, 31);
		
		Label label_135 = new Label(composite_1, SWT.NONE);
		label_135.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_135.setBounds(485, 244, 31, 31);
		
		Label label_136 = new Label(composite_1, SWT.NONE);
		label_136.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_136.setBounds(522, 244, 31, 31);
		
		Label label_137 = new Label(composite_1, SWT.NONE);
		label_137.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_137.setBounds(189, 281, 31, 31);
		
		Label label_138 = new Label(composite_1, SWT.NONE);
		label_138.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_138.setBounds(226, 281, 31, 31);
		
		Label label_139 = new Label(composite_1, SWT.NONE);
		label_139.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_139.setBounds(263, 281, 31, 31);
		
		Label label_140 = new Label(composite_1, SWT.NONE);
		label_140.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_140.setBounds(300, 281, 31, 31);
		
		Label label_141 = new Label(composite_1, SWT.NONE);
		label_141.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_141.setBounds(337, 281, 31, 31);
		
		Label label_142 = new Label(composite_1, SWT.NONE);
		label_142.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_142.setBounds(374, 281, 31, 31);
		
		Label label_143 = new Label(composite_1, SWT.NONE);
		label_143.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_143.setBounds(411, 281, 31, 31);
		
		Label label_144 = new Label(composite_1, SWT.NONE);
		label_144.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_144.setBounds(448, 281, 31, 31);
		
		Label label_145 = new Label(composite_1, SWT.NONE);
		label_145.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_145.setBounds(485, 281, 31, 31);
		
		Label label_146 = new Label(composite_1, SWT.NONE);
		label_146.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_146.setBounds(522, 281, 31, 31);
		
		Label label_147 = new Label(composite_1, SWT.NONE);
		label_147.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_147.setBounds(189, 318, 31, 31);
		
		Label label_148 = new Label(composite_1, SWT.NONE);
		label_148.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_148.setBounds(226, 318, 31, 31);
		
		Label label_149 = new Label(composite_1, SWT.NONE);
		label_149.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_149.setBounds(263, 318, 31, 31);
		
		Label label_150 = new Label(composite_1, SWT.NONE);
		label_150.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_150.setBounds(300, 318, 31, 31);
		
		Label label_151 = new Label(composite_1, SWT.NONE);
		label_151.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_151.setBounds(337, 318, 31, 31);
		
		Label label_152 = new Label(composite_1, SWT.NONE);
		label_152.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_152.setBounds(374, 318, 31, 31);
		
		Label label_153 = new Label(composite_1, SWT.NONE);
		label_153.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_153.setBounds(411, 318, 31, 31);
		
		Label label_154 = new Label(composite_1, SWT.NONE);
		label_154.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_154.setBounds(448, 318, 31, 31);
		
		Label label_155 = new Label(composite_1, SWT.NONE);
		label_155.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_155.setBounds(485, 318, 31, 31);
		
		Label label_156 = new Label(composite_1, SWT.NONE);
		label_156.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_156.setBounds(522, 318, 31, 31);
		
		Label label_157 = new Label(composite_1, SWT.NONE);
		label_157.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_157.setBounds(189, 355, 31, 31);
		
		Label label_158 = new Label(composite_1, SWT.NONE);
		label_158.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_158.setBounds(226, 355, 31, 31);
		
		Label label_159 = new Label(composite_1, SWT.NONE);
		label_159.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_159.setBounds(263, 355, 31, 31);
		
		Label label_160 = new Label(composite_1, SWT.NONE);
		label_160.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_160.setBounds(300, 355, 31, 31);
		
		Label label_161 = new Label(composite_1, SWT.NONE);
		label_161.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_161.setBounds(337, 355, 31, 31);
		
		Label label_162 = new Label(composite_1, SWT.NONE);
		label_162.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_162.setBounds(374, 355, 31, 31);
		
		Label label_163 = new Label(composite_1, SWT.NONE);
		label_163.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_163.setBounds(411, 355, 31, 31);
		
		Label label_164 = new Label(composite_1, SWT.NONE);
		label_164.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_164.setBounds(448, 355, 31, 31);
		
		Label label_165 = new Label(composite_1, SWT.NONE);
		label_165.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_165.setBounds(485, 355, 31, 31);
		
		Label label_166 = new Label(composite_1, SWT.NONE);
		label_166.setBackground(SWTResourceManager.getColor(50, 205, 50));
		label_166.setBounds(522, 355, 31, 31);
		
		Label label_167 = new Label(composite_1, SWT.NONE);
		label_167.setBackground(SWTResourceManager.getColor(221, 160, 221));
		label_167.setBounds(189, 392, 31, 31);
		
		Label label_177 = new Label(composite_1, SWT.NONE);
		label_177.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_177.setText(" 1");
		label_177.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_177.setBounds(41, 22, 31, 31);
		
		Label label_178 = new Label(composite_1, SWT.NONE);
		label_178.setText("  2");
		label_178.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_178.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_178.setBounds(78, 22, 31, 31);
		
		Label label_179 = new Label(composite_1, SWT.NONE);
		label_179.setText("  3");
		label_179.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_179.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_179.setBounds(115, 22, 31, 31);
		
		Label label_180 = new Label(composite_1, SWT.NONE);
		label_180.setText("  4");
		label_180.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_180.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_180.setBounds(152, 22, 31, 31);
		
		Label label_181 = new Label(composite_1, SWT.NONE);
		label_181.setText(" 5");
		label_181.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_181.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_181.setBounds(189, 22, 31, 31);
		
		Label label_182 = new Label(composite_1, SWT.NONE);
		label_182.setText("  6");
		label_182.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_182.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_182.setBounds(226, 22, 31, 31);
		
		Label label_183 = new Label(composite_1, SWT.NONE);
		label_183.setText("  7");
		label_183.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_183.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_183.setBounds(263, 22, 31, 31);
		
		Label label_184 = new Label(composite_1, SWT.NONE);
		label_184.setText("  8");
		label_184.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_184.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_184.setBounds(300, 22, 31, 31);
		
		Label label_185 = new Label(composite_1, SWT.NONE);
		label_185.setText(" 9");
		label_185.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_185.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_185.setBounds(337, 22, 31, 31);
		
		Label label_186 = new Label(composite_1, SWT.NONE);
		label_186.setText(" 10");
		label_186.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_186.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_186.setBounds(374, 22, 31, 31);
		
		Label label_187 = new Label(composite_1, SWT.NONE);
		label_187.setText(" 11");
		label_187.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_187.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_187.setBounds(411, 22, 31, 31);
		
		Label label_188 = new Label(composite_1, SWT.NONE);
		label_188.setText(" 12");
		label_188.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_188.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_188.setBounds(448, 22, 31, 31);
		
		Label label_189 = new Label(composite_1, SWT.NONE);
		label_189.setText(" 13");
		label_189.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_189.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_189.setBounds(485, 22, 31, 31);
		
		Label label_190 = new Label(composite_1, SWT.NONE);
		label_190.setText(" 14");
		label_190.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_190.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_190.setBounds(522, 22, 31, 31);
		
		Label label_191 = new Label(composite_1, SWT.NONE);
		label_191.setText(" 15");
		label_191.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_191.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_191.setBounds(559, 22, 31, 31);
		
		Label label_192 = new Label(composite_1, SWT.NONE);
		label_192.setText(" 16");
		label_192.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_192.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_192.setBounds(596, 22, 31, 31);
		
		Label label_193 = new Label(composite_1, SWT.NONE);
		label_193.setText(" 17");
		label_193.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_193.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_193.setBounds(633, 22, 31, 31);
		
		Label label_194 = new Label(composite_1, SWT.NONE);
		label_194.setText(" 18");
		label_194.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		label_194.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label_194.setBounds(670, 22, 31, 31);
		
		Label lblA = new Label(composite_1, SWT.NONE);
		lblA.setText(" A");
		lblA.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblA.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblA.setBounds(4, 59, 31, 31);
		
		Label lblB = new Label(composite_1, SWT.NONE);
		lblB.setText(" B");
		lblB.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblB.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblB.setBounds(4, 96, 31, 31);
		
		Label lblC = new Label(composite_1, SWT.NONE);
		lblC.setText(" C");
		lblC.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblC.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblC.setBounds(4, 133, 31, 31);
		
		Label lblD = new Label(composite_1, SWT.NONE);
		lblD.setText(" D");
		lblD.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblD.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblD.setBounds(4, 170, 31, 31);
		
		Label lblE = new Label(composite_1, SWT.NONE);
		lblE.setText(" E");
		lblE.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblE.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblE.setBounds(4, 207, 31, 31);
		
		Label lblF = new Label(composite_1, SWT.NONE);
		lblF.setText(" F");
		lblF.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblF.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblF.setBounds(4, 244, 31, 31);
		
		Label lblG = new Label(composite_1, SWT.NONE);
		lblG.setText(" G");
		lblG.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblG.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblG.setBounds(4, 281, 31, 31);
		
		Label lblH = new Label(composite_1, SWT.NONE);
		lblH.setText(" H");
		lblH.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblH.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblH.setBounds(4, 318, 31, 31);
		
		Label lblJ = new Label(composite_1, SWT.NONE);
		lblJ.setText(" I");
		lblJ.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblJ.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblJ.setBounds(4, 355, 31, 31);
		
		Label lblK = new Label(composite_1, SWT.NONE);
		lblK.setText(" J");
		lblK.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblK.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblK.setBounds(4, 392, 31, 31);
		
		Label lblNewLabel_4 = new Label(composite_1, SWT.NONE);
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(65, 105, 225));
		lblNewLabel_4.setBounds(41, 1, 660, 15);
		
		Label label_170 = new Label(composite_1, SWT.NONE);
		label_170.setBackground(SWTResourceManager.getColor(221, 160, 221));
		label_170.setBounds(263, 392, 31, 31);
		
		Label label_171 = new Label(composite_1, SWT.NONE);
		label_171.setBackground(SWTResourceManager.getColor(221, 160, 221));
		label_171.setBounds(300, 392, 31, 31);
		
		Label label_172 = new Label(composite_1, SWT.NONE);
		label_172.setBackground(SWTResourceManager.getColor(221, 160, 221));
		label_172.setBounds(337, 392, 31, 31);
		
		Label label_173 = new Label(composite_1, SWT.NONE);
		label_173.setBackground(SWTResourceManager.getColor(221, 160, 221));
		label_173.setBounds(374, 392, 31, 31);
		
		Label label_174 = new Label(composite_1, SWT.NONE);
		label_174.setBackground(SWTResourceManager.getColor(221, 160, 221));
		label_174.setBounds(411, 392, 31, 31);
		
		Label label_175 = new Label(composite_1, SWT.NONE);
		label_175.setBackground(SWTResourceManager.getColor(221, 160, 221));
		label_175.setBounds(448, 392, 31, 31);
		
		Label label_176 = new Label(composite_1, SWT.NONE);
		label_176.setBackground(SWTResourceManager.getColor(221, 160, 221));
		label_176.setBounds(485, 392, 31, 31);
		
		Label label_195 = new Label(composite_1, SWT.NONE);
		label_195.setBackground(SWTResourceManager.getColor(221, 160, 221));
		label_195.setBounds(522, 392, 31, 31);
		
		Label label_168 = new Label(composite_1, SWT.NONE);
		label_168.setBackground(SWTResourceManager.getColor(221, 160, 221));
		label_168.setBounds(226, 392, 31, 31);
		
		Composite composite_2 = new Composite(this, SWT.NONE);
		composite_2.setBounds(388, 26, 324, 56);
		composite_2.setLayout(null);
		
		Label lblNewLabel_1 = new Label(composite_2, SWT.NONE);
		lblNewLabel_1.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/refresh2_16x16.png"));
		lblNewLabel_1.setBounds(23, 32, 16, 16);
		
		Label lblNewLabel_2 = new Label(composite_2, SWT.NONE);
		lblNewLabel_2.setBounds(45, 32, 71, 15);
		lblNewLabel_2.setText("Ghế VIP");
		
		Label label = new Label(composite_2, SWT.NONE);
		label.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/refresh2_16x16.png"));
		label.setBounds(122, 32, 16, 16);
		
		Label lblGhi = new Label(composite_2, SWT.NONE);
		lblGhi.setText("Ghế đôi");
		lblGhi.setBounds(144, 32, 71, 15);
		
		Label label_5 = new Label(composite_2, SWT.NONE);
		label_5.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/refresh2_16x16.png"));
		label_5.setBounds(23, 10, 16, 16);
		
		Label lblt = new Label(composite_2, SWT.NONE);
		lblt.setText("Đã đặt");
		lblt.setBounds(45, 10, 71, 15);
		
		Label label_7 = new Label(composite_2, SWT.NONE);
		label_7.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/refresh2_16x16.png"));
		label_7.setBounds(122, 10, 16, 16);
		
		Label lblangChn = new Label(composite_2, SWT.NONE);
		lblangChn.setText("Đang chọn");
		lblangChn.setBounds(144, 10, 71, 15);
		
		Label label_2 = new Label(composite_2, SWT.NONE);
		label_2.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/refresh2_16x16.png"));
		label_2.setBounds(217, 32, 16, 16);
		
		Label label_3 = new Label(composite_2, SWT.NONE);
		label_3.setText("Ghế thường");
		label_3.setBounds(239, 32, 71, 15);
		
		Label label_169 = new Label(composite_2, SWT.NONE);
		label_169.setImage(ResourceManager.getPluginImage("QuanLyRapChieuPhim", "res/refresh2_16x16.png"));
		label_169.setBounds(217, 10, 16, 16);
		
		Label lblMnHnh = new Label(composite_2, SWT.NONE);
		lblMnHnh.setText("Màn hình");
		lblMnHnh.setBounds(239, 10, 71, 15);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Bán vé");
		setSize(739, 634);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
