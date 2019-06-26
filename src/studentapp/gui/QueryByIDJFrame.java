package studentapp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import studentapp.dal.Entity.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class QueryByIDJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idJTextField;
	private JTable jTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryByIDJFrame frame = new QueryByIDJFrame();
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
	public QueryByIDJFrame() {
		setTitle("\u8F93\u5165ID\u67E5\u8BE2\u5B66\u751F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("宋体", Font.PLAIN, 16));
		lblId.setBounds(91, 48, 54, 15);
		contentPane.add(lblId);
		
		idJTextField = new JTextField();
		idJTextField.setBounds(155, 46, 166, 21);
		contentPane.add(idJTextField);
		idJTextField.setColumns(10);
		
		JButton buttonSearch = new JButton("\u67E5\u8BE2");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchActionPerformed(e);
			}
		});
		buttonSearch.setBounds(169, 96, 93, 23);
		contentPane.add(buttonSearch);
	}
	
	public QueryByIDJFrame(JTable jTable) throws HeadlessException {
		super();
		this.jTable = jTable;
		setTitle("\u8F93\u5165ID\u67E5\u8BE2\u5B66\u751F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("宋体", Font.PLAIN, 16));
		lblId.setBounds(91, 48, 54, 15);
		contentPane.add(lblId);
		
		idJTextField = new JTextField();
		idJTextField.setBounds(155, 46, 166, 21);
		contentPane.add(idJTextField);
		idJTextField.setColumns(10);
		
		JButton buttonSearch = new JButton("\u67E5\u8BE2");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchActionPerformed(e);
			}
		});
		buttonSearch.setBounds(169, 96, 93, 23);
		contentPane.add(buttonSearch);
	}

	private void SearchActionPerformed(ActionEvent event) {
		try {
			jTable.clearSelection();
			int id=Integer.parseInt(this.idJTextField.getText());
			SimpleTableModel<Student> simpleTableModel=(SimpleTableModel<Student>)jTable.getModel();
			List<Student> rows=simpleTableModel.getRows();			
			int index=-1;
			for(int i=0;i<rows.size();i++)
			{
				if(id==rows.get(i).getSid()) index=i;
			}
			if(index==-1) {
				JOptionPane.showMessageDialog(this, "未找到学生！", "查询学生信息",JOptionPane.WARNING_MESSAGE );
			}
			else {
				jTable.changeSelection(index, 0, false, false);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "查询失败！", "查询学生信息",JOptionPane.ERROR_MESSAGE );
		}
		
	}
}
