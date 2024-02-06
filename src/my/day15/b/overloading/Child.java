package my.day15.b.overloading;

public class Child extends Parent{
	
	// field
	String name;
	
	// 메소드의 오버라이딩(overriding) == 메소드의 재정의
	// 메소드의 오버라이딩(overriding) 시 접근제한자는 부모클래스에서 정의해둔 메소드의 접근제한자와 같거나 또는 허용이 더 큰 것을 해야 한다.
	// 또한 메소드의 오버라이딩(overriding) 시 껍데기(리턴타입 메소드명 파라미터)는 똑같아야 한다. (껍데기 = 큰틀)
	// 알맹이(내용물)는 새롭게 정의해서 만들면 된다.
	
	@Override	// @ 를 애노테이션(어노테이션) 이라고 부른다.
	protected String info() {							// 부모의 메소드가 protected 일 경우
		return "아이디 : " + super.id + "\n"				// protected 나 public 가능
				+ "비밀번호 : " + super.passwd;			// 접근제한자가 부모보다 자식 클래스가 커야 한다.
	}	// end of protected String info()
	
	// === 메소드의 오버로딩(overloading) === //
	// ==> 메소드의 이름은 같지만 파라미터가 다르면 동일한 메소드로 취급하지 않는다.
	// ==> 접근제한자 및 리턴타입은 메소드의 오버로딩에 관여하지 않는다.
	
	public void info(int n) {							// 같은 이름을 쓰고 싶을 때 파라미터 추가하여 작성하는 것 => 메소드의 overloading
		System.out.println();
	}	// end of public void info()
	
	public void info(short m) {							// 같은 이름을 쓰고 싶을 때 파라미터의 타입을 다르게하여 작성하는 것 => 메소드의 overloading
		
	}	// end of public void info()
	
	public void info(int a, String str) {				// 같은 이름을 쓰고 싶을 때 파라미터 추가하여 작성하는 것 => 메소드의 overloading
		
	}	// end of public void info()

	public void info(String str, int a) {				// 같은 이름을 쓰고 싶을 때 파라미터의 타입과 개수를 동일하게 사용하고 싶을때
														// 파라미터의 위치를 바꾸어 작성해준다. => 메소드의 overloading
	}	// end of public void info()

	
	public String info(String str, int a, byte d) {				// 메소드의 타입을 달리줘도 중복으로 본다.
		return "";												// 같은 이름을 쓰고 싶을 때 파라미터 추가하여 작성
	}	// end of public void info()
	
	public void info(String str, byte d, int a) {				// 접근제한자도 다르고, 리턴타입도 다르지만 중복으로 본다.
		return;													// 이 경우, 파라미터를 추가하여 작성하거나 위치를 다르게 해주어야 한다.
	}	// end of public void info
	
// ========================================================================================================================================
	
	// === 생성자의 오버로딩(overloading) === //
	public Child() {
		
	}
	
	public Child(String id, String passwd){
		super.id = id;
		this.passwd = passwd;					// this 와 super 모두 사용 가능
	}
	
	public Child(String id, String passwd, String name){
		this(id,passwd);		// ==> public Child(String id, String passwd) 생성자
		this.name = name;
	}
	
	/*
	// 오류 => 생성자 내에서 다른 생성자를 쓸 때, 생성자가 아닌 다른 것을 먼저 쓰면 오류가 난다.
	// 		Ex)다른 생성자 : this(id,passwd);
	public Child(String id, String passwd, String name){
		this.name = name;
		this(id,passwd);		// ==> 생성자가 먼저 위치하지 않았으므로 오류발생 !!
								// public Child(String id, String passwd) 생성자
	}
	*/
}
