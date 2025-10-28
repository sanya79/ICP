import java.util.*;
public class Nastya_and_Rice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            int minTotal = n * (a - b);
            int maxTotal = n * (a + b);
            int minPack = c - d;
            int maxPack = c + d;

            if (maxTotal < minPack || minTotal > maxPack)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
        sc.close();
    }
}
