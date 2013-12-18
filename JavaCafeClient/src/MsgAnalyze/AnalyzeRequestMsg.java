package MsgAnalyze;

import java.util.StringTokenizer;

import ClientGUI.CalculatePanel;

public class AnalyzeRequestMsg {
	public static void ToknizerMsg(String _replyMsg,CalculatePanel cp){
		String replyMsg;
		String orderIndex;
		String orderTime;
		String orderTableNum;
		String orderInfo;
		String productlist;
		String productInfo;
		String productName;
		String productCount;
		String productValue;
		replyMsg = _replyMsg.substring(1);
		StringTokenizer stkOrderIndex = new StringTokenizer(replyMsg, "!");

		while(stkOrderIndex.hasMoreTokens()){
			String orderPackage;
			orderPackage = stkOrderIndex.nextToken();
			if(orderPackage==null){
				break;
			}

			StringTokenizer stkPackage = new StringTokenizer(orderPackage, "$");
			orderInfo = stkPackage.nextToken();
			productlist = stkPackage.nextToken();
			
			StringTokenizer stkOrderInfo = new StringTokenizer(orderInfo, "/");
			orderIndex = stkOrderInfo.nextToken();
			orderTime = stkOrderInfo.nextToken();
			orderTableNum = stkOrderInfo.nextToken();

			StringTokenizer stkProductList = new StringTokenizer(productlist, "*");
			while(stkProductList.hasMoreTokens()){
				productInfo = stkProductList.nextToken();
				if(productInfo==null){
					break;
				}
				
				StringTokenizer stkProductInfo = new StringTokenizer(productInfo, ":");
				productName = stkProductInfo.nextToken();
				productCount =stkProductInfo.nextToken();
				productValue =stkProductInfo.nextToken();
				cp.setList(orderIndex, orderTime, orderTableNum, productName, productCount, productValue);
				System.out.println("주문번호 : "+orderIndex+" 주문시간 : "+orderTime+" 주문테이블 : "+orderTableNum+"제품명 : "+productName +" 수량 : "+productCount +"가격 : "+productValue);
			}
		}
	}
}
