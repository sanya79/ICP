class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String longest = "";

        //odd

		for(int axis=0;axis<s.length();axis++) {
			for(int orbit=0;axis-orbit>=0 && axis+orbit<s.length();orbit++) {
				if(s.charAt(axis-orbit) != s.charAt(axis+orbit)) {
					break;
				}
				String palindrome = s.substring(axis - orbit, axis + orbit + 1);
                if (palindrome.length() > longest.length()) {
                    longest = palindrome;
                }
			}
		}
        //even

		for(double axis=0.5;axis<s.length();axis++) {
			for(double orbit=0.5;axis-orbit>=0 && axis+orbit<s.length();orbit++) {
				if(s.charAt((int) (axis-orbit)) != s.charAt((int) (axis+orbit))) {
					break;
				}
				String palindrome = s.substring((int) (axis - orbit), (int) (axis + orbit) + 1);
                if (palindrome.length() > longest.length()) {
                    longest = palindrome;
                }
			}
		}
        return longest;
        
    }
}