package studentapp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import studentapp.dal.Entity.User;
import studentapp.dal.daoimpl.UserDaoImpl;

import java.awt.CardLayout;
import java.awt.Event;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField userPassword;
	private JTextField adminName;
	private JPasswordField adminPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginJFrame() {
		setTitle("\u767B\u9646\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		CardLayout cardLayout=new CardLayout();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu landingOptions = new JMenu("\u767B\u9646\u9009\u62E9");
		menuBar.add(landingOptions);
		
		JMenuItem adminOption = new JMenuItem("\u7BA1\u7406\u5458\u767B\u9646");
		adminOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.last(contentPane);
			}
		});
		landingOptions.add(adminOption);
		
		JMenuItem userOption = new JMenuItem("\u7528\u6237\u767B\u9646");
		userOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.first(contentPane);
			}
		});
		landingOptions.add(userOption);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);
		
		JPanel userPanel = new JPanel();
		contentPane.add(userPanel, "name_5600414879778");
		userPanel.setLayout(null);
		
		userName = new JTextField();
		userName.setBounds(148, 55, 122, 21);
		userPanel.add(userName);
		userName.setColumns(10);
		
		userPassword = new JPasswordField();
		userPassword.setBounds(148, 96, 122, 21);
		userPanel.add(userPassword);
		
		JButton userButton1 = new JButton("\u767B\u9646");
		userButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				userLoginActionPerformed(event);
			}
		});
		userButton1.setBounds(72, 159, 93, 23);
		userPanel.add(userButton1);
		
		JButton userButton2 = new JButton("\u6CE8\u518C");
		userButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				userRegisterActionPerformed(event);
			}
		});
		userButton2.setBounds(220, 159, 93, 23);
		userPanel.add(userButton2);
		
		JLabel lbll = new JLabel("\u7528\u6237\u540D\uFF1A");
		lbll.setBounds(72, 58, 54, 15);
		userPanel.add(lbll);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setBounds(72, 99, 54, 15);
		userPanel.add(label);
		
		JPanel adminPanel = new JPanel();
		contentPane.add(adminPanel, "name_5642638031832");
		adminPanel.setLayout(null);
		
		adminName = new JTextField();
		adminName.setBounds(190, 48, 129, 21);
		adminPanel.add(adminName);
		adminName.setColumns(10);
		
		adminPassword = new JPasswordField();
		adminPassword.setBounds(190, 91, 129, 21);
		adminPanel.add(adminPassword);
		
		JButton adminButton = new JButton("\u767B\u9646");
		adminButton.setBounds(152, 151, 93, 23);
		adminPanel.add(adminButton);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u540D\uFF1A");
		lblNewLabel.setBounds(79, 51, 101, 15);
		adminPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7BA1\u7406\u5458\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(79, 94, 101, 15);
		adminPanel.add(lblNewLabel_1);
		
	}
	private void userLoginActionPerformed(ActionEvent event) {
		 String uname=userName.getText();
	        String upassword=userPassword.getText();
	        UserDaoImpl userDaoImpl=new UserDaoImpl();
	        if(userDaoImpl.certifyUser(uname, upassword))
	        {
	            JOptionPane.showMessageDialog(this, "登录成功");
	            StudentJFrame studentJFrame=new StudentJFrame();
	            studentJFrame.setBounds(600, 400, 800, 600);
	            studentJFrame.setVisible(true);
	            this.setVisible(false);
	            this.dispose();
	        }
	        else
	        {
	            JOptionPane.showMessageDialog(this, "登录失败，账号或密码错误！","登陆学生管理系统",JOptionPane.ERROR_MESSAGE);
	        }
	}
	private void userRegisterActionPerformed(ActionEvent event) {
		String uname=userName.getText();
	     String upassword=userPassword.getText();
	     User user=new User(uname,upassword);
	     UserDaoImpl userDaoImpl=new UserDaoImpl();
	     if(userDaoImpl.addUser(user)) {
	    	 JOptionPane.showMessageDialog(this, "注册成功");
	     }
	     else {
	    	 JOptionPane.showMessageDialog(this, "注册失败!","注册学生管理系统",JOptionPane.ERROR_MESSAGE);
	     }
	}
	
}
