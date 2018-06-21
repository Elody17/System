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

	JLabel name1 = new JLabel("用户名");//提示信息：用户名
	JLabel pass1 = new JLabel("密码");//提示信息：口令
	JLabel remaind = new JLabel("用户名或密码错误，请重试");

	JTextField textName = new JTextField();//编辑框：用于输入用户名
	JPasswordField textPs = new JPasswordField();//编辑框：用于输入口令

	JButton button1 = new JButton("登录");//按钮：登入
	JButton button2 = new JButton("重置");//按钮：
	
	public Login(){
		setTitle("企业资产系统登录窗口"); // 设置JFrame的标题
		setSize(400, 300);// 设置窗口大小	
		
		ImageIcon im = new ImageIcon("./star.png");
		setIconImage(im.getImage());// 设置标题图标*/

		Font font1 = new Font("宋体", 1, 14);
		Font font2 = new Font("宋体", 0, 12);

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
		button1.setIcon(im);// 设置图标

		button1.setFont(font2);
		button1.addActionListener(this);// 为jbutton1注册监听者 监听者为this

		button2.setSize(90, 25);
		button2.setLocation(220, 200);
		button2.setIcon(im);// 设置图标

		button2.setFont(font2);
		button2.addActionListener(this);// 为jbutton2注册监听者 监听者为this

		// 设置背景图片
		// 图片位置在工程主目录下
		ImageIcon bgim = new ImageIcon("./bluelight.jpg");
		JLabel bg = new JLabel(bgim);// 设置图标用于背景

		bg.setSize(getSize().width, getSize().height);// 设置bg为界面大小
		bgim.setImage(bgim.getImage().getScaledInstance(bg.getSize().width,
				bg.getSize().height, Image.SCALE_DEFAULT));// 图片缩放

		Container laycon = getLayeredPane();
		laycon.add(bg, new Integer(Integer.MIN_VALUE));

		Container con = getContentPane();// 取得内容容器 便于后续操作
		con.setLayout(null);// 设置内容容器的布局为空

		con.add(name1); // 添加组件到内容容器
		con.add(pass1);
		con.add(textName);
		con.add(textPs);
		con.add(button1);
		con.add(button2);
		con.setBackground(Color.black);
		con.add(bg);// 添加bg到内容容器 此为设置为背景图片的JLabel

		setLocationRelativeTo(null);// 设置JFrame居中显示
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭窗口的默认操作为 退出程序
		setResizable(false); // 设置窗口不能改变大小
		setVisible(true);// 设置JFrame可见 //位置问题？
	}		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("登录")){
			
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
						//显示登录成功后的界面
						new SystemMenu(wrotename+"进入企业资产管理系统");
						resultSet.close();
						this.dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "用户名或密码错误", "登录错误", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e1){
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "用户名或密码错误", "登录错误", JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "用户名或密码不能为空", "登录错误", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getActionCommand().equalsIgnoreCase("重置")){
			textName.setText("");
			textPs.setText("");
		}
			
	}
	
	public static void main(String args[]) {
		new Login();

	}
	

}