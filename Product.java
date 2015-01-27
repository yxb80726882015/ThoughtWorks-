import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * cacularate shopping product
 *
 * @author yangxingbang
 * @since 01.26.2015
 */
public class Product {
	//��Ʒ�࣬������Ʒ���ƣ���Ʒ�۸��Ƿ������Ϣ
	public static class Item{
		public Item(double price,String name,boolean isPromotion){
			this.price = price;
			this.name = name;
			this.isPromotion = isPromotion;
		}
		public double price;
		public String name;
		public boolean isPromotion;
	}
	
	//�����Ʒ��Ϣ
	public static Map<String, Item> itemMap = new HashMap<String, Item>() {
		{
			put("ITEM000001",new Item(1.00,"��ë��",true));
			put("ITEM000003", new Item(5.50,"ƻ��",false));
			put("ITEM000005", new Item(3.00,"�ɿڿ���",true));
		}
	};
	
	public static void main(String[] args) throws Exception {
		String[] testInputItem = new String[] { "ITEM000001", "ITEM000001",
				"ITEM000001", "ITEM000001", "ITEM000001", "ITEM000003-2",
				"ITEM000005", "ITEM000005", "ITEM000005" };
		Map<String,Map<String,String>>  resultMap = getItemsResult(testInputItem);
		printResult(resultMap);
	}
	

	/**
	 * Return ��Ʒ������
	 * @param items ��Ʒ�б�
	 * @return ��Ʒ������
	 */
	public static Map<String,Map<String,String>> getItemsResult(String[] items){
		Map<String,Map<String,String>> resultMap = getItemNum(items);
		Iterator<String> iterator = resultMap.keySet().iterator();
		while(iterator.hasNext()){
			String itemId = iterator.next().toString();
			Map<String,String> itemMap = resultMap.get(itemId);
			calculateItem(itemId, itemMap);
		}
		return resultMap;
	}
	
	/**
	 * Return ���㵥����Ʒ������ܶ�������Լ��Żݽ���Żݸ���
	 * @param map ��Ʒ�����б�
	 * @param itemId ��Ʒ���
	 * @return ��Ʒ������
	 */
	public static void calculateItem(String itemId,Map<String,String> map){
		Item item = itemMap.get(itemId);
		int num = Integer.parseInt(map.get("num").toString());
		int payNum = num;
		if(item.isPromotion){
			payNum = (num % 3)+ (num/3)*2;
		}
		double totalPrice = payNum * item.price;
		double saveCount = (num-payNum)*item.price;
		map.put("lastNum", String.valueOf(payNum));
		map.put("saveCount", String.valueOf(saveCount));
		map.put("payCount", String.valueOf(totalPrice));
		map.put("promotionNum",String.valueOf(num-payNum));
	}
	
	/**
	 * Return ��ȡ������Ʒ���������
	 * @param map ��Ʒ�����б�
	 * @param itemId ��Ʒ���
	 * @return map ÿ����Ʒ���������������μӻ����Ʒ��
	 */
	public static Map<String,Map<String,String>> getItemNum(String[] items){
		Map<String,Map<String,String>> itemMap = new HashMap<String,Map<String,String>>();
		for(String item:items){
			Map<String,String> map = new HashMap<String,String>();
			if(item.contains("-")){
				String[] tmp = item.split("-");
				map.put("num", tmp[1]);
				itemMap.put(tmp[0], map);
			}else{
				map.put("num", itemMap.get(item) == null?new String("1"):String.valueOf(Integer.parseInt(itemMap.get(item).get("num"))+1));
				itemMap.put(item, map);
			}
		}
		return itemMap;
	}
	
	/**
	 * Return ��ӡ���ܽ�����
	 * @param resultMap ��Ʒ�����ļ����б�
	 * @return void
	 */
	public static void printResult(Map<String,Map<String,String>> resultMap){
		Iterator<String> iterator = resultMap.keySet().iterator();
		double totalPay = 0.00,savePay = 0.00;
		StringBuffer itemBuffer = new StringBuffer("***<ûǮ׬�̵�>�����嵥***\n"),promotionBuffer = new StringBuffer("����������Ʒ��"+"\n");
		while(iterator.hasNext()){
			String itemId = iterator.next().toString();
			Map<String,String> itemMaps = resultMap.get(itemId);
			Item item = itemMap.get(itemId);
			itemBuffer.append("���ƣ�"+item.name+",������"+itemMaps.get("num")+",���ۣ�"+item.price+",С�ƣ�"+itemMaps.get("payCount")+"\n");
			if(Integer.parseInt(itemMaps.get("promotionNum")) > 0){
				promotionBuffer.append("���ƣ�"+item.name+",������"+itemMaps.get("promotionNum")+"\n");
			}
			totalPay += Double.parseDouble(itemMaps.get("payCount"));
			savePay += Double.parseDouble(itemMaps.get("saveCount"));
		}
		System.out.println(itemBuffer.toString()+"----------------------\n"+promotionBuffer.toString()+"----------------------\n"+"�ܼ�: "+totalPay+"(Ԫ)\n"+"��Լ��"+savePay+"(Ԫ)\n");
	}
}
