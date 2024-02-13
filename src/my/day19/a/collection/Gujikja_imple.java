package my.day19.a.collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

	public class Gujikja_imple extends CommonMember implements Gujikja {							// 인터페이스만 해주면 필드가 final 밖에 못들어온다.
		// Company 클래스는 CommonMember 클래스에 생성되어진 field 및 method 및 기본생성자를 상속 받아온다.
		// CommonMember 클래스는 Gujikja 클래스의 부모클래스 가 되어지고,
		// Gujikja 클래스는 CommonMember 클래스의 자식클래스 가 되어진다.
		/*
	    ---------------------------------------------------------------------------------------------------------------------------
	   접근제한자(접근지정자, accessmodifier)   자기자신클래스내부      동일패키지에있는다른클래스      다른패키지에있는하위(자식)클래스       그외의영역  
	   --------------------------------------------------------------------------------------------------------------------------- 
	   public                                    O                    O                         O                        O  
	   protected                                 O                    O                         O                        X
	   없음(default)                              O                    O                         X                        X
	   private                                   O                    X                         X                        X
		 */
	
		// field 생성
		// field 의 캡슐화(EnCapsulation == 은닉화)
		
		private String jubun;         // 주민번호인데 앞자리 6자리에 + 성별을 나타내는 1자리까지만 입력한다. 
										// 예: "9506201"  "9607202"   "0006203"  "0007204"  "1106203" 
		
		public Gujikja_imple() {
			super();			// 부모클래스인 CommonMember 클래스의 기본생성자를 호출한다는 것이다.
			super.setType(1);	// setType 의 1을 구직자로 본다.
		}
		 
	// == 메소드의 오버라이딩(overriding) == (메소드의 재정의) 
	@Override
	public void setName(String name) {
		// 성명은 공백이 없는 한글 또는 영문만 이루어져야 하며 최소 2글자 이상 최대 6글자로만 되어져야 한다.
		// == 1. 정규표현식(Regular Expresiion) 패턴을 작성한다. == //
		Pattern p = Pattern.compile("^[가-힣a-zA-Z]{2,6}$");
		
		// == 2. 문자열이 주어진 정규식 패턴과 일치하는지 판별하는 객체를 생성한다. == //
		Matcher m = p.matcher(name);		// name 를 검색하고자 한다.
		
		// == 3. 판별하도록 한다. == //
		if(m.matches()) {	// boolean 타입으로 나온다.
			super.setName(name);	
		} else {
			System.out.println("[경고] 성명은 공백이 없는 영문 또는 한글로만 이루어져야 하며 최소 2글자 이상 최대 6글자로만 되어져야 한다.\n");
		}	// end of if~else----------			
	}	// end of public void setName(String name)------
	
	// === getter, setter === //
		public void setJubun(String jubun) {
			if(MyUtil.isCheckJubun(jubun)) {
				this.jubun = jubun;
			} else {
				System.out.println("[경고] 주민번호 앞에서 부터 7자리 까지 올바르게 입력하세요!!\n");
			}	// end of if~else--------------------
		}	// end of public void setJubun(String jubun)---------------------
	
		public String getJubun() {
			return jubun;
		}	// end of public String getJubun()--------------

		@Override
		// === 구직자의 만나이를 알려주는 메소드 생성하기 === //
		public int getAge() {
			
			// === 만나이 구하기 === //
			
			int age = 0;
			
			// 구직자의 올해 생일이 현재날짜와 같거나 현재날짜 보다 이전(과거)이라면 
			// 나이 = 현재년도 - 구직자의 태어난년도
			
			// 구직자의 올해 생일이 현재날짜보다 이후(미래)이라면 
			// 나이 = 현재년도 - 구직자의 태어난년도 - 1
			
			Date now = new Date();	// 현재시각
			SimpleDateFormat sdfmt = new SimpleDateFormat("yyyyMMdd");
			String str_now = sdfmt.format(now);	// "20240131"		// 오늘
			
			// 구직자의 올해생일
			String str_now_birthday = str_now.substring(0, 4) + jubun.substring(2, 6);
			// 							"2024"				+ "1020"	==>"20241020"
			
			// 현재년도
			int now_year = Integer.parseInt(str_now.substring(0,4));
			
			// 구직자의 태어난년도
			int centry = ("1".equals(jubun.substring(6))) || ("2".equals(jubun.substring(6)))?1900:2000;	// 년도 뒷자리 2개만 나오기때문에 1900 과 2000 더해주기
			int birth_year = centry + Integer.parseInt(jubun.substring(0, 2));
			
			try {
				now = sdfmt.parse(str_now);		// 오늘의 자정		오늘의 0시0분0초
				// parse : string 타입 -> date 타입
				Date now_birthday = sdfmt.parse(str_now_birthday); 	// 올해생일의 자정 올해생일의 0시0분0초
				
				if(now_birthday.compareTo(now) > 0) {	// 구직자의 올해생일이 현재일 보다 뒤에 있는 경우(미래)
					// 나이 = 현재년도 - 구직자의 태어난년도 - 1
					age = now_year - birth_year - 1;
				} else {	// 구직자의 올해생일이 현재일이거나 현재일 보다 이전에 있는 경우(과거)
					// 나이 = 현재년도 - 구직자의 태어난년도
					age = now_year - birth_year;
				}
			} catch (ParseException e) {
				// try 안 parse 때문에 나왔지만 유효성검사를 미리 했기때문에 넣어진 것이다.
			}	// end of try~catch------------------ 
			return age;
		}	// end of int getAge()---------------
		
		// >> 메소드의 오버라이딩 << //
		
		// === 구직자의 정보를 한줄로 출력해주는 메소드 생성하기 ===
		@Override
		public String getInfo() {
			// eomjh	qWe******  엄정화  961002     여       27      2024-01-31 10:30:40
			
			StringBuilder sb = new StringBuilder();		// 정보 쌓기
			sb.append(super.getId()+"\t");
			
			String str_star = "*".repeat(super.getPasswd().length()-3);	// 비밀번호 앞3자리를 제외한 수
			sb.append(super.getPasswd().substring(0, 3) + str_star +"\t");	// 012 만 보여주기
			/////////////////////////////////////////////////////////////////////// 표시제한 없이 도출
			sb.append(super.getName()+"\t");
			
			sb.append(jubun.substring(0, 6)+"\t");
			// sb.append(jubun.substring(0,jubun.length()-1) + "\t);
			
			// 성별구하기 //
			if("1".equals(jubun.substring(6)) || "3".equals(jubun.substring(6)))	// 지막 인덱스는 길이 -1 => jubun.length()-1
				sb.append("남" + "\t");
			else{
				sb.append("여" +"\t");	
			}
			
			// === 만나이 구하기 === //
			
			int age = 0;
			
			// 구직자의 올해 생일이 현재날짜와 같거나 현재날짜 보다 이전(과거)이라면 
			// 나이 = 현재년도 - 구직자의 태어난년도
			
			// 구직자의 올해 생일이 현재날짜보다 이후(미래)이라면 
			// 나이 = 현재년도 - 구직자의 태어난년도 - 1
			
			Date now = new Date();	// 현재시각
			SimpleDateFormat sdfmt = new SimpleDateFormat("yyyyMMdd");
			String str_now = sdfmt.format(now);	// "20240131"		// 오늘
			
			// 구직자의 올해생일
			String str_now_birthday = str_now.substring(0, 4) + jubun.substring(2, 6);
			// 							"2024"				+ "1020"	==>"20241020"
			
			// 현재년도
			int now_year = Integer.parseInt(str_now.substring(0,4));
			
			// 구직자의 태어난년도
			int centry = ("1".equals(jubun.substring(6))) || ("2".equals(jubun.substring(6)))?1900:2000;	// 년도 뒷자리 2개만 나오기때문에 1900 과 2000 더해주기
			int birth_year = centry + Integer.parseInt(jubun.substring(0, 2));
			
			try {
				now = sdfmt.parse(str_now);		// 오늘의 자정		오늘의 0시0분0초
				// parse : string 타입 -> date 타입
				Date now_birthday = sdfmt.parse(str_now_birthday); 	// 올해생일의 자정 올해생일의 0시0분0초
				
				if(now_birthday.compareTo(now) > 0) {	// 구직자의 올해생일이 현재일 보다 뒤에 있는 경우(미래)
					// 나이 = 현재년도 - 구직자의 태어난년도 - 1
					age = now_year - birth_year - 1;
				} else {	// 구직자의 올해생일이 현재일이거나 현재일 보다 이전에 있는 경우(과거)
					// 나이 = 현재년도 - 구직자의 태어난년도
					age = now_year - birth_year;
				}	// end of if~else-----------------------
			} catch (ParseException e) {
				// try 안 parse 때문에 나왔지만 유효성검사를 미리 했기때문에 넣어진 것이다.
			}	// end of try~catch----------------------- 
			sb.append(age + "\t");
			// age 에 빨간줄이 뜨면 getAge() 로 바꾸기
			sb.append(super.getRegister_day().substring(0,11));
			
			return sb.toString();
		}	// end of public String getInfo()--------------------

		// === 성별을 구해주는 메소드 === //
		@Override
		public String getGender() {
		 //	 StringBuilder sb = new StringBuilder();		// 사용안함 띠용???
			// 성별구하기 //
				if("1".equals(jubun.substring(6)) || "3".equals(jubun.substring(6)))	// 지막 인덱스는 길이 -1 => jubun.length()-1
					return "남";
				else
					return "여";		
		}	// end of String getGendr()--------------------------
		 
		////////////////////////////////////////////////////////////////////////////////
		/*
		// == 메소드의 오버라이딩 == //
		@Override
		public String getInfo() {
			return "" +	jubun + getAge() + getGender();	// 기존에 있던 아이디와 비밀번호 제외함.
		}
		*/
		 //////////////////////////////////////////////////////////////////////////
		 void test() {
			 System.out.println(super.parent_test()); 
			 // 또는
			 System.out.println(this.parent_test());
			 // 또는
			 System.out.println(parent_test());	 		// source 분석 시 헷갈려서 super.을 붙이는 것을 권장한다.
		 }

}
