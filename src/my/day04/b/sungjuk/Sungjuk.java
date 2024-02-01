package my.day04.b.sungjuk;

public class Sungjuk {

	// === field ===
	String hakbun;	// "091234"
	String name;
	byte kor;	// 0 ~ 100 로 제한	byte -128 ~ 127
	byte eng;	// 0 ~ 100 로 제한	byte -128 ~ 127
	byte math;	// 0 ~ 100 로 제한	byte -128 ~ 127
	short age;	// 20 ~ 50 으로 제한	short -32768 ~ 32767
	char hakjum;
	
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
	
	boolean check_age(short age) {
		
		if(20 <= age && age <= 50) {
			return true;
		}
		else {
			System.out.println("[경고] 입력하시는 나이가 20 이상 50 이하 이어야만 합니다.\n");
			return false;
		}
	}	// end of boolean check_age(short age)-------------------

	void sungjuk_print() {
		/*
		short total = (short) (kor + eng + math);
		byte avg = (byte) (total / 3);
		
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
		else {
			hakjum = 'F';
		}
		
		System.out.println("=== " + name + "님의 성적결과 ===" + "\n"
							+ "1. 학번 : " + hakbun + "\n"
							+ "2. 성명 : " + name + "\n"
							+ "3. 국어 : " + kor + "\n"
							+ "4. 영어 : " + eng + "\n"
							+ "5. 수학 : " + math + "\n"
							+ "6. 총점 : " + total + "\n"
							+ "7. 평균 : " + avg + "\n"
							+ "8. 학점 : " + hakjum + "\n"
							+ "9. 나이 : " + age + "\n");
		
	}	// void sungjuk_print()-------------------
	*/
	float avg = (kor+eng+math)/3.0F;
	
	char hakjum = 'F';
	
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
	
	System.out.println("=== " + name + "님의 성적결과 ===" + "\n"
			+ "1. 학번 : " + hakbun + "\n"
			+ "2. 성명 : " + name + "\n"
			+ "3. 국어 : " + kor + "\n"
			+ "4. 영어 : " + eng + "\n"
			+ "5. 수학 : " + math + "\n"
			+ "6. 총점 : " + (kor+eng+math) + "\n"
			+ "7. 평균 : " + ((kor+eng+math)/3) + "\n"
			+ "8. 학점 : " + hakjum + "\n"
			+ "9. 나이 : " + age + "\n");
	
	
	}
}
