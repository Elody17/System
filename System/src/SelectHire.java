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

public class SelectHire extends JPanel implements ActionListener {
	
	Box baseBox,box1,box2,box3,box4,box5,box6,box0,box00;
	
	JLabel jLabel00;
	//JLabel jLabel01;
	JLabel jLabel0;
	JLabel jLabel1;
	JTextField jTextField0;
	//JTextField jTextField01;
	JTextField jTextField2;
	JLabel jLabel3;
	JTextField jTextField4;
	
	JLabel jLabel5;
	JTextField jTextField6;
	JLabel jLabel7;
	JTextField jTextField8;

	JLabel jLabel9;
	JTextField jTextField10;
	JLabel jLabel11;
	JTextField jTextField12;
	
	JLabel jLabel13;
	JTextField jTextField14;
	JLabel jLabel15;
	JTextField jTextField16;
	JTextField jTextField18;
	
	JButton jButton1;
	JButton jButton2;
	JButton jButton3;
	
	
	JTable TableStus;
	
	SelectHire(){
		jLabel00 = new JLabel("�ʲ�����:");
		//jLabel01 = new JLabel("��ҵ����:");
		jLabel0 = new JLabel("��ѯ�������:");
		jLabel1 = new JLabel("�ʲ�����:");
		jLabel3 = new JLabel("�ʲ�����:");
		jLabel5 = new JLabel("��ҵ����:");
		jLabel7 = new JLabel("��ҵ����:");
		jLabel9 = new JLabel("���޷���:");
		jLabel11 = new JLabel("��������:");
		jLabel13 = new JLabel("������:");
		
		
		jTextField0 = new JTextField(15);
		//jTextField01 = new JTextField(15);
		jTextField2 = new JTextField(15);jTextField2.setEnabled(false);
		jTextField4 = new JTextField(15);jTextField4.setEnabled(false);
		jTextField6 = new JTextField(15);jTextField6.setEnabled(false);
		jTextField8 = new JTextField(15);jTextField8.setEnabled(false);
		jTextField10 = new JTextField(15);
		jTextField12 = new JTextField(15);
		jTextField14 = new JTextField(15);
		
		jTextField18 = new JTextField(15);jTextField18.setEnabled(false);
	
		jButton1 = new JButton("��ѯ");
		jButton2 = new JButton("ͳ�Ƴ����ʲ�������");
		jButton3 = new JButton("�����޸�");

		
		TableStus = new JTable();
		TableStus.getTableHeader().setFont(new Font("����", Font.BOLD, 16));
		TableStus.setFont(new Font("����", 0, 16));
		
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		jButton3.addActionListener(this);


		box00 = Box.createHorizontalBox();
		box00.add(jLabel00);
		box00.add(Box.createHorizontalStrut(5));
		box00.add(jTextField0);
		box00.add(Box.createHorizontalStrut(5));
		//box00.add(jLabel01);
		//box00.add(Box.createHorizontalStrut(5));
		//box00.add(jTextField01);
		//box00.add(Box.createHorizontalStrut(5));
		box00.add(jButton1);
		box00.add(Box.createHorizontalStrut(5));
		box00.add(jButton3);
		
		box0 = Box.createHorizontalBox();
		box0.add(jLabel0);
		
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
		box3.add(jLabel11);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(jTextField12);	
		
		box4 = Box.createHorizontalBox();
		box4.add(jLabel13);
		box4.add(Box.createHorizontalStrut(10));
		box4.add(jTextField14);
		box4.add(Box.createHorizontalStrut(40));
		

		box5 = Box.createHorizontalBox();
		box5.add(jButton2);
		box5.add(Box.createHorizontalStrut(20));
		box5.add(jTextField18);

		
		box6 = Box.createHorizontalBox();
		//box6.add(new JScrollPane(TableStus));	
	    //this.tableInitialize();
		//this.setLayout(new BorderLayout());
		//this.add(new JScrollPane(TableStus), BorderLayout.CENTER);
		ImageIcon bgim = new ImageIcon("./main.jpg");
		JLabel bg = new JLabel(bgim);// ����ͼ�����ڱ���

		bg.setSize(507, 322);// ����bgΪ�����С
		bgim.setImage(bgim.getImage().getScaledInstance(bg.getSize().width,
				bg.getSize().height, Image.SCALE_DEFAULT));// ͼƬ����


		box6.add(bg, new Integer(Integer.MIN_VALUE));
		
		baseBox = Box.createVerticalBox();
		baseBox.add(Box.createVerticalStrut(15));
		baseBox.add(box00);
		baseBox.add(Box.createVerticalStrut(15));
		baseBox.add(box0);
		baseBox.add(Box.createVerticalStrut(15));
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
		baseBox.add(box6);
		this.add(baseBox);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//��ѯ
		if(e.getSource()==this.jButton1){
			JDBCFile jdbc = new JDBCFile();
			String zno = jTextField0.getText().toString();
			//String bno = jTextField01.getText().toString();
			String sql =  "select �����.�ʲ�����,�ʲ�����,�����.��ҵ����,��ҵ����,���޷���,��������,������  from �����,��ҵ��,�ʲ����ݱ�  where �����.�ʲ�����='"+zno+"' and �����.�ʲ�����=�ʲ����ݱ�.�ʲ�����  and ��ҵ��.��ҵ����=(select ��ҵ����   from �����  where �ʲ�����='"+zno+"')";
				/*"select �����.�ʲ�����,�ʲ�����,�����.��ҵ����,��ҵ����,���޷���,��������,������ " +
			"from �����,�ʲ����ݱ�,��ҵ�� " +
			"where �����.�ʲ�����=�ʲ����ݱ�.�ʲ����� and " +
			"�����.��ҵ����=��ҵ��.��ҵ���� and �����.�ʲ�����='"+zno+"'and �����.��ҵ����='"+bno+"'";	*/
			/*
			String sql = "select ���ñ�.�ʲ�����,�ʲ�����,���ñ�.���ű��,��������,��������,������ " +
			"from ���ñ�,�ʲ����ݱ�,���ű� " +
			"where ���ñ�.�ʲ�����=�ʲ����ݱ�.�ʲ����� and " +
			"���ñ�.���ű��=���ű�.���ű�� and ���ñ�.�ʲ�����='"+zno+"'and ���ñ�.���ű��='"+bno+"'";*/
			ResultSet res = jdbc.executeQuery(sql);
			try {
				if(res.next()){
					jTextField2.setText(res.getString(1));
					jTextField4.setText(res.getString(2));
					jTextField6.setText(res.getString(3));
					jTextField8.setText(res.getString(4));
					//jTextField10.setText(String.valueOf(res.getFloat(5)));
					//jTextField12.setText(String.valueOf(res.getDate(6)));
					jTextField10.setText(res.getString(5));
					jTextField12.setText(res.getString(6));
					jTextField14.setText(res.getString(7));
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "�������", "������ʾ", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		//ͳ��
		if(e.getSource()==this.jButton2){
			JDBCFile jdbc = new JDBCFile();
			int count=0;
			String sql = "select * from ����� ";
			ResultSet res = jdbc.executeQuery(sql);
			try {
				while(res.next())
				{
					count++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "�������", "������ʾ", JOptionPane.ERROR_MESSAGE);
			}
			//System.out.println(count);
			jTextField18.setText(String.valueOf(count));
		}
		//�����޸�
		if(e.getSource()==this.jButton3){
			try{String zno = jTextField0.getText();
			String s1,s2,s3,s4;
			//s1=jTextField6.getText();
			//s2=jTextField8.getText();
			s1=jTextField10.getText();
			s2=jTextField12.getText();
			s3=jTextField14.getText();
			
			JDBCFile jdbc = new JDBCFile();
			String sql="update �����  set ���޷���='"+s1+"', �������� ='"+s2+"', ������ ='"+s3+"' where �ʲ�����='"+zno+"'";
			jdbc.executeUpdate(sql);}
			catch(Exception e2){
				JOptionPane.showMessageDialog(null, "�޸�ʧ��", "������ʾ", JOptionPane.ERROR_MESSAGE);}
			JOptionPane.showMessageDialog(null, "����ɹ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		}		
	}	

}
