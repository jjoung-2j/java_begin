package my.day16.a.Final;

// final 로 되어진 클래스는 다른 클래스로 상속해줄 수 없다는 말이다.
// 즉, final 로 되어진 클래스는 다른 클래스에서 부모 클래스로 사용될 수 없다는 말이다.

public final class final_test_parent_4 {

	// field
	String id;
	String name;
	
	// method
	void greeting() {
		System.out.println("~~~ 연습입니다. ~~~");
	}
	
}
