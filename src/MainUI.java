import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainUI {

	private JFrame frame;
	private JTextField txtSysUser;
	private Process prNetcat = null;
	private LinkedList SysUsers = new LinkedList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainUI() {
		initialize();
	}
	
	private Process runNetcat() {
		 try {
			 	if(prNetcat == null || (prNetcat != null && !prNetcat.isAlive())) {
			 		Runtime rt = Runtime.getRuntime();
					prNetcat = rt.exec("sudo netcat -l 4444");
			 	}
			 	return prNetcat;
			} catch (IOException err) {
				System.out.println(err.getMessage());
			}
		return null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 1005);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblSsh = new JLabel("SSH");
		GridBagConstraints gbc_lblSsh = new GridBagConstraints();
		gbc_lblSsh.insets = new Insets(0, 0, 5, 5);
		gbc_lblSsh.gridx = 0;
		gbc_lblSsh.gridy = 1;
		frame.getContentPane().add(lblSsh, gbc_lblSsh);
		
		final JButton btnStart = new JButton("Start");
		final JButton btnStop = new JButton("Stop");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnStart.setEnabled(false);
				btnStop.setEnabled(true);
				//TODO: Start SSH
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("sudo service ssh start");
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 1;
		gbc_btnStart.gridy = 1;
		frame.getContentPane().add(btnStart, gbc_btnStart);
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnStart.setEnabled(true);
				btnStop.setEnabled(false);
				//TODO: Stop SSH
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("sudo service ssh stop");
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop.gridx = 2;
		gbc_btnStop.gridy = 1;
		frame.getContentPane().add(btnStop, gbc_btnStop);
		
		JLabel lblFtp = new JLabel("FTP");
		GridBagConstraints gbc_lblFtp = new GridBagConstraints();
		gbc_lblFtp.insets = new Insets(0, 0, 5, 5);
		gbc_lblFtp.gridx = 0;
		gbc_lblFtp.gridy = 2;
		frame.getContentPane().add(lblFtp, gbc_lblFtp);
		
		final JButton btnStart_1 = new JButton("Start");
		final JButton btnStop_1 = new JButton("Stop");
		btnStart_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Start FTP
				btnStart_1.setEnabled(false);
				btnStop_1.setEnabled(true);
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("sudo service vsftpd start");
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnStart_1 = new GridBagConstraints();
		gbc_btnStart_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart_1.gridx = 1;
		gbc_btnStart_1.gridy = 2;
		frame.getContentPane().add(btnStart_1, gbc_btnStart_1);
		
		btnStop_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Stop FTP
				btnStart_1.setEnabled(true);
				btnStop_1.setEnabled(false);
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("sudo service vsftpd stop");
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnStop_1 = new GridBagConstraints();
		gbc_btnStop_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop_1.gridx = 2;
		gbc_btnStop_1.gridy = 2;
		frame.getContentPane().add(btnStop_1, gbc_btnStop_1);
		
		JLabel lblSql = new JLabel("SQL");
		GridBagConstraints gbc_lblSql = new GridBagConstraints();
		gbc_lblSql.insets = new Insets(0, 0, 5, 5);
		gbc_lblSql.gridx = 0;
		gbc_lblSql.gridy = 3;
		frame.getContentPane().add(lblSql, gbc_lblSql);
		
		final JButton btnStart_2 = new JButton("Start");
		final JButton btnStop_2 = new JButton("Stop");
		btnStart_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Start SQL
				btnStart_2.setEnabled(false);
				btnStop_2.setEnabled(true);
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("sudo service mysqld start");
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnStart_2 = new GridBagConstraints();
		gbc_btnStart_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart_2.gridx = 1;
		gbc_btnStart_2.gridy = 3;
		frame.getContentPane().add(btnStart_2, gbc_btnStart_2);
		
		btnStop_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Stop SQL
				btnStart_2.setEnabled(true);
				btnStop_2.setEnabled(false);
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("sudo service mysqld stop");
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnStop_2 = new GridBagConstraints();
		gbc_btnStop_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop_2.gridx = 2;
		gbc_btnStop_2.gridy = 3;
		frame.getContentPane().add(btnStop_2, gbc_btnStop_2);
		
		JLabel lblWww = new JLabel("WWW");
		GridBagConstraints gbc_lblWww = new GridBagConstraints();
		gbc_lblWww.insets = new Insets(0, 0, 5, 5);
		gbc_lblWww.gridx = 0;
		gbc_lblWww.gridy = 4;
		frame.getContentPane().add(lblWww, gbc_lblWww);
		
		final JButton btnStart_3 = new JButton("Start");
		final JButton btnStop_3 = new JButton("Stop");
		btnStart_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Start WWW
				btnStart_3.setEnabled(false);
				btnStop_3.setEnabled(true);
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("sudo service apache2 start");
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnStart_3 = new GridBagConstraints();
		gbc_btnStart_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart_3.gridx = 1;
		gbc_btnStart_3.gridy = 4;
		frame.getContentPane().add(btnStart_3, gbc_btnStart_3);
		
		btnStop_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Stop WWW
				btnStart_3.setEnabled(true);
				btnStop_3.setEnabled(false);
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("sudo service apache2 stop");
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnStop_3 = new GridBagConstraints();
		gbc_btnStop_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop_3.gridx = 2;
		gbc_btnStop_3.gridy = 4;
		frame.getContentPane().add(btnStop_3, gbc_btnStop_3);
		
		JLabel lblDns = new JLabel("DNS");
		GridBagConstraints gbc_lblDns = new GridBagConstraints();
		gbc_lblDns.insets = new Insets(0, 0, 5, 5);
		gbc_lblDns.gridx = 0;
		gbc_lblDns.gridy = 5;
		frame.getContentPane().add(lblDns, gbc_lblDns);
		
		final JButton btnStart_4 = new JButton("Start");
		final JButton btnStop_4 = new JButton("Stop");
		btnStart_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Start DNS
				btnStart_4.setEnabled(false);
				btnStop_4.setEnabled(true);
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("sudo service bind9 start");
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnStart_4 = new GridBagConstraints();
		gbc_btnStart_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart_4.gridx = 1;
		gbc_btnStart_4.gridy = 5;
		frame.getContentPane().add(btnStart_4, gbc_btnStart_4);
		
		btnStop_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Stop DNS
				btnStart_4.setEnabled(true);
				btnStop_4.setEnabled(false);
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("sudo service bind9 stop");
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnStop_4 = new GridBagConstraints();
		gbc_btnStop_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop_4.gridx = 2;
		gbc_btnStop_4.gridy = 5;
		frame.getContentPane().add(btnStop_4, gbc_btnStop_4);
		
		JLabel lblNetcat = new JLabel("Netcat");
		GridBagConstraints gbc_lblNetcat = new GridBagConstraints();
		gbc_lblNetcat.insets = new Insets(0, 0, 5, 5);
		gbc_lblNetcat.gridx = 0;
		gbc_lblNetcat.gridy = 6;
		frame.getContentPane().add(lblNetcat, gbc_lblNetcat);
		
		final JButton btnStart_5 = new JButton("Start");
		final JButton btnStop_5 = new JButton("Stop");
		btnStart_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Start Netcat
				btnStart_5.setEnabled(false);
				btnStop_5.setEnabled(true);
				try {
				 	if(prNetcat == null || (prNetcat != null && !prNetcat.isAlive())) {
				 		Runtime rt = Runtime.getRuntime();
						prNetcat = rt.exec("sudo netcat -l 4444");
				 	}
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
				
			}
		});
		GridBagConstraints gbc_btnStart_5 = new GridBagConstraints();
		gbc_btnStart_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart_5.gridx = 1;
		gbc_btnStart_5.gridy = 6;
		frame.getContentPane().add(btnStart_5, gbc_btnStart_5);
		
		btnStop_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Stop Netcat
				btnStart_5.setEnabled(true);
				btnStop_5.setEnabled(false);
				if(prNetcat != null) {
					prNetcat.destroyForcibly();
				}
				try {
				 	if(prNetcat != null) {
				 		Runtime rt = Runtime.getRuntime();
						prNetcat = rt.exec("sudo pkill netcat");
				 	}
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnStop_5 = new GridBagConstraints();
		gbc_btnStop_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop_5.gridx = 2;
		gbc_btnStop_5.gridy = 6;
		frame.getContentPane().add(btnStop_5, gbc_btnStop_5);
		
		JLabel lblSysUser = new JLabel("Sys User");
		GridBagConstraints gbc_lblSysUser = new GridBagConstraints();
		gbc_lblSysUser.insets = new Insets(0, 0, 0, 5);
		gbc_lblSysUser.gridx = 0;
		gbc_lblSysUser.gridy = 7;
		frame.getContentPane().add(lblSysUser, gbc_lblSysUser);
		
		final JButton btnAdd = new JButton("Add");
		final JButton btnRemove = new JButton("Remove");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Add Sys User
				//delimit txtSysUser
				//add users to a list in UI for record
				btnAdd.setEnabled(false);
				btnRemove.setEnabled(true);
				String user = txtSysUser.getText();
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("sudo useradd -u 12345 -g users -d /home/" + user + " -s /bin/bash -p 'password' " + user);
					SysUsers.add(user);
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 7;
		frame.getContentPane().add(btnAdd, gbc_btnAdd);
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Remove Sys User
				btnAdd.setEnabled(true);
				btnRemove.setEnabled(false);
				String user = txtSysUser.getText();
				try {
					Runtime rt = Runtime.getRuntime();
					Process pr = rt.exec("sudo deluser " + user);
					for(Object uname : SysUsers) {
						SysUsers.remove(uname);
					}
				} catch (IOException err) {
					System.out.println(err.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemove.gridx = 2;
		gbc_btnRemove.gridy = 7;
		frame.getContentPane().add(btnRemove, gbc_btnRemove);
		
		txtSysUser = new JTextField();
		GridBagConstraints gbc_txtSysUser = new GridBagConstraints();
		gbc_txtSysUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSysUser.gridx = 3;
		gbc_txtSysUser.gridy = 7;
		frame.getContentPane().add(txtSysUser, gbc_txtSysUser);
		txtSysUser.setColumns(10);
	}

}
