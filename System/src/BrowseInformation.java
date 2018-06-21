import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BrowseInformation extends JPanel implements ActionListener {
	JTable TableStus;
	public BrowseInformation() {
		TableStus = new JTable();
		TableStus.getTableHeader().setFont(new Font("宋体", Font.BOLD, 16));
		TableStus.setFont(new Font("宋体", 0, 16));

		this.tableInitialize();
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(TableStus), BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	public void tableInitialize() {
		try {
			DefaultTableModel tableModel = (DefaultTableModel) TableStus
					.getModel();
			Object[] tableHead = { "资产代码", "资产名称", "资产类型", "规格型号","资产单位","制造厂家","购置日期","资产原值" };
			JDBCFile db = new JDBCFile();
			String sqlstr = "select * from 资产数据表";
			int row=0;
			ResultSet rs = db.executeQuery(sqlstr);	
			while(rs.next()){row++;}			
			Object[][] tableData = new Object[row][8];		
			rs = db.executeQuery(sqlstr);			
			int i = 0;
			while (rs.next()) {
				tableData[i][0] = rs.getString("资产代码");
				tableData[i][1] = rs.getString("资产名称");
				tableData[i][2] = rs.getString("资产类型");
				tableData[i][3] = rs.getString("规格型号");
				tableData[i][4] = rs.getString("资产单位");
				tableData[i][5] = rs.getString("制造厂家");
				tableData[i][6] = rs.getString("购置日期");
				tableData[i][7] = rs.getString("资产原值");	
				i++;
			}
			rs.close();
			tableModel.setDataVector(tableData, tableHead);
			TableStus.setAutoCreateRowSorter(true);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "输入错误", "出错提示", JOptionPane.ERROR_MESSAGE);
		}
	}
}
