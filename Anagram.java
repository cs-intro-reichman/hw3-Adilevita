/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
			System.out.println(isAnagram("silent","listen"));  
			System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); 
			System.out.println(isAnagram("Madam Curie","Radium came")); 
			System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); 

			System.out.println(preProcess("What? No way!!!"));
			
			System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
			
			String str = "1234567";
			Boolean pass = true;

			for (int i = 0; i < 10; i++) {
					String randomAnagram = randomAnagram(str);
					System.out.println(randomAnagram);
					pass = pass && isAnagram(str, randomAnagram);
					if (!pass) break;
			}
			System.out.println(pass ? "test passed" : "test Failed");
	}  
	
	
	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
			String s1 = preProcess(str1);
			String s2 = preProcess(str2);

			if (s1.length() != s2.length()) {
					return false;
			}

			for (int i = 0; i < s1.length(); i++) {
					char c = s1.charAt(i);
					boolean found = false;

					for (int j = 0; j < s2.length(); j++) {
							if (s2.charAt(j) == c) {
									s2 = removeCharAt(s2, j);
									found = true;
									break;
							}
					}

					if (!found) {
							return false;
					}
			}

			return true;
	}
	
	
	// Preprocesses the string: keeps only lowercase letters and digits.
	public static String preProcess(String str) {
			String result = "";

			for (int i = 0; i < str.length(); i++) {
					char c = str.charAt(i);
					c = Character.toLowerCase(c);

					if (Character.isLetter(c) || Character.isDigit(c)) {
							result = result + c;
					}
			}

			return result;
	} 
	
	
	// Returns a random anagram of the given string.
	public static String randomAnagram(String str) {
			String source = str;
			String result = "";

			while (source.length() > 0) {
					int index = (int)(Math.random() * source.length());
					char c = source.charAt(index);

					result = result + c;
					source = removeCharAt(source, index);
			}

			return result;
	}

	
	public static String removeCharAt(String s, int index) {
			return s.substring(0, index) + s.substring(index + 1);
	}
}
