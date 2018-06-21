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

public class BrowseScrap extends JPanel implements ActionListener {

	JTable TableStus;

	public BrowseScrap() {
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
			// 定义一维数组作为表格标题
			Object[] tableHead = { "资产代码",  "资产残值","报废原因 ","报废日期","经办人" };
			// 定义二维数组作为表格数据
			JDBCFile db = new JDBCFile();
			
			String sqlstr = "select *  from 报废表";
			int row=0;
	
			ResultSet rs = db.executeQuery(sqlstr);
		
			while(rs.next()){row++;}

			

			
			Object[][] tableData = new Object[row][5];
			
			rs = db.executeQuery(sqlstr);
			

			int i = 0;
			while (rs.next()) {
				tableData[i][0] = rs.getString("资产代码");
				tableData[i][1] = rs.getString("资产残值");
				tableData[i][2] = rs.getString("报废原因");
				tableData[i][3] = rs.getString("报废日期");
				tableData[i][4] = rs.getString("经办人");

				i++;
			}

			rs.close();
			tableModel.setDataVector(tableData, tableHead);
			// TableStus = new JTable(tableData, tableHead);
			TableStus.setAutoCreateRowSorter(true);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "输入错误", "出错提示", JOptionPane.ERROR_MESSAGE);

		}
	}
}
