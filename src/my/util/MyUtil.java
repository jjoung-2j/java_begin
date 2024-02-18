package my.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MyUtil {

	// === 현재시각을 출력해주는 static 메소드를 생성한다. === //
	public static void current_time_print() {
		
		Date now = new Date(); // 현재시각
		
		SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 패턴을 지정안하면 영어권 설정으로 나옴 Ex) Wed Jan 17 11:43:29 KST 2024
		
		System.out.println("== 현재시각 : " + sdfmt.format(now));
	}	// end of public static void current_time_print()------------------------------
	
	// === 소문자 3개와 숫자 4개로 이루어진 랜덤한 인증키 만들기 === //
	// 예 > asa9040	txa2356
	
	public static String certification_key() {
		Random rnd = new Random();
		// 처음 얼마부터 마지막 얼마까지 랜덤한 정수
		// ==> rnd.nextInt(마지막 수 - 처음수 + 1) + 처음수;
				
		String certification_key = "";
		
		for(int i=0;i<7;i++) {
			
			if(i<3) {	// 랜덤한 소문자를 발생시킨다.
				char ch = (char)(rnd.nextInt('z' - 'a' + 1) + 'a');
				certification_key += ch;
			} else {	// 랜덤한 숫자 0부터 9 까지 발생시킨다.
				int n = rnd.nextInt(9 - 0 + 1) + 0;
				certification_key += n;
			}	
		}	// end of for--------------
		return certification_key;
	}	// end of certification_key----------------------------------------------

	// 입력받은 문자열에서 공백을 제거해주는 메소드 생성하기
	public static String space_delete(String input_str) {		
		String result = null;		// null 로 해주면 존재자체가 없기때문에 나오지 않는다. => NullPointerException
		
		if(input_str != null) {
			result = "";
			for(int i=0;i<input_str.length();i++) {		// null. 이 되지 않기때문에 초기값을 바꿔주어야 한다.
				
				char ch = input_str.charAt(i);
				if( ch != ' ') 
					result += ch;	
			}	// end of for-----------------------------------------------------	
		}
		return result;
	}	// end of public static String space_delete(String input_str)--------------
	
	// == 비밀번호가 규칙에 맞는지 틀리는지 알려주는 static 메소드 생성하기 == //
	/*
		비밀번호 규칙은 비밀번호의 길이는 8글자 이상 15글자 이하이어야 하고,
		또한 비밀번호는 영문대문자, 영문소문자, 숫자, 특수기호가 혼합되어야만 한다.
		우리는 규칙에 맞으면 true 를 리턴해주고, 규칙에 틀리면 false 를 리턴하도록 만든다.
	 */
	public static boolean isCheckPasswd(String passwd) {
		
		if(passwd == null)
			return false;
		
		// 예를들어서
		// 입력받은 passwd 가 C5d# 이라면 dsfsdf2342@#$@kfjsASFSFDF 이라면
		int length = passwd.length();
		if(length <8 || length >15)
			return false;
		
		// 예를들어서
		// 입력받은 passwd 가 C5d#하하호호 이라면 C5d#하하s@! 이라면
		// 또는
		// 입력받은 passwd 가 C5dawxab 이라면 c5dawxab# 이라면
		// 입력받은 passwd 가 C5dawxab@ 이라면 c5dawxab#T 이라면
		
		boolean flag_upper = false;		// 영문대문자 표식을 위한 용도
		boolean flag_lower = false;		// 영문소문자 표식을 위한 용도
		boolean flag_number = false;	// 숫자 표식을 위한 용도
		boolean flag_special = false;	// 특수문자 표식을 위한 용도
		
		for(int i=0;i<length;i++) {
			// 암호에 한글이 들어가 있는지 알아본다.
			char ch = passwd.charAt(i);
			if('가' <= ch && ch <= '힣') {
				return false;
			}
			
			if(Character.isUpperCase(ch))	// 영문대문자일 경우
				flag_upper = true;
			
			else if(Character.isLowerCase(ch))	// 영문소문자일 경우
				flag_lower = true;
			
			else if(Character.isDigit(ch))	// 숫자일 경우
				flag_number = true;
			
			else	// 특수문자일 경우
				flag_special = true;

		}	// end of for----------------
		
		return flag_upper && flag_lower && flag_number && flag_special;	// 4개 중 하나라도 false 가 나오면 false
		// 이제부터는 입력받은 passwd 의 글자수가 8글자 이상 15글자 이하인 경우
		
	}	// end of isCheckPasswd(String passwd)-----------------------

	public static long delete_character(String money) {
		
		// money => "$2,000,000"
		// money => "2,000,000$"
		// money => "$2,000,000$"
		// money => "$$2,000,000$"
		// money => "2,$000,$000$"		"2," + "000,$000$"		"2,000," + "$000$"	"2,000,000" + "$"	"2,000,000"
		// money => "2,000,000"
		// money => "$500"
		// money => "500"
		
		/*
		String str_result_for = "";
		for(int i=0; i<money.length(); i++) {
			if(money.indexOf("$") != -1) {
				str_result_for += str.charAt(i);
			}
		}
		*/
		do {
			int dollor_index = money.indexOf("$");
			if(dollor_index == -1)	// 처음부터 없으면 빠져나간다.
				break;
			money = money.substring(0,dollor_index) + money.substring(dollor_index+1);	
			// money.substring(a,b)a부터 b전까지 => 달러전위치 / money.substring(dollor_index+1) => (달러위치+1) 마지막까지
			// "2,$000,$000$"
		} while (true);
	
		// System.out.println(money);	// 달러가 빠진 money
		// "2,000,000"
		
		do {
			int comma_index = money.indexOf(",");
			if(comma_index == -1)	// 처음부터 없으면 빠져나간다.
				break;
			money = money.substring(0,comma_index) + money.substring(comma_index+1);	// 달러전위치,달러위치부터 마지막까지
			// "2,$000,$000$"
		} while (true);
		
		//System.out.println(money);
		// "2000000"
		
		return Long.parseLong(money);
		// 2000000
	}	// end of public static long delete_character(String str)-----------------

	// === 숫자에 3자리 마다 , 를 추가해서 문자열로 리턴시켜주는 메소드 생성하기
	public static String append_comma(long num) {
		
		// 숫자를 문자열로 변경시켜주는 메소드
		// Integer.toString(12345); ==> "12345"	// int 타입을 문자열로 바꿔주기
		// Long.toString(1234567890123456789L); ==> "1234567890123456789"	// long 타입을 문자열로 바꿔주기
		// String.valueOf(12345); => "12345"	// int 타입을 string 타입으로 변환
		// String.valueOf(1234567890123456789L); ==> "1234567890123456789"
		
		String temp = String.valueOf(num);
		// num 이 2500000 이라면 temp 는 "2500000" (문자열)
		// num 이 892500000 이라면 temp 는 "892500000"
		
		char[] origin_arr = temp.toCharArray();
		/*
			-----------------------------
			| 2 | 5 | 0 | 0 | 0 | 0 | 0 |	==> 길이 7
			-----------------------------
			
			-------------------------------------
			| 8 | 9 | 2 | 5 | 0 | 0 | 0 | 0 | 0 | ==> 길이 9
			-------------------------------------
		 */
		
		int comma_len = (origin_arr.length%3==0)?origin_arr.length/3-1:origin_arr.length/3;
		char[] result_arr = new char[origin_arr.length + comma_len];
		/*
			-------------------------------------
			| 2 | , | 5 | 0 | 0 | , | 0 | 0 | 0 |	// 7%3 = 2
			-------------------------------------
			---------------------------------------------
			| 8 | 9 | 2 | , | 5 | 0 | 0 | , | 0 | 0 | 0 |	// 9%3=3 - 1 => 2
			---------------------------------------------
		 */
		
		for(int i=origin_arr.length-1, j=result_arr.length-1, count=1 ; i>=0; i--, j--, count++) {	// 길이-1 : 맨마지막 index	반복허용 i>=0
			if(count%4 != 0) {
				result_arr[j] = origin_arr[i];	// result arr 은 , 가 있고 origin_arr 은 , 가 없기에 길이가 다르다.
			// i가 반복되어지는 횟수, j는 값 count 몇번재인지 확인
			} else {
				result_arr[j] = ',';
				i++; 	// , 이 들어서면 i가 증감식으로 i-- 되기때문에 i++를 해줘야 제자리가 된다.(유사 로또)
			//|'2'|','|'5'|'0'|'0'|','|'0'|'0'|'0'|	// char 타입이기에 공백이 들어옴
			}
		}	// end of for------------------
		return String.valueOf(result_arr);
	}	// end of public static String append_comma(long num)----------------------

	// === 주민번호 7자리를 입력받아서 올바른 데이터 인지 검사해주는 메소드 생성 === //
	public static boolean isCheckJubun(String jubun) {
		
		// jubun 의 길이는 7자리 이면서 마지막 7번째 들어오는 문자는 "1" "2" "3" "4" 중에
		// 하나 이어야 한다.
		if(jubun.length() != 7) {
			return false;
		}
		
		else if( !("1".equals(jubun.substring(6)) || "2".equals(jubun.substring(6)) ||
				"3".equals(jubun.substring(6)) || "4".equals(jubun.substring(6)) )) {
			return false;
		}
		else {
			String str_birthday = "";	// 생년월일	(String 타입)
			if("1".equals(jubun.substring(6)) || "2".equals(jubun.substring(6)))
				str_birthday = "19" + jubun.substring(0,6);		// 예 990520 생년월일
			else {
				str_birthday = "20" + jubun.substring(0,6);		// 예 001219 생년월일
			}	
		
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyyMMdd");
		
		sdformat.setLenient(false); 	// 이거 안넣으면 32일도 맞다고 표시된다.
		// false 로 해주어야만 입력한 값을 날짜 타입으로 변경할때 날짜로 되지 못하는 값일 경우 오류가 발생한다.
		// 날짜로 파싱될 때 허술하게 하지 말고 엄격하게 하라고 설정해주는 것이라고 생각하면 된다. 
		
		// === 문자열을 날짜 형태로 변환하기 === //
		try {
			Date birthday = sdformat.parse(str_birthday);		// 스트링타입을 date 타입으로 바꿈
			// Date d = sdformat.parse("19980431");	// 존재 O , setLenient 때문에 가능
			// 현재날짜와 회원의생일날짜를 비교해서 회원의 생일날짜가 현재날짜보다 이후라면 안된다.
			
			Date now = new Date();	// 현재날짜시각
			String str_now = sdformat.format(now);	//20240131	// 문자열에서 시분초빼기
			now = sdformat.parse(str_now);	// 문자열을 date 타입으로 바꿈
			/* 내 방법
			if(birthday.after(now))		// birthday 가 now 보다 미래일 때
				return false;
			else						// birthday 가 now 랑 같거나 과거일 때
				return true;
				// end of if--------
			*/
			// 강사님 방법
			
			if(birthday.compareTo(now) > 0 ) {		// 생년월일이 현재일 보다 미래인 경우
				return false;
			}
			else {		// 생년월일이 현재일 이거나 또는 생년월일이 현재일보다 과거인 경우
				return true;
				
			}	// end of if-----
			
		} catch (ParseException e) {
			return false;
		}	// end of try~catch-------------------------
	}	// end of if-----------------------------
}	// end of public static boolean isCheckJubun(String jubun)----------------------

	// == 입력받은 주민번호(7자리)를 가지고 만나이를 구해주는 메소드 == //
	public static int age(String jubun) {
		Date now = new Date();
		SimpleDateFormat sdfmt = new SimpleDateFormat("yyyyMMdd");
		String str_today = sdfmt.format(now);
		// 세기 파악하기
		String centry = ("1".equals(jubun.substring(6)) || "2".equals(jubun.substring(6)))?"19":"20";
		// 생일 파악하기
		String str_birthday = centry + jubun.substring(0, jubun.length()-1);
		//						"19720910"	"20020320"
		// 올해 생일
		String str_nowYear_birthday = String.format("%tY", now) + jubun.substring(2,jubun.length()-1);
		// 						"2024" + "0910"		"2024" + "0320"
		
		try {
			Date date_today = sdfmt.parse(str_today);
			Date date_nowYear_birthday = sdfmt.parse(str_nowYear_birthday);
			
			int n_nowYear = Integer.parseInt(String.format("%tY", now));
			int n_birthYear = Integer.parseInt(str_birthday.substring(0, 4));
			
			if(date_nowYear_birthday.compareTo(date_today) > 0 ) {
				return n_nowYear - n_birthYear -1;
			} else {
				return n_nowYear - n_birthYear -1;
			}
		} catch(ParseException e) {
			return -1;
		}	// end of try~catch-----------
	}	// end of public static int age(String jubun)-------------------

}	// end of public class MyUtil-----------------
