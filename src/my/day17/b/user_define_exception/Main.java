package my.day17.b.user_define_exception;

public class Main {

	public static void main(String[] args) {
		
		Product_imple p1 = new Product_imple();
		p1.setProd_name("새우깡");
		p1.setJango(100);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		// === Product_imple 클래스에서 toString() 메소드를 오버라이딩(재정의) 하기 전 === //
		System.out.println(p1);
		// my.day17.b.user_define_exception.Product_imple@6f75e721
		
		System.out.println(p1.toString());		// toString은 파라미터 x, return타입 : String
		// my.day17.b.user_define_exception.Product_imple@6f75e721
		*/
		
		/*
		// === Product_imple 클래스에서 toString() 메소드를 오버라이딩(재정의) 한 이후 === //
		System.out.println(p1);					// 자바에서 알아서 toString 에 재정의하면 옮겨준다.
		// 1.제품명 : 새우깡
		// 2.잔고량 : 100개
		
		System.out.println(p1.toString());		// toString은 파라미터 x, return타입 : String
		// 1.제품명 : 새우깡
		// 2.잔고량 : 100개
		*/
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Product_imple p2 = new Product_imple();
		p2.setProd_name("감자깡");
		p2.setJango(50);
		
		Product_imple p3 = new Product_imple();
		p3.setProd_name("양파링");
		p3.setJango(150);		
		
		Product[] prod_arr = new Product[3];		// interface 를 저장소로 사용
		prod_arr[0] = p1;
		prod_arr[1] = p2;
		prod_arr[2] = p3;
		
		for(Product prod : prod_arr) {			// 배열요소 0 번째 p1 => prod  / 배열요소 1번째 p2 => prod / 배열요소 2번째 p3 => prod
			System.out.println(prod);			// prod = prod.toSting 같은 것		// 개선된 for 문
		}	// end of for--------------------
		/*
			1.제품명 : 새우깡
			2.잔고량 : 100개
			
			1.제품명 : 감자깡
			2.잔고량 : 50개
			
			1.제품명 : 양파링
			2.잔고량 : 150개
		 */
		
		System.out.println("\n" + "=".repeat(80) + "\n");
		
		try {
			prod_arr[0].order(30);
		} catch (Jango_lack_Exception e) {				// thorw 로 던진 것을 catch 한다.
			e.printStackTrace();
		}
		/*
			새우깡 제품을 30개를 주문하셨습니다.
			1.제품명 : 새우깡
			2.잔고량 : 70개
		 */
		
		System.out.println("\n=================\n");
		
		try {
			prod_arr[1].order(80);						// order() 메소드 사용
		} catch (Jango_lack_Exception e) {				// thorw 로 던진 것을 catch 한다.
			// e.printStackTrace();
			System.out.println("예외메시지 : " + e.getMessage());
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		try {
			prod_arr[2].jumun(200);						// jumun() 메소드 사용
		} catch (Jango_lack_Exception e) {				// thorw 로 던진 것을 catch 한다.
			// e.printStackTrace();
			System.out.println("예외메시지 : " + e.getMessage());
		}
	}	// end of main()--------------

}
