package level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ProgLv2PhoneBook {
	
	public static class Solution {

        public boolean solution(String[] phone_book) {
            Set<String> set = new HashSet<>();
            Arrays.sort(phone_book, Comparator.comparingInt(str -> ((String) str).length()));
            int minLength = phone_book[phone_book.length - 1].length();

            for (String number : phone_book) {
                if (set.contains(number)) {
                    return false;
                }

                for (int i = minLength; i <= number.length(); i++) {
                    set.add(number.substring(0, i));
                }
            }

            return true;
        }

    }
	
	public static void main(String[] args) {
		boolean answer = true;
		String[] phone_book = {"12","25","26","15","88"};
		Solution solution = new Solution();
		
		System.out.println(solution.solution(phone_book));

		
	}

}
