package my.day05.f.For.quiz;

import java.util.Scanner;

public class Main_quiz_3 {

	public static void main(String[] args) {
	      // ▣ 첫번째 정수 : 1
	      // ▣ 두번째 정수 : 10
	      
	      // >> 결과 <<
	      // 1 부터 10 까지의 홀수의 합 : 25
	      // 1 부터 10 까지의 짝수의 합 : 30
	      
	   //   -----------------------------------
	      
	      // ▣ 첫번째 정수 : 2
	      // ▣ 두번째 정수 : 10
	      
	      // >> 결과 <<
	      // 2 부터 10 까지의 홀수의 합 : 24
	      // 2 부터 10 까지의 짝수의 합 : 30
	      
	      
	      // ▣ 첫번째 정수 : 2.3453
	      // [경고] 올바른 정수를 입력하세요!!
		  
		  // ▣ 첫번째 정수 : 1
	      // ▣ 두번째 정수 : 똘똘이
		  // >> 결과 <<
	      // [경고] 올바른 정수를 입력하세요!!

		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			try {
				System.out.println("▣ 첫번째 정수 : ");
				int n1 = Integer.parseInt(sc.nextLine());
				
				System.out.println("▣ 두번째 정수 : ");
				int n2 = Integer.parseInt(sc.nextLine());
			 
				int result1 = 0;// 홀수의 누적의 합계를 저장하는 변수
				int result2 = 0;// 짝수의 누적의 합계를 저장하는 변수
				
				int holsu = 0, jjaksu = 0;	// 2씩 증가하는 용도
				// n1 => 1	또는 n1 => 2
				// n2 => 10 또는 n2 => 10
				
				if(n1 % 2 != 0)	{	// 첫번째 입력받은 값이 홀수 이라면
					holsu = n1;
					jjaksu = n1 +1;
				} else {	// 첫번째 입력받은 값이 짝수 이라면
					holsu = n1+1;
					jjaksu = n1;
				}
				
				// === 홀수 및 짝수의 합을 구한다. === //
				for(;;) {
					if(holsu <= n2)
						result1 += holsu;
					if(jjaksu <= n2)
						result2 += jjaksu;
					
					holsu += 2;
					jjaksu += 2;
					
					if(n2 < holsu && n2 <jjaksu) { 
						// holsu(1 3 5 7 9 11 13) 	n2 (10)	n2 (11)
						// jjaksu(2 4 6 8 10 14) 	n2 (10) n2 (11)
						
						// holsu(3 5 7 9 11 13)	n2(10) n2 (11)
						// jjaksu(2 4 6 8 10 12)n2(10) n2 (11)
						break;
						
					}
				
				}	// end of for--------------------------
				
				System.out.println("\n>> 결과 <<");
				System.out.println(n1 + " 부터 " + n2 + "까지의 홀수의 합 : " + result1 + "\n"
								+ n1 + " 부터 " + n2 + "까지의 짝수의 합 : " + result2 + "\n");
				
				sc.close();
				break;
			
			} catch(NumberFormatException e) {
				System.out.println("[경고] 올바른 정수를 입력하세요!!\n");
			}
			
		}	// end of for
			System.out.println(">> 프로그램 종료 <<");
		
	}	// end of public static void main(String[] args)

}
