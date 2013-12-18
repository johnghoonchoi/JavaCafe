package ClientGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import CommunicationServer.MakeSendMsg;
import CommunicationServer.RequestToServer;


public class OrderCheck extends JFrame implements ActionListener{
	JButton jButton1;
    JButton jButton2;
    JScrollPane jScrollPane1;
    JTable jTable1;
    Vector col = new Vector();
	Vector data = new Vector();
	TableModel dmodel;
	JLabel jl1= new JLabel("총가격");
    JTextField jTextField2= new JTextField();
    int totalPrice = 0;
    int rowCount;
    TablePanel tP;
    OrderWindow ow;
    
    public OrderCheck(JTable _jTable1,TablePanel tP, OrderWindow ow) {
    	this.tP = tP;
    	this.ow = ow;
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        jButton1 = new JButton("주문");
        jButton2 = new JButton("취소");

        
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        col.addElement("품명");
		col.addElement("수량");
		col.addElement("가격");
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
        listTable(_jTable1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jl1, GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, GroupLayout.Alignment.LEADING,GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField2, GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jl1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        
        
        setTitle("주문확인");
        setSize(315, 390);
        setVisible(true);
    }
    public void listTable(JTable _jTable1){
       	int price;
    	int orderCount;
    	jTable1 = _jTable1;
    	rowCount =_jTable1.getRowCount();
    	for(int i=0; i<rowCount;i++){
    		Vector row = new Vector();
    		row.add(jTable1.getValueAt(i, 0));
    		row.add(jTable1.getValueAt(i, 1));
    		row.add(jTable1.getValueAt(i, 2));
    		orderCount = Integer.parseInt(jTable1.getValueAt(i, 1).toString());
    		price = Integer.parseInt(jTable1.getValueAt(i, 2).toString());
    		totalPrice += orderCount*price;
    		data.addElement(row);
    	}
    	jTextField2.setText(totalPrice+"원");
    	jTable1.updateUI();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sendMsg="";
		if(e.getSource()==jButton1){
			MakeSendMsg msm = new MakeSendMsg();
			sendMsg += "/"; // OrderMsg 표시
			sendMsg += "tableNum"; // Table 번호표시
			sendMsg += "$"; // StartOfOrder
			sendMsg += msm.MakeOrderMsg(rowCount, jTable1);  // 주문 목록 메시지화
			sendMsg += "!";  // EndOfOrder
			System.out.println(sendMsg);
			RequestToServer srts = new RequestToServer();
			srts.sendMessage(sendMsg);
			
			tP.setPrice(totalPrice);
			ow.closeWindow();
			setVisible(false);
			dispose();
		}
		if(e.getSource()==jButton2){
			setVisible(false);
			dispose();
		}
	}
}
