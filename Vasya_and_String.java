import java.util.*;
public class Vasya_and_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        sc.close();
        System.out.println(Math.max(maxLength(s, n, k, 'a'), maxLength(s, n, k, 'b')));
    }
    private static int maxLength(String s, int n, int k, char targetChar) {
        int left = 0, right = 0, maxLen = 0, diffCount = 0;
        while (right < n) {
            if (s.charAt(right) != targetChar)
                diffCount++;
            while (diffCount > k) {
                if (s.charAt(left) != targetChar)
                    diffCount--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
