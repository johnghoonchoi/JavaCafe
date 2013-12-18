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


public class OrderWindow extends JFrame implements ActionListener{
	String[][][] menuInfo = new String[3][8][1];
	menuInfo ={{{},{},{},{},{},{},{},{}},{{},{},{},{},{},{},{},{}},{{},{},{},{},{},{},{},{}}};
	JButton jButton1= new JButton("COFFEE");
	JButton jButton2= new JButton("NONCOFFEE");
	JButton jButton3= new JButton("DESSERT");
	
	JButton jButton4= new JButton("에스프레소");
	JButton jButton5= new JButton("아메리카노");
	JButton jButton6= new JButton("카푸치노");
	JButton jButton7= new JButton("카페라떼");
    JButton jButton8= new JButton("바닐라라떼");
    JButton jButton9= new JButton("아포가토");
    JButton jButton10= new JButton("카페모카");
    JButton jButton11= new JButton("민트모카");
    
    JButton jButton12= new JButton("주문");
    JButton jButton13= new JButton("취소");
    
    JLabel jLabel1 = new JLabel("테이블번호");
    JLabel jLabel2 = new JLabel("총가격");
    
    JTextField jTextField1 = new JTextField("0원");
    
    JScrollPane jScrollPane1= new JScrollPane();
    JTable jTable1 = new JTable();
    TablePanel tP;
	Vector col = new Vector();
	Vector data = new Vector();
	TableModel dmodel;
	
	int totalPrice;
	
	
    public OrderWindow(int tNum,TablePanel tP) {
    	this.tP =tP;
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

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
    	jButton5.addActionListener(this);
    	jButton6.addActionListener(this);
    	jButton7.addActionListener(this);
        jButton8.addActionListener(this);
        jButton9.addActionListener(this);
        jButton10.addActionListener(this);
        jButton11.addActionListener(this);
        jButton12.addActionListener(this);
        jButton13.addActionListener(this);
        
        
        

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1))
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton12, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton13, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1)
                        .addComponent(jButton12, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton13, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setTitle("주문");
        setSize(640, 335);
        setVisible(true);

    }                      

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jButton1){
			buttonSetText(e.getActionCommand());
		}else if(e.getSource()==jButton2){
			buttonSetText(e.getActionCommand());
		}else if(e.getSource()==jButton3){
			buttonSetText(e.getActionCommand());
		}else if(e.getSource()==jButton12){
			new OrderCheck(jTable1,tP,this);
		}else if(e.getSource()==jButton13){
			//창닫기
			closeWindow();
		}else{
			upCountOrder(e.getActionCommand());
		}
	}
	public void closeWindow(){
		setVisible(false);
		dispose();
	}
	public void totalPrice(){
		int productCount;
		int productPrice;
		totalPrice=0;
		int rowCount= jTable1.getRowCount();
		for(int i=0;i<rowCount;i++){
			productCount = Integer.parseInt(jTable1.getValueAt(i, 1).toString());
			productPrice = Integer.parseInt(jTable1.getValueAt(i, 2).toString());
			totalPrice += productCount*productPrice;
			
		}
		jTextField1.setText(totalPrice+"원");
	}
	
	public void upCountOrder(String orderName){
		int rowCount;
		int orderCount;
		int price;
		boolean checkorder=true;
		rowCount = jTable1.getRowCount();
		System.out.println(orderName);
		if(rowCount==0){
			Vector row = new Vector();
			row.add(orderName);
			row.add("1");
			row.add("3000");
			data.addElement(row);
			checkorder=false;
		}
		for(int i=0;i<rowCount;i++){
			if(jTable1.getValueAt(i, 0)==orderName){
				Integer.parseInt(jTable1.getValueAt(i, 1).toString());
				orderCount = Integer.parseInt(jTable1.getValueAt(i, 1).toString());
				orderCount++;
				jTable1.setValueAt(orderCount, i, 1);
				checkorder=false;
			}
		}
		if(checkorder){
			Vector row = new Vector();
			row.add(orderName);
			row.add("1");
			row.add("3000");
			data.addElement(row);
		}
		jTable1.updateUI();
		totalPrice();
	}
	
	public void buttonSetText(String index){
		if(index=="COFFEE"){
			jButton4.setText("에스프레소");
			jButton5.setText("아메리카노");
			jButton6.setText("카푸치노");
			jButton7.setText("카페라떼");
			jButton8.setText("바닐라라떼");
			jButton9.setText("아포가토");
			jButton10.setText("카페모카");
			jButton11.setText("민트모카");
		}
		if(index=="NONCOFFEE"){
			jButton4.setText("초코라떼");
			jButton5.setText("그린티라떼");
			jButton6.setText("고구마라떼");
			jButton7.setText("쿠앤크라떼");
			jButton8.setText("아이스티");
			jButton9.setText("에이드");
			jButton10.setText("스무디");
			jButton11.setText("허브티");
		}
		if(index=="DESSERT"){
			jButton4.setText("와플");
			jButton5.setText("베이글");
			jButton6.setText("프레즐");
			jButton7.setText("브라우니");
			jButton8.setText("번");
			jButton9.setText("토스트");
			jButton10.setText("샌드위치");
			jButton11.setText("허니브레드");
		}
	}            
}
