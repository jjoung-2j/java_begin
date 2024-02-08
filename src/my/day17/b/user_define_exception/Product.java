package my.day17.b.user_define_exception;

public interface Product {

	// 주문받기1 (기본생성자 사용)
	void order(int jumun_su) throws Jango_lack_Exception;	// 개발자가 만든 클래스(사용자가 정의하는 exception)
	
	// 주문받기2 (파라미터가 있는 생성자 사용)
	void jumun(int jumun_su) throws Jango_lack_Exception;
}
