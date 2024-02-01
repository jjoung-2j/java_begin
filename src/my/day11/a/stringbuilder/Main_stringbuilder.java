package my.day11.a.stringbuilder;

public class Main_stringbuilder {

	public static void main(String[] args) {
		
		String name = "일순신";    // 메모리상에  name 1개 소모
	    name += ",이순신";  // 메모리상에  name 1개 소모
	    name += ",삼순신";  // 메모리상에  name 1개 소모
	    name += ",사순신";  // 메모리상에  name 1개 소모
	    name += ",오순신";  // 메모리상에  name 1개 소모
	    name += ",육순신";  // 메모리상에  name 1개 소모
	    name += ",칠순신";  // 메모리상에  name 1개 소모
	    name += ",팔순신";  // 메모리상에  name 1개 소모 
	    name += ",구순신";  // 메모리상에  name 1개 소모
	     
	    // 누적되어진 메모리상의 name은 9개 소모된다고 한다. 		// 가능하지만 메모리에 낭비가 심하다.
  
		System.out.println(name);
		  
		name = "끝";
		System.out.println(name);
		  
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~\n");
		// 메모리의 낭비가 심하기 때문에 권장사항
		
		StringBuffer sb_1 = new StringBuffer();
		// StringBuffer 는 Multi thread 를 지원해준다.						// 차이점! 무겁고 느리지만 Multi thread 지원, 게임
	    // 그래서 Multi thread 로 움직이는 게임에는 StringBuffer 를 사용한다.
	    // StringBuffer 는 StringBuilder 보다 무겁고 동작속도가 떨어지지만
	    // Multi thread 를 지원해주므로 게임에서 사용하는 것이 적합하다.
		sb_1.append("일순신");
		sb_1.append(",이순신");
		sb_1.append(",삼순신");
		sb_1.append(",사순신");
		sb_1.append(",오순신");
		sb_1.append(",육순신");
		sb_1.append(",칠순신");
		sb_1.append(",팔순신");
		sb_1.append(",구순신");
		
		System.out.println(sb_1.toString());					// 정상인 경우
		// 일순신,이순신,삼순신,사순신,오순신,육순신,칠순신,팔순신,구순신
		System.out.println(sb_1);								// 생략하더라도 작동한다.
		// 일순신,이순신,삼순신,사순신,오순신,육순신,칠순신,팔순신,구순신

		System.out.println("\n"+"=".repeat(20)+"\n");	// repeat 사용해보기
		
		StringBuilder sb_2 = new StringBuilder();
		// StringBuilder 는 Multi thread 를 지원해주지 못하고 			// 차이점! Single thread만 지원, 웹, 가볍고 빠르다
		// StringBuilder 는 Single thread 만 지원해준다.
		// Single thread 로 움직이는 웹에는 StringBuilder 를 사용한다.
		// 왜냐하면 StringBuilder 가 StringBuffer 보다 가볍고 또한 동작속도가 빠르므로 그렇다. 
		sb_2.append("일순신");
		sb_2.append(",이순신");
		sb_2.append(",삼순신");
		sb_2.append(",사순신");
		sb_2.append(",오순신");
		sb_2.append(",육순신");
		sb_2.append(",칠순신");
		sb_2.append(",팔순신");
		sb_2.append(",구순신");
		
		System.out.println(sb_2.toString());					// 정상인 경우
		// 일순신,이순신,삼순신,사순신,오순신,육순신,칠순신,팔순신,구순신
		System.out.println(sb_2);								// 생략하더라도 작동한다.
		// 일순신,이순신,삼순신,사순신,오순신,육순신,칠순신,팔순신,구순신
		
		System.out.println("\n"+"~".repeat(35)+"\n");
		
		// StringBuilder sb_2 의 초기화 하는 첫번째 방법
		sb_2.setLength(0);					// 초기화
		sb_2.append("다시 처음부터 시작");
		sb_2.append("끝");
		System.out.println(sb_2.toString());
		System.out.println(sb_2);
		
		// StringBuilder sb_2 의 초기화 하는 두번째 방법
		sb_2 = new StringBuilder();			// 초기화
		sb_2.append("또 다시 처음부터 시작");
		sb_2.append("끝");
		System.out.println(sb_2.toString());
		System.out.println(sb_2);
		
		// === 문자열 거꾸로 뒤집기 ===
		String str = "안녕하세요";
		StringBuffer sb_3 = new StringBuffer(str);
		str = sb_3.reverse().toString();		// 거꾸로바꾸기.string타입으로 바꾸기
		System.out.println(str);
		// 요세하녕안
		
		str = "안녕하세요";
		StringBuilder sb_4 = new StringBuilder(str);
		str = sb_4.reverse().toString();		// 거꾸로바꾸기.string타입으로 바꾸기
		System.out.println(str);
		// 요세하녕안
		
	}	// end of main()-------------

}