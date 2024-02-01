package my.day04.d.calculator;

import java.util.Scanner;

public class Main_calculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String input_str = "";
		
		try {
			System.out.print("▣ 첫번째 정수 입력 => ");
			input_str = sc.nextLine();
			int num1 = Integer.parseInt(input_str);  // 문자열을 정수로 형변환 시킨다. 
			                                         // 10 
			                                         // 오류 경우 : 300000000, 똘똘이
			
			System.out.print("▣ 두번째 정수 입력 => ");
			input_str = sc.nextLine();
			int num2 = Integer.parseInt(input_str);  // 문자열을 정수로 형변환 시킨다. 
			                                         // 4 
			                                         // 오류 경우 : 300000000, 헤헤헤
			
			
			System.out.print("▣ 사칙연산을 선택하세요(+ - * /) : "); 
			String operator = sc.nextLine();
			
			String result = "";
			double calc_result = 0;
			
			if("+".equals(operator)) {
				calc_result = num1 + num2;
			}
			
			else if("-".equals(operator)) {
				calc_result = num1 - num2;
			}
			
			else if("*".equals(operator)) {
				calc_result = num1 * num2;
			}
			
			else if("/".equals(operator)) {
				calc_result = (double)num1 / num2;
			}
			
			else {
				// 사칙연산 선택시 + - * / 를 제외한 다른것을 입력한 경우 
				System.out.println("[경고] 사칙연산 선택은 + - * / 만 입력하세요!!");
				sc.close();
				return; // 종료
			}
			
			if("/".equals(operator)) { 	//  /  인 경우
				
				if(num1%num2 == 0) {
					result = num1 + operator + num2 + "=" + (int)calc_result;
				}
				else {
					result = num1 + operator + num2 + "=" + calc_result;
				}
				      
			}
			else { 	//  + - * 인 경우
				result = num1 + operator + num2 + "=" + (int)calc_result;
			}
			
			System.out.println(result); 
			//  10 + 4 = 14
			//  10 - 4 = 6
			//  10 * 4 = 40
			//  10 / 4 = 2.5  
			
			
		} catch(NumberFormatException e) {
			System.out.println(">>> "+ input_str +" 은 올바른 데이터 아닙니다. 올바른 정수를 입력하세요!!"); 
		} catch(ArithmeticException e) {
			System.out.println(">>> 0 으로 나눌 수 없습니다. <<<");
		}
		
		sc.close();
		
	}// end of public static void main(String[] args)------

}
 