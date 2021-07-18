package level2;

public class ProgLv2JadenCase {

	public static void main(String[] args) {
		String answer = "";
        String s = "3c  ss  ";
		//s+="1";
        
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }
        

	}

}
