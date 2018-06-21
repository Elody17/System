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
		TableStus.getTableHeader().setFont(new Font("����", Font.BOLD, 16));
		TableStus.setFont(new Font("����", 0, 16));

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
			// ����һά������Ϊ������
			Object[] tableHead = { "�ʲ�����",  "�ʲ���ֵ","����ԭ�� ","��������","������" };
			// �����ά������Ϊ�������
			JDBCFile db = new JDBCFile();
			
			String sqlstr = "select *  from ���ϱ�";
			int row=0;
	
			ResultSet rs = db.executeQuery(sqlstr);
		
			while(rs.next()){row++;}

			

			
			Object[][] tableData = new Object[row][5];
			
			rs = db.executeQuery(sqlstr);
			

			int i = 0;
			while (rs.next()) {
				tableData[i][0] = rs.getString("�ʲ�����");
				tableData[i][1] = rs.getString("�ʲ���ֵ");
				tableData[i][2] = rs.getString("����ԭ��");
				tableData[i][3] = rs.getString("��������");
				tableData[i][4] = rs.getString("������");

				i++;
			}

			rs.close();
			tableModel.setDataVector(tableData, tableHead);
			// TableStus = new JTable(tableData, tableHead);
			TableStus.setAutoCreateRowSorter(true);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "�������", "������ʾ", JOptionPane.ERROR_MESSAGE);

		}
	}
}
