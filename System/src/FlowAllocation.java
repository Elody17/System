import java.awt.BorderLayout;
import java.awt.Container;
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

public class FlowAllocation extends JPanel implements ActionListener {
	
	Box baseBox,box1,box2,box3,box4,box5,box6,box0;
	
	JLabel jLabel1;
	JTextField jTextField2;
	JLabel jLabel3;
	JTextField jTextField4;
	
	JLabel jLabel5;
	JTextField jTextField6;
	JLabel jLabel7;
	JTextField jTextField8;

	JLabel jLabel9;
	JTextField jTextField10;
	
	JButton jButton1;
	JButton jButton2;
	JButton jButton3;
	
	JTable TableStus;
	
	FlowAllocation(){
		
		jLabel1 = new JLabel("资产代码:");
		jLabel3 = new JLabel("调入部门编号:");
		jLabel5 = new JLabel("调拨日期:");
		jLabel7 = new JLabel("调出部门编号:");
		jLabel9 = new JLabel("经办人:");

		
		jTextField2 = new JTextField(15);
		jTextField4 = new JTextField(15);
		jTextField6 = new JTextField(15);
		jTextField8 = new JTextField(15);
		jTextField10 = new JTextField(15);

	
		jButton1 = new JButton("保存");
		jButton2 = new JButton("重置");
		jButton3 = new JButton("删除");
		
		TableStus = new JTable();
		TableStus.getTableHeader().setFont(new Font("宋体", Font.BOLD, 16));
		TableStus.setFont(new Font("宋体", 0, 16));
		
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		jButton3.addActionListener(this);

		box0 = Box.createHorizontalBox();
		box1 = Box.createHorizontalBox();
		box1.add(jLabel1);
		box1.add(Box.createHorizontalStrut(10));
		box1.add(jTextField2);
		box1.add(Box.createHorizontalStrut(40));
		box1.add(jLabel3);
		box1.add(Box.createHorizontalStrut(10));
		box1.add(jTextField4);		
	
		box2 = Box.createHorizontalBox();
		box2.add(jLabel5);
		box2.add(Box.createHorizontalStrut(10));
		box2.add(jTextField6);
		box2.add(Box.createHorizontalStrut(40));
		box2.add(jLabel7);
		box2.add(Box.createHorizontalStrut(10));
		box2.add(jTextField8);	
		
		box3 = Box.createHorizontalBox();
		box3.add(jLabel9);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(jTextField10);
		box3.add(Box.createHorizontalStrut(40));
	
		
		

		box4 = Box.createHorizontalBox();
		box4.add(jButton1);
		box4.add(Box.createHorizontalStrut(20));
		box4.add(jButton2);
		box4.add(Box.createHorizontalStrut(20));
		box4.add(jButton3);
		
		box5 = Box.createHorizontalBox();
		//box6.add(new JScrollPane(TableStus));	
	    //this.tableInitialize();
		//this.setLayout(new BorderLayout());
		//this.add(new JScrollPane(TableStus), BorderLayout.CENTER);
		ImageIcon bgim = new ImageIcon("./main.jpg");
		JLabel bg = new JLabel(bgim);// 设置图标用于背景

		bg.setSize(507, 402);// 设置bg为界面大小
		bgim.setImage(bgim.getImage().getScaledInstance(bg.getSize().width,
				bg.getSize().height, Image.SCALE_DEFAULT));// 图片缩放


		box5.add(bg, new Integer(Integer.MIN_VALUE));
		
		baseBox = Box.createVerticalBox();
		baseBox.add(box0);
		baseBox.add(Box.createVerticalStrut(15));		
		baseBox.add(box1);
		baseBox.add(Box.createVerticalStrut(15));
		baseBox.add(box2);
		baseBox.add(Box.createVerticalStrut(15));
		baseBox.add(box3);
		baseBox.add(Box.createVerticalStrut(15));
		baseBox.add(box4);
		baseBox.add(Box.createVerticalStrut(15));
		baseBox.add(box5);
		baseBox.add(Box.createVerticalStrut(15));
	
		this.add(baseBox);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//添加
		if(e.getSource()==this.jButton1){
			inserIntoOracle(jTextField2.getText(),jTextField4.getText(),jTextField6.getText(),
					jTextField8.getText(),jTextField10.getText());
		}
		
		//重置
		if(e.getSource()==this.jButton2){
			jTextField2.setText("");
			jTextField4.setText("");
			jTextField6.setText("");
			jTextField8.setText("");
			jTextField10.setText("");

		}
		
		//删除
		if(e.getSource()==this.jButton3){
			deleteFromOracle(jTextField2.getText());
		}
		
	}
	void deleteFromOracle(String s){
		
		JDBCFile conn = new JDBCFile();
		if(s.toString().isEmpty()){
			JOptionPane.showMessageDialog(null, "删除失败，资产代码不能为空", "错误提示", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql="delete from 调拨表 where 资产代码='"+s+"'"; 
		String sql2="select * from 调拨表 where 资产代码='"+s+"'";
		ResultSet res=conn.executeQuery(sql2);
		try {
			if(res.next()){
				int count = -1;
			    count = conn.executeUpdate(sql);
				jTextField2.setText("");
				jTextField4.setText("");
				jTextField6.setText("");
				jTextField8.setText("");
				jTextField10.setText("");	
				JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败", "提示", JOptionPane.PLAIN_MESSAGE);
		}


		//if(count!=-1)
			
		//else JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);	
	}
	void inserIntoOracle(String s2,String s4,String s6,String s8,String s10){
		
		JDBCFile conn = new JDBCFile();
		if(s2.toString().isEmpty()||s4.toString().isEmpty() ||s8.toString().isEmpty()){
			JOptionPane.showMessageDialog(null, "添加失败，资产代码、调入部门编号、调出部门编号不能为空", "错误提示", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql="insert into 调拨表  values('"+s2+"','"+s4+"','"+s6+"','"+s8+"','"+s10+"')";
		conn.executeUpdate(sql);
		/*jTextField2.setText("");
		jTextField4.setText("");
		jTextField6.setText("");
		jTextField8.setText("");
		jTextField10.setText("");*/

		//JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.PLAIN_MESSAGE);
	}

}
