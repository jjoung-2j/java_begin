package my.day18.a.collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import my.util.MyUtil;

public class Member {
	
	private String id;
	private String passwd;
	private String name;
	private String jubun;
	
	// 기본생성자
	public Member() {}		// main_1을 위해 생성
	
	public Member(String id, String passwd, String name, String jubun) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.jubun = jubun;
	}

	// === getter, setter === //
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJubun() {
		return jubun;
	}

	public void setJubun(String jubun) {
		this.jubun = jubun;
	}

	/*	
	private String gender;
	
	public String getGender() {
		if(Integer.valueOf(jubun.substring(6)) == 1 || Integer.valueOf(jubun.substring(6)) == 3)
			return "남";
		else
			return "여";
	}

	public void setGender(String gender) {
		if(MyUtil.isCheckJubun(jubun)) {
				this.jubun = jubun;
		this.gender = gender;
		else
			System.out.println("[경고] 주민번호 앞에서 부터 7자리 까지 올바르게 입력하세요!!\n");
	}
	 */
	
	public int age() {
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
	}	// end of public int age()-----------------

//비교하기 (오류)
/*
	private int age;
	
	public int age() {
		Date now = new Date();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyyMMdd");
		String now_str = sdformat.format(now);		// 오늘을 보기 쉬운 타입으로 변환하기
		
		// 세기파악하기 (19,20)
		String centry = ("1".equals(jubun.substring(6)) || "2".equals(jubun.substring(6)))?"19":"20";
		
		// 생년 ( Ex. 19990520 )
		String birth = centry+ jubun;
		
		try {
			// 올해 생일
			Date year_birth; // ( Ex. 0520 )
			year_birth = sdformat.parse(birth.substring(4));	// Date 타입으로 변환

			// 이번년도 파악하기	( Ex. 1999 )
			String now_year = now_str.substring(0, 4);
			
			// 오늘 날짜 Date 타입으로 바꾸기 (Ex. 0520)
			Date now_day;
			now_day = sdformat.parse(now_str.substring(4));
		
			// 올해 생일이 오늘 이후라면
			if(year_birth.after(now_day)) {
				return Integer.parseInt(now_year) - Integer.parseInt(birth.substring(0, 4)) -1;
			} else {
				return Integer.parseInt(now_year) - Integer.parseInt(birth.substring(0, 4));
			}
		} catch (ParseException e) {	// 주민번호 가 올바르게 입력되지 않은 경우(실제 날짜에 없는 경우)
			return -1;
		}
	}
*/
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	public void getInfo() {
		System.out.println("=== " + name + "님의 회원정보 ===\n"
				+ "1. 아이디 : " + getId() + "\n"
				+ "2. 비밀번호 : " + getPasswd() + "\n"
				+ "3. 성명 : " + getName() + "\n"
				+ "4. 주민번호 : " + getJubun() + "\n"
				+ "5. 성별 : " + getGender() +"\n");
	}	// end of public void getInfo()------------
	*/
	// 또는
	
	public String gender() {
		if(jubun == null)
			return "";
		else {
			if("1".equals(jubun.substring(6))
				|| "3".equals(jubun.substring(6))	)
			return "남";
			else
				return "여";
		}
	}	// end of gender()-------------
	
	// 메소드의 오버라이딩(재정의)
/*
	public String toString() {
		return "=== " + name + "님의 회원정보 ===\n"
				+ "1. 아이디 : " + id + "\n"
				+ "2. 비밀번호 : " + passwd + "\n"
				+ "3. 성명 : " + name + "\n"
				+ "4. 주민번호 : " + jubun + "\n"
				+ "5. 성별 : " + gender() +"\n"
		 		+ "6. 만나이 : " + age() + "세\n";
	}	// end of public String toString()---------------
*/
	
	public String toString() {
		return "=== " + name + "님의 회원정보 ===\n"
				+ "1. 아이디 : " + id + "\n"
				+ "2. 비밀번호 : " + passwd + "\n"
				+ "3. 성명 : " + name + "\n"
				+ "4. 주민번호 : " + jubun + "\n"
				+ "5. 성별 : " + gender() +"\n"
		 		+ "6. 만나이 : " + MyUtil.age(jubun) + "세\n";
	}	// end of public String toString()---------------
	
}
