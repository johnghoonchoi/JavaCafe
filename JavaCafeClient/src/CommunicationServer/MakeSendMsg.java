package CommunicationServer;

import javax.swing.JTable;

public class MakeSendMsg {
	public String MakeOrderMsg(int rowCount,JTable jTable){
		String makeMsg="";
		String productName;
		String productCount;
		String productValue;
		for(int i=0; i<rowCount;i++){ 		
    		productName = jTable.getValueAt(i, 0).toString();
    		productCount= jTable.getValueAt(i, 1).toString();
    		productValue= jTable.getValueAt(i, 2).toString();

    		System.out.println(productName);
    		System.out.println(productCount);
    		System.out.println(productValue);
    		makeMsg += productName+":"+productCount+":"+productValue+"*";
		}
		makeMsg +="*";
		return makeMsg;
	}
}
