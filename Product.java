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
	//商品类，包括商品名称，单品价格，是否促销信息
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
	
	//存放商品信息
	public static Map<String, Item> itemMap = new HashMap<String, Item>() {
		{
			put("ITEM000001",new Item(1.00,"羽毛球",true));
			put("ITEM000003", new Item(5.50,"苹果",false));
			put("ITEM000005", new Item(3.00,"可口可乐",true));
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
	 * Return 商品结算结果
	 * @param items 商品列表
	 * @return 商品计算结果
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
	 * Return 计算单个商品种类的总额，个数，以及优惠金额优惠个数
	 * @param map 商品集合列表
	 * @param itemId 商品编号
	 * @return 商品计算结果
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
	 * Return 获取单个商品种类的数量
	 * @param map 商品集合列表
	 * @param itemId 商品编号
	 * @return map 每个商品包含个数（包含参加活动的商品）
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
	 * Return 打印最总结算结果
	 * @param resultMap 商品结算后的集合列表
	 * @return void
	 */
	public static void printResult(Map<String,Map<String,String>> resultMap){
		Iterator<String> iterator = resultMap.keySet().iterator();
		double totalPay = 0.00,savePay = 0.00;
		StringBuffer itemBuffer = new StringBuffer("***<没钱赚商店>购物清单***\n"),promotionBuffer = new StringBuffer("挥泪赠送商品："+"\n");
		while(iterator.hasNext()){
			String itemId = iterator.next().toString();
			Map<String,String> itemMaps = resultMap.get(itemId);
			Item item = itemMap.get(itemId);
			itemBuffer.append("名称："+item.name+",数量："+itemMaps.get("num")+",单价："+item.price+",小计："+itemMaps.get("payCount")+"\n");
			if(Integer.parseInt(itemMaps.get("promotionNum")) > 0){
				promotionBuffer.append("名称："+item.name+",数量："+itemMaps.get("promotionNum")+"\n");
			}
			totalPay += Double.parseDouble(itemMaps.get("payCount"));
			savePay += Double.parseDouble(itemMaps.get("saveCount"));
		}
		System.out.println(itemBuffer.toString()+"----------------------\n"+promotionBuffer.toString()+"----------------------\n"+"总计: "+totalPay+"(元)\n"+"节约："+savePay+"(元)\n");
	}
}
