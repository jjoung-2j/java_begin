package my.day15.e.polymorphism;

import java.text.DecimalFormat;

public class Duck extends Animal{

	// Duck 만 가지는 field 를 정의 (추상화)
	private int price;

	// Duck 만 가지는 method 를 정의 (추상화)
	
	// === getter, setter ===//
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price > 0)
			this.price = price;
	}	// end of public void setPrice(int price)--------------
	
	// == 메소드의 오버라이딩(메소드의 재정의) == //
	@Override
	protected void view_info() {
		System.out.println("==== 오리 정보 ====\n"
						+ "1. 성명 : " + super.getName() + "\n"
						+ "2. 생년 : " + super.getBirth_year() + "년\n"
						+ "3. 가격 : " + new DecimalFormat("#,###").format(this.price) + "원\n");
	}	// end of protected void view_info()-----------------
	
	@Override
	protected void action() {
		System.out.println("[오리는 물가에서 헤엄을 칩니다.^^]");
	}	// end of protected void action()-----------------
	
}
