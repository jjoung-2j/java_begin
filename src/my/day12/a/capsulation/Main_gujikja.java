package my.day12.a.capsulation;

import java.util.Scanner;

public class Main_gujikja {

	public static void main(String[] args) {
		
		Gujikja[] gu_arr = new Gujikja[5];
		
		///////////////////////////////////////////////////////////
		Gujikja gu1 = new Gujikja();
		gu1.setUserid("eomjh");		// 생성되어진 인스턴시 gu1 에 메소드를 통해 아이디 입력
										// 메소드를 통하지 않을시 String 타입이면 무조건 OK 되기 때문에 설정한 값에 만족하지 않더라도 출력이 된다.
	    gu1.setPasswd("qWer1234$");
	    gu1.setName("엄정화");
	    gu1.setJubun("8610202");
		gu_arr[Gujikja.count++] = gu1;		// 구직자 클래스에 가서 static count 선언하기
	    
	    Gujikja gu2 = new Gujikja();
	    gu2.setUserid("leess");
	    gu2.setPasswd("abCd12345$");
	    gu2.setName("이순신");
	    gu2.setJubun("8601201");
	    gu_arr[Gujikja.count++] = gu2;
	    
	    Gujikja gu3 = new Gujikja();
	    gu3.setUserid("chaew");
	    gu3.setPasswd("aSdf1234$");
	    gu3.setName("차은우");
	    gu3.setJubun("0106203");
	    gu_arr[Gujikja.count++] = gu3;		// 3명으로 나옴, 3명이 저장되어있다!
	    
	    /*
	    Gujikja gu4 = new Gujikja();
	    gu4.userid = "chaew";
	    gu4.passwd = "aSdf1234$";
	    gu4.name = "차은우";
	    gu4.jubun = "0106203";
	    gu_arr[Gujikja.count++] = gu4;
	    Gujikja gu5 = new Gujikja();
	    gu5.userid = "chaew";
	    gu5.passwd = "aSdf1234$";
	    gu5.name = "차은우";
	    gu5.jubun = "0106203";
	    gu_arr[Gujikja.count++] = gu5;
	    //>>> 정원 5명이 꽉차서 구직자 회원가입이 불가합니다.!! <<
	    */
	    ////////////////////////////////////////////////////////////////////////
	    
	    Scanner sc = new Scanner(System.in);
	    Ctrl_gujikja ctrl = new Ctrl_gujikja();
	    
	    String str_menuno ="";
	    do {
			ctrl.main_menu();
			str_menuno = sc.nextLine();
			switch (str_menuno) {
			case "1":	// 구직자 회원가입
				ctrl.register(sc, gu_arr);
				break;
				
			case "2":	// 구직자 모두보기
				ctrl.view_all_info(gu_arr);
				break;
			case "3":	// 검색하기
				ctrl.search_menu(sc, gu_arr);
				break;
			case "4":
				break;
			default:	// 보기에 없는 경우
				System.out.println("[경고] 메뉴에 없는 번호입니다.\n");
				continue;
			}
		} while (!("4".equals(str_menuno)));	// end of do~while------------------------
	    
	    sc.close();
	    System.out.println("\n>>> 프로그램 종료 <<<");
	    
	}	// end of main()-----------------------

}
