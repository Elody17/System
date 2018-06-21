import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class SystemMenu extends JFrame implements ActionListener{
	
	JMenuBar menubar;

	JMenu menuStart;
	JMenu menuFlow;//资产流动
	JMenu menuSelect;//资产查询统计
	JMenu menuBrowse;//浏览
	
	JMenuItem menuStartQuit;
	JMenuItem menuStartBranch;
	JMenuItem menuStartCompany;
	
	JMenuItem menuFlowPurchase;//购置
	JMenuItem menuFlowCollar;//领用
	JMenuItem menuFlowAllocation;//调拨
	JMenuItem menuFlowHire;//出租
	JMenuItem menuFlowScrap;//报废
	
	JMenuItem menuSelectInformation;//资产基本信息
	JMenuItem menuSelectCollar;//领用
	JMenuItem menuSelectAllocation;//调拨
	JMenuItem menuSelectHire;//出租
	JMenuItem menuSelectScrap;//报废
	
	JMenuItem menuBrowseInformation;//浏览资产基本信息
	JMenuItem menuBrowseCollar;//浏览
	JMenuItem menuBrowseAllocation;
	JMenuItem menuBrowseHire;
	JMenuItem menuBrowseScrap;
	
	StartBranch startBranch;
	StartCompany startCompany;
	
	FlowPurchase flowPurchase;
	FlowCollar flowCollar;
	FlowAllocation flowAllocation ;
	FlowHire flowHire;
	FlowScrap flowScrap;
	
	SelectInformation selectInformation;
	SelectCollar selectCollar;
	SelectAllocation selectAllocation;
	SelectHire selectHire;
	SelectScrap selectScrap;
	
	BrowseInformation browseInformation;
	BrowseCollar browseCollar;
	BrowseAllocation browseAllocation;
	BrowseHire browseHire;
	BrowseScrap browseScrap;
	

	
	SystemMenu(String s){
		setTitle(s);
		setSize(700, 700);		
		
		menubar = new JMenuBar();

		//菜单栏
		menuStart = new JMenu("【开始】");
		menuFlow = new JMenu("【资产状态设置】");
		menuSelect = new JMenu("【资产查询、修改、统计】");
		menuBrowse = new JMenu("【资产状态浏览】");
		
		//开始菜单的项目
		menuStartQuit = new JMenuItem("退出");
		menuStartBranch = new JMenuItem("企业部门");
		menuStartCompany = new JMenuItem("合作企业");
		
		//资产流动菜单的项目
		menuFlowPurchase = new JMenuItem("购置");
		menuFlowCollar = new JMenuItem("领用");
		menuFlowAllocation = new JMenuItem("调拨");
		menuFlowHire = new JMenuItem("出租");		
		menuFlowScrap = new JMenuItem("报废");	
		
		//资产查询统计菜单的项目
		menuSelectInformation = new JMenuItem("资产基本信息");
		menuSelectCollar = new JMenuItem("领用");
		menuSelectAllocation = new JMenuItem("调拨");
		menuSelectHire = new JMenuItem("出租");		
		menuSelectScrap = new JMenuItem("报废");	
		
		menuBrowseInformation = new JMenuItem("资产基本信息");
		menuBrowseCollar = new JMenuItem("领用");
		menuBrowseAllocation = new JMenuItem("调拨");
		menuBrowseHire = new JMenuItem("出租");
		menuBrowseScrap = new JMenuItem("报废");
		
		menuStart.add(menuStartQuit);
		menuStart.add(menuStartBranch);
		menuStart.add(menuStartCompany);

		menuFlow.add(menuFlowPurchase);
		menuFlow.add(menuFlowCollar);
		menuFlow.add(menuFlowAllocation);
		menuFlow.add(menuFlowHire);
		menuFlow.add(menuFlowScrap);

		menuSelect.add(menuSelectInformation);
		menuSelect.add(menuSelectCollar);
		menuSelect.add(menuSelectAllocation);
		menuSelect.add(menuSelectHire);
		menuSelect.add(menuSelectScrap);
		
		menuBrowse.add(menuBrowseInformation);
		menuBrowse.add(menuBrowseCollar);
		menuBrowse.add(menuBrowseAllocation);
		menuBrowse.add(menuBrowseHire);
		menuBrowse.add(menuBrowseScrap);

		menuStartQuit.addActionListener(this);
		menuStartBranch.addActionListener(this);
		menuStartCompany.addActionListener(this);

		menuFlowPurchase.addActionListener(this);
		menuFlowCollar.addActionListener(this);
		menuFlowAllocation.addActionListener(this);
		menuFlowHire.addActionListener(this);
		menuFlowScrap.addActionListener(this);

		menuSelectInformation.addActionListener(this);
		menuSelectCollar.addActionListener(this);
		menuSelectAllocation.addActionListener(this);
		menuSelectHire.addActionListener(this);
		menuSelectScrap.addActionListener(this);
		
		menuBrowseInformation.addActionListener(this);
		menuBrowseCollar.addActionListener(this);
		menuBrowseAllocation.addActionListener(this);
		menuBrowseHire.addActionListener(this);
		menuBrowseScrap.addActionListener(this);

		menubar.add(menuStart);
		menubar.add(menuFlow);
		menubar.add(menuSelect);
		menubar.add(menuBrowse);

		setJMenuBar(menubar);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭窗口的默认操作为 退出程序
		setLocationRelativeTo(null);// 设置JFrame居中显示
		setVisible(true);// 设置JFrame可见		
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.menuStartQuit){
			this.dispose();
		}		
		if(e.getSource()==this.menuStartBranch){
			clear();
			startBranch = new StartBranch();
			this.setContentPane(startBranch);
			this.validate();
		}
		if(e.getSource()==this.menuStartCompany){
			clear();
			startCompany = new StartCompany();
			this.setContentPane(startCompany);
			this.validate();
		}		

		if (e.getSource() == this.menuFlowPurchase){//流动菜单中的购置
			clear();
			/*创建点击购置后出现的窗口*/
			flowPurchase = new FlowPurchase();
			this.setContentPane(flowPurchase);
			this.validate();			
		}
		
		if (e.getSource() == this.menuFlowCollar){//流动菜单中的领用
			clear();
			/*创建点击领用后出现的窗口*/
			flowCollar = new FlowCollar();
			this.setContentPane(flowCollar);
			this.validate();			
		}
				
		if (e.getSource() == this.menuFlowAllocation){//流动菜单中的调拨
			clear();
			/*创建点击调拨后出现的窗口*/
			flowAllocation = new FlowAllocation();
			this.setContentPane(flowAllocation);
			this.validate();			
		}
		
		if (e.getSource() == this.menuFlowHire){//流动菜单中的出租
			clear();
			/*创建点击出租后出现的窗口*/
			flowHire = new FlowHire();
			this.setContentPane(flowHire);
			this.validate();			
		}	
		
		if (e.getSource() == this.menuFlowScrap){//流动菜单中的报废
			clear();
			/*创建点击报废后出现的窗口*/
			flowScrap = new FlowScrap();
			this.setContentPane(flowScrap);
			this.validate();			
		}
		
		if (e.getSource() == this.menuSelectInformation){//查询统计菜单中的资产基本信息
			clear();
			/*创建点击 资产基本信息 后出现的窗口*/
			selectInformation = new SelectInformation();
			this.setContentPane(selectInformation);
			this.validate();			
		}
		
		if (e.getSource() == this.menuSelectCollar){//查询统计菜单中的领用
			clear();
			/*创建点击领用后出现的窗口*/
			selectCollar = new SelectCollar();
			this.setContentPane(selectCollar);
			this.validate();			
		}	
		
		if (e.getSource() == this.menuSelectAllocation){//查询统计菜单中的调拨
			clear();
			/*创建点击调拨后出现的窗口*/
			selectAllocation = new SelectAllocation();
			this.setContentPane(selectAllocation);
			this.validate();			
		}	
		
		if (e.getSource() == this.menuSelectHire){//查询统计菜单中的出租
			clear();
			/*创建点击出租后出现的窗口*/
			selectHire = new SelectHire();
			this.setContentPane(selectHire);
			this.validate();			
		}
		
		if (e.getSource() == this.menuSelectScrap){//查询统计菜单中的报废
			clear();
			/*创建点击报废后出现的窗口*/
			selectScrap = new SelectScrap();
			this.setContentPane(selectScrap);
			this.validate();			
		}
		if(e.getSource()==this.menuBrowseInformation){
			clear();
			browseInformation= new BrowseInformation();
			this.setContentPane(browseInformation);
			this.validate();			
		}
		if(e.getSource()==this.menuBrowseCollar){
			clear();
			browseCollar= new BrowseCollar();
			this.setContentPane(browseCollar);
			this.validate();			
		}
		if(e.getSource()==this.menuBrowseAllocation){
			clear();
			browseAllocation= new BrowseAllocation();
			this.setContentPane(browseAllocation);
			this.validate();			
		}	
		if(e.getSource()==this.menuBrowseHire){
			clear();
			browseHire= new BrowseHire();
			this.setContentPane(browseHire);
			this.validate();			
		}		
		if(e.getSource()==this.menuBrowseScrap){
			clear();
			browseScrap= new BrowseScrap();
			this.setContentPane(browseScrap);
			this.validate();			
		}			
	}

	private void clear() {
		// TODO Auto-generated method stub
		if (browseScrap != null)
			browseScrap = null;
		if (browseHire != null)
			browseHire = null;		
		if (browseAllocation != null)
			browseAllocation = null;		
		if (browseCollar != null)
			browseCollar = null;		
		if (browseInformation != null)
			browseInformation = null;		
		if (startBranch != null)
			startBranch = null;
		if (startCompany != null)
			startCompany = null;		
		if (flowPurchase != null)
			flowPurchase = null;
		if (flowCollar != null)
			flowCollar = null;
		if (flowAllocation != null)
			flowAllocation = null;
		if (flowHire != null)
			flowHire = null;
		if (flowScrap != null)
			flowScrap = null;
		if (selectInformation != null)
			selectInformation = null;
		if (selectCollar != null)
			selectCollar = null;
		if (selectAllocation != null)
			selectAllocation = null;
		if (selectHire != null)
			selectHire = null;
		if (selectScrap != null)
			selectScrap = null;		
	}
}
