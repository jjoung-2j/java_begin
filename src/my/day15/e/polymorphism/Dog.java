package my.day15.e.polymorphism;

public class Dog extends Animal{

	// Dog 만 가지는 field 를 정의 (추상화)
	private int weight;

	// Dog 만 가지는 method 를 정의 (추상화)
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if(weight > 0)
			this.weight = weight;
	}	// end of public void setWeight(int weight)-----------

	// == 메소드의 오버라이딩(메소드의 재정의) == //
	@Override
	protected void view_info() {
		System.out.println("==== 강아지 정보 ====\n"
						+ "1. 성명 : " + super.getName() + "\n"
						+ "2. 생년 : " + super.getBirth_year() + "년\n"
						+ "3. 몸무게 : " + this.weight + "kg\n");
	}	// end of protected void view_info()-----------------

	@Override
	protected void action() {
		System.out.println("[강아지가 빠르게 달립니다~~~]");
	}	// end of protected void action()-----------------
	
}
