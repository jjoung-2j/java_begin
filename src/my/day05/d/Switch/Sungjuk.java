package my.day05.d.Switch;

public class Sungjuk {

	// === field ===
	String hakbun;	// "091234"
	String name;
	byte kor;	// 0 ~ 100 로 제한	byte -128 ~ 127
	byte eng;	// 0 ~ 100 로 제한	byte -128 ~ 127
	byte math;	// 0 ~ 100 로 제한	byte -128 ~ 127
	
	// === method ===
	boolean check_jumsu(byte jumsu){
		
		if(0 <= jumsu && jumsu <= 100) {
			return true; 	// return 을 만나면 해당 메소드가 종료가 된다.
		}
		else {
			System.out.println("[경고] 입력하시는 점수는 0 이상 100 이하 이어야만 합니다.\n");
			return false;
		}
		
	} // end of boolean check_jumsu(byte jumsu)-------------------
	
	void sungjuk_print() {

	float avg = (kor+eng+math)/3.0F;
	
	char hakjum = ' ';
	/*
	if(avg >= 90) {
		hakjum = 'A';
	}
	else if(avg >= 80) {
		hakjum = 'B';
	}
	else if(avg >= 70) {
		hakjum = 'C';
	}
	else if(avg >= 60) {
		hakjum = 'D';
	}
	*/
	// byte n = 0;
	// short n = 0;
	// int n = 0;
	// long n = 0;		==> 불가함. // switch 문에 불가능
	// float n = 0.0F;	==> 불가함.
	// double n = 0.0;	==> 불가함.
	// char n = ' ';
	// String n = "";
	
	switch (((byte)avg)/10) {	// switch 에 들어올 비교대상값은 정수형 중 long 을 제외한 나머지인 byte, short, int 만 가능하다.!!!
							// switch 에 들어올 비교대상값으로 float 및 double 은 불가하다.
							// switch 에 들어올 비교대상값으로 char 및 String 타입은 가능하다.
		case 10 :	// case 10 : case 9: 이말은 '또는' 이라는 뜻!
		case 9 :	// 90 <= (byte)avg <= 99
					// 90	 91		 92	 93		94 .... 98 99
					// 90/10 91/10 92/10 93/10 94/10 98/10 99/10
					// 9	  9		  9	  9		  9 	9  	9
			hakjum = 'A';
			break;
	
		case 8 :	// ((byte)avg)/10) 값이 8이라면
			hakjum = 'B';
			break;
		case 7 :	// ((byte)avg)/10) 값이 7이라면
			hakjum = 'C';
			break;
		case 6 :	// ((byte)avg)/10) 값이 6이라면
			hakjum = 'D';
			break;
		
		default:	// ((byte)avg)/10) 값이 10,9,8,7,6 을 제외한 다른 값
			hakjum = 'F';
			break;
	}	// end of switch((byte)avg)/10)----------------------
	
	String gift = "";
	
	switch (hakjum) {
		case 'A':
			gift += "놀이공원이용권, ";	// gift = gift + "놀이공원이용권, ";
									// gift = "" + "놀이공원이용권, "
		case 'B':
			gift += "치킨, ";			// gift = gift + "치킨, ";
			
		case 'C':
			gift += "피자, ";			// gift = gift + "피자, ";
			
		case 'D':
			gift += "스파게티";			// gift = gift + "스파게티, ";
			break;	// break; 를 만나야만 switch case 문을 빠져나감.
		default:
			gift = "꿀밤3대";
			break;
	}
	
	System.out.println("\n=== " + name + "님의 성적결과 ===" + "\n"
			+ "1. 학번 : " + hakbun + "\n"
			+ "2. 성명 : " + name + "\n"
			+ "3. 국어 : " + kor + "\n"
			+ "4. 영어 : " + eng + "\n"
			+ "5. 수학 : " + math + "\n"
			+ "6. 총점 : " + (kor+eng+math) + "\n"
			+ "7. 평균 : " + Math.round(avg*10)/10.0 + "\n"
			+ "8. 학점 : " + hakjum + "\n"
			+ "9. 선물 : " + gift + "\n"
			);
	}
}
