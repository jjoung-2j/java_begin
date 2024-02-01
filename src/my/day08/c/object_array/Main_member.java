package my.day08.c.object_array;

import java.util.Scanner;

import my.util.MyUtil;

public class Main_member {

	public static void main(String[] args) {
		
		//System.out.println("시작"+ MyUtil.space_delete("  이 순 신")+"끝");
		// 시작이순신끝
		//System.out.println("시작"+ MyUtil.space_delete(null)+"끝");
		// 시작null끝
		/*
		System.out.println("시작"+"             "+"끝");
		System.out.println("시작"+"             ".trim()+"끝"); 		// 양쪽 공백 모두 제거
		
		System.out.println("시작"+"      중  간     "+"끝");
		System.out.println("시작"+"      중  간     ".trim()+"끝");	// 가운데는 제거 X
		
		System.out.println("".trim().isEmpty());				// true
		System.out.println(" ".isEmpty());						// false
		System.out.println("          ".trim().isEmpty());		// true
		System.out.println("  하       ".trim().isEmpty());		// false
		System.out.println("".trim().isEmpty());				// true
		*/
		// int[] arr_subject = new int[7];
		Member[] arr_mbr = new Member[3];
		int mbr_cnt = 0;
		
		/*
		for(int i=0;i<arr_mbr.length;i++) {
			System.out.println(arr_mbr[i]);
		}	// end of for---------------
		*/
		
		Scanner sc = new Scanner(System.in);

		String str_menuno = "";
		// outer:
		do {
		System.out.println("\n=============== >>  메뉴 << ================\n"
							+ "1. 회원가입	2.모든회원조회		3.프로그램종료\n"
							+"===========================================");
		
		System.out.print("▷ 선택하세요 => ");
		
		str_menuno = MyUtil.space_delete(sc.nextLine());
		/*
		if(str_menuno == "1" && str_menuno =="2") {
			
		}
		else {
			System.out.println("== [경고] 메뉴에 없는 것입니다. ==");
		}
		*/
		
		switch (str_menuno) {
		case "1":	// 회원가입
			
			if(mbr_cnt < arr_mbr.length) {
				
				/*
				String id ="";		// while 문 조건에 쓰기 위해 밖으로 뺀다.
				do {
					System.out.print("\n▣ 아이디 : ");
					id = sc.nextLine();
					if(id.trim().isEmpty())
						System.out.println(">>[경고] 아이디값을 공백이 아닌 다른 값으로 입력하세요!!\n");
				}while(id.trim().isEmpty());
				*/
				
				// 강사님. while 문 true 할 경우
				String id ="";
				// 방법1. id:
				id_outer:
				do {
					System.out.print("\n▣ 아이디 : ");
					id = sc.nextLine();
					if(id.trim().isEmpty())
						System.out.println(">>[경고] 아이디값을 공백이 아닌 다른 값으로 입력하세요!!\n");
					else {
						/*
						// 입력한 아이디가 중복된 아이디 인지 검사하기 첫번째 방법  == //
						boolean isDuplicate_id = false;
						for(int i=0;i<mbr_cnt;i++) {		// 배열(arr_mbr)은 String 타입으로 null로 초기화 되어있다.
															// 종료범위 arr_mbr.length 불가
							 if(id.equals(arr_mbr[i].id)) {				
								 System.out.println(id+"는 이미 사용중인 id 이므로 새로운 id 값을 넣으세요.");
								// 방법 1. continue id;
								 isDuplicate_id = true;
								 break;
							 }
						}	// end of for---------------------
						
						if(!isDuplicate_id)
						break;
						*/
						///////////////////////////////////////////////////
						// 입력한 아이디가 중복된 아이디 인지 검사하기 두번째 방법 == //
						// 나와같은 방법(방법 1)

						for(int i=0;i<mbr_cnt;i++) {		// 배열(arr_mbr)은 String 타입으로 null로 초기화 되어있다.
															// 종료범위 arr_mbr.length 불가
							 if(id.equals(arr_mbr[i].id)) {				
								 System.out.println(id+"는 이미 사용중인 id 이므로 새로운 id 값을 넣으세요.");
								 continue id_outer;		// 다시 반복할것이기 때문에 continue 레이블; 로 작성
							 }
						}	// end of for---------------------
						break;
					}
				}while(true);
				// end of do~while---------------------------------

				String passwd ="";
				do {
					System.out.print("▣ 비밀번호 : ");
					passwd = sc.nextLine();
					if(!MyUtil.isCheckPasswd(passwd)) {
						System.out.println(">>[경고] 비밀번호는 8글자 이상 15글자 이하의 영문 대,소문자 및 숫자 및 특수문자가 혼합되어야만 합니다.\n");
					}
					else
						break;
				} while(true);
					
				// 성명은 공백이 없는 한글로만 되어야 하고 글자길이는 2글자 이상 6글자 이하이어야만 한다.
				
				
				String name ="";
				boolean result = false;
				do {
					System.out.print("▣ 성명 : ");
					name = sc.nextLine();
					if(name.trim().isEmpty()) {
						System.out.println(">>[경고] 성명을 공백이 아닌 다른 값으로 입력하세요!!");
					}
					int length = name.length();
					
					if (length <2 || length >6) {
						result = false;
						System.out.println(">>[경고] 성명은 2글자 이상 6글자 이하이어야만 합니다.");
					}
					
					for(int i=0;i<name.length();i++) {
						// 암호에 한글이 들어가 있는지 알아본다.
						char ch = name.charAt(i);   // 양HaeJg
						
						if('가' <= ch && ch <= '힣') {
							result = true;
						}
						
						else {
							System.out.println(">>[경고] 성명은 한글로만 입력하세요!! \n");
							result = false;
							break;
						}
					}// end of for -----------
					
				} while (!result);
				
				// 강사님
				/*
				String name =null;
				do {
					System.out.println("▣ 성명 : ");
					name = sc.nextLine();
					
					boolean isUseName = true;
					
					if(name.length() < 2 || name.length() > 6) {
						isUseName = false;
					}
					else {	// 입력한 성명의 기이가 2글자 이상 6글자 이하인 경우
						 for(int i=0;i<name.length();i++) {
							 if(!('가'<= name.charAt(i) && name.charAt(i) <= '힣')) {
								 isUseName = false;
								 break;
							 }
						 }	// end of for-------------
					}
					if(isUseName) {
						break;		// do~while 문을 빠져나가기 위해.
					}
					else {
						System.out.println(">>[경고] 성명은 공백이 없는 한글로만 2글자 이상 6글자 이하로 입력하세요!! \n");
					}
				} while (true);
				*/
				
				
				Member mbr = new Member();
				mbr.id = id;
				mbr.passwd = passwd;
				mbr.name = name;
				
				arr_mbr[mbr_cnt++] = mbr;
				
				System.out.println(">> 회원가입 성공!! <<\n");
					
			}
			else {
				System.out.println(">> 정원마감되어 회원가입이 불가합니다!!\n");
			}
			
			break;	// switch 문을 빠져나간다.
			
		case "2":	// 모든회원조회
			
			if(mbr_cnt == 0) {
				System.out.println(">> 가입된 회원이 없습니다. <<");
			} else {
				System.out.println("-----------------------------\n"
								+ "아이디	  비밀번호	 성명  \n"
								+ "-----------------------------");
				for(int i=0;i<mbr_cnt;i++) {
					//System.out.println(arr_mbr[i].id+"\t"+arr_mbr[i].passwd+"\t"+arr_mbr[i].name+"\n");
					System.out.println(arr_mbr[i].view_info());
				}	// end of for------------------
			}
			
			/*
				--------------------------
				아이디	  비밀번호	 성명
				--------------------------
				leess	Qwer1234$	이순신
				eomjh	Abcd1234$	엄정화
				youks	Qwer1234$	유관순
				
			 */
			
			break;	// switch 문을 빠져나간다.
			
		case "3":	// 프로그램 종료
			
			break;	// switch 문을 빠져나간다.			// break outer;
		default:	// 메뉴에 존재하지 않는 값
			System.out.println("== [경고] 메뉴에 없는 것입니다. ==");
			continue;
		}	// end of switch--------------------------
		
		 }while(!("3".equals(str_menuno)));	// 입력한 메뉴번호가 3번이라면 반복문을 빠져나와야 한다.
											// .equals 앞에 변수가 오면 안된다!!
											// null 값이 오는 순간 오류발생하기 때문에
		//	end of do~while---------------------------------------------------------------
		sc.close();
		System.out.println("\n ==== 프로그램 종료 ====");
		
	}	// end of main()--------

}
