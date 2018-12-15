
public class Challenge2 {
	public static String solution(String S) {
        // write your code in Java SE 8
		char[] s = S.replaceAll("\\D", "").toCharArray();
		
		int j = 1;
		String ans = Character.toString(s[0]);
		
		for(int i=1;i<s.length;i++) {
			if(j == 2 && s.length - i == 2) {
				ans += "-";
				ans += s[i];
				j = 1;
			}else {
				if(j<3) {
					ans += s[i];
					j++;
				}else {
					ans += "-";
					ans += s[i];
					j = 1;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		String a = "00-44  48 5555 8361";
		String b = "0 - 22 1985--324";
		String c = "555372654";
		
		a = solution(a);
		b = solution(b);
		c = solution(c);
		
	
	}
	
}
