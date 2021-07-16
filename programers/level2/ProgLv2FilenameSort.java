package level2;

import java.util.Arrays;
import java.util.Comparator;


public class ProgLv2FilenameSort {


	static class MyComparator implements Comparator<String>{

		@Override
		public int compare(String arg0, String arg1) {
					
			int a = headEndIndex(arg0);
			int b = headEndIndex(arg1);
			String aHead = arg0.toLowerCase().substring(0, a);
			String bHead = arg1.toLowerCase().substring(0, b);
					
			//head
			if(aHead.compareTo(bHead) > 0) {
				return 1;
			} else if(aHead.compareTo(bHead) < 0) {
				return -1;
			} else {
				//number
				String aEtc = arg0.substring(a, arg0.length());
				String bEtc = arg1.substring(b, arg1.length());

				int aNumber = Integer.parseInt(aEtc.substring(0, numEndIndex(aEtc)));
				int bNumber = Integer.parseInt(bEtc.substring(0, numEndIndex(bEtc)));

				if(aNumber > bNumber) {
					return 1;
				}else if(aNumber < bNumber){
					return -1;
				}else {
					return 0;
				}
			}
				
		}
		
		public int headEndIndex(String arg) {
			int headEndIndex = 0;
			for(int i=0;i<arg.length(); i++) {
				if(arg.charAt(i)>='0' && arg.charAt(i)<='9') {
					headEndIndex = i;
					break;
				}			
			}	
			if(headEndIndex == 0) return arg.length();
			return headEndIndex;
		}
		
		public int numEndIndex(String arg) {
			int numEndIndex = 0;
			for(int i=0;i<arg.length(); i++) {
				if(!(arg.charAt(i)>='0' && arg.charAt(i)<='9')) {
					numEndIndex = i;
					break;
				}			
			}
			if(numEndIndex == 0) return arg.length();
			return numEndIndex;
		}
		
	}
	
	public static void main(String[] args) {
		String[] files = {"img000012345", "img1.png","img2","IMG02"};
		MyComparator myComparator = new MyComparator();
	
		Arrays.sort(files,myComparator);
		
		
		
	}

}
