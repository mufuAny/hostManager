package com.entity;

public class Foods {
	private int food_id;
	private String food_name;
	private String food_classify;
	private int food_price;
	private String food_declare;
	private String food_picture;
	
	public Foods(){}
	public Foods(int foodId, String foodName, String foodClassify,
			int foodPrice, String foodDeclare, String foodPicture) {
		super();
		food_id = foodId;
		food_name = foodName;
		food_classify = foodClassify;
		food_price = foodPrice;
		food_declare = foodDeclare;
		food_picture = foodPicture;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int foodId) {
		food_id = foodId;
	}
	
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String foodName) {
		food_name = foodName;
	}
	public String getFood_classify() {
		return food_classify;
	}
	public void setFood_classify(String foodClassify) {
		food_classify = foodClassify;
	}
	public int getFood_price() {
		return food_price;
	}
	public void setFood_price(int foodPrice) {
		food_price = foodPrice;
	}
	public String getFood_declare() {
		return food_declare;
	}
	public void setFood_declare(String foodDeclare) {
		food_declare = foodDeclare;
	}
	public String getFood_picture() {
		return food_picture;
	}
	public void setFood_picture(String foodPicture) {
		food_picture = foodPicture;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getFood_id()+this.getFood_name().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
		{
			return true;
		}
		if(obj instanceof Foods)
		{
			Foods i = (Foods)obj;
			if(this.getFood_id()==i.getFood_id()&&this.getFood_name().equals(i.getFood_name()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public String toString()
	{
		return "商品编号："+this.getFood_id()+",商品名称："+this.getFood_name();
	}
		
}
