package ClientGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import CommunicationServer.RequestToServer;



public class CalculatePanel extends JPanel implements ActionListener{
	JButton jButton1;
    JButton jButton2;
    JLabel jLabel1;
    JLabel jLabel2;
    JScrollPane jScrollPane1;
    JTable jTable1;
    
    int year;
    int month;
    int day;
    
    Vector col = new Vector();
	Vector data = new Vector();
	TableModel dmodel;
	

    public CalculatePanel() {
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jButton1= new JButton("��¥����");
        jButton2= new JButton("��ȸ");
        jLabel1= new JLabel("��ȸ�Ͻǳ�¥�� �����Ͽ��ֽʽÿ�");
        jLabel2= new JLabel("��ȸ����� �����ϴ�");
        col.addElement("�ֹ���ȣ");
        col.addElement("�ֹ��ð�");
        col.addElement("���̺��ȣ");
        col.addElement("ǰ��");
		col.addElement("����");
		col.addElement("����");
		dmodel = new DefaultTableModel(data,col){
			public boolean isCellEditable(int rowIndex, int mCollndex){
				return false;
			}
		};
		jTable1 = new JTable(dmodel);
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		jScrollPane1 = new JScrollPane(jTable1,v,h);

        jScrollPane1.setViewportView(jTable1);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton2.setEnabled(false);
 

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
    }                       

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jButton1){
			new SelectCalendar(this);
		}
		if(e.getSource()==jButton2){
			data.clear();
			requestDate();
		}
	}
	public void setDate(int year,int month,int day){
    	this.year=year;
    	this.month=month;
    	this.day=day;
    	jLabel1.setText(year+"�� "+month+"�� "+day+"�� ");
    	jButton2.setEnabled(true);
    }
	public void requestDate(){
		String checkDate="";
		checkDate += year;
    	checkDate += month;
    	checkDate += day;
    	RequestToServer rts = new RequestToServer();
    	rts.RequestMsg(checkDate,this);
	}
	public void setList(String orderIndex,String orderTime,String orderTable,String orderProduct,String orderCount,String orderValue){
		jLabel2.setText("�Ǹų����� ��ȸ�Ǿ����ϴ�");
		Vector row = new Vector();
		row.add(orderIndex);  // �ֹ���ȣ
		row.add(orderTime);  // �ֹ��ð�
		row.add(orderTable);  // �ֹ����̺�
		row.add(orderProduct);  // ��ǰ��
		row.add(orderCount);  // ����
		row.add(orderValue);  // ����
		data.addElement(row);
		jTable1.updateUI();
	}
                
}
