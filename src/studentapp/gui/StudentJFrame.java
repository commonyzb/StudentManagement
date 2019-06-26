package studentapp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import studentapp.dal.Entity.Student;
import studentapp.dal.daoimpl.StudentDaoImpl;

public class StudentJFrame extends JFrame {

	private JPanel contentPane;
	private List<String> cols;
    private List<Student> rows;
    private StudentDaoImpl studentDaoImpl;
    private SimpleTableModel<Student> simpleTableModel;
    private JTable jTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentJFrame frame = new StudentJFrame();
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
	public StudentJFrame() {
		setTitle("\u5B66\u751F\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cols=new ArrayList<>();
        cols.add("ID");
        cols.add("姓名");
        cols.add("年龄");
        cols.add("地址");
        cols.add("学号");
        cols.add("联系方式");       
        studentDaoImpl=new StudentDaoImpl();
        rows=studentDaoImpl.getAllStudent();
        simpleTableModel=new SimpleTableModel<Student>(cols,rows);
    	
        JLabel jLabel = new JLabel();
        jLabel.setText("学生管理系统");      
        jLabel.setFont(new Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);        
        getContentPane().add(jLabel, BorderLayout.PAGE_START);
        JScrollPane jScrollPane = new JScrollPane();
        jTable = new JTable();
/*        
        jTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
*/
        jTable.setModel(simpleTableModel);
        jScrollPane.setViewportView(jTable);
        getContentPane().add(jScrollPane, BorderLayout.CENTER);
            
        JLabel jLabel2 = new JLabel();
        jLabel2.setText("状态栏");
        getContentPane().add(jLabel2, BorderLayout.PAGE_END);
        
        JMenuBar jMenuBar = new JMenuBar();
        
        JMenu file = new JMenu();
        file.setText("文件");
        	JMenuItem saveAsXML = new JMenuItem();
        		saveAsXML.setText("存为XML");
        		file.add(saveAsXML);
        	JMenuItem saveAsExcel = new JMenuItem();
        		saveAsExcel.setText("存为Excel");
        	file.add(saveAsExcel);
        	JMenuItem quit = new JMenuItem();
        	quit.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			quitActionPerformed(e);
        		}
        	});
        		quit.setText("退出");
        		file.add(quit);
        jMenuBar.add(file);
        
        JMenu edit = new JMenu();
        	edit.setText("编辑");
        	edit.setToolTipText("");
        	JMenuItem insert = new JMenuItem();
        		insert.setText("插入");
        		insert.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        insertStudentActionPerformed(evt);
                    }
                });
        	edit.add(insert);
        
        	JMenuItem update = new JMenuItem();
        		update.setText("更新");
        		update.addActionListener(new java.awt.event.ActionListener() {
        			public void actionPerformed(ActionEvent evt) {
        				updateStudentActionPerformed(evt);
        			}
        		});
        	edit.add(update);
        
        	JMenuItem refresh = new JMenuItem();
        	refresh.setText("刷新");
        	refresh.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent evt) {
        			refreshActionPerformed(evt);
        		}
        	});
        	edit.add(refresh);
        jMenuBar.add(edit);
        
        JMenuItem delete = new JMenuItem("\u5220\u9664");
        delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		delStudentActionPerformed(e);
        	}
        });
        edit.add(delete);
        
        JMenu query = new javax.swing.JMenu();
        	query.setText("查询");
        	JMenuItem queryAll = new JMenuItem();
        	queryAll.setText("查询所有");
        	queryAll.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					queryAllActionPerformed(e);
				}
			});
        query.add(queryAll);
        
        	JMenu classifiedQuery = new JMenu();
        	classifiedQuery.setText("分类查询");
        		JMenuItem queryBySno = new JMenuItem();
        		queryBySno.setText("按学号查");
        	classifiedQuery.add(queryBySno);
        		JMenuItem queryByName = new JMenuItem();
        		queryByName.setText("按姓名查");
        	classifiedQuery.add(queryByName);       
        		JMenuItem queryByID = new JMenuItem();
        		queryByID.setText("按id查");
                queryByID.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        queryByIDActionPerformed(evt);
                    }
                });
            classifiedQuery.add(queryByID);
        query.add(classifiedQuery);
        jMenuBar.add(query);
        
        JMenu statistics = new JMenu();
        statistics.setText("统计");
        jMenuBar.add(statistics);
        
        JMenu help = new JMenu();
        help.setText("帮助");
        	JMenuItem about = new JMenuItem();
        	about.setText("关于");
        	about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        help.add(about);         
        jMenuBar.add(help);         
        setJMenuBar(jMenuBar);  
        pack();
	}
	
	 private void aboutActionPerformed(ActionEvent evt) {
		 JOptionPane.showMessageDialog(this, "学生管理系统 ver 1.2.0\n\n  版权：yzb","关于学生管理系统",JOptionPane.PLAIN_MESSAGE);
	 }

	 private void insertStudentActionPerformed(ActionEvent evt) {
	     new InsertStudentJFrame().setVisible(true);
	 }

	 private void refreshActionPerformed(ActionEvent evt) {
		 rows=studentDaoImpl.getAllStudent();
	     simpleTableModel.setRows(rows);
	     simpleTableModel.fireTableDataChanged();
	 }
	 
	 private void updateStudentActionPerformed(ActionEvent evt) {
		 try {
			 	rows=studentDaoImpl.getAllStudent();
			 	simpleTableModel.setRows(rows);
				Student student=rows.get(jTable.getSelectedRow());
				new UpdateStudentJFrame(student).setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "请选中具体学生...","更新学生信息",JOptionPane.ERROR_MESSAGE);
		}    	             
	 }
	 
	 private void queryByIDActionPerformed(ActionEvent evt) {
		 rows=studentDaoImpl.getAllStudent();
	     simpleTableModel.setRows(rows);
		 new QueryByIDJFrame(jTable).setVisible(true);
	 }
	 
	 private void delStudentActionPerformed(ActionEvent actionEvent) {		 
	     try {
			Student student=rows.get(jTable.getSelectedRow());
			studentDaoImpl.delStudentbyID(student.getSid());
			rows=studentDaoImpl.getAllStudent();
		    simpleTableModel.setRows(rows);
		    simpleTableModel.fireTableDataChanged();
		    JOptionPane.showMessageDialog(this, "删除成功", "删除学生信息", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "删除失败!请选中学生...", "删除学生信息", JOptionPane.ERROR_MESSAGE);
		}
	 }
	 
	 private void quitActionPerformed(ActionEvent actionEvent) {
		 this.setVisible(false);
		 this.dispose();
	 }
	 private void queryAllActionPerformed(ActionEvent actionEvent) {
		 rows=studentDaoImpl.getAllStudent();
	     simpleTableModel.setRows(rows);
	     simpleTableModel.fireTableDataChanged();
	 }
}
