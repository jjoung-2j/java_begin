package my.day07.b.dowhile;

import java.util.Scanner;

public class Main_factorial_2 {

	public static void main(String[] args) {
		
		// === 입사문제 === //
		/*
			▣ 알고 싶은 팩토리얼 수 입력 => 5엔터
			>> 결과 : 5! = 120
			>> 또 할래?[Y/N] => y
			
			5! ==> 5*4*3*2*1
			71 ==> 7*6*5*4*3*2*1
			
			▣ 알고 싶은 팩토리얼 수 입력 => 0엔터
			>> [경고] 자연수만 입력하세요!!
			
			▣ 알고 싶은 팩토리얼 수 입력 => -5엔터
			>> [경고] 자연수만 입력하세요!!
			
			▣ 알고 싶은 팩토리얼 수 입력 => 1.25엔터
			>> [경고] 정수만 입력하세요!!
			
			▣ 알고 싶은 팩토리얼 수 입력 => 똘똘이엔터
			>> [경고] 정수만 입력하세요!!
			
			▣ 알고 싶은 팩토리얼 수 입력 => 4엔터
			>> 결과 : 4! = 24
			>> 또 할래?[Y/N] => s엔터
			>> [경고] Y 또는 N 만 입력하세요!!
			>> 또 할래?[Y/N] => n엔터
		 */
		
		Scanner sc = new Scanner(System.in);
		outer:
		do {
			try {
				System.out.print("▣ 알고 싶은 팩토리얼 수 입력 => ");
				int num = Integer.parseInt(sc.nextLine());
				if(num<=0) {
					System.out.println(">> [경고] 자연수만 입력하세요!!\n");
					continue;	// continue; 를 만나면 아래로 떨어지지 않고 do~while(조건식); 의 조건식으로 들어간다.
				}
				// == 팩토리얼 구하기 시작 == //
				// 5*4*3*2*1
				int factorial = 1;
				for(int i=num;i>0;i--) {
					factorial *= i;	// factorial = factorial * i; 와 같다.
									// factorial = 1 * 5
									// factorial =(1 *)5 * 4
									// factorial = 5 * 4 * 3
									// factorial = 5 * 4 * 3 * 2
									// factorial = 5 * 4 * 3 * 2 * 1
				}	// end of for-----------
				System.out.println(">> 결과 : " + num + "! = " + factorial);
				// == 팩토리얼 구하기 끝 == //
				do {
					System.out.print(">> 또 할래?[Y/N] =>");
					String yn = sc.nextLine();
					if("y".equalsIgnoreCase(yn))
						break;
					else if("n".equalsIgnoreCase(yn)) {
						sc.close();
						break outer;	// 팩토리얼 구하는 프로그램 종료
					}
					else {
						System.out.println(">> [경고] Y 또는 N 만 입력하세요!!\n");
					}
				} while (true);
				// end of do~while-------------
			} catch(NumberFormatException e) {
				System.out.println(">> [경고] 정수만 입력하세요!!\n");
			}
		} while (true);
		// end of do~while -------------------
		
		System.out.println("\n>>> 프로그램 종료<<<");
		
		// 값이 int 범위를 넘어가면 '0' 으로 뜨기때문에 long 타입으로 바꿔주면 가능
		/*
		Scanner sc = new Scanner(System.in);
		outer:
		do {
			try {
				System.out.print("▣ 알고 싶은 팩토리얼 수 입력 => ");
				long num = Integer.parseInt(sc.nextLine());
				if(num<=0) {
					System.out.println(">> [경고] 자연수만 입력하세요!!\n");
					continue;	// continue; 를 만나면 아래로 떨어지지 않고 do~while(조건식); 의 조건식으로 들어간다.
				}
				// == 팩토리얼 구하기 시작 == //
				// 5*4*3*2*1
				long factorial = 1;
				for(long i=num;i>0;i--) {
					factorial *= i;	// factorial = factorial * i; 와 같다.
									// factorial = 1 * 5
									// factorial =(1 *)5 * 4
									// factorial = 5 * 4 * 3
									// factorial = 5 * 4 * 3 * 2
									// factorial = 5 * 4 * 3 * 2 * 1
				}	// end of for-----------
				System.out.println(">> 결과 : " + num + "! = " + factorial);
				// == 팩토리얼 구하기 끝 == //
				do {
					System.out.print(">> 또 할래?[Y/N] =>");
					String yn = sc.nextLine();
					if("y".equalsIgnoreCase(yn))
						break;
					else if("n".equalsIgnoreCase(yn)) {
						sc.close();
						break outer;	// 팩토리얼 구하는 프로그램 종료
					} else
						System.out.println(">> [경고] Y 또는 N 만 입력하세요!!\n");
				} while (true);
				// end of do~while-------------
			} catch(NumberFormatException e) {
				System.out.println(">> [경고] 정수만 입력하세요!!\n");
			}
		} while (true);
		// end of do~while -------------------
		
		System.out.println("\n>>> 프로그램 종료<<<");
		*/
		/*
		Scanner sc = new Scanner(System.in);
		outer:
		for(;;) {
			try {
				System.out.print("▣ 알고 싶은 팩토리얼 수 입력 => ");
				int num = Integer.parseInt(sc.nextLine());
				if(num<=0) {
					System.out.println(">> [경고] 자연수만 입력하세요!!\n");
					continue;	// continue; 를 만나면 아래로 떨어지지 않고 do~while(조건식); 의 조건식으로 들어간다.
				}
				// == 팩토리얼 구하기 시작 == //
				// 5*4*3*2*1
				int factorial = 1;
				for(int i=num;i>0;i--) {
					factorial *= i;	// factorial = factorial * i; 와 같다.
									// factorial = 1 * 5
									// factorial =(1 *)5 * 4
									// factorial = 5 * 4 * 3
									// factorial = 5 * 4 * 3 * 2
									// factorial = 5 * 4 * 3 * 2 * 1
				}	// end of for-----------
				System.out.println(">> 결과 : " + num + "! = " + factorial);
				// == 팩토리얼 구하기 끝 == //
				for(;;) {
					System.out.print(">> 또 할래?[Y/N] =>");
					String yn = sc.nextLine();
					if("y".equalsIgnoreCase(yn))
						break;
					else if("n".equalsIgnoreCase(yn)) {
						sc.close();
						break outer;	// 팩토리얼 구하는 프로그램 종료
					} else
						System.out.println(">> [경고] Y 또는 N 만 입력하세요!!\n");
				} // end of for-------------
			} catch(NumberFormatException e) {
				System.out.println(">> [경고] 정수만 입력하세요!!\n");
			}
		} // end of for -------------------
		
		System.out.println("\n>>> 프로그램 종료<<<");
	*/
	}	// end of main()---------------------------

}
