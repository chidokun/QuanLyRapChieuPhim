package rcp;

import java.io.*;
import java.util.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;
import rcp.view.popup.*;
import rcp.util.*;
import rcp.view.*;

public class Application {
	private static Display display = Display.getDefault();
	private static frmMain shellMain = new frmMain(display);
	private static int result;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			if (ketNoiCSDL())
				dangNhap();
			else 
				ketNoiLai();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean ketNoiCSDL() {
		try {
			Settings.load();
			Database.load();
			Database.connect();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void dangNhap() throws IOException {
		//hiện form đăng nhập
		frmDangNhap shell = new frmDangNhap(display);
		shell.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
				result = frmDangNhap.result;
			}
		});
		shell.open();
		shell.layout();
		
		//vòng lặp thông diệp
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		//đăng nhập được thì hiển thị giao diện
		if(result == SWT.OK)
			hienThiGiaoDien();
		else
			shellMain.close();
	}

	public static void hienThiGiaoDien() {
		shellMain.open();
		shellMain.layout();
		
		while (!shellMain.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public static void ketNoiLai() {
		//hiện form kết nối lại
		frmKetNoiCSDL shell = new frmKetNoiCSDL(display);
		shell.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
				result = shell.result;
			}
		});
		shell.open();
		shell.layout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		switch (result) {
		case SWT.OK:
			if (SWT.YES == Message.show("Bạn có muốn khởi động lại chương trình ngay?",
					"Khởi động lại chương trình", SWT.ICON_QUESTION | SWT.YES | SWT.NO, shellMain))
				restart();
			break;
		case SWT.CANCEL:
			Message.show("Bạn có thể cài đặt lại kết nối cơ sở dữ liệu khi chạy lại chương trình.",
					"Kết nối cơ sở dữ liệu", SWT.ICON_INFORMATION | SWT.OK, shellMain);
		}
	}
	
	public static void restart() {
		try {
			final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
			final File currentJar = new File(
					Application.class.getProtectionDomain().getCodeSource().getLocation().toURI());

			if (!currentJar.getName().endsWith(".jar"))
				return;

			final ArrayList<String> command = new ArrayList<String>();
			command.add(javaBin);
			command.add("-jar");
			command.add(currentJar.getPath());

			final ProcessBuilder builder = new ProcessBuilder(command);
			builder.start();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
