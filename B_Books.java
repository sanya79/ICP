import java.util.*;

public class B_Books{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long t = sc.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        int left = 0;
        long currentTime = 0;
        int maxBooks = 0;

        for (int right = 0; right < n; right++) {
            currentTime += a[right];

            while (currentTime > t) {
                currentTime -= a[left];
                left++;
            }

            maxBooks = Math.max(maxBooks, right - left + 1);
        }

        System.out.println(maxBooks);
    }
}
