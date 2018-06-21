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
	JMenu menuFlow;//�ʲ�����
	JMenu menuSelect;//�ʲ���ѯͳ��
	JMenu menuBrowse;//���
	
	JMenuItem menuStartQuit;
	JMenuItem menuStartBranch;
	JMenuItem menuStartCompany;
	
	JMenuItem menuFlowPurchase;//����
	JMenuItem menuFlowCollar;//����
	JMenuItem menuFlowAllocation;//����
	JMenuItem menuFlowHire;//����
	JMenuItem menuFlowScrap;//����
	
	JMenuItem menuSelectInformation;//�ʲ�������Ϣ
	JMenuItem menuSelectCollar;//����
	JMenuItem menuSelectAllocation;//����
	JMenuItem menuSelectHire;//����
	JMenuItem menuSelectScrap;//����
	
	JMenuItem menuBrowseInformation;//����ʲ�������Ϣ
	JMenuItem menuBrowseCollar;//���
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

		//�˵���
		menuStart = new JMenu("����ʼ��");
		menuFlow = new JMenu("���ʲ�״̬���á�");
		menuSelect = new JMenu("���ʲ���ѯ���޸ġ�ͳ�ơ�");
		menuBrowse = new JMenu("���ʲ�״̬�����");
		
		//��ʼ�˵�����Ŀ
		menuStartQuit = new JMenuItem("�˳�");
		menuStartBranch = new JMenuItem("��ҵ����");
		menuStartCompany = new JMenuItem("������ҵ");
		
		//�ʲ������˵�����Ŀ
		menuFlowPurchase = new JMenuItem("����");
		menuFlowCollar = new JMenuItem("����");
		menuFlowAllocation = new JMenuItem("����");
		menuFlowHire = new JMenuItem("����");		
		menuFlowScrap = new JMenuItem("����");	
		
		//�ʲ���ѯͳ�Ʋ˵�����Ŀ
		menuSelectInformation = new JMenuItem("�ʲ�������Ϣ");
		menuSelectCollar = new JMenuItem("����");
		menuSelectAllocation = new JMenuItem("����");
		menuSelectHire = new JMenuItem("����");		
		menuSelectScrap = new JMenuItem("����");	
		
		menuBrowseInformation = new JMenuItem("�ʲ�������Ϣ");
		menuBrowseCollar = new JMenuItem("����");
		menuBrowseAllocation = new JMenuItem("����");
		menuBrowseHire = new JMenuItem("����");
		menuBrowseScrap = new JMenuItem("����");
		
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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ùرմ��ڵ�Ĭ�ϲ���Ϊ �˳�����
		setLocationRelativeTo(null);// ����JFrame������ʾ
		setVisible(true);// ����JFrame�ɼ�		
				
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

		if (e.getSource() == this.menuFlowPurchase){//�����˵��еĹ���
			clear();
			/*����������ú���ֵĴ���*/
			flowPurchase = new FlowPurchase();
			this.setContentPane(flowPurchase);
			this.validate();			
		}
		
		if (e.getSource() == this.menuFlowCollar){//�����˵��е�����
			clear();
			/*����������ú���ֵĴ���*/
			flowCollar = new FlowCollar();
			this.setContentPane(flowCollar);
			this.validate();			
		}
				
		if (e.getSource() == this.menuFlowAllocation){//�����˵��еĵ���
			clear();
			/*���������������ֵĴ���*/
			flowAllocation = new FlowAllocation();
			this.setContentPane(flowAllocation);
			this.validate();			
		}
		
		if (e.getSource() == this.menuFlowHire){//�����˵��еĳ���
			clear();
			/*��������������ֵĴ���*/
			flowHire = new FlowHire();
			this.setContentPane(flowHire);
			this.validate();			
		}	
		
		if (e.getSource() == this.menuFlowScrap){//�����˵��еı���
			clear();
			/*����������Ϻ���ֵĴ���*/
			flowScrap = new FlowScrap();
			this.setContentPane(flowScrap);
			this.validate();			
		}
		
		if (e.getSource() == this.menuSelectInformation){//��ѯͳ�Ʋ˵��е��ʲ�������Ϣ
			clear();
			/*������� �ʲ�������Ϣ ����ֵĴ���*/
			selectInformation = new SelectInformation();
			this.setContentPane(selectInformation);
			this.validate();			
		}
		
		if (e.getSource() == this.menuSelectCollar){//��ѯͳ�Ʋ˵��е�����
			clear();
			/*����������ú���ֵĴ���*/
			selectCollar = new SelectCollar();
			this.setContentPane(selectCollar);
			this.validate();			
		}	
		
		if (e.getSource() == this.menuSelectAllocation){//��ѯͳ�Ʋ˵��еĵ���
			clear();
			/*���������������ֵĴ���*/
			selectAllocation = new SelectAllocation();
			this.setContentPane(selectAllocation);
			this.validate();			
		}	
		
		if (e.getSource() == this.menuSelectHire){//��ѯͳ�Ʋ˵��еĳ���
			clear();
			/*��������������ֵĴ���*/
			selectHire = new SelectHire();
			this.setContentPane(selectHire);
			this.validate();			
		}
		
		if (e.getSource() == this.menuSelectScrap){//��ѯͳ�Ʋ˵��еı���
			clear();
			/*����������Ϻ���ֵĴ���*/
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
