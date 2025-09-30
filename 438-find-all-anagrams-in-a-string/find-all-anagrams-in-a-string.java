import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (n < m) return result;
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        String sortedP = new String(pArr);
        for (int i = 0; i <= n - m; i++) {
            String sub = s.substring(i, i + m);
            char[] subArr = sub.toCharArray();
            Arrays.sort(subArr);
            if (sortedP.equals(new String(subArr))) {
                result.add(i);
            }
        }
        return result;
    }
}
