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


public class FlowCollar extends JPanel implements ActionListener {
	
	Box baseBox,box1,box2,box3,box4;
	
	JLabel jLabel1;
	JTextField jTextField2;
	JLabel jLabel3;
	JTextField jTextField4;
	
	JLabel jLabel5;
	JTextField jTextField6;
	JLabel jLabel7;
	JTextField jTextField8;
	
	JButton jButton1;
	JButton jButton2;
	JButton jButton3;
	
	JTable TableStus;
	
	FlowCollar(){
		
		jLabel1 = new JLabel("资产代码:    ");
		jLabel3 = new JLabel("领用部门编号:");
		jLabel5 = new JLabel("领用日期:    ");
		jLabel7 = new JLabel("经办人:      ");
		
		jTextField2 = new JTextField(15);
		jTextField4 = new JTextField(15);
		jTextField6 = new JTextField(15);
		jTextField8 = new JTextField(15);
		
		jButton1 = new JButton("保存");
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

		bg.setSize(545, 402);// 设置bg为界面大小
		bgim.setImage(bgim.getImage().getScaledInstance(bg.getSize().width,
				bg.getSize().height, Image.SCALE_DEFAULT));// 图片缩放


		box4.add(bg, new Integer(Integer.MIN_VALUE));		
		
		baseBox = Box.createVerticalBox();
		baseBox.add(Box.createVerticalStrut(30));		
		baseBox.add(box1);
		baseBox.add(Box.createVerticalStrut(20));
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
			inserIntoOracle(jTextField2.getText(),jTextField4.getText(),jTextField6.getText(),
					jTextField8.getText());
		}	
		//重置
		if(e.getSource()==this.jButton2){
			jTextField2.setText("");
			jTextField4.setText("");
			jTextField6.setText("");
			jTextField8.setText("");
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
		String sql="delete from 领用表 where 资产代码='"+s+"'"; 
		String sql2="select * from 领用表 where 资产代码='"+s+"'"; 
		int count = -1;
		ResultSet res=conn.executeQuery(sql2);
		try {
			if(res.next()){
			    count = conn.executeUpdate(sql);
				jTextField2.setText("");
				jTextField4.setText("");
				jTextField6.setText("");
				jTextField8.setText("");	
				JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败", "提示", JOptionPane.PLAIN_MESSAGE);
		}
	    count = conn.executeUpdate(sql);
		jTextField2.setText("");
		jTextField4.setText("");
		jTextField6.setText("");
		jTextField8.setText("");

		//if(count!=-1)
		//JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);	
		//else JOptionPane.showMessageDialog(null, "删除失败", "提示", JOptionPane.PLAIN_MESSAGE);	
	}	
	void inserIntoOracle(String s2,String s4,String s6,String s8){
		JDBCFile conn = new JDBCFile();
		if(s2.toString().isEmpty()||s4.toString().isEmpty()){
			JOptionPane.showMessageDialog(null, "保存失败，资产代码、领用部门编号不能为空", "错误提示", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql="insert into 领用表  values('"+s2+"','"+s4+"','"+s6+"','"+s8+"')";		
		conn.executeUpdate(sql);
		/*jTextField2.setText("");
		jTextField4.setText("");
		jTextField6.setText("");
		jTextField8.setText("");*/
		//JOptionPane.showMessageDialog(null, "保存成功", "提示", JOptionPane.PLAIN_MESSAGE);		
	}
}
