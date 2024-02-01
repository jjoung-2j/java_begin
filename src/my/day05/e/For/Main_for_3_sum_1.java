package my.day05.e.For;

public class Main_for_3_sum_1 {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i=1; i<=10; i++) {	// 10번 반복
			sum += i;	// sum = sum + i; 와 같은 뜻이다.
						// sum 은 누적의 합을 저장시키는 변수
			
			// sum = 0 + 1; ==> 1번째 반복
			// sum = 1 + 2; ==> 2번째 반복
			// sum = 1 + 2 + 3; ==> 3번째 반복
			// ...........
			// sum = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 ==> 10번째 반복
		
		}

		System.out.println("1 부터 10 까지의 누적 합계 : " + sum );
		// 1 부터 10 까지의 누적 합계 : 55
		
		sum = 0;	// sum 은 누적의 합을 저장시키는 변수
		String str ="";
		for(int i=1; i<=10; i++) {
			if(i<10) 
				// str += i;	// str = str + i; (문자열 결합)
								// str = ""  + 1;
				str += i + "+";	// str = "" + 1 + "+"; 		==> 1번째 반복
								// str = "1+" + 2 + "+";	==> 2번째 반복
								// str ="1+2+" + 3 + "+"; 	==> 3번째 반복
								// ....................
								// str = 1+2+3+4+5+6+7+8+9+10+ ==> 10번째 반복(if(i<10) 안쓸경우)
			 else 
				str += i;		// str = 1+2+3+4+5+6+7+8+9+10 ==> 10번째 반복(if 사용한 경우)
					// end of if-else -------------
			
			sum += i;
		
		}	// end of for --------------
		
		System.out.println(str + "=" + sum);
		// 1+2+3+4+5+6+7+8+9+10=55
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		sum = 0;
		str = "";
		
		for(int i=1; i<=10; i++) {
			// (i)?값1:값2;
			str = (i<10)?str+i+"+":str+i;
			sum += i; 
		}
		
		System.out.println(str + "=" + sum);
		// 1+2+3+4+5+6+7+8+9+10=55
		
		sum = 0;
		str = "";
		
		for(int i=1; i<=10; i++) {
			String add = (i<10)?"+":"=";
			str += i+add;
			sum += i; 
		}	// end of for--------------
		
		System.out.println(str + sum);
		// 1+2+3+4+5+6+7+8+9+10=55

	}

}
