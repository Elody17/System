import java.sql.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login extends JFrame implements ActionListener{

	JLabel name1 = new JLabel("�û���");//��ʾ��Ϣ���û���
	JLabel pass1 = new JLabel("����");//��ʾ��Ϣ������
	JLabel remaind = new JLabel("�û������������������");

	JTextField textName = new JTextField();//�༭�����������û���
	JPasswordField textPs = new JPasswordField();//�༭�������������

	JButton button1 = new JButton("��¼");//��ť������
	JButton button2 = new JButton("����");//��ť��
	
	public Login(){
		setTitle("��ҵ�ʲ�ϵͳ��¼����"); // ����JFrame�ı���
		setSize(400, 300);// ���ô��ڴ�С	
		
		ImageIcon im = new ImageIcon("./star.png");
		setIconImage(im.getImage());// ���ñ���ͼ��*/

		Font font1 = new Font("����", 1, 14);
		Font font2 = new Font("����", 0, 12);

		name1.setLocation(80, 30);
		name1.setSize(100, 100);
		name1.setFont(font1);
		name1.setForeground(new Color(255,255,0));

		pass1.setLocation(80, 90);
		pass1.setSize(100, 100);
		pass1.setForeground(new Color(255,255,0));
		pass1.setFont(font1);

		textName.setSize(140, 20);
		textName.setLocation(170, 70);

		textPs.setSize(140, 20);
		textPs.setLocation(170, 130);
		textPs.setEchoChar('*');

		remaind.setLocation(170, 150);
		remaind.setSize(180, 20);
		remaind.setForeground(new Color(255,255,255));
		remaind.setFont(font2);		

		button1.setSize(90, 25);
		button1.setLocation(80, 200);
		button1.setIcon(im);// ����ͼ��

		button1.setFont(font2);
		button1.addActionListener(this);// Ϊjbutton1ע������� ������Ϊthis

		button2.setSize(90, 25);
		button2.setLocation(220, 200);
		button2.setIcon(im);// ����ͼ��

		button2.setFont(font2);
		button2.addActionListener(this);// Ϊjbutton2ע������� ������Ϊthis

		// ���ñ���ͼƬ
		// ͼƬλ���ڹ�����Ŀ¼��
		ImageIcon bgim = new ImageIcon("./bluelight.jpg");
		JLabel bg = new JLabel(bgim);// ����ͼ�����ڱ���

		bg.setSize(getSize().width, getSize().height);// ����bgΪ�����С
		bgim.setImage(bgim.getImage().getScaledInstance(bg.getSize().width,
				bg.getSize().height, Image.SCALE_DEFAULT));// ͼƬ����

		Container laycon = getLayeredPane();
		laycon.add(bg, new Integer(Integer.MIN_VALUE));

		Container con = getContentPane();// ȡ���������� ���ں�������
		con.setLayout(null);// �������������Ĳ���Ϊ��

		con.add(name1); // ����������������
		con.add(pass1);
		con.add(textName);
		con.add(textPs);
		con.add(button1);
		con.add(button2);
		con.setBackground(Color.black);
		con.add(bg);// ���bg���������� ��Ϊ����Ϊ����ͼƬ��JLabel

		setLocationRelativeTo(null);// ����JFrame������ʾ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ùرմ��ڵ�Ĭ�ϲ���Ϊ �˳�����
		setResizable(false); // ���ô��ڲ��ܸı��С
		setVisible(true);// ����JFrame�ɼ� //λ�����⣿
	}		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("��¼")){
			
			String wrotename = textName.getText().toString();
			//String password = textPs.getPassword().toString();
			String wrotepassword = new String(textPs.getPassword()).toString();
			if(!wrotename.equals("")&&!wrotepassword.equals("")){
				String queryString = "select * from systemuser where name='" + wrotename
						+ "' and password='" + wrotepassword + "'";
				try{
					
					JDBCFile conn = new JDBCFile();
					ResultSet resultSet = conn.executeQuery(queryString);
					
					if(resultSet.next()){
						//��ʾ��¼�ɹ���Ľ���
						new SystemMenu(wrotename+"������ҵ�ʲ�����ϵͳ");
						resultSet.close();
						this.dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "�û������������", "��¼����", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e1){
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "�û������������", "��¼����", JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ��", "��¼����", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getActionCommand().equalsIgnoreCase("����")){
			textName.setText("");
			textPs.setText("");
		}
			
	}
	
	public static void main(String args[]) {
		new Login();

	}
	

}