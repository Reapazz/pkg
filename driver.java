package pkg;

import java.awt.SystemTray;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.WindowEvent;


import java.awt.AWTException;
import java.awt.BorderLayout;

import java.awt.FlowLayout;

import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.PopupMenu;

import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;




//import javafx.application.Platform;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.IOException;



public class driver {

	private static TrayIcon trayIcon = null;
	// static JFrame mf = new JFrame();

	static SystemTray tray = SystemTray.getSystemTray();

	public static JLabel counterTabs = new JLabel();
	public static JLabel tataStats = new JLabel();



	static JFrame mf = new JFrame();
	static JFrame info = new JFrame();	
	public static int shillCounter= 0;
	public static int shillCounter2= 0;
	public static int shillCounter3= 0;
	public static int shillCounter4= 0;
	

	public static void main(String[] args) throws InterruptedException, FontFormatException, IOException {
		
		info.setLocation(300, 100);
		info.setSize(400, 600);
		info.setTitle("About");

		webDriver tabs = new webDriver("1629758158", 0);
//		msg2Driver msg2 = new msg2Driver();
//		msg3Driver msg3 = new msg3Driver("1628123480", 55);
		msg4Driver msg4 = new msg4Driver("1630681778", 20);
//		


		System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
		mf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		mf.setLocation(300, 100);
		mf.setSize(550, 300);
		mf.setTitle("TATA User MSG Sender");

		Thread t1 = new Thread(new Runnable() {
			public void run() {

				try {

					tabs.run();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		

		Thread t4 = new Thread(new Runnable() {
			public void run() {

				try {

					msg4.run();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		
	
		
		

		// Toolkit t=Toolkit.getDefaultToolkit() ;
		Image bullimg = null;
		Image tataInstructions = null;
		try {
			bullimg = ImageIO.read(driver.class.getClassLoader().getResource("tatabull.jpg"));
			tataInstructions = ImageIO.read(driver.class.getClassLoader().getResource("info.jpg"));
			// Image bullImg = new
			// Image(driver.class.getClassLoader().getResource("tatabull.jpg"));// tray icon
			// bullimg = ImageIO.read(new File(".//res//tatabull.jpg"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Image bullimg=t.getImage("tatabull.jpg");
		// JLabel contentPane = new JLabel();
		// contentPane.setIcon( img );
		// contentPane.setLayout( new BorderLayout() );
		BackgroundPanel panel = new BackgroundPanel(bullimg);
		BackgroundPanel panel2 = new BackgroundPanel(tataInstructions);
		info.add(panel2);
		mf.add(panel);

		JButton start = new JButton("Start");
		JButton instructions = new JButton("HowkTo Use/About");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(instructions);
		panel.add(buttonPanel);

		counterTabs.setText("Total Shills: " + 0);

		mf.getContentPane().add(counterTabs, BorderLayout.NORTH);
		panel.add(tataStats, BorderLayout.SOUTH);

		mf.getContentPane().add(start, BorderLayout.SOUTH);

		mf.setVisible(true);

	
		mf.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				
				tabs.closeTabs();
				msg4.closeTabs();
				
				System.exit(0);
				// super.wait();

			}

			@SuppressWarnings("deprecation")
			public void windowIconified(WindowEvent e) {// Window minimized event

				mf.setVisible(false);
				info.hide();
				miniTray();

			}
		});

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"Running in background! \n IMPORTANT: To close the tabs simply close the TATA refresher application \n DO NOT close the broswers manually");
				// {

				t1.start();
				
				t4.start();
				
				

				// }
			}

		});

		instructions.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				if (info.isShowing()) {

					info.hide();
				} else {
					info.show();
				}
			}

		});

	}

	

	// String windows = JOptionPane.showInputDialog(null,"Please enter how many tabs
	// to refresh","TATA Refresher", JOptionPane.INFORMATION_MESSAGE);
	// int windowsint = Integer.parseInt(windows);

	private static void miniTray() {// Minimize the window to the taskbar tray

		ImageIcon trayImg = new ImageIcon(driver.class.getClassLoader().getResource("tatabull.jpg"));// tray icon// tray
																										// icon

		trayIcon = new TrayIcon(trayImg.getImage(), "TATA User Message Sender", new PopupMenu());
		trayIcon.setImageAutoSize(true);

		trayIcon.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 1) {// single click 1 double click 2

					tray.remove(trayIcon);
					mf.setVisible(true);
					mf.setExtendedState(JFrame.NORMAL);
					mf.toFront();
				}

			}

		});

		try {

			tray.add(trayIcon);

		} catch (AWTException e1) {
			e1.printStackTrace();
		}

	}

}
