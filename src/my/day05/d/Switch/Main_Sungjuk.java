package my.day05.d.Switch;

import java.util.Scanner;

public class Main_Sungjuk {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Sungjuk sj = new Sungjuk();	// 기본생성자
		
		System.out.print("1. 학번 : ");
		sj.hakbun = sc.nextLine();	// "091234"
		
		System.out.print("2. 성명 : ");
		sj.name = sc.nextLine();	// 이순신
		
		String input_str ="";
		/*
		try {
			System.out.print("3. 국어 : ");
			
			// === *** 유효성 검사하기(올바른 데이터인지 틀린 데이터인지 검사하는 것) *** === //
			
			// sj.kor = Byte.parseByte(sc.nextLine());	// 90
			// sj.eng = Byte.parseByte(sc.nextLine());	// 100
			// sj.math = Byte.parseByte(sc.nextLine()); // 80
			// 오류 경우 발생 
			// 오류 경우 : 101, 2343242, "똘똘이" ...
			input_str = sc.nextLine();
			byte kor = Byte.parseByte(input_str);	// 90
														// 오류 경우 : 101, 2343242, "똘똘이"
			if(!sj.check_jumsu(kor)) {
				sc.close();
				return;		// return 을 만나면 해당 메소드가 종료가 된다.
			}
			else {
				sj.kor = kor;
			}
			
			System.out.print("4. 영어 : ");
			input_str = sc.nextLine();
			byte eng = Byte.parseByte(input_str);	// 100
														// 오류 경우 : -20, 3943242, "호호하하하"		
	
			if(!sj.check_jumsu(eng)) {
				sc.close();
				return;		// return 을 만나면 해당 메소드가 종료가 된다.
			}
			else {
				sj.eng = eng;
			}									
			
			System.out.print("5. 수학 : ");
			input_str = sc.nextLine();
			byte math = Byte.parseByte(input_str);	// 80
													// 오류 경우 : 128, -7843242, "헤헤헤"		
	
			if(!sj.check_jumsu(math)) {
			sc.close();
			return;		// return 을 만나면 해당 메소드가 종료가 된다.
			}
			else {
			sj.math = math;
			}				
		
		} catch(NumberFormatException e) {
			// e.printStackTrace(); 	// 에러위치 알려줌.
			System.out.println(e.getMessage());		// 에러 입력값 알려줌.
			// 점수를 입력해주는 상태이라면
			System.out.println(">> 입력하신 "+ input_str +  "는 올바른 데이터가 아닙니다.\n"
					+ "[점수에 대한 경고] 점수는 0 ~ 100 까지의 정수만 입력하세요!!");
			return;
		}
		
		System.out.print("6. 나이 : ");
		try {
			input_str = sc.nextLine();		// 25
											// 오류 경우 : 70, 50000, "홍대클럽"
			short age = Short.parseShort(input_str);
			
			if(!sj.check_age(age)) {
				sc.close();
				return;		// return 을 만나면 해당 메소드가 종료가 된다.
			}
			else {
				sj.age = age;
			}
			sj.sungjuk_print();
		} catch(NumberFormatException e) {
			// 나이를 입력해주는 상태이라면
			System.out.println(">> 입력하신 "+ input_str +  "는 올바른 데이터가 아닙니다.\n"
							+ "[나이에 대한 경고] 점수는 20 ~ 50 까지의 정수만 입력하세요!!");
		}
		*/
		
		try {
			System.out.print("3. 국어 : ");
			input_str = sc.nextLine();
			byte kor = Byte.parseByte(input_str);
			
			if(!sj.check_jumsu(kor)) {
				sc.close();
				return;		// return 을 만나면 해당 메소드가 종료가 된다.
			}
			else {
				sj.kor = kor;
			}
			
			System.out.print("4. 영어 : ");
			input_str = sc.nextLine();
			byte eng = Byte.parseByte(input_str);	// 100
														// 오류 경우 : -20, 3943242, "호호하하하"		
	
			if(!sj.check_jumsu(eng)) {
				sc.close();
				return;		// return 을 만나면 해당 메소드가 종료가 된다.
			}
			else {
				sj.eng = eng;
			}									
			
			System.out.print("5. 수학 : ");
			input_str = sc.nextLine();
			byte math = Byte.parseByte(input_str);	// 80
													// 오류 경우 : 128, -7843242, "헤헤헤"		
	
			if(!sj.check_jumsu(math)) {
			sc.close();
			return;		// return 을 만나면 해당 메소드가 종료가 된다.
			}
			else {
			sj.math = math;
			}
			
			// 성적출력하기
			sj.sungjuk_print();
		}catch(NumberFormatException e) {
			System.out.println("\n>> 입력하신 "+ input_str +  "는 올바른 데이터가 아닙니다.\n");
			System.out.println("[점수에 대한 경고] 점수는 0 ~ 100 까지의 정수만 입력하세요!!");
		}
		
		sc.close();
		
	}
}


