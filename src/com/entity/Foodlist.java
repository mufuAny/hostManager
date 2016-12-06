package com.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Foodlist {
	//购买商品的集合
	private HashMap<Foods,Integer> goods;
	
	//购物车的总金额
	private double totalPrice;
	
	private int shu;

	public int getShu() {
		return shu;
	}


	public void setShu(int shu) {
		this.shu = shu;
	}


	//构造方法
	public Foodlist()
	{
		goods = new HashMap<Foods,Integer>();
		totalPrice = 0.0;
	}
	
	
	public HashMap<Foods, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Foods, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//添加商品进购物车的方法
	public boolean addGoodsInCart(Foods item ,int number)
	{
		if(goods.containsKey(item))
		{
			goods.put(item, goods.get(item)+number);
		}
		else
		{
			goods.put(item, number);	
		}
		calTotalPrice(); //重新计算购物车的总金额
		shu+=number;
		return true;
	}
	
	//删除商品的方法
	public boolean removeGoodsFromCart(Foods item)
	{	int s1=goods.size();
		goods.remove(item);
		int s2=goods.size();
		shu-=(s1-s2);
		calTotalPrice(); //重新计算购物车的总金额
		return true;
	}
	
	//统计购物车的总金额
	public double calTotalPrice()
	{
		double sum = 0.0;
		Set<Foods> keys = goods.keySet(); //获得键的集合	
//		shu=goods.size();
		Iterator<Foods> it = keys.iterator(); //获得迭代器对象
	    while(it.hasNext())
	    {
	    	Foods i = it.next();
	    	sum += i.getFood_price()* goods.get(i);	    		
	    }
	    this.setTotalPrice(sum); //设置购物车的总金额
	    return this.getTotalPrice();
	}
	
	public static void main(String[] args) {
		
		//先创建两个商品对象
		Foods i1=new Foods(7,"多宝鱼","海鲜",36,"","007.jpg");
		Foods i2=new Foods(2,"南瓜饼","点心",12,"","002.jpg");
		Foods i3=new Foods(7,"多宝鱼","海鲜",36,"","007.jpg");
		
//		Foods i0 = new Foods(1,"沃特篮球鞋","温州",200,500,"001.jpg");
//		Foods i2 = new Foods(2,"李宁运动鞋","广州",300,500,"002.jpg");
//		Foods i3 = new Foods(1,"沃特篮球鞋","温州",200,500,"001.jpg");
		
		Foodlist c = new Foodlist();
		c.addGoodsInCart(i1, 1);
		c.addGoodsInCart(i2, 2);
		//再次购买沃特篮球鞋，购买3双
		c.addGoodsInCart(i3, 3);
		
		
		//变量购物商品的集合
		Set<Map.Entry<Foods, Integer>> items= c.getGoods().entrySet();
		for(Map.Entry<Foods, Integer> obj:items)
		{
			System.out.println(obj);
		}
		
		
		System.out.println("购物车的总金额："+c.getTotalPrice());
		
	}
}
