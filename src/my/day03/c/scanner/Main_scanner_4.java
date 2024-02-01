package my.day03.c.scanner;

import java.util.Scanner;

public class Main_scanner_4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String str_no = "";
		
		try {
			System.out.print("1. 첫번째 정수 입력 : ");
			str_no = sc.nextLine();
			int first_no = Integer.parseInt(str_no);
			
			System.out.print("2. 두번째 정수 입력 : ");
			str_no = sc.nextLine();
			int second_no = Integer.parseInt(str_no);
			
			System.out.println(">> " + first_no + " + " + second_no + " = " + (first_no + second_no));
		} catch(NumberFormatException e) {
			System.out.println("[경고] " + str_no + "는 정수가 아닙니다. 모두 정수를 입력해주세요!!");
		}
	
		sc.close();
		
		/* 
			1. 첫번째 정수 입력 : 10
			2. 두번째 정수 입력 : 20
			>> 10 + 20 = 30
			----------------------
			1. 첫번째 정수 입력 : 10
			2. 두번째 정수 입력 : 똘똘이
			>> [경고] 똘똘이는 정수가 아닙니다. 모두 정수를 입력해주세요!!
			----------------------
			1. 첫번째 정수 입력 : 똘똘이
			>> [경고] 똘똘이는 정수가 아닙니다. 모두 정수를 입력해주세요!!
		 */
	
	}

}
