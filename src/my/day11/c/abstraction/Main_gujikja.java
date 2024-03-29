package my.day11.c.abstraction;

import java.util.Scanner;

public class Main_gujikja {

	public static void main(String[] args) {
		
		Gujikja[] gu_arr = new Gujikja[5];
		
		///////////////////////////////////////////////////////////
		Gujikja gu1 = new Gujikja();
	    gu1.userid = "eomjh";
	    gu1.passwd = "qWer1234$";
	    gu1.name = "엄정화";
	    gu1.jubun = "8610201";
		gu_arr[Gujikja.count++] = gu1;		// 구직자 클래스에 가서 static count 선언하기
	    
	    Gujikja gu2 = new Gujikja();
	    gu2.userid = "leess";
	    gu2.passwd = "abCd12345$";
	    gu2.name = "이순신";
	    gu2.jubun = "8601201";
	    gu_arr[Gujikja.count++] = gu2;
	    
	    Gujikja gu3 = new Gujikja();
	    gu3.userid = "chaew";
	    gu3.passwd = "aSdf1234$";
	    gu3.name = "차은우";
	    gu3.jubun = "0106203";
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
	    Ctrl_gujikja ctrl = new Ctrl_gujikja();	// ctrl에 있는 메소드 사용하기 위해 가져옴
	    
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
