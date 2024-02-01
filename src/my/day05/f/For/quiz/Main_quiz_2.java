package my.day05.f.For.quiz;

public class Main_quiz_2 {

	public static void main(String[] args) {
		
		// for 문을 사용하여 알파벳 소문자를 아래처럼 출력하세요.
		// a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
		
		String result = "";		// 문자열 누적용
		/*
		String eng = "abcdefghijklmnopqrstuvwxyz";
		
		for(char i=0;i<eng.length();i++) {
			
			String add = (i + 1) < eng.length()?",":"";
			
			result += eng.charAt(i) + add;
		*/
		
		for(int i=0; i <'z'-'a'+1;i++) {
			char ch = (char)('a'+i);	// (char)(97+0) ==> a
										// (char)(98+1) ==> b
										// (char)(99+1) ==> c
			/*
			String add = "";
			if(i <'z'-'a')
				add = ",";
			*/
			// 또는
			String add = (i<'z'-'a')?",":"";
			result += ch+add;
		}	// end of for------------------
		
		System.out.println(result);
		// a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// for 문을 사용하여 알파벳 소문자를 아래처럼 출력하세요.
		/*
			a,b,c,d,e,f,g,h,i,j,k,l,m
			n,o,p,q,r,s,t,u,v,w,x,y,z
		 */
		
		result = "";		// 문자열 누적용
		
		for(int i = 0; i < 'z'-'a'+1;i++) {
			char ch = (char)('a'+ i);
			String add = "";
				
					if(i<'z'-'n')
						add = ",";
					else if(i == 'z'-'n')
						add = "\n";
					else if(i == 'z'-'a')
						add = "";
					else
						add = ",";
				
			result += ch + add;	
		}
		
		System.out.println(result);
		
		
		System.out.println("강사님");
		
		for(int i = 0; i < 'z'-'a'+1; i++) {
			char ch =(char)('a'+i);
			/*
			String add ="";
			if(ch == 'm' || ch == 'z')
				add ="\n";
			else
				add = ",";
			*/
			// 또는
			String add = (ch == 'm' || ch == 'z')?"\n":",";
					result += ch+add;
		}	// end of for-------------------
		
		System.out.println(result);
	}

}
