package my.day06.a.multifor;

public class Main_homework_5 {

	public static void main(String[] args) {
		
		// 1. 제출할 파일명 :  본인이름_Main_homework_5.java.txt (txt 파일로 제출함)
		   // 2. 메일주소 :  tjdudgkr0959@naver.com
		   // 3. 제출기한 :  1월26일(금) 18:00 까지 
		   // 4. 자바소스 :  for 문 사용하여 만들것.      
		      
		System.out.println("== 숙제 1 ==");
		for(int i=1;i<=5;i++) {	
			for(int j=1;j<=i;j++) {
			System.out.print("*");
			}	// end of for-----
			System.out.print("\n");
		}	// end of for-------
		/*
		 	== 숙제 1 ==
			*
			**
			***
			****
			*****
		 */	
		
		System.out.println("== 숙제 2 ==");
		
		for(int i=1;i<=5;i++) {
			
			for(int j=5;j>=i;j--) {
				System.out.print(" ");
			}	// end of for-----------
			for(int z=1;z<=i;z++) {
				System.out.print("*");
			}	// end of for-----------
			System.out.println();
		}	// end of for--------
		/*
		== 숙제 2 ==
		     *
		    **
		   ***
		  ****
		 *****	
		 */
		
		System.out.println("== 숙제 3 ==");
		
		for(int i=1;i<=5;i++) {
			for(int j=5;j>=i;j--) {
				System.out.print("*");
			}	// end of for
			System.out.println();
		}	// end of for
		/*
			== 숙제 3 ==
			*****
			****
			***
			**
			*
		 */
		
		System.out.println("== 숙제 4 ==");
		for(int i=1;i<=3;i++) {			
			for(int j=3;j>=i;j--) {		
				System.out.print(" ");
			}	// end of for-----------
			for(int z=1;z<=(i*2)-1;z++) {	
				System.out.print("*");
			}	// end of for-----------
			System.out.println();
		}	// end of for--------
		
		/*
		== 숙제 4 ==
		   *
		  ***
		 *****
		*/
		
		System.out.println("== 숙제 5 ==");
		for(int i=1;i<=3;i++) {	
			for(int j=0;j<(i*2)-i;j++) {	// Point. "-i"
				System.out.print(" ");
			}	// end of for-----------
			for(int z=5;z>=(i*2)-1;z--) {
				System.out.print("*");
			}	// end of for-----------
			System.out.println();
		}
		/*
			== 숙제 5 ==
			 *****
			  ***
			   *
		 */

		System.out.println("== 숙제6 ==");
		
		for(int i=1;i<=3;i++){
			for(int j=3;j>=i*2-i;j--) {
				System.out.print(" ");
			}
			for(int z=1;z<=i*2-1;z++) {
				System.out.print("*");
			}
			System.out.println();
		}	// end of for
		
		for(int i=1;i<=2;i++) {			//12
			for(int j=0;j<=i;j++) {	//2
				System.out.print(" ");
			}	// end of for-----------
			for(int z=3;z>=(i*2)-1;z--) {
				System.out.print("*");
			}	// end of for-----------
			System.out.println();
		}	// end of for---------
		/*
			== 숙제6 ==
			   *
			  ***
			 *****
			  ***
			   *
		 */
		
		System.out.println("== 입사문제 ==");
		
		for(int i=1;i<=9;i++) {
			for(int j=9;j>=i;j--) {
				System.out.print("*");
			}	// end of for---------
			System.out.print(i);
			System.out.println();
		}	// end of for-----------
		/*
			== 입사문제 ==
			*********1
			********2
			*******3
			******4
			*****5
			****6
			***7
			**8
			*9

		 */
		
	}	// end of main()----------------

}
