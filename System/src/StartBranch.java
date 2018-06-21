import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class StartBranch extends JPanel implements ActionListener {

	Box baseBox,box1,box2,box3,box4;
	
	JLabel jLabel1;
	JTextField jTextField2;
	JLabel jLabel3;
	JTextField jTextField4;
	
	JButton jButton1;
	JButton jButton2;
	JButton jButton3;
	
	JTable TableStus;	
	
	StartBranch(){
		jLabel1 = new JLabel("部门编号");
		jLabel3 = new JLabel("部门名称");
		
		jTextField2 = new JTextField(25);
		jTextField4 = new JTextField(25);
		
		jButton1 = new JButton("添加");
		jButton2 = new JButton("重置");
		jButton3 = new JButton("删除");	
		
		TableStus = new JTable();
		TableStus.getTableHeader().setFont(new Font("宋体", Font.BOLD, 16));
		TableStus.setFont(new Font("宋体", 0, 16));		
		
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		jButton3.addActionListener(this);
		
		box1 = Box.createHorizontalBox();
		box1.add(jLabel1);
		box1.add(Box.createHorizontalStrut(15));
		box1.add(jTextField2);		
		
		box2 = Box.createHorizontalBox();
		box2.add(jLabel3);
		box2.add(Box.createHorizontalStrut(15));
		box2.add(jTextField4);	
		
		box3 = Box.createHorizontalBox();
		box3.add(jButton1);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(jButton2);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(jButton3);
		
		box4 = Box.createHorizontalBox();
		//box4.add(new JScrollPane(TableStus));	
	    //this.tableInitialize();
		//this.setLayout(new BorderLayout());
		//this.add(new JScrollPane(TableStus), BorderLayout.CENTER);
		ImageIcon bgim = new ImageIcon("./main.jpg");
		JLabel bg = new JLabel(bgim);// 设置图标用于背景

		bg.setSize(452, 402);// 设置bg为界面大小
		bgim.setImage(bgim.getImage().getScaledInstance(bg.getSize().width,
				bg.getSize().height, Image.SCALE_DEFAULT));// 图片缩放

		box4.add(bg, new Integer(Integer.MIN_VALUE));	
		
		baseBox = Box.createVerticalBox();

		baseBox.add(Box.createVerticalStrut(30));		
		baseBox.add(box1);
		baseBox.add(Box.createVerticalStrut(30));
		baseBox.add(box2);
		baseBox.add(Box.createVerticalStrut(30));
		baseBox.add(box3);
		baseBox.add(Box.createVerticalStrut(30));
		baseBox.add(box4);	
		this.add(baseBox);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//添加
		if(e.getSource()==this.jButton1){
			inserIntoOracle(jTextField2.getText(),jTextField4.getText());
		}
		
		//重置
		if(e.getSource()==this.jButton2){
			jTextField2.setText("");
			jTextField4.setText("");
		}
		
		//删除
		if(e.getSource()==this.jButton3){
			deleteFromOracle(jTextField2.getText());
		}		
	}
	void deleteFromOracle(String s) {
		JDBCFile conn = new JDBCFile();
		if(s.toString().isEmpty()){
			JOptionPane.showMessageDialog(null, "删除失败，部门编号不能为空", "错误提示", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql="delete from 部门表  where 部门编号='"+s+"'"; 
		String sql2="select * from 部门表  where 部门编号='"+s+"'";
		int count = -1;
		ResultSet res=conn.executeQuery(sql2);
		try {
			if(res.next()){
			    count = conn.executeUpdate(sql);
				jTextField2.setText("");
				jTextField4.setText("");
				//if(count!=-1)
					JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败", "提示", JOptionPane.PLAIN_MESSAGE);
		}

			//else JOptionPane.showMessageDialog(null, "删除失败", "提示", JOptionPane.PLAIN_MESSAGE);		
	}
	
	void inserIntoOracle(String s2,String s4){
		
		JDBCFile conn = new JDBCFile();
		if(s2.toString().isEmpty()){
			JOptionPane.showMessageDialog(null, "添加失败，部门编号不能为空", "错误提示", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql="insert into 部门表  values('"+s2+"','"+s4+"')";	
		conn.executeUpdate(sql);
		//jTextField2.setText("");
		//jTextField4.setText("");
		JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.PLAIN_MESSAGE);
	}
	
	

}
