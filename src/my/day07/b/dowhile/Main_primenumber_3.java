package my.day07.b.dowhile;

import java.util.InputMismatchException;
import java.util.Scanner;

// === 소수란? === 
	// 소수란? 1과 자기 자신밖에 나누어지지 않는 1 이외의 정수 
	// 예> 1 부터 10까지의 소수를 나타내면 
	// 몫이 1이나 자기자신 뿐인 수
	// 소수 : 2, 3, 5, 7 ...

public class Main_primenumber_3 {

	public static void main(String[] args) {
		
		/*
	     >>>>> 실행결과 <<<<<
	     
	     ▷시작 자연수 : 1엔터
	     ▷끝 자연수 : 10엔터 
	     1 부터 10 까지의 소수는?
	     2,3,5,7
	     1부터 10 까지의 소수의 개수? 4개  
	     1부터 10 까지의 소수들의 합? 17 
	     
	     === 프로그램 종료 ===
	     
	     >>>>> 실행결과 <<<<<
	     
	     ▷시작 자연수 : 1엔터
	     ▷끝 자연수 : 똘똘이엔터 
	     >> [경고] 자연수만 입력하세요!! 
	     
	     ▷시작 자연수 : 1엔터
	     ▷끝 자연수 : 20엔터 
	     1 부터 20 까지의 소수는?
	     2,3,5,7,11,13,17,19
	     1부터 20 까지의 소수의 개수? 8개  
	     1부터 20 까지의 소수들의 합? 77 
	     
	     === 프로그램 종료 ===
	           
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(">>>>> 실행결과 <<<<<");
		do {
			try {
				System.out.print("▷시작 자연수 :");
				int start_no = sc.nextInt();	// 1엔터 또는 1.234엔터
				System.out.print("▷끝 자연수 :");
				int end_no = sc.nextInt();	// 10엔터 또는 2.234엔터
				
				// === 소수란? === 
				// 소수란? 1과 자기 자신의 수로만 나누었을때 나머지가 0인 1 이외의 정수를 말한다.
				
				String str_result ="";
				int cnt = 0, sum=0;
				
				for(int i=start_no;i<=end_no;i++) {
					if(i==1) {// 1은 소수가 아니므로 소수인지 아닌지 검사할 필요가 없기에 continue; 를 한다.
						continue;
					}
						/*
						나누기를 했을때 나머지가 얼마가 되는지 일일이 검사를 한다.
						만약에 i 가 2 이라면 ==> 2는 소수이다.
						만약에 i 가 3 이라면 ==> 3%2 != 0	3는 소수이다.
						만약에 i 가 4 이라면 ==> 4%2 == 0	4%3(검사할 필요가 없다)	4는 소수가 아니다.
						만약에 i 가 5 이라면 ==> 5%2 != 0	5%3 != 0 5%4 != 0	5는 소수이다.
						만약에 i 가 6 이라면 ==> 6%2 == 0	6%3(검사할 필요가 없다) 6은 소수가 아니다.
						만약에 i 가 7 이라면 ==> 7%2 != 0	7%3 != 0 7%4 != 0 7%5 != 0 7%6 != 0	7은 소수이다.
						만약에 i 가 8 이라면 ==> 8%2 == 0	8%3(검사할 필요가 없다) 8은 소수가 아니다.
						만약에 i 가 9 이라면 ==> 9%2 != 0	9%3 == 0 9%4(검사할 필요가 없다) 9은 소수가 아니다.
						만약에 i 가 10 이라면 ==> 10%2 == 0	10%3(검사할 필요가 없다) 10은 소수가 아니다.
						 */
					
					boolean isSosu = true;
					
					for(int bunmo=2;bunmo<i;bunmo++) {	// i = start_no ~ end_no 마지막수 전까지
						if(i%bunmo == 0) {
							isSosu = false;
							break;
						}
					}	// end of for----
					
					if(isSosu) {	// 검사대상인 i가 소수이라면
						cnt++;		// 소수의 개수
						sum += i;	// 소수들의 누적 합계
					
						 String add =(cnt==1)?"":",";	// 첫번째 소수는 "" 을 붙여주고, 두번째 이후부터 나오는 소수는 ","를 붙여준다.
						 str_result += add+i;
						
					}
				}	// end of for-------------
				
				System.out.println(start_no + "부터 "+ end_no +"까지의 소수는? "+str_result);
				System.out.println(start_no + "부터 "+ end_no +"까지의 소수의 개수? "+cnt+"개");
				System.out.println(start_no + "부터 "+ end_no +"까지의 소수들의 합? "+sum);

				sc.close();
				break;
			} catch(InputMismatchException e) {
				System.out.println(">> [경고] 자연수만 입력하세요!!\n");
				sc.nextLine();
			}
		} while(true);// end of do- while-----------
			System.out.println("\n=== 프로그램 종료 ===\n");
			
		/* 내생각
			System.out.println(">>>>> 실행결과 <<<<<");
			try {
				do {
					System.out.print("▷시작 자연수 :");
					int n1 = Integer.parseInt(sc.nextLine());
					System.out.print("▷끝 자연수 :");
					int n2 = Integer.parseInt(sc.nextLine());
					
					String str_result ="";
					int cnt = 0, sum=0;
				
					for(int i=n1;i<=n2;i++) {
						if(i==0)
							continue;
						for(int j=2;j<i;j++) {
							if(i%j == 0)
							break;
							}	// end of for------
							
						if(isSosu) {	// 검사대상인 i가 소수이라면
						cnt++;		// 소수의 개수
						sum += i;	// 소수들의 누적 합계
						str_result += i;
						}
					}	// end of for--------
					System.out.println(n1 + "부터 "+ n2 +"까지의 소수는? "+str_result);
					
					System.out.print(n1 + "부터 "+ n2 +"까지의 소수의 개수? "+cnt+"개");
					
					System.out.print(n1 + "부터 "+ n2 +"까지의 소수들의 합? "+sum);
					
					break;
				} while(true);// end of do- while-----------
			} catch(InputMismatchException e) {
					System.out.println(">> [경고] 자연수만 입력하세요!!");
				}
			System.out.println("\n=== 프로그램 종료 ===\n");
		*/	
	}	// end of main()----------------

}
