package level2;

import java.util.ArrayList;

public class ProgLv2MaxExpress {

	public static void main(String[] args) {
		
		long answer = 0;
		long temp = 0;
		
		ArrayList<String> strArr = new ArrayList<String>();
		ArrayList<String> strArrTemp = new ArrayList<String>();
		
		String expression = "50*6-3*2";
		int z =0;
		
		while(true) {
			if(expression.length() <= z) break;
			char c = expression.charAt(z);
			if(c=='-'||c=='*'||c=='+') {
				strArr.add(expression.substring(0,z));
				strArr.add(expression.substring(z,z+1));
				expression = expression.substring(z+1,expression.length());
				z=0;
				continue;
			}
			z++;
		}
		strArr.add(expression);
		
		String[] op = {"*+-","*-+","+*-","+-*","-*+","-+*"};
		
		for(int i=0; i<op.length; i++) {
			for(int k=0; k<strArr.size(); k++) {
				strArrTemp.add(k,strArr.get(k));
			}	  
		  
		  temp = work(strArrTemp, op[i]);
		  if(temp > answer)
			  answer = temp;
		}
		
        System.out.println(answer);

	}

	private static long work(ArrayList<String> strArrTemp, String op) {
		
		for(int i=0; i<op.length(); i++) {
			String x = String.valueOf(op.charAt(i));
			int z = 0;
			while(true) {
				if(strArrTemp.size() <= z) break;
				if(x.equals(strArrTemp.get(z))) {
					long n1 = (long) Long.parseLong(strArrTemp.get(z-1)); 
					long n2 = (long) Long.parseLong(strArrTemp.get(z+1)); 
					strArrTemp.remove(z-1);
					strArrTemp.remove(z-1);
					strArrTemp.remove(z-1);
					
					long n3 = 0;
					
					if(x.equals("*"))	n3 = n1*n2;
					else if(x.equals("+")) n3 = n1+n2;
					else if(x.equals("-")) n3 = n1-n2;
					
					strArrTemp.add(z-1, String.valueOf(n3));
					continue;
				}
				
				z++;
			}	
		}

		return Math.abs(Long.parseLong(strArrTemp.get(0)));
	}

}
