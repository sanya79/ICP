import java.util.*;
public class Dreamoon_and_Wifi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().trim();
        String s2 = sc.nextLine().trim();
        sc.close();
        int target = 0;
        for (char c : s1.toCharArray()) {
            if (c == '+') target++;
            else target--;
        }
        int known = 0;
        int q = 0;
        for (char c : s2.toCharArray()) {
            if (c == '+') known++;
            else if (c == '-') known--;
            else q++;
        }
        int diff = target - known;
        if (Math.abs(diff) > q || ((q + diff) % 2 != 0)) {
            System.out.printf("%.12f\n", 0.0);
            return;
        }
        int pluses = (q + diff) / 2; 
        if (pluses < 0 || pluses > q) {
            System.out.printf("%.12f\n", 0.0);
            return;
        }
        double ways = binomial(q, pluses);
        double total = Math.pow(2, q);
        double prob = ways / total;

        System.out.printf("%.12f\n", prob);
    }
    private static double binomial(int n, int k) {
        if (k < 0 || k > n) return 0;
        k = Math.min(k, n - k);
        double res = 1.0;
        for (int i = 1; i <= k; i++) {
            res = res * (n - k + i) / i;
        }
        return res;
    }
}
