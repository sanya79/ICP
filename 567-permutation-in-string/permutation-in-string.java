import java.util.Arrays;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) return false;
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);
        for (int i = 0; i <= m - n; i++) {
            String sub = s2.substring(i, i + n);
            char[] subArr = sub.toCharArray();
            Arrays.sort(subArr);
            if (sortedS1.equals(new String(subArr))) {
                return true;
            }
        }
        return false;
    }
}
