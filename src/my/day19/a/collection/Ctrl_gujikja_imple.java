package my.day19.a.collection;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ctrl_gujikja_imple extends Ctrl_common_imple implements Ctrl_gujikja {
	
	// == 구직자(Gujikja) 신규 회원가입시
	//	Gujikja 클래스의 field 의 요구사항에 모두 맞으면
	//	List<Gujikja> gu_list, Map<String, Gujikja> gu_map 에 저장시켜주는 메소드 생성하기 ==
	@Override
	public void register(Scanner sc, List<Gujikja_imple> gu_list, Map<String, Gujikja_imple> gu_map) {
			
			Gujikja_imple gu = new Gujikja_imple();
			
			String id = null;
			// 아이디는 필수 입력사항이면서 아이디 조건에 맞을때 까지 반복해야 한다.
			outer:
			do {
				System.out.print("1.아이디 : ");
				id = sc.nextLine();
				
				// == 중복 아이디 검사하기 시작 == //
				if(gu_map.get(id) != null) {	// 아이디가 이미 존재하는 경우
						System.out.println(">> 이미 사용중인 아이디 이므로 다른 아이디를 입력하세요!!\n");
						continue outer;
					}	
				
				// == 중복 아이디 검사하기 끝 == //
				gu.setId(id);
				
			} while(!(gu.getId() != null));
			
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
				System.out.print("3.주민번호 : ");
				String jubun = sc.nextLine();
				
				gu.setJubun(jubun);

			} while(!(gu.getJubun() != null));
		
			//////////////////////////////////////////////////////
			
		gu_list.add(gu);
		gu_map.put(id, gu);
		
		System.out.println(">> 구직자 회원가입 성공 !! << \n");
		
	}	// end of void register(Scanner sc, List<Gujikja_imple> gu_list, Map<String, Gujikja_imple> gu_map)-------------

	// == 구직자 로그인 메소드 생성하기 == //
		@Override
		public Gujikja_imple login(Scanner sc, Map<String, Gujikja_imple> gu_map) {
			
			System.out.print("▷ 구직자 ID : ");
			String id = sc.nextLine();
			
			System.out.print("▷ 비밀번호 : ");
			String passwd = sc.nextLine();
			
			if(gu_map.get(id) != null && passwd.equals(gu_map.get(id).getPasswd())) {
				return gu_map.get(id);		// 구직자 정보 들어갈 것
			} else 
				return null;	// 로그인 실패
		}	// end of public  Gujikja_imple login(Scanner sc, Map<String, Gujikja_imple> gu_map)---------

		// == 구직자 전용메뉴 메소드 생성하기 == //
		@Override
		public void gu_menu(Scanner sc, Gujikja_imple login_gu, List<Company_imple> cp_list, List<Recruit_imple> rc_list, List<RecruitApply> rcapply_list) {
			String str_menuno;
			do {
				System.out.println("\n === 구직자 전용메뉴(" + login_gu.getName() + "님 로그인중) ===\n"
						+ "1. 내정보 보기  2. 내정보 수정 3. 모든 구인회사 조회 4. 구인회사 검색하기\n"
						+ "5. 모든 채용공고 조회 6. 채용 지원하기 7. 지원한 채용공고 조회 8. 로그아웃\n");
				System.out.print("▷ 메뉴번호 선택 : ");
				str_menuno = sc.nextLine();
				
				switch (str_menuno) {
				case "1":	// 내정보 보기
					view_myInfo(login_gu);
					break;
				case "2":	// 내정보 수정
					update_myInfo(sc, login_gu);
					break;
				case "3":	// 모든 구인회사 조회
					view_company_info(cp_list);	// 메소드의 오버로딩
					break;
				case "4":	// 구인회사 검색하기
					search_company_info(sc,cp_list);		// 메소드의 오버로딩
					break;
				case "5":	// 모든 채용공고 조회
					view_all_recruit_info(rc_list);
					break;
				case "6":	// 채용 지원하기
					input_recruitApply(sc, login_gu, rc_list, rcapply_list);
					break;
				case "7":	// 지원한 채용공고 조회
					view_my_recruitApply(login_gu, rcapply_list);
					break;
				case "8":	// 로그아웃
					System.out.println(">> 로그아웃 되었습니다. <<\n");
					login_gu = null;		// 로그인 되어진 사람을 없애주어야한다.
					break;
				default:
					System.out.println(">> [경고] 선택하신 번호는 메뉴에 없습니다.");
					break;
				}	// end of switch (str_menuno)------------------------------
			} while(!("8".equals(str_menuno)));	// end of do~while------------------------
		}	// end of public void gu_menu(Scanner sc, Gujikja_imple login_gu, List<Company_imple> cp_list, List<Recruit_imple> rc_list, List<RecruitApply> rcapply_list)------------

		// 내정보 보기
		private void view_myInfo(Gujikja_imple login_gu) {
			System.out.println(">>> " + login_gu.getName() + "님의 정보 <<<\n"
					+ "-".repeat(40)+"\n아이디\t비밀번호\t   성명\t주민번호\n"+ "-".repeat(40));
			System.out.println(login_gu.getId() + " ".repeat(3) + login_gu.getPasswd()+" ".repeat(1)
					+ login_gu.getName() + " ".repeat(2) + login_gu.getJubun());
		}	// end of private void view_myInfo(Gujikja login_gu)---------------------
		
		// 내정보 수정
		private void update_myInfo(Scanner sc, Gujikja_imple login_gu) {
			view_myInfo(login_gu);
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/* 내방법
			String new_passwd;
			do {
				System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
				System.out.print("1. 비밀번호 : ");
				new_passwd = sc.nextLine();	// 기존 비밀번호인 qWer1234$ 을 qWer0070$ 으로 변경하려고 한다.
													// 기존 비밀번호인 qWer1234$ 을 qWer0070$ 으로 변경하려고 하려면 기존암호와 동일하므로 변경이 불가합니다.
													// 기존 비밀번호인 qWer1234$ 을 바꾸지 않으려고 한다.
													// 기존 비밀번호인 qWer1234$ 을 abcd 로 변경하고자 할때는 비밀정책에 맞지 않으므로 안된다.!!
				
				if(!new_passwd.equals("")) {		// 입력한 비밀번호가 엔터가 아닐 경우
					// System.out.println("엔터이군요");
					
					if(new_passwd.equals(login_gu.getPasswd()))	// 입력한 비밀번호가 기존 비밀번호와 같을 경우
						System.out.println(">> 기존암호와 동일하므로 변경이 불가합니다.!!");
					else
						login_gu.setPasswd(new_passwd);			// 비밀번호 바꾸기
				}	
				else {
					new_passwd = login_gu.getName();
				}	// end of if------------
			} while(!(login_gu.getPasswd().equals(new_passwd)));	// end of do~while----------------
			*/
			
			// 강사님
			boolean exit_ok = false;
			do {
				System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
				System.out.print("1. 비밀번호 : ");
				String new_passwd = sc.nextLine();	// 기존 비밀번호인 qWer1234$ 을 qWer0070$ 으로 변경하려고 한다.
													// 기존 비밀번호인 qWer1234$ 을 qWer0070$ 으로 변경하려고 하려면 기존암호와 동일하므로 변경이 불가합니다.
													// 기존 비밀번호인 qWer1234$ 을 바꾸지 않으려고 한다.
													// 기존 비밀번호인 qWer1234$ 을 abcd 로 변경하고자 할때는 비밀정책에 맞지 않으므로 안된다.!!
				
				if(!new_passwd.equals("")) {		// 입력한 비밀번호가 엔터가 아닐 경우
					// System.out.println("엔터이군요");
					
					if(new_passwd.equals(login_gu.getPasswd()))	// 입력한 비밀번호가 기존 비밀번호와 같을 경우
						System.out.println(">> 기존암호와 동일하므로 변경이 불가합니다.!!");
					else
						login_gu.setPasswd(new_passwd);			// 비밀번호 바꾸기
						if(login_gu.getPasswd().equals(new_passwd)) {	// 암호가 바뀔경우
							exit_ok = true;
						}
						// 암호를 틀리게 입력한 경우 else
				}	
				else {	// 입력한 비밀번호가 엔터일 경우
					exit_ok = true;
				}
			} while (!exit_ok);	// end of do~while----------------
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			/* 내방법
			String new_name;
			do {
				System.out.println(">> \n[주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
				System.out.print("2. 성명 : ");
				new_name = sc.nextLine();	// 기존 성명인 엄정화 를 엄화정 으로 변경하려고 한다.
													// 기존 성명인 엄정화 를 엄정화 으로 변경하려고 하려면 기존성명와 동일하므로 변경이 불가합니다.
													// 기존 성명인 엄정화 를 바꾸지 않으려고 한다.
													// 기존 성명인 엄정화 를 엄JungHwa 로 변경하고자 할때는 성명정책에 맞지 않으므로 안된다.!!
				
				if(!(new_name.equals(""))) {
					if(new_name.equals(login_gu.getName()))
						System.out.println("기존성명와 동일하므로 변경이 불가합니다.");
					else
						login_gu.setName(new_name);
				}	
				else {
					new_name = login_gu.getName();
				}	// end of if------------
			}while(!(login_gu.getName().equals(new_name)));	// end of do~while----------------
			*/
			
			// 강사님
			exit_ok = false;
			do {
				System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
				System.out.print("2. 성명 : ");
				String new_name = sc.nextLine();	// 기존 성명인 엄정화 를 엄화정 으로 변경하려고 한다.
													// 기존 성명인 엄정화 를 엄정화 으로 변경하려고 하려면 기존성명와 동일하므로 변경이 불가합니다.
													// 기존 성명인 엄정화 를 바꾸지 않으려고 한다.
													// 기존 성명인 엄정화 를 엄JungHwa 로 변경하고자 할때는 성명정책에 맞지 않으므로 안된다.!!
				
				if(!new_name.equals("")) {
					if(new_name.equals(login_gu.getPasswd()))
						System.out.println(">> 기존성명와 동일하므로 변경이 불가합니다.!!");
					else
						login_gu.setName(new_name);
						if(login_gu.getName().equals(new_name)) {
							exit_ok = true;
						}
				}	// end of if------------
				else {
					exit_ok = true;
				}
			}while(!exit_ok);
	
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			/* 내방법
			String new_jubun;
			do {
				System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
				System.out.print("3. 주민번호 : ");
				new_jubun = sc.nextLine();	// 기존 주민번호인 8610202 를 8808081 으로 변경하려고 한다.
													// 기존 주민번호인 8610202 를 8610202 으로 변경하려고 하려면 기존 주민번호와 동일하므로 변경이 불가합니다.
													// 기존 주민번호인 8610202 를 바꾸지 않으려고 한다.
													// 기존 주민번호인 8610202 를 엄JungHwa 로 변경하고자 할때는 주민번호 정책에 맞지 않으므로 안된다.!!
				
				if(!new_jubun.equals("")) {
					if(new_jubun.equals(login_gu.getJubun()))
						System.out.println(">> 기존 주민번호와 동일하므로 변경이 불가합니다.!!");
					else
						login_gu.setJubun(new_jubun);
				}	
				else {
					new_jubun = login_gu.getJubun();
				}	// end of if------------
			}while(!(login_gu.getJubun().equals(new_jubun)));
			*/
			
			// 강사님
			exit_ok = false;
			do {
				System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!");
				System.out.print("3. 주민번호 : ");
				String new_jubun = sc.nextLine();	// 기존 주민번호인 8610202 를 8808081 으로 변경하려고 한다.
													// 기존 주민번호인 8610202 를 8610202 으로 변경하려고 하려면 기존 주민번호와 동일하므로 변경이 불가합니다.
													// 기존 주민번호인 8610202 를 바꾸지 않으려고 한다.
													// 기존 주민번호인 8610202 를 엄JungHwa 로 변경하고자 할때는 주민번호 정책에 맞지 않으므로 안된다.!!
				
				if(!new_jubun.equals("")) {
					if(new_jubun.equals(login_gu.getJubun()))
						System.out.println(">> 기존 주민번호와 동일하므로 변경이 불가합니다.!!");
					else
						login_gu.setJubun(new_jubun);
						if(login_gu.getJubun().equals(new_jubun)) {
						exit_ok = true;
						}
				}	
				else {
					exit_ok = true;
				}	// end of if------------
			} while (!exit_ok);
		}	// end of private void update_myInfo(Scanner sc, Gujikja login_gu)----------------------
		
		// 모든 구인회사 조회
		private void view_company_info(List<Company_imple> cp_list) {
			
			if(cp_list.size() == 0)		
				System.out.println(">> 구인회사로 등록된 회사가 없습니다. << \n");
			else
				title_company();
			
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<cp_list.size(); i++) {
					sb.append(cp_list.get(i).getInfo() + "\n");	// sb 에 쌓기 => append
				}	// end of for-----------------
				
				System.out.println(sb.toString());
			
		}	// end of private void view_all_company_info(List<Company_imple> cp_list)-----------------------
		
		// 구인회사 검색하기
		private void search_company_info(Scanner sc, List<Company_imple> cp_list) {
			
			boolean exit = false;
			do {
				System.out.println(">>> 구인회사 검색메뉴 <<<\n"
								+ "1. 업종검색 2. 자본금검색 3. 구직자메뉴로 돌아가기");
				System.out.print("▷ 검색메뉴번호 입력 : ");
				
				int search_num = Integer.parseInt(sc.nextLine());
				
				switch (search_num) {
				case 1:	// 업종검색
					search_jobtype_company(sc,cp_list);
					break;
				case 2:	// 자본금검색
					search_seedmoney_company(sc,cp_list);	
					break;
				case 3:	// 구직자메뉴로 돌아가기
					exit = true;
					break;
				default:	// 다른것을 입력할 경우
					System.out.println("[경고]메뉴에 있는 번호를 입력해주세요.");
					break;
				}

			} while (!exit);
			
		}	// end of private void search_company(Scanner sc, List<Company_imple> cp_list)----------------------------

		// 회사 타이틀
		private void title_company() {
			
			System.out.println("=".repeat(70) +"\n"
						+ " 회사명\t업종\t사업자등록번호\t자본금" + "\n" 
						+ "=".repeat(70));
			
		}	// end of private void title_company()-------------------
		
		// 업종명 검색하기
		private void search_jobtype_company(Scanner sc, List<Company_imple> cp_list) {
			boolean exit = false;
			do {
				System.out.print("▷ 업종명 : ");
				String job_type_name = sc.nextLine().toLowerCase();	// 입력한 업종
				StringBuilder sb = new StringBuilder();
				
				for(Company_imple cp : cp_list) {
					if(cp.getJob_type().toLowerCase().contains(String.join("", job_type_name.split("\\ ")))) {
						exit = true;
						sb.append(cp.getInfo() + "\n");	// 해당한 업종 쌓기)
					} 
				}	// end of for------
				if(exit) {
					title_company();
					System.out.println(sb.toString());
				} else	// 해당하는 것이 없다면
					System.out.println("검색하시려는 " + job_type_name + "은 없습니다.");
			}while (!exit);
		}	// end of private void search_jobtype_company(Scanner sc, List<Company_imple> cp_list)------------
		
	   //////////////////////////////////////////////////////////////////////////////////////////////////
		// 자본금 검색하기
		// 검색한 자본금에 해당하는 회사가 없을 경우 재검색이 가능하도록 해주었다.
		private void search_seedmoney_company(Scanner sc, List<Company_imple> cp_list) {
		boolean exit = false;
		StringBuilder sb = new StringBuilder();
		do {
			try {
				System.out.print("▷ 자본금 : ");
				long seedmoney = Long.parseLong(sc.nextLine());	// 입력한 자본금
				
				for(Company_imple cp : cp_list) {
					if(seedmoney <= cp.getSeed_money()) {
						exit = true;
						sb.append(cp.getInfo() + "\n");	// 해당 회사의 정보 쌓기
					}
				}	// end of for-------
				if(exit) {
					title_company();
					System.out.println(sb.toString());
				} else	// 해당하는 것이 없다면
					System.out.println("자본금이 " + seedmoney + "이상인 회사는 없습니다.");
			} catch(NumberFormatException e) {
				System.out.println("올바른 수를 입력해주세요");
			}	// end of try~catch----------
		} while (!exit);	// end of do~while------------		
		} 	// end of private void search_seedmoney_company(Scanner sc, List<Company_imple> cp_list)-----------------
		
		// 모든 채용공고 조회 (채용마감일자가 오늘보다 이전인 것은 보여주면 안된다)
		private void view_all_recruit_info(List<Recruit_imple> rc_list) {
			if(rc_list.size() == 0)
				System.out.println(">> 채용공고가 없습니다. <<\n");
			else {
				StringBuilder sb = new StringBuilder();		// 채용공고를 쌓을려고 한다.
				
				try {
					Date now = new Date();
					SimpleDateFormat sdft = new SimpleDateFormat("yyyyMMdd");
					Date today = sdft.parse(sdft.format(now));	// "20240207" ==> 20240207
					
					for(Recruit_imple rc : rc_list) {
						 Date date_finish_day = sdft.parse(rc.getFinish_day());	// String -> Date 타입 변환
						 
							// == !채용마감일자.before(오늘날짜)
							 if(!date_finish_day.before(today)) {
							// if(rc_arr[i].getFinish_day() != null) { 		// 채용마감일이 오늘날짜 이후 
								 
									sb.append(rc.getRecruit_no() + "\t\t"
											+ rc.getCp().getName() + "\t"
											+ rc.getCp().getJob_type() + "\t"
											+ new DecimalFormat("#,###").format(rc.getCp().getSeed_money()) + "원\t"		// 3자리마다 콤마찍어서 나오게하기
											+ rc.getWork_type() + "\t    "
											+ rc.getCnt() + "\t"
											
											+ rc.getRegister_day().substring(0, 4) +"-" 		// yy-MM-dd 처럼 중간에 '-'를 넣으려고 한다.
											+ rc.getRegister_day().substring(4, 6) +"-" 
											+ rc.getRegister_day().substring(6) + "\t"
											
											+ rc.getFinish_day().substring(0, 4) +"-" 		// yy-MM-dd 처럼 중간에 '-'를 넣으려고 한다.
											+ rc.getFinish_day().substring(4, 6) +"-" 
											+ rc.getFinish_day().substring(6) + "\n");
							 }
					}	// end of for-----------------
				} catch(ParseException e) {
				} 
				System.out.println("-".repeat(90));
				System.out.println("채용공고 순번     회사명     회사직종타입    자본금   채용분야(근무형태) 채용인원  등록일자  채용마감일자");
				System.out.println("-".repeat(90));
				
				System.out.println(sb.toString());
				System.out.println("[채용공고가 " + rc_list.size() +"건이 있습니다]\n");
			}	// end of if~else---------------
		}	// end of private void view_all_recruit_info(List<Recruit_imple> rc_list)-----------------------
		
		// 채용 지원하기
		private void input_recruitApply(Scanner sc, Gujikja_imple login_gu, List<Recruit_imple> rc_list, List<RecruitApply> rcapply_list) {
			
			// 구직자 자신이 응모한 채용공고 번호를 알아오자
			String str_my_recruit_no = "";
			
			for(RecruitApply rc_apply : rcapply_list) {
				if(rc_apply.getGu().getId().equals(login_gu.getId()))	// 로그인한 아이디와 지원서에 있는 아이디가 같은 경우
					str_my_recruit_no += rc_apply.getRc().getRecruit_no() + ",";	// 채용공고순서
				
			}	// end of for---------------------------
			
			if(str_my_recruit_no.length() > 0) {	// 응모한 경우가 있으면
				// str_my_cruit_no = "1,3,2,";
				str_my_recruit_no = str_my_recruit_no.substring(0, str_my_recruit_no.length()-1);
				// str_my_cruit_no = "1,3,2"
				
				String[] my_recruit_no_arr = str_my_recruit_no.split("\\,");
				// {"1","3","2"}
				
				if(my_recruit_no_arr.length == rc_list.size()) {
					System.out.println(">> 이미 모든 채용공고에 지원하셨으므로, 더 이상 채용지원 가능한 공고가 없습니다.");
					return;	// 메소드 종료
				}
			}
			
			// == 채용공고번호는 채용공고로 올라온 번호만 입력해야 한다. == //
			boolean is_existance, is_duplicate_recruit_no;
			Recruit_imple rc = null;		// 초기값
	
			do {
				is_existance = false;
				is_duplicate_recruit_no = true;
				System.out.print("▷ 채용공고번호 : ");
				String input_recruit_no = sc.nextLine();

				for (Recruit_imple recruit : rc_list) {
					if(input_recruit_no.equals(String.valueOf(recruit.getRecruit_no()))) {
						is_existance = true;
						rc = recruit;			// 채용공고번호를 담아주기!
						break;
					}
				}	// end of for-------------------------
				
				if(!is_existance)
					System.out.println(">> 입력하신 " + input_recruit_no + "번은 채용공고에 존재하지 않습니다.\n");
			
				// 또한
				// 이미 공고한 곳에 중복 지원을 하면 안된다.

				else {		// 입력한 번호가 채용공고 번호에 있는 경우
					// == 채용공고번호는 채용공고로 올라온 번호이지만 이미 응모한 채용공고번호는 입력하면 안된다. == //
					for(RecruitApply rcapply: rcapply_list) {
						// rcapply.getRc().getRecruit_no() ==> 채용공고번호(int)
						// rcapply.getGu().getId() ==> 채용공고에 지원한 구직자 ID
						if(String.valueOf(rcapply.getRc().getRecruit_no()).equals(input_recruit_no) 
								&& rcapply.getGu().getId().equals(login_gu.getId())) {
							// 중복된 경우
							is_duplicate_recruit_no = false;
							break;
						}
					}	// end of for-----------
					
					if(!is_duplicate_recruit_no)	// 중복된 경우
						System.out.println("채용공고번호 " + input_recruit_no + "번은 이미 지원하신 번호입니다.\n");
					else {	// 중복지원이 아닐 경우
							do {
								System.out.print("▷ 지원동기 : ");
								String apply_motive = sc.nextLine();
								if(apply_motive.isBlank()) {	// 지원동기가 비어있는 경우
									System.out.println("[경고] 지원동기는 필수로 입력하셔야 합니다.!!\n");
								} else {	// 지원동기를 입력한경우
									RecruitApply rc_apply = new RecruitApply();
									rc_apply.setRc(rc);
									rc_apply.setGu(login_gu);
									rc_apply.setApply_motive(apply_motive);
									
									rcapply_list.add(rc_apply);
									break;	// do~while 문 빠져나가기(지원동기)
								}	// end of if~else----------
							} while (true);
					}	// end of if~else-----------
				}	// end of if~else--------------
			// } while (!is_existance);	// end of do~while---------------	
			} while (!(is_existance && is_duplicate_recruit_no));	// end of do~while--------------
		}	// end of private void input_recruitApply(Scanner sc, Gujikja_imple login_gu, List<Recruit_imple> rc_list, List<RecruitApply> rcapply_list)----
		
		// 지원한 채용공고 조회
		private void view_my_recruitApply(Gujikja_imple login_gu, List<RecruitApply> rcapply_list) {
			boolean is_existence = false;
			
			for(RecruitApply rcapply : rcapply_list) {
				if(login_gu.getId().equals(rcapply.getGu().getId())) {
					is_existence = true;
					System.out.print(rcapply.getRc().recruit_info());	// 채용정보를 알려주는 메소드 호출하기
					System.out.println("▣ 지원동기 : " + rcapply.getApply_motive() + "\n\n");
				}
			}	// end of for--------------
			
			if(!is_existence)
				System.out.println(">>> 채용공고에 응모한 내역이 없습니다.\n");
		}	// end of private void view_my_recruitApply(Gujikja_imple login_gu, List<RecruitApply> rcapply_list)---------------------

}
