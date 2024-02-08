package my.day16.b.INTERFACE;

public class Triangle implements Figure {
// Triangle 이라는 클래스는 Figure 라는 인터페이스를 implements(구현)한다는 말이다.
	
	@Override
	public double area(double x, double y) {
		return x*y*0.5;
	}

	// 추상메소드(미완성 메소드) 는 내가 사용하지 않더라도 반드시 구현해야 된다.
	@Override
	public double circle_area(double r) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double circle_area(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
