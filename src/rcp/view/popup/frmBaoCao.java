package rcp.view.popup;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JRootPane;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.cj.mysqlx.protobuf.MysqlxNotice.Frame;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import rcp.util.Database;
import rcp.util.DateF;
import rcp.util.Message;
import rcp.util.Window;
import rcp.view.popup.frmBaoCao;

import org.eclipse.swt.layout.FillLayout;

public class frmBaoCao extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */

    HashMap hm = null;
    Connection con = null;
    String reportName;
    

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmBaoCao(Display display,HashMap map ,Connection con,String rptName) {
		super(display, SWT.SHELL_TRIM);
		this.hm = map;
        this.con = con;
        this.reportName = rptName;
        setLayout(new FillLayout(SWT.HORIZONTAL));

		createContents();
		callReport();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Xem trước");
		setSize(576, 383);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
 
  
 
    public void callReport() {
        JasperPrint jasperPrint = generateReport();
        //initialize JRViewer object 
        JRViewer jasperviewer = new JRViewer(jasperPrint);

        //add the SWT_AWT compposite for SWING contents of GUI              
        final Composite swtAwtComposite = new Composite(this, SWT.EMBEDDED);
        swtAwtComposite.setBounds(10, 0, 767, 600);

        java.awt.Frame frame = SWT_AWT.new_Frame(swtAwtComposite);

        Panel panel = new Panel();
        frame.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JRootPane rootPane = new JRootPane();
        rootPane.setSize(767, 600);
        panel.add(rootPane);

        //Define a container yourself
        Container c = rootPane.getContentPane();

        //Add the JRViewer object onto the container to render in GUI
        c.add(jasperviewer);
       
    }
 
    public void callConnectionLessReport() {
        JasperPrint jasperPrint = generateEmptyDataSourceReport();
      //initialize JRViewer object 
        JRViewer jasperviewer = new JRViewer(jasperPrint);

        //add the SWT_AWT compposite for SWING contents of GUI              
        final Composite swtAwtComposite = new Composite(this, SWT.EMBEDDED);
        swtAwtComposite.setBounds(10, 0, 767, 600);

        java.awt.Frame frame = SWT_AWT.new_Frame(swtAwtComposite);

        Panel panel = new Panel();
        frame.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JRootPane rootPane = new JRootPane();
        rootPane.setSize(767, 600);
        panel.add(rootPane);

        //Define a container yourself
        Container c = rootPane.getContentPane();

        //Add the JRViewer object onto the container to render in GUI
        c.add(jasperviewer);
       
    }
 
    public void closeReport() {
        //jasperViewer.setVisible(false);
    }
 
    /** this method will call the report from data source*/
    public JasperPrint generateReport() {
        try {
            if (con == null) {
                try {
                    con = Database.connect();
 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            JasperPrint jasperPrint = null;
            if (hm == null) {
                hm = new HashMap();
   
            }
            try {
                /**You can also test this line if you want to display 
                 * report from any absolute path other than the project root path*/
             
                jasperPrint = JasperFillManager.fillReport(reportName + ".jasper", hm, con);
            } catch (JRException e) {
                e.printStackTrace();
            }
            return jasperPrint;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
 
 
    }
 
    /** call this method when your report has an empty data source*/
    public JasperPrint generateEmptyDataSourceReport() {
        try {
            JasperPrint jasperPrint = null;
            if (hm == null) {
                hm = new HashMap();
               // hm.put("v_maHD", v_maHD);
                
            }
            try {
                jasperPrint = JasperFillManager.fillReport(reportName + ".jasper", hm, new JREmptyDataSource());
            } catch (JRException e) {
                e.printStackTrace();
            }
            return jasperPrint;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
    
  
}