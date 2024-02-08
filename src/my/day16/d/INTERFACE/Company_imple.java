package my.day16.d.INTERFACE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Company_imple extends CommonMember implements Company {							
	// Company 클래스는 CommonMember 클래스에 생성되어진 field 및 method 및 기본생성자를 상속 받아온다.
	// CommonMember 클래스는 Company 클래스의 부모클래스 가 되어지고,
	// Company 클래스는 CommonMember 클래스의 자식클래스 가 되어진다.
	
		// field 생성
		// field 의 캡슐화(EnCapsulation == 은닉화)
		
		private String business_number;   // 사업자등록번호
		private String job_type;          // 회사직종타입(제조업, 서비스업, IT, ...)
		private long seed_money;          // 자본금 

		// 기본생성자 생략됨!!
		/*
		public Company() {
			super();	// Company 클래스의 부모클래스인 CommonMemver 클래스의 기본생성자이다.
		}
		*/
		
		public Company_imple() {
			super();			// 부모클래스인 CommonMember 클래스의 기본생성자를 호출한다는 것이다.	// 자동적으로 생략되어진것이다.
			super.setType(2);	// setType 의 2을 회사로 본다.
		}
		
		private String name;
		
		// == 메소드의 오버라이딩(overriding) == (메소드의 재정의) 
		// 내방법
		@Override
		public void setName(String name) {
			// 회사명은 공백이 없는 한글 또는 영문만 이루어져야 하며 최소 2글자 이상 최대 10글자로만 되어져야 한다.
			// == 1. 정규표현식(Regular Expresiion) 패턴을 작성한다. == //
			Pattern p = Pattern.compile("^[가-힣a-zA-Z]{2,10}$");
			
			// == 2. 문자열이 주어진 정규식 패턴과 일치하는지 판별하는 객체를 생성한다. == //
			Matcher m = p.matcher(name);		// name 를 검색하고자 한다.
			
			// == 3. 판별하도록 한다. == //
			if(m.matches()) {	// boolean 타입으로 나온다.
				this.name = name;	
			} else {
				System.out.println("[경고] 회사명은 공백이 없는 한글로만 이루어져야 하며 최소 2글자 이상 최대 10글자로만 되어져야 한다.\n");
			}	// end of if~else----------			
		}	// end of public void setName(String name)------
		
		public String getName() {
			return name;
		}	// end of public String getName()--------------------
		
		/*
		// == 메소드의 오버라이딩(overriding) == (메소드의 재정의) 
		// 강사님 방법
		@Override
		public void setName(String name) {
			// 회사명은 공백이 없는 한글 또는 영문만 이루어져야 하며 최소 2글자 이상 최대 10글자로만 되어져야 한다.
			// == 1. 정규표현식(Regular Expresiion) 패턴을 작성한다. == //
			Pattern p = Pattern.compile("^[가-힣a-zA-Z]{2,10}$");
			
			// == 2. 문자열이 주어진 정규식 패턴과 일치하는지 판별하는 객체를 생성한다. == //
			Matcher m = p.matcher(name);		// name 를 검색하고자 한다.
			
			// == 3. 판별하도록 한다. == //
			if(m.matches()) {	// boolean 타입으로 나온다.
				super.setName(name);	
			} else {
				System.out.println("[경고] 회사명은 공백이 없는 한글로만 이루어져야 하며 최소 2글자 이상 최대 10글자로만 되어져야 한다.\n");
			}	// end of if~else----------			
		}	// end of public void setName(String name)------
		 */
		public String getBusiness_number() {
			return business_number;
		}	// end of public String getBusiness_number()-----------

		public void setBusiness_number(String business_number) {
			
			// 사업자등록번호는 오로지 숫자로만 들어와야 하며
			// 첫글자는 0이 들어올 수 없다.
			// 또한 사업자 등록번호의 길이는 10글자가 되어야 한다.
			
			// == 1. 정규표현식(Regular Expresiion) 패턴을 작성한다. == //
			Pattern p = Pattern.compile("^[1-9][0-9]{9}$");
			// ^ 은 시작을 의미한다.
			// $ 는 끝을 의미한다.
			// [] 는 글자 1개가 들어오는 것을 의미한다.
			// [1-9] 는 글자 1개가 들어오는데 1 부터 9 만 가능하다.				
			// [0-9]{9} 는 글자 1개가 들어오는데 숫자인 0 부터 9만 가능하다. 이러한 숫자의 개수가 9번 들어와야 한다.
			
			// == 2. 문자열이 주어진 정규식 패턴과 일치하는지 판별하는 객체를 생성한다. == //
			Matcher m = p.matcher(business_number);
			
			// == 3. 판별하도록 한다. == //
			if(m.matches()) {	// boolean 타입으로 나온다.
				this.business_number = business_number;	
			} else {
				System.out.println("[경고] 사업자등록번호는 10글자이며, 오로지 숫자로만 들어와야 합니다.\n"
								+ "또한 첫글자는 0이 들어올 수 없습니다.\n");
			}	// end of if~else----------			
		}	// end of public void setBusiness_number(String business_number)------------

		public String getJob_type() {
			return job_type;
		}	// end of public String getJob_type()--------------

		public void setJob_type(String job_type) {
			if((job_type == null || job_type.isBlank())) {
				System.out.println("[경고] 회사직종군은 공백이 아닌 글자로 입력하셔야 합니다.\n");
			} else {	// 공백이 아니면
				this.job_type = job_type;
			}	// end of if~else-----
		}	// end of public void setJob_type(String job_type)-----------

		public long getSeed_money() {
			return seed_money;
		}	// end of public long getSeed_money()--------

		public void setSeed_money(long seed_money) {
			if(!(seed_money >= 0)) {
				System.out.println("[경고] 자본금은 0 보다 커야 합니다.\n");
			} else {	// 0 보다 클 경우
			this.seed_money = seed_money;	
			}
		}	// end of public void setSeed_money(long seed_money)------------------
		
		// >> 메소드의 오버라이딩 << //
		// === 회사의 정보를 한줄로 출력해주는 메소드 생성하기 ===
		@Override
		public String getInfo() {
			// 회사명
			StringBuilder sb = new StringBuilder();		// 정보 쌓기

			sb.append(super.getName() + "\t");	// 회사명
			sb.append(getJob_type() + "\t");	// 업종
			sb.append(getBusiness_number() + "\t");	// 사업자등록번호
			sb.append(getSeed_money() + "\t");		// 자본금
			sb.append(getRegister_day().substring(0,10) + "\t");	// 가입일자
			
			return sb.toString();
		}	// end of String getInfo()
	/*
		// == 메소드의 오버라이딩 == //
		@Override
		public String getInfo() {
			return "" + job_type + seed_money;	// 기존에 있던 아이디와 비밀번호 제외함.
		}
	*/

}	// end of Company---------------------------
