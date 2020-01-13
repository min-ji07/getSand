package model;

public class Sandwich {		// 샌드위치 재료들의 부모클래스 Sandwich
	private String name;		// 메뉴 이름
	private int price;			// 가격
	
	public Sandwich(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
