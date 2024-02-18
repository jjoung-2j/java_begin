package my.day15.a.overriding;

public class Child extends Parent{
	
	// 메소드의 오버라이딩(overriding) == 메소드의 재정의
	// 메소드의 오버라이딩(overriding) 시 접근제한자는 부모클래스에서 정의해둔 메소드의 접근제한자와 같거나 또는 허용이 더 큰 것을 해야 한다.
	// 또한 메소드의 오버라이딩(overriding) 시 껍데기(리턴타입 메소드명 파라미터)는 똑같아야 한다. (껍데기 = 큰틀)
	// 알맹이(내용물)는 새롭게 정의해서 만들면 된다.
	
	@Override	// @ 를 애노테이션(어노테이션) 이라고 부른다.
	protected String info() {							// 부모의 메소드가 protected 일 경우
		return "아이디 : " + super.id + "\n"				// protected 나 public 가능
				+ "비밀번호 : " + super.passwd;			// 접근제한자가 부모보다 자식 클래스가 커야 한다.
	}	// end of String info()
	
	/*
	@Override
	String info(int a) {						// 불가능한 경우 -> 부모클래스에는 파라미터 int a 가 없다.
		return "아이디 : " + super.id + "\n"
				+ "비밀번호 : " + super.passwd;
	}	// end of String info()
	*/
}
