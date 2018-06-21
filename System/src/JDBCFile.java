
import java.sql.*;

import javax.swing.JOptionPane;
public class JDBCFile {
	
	private static final String DBDRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String DBURL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String DBUSER="system";
	private static final String PASSWORD="Elody1739";
	
	Connection conn = null;
	Statement sta = null;
	ResultSet res = null;	
	int insertValue = -1;
	
	//构造函数
	JDBCFile(){
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "输入错误", "出粗提示", JOptionPane.ERROR_MESSAGE);
		}
		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "输入错误", "出错提示", JOptionPane.ERROR_MESSAGE);
		}
		try {
			sta = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "输入错误", "出错提示", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//查询函数executeQuery
	ResultSet executeQuery(String sql){
		try {
			res = sta.executeQuery(sql);
		//System.out.println(sta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "输入错误", "出错提示", JOptionPane.ERROR_MESSAGE);
		}
		return res;
	}
	

	int executeUpdate(String sql) {
		try {
			insertValue = sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "输入错误", "出错提示", JOptionPane.ERROR_MESSAGE);
		}
		return insertValue;
	}	
}

