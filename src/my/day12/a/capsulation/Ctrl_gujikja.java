package my.day12.a.capsulation;

import java.util.Scanner;

public class Ctrl_gujikja {

	// == 메인 메뉴를 보여주는 메소드 생성하기 == //
	void main_menu() {
		System.out.println("\n === 메인메뉴 ===\n"
							+ "1. 구직자 회원가입  2. 구직자 모두보기  3.검색하기  4.프로그램종료\n");
		System.out.print("▷ 메뉴번호 선택 : ");
	}	// end of void main_menu()----------------------
	
	// == 구직자(Gujikja) 신규 회원가입시
	//	Gujikja 클래스의 field 의 요구사항에 모두 맞으면
	//	Gujikja[] gu_arr 에 저장시켜주는 메소드 생성하기 ==
	
	void register(Scanner sc, Gujikja[] gu_arr) {
		
		if(Gujikja.count < gu_arr.length) {	// 지금까지 생성된 구직자 회원수가 gu_arr.length(==>정원) 보다 적을 경우에만 신규회원을 받아들인다.
			
			Gujikja gu = new Gujikja();
			
			outer:
			do {
				System.out.print("1.아이디 : ");
				String userid = sc.nextLine();
				
				// == 중복 아이디 검사하기 시작 == //
				for(int i=0; i<Gujikja.count; i++) {
					if(userid.equals(gu_arr[i].getUserid())) {
						System.out.println(">> 이미 사용중인 아이디 이므로 다른 아이디를 입력하세요!!\n");
						continue outer;
					}	
				}	// end of for----------
				// == 중복 아이디 검사하기 끝 == //
				gu.setUserid(userid);
				
			} while(!(gu.getUserid() != null));
			
			// 비밀번호는 필수 입력사항이면서 비밀번호 조건에 맞을때까지 반복해야 한다.
			do {
				System.out.print("2.비밀번호 : ");
				String passwd = sc.nextLine();
				
				gu.setPasswd(passwd);

			} while(!(gu.getPasswd() != null));
			
		// 성명은 필수 입력사항이므로 그냥 엔터나 공백만으로 된 것이 아닐때 까지 반복해야 한다.
		// 성명은 2글자 이상 6글자 이하의 한글로만 되어져야 한다.

			do {
				System.out.print("3.성명 : ");
				String name = sc.nextLine();
				
				gu.setName(name);

			} while(!(gu.getName() != null));
		
		// 주민번호는 필수 입력사항이면서 주민번호 조건에 맞을때까지 반복해야 한다.

			do {
				System.out.print("4.주민번호 : ");
				String jubun = sc.nextLine();
				
				gu.setJubun(jubun);

			} while(!(gu.getJubun() != null));
		
			//////////////////////////////////////////////////////
			
			
		gu_arr[Gujikja.count++] = gu;
		
		System.out.println(">> 구직자 회원가입 성공 !! << \n");
		
		} else {	// 지금까지 생성된 구직자 회원수가 gu_arr.length(==>정원) 와 같거나 큰 경우에만 신규회원을 받아들이면 안된다.
			System.out.println(">>> 정원 " + gu_arr.length + "명이 꽉차서 구직자 회원가입이 불가합니다.!! <<\n");
		}
		
	}	// end of void register(Scanner sc, Gujikja[] gu_arr)-------------

	// === 구직자 모두보기 메소드 ===
	public void view_all_info(Gujikja[] gu_arr) {
		
		/*
			------------------------------------------------------------------------
			아이디    비밀번호     성명    생년월일    성별   현재만나이    가입일자
			------------------------------------------------------------------------
			eomjh	qWe******  엄정화  961002     여       27      2024-01-31 10:30:40
			leess	abC******* 이순신  960120     남       28      2024-01-31 10:30:40
			chaew	aSd******  차은우  010620     남       22      2024-01-31 10:30:40
			------------------------------------------------------------------------
		 */
		
		if(Gujikja.count == 0) {
			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. \n");
		} else {
			title();
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<Gujikja.count;i++) {
				sb.append(gu_arr[i].getInfo()+"\n");	//sb.append 는 쌓아두는 것, gu_arr[i] 의 정보를 getInfo메소드에 담기
			}	// end of for-----------------
		
			System.out.println(sb.toString()); 	// String 타입으로 바꾼것을 찍어라
		}	// end of if---------
		
	}	// end of public void view_all_info(Gujikja[] gu_arr)
	
	void title() {
		System.out.println("-".repeat(80)+"\n"
				+ "아이디    비밀번호          성명    생년월일    성별   현재만나이    가입일자\n"
				+ "-".repeat(80));
	}	// end of voie title()------------------------------

	// 검색하기 메뉴를 보여주는 메소드 생성하기 == // 
	void search_menu(Scanner sc, Gujikja[] gu_arr) {
		String str_menuno = "";		// 지역변수이면 while 문 조건에 사용할 수 없으니 밖으로 뺀다.
		do {
			System.out.println("\n === 검색메뉴 ===\n"
								+ "1. 연령대검색  2. 성별검색  3.연령대 및 성별 검색하기  4.메인메뉴로 돌아가기\n");
			System.out.print("▷ 메뉴번호 선택 : ");
			str_menuno = sc.nextLine();
			
			switch (str_menuno) {
			case "1":	// 연령대 검색
				search_ageLine(sc,gu_arr);
				break;
			case "2":	// 성별검색
				search_gender(sc,gu_arr);
				break;
			case"3":	// 연령대 및 성별 검색하기
				search_ageLine_gender(sc,gu_arr);
				break;
			case"4":	// 메인메뉴로 돌아가기
				break;
			default:
				System.out.println("[경고] 검색메뉴에 존재하는 번호만 입력하세요!!\n");
				break;
			}	// end of switch(str_menuno)------------------
		 } while(!("4".equals(str_menuno)));
	}	// end of public void search_menu(Scanner sc, Gujikja[] gu_arr)----------------



	// === 연령대 검색해주는 메소드 == //
	void search_ageLine(Scanner sc, Gujikja[] gu_arr) {
		
		if(Gujikja.count == 0) {	// 구직자가 존재하지 않는 경우
			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
		} else {	// 구직자가 존재하는 경우
			
			String str_ageLine = "";
			// 강사님
			boolean isUse_ageLine = false;
			// 내방법
			// outer:
			do {
				System.out.print("▷ 검색하고자 하는 연령대 [예: 20] => ");
				str_ageLine = sc.nextLine();		// "0" "10" "20" "30" "40" "50" "60" "70" "80"	-- 정상
														// "25" "강아지" "-20" --> 비정상
				switch (str_ageLine) {
				case "0" :
				case "10":
				case "20":
				case "30":
				case "40":
				case "50":
				case "60":
				case "70":
				case "80":
					isUse_ageLine = true;
					break;
					// 내방법
					// break outer;
				default:
					System.out.println("[경고] 올바른 연령대를 입력하세요!!\n");
					break;
					// 내방법
					// continue;
				}	// end of switch(str_ageLine)----------------------------
			} while(!isUse_ageLine);	// end of do~while----------------
			// 내방법
			//} while(true);	// end of do~while-------------------------------------
			
			// == 입력받은 연령대에 해당하는 구직자 찾기 == //
			StringBuilder sb = new StringBuilder();		// for 문안에 넣으면 반복되기에 밖으로 빼야한다.
			boolean isSearch = false;
			
			for(int i=0; i<Gujikja.count; i++) {
				int ageLine = gu_arr[i].getAge()/10*10;
								// 나이/10*10
								// 26/10*10 ==> 20
								// 23/10*10 ==> 20
				
				if(Integer.parseInt(str_ageLine) == ageLine) {
					isSearch = true;
					sb.append(gu_arr[i].getInfo() + "\n");
				}
			}	// end of for----------------
			
			if(isSearch) {
				title();
				System.out.println(sb.toString());
			}
			else {
				System.out.println("[검색결과 연령대 " + str_ageLine+ "대인 구직자는 없습니다.");
			}
			
		}	// end of if~else---------------------------
	}	// end of void search_ageLine(Scanner sc, Gujikja[] gu_arr)-------------------
	
	// == 성별 검색해주는 메소드 == //
		void search_gender(Scanner sc, Gujikja[] gu_arr) {
			if(Gujikja.count == 0) {	// 구직자가 존재하지 않는 경우
				System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
			} else {	// 구직자가 존재하는 경우
				String input_gender = "";
				boolean isUse_input_gender = false;
				do {
					System.out.print("▷ 검색하고자 하는 성별 [남/여] => ");
					input_gender = sc.nextLine();		// "남" "여" "   남" "여   " "    남    " "   여   " -- 정상
														// "" "       " "강아지" --> 비정상
					switch (input_gender.trim()) {
					case "남" :
					case "여" :
						isUse_input_gender = true;
						input_gender = input_gender.trim();		// 공백을 뺀것을 넣어주기
						break;
					default:
						System.out.println("[경고] \"남\" 또는 \"여\" 만 입력하세요!!\n");
						break;
					}	// end of switch(input_gender.trim())----------------------------
				} while(!isUse_input_gender);	// end of do~while----------------
				
				// == 입력받은 성별에 해당하는 구직자 찾기 == //
				StringBuilder sb = new StringBuilder();		// for 문안에 넣으면 반복되기에 밖으로 빼야한다.
				boolean isSearch = false;
				
				for(int i=0; i<Gujikja.count; i++) {
					if(input_gender.equals(gu_arr[i].getGender())){
						isSearch = true;
						sb.append(gu_arr[i].getInfo() + "\n");
					}
				
				}	// end of for----------------
				
				if(isSearch) {
					title();
					System.out.println(sb.toString());
				}
				else {
					System.out.println("[검색결과 성별 " + input_gender+ "자 구직자는 없습니다.]");
				}
				
			}	// end of if~else-----------------------
			
		}	// end of void search_gender(Scanner sc, Gujikja[] gu_arr)
		
		// == 연령대 및 성별 검색해주는 메소드 == //
		/*
		void search_ageLine_gender(Scanner sc, Gujikja[] gu_arr) {
			if(Gujikja.count == 0) {	// 구직자가 존재하지 않는 경우
				System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
			} else {	// 구직자가 존재하는 경우
				StringBuilder sb = new StringBuilder();
				String str_ageLine = "";
				String str_gender = "";
				boolean isUse_ageLine_gender = false;
				boolean isSearch = false;
				
				outer:
				do {
					System.out.print("▷ 검색하고자 하는 연령대 [예: 20] => ");
					str_ageLine = sc.nextLine();		// "0" "10" "20" "30" "40" "50" "60" "70" "80"	-- 정상
					// "25" "강아지" "-20" --> 비정상
					switch (str_ageLine) {
					case "0" :
					case "10":
					case "20":
					case "30":
					case "40":
					case "50":
					case "60":
					case "70":
					case "80":
					isUse_ageLine_gender = true;
					break;
					default:
					System.out.println("[경고] 올바른 연령대를 입력하세요!!\n");
					break outer;
					}	// end of switch(str_ageLine)----------------------------
					
					for(int i=0; i<Gujikja.count; i++) {
						int ageLine = gu_arr[i].getAge()/10*10;
										// 나이/10*10
										// 26/10*10 ==> 20
										// 23/10*10 ==> 20
						
						if(Integer.parseInt(str_ageLine) == ageLine) {
							isSearch = true;
												// 빼도됨.	sb.append(gu_arr[i].getInfo() + "\n");
						  break; 				// 한명만 참이여도 되기때문에 break 해도 된다. //////////////////
						}
					}	// end of for----------------
					
					if (!isSearch ){
						System.out.println("[검색결과 연령대 " + str_ageLine+ "대인 구직자는 없습니다.");
						break outer;
					}	
	
					System.out.print("▷ 검색하고자 하는 성별 [남/여] => ");
					str_gender = sc.nextLine();
					
					
					switch (str_gender.trim()) {
					case "남" :
					case "여" :
						isUse_ageLine_gender = true;
						str_gender = str_gender.trim();		// 공백을 뺀것을 넣어주기
						break;
					default:
						System.out.println("[경고] \"남\" 또는 \"여\" 만 입력하세요!!\n");
						break;
					}	// end of switch(input_gender.trim())----------------------------
					
					isSearch = false;
					
					for(int i=0; i<Gujikja.count; i++) {
						if(str_gender.equals(gu_arr[i].getGender())){
							isSearch = true;
							sb.append(gu_arr[i].getInfo() + "\n");
						}
					
					}	// end of for----------------
					
					if(isSearch) {
						title();
						System.out.println(sb.toString());
					}
					else {
						System.out.println("[검색결과 성별 " + str_gender+ "자 구직자는 없습니다.]");
					}
				} while (!isUse_ageLine_gender);	// end of do~while----------------------
			}	// end of if~else-------------------------
		}	// end of void search_ageLine_gender(Scanner sc, Gujikja[] gu_arr)
		*/
		////////////////////////////////////////////////////////////////////////////////////
		// 강사님
		
		// == 연령대 및 성별 검색해주는 메소드 == //
		void search_ageLine_gender(Scanner sc, Gujikja[] gu_arr) {
			
			if(Gujikja.count == 0) {	// 구직자가 존재하지 않는 경우
				System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
				// return;		// 해당 메소드 종료(확인사살)
			} else {	// 구직자가 존재하는 경우
				
				String str_ageLine = "";
				boolean isUse_ageLine = false;
				do {
					System.out.print("▷ 검색하고자 하는 연령대 [예: 20] => ");
					str_ageLine = sc.nextLine();		// "0" "10" "20" "30" "40" "50" "60" "70" "80"	-- 정상
															// "25" "강아지" "-20" --> 비정상
					switch (str_ageLine) {
					case "0" :
					case "10":
					case "20":
					case "30":
					case "40":
					case "50":
					case "60":
					case "70":
					case "80":
						isUse_ageLine = true;
						break;

					default:
						System.out.println("[경고] 올바른 연령대를 입력하세요!!\n");
						break;

					}	// end of switch(str_ageLine)----------------------------
				} while(!isUse_ageLine);	// end of do~while----------------
				
				// == 입력받은 연령대에 해당하는 구직자 찾기 == //
				boolean is_ageline_Search = false;
				
				for(int i=0; i<Gujikja.count; i++) {
					int ageLine = gu_arr[i].getAge()/10*10;
									// 나이/10*10
									// 26/10*10 ==> 20
									// 23/10*10 ==> 20
					
					if(Integer.parseInt(str_ageLine) == ageLine) {
						is_ageline_Search = true;
						break;						// 연령대에 1명만 있는게 중요하기 때문에 나가도 된다.
					}
				}	// end of for----------------
				
				if(!is_ageline_Search) {	// 검색하고자 하는 연령대에 해당하는 구직자가 존재하지 않는 경우
					System.out.println("[검색결과 연령대 " + str_ageLine+ "대인 구직자는 없습니다.");
				}
				else {	// 검색하고자 하는 연령대에 해당하는 구직자가 존재하는 경우
					
					// === !! 성별 검색에 시작 !! === // 
					String input_gender = "";
					boolean isUse_input_gender = false;
					do {
						System.out.print("▷ 검색하고자 하는 성별 [남/여] => ");
						input_gender = sc.nextLine();		// "남" "여" "   남" "여   " "    남    " "   여   " -- 정상
															// "" "       " "강아지" --> 비정상
						switch (input_gender.trim()) {
						case "남" :
						case "여" :
							isUse_input_gender = true;
							input_gender = input_gender.trim();		// 공백을 뺀것을 넣어주기
							break;
						default:
							System.out.println("[경고] \"남\" 또는 \"여\" 만 입력하세요!!\n");
							break;
						}	// end of switch(input_gender.trim())----------------------------
					} while(!isUse_input_gender);	// end of do~while----------------
					
					// == 입력받은 연령대 및 성별에 해당하는 구직자 찾기 == //
					StringBuilder sb = new StringBuilder();		// for 문안에 넣으면 반복되기에 밖으로 빼야한다.
					boolean is_ageline_gender_Search = false;
					
					for(int i=0; i<Gujikja.count; i++) {
						if(Integer.parseInt(str_ageLine) == gu_arr[i].getAge()/10*10 
							&& input_gender.equals(gu_arr[i].getGender())){
							is_ageline_gender_Search = true;
							sb.append(gu_arr[i].getInfo() + "\n");
						}
					}	// end of for----------------
					
					if(is_ageline_gender_Search) {
						title();
						System.out.println(sb.toString());
					}
					else {
						System.out.println("[검색결과 연령대가 " +str_ageLine + "대인 " + input_gender+ "자 구직자는 없습니다.]\n");
					}
					// === !! 성별 검색 끝 !! === //
				}	// end of if~else-----------------------
				
				// 회원명수, 회원정보 등 입력하는 경우가 else 뒤에 있을경우 확인사살로 if 에 return 을 적어줘야한다.
				
			}	// end of if~else----------			
			
		}	// end of void search_ageLine_gender(Scanner sc, Gujikja[] gu_arr)
		
}
